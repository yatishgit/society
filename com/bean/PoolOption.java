package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class PoolOption {

    private String pollId;
    private String oprionId;
    private String options;

    public PoolOption() {
    }

    public PoolOption(String pollId, String oprionId, String options) {
        this.pollId = pollId;
        this.oprionId = oprionId;
        this.options = options;
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public String getOprionId() {
        return oprionId;
    }

    public void setOprionId(String oprionId) {
        this.oprionId = oprionId;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "PoolOption{" +
                "pollId='" + pollId + '\'' +
                ", oprionId='" + oprionId + '\'' +
                ", options='" + options + '\'' +
                '}';
    }
}
