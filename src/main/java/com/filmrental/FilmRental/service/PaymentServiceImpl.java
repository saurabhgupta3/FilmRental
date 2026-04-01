package com.filmrental.FilmRental.service;

import com.filmrental.FilmRental.dto.CustomerPaymentDTO;
import com.filmrental.FilmRental.dto.PaymentDetailsDTO;
import com.filmrental.FilmRental.dto.PaymentStoreDetailsDTO;
import com.filmrental.FilmRental.exception.ResourceNotFoundException;
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
        List<PaymentDetailsDTO> list = paymentRepository.getPaymentDetails();

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No payments found");
        }

        return list;
    }

    @Override
    public List<PaymentStoreDetailsDTO> getPaymentStoreDetails() {
        List<PaymentStoreDetailsDTO> list = paymentRepository.getPaymentStoreDetails();

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("No store payment data found");
        }

        return list;
    }

    @Override
    public List<CustomerPaymentDTO> getPaymentsByCustomerId(Short customerId) {
        List<CustomerPaymentDTO> list =
                paymentRepository.getPaymentsByCustomerId(customerId);

        if (list.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No payments found for customer id: " + customerId);
        }

        return list;
    }
}