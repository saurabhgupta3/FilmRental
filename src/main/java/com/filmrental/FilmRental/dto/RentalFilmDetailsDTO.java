package com.filmrental.FilmRental.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RentalFilmDetailsDTO {

    private final Integer rentalId;
    private final LocalDateTime rentalDate;
    private final Short filmId;
    private final String title;
    private final LocalDateTime returnDate;

    public RentalFilmDetailsDTO(Integer rentalId,
                                LocalDateTime rentalDate,
                                Short filmId,
                                String title,
                                LocalDateTime returnDate) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.filmId = filmId;
        this.title = title;
        this.returnDate = returnDate;
    }
}
