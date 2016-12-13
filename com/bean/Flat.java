package com.bean;

/**
 * Created by TheLucifer on 12/10/2016.
 */
public class Flat {
    private String flatId;
    private String buildingId;
    private String societyId;
    private String flatNo;
    private String flatArea;
    private String flatType;
    private String name;
    private String memberCount;
    private String owner;
    private String pollingAllowed;
    private String userId;
    private String ownerId;

    public Flat() {
    }

    public Flat(String flatId, String buildingId, String societyId, String flatNo, String flatArea, String flatType, String name, String memberCount, String owner, String pollingAllowed, String userId, String ownerId) {
        this.flatId = flatId;
        this.buildingId = buildingId;
        this.societyId = societyId;
        this.flatNo = flatNo;
        this.flatArea = flatArea;
        this.flatType = flatType;
        this.name = name;
        this.memberCount = memberCount;
        this.owner = owner;
        this.pollingAllowed = pollingAllowed;
        this.userId = userId;
        this.ownerId = ownerId;
    }

    public String getFlatId() {
        return flatId;
    }

    public void setFlatId(String flatId) {
        this.flatId = flatId;
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

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getFlatArea() {
        return flatArea;
    }

    public void setFlatArea(String flatArea) {
        this.flatArea = flatArea;
    }

    public String getFlatType() {
        return flatType;
    }

    public void setFlatType(String flatType) {
        this.flatType = flatType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(String memberCount) {
        this.memberCount = memberCount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPollingAllowed() {
        return pollingAllowed;
    }

    public void setPollingAllowed(String pollingAllowed) {
        this.pollingAllowed = pollingAllowed;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "flatId='" + flatId + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", societyId='" + societyId + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", flatArea='" + flatArea + '\'' +
                ", flatType='" + flatType + '\'' +
                ", name='" + name + '\'' +
                ", memberCount='" + memberCount + '\'' +
                ", owner='" + owner + '\'' +
                ", pollingAllowed='" + pollingAllowed + '\'' +
                ", userId='" + userId + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
