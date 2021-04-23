package com.example.mygithub.model;

import com.google.gson.annotations.SerializedName;

public class License {
    @SerializedName("key")
    private String key;
    @SerializedName("name")
    private String name;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
