package com.filmrental.FilmRental.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.filmrental.FilmRental.model.Film;
import com.filmrental.FilmRental.repo.FilmRepo;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepo filmRepository;

    public FilmServiceImpl(FilmRepo filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public List<Film> getFilmByTitle(String title) {
        return filmRepository.findByTitle(title);
    }

    @Override
    public Film getFilmById(Short filmId) {
        return filmRepository.findByFilmId(filmId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Film not found"));
    }
}
