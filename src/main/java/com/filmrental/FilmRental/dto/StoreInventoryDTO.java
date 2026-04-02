package com.filmrental.FilmRental.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class StoreInventoryDTO {

    private Byte storeId;
    private Integer inventoryId;
    private Short filmId;
    private String title;
    private LocalDateTime lastUpdate;

    public StoreInventoryDTO(Byte storeId, Integer inventoryId, Short filmId, String title, LocalDateTime lastUpdate) {
        this.storeId = storeId;
        this.inventoryId = inventoryId;
        this.filmId = filmId;
        this.title = title;
        this.lastUpdate = lastUpdate;
    }
}