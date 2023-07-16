package com.example.repository;

import com.example.model.Variant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VariantRepository extends CrudRepository<Variant,Long>, PagingAndSortingRepository<Variant,Long> {
    Iterable<Variant> findAllByIsActiveTrue();

    @Query("from Variant v where v.id = :id AND v.isActive = true ")
    Optional<Variant> findByIdAndIsActiveTrue(@Param("id") Long id);
    @Modifying
    @Query("update Variant v set v.isActive=false where v.id = :id")
    void updateByIsActiveFalse(@Param("id") Long id);
}
