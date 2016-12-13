package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class Pooling {

    private String pollId;
    private String societyId;
    private String creator;
    private String description;
    private String pollDate;
    private String expiryDate;
    private String status;
    private String pollFor;
    private String contactNo;

    public Pooling() {
    }

    public Pooling(String pollId, String societyId, String creator, String description, String pollDate, String expiryDate, String status, String pollFor, String contactNo) {
        this.pollId = pollId;
        this.societyId = societyId;
        this.creator = creator;
        this.description = description;
        this.pollDate = pollDate;
        this.expiryDate = expiryDate;
        this.status = status;
        this.pollFor = pollFor;
        this.contactNo = contactNo;
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPollDate() {
        return pollDate;
    }

    public void setPollDate(String pollDate) {
        this.pollDate = pollDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPollFor() {
        return pollFor;
    }

    public void setPollFor(String pollFor) {
        this.pollFor = pollFor;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Pooling{" +
                "pollId='" + pollId + '\'' +
                ", societyId='" + societyId + '\'' +
                ", creator='" + creator + '\'' +
                ", description='" + description + '\'' +
                ", pollDate='" + pollDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", status='" + status + '\'' +
                ", pollFor='" + pollFor + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
