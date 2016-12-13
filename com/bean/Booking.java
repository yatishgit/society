package com.bean;

/**
 * Created by TheLucifer on 12/10/2016.
 */
public class Booking {
    private String bookingId;
    private String bookingDate;
    private String userId;
    private String facilityId;
    private String fromDate;
    private String toDate;
    private String buildingId;
    private String flatNo;
    private String amountDeposited;
    private String depositedDate;
    private String rDescription;
    private String rPaymentmode;
    private String rChequeNo;
    private String amountRefunded;
    private String refundDate;
    private String description;
    private String paymentMode;
    private String chequeNo;
    private String status;
    private String societyId;


    public Booking() {
    }

    public Booking(String bookingId, String bookingDate, String userId, String facilityId, String fromDate, String toDate, String buildingId, String flatNo, String amountDeposited, String depositedDate, String rDescription, String rPaymentmode, String rChequeNo, String amountRefunded, String refundDate, String description, String paymentMode, String chequeNo, String status, String societyId) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.userId = userId;
        this.facilityId = facilityId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.buildingId = buildingId;
        this.flatNo = flatNo;
        this.amountDeposited = amountDeposited;
        this.depositedDate = depositedDate;
        this.rDescription = rDescription;
        this.rPaymentmode = rPaymentmode;
        this.rChequeNo = rChequeNo;
        this.amountRefunded = amountRefunded;
        this.refundDate = refundDate;
        this.description = description;
        this.paymentMode = paymentMode;
        this.chequeNo = chequeNo;
        this.status = status;
        this.societyId = societyId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
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

    public String getAmountDeposited() {
        return amountDeposited;
    }

    public void setAmountDeposited(String amountDeposited) {
        this.amountDeposited = amountDeposited;
    }

    public String getDepositedDate() {
        return depositedDate;
    }

    public void setDepositedDate(String depositedDate) {
        this.depositedDate = depositedDate;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription;
    }

    public String getrPaymentmode() {
        return rPaymentmode;
    }

    public void setrPaymentmode(String rPaymentmode) {
        this.rPaymentmode = rPaymentmode;
    }

    public String getrChequeNo() {
        return rChequeNo;
    }

    public void setrChequeNo(String rChequeNo) {
        this.rChequeNo = rChequeNo;
    }

    public String getAmountRefunded() {
        return amountRefunded;
    }

    public void setAmountRefunded(String amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    public String getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(String refundDate) {
        this.refundDate = refundDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", userId='" + userId + '\'' +
                ", facilityId='" + facilityId + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", amountDeposited='" + amountDeposited + '\'' +
                ", depositedDate='" + depositedDate + '\'' +
                ", rDescription='" + rDescription + '\'' +
                ", rPaymentmode='" + rPaymentmode + '\'' +
                ", rChequeNo='" + rChequeNo + '\'' +
                ", amountRefunded='" + amountRefunded + '\'' +
                ", refundDate='" + refundDate + '\'' +
                ", description='" + description + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", chequeNo='" + chequeNo + '\'' +
                ", status='" + status + '\'' +
                ", societyId='" + societyId + '\'' +
                '}';
    }
}
