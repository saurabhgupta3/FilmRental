package com.filmrental.FilmRental.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CustomerPaymentDTO {

    private Short customerId;
    private String firstName;
    private Short paymentId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;

    public CustomerPaymentDTO(Short customerId,
                              String firstName,
                              Short paymentId,
                              BigDecimal amount,
                              LocalDateTime paymentDate) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // getters
    public Short getCustomerId() { return customerId; }
    public String getFirstName() { return firstName; }
    public Short getPaymentId() { return paymentId; }
    public BigDecimal getAmount() { return amount; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
}