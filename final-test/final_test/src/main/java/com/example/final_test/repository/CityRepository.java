package com.example.final_test.repository;

import com.example.final_test.model.City;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface CityRepository extends PagingAndSortingRepository<City,Long>, CrudRepository<City,Long>, JpaRepository<City,Long> {
    Iterable<City> findByIsActiveTrue();

    @Query("from City c where c.id = :id AND c.isActive = true ")
    Optional<City> findByIdAndIsActiveTrue(@Param("id") Long id);
    @Modifying
    @Query("update City c set c.isActive=false where c.id = :id")
    void updateByIsActiveFalse(@Param("id") Long id);
}
