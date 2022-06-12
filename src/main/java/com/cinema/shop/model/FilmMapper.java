package com.cinema.shop.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper implements RowMapper<Film> {
    @Override
    public Film mapRow(ResultSet rs, int rowNum) throws SQLException {

        Film film =new Film();

        film.setId(rs.getInt("film_id"));
        film.setTitle(rs.getString("title"));
        film.setDescription(rs.getString("description"));

        return film;
    }
}
