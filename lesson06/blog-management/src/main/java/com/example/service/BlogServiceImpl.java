package com.example.service;

import com.example.model.Post;
import com.example.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Post> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Post findPostById(Long id) {
        return blogRepository.findPostById(id);
    }

    @Override
    public void save(Post post) {
        blogRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        blogRepository.delete(id);
    }
}
