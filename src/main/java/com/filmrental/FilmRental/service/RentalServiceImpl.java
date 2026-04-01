package com.filmrental.FilmRental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.filmrental.FilmRental.dto.CustomerRentalDTO;
import com.filmrental.FilmRental.dto.RentalStaffDTO;
import com.filmrental.FilmRental.exception.MissingFieldException;
import com.filmrental.FilmRental.exception.ResourceNotFoundException;
import com.filmrental.FilmRental.model.Rental;
import com.filmrental.FilmRental.repo.RentalRepository;

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
    @Override
    public List<CustomerRentalDTO> getRentalsByCustomerId(Short customerId) {
    	if (customerId == null) {
            throw new MissingFieldException("Customer ID is required");
        }
    	List<CustomerRentalDTO> rentals = rentalRepository.findRentalsByCustomerId(customerId);
    	if (rentals == null || rentals.isEmpty()) {
            throw new ResourceNotFoundException("No rentals found for customer ID: " + customerId);
        }

        return rentals;
    }
}