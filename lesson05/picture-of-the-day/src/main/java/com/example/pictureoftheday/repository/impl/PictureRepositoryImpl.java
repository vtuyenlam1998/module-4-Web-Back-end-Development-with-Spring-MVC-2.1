package com.example.pictureoftheday.repository.impl;

import com.example.pictureoftheday.model.Comment;
import com.example.pictureoftheday.repository.PictureRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PictureRepositoryImpl implements PictureRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = em.createQuery("select m from Comment m", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        TypedQuery<Comment> query = em.createQuery("select m from Comment m where m.id=:id", Comment.class).setParameter("id", id);
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
        } else em.persist(comment);
    }

    @Override
    public void delete(Long id) {
        Comment comment = findById(id);
        if (comment != null) {
            em.remove(comment);
        }
    }
}
