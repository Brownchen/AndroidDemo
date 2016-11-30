package edu.whut.chenmin.job3;

import java.util.List;

/**
 * Created by brown on 2016/11/29.
 */

public class LyricListBean {
    private int count;
    private int code;
    /**
     * aid : 2848529
     * lrc : http://s.gecimi.com/lrc/344/34435/3443588.lrc
     * song : 海阔天空
     * artist_id : 2
     * sid : 3443588
     */

    private List<ResultBean> result;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private int aid;
        private String lrc;
        private String song;
        private int artist_id;
        private int sid;

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public String getLrc() {
            return lrc;
        }

        public void setLrc(String lrc) {
            this.lrc = lrc;
        }

        public String getSong() {
            return song;
        }

        public void setSong(String song) {
            this.song = song;
        }

        public int getArtist_id() {
            return artist_id;
        }

        public void setArtist_id(int artist_id) {
            this.artist_id = artist_id;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }
    }
}
