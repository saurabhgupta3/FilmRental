package com.filmrental.FilmRental.controller;

import com.filmrental.FilmRental.dto.RentalFilmDetailsDTO;
import com.filmrental.FilmRental.service.RentalFilmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalFilmController {

    private final RentalFilmService rentalFilmService;

    public RentalFilmController(RentalFilmService rentalFilmService) {
        this.rentalFilmService = rentalFilmService;
    }

    @GetMapping("/films")
    public List<RentalFilmDetailsDTO> getRentalFilmDetails() {
        return rentalFilmService.getRentalFilmDetails();
    }
}
