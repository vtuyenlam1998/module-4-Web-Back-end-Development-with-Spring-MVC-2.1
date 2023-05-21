package com.example.pictureoftheday.service;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T> {
    List<T> findAll();
    T findById(Long id) throws Exception;

    void save(T t);

    void remove(Long id);
}
