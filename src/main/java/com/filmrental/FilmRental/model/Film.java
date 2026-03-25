package com.filmrental.FilmRental.model;

import jakarta.persistence.*;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @Column(name = "film_id")
    private Long filmId;

    private String title;
    private String description;

    @Column(name = "rental_rate")
    private Double rentalRate;

    private Integer length;

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(Double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Film(Long filmId, String title, String description, Double rentalRate, Integer length) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.rentalRate = rentalRate;
		this.length = length;
	}

	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters & Setters
}