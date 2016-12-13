package com.bean;

import java.util.Arrays;

/**
 * Created by TheLucifer on 10/30/2016.
 */
public class AlbumDataObject {

    private String albumName;
    private String albumDate;
    private String albumUploader;
    private String coverImage;

    public AlbumDataObject() {
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public AlbumDataObject(String albumName, String albumDate, String albumUploader,String coverImage) {
        this.albumName = albumName;
        this.albumDate = albumDate;
        this.albumUploader = albumUploader;
        this.coverImage = coverImage;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDate() {
        return albumDate;
    }

    public void setAlbumDate(String albumDate) {
        this.albumDate = albumDate;
    }

    public String getAlbumUploader() {
        return albumUploader;
    }

    public void setAlbumUploader(String albumUploader) {
        this.albumUploader = albumUploader;
    }


    @Override
    public String toString() {
        return "AlbumDataObject{" +
                "albumName='" + albumName + '\'' +
                ", albumDate='" + albumDate + '\'' +
                ", albumUploader='" + albumUploader + '\'' +
                ", coverImage=" + coverImage +
                '}';
    }
}
