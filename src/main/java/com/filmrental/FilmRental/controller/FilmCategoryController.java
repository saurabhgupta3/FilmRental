package com.filmrental.FilmRental.controller;

import com.filmrental.FilmRental.dto.FilmCategoryDTO;
import com.filmrental.FilmRental.service.FilmCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmCategoryController {

    private final FilmCategoryService service;

    public FilmCategoryController(FilmCategoryService service) {
        this.service = service;
    }

    @GetMapping("/{id}/categories")
    public List<FilmCategoryDTO> getFilmCategories(@PathVariable Short id) {
        return service.getCategoriesByFilmId(id);
    }
}
