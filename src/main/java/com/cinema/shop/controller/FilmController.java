package com.cinema.shop.controller;

import com.cinema.shop.model.Film;
import com.cinema.shop.model.requestData.FilterRequest;
import com.cinema.shop.servise.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
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

    @GetMapping (value = "/sid")
    public ResponseEntity<byte[]> getImage() throws IOException {

        Map<String,Object> map = new HashMap<>();

        var imgFile = new ClassPathResource("images/1.jpg");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
        map.put("img",bytes);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
}
