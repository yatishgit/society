package com.bean;

/**
 * Created by TheLucifer on 12/10/2016.
 */
public class AlbumImages {
    private String imageId;
    private String albumId;
    private String societyId;
    private String image;

    public AlbumImages() {
    }

    public AlbumImages(String imageId, String albumId, String societyId, String image) {
        this.imageId = imageId;
        this.albumId = albumId;
        this.societyId = societyId;
        this.image = image;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "AlbumImages{" +
                "imageId='" + imageId + '\'' +
                ", albumId='" + albumId + '\'' +
                ", societyId='" + societyId + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
