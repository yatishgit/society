package com.bean;

/**
 * Created by TheLucifer on 12/10/2016.
 */
public class User {
    private String userId;
    private String userName;
    private String userEmailId;
    private String userContact;
    private String userAddress;
    private String userImage;
    private String name;
    private String userFlatNo;
    private String userType;
    private String expiryDate;
    private String approvalStatus;
    private String pollingAllowed;
    private String societyId;
    private String buildingId;

    public User() {
    }

    public User(String userId, String userName, String userEmailId, String userContact, String userAddress, String userImage, String name, String userFlatNo, String userType, String expiryDate, String approvalStatus, String pollingAllowed, String societyId, String buildingId) {
        this.userId = userId;
        this.userName = userName;
        this.userEmailId = userEmailId;
        this.userContact = userContact;
        this.userAddress = userAddress;
        this.userImage = userImage;
        this.name = name;
        this.userFlatNo = userFlatNo;
        this.userType = userType;
        this.expiryDate = expiryDate;
        this.approvalStatus = approvalStatus;
        this.pollingAllowed = pollingAllowed;
        this.societyId = societyId;
        this.buildingId = buildingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserFlatNo() {
        return userFlatNo;
    }

    public void setUserFlatNo(String userFlatNo) {
        this.userFlatNo = userFlatNo;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getPollingAllowed() {
        return pollingAllowed;
    }

    public void setPollingAllowed(String pollingAllowed) {
        this.pollingAllowed = pollingAllowed;
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

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmailId='" + userEmailId + '\'' +
                ", userContact='" + userContact + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userImage='" + userImage + '\'' +
                ", name='" + name + '\'' +
                ", userFlatNo='" + userFlatNo + '\'' +
                ", userType='" + userType + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", pollingAllowed='" + pollingAllowed + '\'' +
                ", societyId='" + societyId + '\'' +
                ", buildingId='" + buildingId + '\'' +
                '}';
    }
}
