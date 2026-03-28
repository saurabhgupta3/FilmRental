package com.filmrental.FilmRental.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "payment_id")
    private Short paymentId;

    @Column(name = "customer_id")
    private Short customerId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    // getters
    public Short getPaymentId() { return paymentId; }

public Short getCustomerId() { return customerId; }

public BigDecimal getAmount() { return amount; }

public LocalDateTime getPaymentDate() { return paymentDate; }
}