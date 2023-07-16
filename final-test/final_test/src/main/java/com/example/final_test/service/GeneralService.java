package com.example.final_test.service;

import java.util.Optional;

public interface GeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id) throws Exception;

    void save(T t);

    void softDelete(Long id);
}
