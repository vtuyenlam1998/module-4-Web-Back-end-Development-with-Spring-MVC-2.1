package com.example.final_test.repository;

import com.example.final_test.model.City;
import com.example.final_test.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country,Long>, CrudRepository<Country,Long>, JpaRepository<Country,Long> {
    Iterable<Country> findByIsActiveTrue();

    @Query("from Country c where c.id = :id AND c.isActive = true ")
    Optional<Country> findByIdAndIsActiveTrue(@Param("id") Long id);
    @Modifying
    @Query("update Country c set c.isActive=false where c.id = :id")
    void updateByIsActiveFalse(@Param("id") Long id);
}
