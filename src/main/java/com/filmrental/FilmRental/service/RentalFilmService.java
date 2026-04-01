package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.RentalFilmDetailsDTO;

import java.util.List;

public interface RentalFilmService {

    List<RentalFilmDetailsDTO> getRentalFilmDetails();
}
