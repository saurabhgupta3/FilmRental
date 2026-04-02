package com.filmrental.FilmRental.model;

import java.util.List;

import com.filmrental.FilmRental.model.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    @Id
    @Column(name = "staff_id")
    private Byte staffId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    // MANY staff → ONE store
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    // MANY staff → ONE address
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    // One staff → many rentals
    @OneToMany(mappedBy = "staff")
    private List<Rental> rentals;

    @OneToMany(mappedBy = "staff")
    private List<Payment> payments;
}
