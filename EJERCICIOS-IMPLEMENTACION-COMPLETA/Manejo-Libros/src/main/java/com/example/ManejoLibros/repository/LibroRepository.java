package com.example.ManejoLibros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ManejoLibros.entities.LibroEntity;
import java.util.List;
import java.util.Optional;

// Repositorio para la entidad LibroEntity.
public interface LibroRepository extends JpaRepository<LibroEntity, Long> { 
    
    // Buscar un libro por su ISBN.
    Optional<LibroEntity> findByIsbn(String isbn); 

    // Buscar libros por autor.
    List<LibroEntity> findByAutor(String autor); 

    // Buscar libros por título que contenga una cadena específica.
    List<LibroEntity> findByTituloContaining(String titulo); 

    // Buscar libros con stock menor o igual a una cantidad dada.
    List<LibroEntity> findByStockLessThanEqual(Integer stock);
}
