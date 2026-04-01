package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.FilmCategoryDTO;
import com.filmrental.FilmRental.exception.ResourceNotFoundException;
import com.filmrental.FilmRental.repo.FilmCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmCategoryServiceImpl implements FilmCategoryService {

    private final FilmCategoryRepository repository;

    public FilmCategoryServiceImpl(FilmCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FilmCategoryDTO> getCategoriesByFilmId(Short filmId) {

        List<FilmCategoryDTO> categories = repository.findCategoriesByFilmId(filmId);

        if (categories.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No categories found for film id: " + filmId
            );
        }

        return categories;
    }
}