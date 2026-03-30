package com.filmrental.FilmRental.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalStaffDTO {

    private Integer rentalId;
    private LocalDateTime rentalDate;
    private Byte staffId;
    private String firstName;
    private String lastName;
}