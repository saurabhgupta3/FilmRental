package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.StoreInventoryDTO;
import java.util.List;

public interface StoreService {

    List<StoreInventoryDTO> getStoreInventory(Byte storeId);
}