//Los DTO son unos objetos simples cuyo proposito es transferir datos entre los limites del sistema (por ejemplo, entre el controller y el service, o entre la API y el cliente web).

//Dentro de los DTOs hay una regla que nunca se debe romper y es que nunca se debe exponer las entities directamente al mundo exterior (el controller).

//En este caso el ResponseDTO se usa para enviar datos hacia las respuestas HTTP.
//Este permite exponer solo los campos necesarios, ocultando datos internos de la Entity (como campos de auditoria, contraseñas, o relaciones complejas).


package com.example.Aprendiendo.DTO;

import lombok.Data;

@Data //Incluimos todos los campos que queremos mostrar.
public class TareaResponseDTO {
    //NOTA: Inlcuimos el id, ya que el cliente debe saber cual es el ID de la tarea creada.
    private Long id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    
}
