package com.example.Aprendiendo2.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Aprendiendo2.entities.EstudianteEntity;



public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
    
    //Metodo de consulta derivada para validar si un email existe.
    //Usaremos esto en la logica de negocio (service).
    Optional<EstudianteEntity>  findByEmail(String email);

    //Metodo para buscar estudiantes en un semestre especifico.
    java.util.List<EstudianteEntity> findBySemestreActual(Integer semestre);
}
