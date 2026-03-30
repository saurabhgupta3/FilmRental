package com.filmrental.FilmRental.service;

import java.util.List;

import com.filmrental.FilmRental.dto.CustomerPaymentDTO;
import com.filmrental.FilmRental.dto.PaymentDetailsDTO;

public interface PaymentService {

    List<PaymentDetailsDTO> getPaymentDetails();

    List<CustomerPaymentDTO> getPaymentsByCustomerId(Short customerId);
}