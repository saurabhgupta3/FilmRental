package com.filmrental.FilmRental.service;

import java.util.List;

import com.filmrental.FilmRental.dto.CustomerPaymentDTO;
import com.filmrental.FilmRental.dto.PaymentDetailsDTO;
import com.filmrental.FilmRental.dto.PaymentStoreDetailsDTO;

public interface PaymentService {

    List<PaymentDetailsDTO> getPaymentDetails();

    List<PaymentStoreDetailsDTO> getPaymentStoreDetails();

    List<CustomerPaymentDTO> getPaymentsByCustomerId(Short customerId);
}
