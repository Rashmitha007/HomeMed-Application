package com.example.homeremedy;

public class Remedy {
    private String name;
    private String summary;

    public Remedy(String name, String summary) {
        this.name = name;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }
}

