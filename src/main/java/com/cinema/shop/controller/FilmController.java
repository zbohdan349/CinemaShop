package com.cinema.shop.controller;

import com.cinema.shop.model.Film;
import com.cinema.shop.repository.FilmRepository;
import com.cinema.shop.servise.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;


    @GetMapping("/films")
    public Map<String, Object> getFilms(@RequestParam Integer page) throws Exception {

        return filmService.getAllPageable(page);

    }

    @GetMapping("/films/{id}")
    public Film getFilmById(@PathVariable Integer id){


        return filmService.getFilmById(id);
    }


}
