package com.bean;

/**
 * Created by TheLucifer on 10/30/2016.
 */
public class MainMenuDataObject {

    private String menuName;
    private Integer menuImage;


    public MainMenuDataObject() {
    }

    public MainMenuDataObject(String menuName, Integer menuImage) {
        this.menuName = menuName;
        this.menuImage = menuImage;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(Integer menuImage) {
        this.menuImage = menuImage;
    }

    @Override
    public String toString() {
        return "MainMenuDataObject{" +
                "menuName='" + menuName + '\'' +
                ", menuImage='" + menuImage + '\'' +
                '}';
    }
}
