package com.bean;

/**
 * Created by TheLucifer on 12/11/2016.
 */
public class Category {

    private String categoryId;
    private String categoryName;
    private String image;
    private String description;

    public Category() {
    }

    public Category(String categoryId, String categoryName, String image, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.image = image;
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
