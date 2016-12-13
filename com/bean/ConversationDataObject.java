package com.bean;

/**
 * Created by TheLucifer on 10/30/2016.
 */
public class ConversationDataObject {
    private String name;
    private String date;
    private String time;
    private String title;
    private String description;
    private String image;

    public ConversationDataObject(String name, String date, String time, String title, String description, String image) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public ConversationDataObject(String name, String date, String time, String title, String description) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.title = title;
        this.description = description;
        this.image = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ConversationDataObject{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}