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
    private final int COUNT_OF_ELEMENTS_ON_PAGE = 21;
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

    public Map<String,Object> getAllFilm(Integer page) {
        Page<Film> films = filmRepository.findAll(PageRequest.of(--page,COUNT_OF_ELEMENTS_ON_PAGE));
        return getPageable(films,page);
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
    public Map<String,Object> getFilmByTitle(String title, Integer page){
        Page<Film> films = filmRepository.findByTitleContains(title,PageRequest.of(--page,COUNT_OF_ELEMENTS_ON_PAGE));
        return getPageable(films,page);
    }

    private Map<String,Object> getPageable(Page<Film> films,Integer page){
        if(films.getTotalElements()<1)throw new NotFoundException("Movies with these parameters not found");

        if(films.getTotalPages()<=page)throw new NotFoundException("Incorrect page number");

        Map<String,Object> filmMap =new HashMap<>();
        filmMap.put("Count of pages",films.getTotalPages());
        filmMap.put("Count of elements", films.getTotalElements());
        filmMap.put("Films",convertToDto(films.toList()));
        return filmMap;
    }
    private List<FilmDto> convertToDto(List<Film> films){
        Function<Film, FilmDto> change = film -> {
            FilmDto dto = new FilmDto();

            return (FilmDto) MappingUtils.map(dto,film);
        };
        return films.stream().map(change).collect(Collectors.toList());
    }
}
