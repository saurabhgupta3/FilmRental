package com.filmrental.FilmRental.repo;


import com.filmrental.FilmRental.model.FilmActor;
import com.filmrental.FilmRental.model.FilmActorId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId> {

    List<FilmActor> findByFilm_FilmId(Short filmId);
}