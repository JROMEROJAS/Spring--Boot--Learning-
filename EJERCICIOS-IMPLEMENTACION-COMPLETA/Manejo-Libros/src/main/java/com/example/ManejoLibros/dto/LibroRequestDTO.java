package com.example.ManejoLibros.dto;

import lombok.Data;

@Data // Genera getters, setters, toString, equals y hashCode automáticamente.
// DTO para la solicitud de creación o actualización general.
public class LibroRequestDTO {
    // Atributos del libro
    private String titulo; 
    private String autor;
    private String isbn;
    private Integer stock;
    private double precio;
}
