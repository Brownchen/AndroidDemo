package edu.whut.chenmin.job3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by brown on 2016/11/29.
 */

public class LyricActivity extends AppCompatActivity {
    String result="";
    String imageurl="";
    String aid="";
    LyricListBean my_lyricList;
    public  TextView lyricText;
    public static final int UPDATE_TEXT = 1;
    private Handler handler = new Handler(){

        public void handleMessage(Message message){
            switch (message.what){
                case UPDATE_TEXT:
                    String string=(String)message.obj;
                    lyricText.setText(string);
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyric);
        Bundle bundle = this.getIntent().getExtras();
        final String Title = bundle.getString("title");
        String singer = bundle.getString("text");
        TextView title2=(TextView)findViewById(R.id.title2);
        TextView text2=(TextView)findViewById(R.id.text2);
        lyricText = (TextView) findViewById(R.id.lyrics_list);
        title2.setText(Title);
        text2.setText(singer);
        Log.e("MZC", "hhh");
        new Thread(new Runnable() {
            @Override
            public void run() {
                //String song_name="";
                String path ="http://gecimi.com/api/lyric/";
                try {
                    //song_name = URLEncoder.encode(Title,"UTF-8");
                    URL url = new URL(path + Title);
                    Log.e("MZC", path + Title);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestMethod("GET");
                    //conn.setReadTimeout(5000);// 设置超时的时间
                    //conn.setConnectTimeout(5000);// 设置链接超时的时间
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    if (conn.getResponseCode() == 200) {
                        // 获取响应的输入流对象
                        InputStream is = conn.getInputStream();

                        // 创建字节输出流对象
                        ByteArrayOutputStream os = new ByteArrayOutputStream();
                        // 定义读取的长度
                        int len = 0;
                        // 定义缓冲区
                        byte buffer[] = new byte[1024];
                        // 按照缓冲区的大小，循环读取
                        while ((len = is.read(buffer)) != -1) {
                            // 根据读取的长度写入到os对象中
                            os.write(buffer, 0, len);
                        }
                        // 释放资源
                        is.close();
                        os.close();
                        // 返回字符串
                        result = new String(os.toByteArray());
                        Log.e("MZC", result);
                        my_lyricList=new GsonBuilder().create().fromJson(result,LyricListBean.class);
                        if(my_lyricList.getResult().size()!=0){
                            for (LyricListBean.ResultBean tmp:my_lyricList.getResult()) {
                                result = result + tmp.getLrc() + "\n";
                           }
                            Log.e("MZC", "\n"+result);
                            Message message = new Message();
                            message.what = UPDATE_TEXT;
                            message.obj = result;
                            handler.sendMessage(message);
                        }else{
                        result="未找到匹配歌词";
                            Log.e("MZC", result);
                        }


                    } else {
                        System.out.println("------------------链接失败-----------------");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                //Toast.makeText(MainActivity.this, "hah", Toast.LENGTH_SHORT).show();
////                LoadDialog.dismiss(LyricActivity.this);
//                lyricText.setText(result);
////                lyricText.setText("歌词在哪里");
//            }
//        });
    }
}
