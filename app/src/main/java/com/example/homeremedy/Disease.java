package com.example.homeremedy;

public class Disease {
    private int imageResId;
    private String name;

    public Disease(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }
}
