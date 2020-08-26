package com.example.android_v4_debit_credit;

import androidx.annotation.IntegerRes;

public class NewsItems {
    private String title;
    private String description;
    @IntegerRes
    private int imageView;

    public NewsItems(String title, String description
//                     @IntegerRes int imageView
    ) {
        this.title = title;
        this.description = description;
//        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getImageView() { return imageView; }
    @Override
    public String toString() {
        return "NewsItems{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
//                ", imageView=" + imageView +
                '}';
    }
}

