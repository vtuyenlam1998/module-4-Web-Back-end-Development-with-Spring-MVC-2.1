package com.example.uploadmusic.repository.impl;

import com.example.uploadmusic.model.Music;
import com.example.uploadmusic.repository.UploadMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UploadMusicRepositoryImpl implements UploadMusicRepository {
    @PersistenceContext
    private EntityManager em;

        @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = em.createQuery("select m from Music m",Music.class);
        return query.getResultList();
    }
//    @Override
//    public List<Music> findAll() {
//        return findAllByIsActiveIsTrue();
//    }

    @Override
    public Music findById(Long id) {
        TypedQuery<Music> query = em.createQuery("select m from Music m where m.id = :id", Music.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(Music music) {
        if (music.getId() != null) {
            em.merge(music);
        } else {
            em.persist(music);
        }
    }

    @Override
    public void delete(Long id) {
        Music music = findById(id);
        if (music != null) {
            em.remove(music);
        }
    }
}
