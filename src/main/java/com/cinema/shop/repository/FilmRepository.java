package com.cinema.shop.repository;

import com.cinema.shop.model.Film;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FilmRepository extends PagingAndSortingRepository<Film,Integer> {
}
