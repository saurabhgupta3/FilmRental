package com.filmrental.FilmRental.controller;

import com.filmrental.FilmRental.dto.StoreInventoryDTO;
import com.filmrental.FilmRental.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/{id}/inventory")
    public List<StoreInventoryDTO> getStoreInventory(@PathVariable("id") Byte storeId) {
        return storeService.getStoreInventory(storeId);
    }
}