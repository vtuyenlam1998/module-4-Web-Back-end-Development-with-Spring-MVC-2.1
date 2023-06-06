package com.example.picture_of_the_day_2.repository.impl;

import com.example.picture_of_the_day_2.model.Comment;
import com.example.picture_of_the_day_2.repository.CommentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository

public class CommentRepositoryImpl implements CommentRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.isActive = true", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.id = :id AND c.isActive = true", Comment.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void save(Comment comment) {
        if (comment.getId() != null) {
            em.merge(comment);
        } else {
            em.persist(comment);
        }
    }

    @Override
    public void delete(Long id) {
        em.createQuery("UPDATE Comment c SET c.isActive = false where c.id=:id", Comment.class).setParameter("id", id);
    }

}
