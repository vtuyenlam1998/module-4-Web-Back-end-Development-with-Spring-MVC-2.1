package com.example.picture_of_the_day_2.service;

import com.example.picture_of_the_day_2.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findByIdComment(Long id) throws Exception;

    void save(Comment comment);

    void remove(Long id);

    void setLike(Long id) throws Exception;
}
