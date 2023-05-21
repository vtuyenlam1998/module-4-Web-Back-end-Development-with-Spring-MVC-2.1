package com.example.pictureoftheday.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    private String author;
    private String feedback;
    private LocalDateTime dateTime;
    private Long like;

    public Comment() {
    }
    public Comment(Long id, int rate, String author, String feedback, LocalDateTime dateTime, Long like) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.feedback = feedback;
        this.dateTime = dateTime;
        this.like = like;
    }

    public Comment(int rate, String author, String feedback, LocalDateTime dateTime, Long like) {
        this.rate = rate;
        this.author = author;
        this.feedback = feedback;
        this.dateTime = dateTime;
        this.like = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }
}
