package com.example.upload_music_service.model;

import java.util.List;

public class Music {
    private int id;
    private String name;
    private String singer;
    private List<TypeMusic> type;
    private String musicFile;

    public Music() {
    }

    public Music(int id, String name, String singer, List<TypeMusic> type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public Music(int id, String name, String singer, List<TypeMusic> type, String musicFile) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.musicFile = musicFile;
    }

    public String getMusicFile() {
        return musicFile;
    }

    public void setMusicFile(String musicFile) {
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
}
