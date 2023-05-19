package com.example.upload_music_service.controller;

import com.example.upload_music_service.model.Music;
import com.example.upload_music_service.model.MusicForm;
import com.example.upload_music_service.model.TypeMusic;
import com.example.upload_music_service.service.UploadMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/music")
public class UploadMusicController {
    @Autowired
    private UploadMusicService musicService;

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Music> musics = musicService.showAllMusic();
        modelAndView.addObject("musics", musics);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("musicForm", new MusicForm());
        modelAndView.addObject("typeMusic", Arrays.stream(TypeMusic.values()).toArray());
        return modelAndView;
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping("/save")
    public ModelAndView saveMusic(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getMusicFile();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getMusicFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Music music = new Music(musicForm.getId(), musicForm.getName(), musicForm.getSinger(), musicForm.getType(), fileName);
        musicService.addMusic(music);
        ModelAndView modelAndView =  new ModelAndView("/create");
        modelAndView.addObject("musicForm",musicForm);
        modelAndView.addObject("message","Created new music successfully");
        return modelAndView;
    }
}
