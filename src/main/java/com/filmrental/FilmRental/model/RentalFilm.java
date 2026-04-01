package com.filmrental.FilmRental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalFilm {

    @Id
    @Column(name = "film_id")
    private Short filmId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate", precision = 4, scale = 2)
    private BigDecimal rentalRate;

    @Column(name = "length")
    private Integer length;

    @Column(name = "replacement_cost", precision = 5, scale = 2)
    private BigDecimal replacementCost;

    @Column(name = "rating")
    private String rating;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @JsonIgnore
    @OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
    private List<RentalInventory> inventories = new ArrayList<>();
}
