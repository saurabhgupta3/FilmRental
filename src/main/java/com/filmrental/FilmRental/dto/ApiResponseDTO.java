package com.filmrental.FilmRental.dto;

import lombok.Data;

@Data
public class ApiResponseDTO {
    private String status;
    private String message;
    private Object data;

    public ApiResponseDTO(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
