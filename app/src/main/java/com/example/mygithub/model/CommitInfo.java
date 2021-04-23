package com.example.mygithub.model;

import com.google.gson.annotations.SerializedName;

public class CommitInfo {
    @SerializedName("sha")
    private String sha;
    @SerializedName("commit")
    private Commit commit;
    @SerializedName("committer")
    private UserInfo committer;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public UserInfo getCommitter() {
        return committer;
    }

    public void setCommitter(UserInfo committer) {
        this.committer = committer;
    }
}
