package com.example.uploadmusic.service.impl;

import com.example.uploadmusic.model.Music;
import com.example.uploadmusic.model.MusicForm;
import com.example.uploadmusic.repository.UploadMusicRepository;
import com.example.uploadmusic.service.UploadMusicService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


@Service
public class UploadMusicServiceImpl implements UploadMusicService {
    private static final Set<String> fileTypes = new HashSet<>(Arrays.asList(".mp3", ".m4p", ".ogg", ".wav"));

    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private UploadMusicRepository uploadMusicRepository;

    @Override
    public List<Music> findAll() {
        return uploadMusicRepository.findAll();
    }

    @Override
    public MusicForm findByIdMusic(Long id) throws Exception {
        Music music = uploadMusicRepository.findById(id);
        if (music == null) {
            return null;
        } else {
            MusicForm musicForm = new MusicForm();
            musicForm.setId(music.getId());
            musicForm.setName(music.getName());
            musicForm.setSinger(music.getSinger());
            musicForm.setType(music.getType());
            //https://stackoverflow.com/questions/16648549/converting-file-to-multipartfile
            byte[] content = IOUtils.toByteArray(Files.newInputStream(Paths.get(fileUpload + music.getMusicFile())));
            MultipartFile multipartFile = new MockMultipartFile(
                    music.getMusicFile(), music.getMusicFile(), "audio/mp3", content);
            musicForm.setMusicFile(multipartFile);
            return musicForm;
        }
    }

    @Override
    public boolean save(MusicForm musicForm) throws IOException {
        MultipartFile multipartFile = musicForm.getMusicFile();
        String fileName = multipartFile.getOriginalFilename();
        assert fileName != null;
        if (isValidFile(fileName)) {
            FileCopyUtils.copy(musicForm.getMusicFile().getBytes(), new File(fileUpload + fileName));
            Music music = new Music(musicForm.getId(), musicForm.getName(), musicForm.getSinger(), musicForm.getType(), fileName);
            uploadMusicRepository.save(music);
            return true;
        }
        return false;
    }

    private boolean isValidFile(String fileName) {
        int indexOfFileType = fileName.lastIndexOf(".");
        String fileType = fileName.substring(indexOfFileType);
        return fileTypes.contains(fileType);
    }

    @Override
    public void remove(Long id) {
        uploadMusicRepository.delete(id);
    }

}
