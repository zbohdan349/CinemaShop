package com.cinema.shop.servise;

import com.cinema.shop.model.Film;
import com.cinema.shop.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final int COUNT_OF_ELEMENTS_ON_PAGE = 20;
    @Autowired
    private FilmRepository filmRepository;

    public Optional<Film> getFilmById(Integer id){
        return filmRepository.findById(id);
    }

    public List<Film> getAllPageable(Integer page){
       return  filmRepository.findAll(PageRequest.of(page-1,COUNT_OF_ELEMENTS_ON_PAGE)).toList();
    }


}
