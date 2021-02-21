package com.example.realsoloeat;

import android.graphics.drawable.Drawable;

public class DriveVO {
    public Drawable img;
    public String rest_name;

    public Drawable getImg(){
        return img;
    }

    public void setImg(Drawable img){
        this.img = img;
    }

    public String getRest_name(){
        return rest_name;
    }

    public void setRest_name(String rest_name){
        this.rest_name = rest_name;
    }
}