package com.example.blogSample.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Comment {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Size(min = 5, max = 150, message = "Minimum 5 znaków, maximum 150 znaków")
    private String title;

    @NotNull
    @Size(min = 5, max = 3000,message = "Minimum 5 znaków, maximum 3000 znaków")
    private String text;

    @NotNull
    private String data;

    public Comment(){}

    public Comment(String title, String text, String data) {
        this.title = title;
        this.text = text;
        this.data = data;
    }

    public Comment(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
