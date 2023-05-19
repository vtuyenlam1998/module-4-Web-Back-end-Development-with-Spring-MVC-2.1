package com.example.uploadmusic.service;

import com.example.uploadmusic.model.MusicForm;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();

    MusicForm findByIdMusic(Long id) throws Exception;

    void save(MusicForm musicForm);

    void remove(Long id);
}
