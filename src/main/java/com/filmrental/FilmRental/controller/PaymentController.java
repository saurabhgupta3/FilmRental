package com.filmrental.FilmRental.controller;

import com.filmrental.FilmRental.dto.PaymentDetailsDTO;
import com.filmrental.FilmRental.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/details")
    public List<PaymentDetailsDTO> getPaymentDetails() {
        return paymentService.getPaymentDetails();
    }
}