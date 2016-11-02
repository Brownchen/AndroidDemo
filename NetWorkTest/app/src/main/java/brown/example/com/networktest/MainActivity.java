package brown.example.com.networktest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int SHOW_REQUEST = 0;

    private Button sendRequest;

    private TextView responseText;

    private Handler handler = new Handler(){

        public void handleMessage(Message msg)  {
            switch (msg.what)   {
                case SHOW_REQUEST:
                    String response = (String) msg.obj;
                    responseText.setText(response);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendRequest = (Button)findViewById(R.id.send_request);
        responseText = (TextView)findViewById(R.id.request_text);
        sendRequest.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v.getId() == R.id.send_request){
            sendRequestWithHttpURLConnection();
        }
    }

    private void sendRequestWithHttpURLConnection(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL("http://www.baidu.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    Message msg = new Message();
                    msg.what = SHOW_REQUEST;
                    msg.obj = response.toString();
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
}
