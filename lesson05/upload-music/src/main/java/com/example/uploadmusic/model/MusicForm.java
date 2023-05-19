package com.example.uploadmusic.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private Long id;
    private String name;
    private String singer;
    private String type;
    private MultipartFile musicFile;

    public MusicForm() {
    }

    public MusicForm(Long id, String name, String singer, String type, MultipartFile musicFile) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.musicFile = musicFile;
    }

    public MusicForm(String name, String singer, String type, MultipartFile musicFile) {
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.musicFile = musicFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MultipartFile getMusicFile() {
        return musicFile;
    }

    public void setMusicFile(MultipartFile musicFile) {
        this.musicFile = musicFile;
    }
}
