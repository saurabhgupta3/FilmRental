package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.RentalFilmDetailsDTO;
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
        return rentalFilmRepository.findRentalFilmDetails();
    }
}
