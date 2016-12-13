package com.bean;

/**
 * Created by TheLucifer on 12/10/2016.
 */
public class Album {
    private String societyId;
    private String albumId;
    private String albumTitle;
    private String addedDate;
    private String description;
    private String image;

    public Album() {
    }

    public Album(String societyId, String albumId, String albumTitle, String addedDate, String description, String image) {
        this.societyId = societyId;
        albumId = albumId;
        this.albumTitle = albumTitle;
        this.addedDate = addedDate;
        this.description = description;
        this.image = image;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Album{" +
                "societyId='" + societyId + '\'' +
                ", albumId='" + albumId + '\'' +
                ", albumTitle='" + albumTitle + '\'' +
                ", addedDate='" + addedDate + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
