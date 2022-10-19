package com.example.moviegetter;

public class Movies {
    private long id;
    private Integer year;
    private String title;
    private String description;

    public Movies(long id, Integer year, String title, String description) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
