package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class Vendor {

    private String vendorId;
    private String categoryId;
    private String vendorName;
    private String company;
    private String description;
    private String contact1;
    private String contact2;
    private String vendorAdd1;
    private String vendorAdd2;
    private String vendorAdd3;
    private String idProof;
    private String societyId;

    public Vendor() {
    }

    public Vendor(String vendorId, String categoryId, String vendorName, String company, String description, String contact1, String contact2, String vendorAdd1, String vendorAdd2, String vendorAdd3, String idProof, String societyId) {
        this.vendorId = vendorId;
        this.categoryId = categoryId;
        this.vendorName = vendorName;
        this.company = company;
        this.description = description;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.vendorAdd1 = vendorAdd1;
        this.vendorAdd2 = vendorAdd2;
        this.vendorAdd3 = vendorAdd3;
        this.idProof = idProof;
        this.societyId = societyId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getVendorAdd1() {
        return vendorAdd1;
    }

    public void setVendorAdd1(String vendorAdd1) {
        this.vendorAdd1 = vendorAdd1;
    }

    public String getVendorAdd2() {
        return vendorAdd2;
    }

    public void setVendorAdd2(String vendorAdd2) {
        this.vendorAdd2 = vendorAdd2;
    }

    public String getVendorAdd3() {
        return vendorAdd3;
    }

    public void setVendorAdd3(String vendorAdd3) {
        this.vendorAdd3 = vendorAdd3;
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

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorId='" + vendorId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", company='" + company + '\'' +
                ", description='" + description + '\'' +
                ", contact1='" + contact1 + '\'' +
                ", contact2='" + contact2 + '\'' +
                ", vendorAdd1='" + vendorAdd1 + '\'' +
                ", vendorAdd2='" + vendorAdd2 + '\'' +
                ", vendorAdd3='" + vendorAdd3 + '\'' +
                ", idProof='" + idProof + '\'' +
                ", societyId='" + societyId + '\'' +
                '}';
    }
}
