package com.cinema.shop.servise;

import com.cinema.shop.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ImgService {

    private static final String IMG_URL ="http://localhost:8080/sid";

    public ImgService() {
    }

    public Film addImgUrlToFilm(Film film){
        film.setImgUrl(IMG_URL);
        return film;
    }
    public Page<Film>addImgToFilms(Page<Film> list){

        list.stream().forEach(film -> film.setImgUrl(IMG_URL));
        return list;
    }

}
