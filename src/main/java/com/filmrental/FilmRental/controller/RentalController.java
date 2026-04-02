package com.filmrental.FilmRental.controller;

import com.filmrental.FilmRental.dto.RentalStaffDTO;
import com.filmrental.FilmRental.model.Rental;
import com.filmrental.FilmRental.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    // Existing API (optional if you already have)
    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    // NEW API
    @GetMapping("/staff")
    public List<RentalStaffDTO> getRentalWithStaff() {
        return rentalService.getRentalStaffDetails();
    }
}