package com.cinema.shop.controller;

import com.cinema.shop.model.Film;
import com.cinema.shop.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;


    @GetMapping("/films")
    public List<Film> getFilms(@RequestParam Integer page){

        return (List<Film>) filmRepository.findAll();

    }

    @GetMapping("/films/{id}")
    public Optional<Film> getFilmById(@PathVariable Integer id){

        return filmRepository.findById(id);
    }


}
