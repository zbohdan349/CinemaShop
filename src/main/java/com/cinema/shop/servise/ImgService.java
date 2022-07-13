package com.cinema.shop.servise;

import com.cinema.shop.model.Film;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImgService {

    private static final String IMG_URL ="http://localhost:8080/img/";
    private static final String DEFAULT_IMG_PATH ="images/default.jpg";
    private static final String ROOT_FOLDER ="images/";
    private static final String FILM_IMG ="/film_img.jpg";

    public ImgService() {
    }

    public Film addImgUrlToFilm(Film film){
        film.setImgUrl(IMG_URL+film.getId());
        return film;
    }
    public Page<Film>addImgToFilms(Page<Film> list){

        list.stream().forEach(film -> film.setImgUrl(IMG_URL+film.getId()));
        return list;
    }

    public byte[] getSingleImage(Integer id) throws IOException {

        ClassPathResource imgFile = new ClassPathResource(ROOT_FOLDER+id+FILM_IMG);

        if(imgFile.exists())
            return StreamUtils.copyToByteArray(imgFile.getInputStream());

        imgFile = new ClassPathResource(DEFAULT_IMG_PATH);
        return StreamUtils.copyToByteArray(imgFile.getInputStream());
    }
}
