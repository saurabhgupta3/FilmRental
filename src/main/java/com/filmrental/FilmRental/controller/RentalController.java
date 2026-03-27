package com.filmrental.FilmRental.controller;

import com.filmrental.FilmRental.model.Rental;
import com.filmrental.FilmRental.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }
    @GetMapping
    public List<Rental> getRentals() {return rentalService.getAllRentals();}


}