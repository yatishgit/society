package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class Visitor {

    private String visitorId;
    private String name;
    private String contactNo;
    private String societyId;
    private String buildingId;
    private String flatNo;
    private String visitorType;
    private String checkInTime;
    private String checkOutTime;
    private String expectedTime;
    private String date;

    public Visitor() {
    }

    public Visitor(String visitorId, String name, String contactNo, String societyId, String buildingId, String flatNo, String visitorType, String checkInTime, String checkOutTime, String expectedTime, String date) {
        this.visitorId = visitorId;
        this.name = name;
        this.contactNo = contactNo;
        this.societyId = societyId;
        this.buildingId = buildingId;
        this.flatNo = flatNo;
        this.visitorType = visitorType;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.expectedTime = expectedTime;
        this.date = date;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(String visitorType) {
        this.visitorType = visitorType;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(String expectedTime) {
        this.expectedTime = expectedTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorId='" + visitorId + '\'' +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", societyId='" + societyId + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", visitorType='" + visitorType + '\'' +
                ", checkInTime='" + checkInTime + '\'' +
                ", checkOutTime='" + checkOutTime + '\'' +
                ", expectedTime='" + expectedTime + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
