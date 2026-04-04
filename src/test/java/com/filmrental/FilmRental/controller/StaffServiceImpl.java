package com.filmrental.FilmRental.controller;


import com.filmrental.FilmRental.dto.StaffStoreDTO;
import com.filmrental.FilmRental.exception.ResourceNotFoundException;
import com.filmrental.FilmRental.repo.StaffRepository;
import com.filmrental.FilmRental.service.StaffServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StaffServiceImplTest {

    @Mock
    private StaffRepository staffRepository;

    @InjectMocks
    private StaffServiceImpl staffService;

    // ✅ Positive Test Case
    @Test
    void testGetStaffDetails_Success() {

        StaffStoreDTO dto = new StaffStoreDTO(
                (byte)1,
                "John",
                "Doe",
                (byte)2,
                (short)101
        );

        when(staffRepository.getStaffWithStoreDetails())
                .thenReturn(List.of(dto));

        List<StaffStoreDTO> result = staffService.getStaffDetails();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());

        verify(staffRepository, times(1))
                .getStaffWithStoreDetails();
    }

    // ❌ Negative Test Case: Empty List
    @Test
    void testGetStaffDetails_EmptyList() {

        when(staffRepository.getStaffWithStoreDetails())
                .thenReturn(List.of());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> staffService.getStaffDetails()
        );

        assertEquals("No staff details found", exception.getMessage());

        verify(staffRepository, times(1))
                .getStaffWithStoreDetails();
    }

    // ❌ Negative Test Case: Null Response
    @Test
    void testGetStaffDetails_NullResponse() {

        when(staffRepository.getStaffWithStoreDetails())
                .thenReturn(null);

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> staffService.getStaffDetails()
        );

        assertEquals("No staff details found", exception.getMessage());

        verify(staffRepository, times(1))
                .getStaffWithStoreDetails();
    }
}