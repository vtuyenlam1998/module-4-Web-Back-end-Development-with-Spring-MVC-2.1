package com.example.pictureoftheday.repository;

import com.example.pictureoftheday.model.Comment;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PictureRepository {
    List<Comment> findAll();

    Comment findById(Long id);

    void save(Comment comment);

    void delete(Long id);
}
