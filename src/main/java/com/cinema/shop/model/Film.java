package com.cinema.shop.model;

public class Film {

    private Integer id;

    private String title;

    private String Description;

    public Film() {
    }

    public Film(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        Description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
