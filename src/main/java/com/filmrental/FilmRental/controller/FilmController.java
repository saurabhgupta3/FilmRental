package com.filmrental.FilmRental.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.FilmRental.model.Film;
import com.filmrental.FilmRental.service.FilmService;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/search")
    public List<Film> getFilmByTitle(@RequestParam String title) {
        return filmService.getFilmByTitle(title);
    }
}