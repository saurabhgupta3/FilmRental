package com.filmrental.FilmRental.controller;

import java.util.List;

import com.filmrental.FilmRental.dto.CustomerPaymentDTO;
import com.filmrental.FilmRental.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmrental.FilmRental.dto.CustomerRentalDTO;
import com.filmrental.FilmRental.model.Customer;
import com.filmrental.FilmRental.service.CustomerService;
import com.filmrental.FilmRental.service.RentalService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaymentService paymentService;
   
    private final RentalService rentalService;
    public CustomerController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}/rentals")
    public List<CustomerRentalDTO> getCustomerRentals(@PathVariable Short id) {
        return rentalService.getRentalsByCustomerId(id);
    }

    @GetMapping("/{id}/payments")
    public ResponseEntity<List<CustomerPaymentDTO>> getCustomerPayments(@PathVariable Short id) {
        return ResponseEntity.ok(paymentService.getPaymentsByCustomerId(id));
    }
}
