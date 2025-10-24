package com.example.Aprendiendo2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Aprendiendo2.dto.EstudianteRequestDTO;
import com.example.Aprendiendo2.dto.EstudianteResponseDTO;
import com.example.Aprendiendo2.service.EstudianteService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    //ENDPOINT: Crear Estudiantes (POST)
    @PostMapping
    //Utilizamos @RequestBody para mapear el JSON de la peticion al objeto EstudianteRequestDTO.
    //En otras palabras toma el JSON que viene en el cuerpo de la peticion y la convierte en nuestro de Java (EstudianteRequestDTO)
    public ResponseEntity<EstudianteResponseDTO> crearEstudiante(@RequestBody EstudianteRequestDTO requestDTO) {
        try {
            EstudianteResponseDTO nuevoEstudiante = estudianteService.crearEstudiante(requestDTO);
            return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            //Manejo de la excepcion de logica de negocio (email repetido).
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    //ENDPOINT: Obtener estudiantes (GET)
    @GetMapping
    public ResponseEntity<List<EstudianteResponseDTO>> obtenerTodos() {
        List<EstudianteResponseDTO> estudiantes = estudianteService.obtenerTodos();
        //Retorna la respuesta con el codigo de estado.
        return ResponseEntity.ok(estudiantes);
    }
    
    
}
