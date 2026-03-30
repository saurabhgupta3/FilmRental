package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.FilmCategoryDTO;

import java.util.List;

public interface FilmCategoryService {
    List<FilmCategoryDTO> getCategoriesByFilmId(Short filmId);
}