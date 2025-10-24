package com.example.ManejoLibros.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity // Indica que esta clase es una entidad JPA.
@Table(name = "libros") // Mapea esta entidad a la tabla "libros" en la base de datos.
@Data // Genera automáticamente getters, setters, toString, equals y hashCode.
@NoArgsConstructor // Genera un constructor sin argumentos.
@AllArgsConstructor // Genera un constructor con todos los argumentos.
public class LibroEntity {
    
    @Id // Indica que este campo es la clave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; // Identificador único del libro.

    private String titulo; // Título del libro.

    private String autor; // Autor del libro.

    private String isbn; // Código ISBN del libro.

    private double precio; // Precio del libro.

    private Integer stock; // Cantidad en stock del libro.

    
}
