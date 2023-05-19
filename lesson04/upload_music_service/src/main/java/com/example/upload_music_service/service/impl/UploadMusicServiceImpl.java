package com.example.upload_music_service.service.impl;

import com.example.upload_music_service.model.Music;
import com.example.upload_music_service.model.TypeMusic;
import com.example.upload_music_service.service.UploadMusicService;

import java.util.ArrayList;
import java.util.List;

public class UploadMusicServiceImpl implements UploadMusicService {
    private static List<Music> musicList = new ArrayList<>();
    static {
        List<TypeMusic> typeMusics = new ArrayList<>();
        typeMusics.add(TypeMusic.Jazz);
        typeMusics.add(TypeMusic.Pop);
        musicList.add(new Music(1,"Thái Dúi","Cô đơn trên sofa",typeMusics));
        musicList.add(new Music(2,"Thái Dơm","Cô đơn ở module 3",typeMusics));
    }
    @Override
    public void addMusic(Music music) {
        musicList.add(music);
    }

    @Override
    public List<Music> showAllMusic() {
        return musicList;
    }
}
