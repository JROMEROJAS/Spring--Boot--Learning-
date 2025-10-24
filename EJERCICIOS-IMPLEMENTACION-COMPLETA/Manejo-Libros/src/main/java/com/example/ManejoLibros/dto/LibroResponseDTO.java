package com.example.ManejoLibros.dto;

import lombok.Data;

@Data
// Clase DTO para representar la respuesta de un libro.
public class LibroResponseDTO {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer stock;
    private double precio;
}
