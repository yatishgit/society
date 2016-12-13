package com.bean;

import java.security.PrivateKey;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class PoolingResponse {

    private String pollId;
    private String userId;
    private String flatNo;
    private String responseId;
    private String response;
    private String optionId;

    public PoolingResponse() {
    }

    public PoolingResponse(String pollId, String userId, String flatNo, String responseId, String response, String optionId) {
        this.pollId = pollId;
        this.userId = userId;
        this.flatNo = flatNo;
        this.responseId = responseId;
        this.response = response;
        this.optionId = optionId;
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getResponseId() {
        return responseId;
    }

    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    @Override
    public String toString() {
        return "PoolingResponse{" +
                "pollId='" + pollId + '\'' +
                ", userId='" + userId + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", responseId='" + responseId + '\'' +
                ", response='" + response + '\'' +
                ", optionId='" + optionId + '\'' +
                '}';
    }
}
