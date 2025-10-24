package com.example.ManejoLibros.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ManejoLibros.dto.LibroRequestDTO;
import com.example.ManejoLibros.dto.LibroResponseDTO;
import com.example.ManejoLibros.dto.LibroStockUpdateRequestDTO;
import com.example.ManejoLibros.entities.LibroEntity;
import com.example.ManejoLibros.repository.LibroRepository;


@Service
public class LibroServiceImpl implements LibroService {
    
    //Inyección del repositorio de libros.
    private final LibroRepository libroRepository;

    //Constructor para la inyección de dependencias.
    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    //Logica para crear un libro.
    @Override
    public LibroResponseDTO crearLibro(LibroRequestDTO RequestDTO) {
        // Implementar la lógica para crear un libro
        if (libroRepository.findByIsbn(RequestDTO.getIsbn()).isPresent()) {
            throw new IllegalArgumentException("El libro con ISBN " + RequestDTO.getIsbn() + " ya existe."); // Validación de ISBN único.
        }

        // Mapear DTO a entidad
        LibroEntity nuevoLibro = mapToEntity(RequestDTO); // Implementa este método para mapear el DTO a la entidad.
        LibroEntity libroGuardado = libroRepository.save(nuevoLibro); // Guardar en la base de datos.
        return mapToResponseDTO(libroGuardado); // Mapear entidad a DTO de respuesta.

    }

    //Logica para actualizar completamente un libro.
    @Override
    public LibroResponseDTO actualizarLibro(Long id, LibroRequestDTO RequestDTO) {
        // Implementar la lógica para actualizar un libro.
        LibroEntity libroExistente = libroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El libro con ID " + id + " no existe."));
        // Actualizar los campos del libro existente con los datos del RequestDTO(Excluyendo el ID).
        libroExistente.setTitulo(RequestDTO.getTitulo());
        libroExistente.setAutor(RequestDTO.getAutor());
        libroExistente.setIsbn(RequestDTO.getIsbn());
        libroExistente.setPrecio(RequestDTO.getPrecio());
        libroExistente.setStock(RequestDTO.getStock());
        
        LibroEntity libroActualizado = libroRepository.save(libroExistente); // Guardar los cambios en la base de datos.
        return mapToResponseDTO(libroActualizado); // Mapear entidad a DTO de respuesta.

    }

    //Logica para actualizar SOLO el stock (operacion parcial).
    @Override
    public LibroResponseDTO actualizarStock(Long id, LibroStockUpdateRequestDTO stockDTO) {
        // Implementar la lógica para actualizar el stock de un libro.
        LibroEntity libroExistente = libroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El libro con ID " + id + " no existe."));

        //Logica de negocio: El stock no puede ser negativo.
        if (stockDTO.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }

        // Actualizar solo el campo de stock.
        libroExistente.setStock(stockDTO.getStock());
        
        // Guardar los cambios en la base de datos.
        LibroEntity libroActualizado = libroRepository.save(libroExistente);

        // Mapear entidad a DTO de respuesta.
        return mapToResponseDTO(libroActualizado); 

    }

    //Logica para obtener libros con stock bajo.
    @Override
    public List<LibroResponseDTO> obtenerLibrosConStockBajo(Integer limiteStock) {
        // Implementar la lógica para obtener libros con stock bajo.
        return libroRepository.findByStockLessThanEqual(limiteStock).stream().map(this::mapToResponseDTO).toList();
    }

    //Logica para obtener un libro por su ID.
    @Override
    public LibroResponseDTO obtenerLibroPorId(Long id) {
        // Implementar la lógica para obtener un libro por su ID.
        LibroEntity libroExistente = libroRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("El libro con ID " + id + " no existe."));
        return mapToResponseDTO(libroExistente);
    }

    //Logica para obtener todos los libros.
    @Override
    public List<LibroResponseDTO> obtenerTodosLosLibros() {
        // Implementar la lógica para obtener todos los libros.
        return libroRepository.findAll().stream().map(this::mapToResponseDTO).toList();
    }

    //Logica para eliminar un libro por su ID.
    @Override
    public void eliminarLibro(Long id) {
        // Implementar la lógica para eliminar un libro por su ID.
        if (!libroRepository.existsById(id)) {
            throw new IllegalArgumentException("El libro con ID " + id + " no existe.");
        }
        libroRepository.deleteById(id);
    }

    //Metodos de mapeo entre DTOs y Entidades.
    private LibroEntity mapToEntity(LibroRequestDTO dto) {
        LibroEntity entity = new LibroEntity();
        entity.setTitulo(dto.getTitulo());
        entity.setAutor(dto.getAutor());
        entity.setIsbn(dto.getIsbn());
        entity.setPrecio(dto.getPrecio());
        entity.setStock(dto.getStock());
        return entity;
    }

    //Mapear entidad a DTO de respuesta.
    private LibroResponseDTO mapToResponseDTO(LibroEntity entity) {
        LibroResponseDTO dto = new LibroResponseDTO();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setAutor(entity.getAutor());
        dto.setIsbn(entity.getIsbn());
        dto.setPrecio(entity.getPrecio());
        dto.setStock(entity.getStock());
        return dto;
    }

}
