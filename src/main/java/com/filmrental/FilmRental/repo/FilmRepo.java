package com.filmrental.FilmRental.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.filmrental.FilmRental.model.Film;

public interface FilmRepo extends JpaRepository<Film, Long> {
}