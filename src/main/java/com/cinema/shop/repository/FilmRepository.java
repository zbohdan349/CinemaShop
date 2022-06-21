package com.cinema.shop.repository;

import com.cinema.shop.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FilmRepository extends PagingAndSortingRepository<Film,Integer> {
    Page<Film> findAll(Pageable pageable);

}
