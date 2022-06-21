package com.cinema.shop.servise;

import com.cinema.shop.exception.NotFoundException;
import com.cinema.shop.model.Film;
import com.cinema.shop.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FilmService {

    private final int COUNT_OF_ELEMENTS_ON_PAGE = 20;
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
        filmMap.put("Films",films.toList());
        return filmMap;
    }


}
