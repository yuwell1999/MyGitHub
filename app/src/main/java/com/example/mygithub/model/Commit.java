package com.example.mygithub.model;

import com.google.gson.annotations.SerializedName;

public class Commit {
    @SerializedName("message")
    private String message;
    @SerializedName("committer")
    private Coder committer;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Coder getCommitter() {
        return committer;
    }

    public void setCommitter(Coder committer) {
        this.committer = committer;
    }
}
