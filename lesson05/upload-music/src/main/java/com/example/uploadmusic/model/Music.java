package com.example.uploadmusic.model;


import javax.persistence.*;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String singer;
    private String type;
    private String musicFile;
//    @Column(name = "is_active")
//    private boolean isActive;

    public Music() {
    }

    public Music(String name, String singer, String type, String musicFile) {
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.musicFile = musicFile;
    }

    public Music(Long id, String name, String singer, String type, String musicFile) {
        this.id = id;
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

    public String getMusicFile() {
        return musicFile;
    }

    public void setMusicFile(String musicFile) {
        this.musicFile = musicFile;
    }
}
