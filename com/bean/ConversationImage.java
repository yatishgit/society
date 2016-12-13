package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class ConversationImage {

    private String imageId;
    private String conversationId;
    private String societyId;
    private String image;

    public ConversationImage() {
    }

    public ConversationImage(String imageId, String conversationId, String societyId, String image) {
        this.imageId = imageId;
        this.conversationId = conversationId;
        this.societyId = societyId;
        this.image = image;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
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
        return "ConversationImage{" +
                "imageId='" + imageId + '\'' +
                ", conversationId='" + conversationId + '\'' +
                ", societyId='" + societyId + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
