package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.CustomerPaymentDTO;
import com.filmrental.FilmRental.dto.PaymentDetailsDTO;
import com.filmrental.FilmRental.dto.PaymentDetailsDTO;
import com.filmrental.FilmRental.repo.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<PaymentDetailsDTO> getPaymentDetails() {
        return paymentRepository.getPaymentDetails();
    }

    @Override
    public List<CustomerPaymentDTO> getPaymentsByCustomerId(Short customerId) {
        return paymentRepository.getPaymentsByCustomerId(customerId);
    }
}