package com.cinema.shop.controller;

import com.cinema.shop.model.Film;
import com.cinema.shop.repository.FilmRepository;
import com.cinema.shop.servise.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;


    @GetMapping("/films")
    public List<Film> getFilms(@RequestParam Integer page){

        return filmService.getAllPageable(page);

    }

    @GetMapping("/films/{id}")
    public Optional<Film> getFilmById(@PathVariable Integer id){

        return filmService.getFilmById(id);
    }


}
