package com.filmrental.FilmRental.model;


import jakarta.persistence.Embeddable;
import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmActorId implements Serializable {

    @Column(name = "film_id")
    private Short filmId;

    @Column(name = "actor_id")
    private Short actorId;
}