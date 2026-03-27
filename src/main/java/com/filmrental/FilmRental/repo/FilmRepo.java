package com.filmrental.FilmRental.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.FilmRental.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmRepo extends JpaRepository<Film, Long> {
    List<Film> findByTitle(String title);
    Optional<Film> findByFilmId(Long filmId);
}