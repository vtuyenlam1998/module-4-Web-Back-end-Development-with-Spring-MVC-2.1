package com.example.service;

import com.example.model.Product;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id) throws Exception;

    void save(T t);

    void softDelete(Long id);
}
