package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class Notice {

    private String noticeId;
    private String societyId;
    private String managerId;
    private String description;
    private String title;


    public Notice() {
    }

    public Notice(String noticeId, String societyId, String managerId, String description, String title) {
        this.noticeId = noticeId;
        this.societyId = societyId;
        this.managerId = managerId;
        this.description = description;
        this.title = title;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId='" + noticeId + '\'' +
                ", societyId='" + societyId + '\'' +
                ", managerId='" + managerId + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
