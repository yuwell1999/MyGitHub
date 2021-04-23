package com.example.mygithub.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResult<T> {
    @SerializedName("total_count")
    private int count;
    @SerializedName("items")
    private List<T> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
