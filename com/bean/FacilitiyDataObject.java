package com.bean;

/**
 * Created by TheLucifer on 11/7/2016.
 */
public class FacilitiyDataObject {

    String facility_id;
    String facility_name;
    String facility_description;
    String facility_icon;
    String deposit_amt;
    String available_flag;

    public FacilitiyDataObject() {

    }

    public FacilitiyDataObject(String facility_id, String facility_name, String facility_description, String facility_icon, String deposit_amt, String available_flag) {
        this.facility_id = facility_id;
        this.facility_name = facility_name;
        this.facility_description = facility_description;
        this.facility_icon = facility_icon;
        this.deposit_amt = deposit_amt;
        this.available_flag = available_flag;
    }

    public String getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(String facility_id) {
        this.facility_id = facility_id;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }

    public String getFacility_description() {
        return facility_description;
    }

    public void setFacility_description(String facility_description) {
        this.facility_description = facility_description;
    }

    public String getFacility_icon() {
        return facility_icon;
    }

    public void setFacility_icon(String facility_icon) {
        this.facility_icon = facility_icon;
    }

    public String getDeposit_amt() {
        return deposit_amt;
    }

    public void setDeposit_amt(String deposit_amt) {
        this.deposit_amt = deposit_amt;
    }

    public String getAvailable_flag() {
        return available_flag;
    }

    public void setAvailable_flag(String available_flag) {
        this.available_flag = available_flag;
    }

    @Override
    public String toString() {
        return "FacilitiyDataObject{" +
                "facility_id='" + facility_id + '\'' +
                ", facility_name='" + facility_name + '\'' +
                ", facility_description='" + facility_description + '\'' +
                ", facility_icon='" + facility_icon + '\'' +
                ", deposit_amt='" + deposit_amt + '\'' +
                ", available_flag='" + available_flag + '\'' +
                '}';
    }
}
