package com.filmrental.FilmRental.service;

import java.util.List;

import com.filmrental.FilmRental.model.Film;

public interface FilmService {
	List<Film> getAllFilms();
    List<Film> getFilmByTitle(String title);
    Film getFilmById(Short filmId);
    List<Object[]> getFilmActorsByFilmId(Short filmId);
}
