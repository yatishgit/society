package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class Parking {

    private String parkingId;
    private String societyId;
    private String buildingId;
    private String flatNo;
    private String parkingSlot;
    private String vehicleNo;
    private String vehicleType;


    public Parking() {
    }

    public Parking(String parkingId, String societyId, String buildingId, String flatNo, String parkingSlot, String vehicleNo, String vehicleType) {
        this.parkingId = parkingId;
        this.societyId = societyId;
        this.buildingId = buildingId;
        this.flatNo = flatNo;
        this.parkingSlot = parkingSlot;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
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

    public String getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(String parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingId='" + parkingId + '\'' +
                ", societyId='" + societyId + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", parkingSlot='" + parkingSlot + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
