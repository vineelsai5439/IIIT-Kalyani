package com.iiit.iiitkalyani;

public class Download {
    private String mName;
    private String mImageUrl;
    private String mtitle;
    private String mdescription;
    private String mprofile;
    public Download() {
        //empty constructor needed
    }

    public Download(String publisher, String imageUrl, String title, String description, String profile) {
        mName = publisher;
        mImageUrl = imageUrl;
        mprofile = profile;
        mtitle = title;
        mdescription = description;
    }

    public String getName() {
        return mName;
    }
    public String gettitle() {
        return mtitle;
    }
    public String getdescription() {
        return mdescription;
    }
    public String getprofileimg() {
        return mprofile;
    }
    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}