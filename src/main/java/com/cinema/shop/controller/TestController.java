package com.cinema.shop.controller;

import com.cinema.shop.model.Film;
import com.cinema.shop.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TestController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping("/films")
    public List<Film> getFilms(){

        return filmRepository.findAll();

    }
    @GetMapping("/films/{id}")
    public Film getFilmById(@PathVariable Integer id){

        return filmRepository.findFilmById(id);
    }

}
