package com.cinema.shop.repository;

import com.cinema.shop.model.Film;
import com.cinema.shop.model.FilmMapper;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FilmRepository {

        private final int COUNT_OF_ELEMENTS=20;
        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Transactional(readOnly=true)
        public List<Film> findPageableFilm(Integer page) {
            String sql="select * from Film limit "
                    + COUNT_OF_ELEMENTS
                    + " offset "
                    + (page-1)*COUNT_OF_ELEMENTS;
            return jdbcTemplate.query(sql,
                    new FilmMapper());
        }
    @Transactional(readOnly=true)
    public Film findFilmById(Integer id) {
        //

        return  jdbcTemplate.queryForObject("select * from Film where film_id=?",new FilmMapper(),id);
    }

    }
