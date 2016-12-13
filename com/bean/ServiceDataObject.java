package com.bean;

/**
 * Created by TheLucifer on 11/7/2016.
 */
public class ServiceDataObject {

    String serviceImageUrl;
    String ServiceType;

    public ServiceDataObject() {

    }

    public ServiceDataObject(String serviceImageUrl, String serviceType) {
        this.serviceImageUrl = serviceImageUrl;
        ServiceType = serviceType;
    }

    public String getServiceImageUrl() {
        return serviceImageUrl;
    }

    public void setServiceImageUrl(String serviceImageUrl) {
        this.serviceImageUrl = serviceImageUrl;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    @Override
    public String toString() {
        return "ServiceDataObject{" +
                "serviceImageUrl='" + serviceImageUrl + '\'' +
                ", ServiceType='" + ServiceType + '\'' +
                '}';
    }
}
