package com.filmrental.FilmRental.repo;

import com.filmrental.FilmRental.dto.StoreInventoryDTO;
import com.filmrental.FilmRental.model.Inventory;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Query("""
        SELECT new com.filmrental.FilmRental.dto.StoreInventoryDTO(
            s.storeId,
            i.inventoryId,
            f.filmId,
            f.title,
            i.lastUpdate
        )
        FROM Inventory i
        JOIN i.store s
        JOIN i.film f
        WHERE s.storeId = :storeId
    """)
    List<StoreInventoryDTO> getStoreInventory(Byte storeId);
}