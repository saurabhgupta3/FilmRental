package com.filmrental.FilmRental.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffStoreDTO {

    private Byte staffId;
    private String firstName;
    private String lastName;
    private Byte storeId;
    private Short addressId;
}