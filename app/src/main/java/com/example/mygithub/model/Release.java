package com.example.mygithub.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Release {
    @SerializedName("name")
    private String name;
    @SerializedName("published_at")
    private String publishDate;
    @SerializedName("assets")
    private List<Asset> assets;
    @SerializedName("body")
    private String body;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
