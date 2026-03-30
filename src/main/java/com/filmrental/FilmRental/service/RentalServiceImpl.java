package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.RentalStaffDTO;
import com.filmrental.FilmRental.model.Rental;
import com.filmrental.FilmRental.repo.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    // Existing method (UNCHANGED)
    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    // NEW METHOD
    @Override
    public List<RentalStaffDTO> getRentalStaffDetails() {
        return rentalRepository.getRentalWithStaff();
    }
}