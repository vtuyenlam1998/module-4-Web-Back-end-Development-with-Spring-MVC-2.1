package com.example.picture_of_the_day_2.repository;

import com.example.picture_of_the_day_2.model.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CommentRepository {
    List<Comment> findAll();

    Comment findById(Long id);

    void save(Comment comment);
    void delete(Long id);
//    @Modifying
//    @Query("UPDATE Comment c SET c.isActive = false where c.id=:id")
//    Comment softDeleteJPQL(@Param("id") Long id);
//
//    @Query("select c from Comment c where c.isActive = true")
//    List<Comment> findAllByIsActiveIsTrue();
}
