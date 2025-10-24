package com.example.ManejoLibros.service;

import java.util.List;

import com.example.ManejoLibros.dto.LibroRequestDTO;
import com.example.ManejoLibros.dto.LibroResponseDTO;
import com.example.ManejoLibros.dto.LibroStockUpdateRequestDTO;

public interface LibroService {

    //Métodos para la gestión de libros
    LibroResponseDTO crearLibro(LibroRequestDTO libroRequestDTO);

    //Logica para actualizar completamente un libro.
    LibroResponseDTO actualizarLibro(Long id, LibroRequestDTO libroRequestDTO);

    //Logica para actualizar SOLO el stock (operacion parcial).
    LibroResponseDTO actualizarStock(Long id, LibroStockUpdateRequestDTO stockDTO);

    //Logica para obtener libros con stock bajo.
    List<LibroResponseDTO> obtenerLibrosConStockBajo(Integer limiteStock);

    //Logica para obtener un libro por su ID.
    LibroResponseDTO obtenerLibroPorId(Long id);

    //Logica para obtener todos los libros.
    List<LibroResponseDTO> obtenerTodosLosLibros();

    //Logica para eliminar un libro por su ID.  
    void eliminarLibro(Long id);

}
