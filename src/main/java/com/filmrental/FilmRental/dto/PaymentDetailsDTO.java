package com.filmrental.FilmRental.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentDetailsDTO {

    private Short paymentId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private Short customerId;
    private String firstName;

    // ✅ ONLY ONE CORRECT CONSTRUCTOR (MATCHES QUERY)
    public PaymentDetailsDTO(Short paymentId,
                             BigDecimal amount,
                             LocalDateTime paymentDate,
                             Short customerId,
                             String firstName) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.customerId = customerId;
        this.firstName = firstName;
    }

    // ✅ GETTERS

    public Short getPaymentId() {
        return paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public Short getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }
}