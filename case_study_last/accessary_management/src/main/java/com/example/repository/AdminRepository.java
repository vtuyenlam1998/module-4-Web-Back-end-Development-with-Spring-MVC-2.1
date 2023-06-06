package com.example.repository;

import com.example.model.Admin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AdminRepository extends PagingAndSortingRepository<Admin,Long> {
    Iterable<Admin> findAllByIsActiveTrue();

    @Query("from Admin a where a.id = :id AND a.isActive = true ")
    Optional<Admin> findByIdAndIsActiveTrue(@Param("id") Long id);
    @Modifying
    @Query("update Admin a set a.isActive=false where a.id = :id")
    void updateByIsActiveFalse(@Param("id") Long id);
}
