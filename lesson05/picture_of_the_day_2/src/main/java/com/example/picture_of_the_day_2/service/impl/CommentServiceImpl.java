package com.example.picture_of_the_day_2.service.impl;

import com.example.picture_of_the_day_2.model.Comment;
import com.example.picture_of_the_day_2.repository.CommentRepository;
import com.example.picture_of_the_day_2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findByIdMusic(Long id) throws Exception {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment remove(Long id) {
        return commentRepository.delete(id);
    }


}
