package com.example.ManejoEstudiantes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ManejoEstudiantes.dto.EstudianteRequestDTO;
import com.example.ManejoEstudiantes.dto.EstudianteResponseDTO;
import com.example.ManejoEstudiantes.entities.EstudianteEntity;
import com.example.ManejoEstudiantes.repository.EstudianteRepository;

@Service //Anotacion para marcar esta clase como service.
public class EstudianteServiceImpl implements EstudianteService {
    
    //Inyeccion de dependencias.
    private final EstudianteRepository estudianteRepository;

    //Contructor de la inyeccion de dependencia.
    public EstudianteServiceImpl (EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    //Implementacion de los metodos.

    @Override 
    public EstudianteResponseDTO crearEstudiante(EstudianteRequestDTO requestDTO) {

        //Logica de negocio: Validacion del Email
        if (estudianteRepository.findByEmail(requestDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email " + requestDTO.getEmail() + " ya esta registrado.");
        }

        //1. DTO a Entity: Transformamos el DTO de entrada a nuestra entity.
        EstudianteEntity nuevoEstudiante = new EstudianteEntity();
        nuevoEstudiante.setNombre(requestDTO.getNombre());
        nuevoEstudiante.setApellido(requestDTO.getApellido());
        nuevoEstudiante.setEmail(requestDTO.getEmail());
        nuevoEstudiante.setSemestreActual(requestDTO.getSemestreActual());

        //2. Persistencia: Usamos el repository para guardar la entity en la base de datos.
        EstudianteEntity estudianteGuardado = estudianteRepository.save(nuevoEstudiante);

        //3. Entity a DTO: Transformamos la entity guardada (que ya tiene el ID) a DTO de respuesta.
        return mapToResponseDTO(estudianteGuardado);
    }

    @Override
    //Obtenemos todas las entidades.
    public List<EstudianteResponseDTO> obtenerTodos() {
        //Usamos stream para transformar cada Entity a su DTO de respuesta.
        return estudianteRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    //Metodo de mapeo (entity -> response DTO)
    private EstudianteResponseDTO mapToResponseDTO(EstudianteEntity estudiante) {
        EstudianteResponseDTO dto = new EstudianteResponseDTO();
        dto.setID(estudiante.getId());

        //Logica de mapeo: Combinar nombre y apellido.
        dto.setNombreCompleto(estudiante.getNombre() + " " + estudiante.getApellido());
        dto.setEmail(estudiante.getEmail());
        dto.setSemestreActual(estudiante.getSemestreActual());
        return dto;
    }
}
