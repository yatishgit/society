package com.bean;

/**
 * Created by TheLucifer on 12/10/2016.
 */
public class HelpDeskSociety {
    private String issueId;
    private String buildingId;
    private String societyId;
    private String userId;
    private String category;
    private String description;
    private String issueDate;
    private String resolvedStatus;
    private String status;
    private String image;
    private String issueBy;
    private String type;

    public HelpDeskSociety() {
    }

    public HelpDeskSociety(String issueId, String buildingId, String societyId, String userId, String category, String description, String issueDate, String resolvedStatus, String status, String image, String issueBy, String type) {
        this.issueId = issueId;
        this.buildingId = buildingId;
        this.societyId = societyId;
        this.userId = userId;
        this.category = category;
        this.description = description;
        this.issueDate = issueDate;
        this.resolvedStatus = resolvedStatus;
        this.status = status;
        this.image = image;
        this.issueBy = issueBy;
        this.type = type;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getResolvedStatus() {
        return resolvedStatus;
    }

    public void setResolvedStatus(String resolvedStatus) {
        this.resolvedStatus = resolvedStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIssueBy() {
        return issueBy;
    }

    public void setIssueBy(String issueBy) {
        this.issueBy = issueBy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HelpDeskPersonal{" +
                "issueId='" + issueId + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", societyId='" + societyId + '\'' +
                ", userId='" + userId + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", resolvedStatus='" + resolvedStatus + '\'' +
                ", status='" + status + '\'' +
                ", image='" + image + '\'' +
                ", issueBy='" + issueBy + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

