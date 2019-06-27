package com.example.android.recyclerviewproject.Custom_Object;

public class Category {

    private int imageIndex;
    private String myName;

    public Category(String name, int i){
        myName = name;
        imageIndex = i;
    }

    public String getMyName() {
        return myName;
    }

    public int getImageIndex() {
        return imageIndex;
    }
}
