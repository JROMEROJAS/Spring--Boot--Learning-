//Entrada de datos.
//Dentro de los DTOs hay una regla que nunca se debe romper y es que nunca se debe exponer las entities directamente al mundo exterior (el controller).

//En este caso el RequestDTO se utiliza para recibir datos de las peticiones POST/PUT.
//Evita que el cliente envie campos que no debe (como el id).

package com.example.ManejoEstudiantes.dto;

import lombok.Data;

//Solo necesitamos los campos que el usuario pueda enviar.
@Data
public class EstudianteRequestDTO {
    //No incluimos el ID
    private String nombre;
    private String apellido;
    private String email;
    private Integer semestreActual;
}
