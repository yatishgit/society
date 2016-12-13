package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class Staff {

    private String staffId;
    private String name;
    private String designation;
    private String contactNo;
    private String idProof;
    private String societyId;
    private String buidingId;
    private String flatNo;

    public Staff() {
    }

    public Staff(String staffId, String name, String designation, String contactNo, String idProof, String societyId, String buidingId, String flatNo) {
        this.staffId = staffId;
        this.name = name;
        this.designation = designation;
        this.contactNo = contactNo;
        this.idProof = idProof;
        this.societyId = societyId;
        this.buidingId = buidingId;
        this.flatNo = flatNo;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getBuidingId() {
        return buidingId;
    }

    public void setBuidingId(String buidingId) {
        this.buidingId = buidingId;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId='" + staffId + '\'' +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", idProof='" + idProof + '\'' +
                ", societyId='" + societyId + '\'' +
                ", buidingId='" + buidingId + '\'' +
                ", flatNo='" + flatNo + '\'' +
                '}';
    }
}
