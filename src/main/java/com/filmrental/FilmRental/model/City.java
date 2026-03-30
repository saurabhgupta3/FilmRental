package com.filmrental.FilmRental.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @Column(name = "city_id")
    private Short cityId; // SMALLINT → Short

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    // MANY city → ONE country
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}