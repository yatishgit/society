package com.bean;

/**
 * Created by TheLucifer on 12/10/2016.
 */
public class Committee {

    private String committeeId;
    private String name;
    private String designation;
    private String description;
    private String showContact;
    private String contactNo;
    private String societyId;
    private String buildingId;
    private String flatNo;


    public Committee() {
    }

    public Committee(String committeeId, String name, String designation, String description, String showContact, String contactNo, String societyId, String buildingId, String flatNo) {
        this.committeeId = committeeId;
        this.name = name;
        this.designation = designation;
        this.description = description;
        this.showContact = showContact;
        this.contactNo = contactNo;
        this.societyId = societyId;
        this.buildingId = buildingId;
        this.flatNo = flatNo;
    }

    public String getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(String committeeId) {
        this.committeeId = committeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShowContact() {
        return showContact;
    }

    public void setShowContact(String showContact) {
        this.showContact = showContact;
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

    @Override
    public String toString() {
        return "Committee{" +
                "committeeId='" + committeeId + '\'' +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", description='" + description + '\'' +
                ", showContact='" + showContact + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", societyId='" + societyId + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", flatNo='" + flatNo + '\'' +
                '}';
    }
}
