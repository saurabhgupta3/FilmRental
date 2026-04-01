package com.filmrental.FilmRental.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.filmrental.FilmRental.dto.CustomerRentalDTO;
import com.filmrental.FilmRental.dto.RentalStaffDTO;
import com.filmrental.FilmRental.model.Rental;

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
    
    @Query("""
            SELECT new com.filmrental.FilmRental.dto.CustomerRentalDTO(
                r.rentalId,
                r.rentalDate,
                r.returnDate,
                s.firstName,
                s.lastName
            )
            FROM Rental r
            JOIN r.staff s
            WHERE r.customer.customerId = :customerId
        """)
        List<CustomerRentalDTO> findRentalsByCustomerId(Short customerId);
}