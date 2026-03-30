package com.filmrental.FilmRental.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "film")

@Data                   // getters + setters + toString + equals + hashCode
@NoArgsConstructor      // default constructor
@AllArgsConstructor     // all fields constructor

public class Film {

    @Id
    @Column(name = "film_id")
    private Short filmId;

    @Column(name = "title")
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

    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    private List<FilmCategory> filmCategories;
}