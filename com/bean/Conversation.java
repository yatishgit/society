package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class Conversation {

    private String conversationId;
    private String societyId;
    private String userId;
    private String createDate;
    private String date;
    private String type;
    private String imageId;
    private String description;
    private String conversationTitle;

    public Conversation() {
    }

    public Conversation(String conversationId, String societyId, String userId, String createDate, String date, String type, String imageId, String description, String conversationTitle) {
        this.conversationId = conversationId;
        this.societyId = societyId;
        this.userId = userId;
        this.createDate = createDate;
        this.date = date;
        this.type = type;
        this.imageId = imageId;
        this.description = description;
        this.conversationTitle = conversationTitle;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConversationTitle() {
        return conversationTitle;
    }

    public void setConversationTitle(String conversationTitle) {
        this.conversationTitle = conversationTitle;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "conversationId='" + conversationId + '\'' +
                ", societyId='" + societyId + '\'' +
                ", userId='" + userId + '\'' +
                ", createDate='" + createDate + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", imageId='" + imageId + '\'' +
                ", description='" + description + '\'' +
                ", conversationTitle='" + conversationTitle + '\'' +
                '}';
    }
}
