package com.filmrental.FilmRental.service;

import java.util.ArrayList;
import java.util.List;

import com.filmrental.FilmRental.model.FilmActor;
import com.filmrental.FilmRental.repo.FilmActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.filmrental.FilmRental.model.Film;
import com.filmrental.FilmRental.repo.FilmRepo;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepo filmRepository;

    @Autowired
    private FilmActorRepository filmActorRepository;

    public FilmServiceImpl(FilmRepo filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public List<Film> getFilmByTitle(String title) {
        return filmRepository.findByTitle(title);
    }

    @Override
    public Film getFilmById(Short filmId) {
        return filmRepository.findByFilmId(filmId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Film not found"));
    }


    @Override
    public List<Object[]> getFilmActorsByFilmId(Short filmId) {

        List<FilmActor> filmActors = filmActorRepository.findByFilm_FilmId(filmId);

        List<Object[]> response = new ArrayList<>();

        for (FilmActor filmActor : filmActors) {
            response.add(new Object[]{
                    filmActor.getFilm().getFilmId(),
                    filmActor.getFilm().getTitle(),
                    filmActor.getActor().getActorId(),
                    filmActor.getActor().getFirstName(),
                    filmActor.getActor().getLastName()
            });
        }
       return response;
    }
}