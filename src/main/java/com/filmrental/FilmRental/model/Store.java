package com.filmrental.FilmRental.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @Column(name = "store_id")
    private Byte storeId;
    
 // ONE store → MANY staff
    @OneToMany(mappedBy = "store")
    private List<Staff> staffList;

    // ONE store → ONE manager (staff)
    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    private Staff manager;

    // MANY store → ONE address
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;


    @OneToMany(mappedBy = "store")
    private List<Inventory> inventories;
}