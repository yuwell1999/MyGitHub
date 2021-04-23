package com.example.mygithub.model;

import com.google.gson.annotations.SerializedName;

public class FileContent {
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;
    @SerializedName("path")
    private String path;
    @SerializedName("download_url")
    private String fileUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
