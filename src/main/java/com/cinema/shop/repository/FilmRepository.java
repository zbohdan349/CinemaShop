package com.cinema.shop.repository;

import com.cinema.shop.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film,Integer> {
    Page<Film> findAll(Pageable pageable);

    Page<Film>findByTitleContains(String title,Pageable pageable);

    @Query("SELECT max(buyRate) FROM Film")
    long findMaxPrice();

    @Query("SELECT min(buyRate) FROM Film")
    long findMinPrice();


}
