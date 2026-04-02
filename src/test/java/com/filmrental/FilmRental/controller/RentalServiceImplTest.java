package com.filmrental.FilmRental.controller;

import com.filmrental.FilmRental.dto.CustomerRentalDTO;
import com.filmrental.FilmRental.dto.RentalStaffDTO;
import com.filmrental.FilmRental.exception.MissingFieldException;
import com.filmrental.FilmRental.exception.ResourceNotFoundException;
import com.filmrental.FilmRental.model.Rental;
import com.filmrental.FilmRental.repo.RentalRepository;

import com.filmrental.FilmRental.service.RentalServiceImpl;
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
class RentalServiceImplTest {

    @Mock
    private RentalRepository rentalRepository;

    @InjectMocks
    private RentalServiceImpl rentalService;


    // ❌ 2. getRentalStaffDetails() - Empty List
    @Test
    void testGetRentalStaffDetails_EmptyList() {

        when(rentalRepository.getRentalWithStaff())
                .thenReturn(List.of());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> rentalService.getRentalStaffDetails()
        );

        assertEquals("No rental-staff details found", exception.getMessage());

        verify(rentalRepository, times(1)).getRentalWithStaff();
    }

    // ✅ 2. getRentalStaffDetails() - Success
    @Test
    void testGetRentalStaffDetails_Success() {

        RentalStaffDTO dto = new RentalStaffDTO(
                1,
                LocalDateTime.now(),
                (byte) 1,
                "John",
                "Doe"
        );

        when(rentalRepository.getRentalWithStaff())
                .thenReturn(List.of(dto));

        List<RentalStaffDTO> result = rentalService.getRentalStaffDetails();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());

        verify(rentalRepository, times(1)).getRentalWithStaff();
    }
}