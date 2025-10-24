//Salida de datos.
//Dentro de los DTOs hay una regla que nunca se debe romper y es que nunca se debe exponer las entities directamente al mundo exterior (el controller).

//En este caso el ResponseDTO se usa para enviar datos hacia las respuestas HTTP.
//Este permite exponer solo los campos necesarios, ocultando datos internos de la Entity (como campos de auditoria, contraseñas, o relaciones complejas).
package com.example.ManejoEstudiantes.dto;

import lombok.Data;

@Data //Incluimos todos los datos que queremos mostrar.
public class EstudianteResponseDTO {
    //Incluimos el ID para la respuesta.
    private Long ID;
    private String nombreCompleto;
    private String email;
    private Integer semestreActual;
}
