package com.example.mygithub.model;

import com.google.gson.annotations.SerializedName;

public class Repo {
    @SerializedName("full_name")
    private String name;
    @SerializedName("forks_count")
    private int fork;
    @SerializedName("language")
    private String language;
    @SerializedName("stargazers_count")
    private int star;
    @SerializedName("description")
    private String description;
    @SerializedName("private")
    private boolean isPrivate;
    @SerializedName("license")
    private License license;
    @SerializedName("watchers_count")
    private int watches;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFork() {
        return fork;
    }

    public void setFork(int fork) {
        this.fork = fork;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public int getWatches() {
        return watches;
    }

    public void setWatches(int watches) {
        this.watches = watches;
    }
}
