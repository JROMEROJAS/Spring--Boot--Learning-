package com.example.ManejoLibros.dto;

import lombok.Data;


@Data
//DTO para actualizacion parcial.
public class LibroStockUpdateRequestDTO {
    private Integer stock; // Nuevo stock del libro.
}
