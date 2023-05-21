package com.example.pictureoftheday.service;

import com.example.pictureoftheday.model.Comment;
import com.example.pictureoftheday.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private  PictureRepository pictureRepository;

    @Override
    public List<Comment> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Comment findById(Long id) throws NoSuchElementException{
       return pictureRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        pictureRepository.save(comment);
    }

    @Override
    public void remove(Long id) {
        pictureRepository.delete(id);
    }
}
