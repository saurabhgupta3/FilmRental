package com.filmrental.FilmRental.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @Column(name = "category_id")
    private Byte categoryId;

    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<FilmCategory> filmCategories;
}