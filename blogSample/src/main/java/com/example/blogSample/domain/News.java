package com.example.blogSample.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


public class News {

    @Id
    @GeneratedValue
    private long id;

    @NotNull(message = "Pole nie może być puste")
    @Size(min = 5, max = 300, message = "Minimum 5 znaków, maximum 300 znaków")
    private String title;

    @NotNull
    @Size(min = 5, max = 3000,message = "Minimum 5 znaków, maximum 3000 znaków")
    private String text;

    @NotNull
    private String data;

    @NotNull
    @Size(min = 1,max = 100, message = "Minimum 1 znak, maximum 100 znaków")
    private String author;

    public News(){}

    public News(String title, String text, String data, String author) {
        this.title = title;
        this.text = text;
        this.data = data;
        this.author = author;
    }

    public News(String title, String text,String author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
