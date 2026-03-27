package com.filmrental.FilmRental.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "film")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @Column(name = "film_id")
    private Short filmId;

    private String title;

    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "language_id")
    private Byte languageId;

    @Column(name = "original_language_id")
    private Byte originalLanguageId;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private Double rentalRate;

    private Integer length;

    @Column(name = "replacement_cost")
    private Double replacementCost;

    private String rating;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}