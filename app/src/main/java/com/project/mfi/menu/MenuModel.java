package com.project.mfi.menu;

/**
 * Created by root on 09/01/17.
 */

public class MenuModel {
    private int image;
    private String title;

    public MenuModel(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
