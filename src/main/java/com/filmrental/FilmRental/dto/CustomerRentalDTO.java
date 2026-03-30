package com.filmrental.FilmRental.dto;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerRentalDTO {

    private Integer rentalId;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
    private String staffName;

    // Custom constructor for JPQL projection
    public CustomerRentalDTO(Integer rentalId, LocalDateTime rentalDate,
                             LocalDateTime returnDate,
                             String firstName, String lastName) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.staffName = firstName + " " + lastName;
    }
}