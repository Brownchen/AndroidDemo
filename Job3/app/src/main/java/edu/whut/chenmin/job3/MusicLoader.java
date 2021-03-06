package edu.whut.chenmin.job3;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brown on 2016/11/28.
 */

public class MusicLoader {



        private static final String TAG = "com.example.nature.MusicLoader";

        public static List<MusicInfo> musicList = new ArrayList<MusicInfo>();

        private static MusicLoader musicLoader;

        private static ContentResolver contentResolver;
        //Uri，指向external的database
        private Uri contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        //projection：选择的列; where：过滤条件; sortOrder：排序。
        private String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.SIZE
        };
        private String where =  "mime_type in ('audio/mpeg','audio/x-ms-wma')  and is_music > 0 " ;
        private String sortOrder = MediaStore.Audio.Media.DATA;

        public static MusicLoader instance(ContentResolver pContentResolver){
            if(musicLoader == null){
                contentResolver = pContentResolver;
                musicLoader = new MusicLoader();
            }
            return musicLoader;
        }

        @SuppressLint("LongLogTag")
        private MusicLoader(){		                                                                                                       //利用ContentResolver的query函数来查询数据，然后将得到的结果放到MusicInfo对象中，最后放到数组中
            Cursor cursor = contentResolver.query(contentUri, null, null, null, null);
            if(cursor == null){
                Log.v(TAG,"cursor == null.");
            }else if(!cursor.moveToFirst()){
                Log.v(TAG,"moveToFirst()->false.");
            }else{
                int displayNameCol = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
                Log.e("GG", displayNameCol + "");
                int albumCol = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
                int idCol = cursor.getColumnIndex(MediaStore.Audio.Media._ID);
                int durationCol = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
                int sizeCol = cursor.getColumnIndex(MediaStore.Audio.Media.SIZE);
                int artistCol = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
                int urlCol = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);
                do{
                    String title = cursor.getString(displayNameCol);
                    String album = cursor.getString(albumCol);
                    long id = cursor.getLong(idCol);
                    int duration = cursor.getInt(durationCol);
                    long size = cursor.getLong(sizeCol);
                    String artist = cursor.getString(artistCol);
                    String url = cursor.getString(urlCol);

                    MusicInfo musicInfo = new MusicInfo(id, title);
                    musicInfo.setTitle(title);
                    musicInfo.setAlbum(album);
                    musicInfo.setDuration(duration);
                    musicInfo.setSize(size);
                    musicInfo.setArtist(artist);
                    musicInfo.setUrl(url);
                    musicList.add(musicInfo);

                }while(cursor.moveToNext());
            }
        }

        public List<MusicInfo> getMusicList(){
            return musicList;
        }

        public Uri getMusicUriById(long id){
            Uri uri = ContentUris.withAppendedId(contentUri, id);
            return uri;
        }
        //下面是自定义的一个MusicInfo子类
        public static class MusicInfo  {
            private long id;
            private String title;
            private String album;
            private int duration;
            private long size;
            private String artist;
            private String url;

            public MusicInfo(){

            }

            public MusicInfo(long pId, String pTitle){
                id = pId;
                title = pTitle;
            }

            public String getArtist() {
                return artist;
            }

            public void setArtist(String artist) {
                this.artist = artist;
            }

            public long getSize() {
                return size;
            }

            public void setSize(long size) {
                this.size = size;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAlbum() {
                return album;
            }

            public void setAlbum(String album) {
                this.album = album;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

        }
}
