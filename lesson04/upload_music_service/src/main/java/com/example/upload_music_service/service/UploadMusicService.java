package com.example.upload_music_service.service;

import com.example.upload_music_service.model.Music;

import java.util.List;

public interface UploadMusicService {
    void addMusic(Music music);
    List<Music> showAllMusic();
}
