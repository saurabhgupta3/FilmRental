package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.StoreInventoryDTO;
import com.filmrental.FilmRental.exception.MissingFieldException;
import com.filmrental.FilmRental.exception.ResourceNotFoundException;
import com.filmrental.FilmRental.repo.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final InventoryRepository inventoryRepository;

    public StoreServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<StoreInventoryDTO> getStoreInventory(Byte storeId) {

        if (storeId == null) {
            throw new MissingFieldException("Store ID is required");
        }

        List<StoreInventoryDTO> inventory = inventoryRepository.getStoreInventory(storeId);

        if (inventory.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No inventory found for store ID: " + storeId
            );
        }

        return inventory;
    }
}