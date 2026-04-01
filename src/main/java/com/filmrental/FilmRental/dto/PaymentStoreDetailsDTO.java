package com.filmrental.FilmRental.dto;

import java.math.BigDecimal;

public class PaymentStoreDetailsDTO {

    private final Short paymentId;
    private final BigDecimal amount;
    private final Byte staffId;
    private final Byte storeId;

    public PaymentStoreDetailsDTO(Short paymentId, BigDecimal amount, Byte staffId, Byte storeId) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.staffId = staffId;
        this.storeId = storeId;
    }

    public Short getPaymentId() {
        return paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Byte getStaffId() {
        return staffId;
    }

    public Byte getStoreId() {
        return storeId;
    }
}
