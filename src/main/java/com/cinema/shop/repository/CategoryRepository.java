package com.cinema.shop.repository;

import com.cinema.shop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query("Select c FROM Category c")
    Set<Category> findAllSet();
}
