package com.filmrental.FilmRental.controller;


import com.filmrental.FilmRental.dto.StoreInventoryDTO;
import com.filmrental.FilmRental.exception.MissingFieldException;
import com.filmrental.FilmRental.exception.ResourceNotFoundException;
import com.filmrental.FilmRental.repo.InventoryRepository;
import com.filmrental.FilmRental.service.StoreServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StoreServiceImplTest {

    @Mock
    private InventoryRepository inventoryRepository;

    @InjectMocks
    private StoreServiceImpl storeService;

    // ✅ Positive Test Case
    @Test
    void testGetStoreInventory_Success() {
        Byte storeId = 1;

        StoreInventoryDTO dto = new StoreInventoryDTO(
                (byte)1,
                100,
                (short)10,
                "King Kong",
                LocalDateTime.now()
        );

        when(inventoryRepository.getStoreInventory(storeId))
                .thenReturn(List.of(dto));

        List<StoreInventoryDTO> result = storeService.getStoreInventory(storeId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("King Kong", result.get(0).getTitle());

        verify(inventoryRepository, times(1))
                .getStoreInventory(storeId);
    }

    // ❌ Negative Test Case: Null storeId
    @Test
    void testGetStoreInventory_NullStoreId() {

        MissingFieldException exception = assertThrows(
                MissingFieldException.class,
                () -> storeService.getStoreInventory(null)
        );

        assertEquals("Store ID is required", exception.getMessage());

        verify(inventoryRepository, never())
                .getStoreInventory(any());
    }

    // ❌ Negative Test Case: Empty Inventory
    @Test
    void testGetStoreInventory_EmptyInventory() {
        Byte storeId = 1;

        when(inventoryRepository.getStoreInventory(storeId))
                .thenReturn(List.of());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> storeService.getStoreInventory(storeId)
        );

        assertEquals(
                "No inventory found for store ID: " + storeId,
                exception.getMessage()
        );

        verify(inventoryRepository, times(1))
                .getStoreInventory(storeId);
    }
}