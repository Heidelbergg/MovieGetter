package com.example.moviegetter;

public class Movies {
    private long id;
    private long year;
    private String title;
    private String description;

    public Movies(long id, long year, String title, String description) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public long getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
