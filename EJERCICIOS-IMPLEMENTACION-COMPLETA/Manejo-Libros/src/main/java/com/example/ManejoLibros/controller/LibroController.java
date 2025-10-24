package com.example.ManejoLibros.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ManejoLibros.dto.LibroRequestDTO;
import com.example.ManejoLibros.dto.LibroResponseDTO;
import com.example.ManejoLibros.dto.LibroStockUpdateRequestDTO;
import com.example.ManejoLibros.service.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    //Metodos POST, GET, PUT, PATCH, DELETE que llamen a los metodos del servicio.
    //1.POST - Crear un libro.
    @PostMapping
    public ResponseEntity<LibroResponseDTO> crearLibro(@RequestBody LibroRequestDTO libroRequestDTO) {
        //Manejo de error de negocio (ISBN duplicado).
        try{
            LibroResponseDTO libroCreado = libroService.crearLibro(libroRequestDTO);
            return new ResponseEntity<> (libroCreado, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    //2.PUT - Actualizar un libro completamente.
    @PutMapping("/{id}")
    //Manejo de error de negocio (Libro no existe).
    public ResponseEntity<LibroResponseDTO> actualizarLibro(@PathVariable Long id, @RequestBody LibroStockUpdateRequestDTO stockDTO ) {
        LibroResponseDTO libroActualizado = libroService.actualizarStock(id, stockDTO);
        return ResponseEntity.ok(libroActualizado);
    }

    //3.PATCH - Actualizar parcialmente un libro.
    @PatchMapping("/{id}/stock")
    public ResponseEntity<LibroResponseDTO> actualizarStock(@PathVariable Long id, @RequestBody LibroStockUpdateRequestDTO stockDTO ) {
        //Manejo de error de negocio (Libro no existe).
        try{
            LibroResponseDTO libroActualizado = libroService.actualizarStock(id, stockDTO);
            return ResponseEntity.ok(libroActualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Otros metodos GET, DELETE.
    @GetMapping("/{id}")
    //Obtener un libro por su ID.
    public ResponseEntity<LibroResponseDTO> obtenerLibro(@PathVariable Long id) {
        LibroResponseDTO libro = libroService.obtenerLibroPorId(id);
        return ResponseEntity.ok(libro);
    }

    @DeleteMapping("/{id}")
    //Eliminar un libro por su ID.
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }

}
