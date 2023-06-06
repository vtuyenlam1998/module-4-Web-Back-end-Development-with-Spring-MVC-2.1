package com.example.repository;

import com.example.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<User,Long>, CrudRepository<User,Long> {
    Iterable<User> findAllByIsActiveTrue();

    @Query("from User u where u.id = :id AND u.isActive = true ")
    Optional<User> findByIdAndIsActiveTrue(@Param("id") Long id);
    @Modifying
    @Query("update User u set u.isActive=false where u.id = :id")
    void updateByIsActiveFalse(@Param("id") Long id);
}
