package com.bean;

import java.util.Arrays;

/**
 * Created by TheLucifer on 10/30/2016.
 */
public class AlbumImageGalleryDataObject {

    private String albumImages;

    public AlbumImageGalleryDataObject() {
    }

    public AlbumImageGalleryDataObject(String albumImages) {
        this.albumImages = albumImages;
    }

    public String getAlbumImages() {
        return albumImages;
    }

    public void setAlbumImages(String albumImages) {
        this.albumImages = albumImages;
    }

    @Override
    public String toString() {
        return "AlbumImageGalleryDataObject{" +
                "albumImages='" + albumImages + '\'' +
                '}';
    }
}
