//Contiene toda la logica de negocio real de la aplicacion.
//Implementa la logica de negocio. Coordina opereciones, como validar datos, llamar a repositorios o realizar calculos.
//En otras palabras, el service es el mediador que recibe los DTOs del controller, usa el Repository para interactuar con las entities en la base de datos, aplica la logia y devuelve DTOs al controller.


package com.example.ManejoTareas.service;

import java.util.List;

import com.example.ManejoTareas.DTO.TareaRequestDTO;
import com.example.ManejoTareas.DTO.TareaResponseDTO;

public interface TareaService {
    //Crear los metodos que van a definir las operaciones de negocio.

    //1. Crear una tarea, recibiendo un DTO y devolviendo un DTO.
    TareaResponseDTO crearTarea (TareaRequestDTO requestDTO);

    //2. Obtener todas las tareas.
    List<TareaResponseDTO> obtenerTodas();

    //3. Marcar una tarea como completada (Logica de negocio).
    TareaResponseDTO marcarComoCompletada(Long id);

    

}
