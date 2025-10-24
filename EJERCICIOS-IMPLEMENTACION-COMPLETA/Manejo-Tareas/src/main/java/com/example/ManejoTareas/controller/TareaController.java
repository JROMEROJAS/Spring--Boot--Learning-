//La capa de controllers maneja las peticiones HTTP (GET, POST, PUT, DELETE), es el punto de entrada.   
//Recibe peticiones HTTP(URLs) y devuelve respuestas HTTP.

package com.example.ManejoTareas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ManejoTareas.DTO.TareaRequestDTO;
import com.example.ManejoTareas.DTO.TareaResponseDTO;
import com.example.ManejoTareas.service.TareaService;

@RestController //Anota esta clase como un REST Controller
//@RestController combina @Controller para manejar peticiones y @ResponseBody para que los metodos devuelvan directamente objetos Java que Spring convertira en JSON/XML. 
@RequestMapping("/api/tareas") // Define la URL base para todos los metodos.    
public class TareaController {
    
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    //ENDPOINT: Crear tarea (POST)
    @PostMapping
    //Utilizamos @RequestBody para mapear el JSON de la peticion al objeto TareaRequestDTO.
    //En otra palabras toma el JSON que viene en el cuerpo de la peticion y la convierte en nuestro de Java (TareaRequestDTO)
    public ResponseEntity<TareaResponseDTO> crearTarea(@RequestBody TareaRequestDTO requestDTO) {
        //La logica esta en el Service, el controller solo delega.
        TareaResponseDTO nuevaTarea = tareaService.crearTarea(requestDTO);

        //Retorna la respuesta con el codigo de estado (created).
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    //ENDPOINT: Obtener todas las tareas (GET)
    @GetMapping
    public ResponseEntity<List<TareaResponseDTO>> obtenerTodasTareas() {
        List<TareaResponseDTO> tareas = tareaService.obtenerTodas();
        //Retorna la respuesta con el codigo de estado.
        return ResponseEntity.ok(tareas);
    }

    //ENDPOINT: Actualizar estado (PUT/PATH)
    @PatchMapping("/{id}/completar") //URL: /api/tareas/{id}/completar
    //PathMapping extrae el valor del id de la URL.
    public ResponseEntity<TareaResponseDTO> marcarComoCompletada(@PathVariable Long id){
        TareaResponseDTO tareaActualizada = tareaService.marcarComoCompletada(id);
        //Retorna la respuesta con el codigo de estado.
        return ResponseEntity.ok(tareaActualizada);
    }


}
