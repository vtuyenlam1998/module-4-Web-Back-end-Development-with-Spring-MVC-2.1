package com.example.uploadmusic.repository;

import com.example.uploadmusic.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UploadMusicRepository {
    List<Music> findAll();

    Music findById(Long id);

    void save(Music music);

    void delete(Long id);

//    @Modifying
//    @Query("UPDATE Music m SET m.isActive = false where m.id=:id")
//    Music softDeleteJPQL(@Param("id") Long id);
//
//    @Query(nativeQuery = true, value = "UPDATE music m SET m.is_active = false WHERE m.id=:id")
//    void softDeleteSQL(@Param("id") Long id);
//
//    @Query("select m from Music  m where m.isActive = true")
//    List<Music> findAllByIsActiveIsTrue();

}
