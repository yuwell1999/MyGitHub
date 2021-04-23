package com.example.mygithub.model;

import com.google.gson.annotations.SerializedName;

public class Asset {
    @SerializedName("name")
    private String name;
    @SerializedName("browser_download_url")
    private String downloadUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }


}
