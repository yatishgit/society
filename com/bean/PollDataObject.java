package com.bean;

import java.sql.Time;
import java.sql.Date;
import java.util.Arrays;

/**
 * Created by TheLucifer on 10/31/2016.
 */
public class PollDataObject {

    private String pollCreator;
    private String pollTitle;
    private String pollDate;
    private String pollTime;
    private String flatNo;
    private String pollDescription;
    private String pollExpiry;
    private String pollQuestion;

    public PollDataObject() {
    }

    public PollDataObject(String pollCreator, String pollTitle, String pollDate, String pollTime, String flatNo, String pollDescription, String pollExpiry, String pollQuestion) {
        this.pollCreator = pollCreator;
        this.pollTitle = pollTitle;
        this.pollDate = pollDate;
        this.pollTime = pollTime;
        this.flatNo = flatNo;
        this.pollDescription = pollDescription;
        this.pollExpiry = pollExpiry;
        this.pollQuestion = pollQuestion;
    }

    public String getPollCreator() {
        return pollCreator;
    }

    public void setPollCreator(String pollCreator) {
        this.pollCreator = pollCreator;
    }

    public String getPollTitle() {
        return pollTitle;
    }

    public void setPollTitle(String pollTitle) {
        this.pollTitle = pollTitle;
    }

    public String getPollDate() {
        return pollDate;
    }

    public void setPollDate(String pollDate) {
        this.pollDate = pollDate;
    }

    public String getPollTime() {
        return pollTime;
    }

    public void setPollTime(String pollTime) {
        this.pollTime = pollTime;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getPollDescription() {
        return pollDescription;
    }

    public void setPollDescription(String pollDescription) {
        this.pollDescription = pollDescription;
    }

    public String getPollExpiry() {
        return pollExpiry;
    }

    public void setPollExpiry(String pollExpiry) {
        this.pollExpiry = pollExpiry;
    }

    public String getPollQuestion() {
        return pollQuestion;
    }

    public void setPollQuestion(String pollQuestion) {
        this.pollQuestion = pollQuestion;
    }
}

