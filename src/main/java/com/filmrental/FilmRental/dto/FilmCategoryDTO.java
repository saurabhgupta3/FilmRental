package com.filmrental.FilmRental.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class FilmCategoryDTO {

    private Short filmId;
    private String title;
    private Byte categoryId;
    private String categoryName;
    private Integer releaseYear;
}