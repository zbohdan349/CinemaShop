package com.cinema.shop.repository;

import com.cinema.shop.model.Film;
import com.cinema.shop.model.FilmMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;

@Repository
public class FilmRepository {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @Transactional(readOnly=true)
        public List<Film> findAll() {
            return jdbcTemplate.query("select * from Film",
                    new FilmMapper());
        }
    @Transactional(readOnly=true)
    public Film findFilmById(Integer id) {
        //

        return  jdbcTemplate.queryForObject("select * from Film where film_id=?",new FilmMapper(),id);
    }

    }
