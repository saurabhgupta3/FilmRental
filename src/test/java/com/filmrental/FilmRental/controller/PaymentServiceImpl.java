package com.filmrental.FilmRental.controller;

import com.filmrental.FilmRental.dto.CustomerPaymentDTO;
import com.filmrental.FilmRental.dto.PaymentDetailsDTO;
import com.filmrental.FilmRental.dto.PaymentStoreDetailsDTO;
import com.filmrental.FilmRental.exception.ResourceNotFoundException;
import com.filmrental.FilmRental.repo.PaymentRepository;

import com.filmrental.FilmRental.service.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    // ===============================
    // ✅ 1. getPaymentDetails()
    // ===============================

    @Test
    void testGetPaymentDetails_Success() {

        PaymentDetailsDTO dto = new PaymentDetailsDTO(
                (short)1,
                new BigDecimal("100.50"),
                LocalDateTime.now(),
                (short)10,
                "John"
        );

        when(paymentRepository.getPaymentDetails())
                .thenReturn(List.of(dto));

        List<PaymentDetailsDTO> result = paymentService.getPaymentDetails();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());

        verify(paymentRepository, times(1)).getPaymentDetails();
    }

    @Test
    void testGetPaymentDetails_EmptyList() {

        when(paymentRepository.getPaymentDetails())
                .thenReturn(List.of());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> paymentService.getPaymentDetails()
        );

        assertEquals("No payments found", exception.getMessage());

        verify(paymentRepository, times(1)).getPaymentDetails();
    }

    // ===============================
    // ✅ 2. getPaymentStoreDetails()
    // ===============================

    @Test
    void testGetPaymentStoreDetails_Success() {

        PaymentStoreDetailsDTO dto = new PaymentStoreDetailsDTO(
                (short)1,
                new BigDecimal("200.00"),
                (byte)2,
                (byte)1
        );

        when(paymentRepository.getPaymentStoreDetails())
                .thenReturn(List.of(dto));

        List<PaymentStoreDetailsDTO> result =
                paymentService.getPaymentStoreDetails();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals((byte)1, result.get(0).getStoreId());

        verify(paymentRepository, times(1))
                .getPaymentStoreDetails();
    }

    @Test
    void testGetPaymentStoreDetails_EmptyList() {

        when(paymentRepository.getPaymentStoreDetails())
                .thenReturn(List.of());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> paymentService.getPaymentStoreDetails()
        );

        assertEquals("No store payment data found", exception.getMessage());

        verify(paymentRepository, times(1))
                .getPaymentStoreDetails();
    }

    // ===============================
    // ✅ 3. getPaymentsByCustomerId()
    // ===============================

    @Test
    void testGetPaymentsByCustomerId_Success() {

        Short customerId = 1;

        CustomerPaymentDTO dto = new CustomerPaymentDTO(
                customerId,
                "John",
                (short)5,
                new BigDecimal("300.00"),
                LocalDateTime.now()
        );

        when(paymentRepository.getPaymentsByCustomerId(customerId))
                .thenReturn(List.of(dto));

        List<CustomerPaymentDTO> result =
                paymentService.getPaymentsByCustomerId(customerId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());

        verify(paymentRepository, times(1))
                .getPaymentsByCustomerId(customerId);
    }

    @Test
    void testGetPaymentsByCustomerId_EmptyList() {

        Short customerId = 1;

        when(paymentRepository.getPaymentsByCustomerId(customerId))
                .thenReturn(List.of());

        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> paymentService.getPaymentsByCustomerId(customerId)
        );

        assertEquals(
                "No payments found for customer id: " + customerId,
                exception.getMessage()
        );

        verify(paymentRepository, times(1))
                .getPaymentsByCustomerId(customerId);
    }
}