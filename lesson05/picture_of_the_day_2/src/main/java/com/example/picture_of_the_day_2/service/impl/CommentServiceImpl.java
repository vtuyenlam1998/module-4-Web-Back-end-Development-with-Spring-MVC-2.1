package com.example.picture_of_the_day_2.service.impl;

import com.example.picture_of_the_day_2.model.Comment;
import com.example.picture_of_the_day_2.repository.CommentRepository;
import com.example.picture_of_the_day_2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
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
    public Comment findByIdComment(Long id) throws Exception {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        comment.setLikes(0L);
        comment.setDateTime(LocalDateTime.now());
        commentRepository.save(comment);
    }

    @Override
    public void remove(Long id) {
        commentRepository.delete(id);
    }

    @Override
    public void setLike(Long id) throws Exception {
        Comment comment = findByIdComment(id);
        long likes = comment.getLikes();
        comment.setLikes(likes + 1);
        commentRepository.save(comment);
    }
}
