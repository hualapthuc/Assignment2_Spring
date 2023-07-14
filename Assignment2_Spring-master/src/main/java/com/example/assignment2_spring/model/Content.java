package com.example.assignment2_spring.model;

import javax.validation.constraints.NotBlank;

public class Content {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Brief is required")
    private String brief;

    @NotBlank(message = "Content is required")
    private String content;

    private String sort;

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
