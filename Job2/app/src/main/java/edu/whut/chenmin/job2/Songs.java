package edu.whut.chenmin.job2;

/**
 * Created by brown on 2016/11/17.
 */

public class Songs {

    private String  name;

    private int imageId;

    private String singer;

    public Songs (int imageId,String name,String singer){
        this.name = name;
        this.imageId = imageId;
        this.singer = singer;
    }
    public String getName(){
        return name;
    }
    public String getSinger(){
        return singer;
    }
    public int getImageId(){
        return imageId;
    }
}
