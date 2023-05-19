package com.example.upload_music_service.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class MusicForm {
    private int id;
    private String name;
    private String singer;
    private List<TypeMusic> type;
    private MultipartFile musicFile;

    public MusicForm() {
    }

    public MusicForm(int id, String name, String singer, List<TypeMusic> type, MultipartFile musicFile) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.musicFile = musicFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public List<TypeMusic> getType() {
        return type;
    }

    public void setType(List<TypeMusic> type) {
        this.type = type;
    }

    public MultipartFile getMusicFile() {
        return musicFile;
    }

    public void setMusicFile(MultipartFile musicFile) {
        this.musicFile = musicFile;
    }
}
