package com.example.Aprendiendo2.service;

import java.util.List;

import com.example.Aprendiendo2.dto.EstudianteRequestDTO;
import com.example.Aprendiendo2.dto.EstudianteResponseDTO;

public interface EstudianteService {
    //Creamos los metodos que van a definir las operaciones de negocio.

    //1. Crear Estudiantes.
    EstudianteResponseDTO crearEstudiante (EstudianteRequestDTO requestDTO);

    //2. Obtener todos los estudiantes.
    List<EstudianteResponseDTO> obtenerTodos();
}
