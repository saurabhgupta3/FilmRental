package com.filmrental.FilmRental.repo;

import com.filmrental.FilmRental.dto.PaymentDetailsDTO;
import com.filmrental.FilmRental.model.Payment;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("""
        SELECT new com.filmrental.FilmRental.dto.PaymentDetailsDTO(
            p.paymentId,
            p.amount,
            p.paymentDate,
            p.customerId,
            c.firstName
        )
        FROM Payment p
        JOIN Customer c ON p.customerId = c.customerId
    """)
    List<PaymentDetailsDTO> getPaymentDetails();
}