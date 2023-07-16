package com.example.service.category;

import com.example.model.Category;
import com.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAllByIsActiveTrue();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findByIdAndIsActiveTrue(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void softDelete(Long categoryId) {
        categoryRepository.updateByIsActiveFalse(categoryId);
    }
}
