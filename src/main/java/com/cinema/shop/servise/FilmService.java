package com.cinema.shop.servise;

import com.cinema.shop.exception.NotFoundException;
import com.cinema.shop.model.Film;
import com.cinema.shop.model.Rating;
import com.cinema.shop.model.dto.FilmDto;
import com.cinema.shop.repository.CategoryRepository;
import com.cinema.shop.repository.FilmRepository;
import com.cinema.shop.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FilmService {
    private final int COUNT_OF_ELEMENTS_ON_PAGE = 20;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private FilmRepository filmRepository;
    public Film getFilmById(Integer id){
      Film film = filmRepository.findById(id).orElseThrow(
              ()-> new NotFoundException("Film with ID: "+ id + " not found"));
      return film;
    }

    public Map<String,Object> getAllPageable(Integer page) {
        --page;
        Page<Film> films = filmRepository.findAll(PageRequest.of(page,COUNT_OF_ELEMENTS_ON_PAGE));

        if(films.getTotalElements()<1)throw new NotFoundException("Movies with these parameters not found");

        if(films.getTotalPages()<=page)throw new NotFoundException("Incorrect page number");

        Map<String,Object> filmMap =new HashMap<>();
        filmMap.put("Count of pages",films.getTotalPages());
        filmMap.put("Count of elements", films.getTotalElements());
        filmMap.put("Films",convert(films.toList()));
        return filmMap;
    }
    public Map<String,Object> getFilterCategories(){
        Map<String,Object> filterCategoryMap =new HashMap<>();
        filterCategoryMap.put("Languages",languageRepository.findAll());
        filterCategoryMap.put("Rating", Rating.values());
        filterCategoryMap.put("Categories",categoryRepository.findAll());
        filterCategoryMap.put("Max price",filmRepository.findMaxPrice());
        filterCategoryMap.put("Min price",filmRepository.findMinPrice());

        return filterCategoryMap;
    }


    private List<FilmDto> convert(List<Film> films){
        Function<Film, FilmDto> change = film -> {
            FilmDto dto = new FilmDto();
            dto.setBuyRate(film.getBuyRate());
            dto.setCategories(film.getCategories());
            dto.setId(film.getId());
            dto.setLanguage(film.getLanguage());
            dto.setDescription(film.getDescription());
            dto.setTitle(film.getTitle());
            dto.setYear(film.getYear());
            dto.setRentalRate(film.getRentalRate());
            dto.setRating(film.getRating());
            return dto;
        };
        return films.stream().map(change).collect(Collectors.toList());
    }
}
