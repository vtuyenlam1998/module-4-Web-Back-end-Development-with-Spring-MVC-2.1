package com.example.picture_of_the_day_2.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    private String author;
    @Column(length = 1000)
    private String feedback;
    private LocalDateTime dateTime;
    private Long likes;
    @Column(name = "is_active")
    private boolean isActive = true;

    public Comment() {
    }
    public Comment(Long id, int rate, String author, String feedback, LocalDateTime dateTime, Long likes) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.feedback = feedback;
        this.dateTime = dateTime;
        this.likes = likes;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Comment(int rate, String author, String feedback, LocalDateTime dateTime, Long likes) {
        this.rate = rate;
        this.author = author;
        this.feedback = feedback;
        this.dateTime = dateTime;
        this.likes = likes;
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

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long like) {
        this.likes = like;
    }
}
