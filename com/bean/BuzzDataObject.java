package com.bean;

/**
 * Created by TheLucifer on 11/7/2016.
 */
public class BuzzDataObject {

    String buzzServiceImageUrl;
    String buzzServiceType;

    public BuzzDataObject() {

    }

    public BuzzDataObject(String buzzServiceImageUrl, String buzzServiceType) {
        this.buzzServiceImageUrl = buzzServiceImageUrl;
        this.buzzServiceType = buzzServiceType;
    }

    public String getBuzzServiceImageUrl() {
        return buzzServiceImageUrl;
    }

    public void setBuzzServiceImageUrl(String buzzServiceImageUrl) {
        this.buzzServiceImageUrl = buzzServiceImageUrl;
    }

    public String getBuzzServiceType() {
        return buzzServiceType;
    }

    public void setBuzzServiceType(String buzzServiceType) {
        this.buzzServiceType = buzzServiceType;
    }

    @Override
    public String toString() {
        return "BuzzDataObject{" +
                "buzzServiceImageUrl='" + buzzServiceImageUrl + '\'' +
                ", buzzServiceType='" + buzzServiceType + '\'' +
                '}';
    }
}
