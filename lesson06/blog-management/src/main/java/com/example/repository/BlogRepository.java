package com.example.repository;

import com.example.model.Post;

import java.util.List;

public interface BlogRepository {
    List<Post> findAll();
    Post findPostById(Long id);
    void save(Post post);
    void delete(Long id);
}
