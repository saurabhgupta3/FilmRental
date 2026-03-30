package com.filmrental.FilmRental.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreInventoryDTO {

    private Byte storeId;
    private Integer inventoryId;
    private Short filmId;
    private String title;
    private LocalDateTime lastUpdate;
}