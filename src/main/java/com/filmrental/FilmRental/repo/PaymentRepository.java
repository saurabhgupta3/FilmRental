package com.filmrental.FilmRental.repo;

import com.filmrental.FilmRental.dto.CustomerPaymentDTO;
import com.filmrental.FilmRental.dto.PaymentDetailsDTO;
import com.filmrental.FilmRental.model.Payment;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Short> {

    @Query("""
    SELECT new com.filmrental.FilmRental.dto.PaymentDetailsDTO(
        p.paymentId,
        p.amount,
        p.paymentDate,
        p.customer.customerId,
        p.customer.firstName
    )
    FROM Payment p
    """)
    List<PaymentDetailsDTO> getPaymentDetails();

    @Query("""
    SELECT new com.filmrental.FilmRental.dto.CustomerPaymentDTO(
        p.customer.customerId,
        p.customer.firstName,
        p.paymentId,
        p.amount,
        p.paymentDate
    )
    FROM Payment p
    WHERE p.customer.customerId = :customerId
""")
    List<CustomerPaymentDTO> getPaymentsByCustomerId(@Param("customerId") Short customerId);
}