package com.example.service;

import com.example.model.Post;

import java.util.List;

public interface BlogService {
    List<Post> findAll();
    Post findPostById(Long id);
    void save(Post post);
    void delete(Long id);
}
