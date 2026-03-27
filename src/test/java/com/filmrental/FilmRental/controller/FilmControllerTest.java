package com.filmrental.FilmRental.controller;

import com.filmrental.FilmRental.model.Film;
import com.filmrental.FilmRental.service.FilmService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FilmController.class)
class FilmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmService filmService;

    @Test
    void getFilmByIdReturnsFilm() throws Exception {
        Film film = new Film();
        film.setFilmId(1L);
        film.setTitle("ACADEMY DINOSAUR");

        when(filmService.getFilmById(1L)).thenReturn(film);

        mockMvc.perform(get("/films/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.filmId").value(1))
                .andExpect(jsonPath("$.title").value("ACADEMY DINOSAUR"));
    }
}
