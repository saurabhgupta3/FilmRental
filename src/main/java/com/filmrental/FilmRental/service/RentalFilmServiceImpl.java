package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.RentalFilmDetailsDTO;
import com.filmrental.FilmRental.exception.ResourceNotFoundException;
import com.filmrental.FilmRental.repo.RentalFilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalFilmServiceImpl implements RentalFilmService {

    private final RentalFilmRepository rentalFilmRepository;

    public RentalFilmServiceImpl(RentalFilmRepository rentalFilmRepository) {
        this.rentalFilmRepository = rentalFilmRepository;
    }

    @Override
    public List<RentalFilmDetailsDTO> getRentalFilmDetails() {

        List<RentalFilmDetailsDTO> result = rentalFilmRepository.findRentalFilmDetails();

        // Simple exception handling
        if (result == null || result.isEmpty()) {
            throw new ResourceNotFoundException("No rental film details found");
        }

        return result;
    }
}
