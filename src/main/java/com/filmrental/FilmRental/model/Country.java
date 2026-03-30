package com.filmrental.FilmRental.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @Column(name = "country_id")
    private Short countryId; // SMALLINT → Short

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}