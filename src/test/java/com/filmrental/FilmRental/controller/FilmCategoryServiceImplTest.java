package com.filmrental.FilmRental.controller;

import com.filmrental.FilmRental.dto.FilmCategoryDTO;
import com.filmrental.FilmRental.exception.ResourceNotFoundException;
import com.filmrental.FilmRental.repo.FilmCategoryRepository;

import com.filmrental.FilmRental.service.FilmCategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FilmCategoryServiceImplTest {

    @Mock
    private FilmCategoryRepository repository;

    @InjectMocks
    private FilmCategoryServiceImpl filmCategoryService;

    // ✅ Success Case
    @Test
    void testGetCategoriesByFilmId_Success() {

        Short filmId = 1;

        FilmCategoryDTO dto = new FilmCategoryDTO(
                filmId,
                "Inception",
                (byte)1,
                "Sci-Fi",
                2010
        );

        when(repository.findCategoriesByFilmId(filmId))
                .thenReturn(List.of(dto));

        List<FilmCategoryDTO> result =
                filmCategoryService.getCategoriesByFilmId(filmId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Sci-Fi", result.get(0).getCategoryName());

        verify(repository, times(1))
                .findCategoriesByFilmId(filmId);
    }

    // ❌ Empty List → Exception
    @Test
    void testGetCategoriesByFilmId_EmptyList() {

        Short filmId = 1;

        when(repository.findCategoriesByFilmId(filmId))
                .thenReturn(List.of());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> filmCategoryService.getCategoriesByFilmId(filmId)
        );

        assertEquals(
                "No categories found for film id: " + filmId,
                exception.getMessage()
        );

        verify(repository, times(1))
                .findCategoriesByFilmId(filmId);
    }
}