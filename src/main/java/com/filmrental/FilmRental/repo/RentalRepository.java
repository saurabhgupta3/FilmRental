package com.filmrental.FilmRental.repo;

import com.filmrental.FilmRental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
