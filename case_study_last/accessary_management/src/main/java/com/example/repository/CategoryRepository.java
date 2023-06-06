package com.example.repository;

import com.example.model.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
    Iterable<Category> findAllByIsActiveTrue();
    @Query("from Category c where c.id = :id AND c.isActive = true ")
    Optional<Category> findByIdAndIsActiveTrue(@Param("id") Long id);
    @Modifying
    @Query("update Category c set c.isActive=false where c.id = :id")
    void updateByIsActiveFalse(@Param("id") Long id);
}
