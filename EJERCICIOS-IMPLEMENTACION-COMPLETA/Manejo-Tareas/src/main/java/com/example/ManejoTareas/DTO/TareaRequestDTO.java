//Los DTO son unos objetos simples cuyo proposito es transferir datos entre los limites del sistema (por ejemplo, entre el controller y el service, o entre la API y el cliente web).

//Dentro de los DTOs hay una regla que nunca se debe romper y es que nunca se debe exponer las entities directamente al mundo exterior (el controller).

//En este caso el RequestDTO se utiliza para recibir datos de las peticiones POST/PUT.
//Evita que el cliente envie campos que no debe (como el id o la fecha de creacion).

package com.example.ManejoTareas.DTO;

import lombok.Data;

@Data // Solo necesitamos los campos que el usuario puede enviar.
public class TareaRequestDTO {
    //NOTA: NO incluimos el id, ya que se genera en la base de datos.
    private String titulo;
    private String descripcion;

    //La propiedad completada se puede omitir en el request inicial o incluirla solo si queremos que el cliente pueda establecer su estado inicial.
}