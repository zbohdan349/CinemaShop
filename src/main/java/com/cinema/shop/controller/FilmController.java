package com.cinema.shop.controller;

import com.cinema.shop.model.Film;
import com.cinema.shop.model.requestData.FilterRequest;
import com.cinema.shop.servise.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/films")
    public Map<String, Object> getFilms(@RequestParam Integer page) throws Exception {
        return filmService.getAllFilms(page);
    }
    @PostMapping("/films/filtered")
    public Map<String, Object> getFilteredFilms(@RequestBody FilterRequest request, @RequestParam Integer page) throws Exception {
        return filmService.getFilteredFilms(request,page);
    }

    @GetMapping("/films/{id}")
    public Film getFilmById(@PathVariable Integer id){
        return filmService.getFilmById(id);
    }

    @GetMapping("/films/title/{title}")
    public Map<String, Object> getFilmByTitle(@PathVariable String title,@RequestParam Integer page){
        return filmService.getFilmByTitle(title,page);
    }
    @GetMapping("/films/smallInfo/{title}")
    public List<String> getFilmSmallInfoByTitle(@PathVariable String title){
        return filmService.getFilmDtoByTitle(title);
    }

    @GetMapping("/filterCategories")
    public Map<String, Object> getFilterCategories(){
        return filmService.getFilterCategories();
    }
}
