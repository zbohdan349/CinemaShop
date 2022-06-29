package com.cinema.shop.repository;

import com.cinema.shop.model.Category;
import com.cinema.shop.model.Film;
import com.cinema.shop.model.Language;
import com.cinema.shop.model.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film,Integer> {
    Page<Film> findAll(Pageable pageable);

    Page<Film>findByTitleContains(String title,Pageable pageable);

    @Query("SELECT max(buyRate) FROM Film")
    long findMaxPrice();

    @Query("SELECT min(buyRate) FROM Film")
    long findMinPrice();
    
    Page<Film>findByCategoriesInAndLanguageInAndRatingInAndBuyRateBetween(
            @Param("categories")List<Category> categories,
            @Param("languages")List<Language> languages,
            @Param("ratings")List<Rating> ratings,
            @Param("min") BigDecimal min,
            @Param("max") BigDecimal max,
            Pageable pageable);

    //findByCategoriesInAndLanguageIn

}
