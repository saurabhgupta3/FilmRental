package com.filmrental.FilmRental.controller;

import com.filmrental.FilmRental.exception.ResourceNotFoundException;
import com.filmrental.FilmRental.model.Actor;
import com.filmrental.FilmRental.model.Film;
import com.filmrental.FilmRental.model.FilmActor;
import com.filmrental.FilmRental.model.FilmActorId;
import com.filmrental.FilmRental.repo.FilmActorRepository;
import com.filmrental.FilmRental.repo.FilmRepo;

import com.filmrental.FilmRental.service.FilmServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FilmServiceImplTest {

    @Mock
    private FilmRepo filmRepo;

    @Mock
    private FilmActorRepository filmActorRepository;

    @InjectMocks
    private FilmServiceImpl filmService;

    // =========================================
    // ✅ 1. getFilmById()
    // =========================================

    @Test
    void testGetFilmById_Success() {

        Short filmId = 1;

        Film film = new Film();
        film.setFilmId(filmId);
        film.setTitle("Inception");

        when(filmRepo.findByFilmId(filmId))
                .thenReturn(Optional.of(film));

        Film result = filmService.getFilmById(filmId);

        assertNotNull(result);
        assertEquals("Inception", result.getTitle());

        verify(filmRepo, times(1)).findByFilmId(filmId);
    }

    @Test
    void testGetFilmById_NotFound() {

        Short filmId = 1;

        when(filmRepo.findByFilmId(filmId))
                .thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> filmService.getFilmById(filmId)
        );

        assertEquals("404 NOT_FOUND \"Film not found\"", exception.getMessage());

        verify(filmRepo, times(1)).findByFilmId(filmId);
    }

    // =========================================
    // ✅ 2. getFilmActorsByFilmId()
    // =========================================

    @Test
    void testGetFilmActorsByFilmId_Success() {

        Short filmId = 1;

        // Film
        Film film = new Film();
        film.setFilmId(filmId);
        film.setTitle("Avatar");

        // Actor
        Actor actor = new Actor();
        actor.setActorId((short)10);
        actor.setFirstName("Sam");
        actor.setLastName("Worthington");

        // FilmActor
        FilmActor filmActor = new FilmActor();
        filmActor.setFilm(film);
        filmActor.setActor(actor);
        filmActor.setId(new FilmActorId(filmId, (short)10));

        when(filmRepo.findByFilmId(filmId))
                .thenReturn(Optional.of(film));

        when(filmActorRepository.findByFilm_FilmId(filmId))
                .thenReturn(List.of(filmActor));

        List<Object[]> result =
                filmService.getFilmActorsByFilmId(filmId);

        assertNotNull(result);
        assertEquals(1, result.size());

        Object[] row = result.get(0);

        assertEquals(filmId, row[0]);              // filmId
        assertEquals("Avatar", row[1]);            // title
        assertEquals((short)10, row[2]);           // actorId
        assertEquals("Sam", row[3]);               // firstName
        assertEquals("Worthington", row[4]);       // lastName

        verify(filmRepo, times(1)).findByFilmId(filmId);
        verify(filmActorRepository, times(1))
                .findByFilm_FilmId(filmId);
    }

    @Test
    void testGetFilmActorsByFilmId_FilmNotFound() {

        Short filmId = 1;

        when(filmRepo.findByFilmId(filmId))
                .thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> filmService.getFilmActorsByFilmId(filmId)
        );

        assertEquals(
                "Film not found with id: " + filmId,
                exception.getMessage()
        );

        verify(filmRepo, times(1)).findByFilmId(filmId);
        verify(filmActorRepository, never())
                .findByFilm_FilmId(any());
    }

    @Test
    void testGetFilmActorsByFilmId_NoActorsFound() {

        Short filmId = 1;

        Film film = new Film();
        film.setFilmId(filmId);
        film.setTitle("Avatar");

        when(filmRepo.findByFilmId(filmId))
                .thenReturn(Optional.of(film));

        when(filmActorRepository.findByFilm_FilmId(filmId))
                .thenReturn(List.of());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> filmService.getFilmActorsByFilmId(filmId)
        );

        assertEquals(
                "No actors found for film id: " + filmId,
                exception.getMessage()
        );

        verify(filmRepo, times(1)).findByFilmId(filmId);
        verify(filmActorRepository, times(1))
                .findByFilm_FilmId(filmId);
    }
}
