package com.filmrental.FilmRental.repo;

import com.filmrental.FilmRental.dto.RentalStaffDTO;
import com.filmrental.FilmRental.model.Rental;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {

    @Query("""
        SELECT new com.filmrental.FilmRental.dto.RentalStaffDTO(
            r.rentalId,
            r.rentalDate,
            s.staffId,
            s.firstName,
            s.lastName
        )
        FROM Rental r
        JOIN r.staff s
    """)
    List<RentalStaffDTO> getRentalWithStaff();
}