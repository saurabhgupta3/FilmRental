package com.filmrental.FilmRental.repo;

import com.filmrental.FilmRental.dto.RentalFilmDetailsDTO;
import com.filmrental.FilmRental.model.RentalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalFilmRepository extends JpaRepository<RentalRecord, Integer> {

    @Query("""
        SELECT new com.filmrental.FilmRental.dto.RentalFilmDetailsDTO(
            r.rentalId,
            r.rentalDate,
            f.filmId,
            f.title,
            r.returnDate
        )
        FROM RentalRecord r
        JOIN r.inventory i
        JOIN i.film f
        ORDER BY r.rentalId
        """)
    List<RentalFilmDetailsDTO> findRentalFilmDetails();
}
