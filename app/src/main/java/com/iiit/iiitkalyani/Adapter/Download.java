package com.iiit.iiitkalyani.Adapter;

public class Download {
    private String publisher;
    private String mImageUrl;
    private String mtitle;
    private String mdescription;
    private String mprofile;
    public Download() {
        //empty constructor needed
    }

    public Download(String name, String imageUrl, String title, String description, String profile) {
        this.publisher = name;
        this.mImageUrl = imageUrl;
        this.mprofile = profile;
        this.mtitle = title;
        this.mdescription = description;
    }

    public String getname() {
        return publisher;
    }
    public void setname(String name) {
        this.publisher = name;
    }
    public String gettitle() {
        return mtitle;
    }
    public void settitle(String title) {
        this.mtitle = title;
    }

    public String getdescription() {
        return mdescription;
    }
    public void setdescription(String description) {
        this.mdescription = description;
    }
    public String getprofileimg() {
        return mprofile;
    }
    public void setprofileimg(String profile) {
        mprofile = profile;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}