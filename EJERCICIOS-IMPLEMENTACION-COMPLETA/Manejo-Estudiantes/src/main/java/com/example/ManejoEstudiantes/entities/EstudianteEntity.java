package com.example.ManejoEstudiantes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "estudiante") //Definimos esta clase como Entity, es decir, es donde describiremos toda nuestra tabla en la base de datos.
@Data //Genera getters, setters y demas.
@NoArgsConstructor //Genera un constructor sin argumentos.
@AllArgsConstructor //Genera un constructor con argumentos.
public class EstudianteEntity {
    
    @Id //Definimos este atributo como ID.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Le definimos al ID un autoIncrement.
    private Long id; //ID unico de cada estudiante.
    private String nombre;
    private String apellido;
    private String email; //Debe ser unico y se gestionara con un metodo en el repository.
    private Integer semestreActual;
}
