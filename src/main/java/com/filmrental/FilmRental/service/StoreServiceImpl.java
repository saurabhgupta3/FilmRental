package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.StoreInventoryDTO;
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
        return inventoryRepository.getStoreInventory(storeId);
    }
}