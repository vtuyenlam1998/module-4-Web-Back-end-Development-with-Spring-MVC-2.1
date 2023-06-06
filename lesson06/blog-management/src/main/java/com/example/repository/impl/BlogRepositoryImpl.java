package com.example.repository.impl;

import com.example.model.Post;
import com.example.repository.BlogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Post> findAll() {
        TypedQuery<Post> query = em.createQuery("from Post", Post.class);
        return query.getResultList();
    }

    @Override
    public Post findPostById(Long id) {
//        TypedQuery<Post> query = em.createQuery("from Post where id = :id", Post.class).setParameter("id",id);
//        return query.getSingleResult();
        return em.find(Post.class,id);
    }

    @Override
    public void save(Post post) {
        if (post.getId() != null) {
            em.merge(post);
        }
        em.persist(post);
    }

    @Override
    public void delete(Long id) {
        em.remove(id);
    }
}
