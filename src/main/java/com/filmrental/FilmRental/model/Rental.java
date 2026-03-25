package com.filmrental.FilmRental.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rental")
public class Rental {

    @Id
    @Column(name = "rental_id")
    private Integer rentalId;

    @Column(name = "rental_date")
    private LocalDateTime rentalDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "customer_id")
    private Integer customerId;

    // ===== GETTERS =====
    public Integer getRentalId() {
        return rentalId;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    // ===== SETTERS =====
    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}