package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Iterable<Product> findAllByIsActiveTrue();

    @Query("from Product p where p.id = :id AND p.isActive = true ")
    Optional<Product> findByIdAndIsActiveTrue(@Param("id") Long id);
    @Modifying
    @Query("update Product p set p.isActive=false where p.id = :id")
    void updateByIsActiveFalse(@Param("id") Long id);
}
