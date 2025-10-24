package com.example.ManejoEstudiantes.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ManejoEstudiantes.entities.EstudianteEntity;



public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
    
    //Metodo de consulta derivada para validar si un email existe.
    //Usaremos esto en la logica de negocio (service).
    Optional<EstudianteEntity>  findByEmail(String email);

    //Metodo para buscar estudiantes en un semestre especifico.
    java.util.List<EstudianteEntity> findBySemestreActual(Integer semestre);
}
