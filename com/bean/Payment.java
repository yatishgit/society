package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class Payment {

    private String transactionId;
    private String userId;
    private String societyId;
    private String buildingId;
    private String flatNo;
    private String paymentType;
    private String description;
    private String dueAmount;
    private String raisedAmount;
    private String raisedDate;
    private String dueDate;
    private String category;
    private String paymentStatus;
    private String paymentDate;
    private String paidAmount;
    private String paymentMode;
    private String chequeNo;
    private String refId;
    private String netBal;
    private String due;


    public Payment() {
    }

    public Payment(String transactionId, String userId, String societyId, String buildingId, String flatNo, String paymentType, String description, String dueAmount, String raisedAmount, String raisedDate, String dueDate, String category, String paymentStatus, String paymentDate, String paidAmount, String paymentMode, String chequeNo, String refId, String netBal, String due) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.societyId = societyId;
        this.buildingId = buildingId;
        this.flatNo = flatNo;
        this.paymentType = paymentType;
        this.description = description;
        this.dueAmount = dueAmount;
        this.raisedAmount = raisedAmount;
        this.raisedDate = raisedDate;
        this.dueDate = dueDate;
        this.category = category;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
        this.paidAmount = paidAmount;
        this.paymentMode = paymentMode;
        this.chequeNo = chequeNo;
        this.refId = refId;
        this.netBal = netBal;
        this.due = due;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(String dueAmount) {
        this.dueAmount = dueAmount;
    }

    public String getRaisedAmount() {
        return raisedAmount;
    }

    public void setRaisedAmount(String raisedAmount) {
        this.raisedAmount = raisedAmount;
    }

    public String getRaisedDate() {
        return raisedDate;
    }

    public void setRaisedDate(String raisedDate) {
        this.raisedDate = raisedDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
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

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getNetBal() {
        return netBal;
    }

    public void setNetBal(String netBal) {
        this.netBal = netBal;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "transactionId='" + transactionId + '\'' +
                ", userId='" + userId + '\'' +
                ", societyId='" + societyId + '\'' +
                ", buildingId='" + buildingId + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", description='" + description + '\'' +
                ", dueAmount='" + dueAmount + '\'' +
                ", raisedAmount='" + raisedAmount + '\'' +
                ", raisedDate='" + raisedDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", category='" + category + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", paidAmount='" + paidAmount + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", chequeNo='" + chequeNo + '\'' +
                ", refId='" + refId + '\'' +
                ", netBal='" + netBal + '\'' +
                ", due='" + due + '\'' +
                '}';
    }
}
