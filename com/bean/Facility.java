package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class Facility {

    private String facilityId;
    private String societyId;
    private String facilityName;
    private String description;
    private String image;
    private String deposit;
    private String availableFlag;

    public Facility() {
    }

    public Facility(String facilityId, String societyId, String facilityName, String description, String image, String deposit, String availableFlag) {
        this.facilityId = facilityId;
        this.societyId = societyId;
        this.facilityName = facilityName;
        this.description = description;
        this.image = image;
        this.deposit = deposit;
        this.availableFlag = availableFlag;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
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

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getAvailableFlag() {
        return availableFlag;
    }

    public void setAvailableFlag(String availableFlag) {
        this.availableFlag = availableFlag;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "facilityId='" + facilityId + '\'' +
                ", societyId='" + societyId + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", deposit='" + deposit + '\'' +
                ", availableFlag='" + availableFlag + '\'' +
                '}';
    }
}
