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

    @OneToMany(mappedBy = "store")
    private List<Inventory> inventories;
}