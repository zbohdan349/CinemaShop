package com.cinema.shop.controller;

import com.cinema.shop.model.Film;
import com.cinema.shop.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/films")
    public List<Film> getFilms(@RequestParam Integer page){

        return filmRepository.findPageableFilm(page);

    }
    @GetMapping("/films/{id}")
    public Film getFilmById(@PathVariable Integer id){

        return filmRepository.findFilmById(id);
    }

}
