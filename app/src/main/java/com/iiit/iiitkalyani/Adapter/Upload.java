package com.iiit.iiitkalyani.Adapter;

public class Upload {
    private String mName;
    private String mImageUrl;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String name, String imageUrl) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}