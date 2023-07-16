package com.example.repository;

import com.example.model.Product;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
public interface ProductRepository extends PagingAndSortingRepository<Product,Long>, CrudRepository<Product,Long>, JpaRepository<Product,Long> {
    Iterable<Product> findByIsActiveTrue();

    @Query("from Product p where p.id = :id AND p.isActive = true ")
    Optional<Product> findByIdAndIsActiveTrue(@Param("id") Long id);
    @Modifying
    @Query("update Product p set p.isActive=false where p.id = :id")
    void updateByIsActiveFalse(@Param("id") Long id);

//    @Query("from Product p inner join ")

    Iterable<Product> findAllByNameContainsOrCategoryContains(String name, String category);

    @Query("SELECT p FROM Product p WHERE p.isActive = true AND (LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) OR LOWER(p.category.name) LIKE LOWER(CONCAT('%', :category, '%')))")
    Page<Product> findAllByIsActiveTrueAndNameContainsOrCategoryNameContains(String name, String category, Pageable pageInfo);

    Page<Product> findAllByIsActiveTrue(Pageable pageInfo);
}
