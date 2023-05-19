package com.example.uploadmusic.controller;

import com.example.uploadmusic.model.Music;
import com.example.uploadmusic.model.MusicForm;
import com.example.uploadmusic.model.TypeMusic;
import com.example.uploadmusic.service.UploadMusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/music")
public class UploadMusicController {
    private final UploadMusicService musicService;

    public UploadMusicController(UploadMusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Music> musics = musicService.findAll();
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
        musicService.save(musicForm);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("musicForm", new MusicForm());
        modelAndView.addObject("typeMusic", Arrays.stream(TypeMusic.values()).toArray());

        modelAndView.addObject("message", "Created new music successfully");
        return modelAndView;
    }

    @PostMapping(value = "/edit-music")
    public ModelAndView editMusic(@ModelAttribute MusicForm musicForm) {
        musicService.save(musicForm);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("musicForm", musicForm);
        modelAndView.addObject("typeMusic", Arrays.stream(TypeMusic.values()).toArray());
        modelAndView.addObject("message", "Edited music successfully");
        return modelAndView;
    }

    @GetMapping("/edit-music/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) throws Exception {
        MusicForm musicForm = musicService.findByIdMusic(id);
        if (musicForm != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("musicForm", musicForm);
            modelAndView.addObject("typeMusic", Arrays.stream(TypeMusic.values()).toArray());
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @GetMapping("/delete-music/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) throws Exception {
        MusicForm musicForm = musicService.findByIdMusic(id);
        if (musicForm != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("musicForm", musicForm);
            modelAndView.addObject("typeMusic", Arrays.stream(TypeMusic.values()).toArray());
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }

    @PostMapping("/delete-music")
    public String deleteMusic(@ModelAttribute MusicForm musicForm, RedirectAttributes redirectAttributes) {
        musicService.remove(musicForm.getId());
        redirectAttributes.addFlashAttribute("message", "Music has been deleted!");
        return "redirect:/music";
    }
    @GetMapping("/view/{id}")
    public ModelAndView showDetailForm(@PathVariable Long id) throws Exception {
        MusicForm musicForm = musicService.findByIdMusic(id);
        if (musicForm != null) {
            ModelAndView modelAndView = new ModelAndView("view");
            modelAndView.addObject("musicForm", musicForm);
            modelAndView.addObject("typeMusic", Arrays.stream(TypeMusic.values()).toArray());
            return modelAndView;
        } else {
            return new ModelAndView("error404");
        }
    }
}

