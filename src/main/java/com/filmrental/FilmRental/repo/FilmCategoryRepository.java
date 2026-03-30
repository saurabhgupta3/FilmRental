package com.filmrental.FilmRental.repo;

import com.filmrental.FilmRental.dto.FilmCategoryDTO;
import com.filmrental.FilmRental.model.FilmCategory;
import com.filmrental.FilmRental.model.FilmCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmCategoryRepository
        extends JpaRepository<FilmCategory, FilmCategoryId> {

    @Query("""
        SELECT new com.filmrental.FilmRental.dto.FilmCategoryDTO(
            f.filmId,
            f.title,
            c.categoryId,
            c.name,
            f.releaseYear
        )
        FROM FilmCategory fc
        JOIN fc.film f
        JOIN fc.category c
        WHERE f.filmId = :filmId
    """)
    List<FilmCategoryDTO> findCategoriesByFilmId(Short filmId);
}