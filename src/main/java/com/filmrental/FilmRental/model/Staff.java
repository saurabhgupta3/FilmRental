package com.filmrental.FilmRental.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

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

    // One staff → many rentals
    @OneToMany(mappedBy = "staff")
    private List<Rental> rentals;
}