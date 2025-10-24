//En este caso TareaServiceImpl es la implementacion concreta de la logica de negocio.

//Si nos damos cuanta, en la carpeta de TareaService lo que hacemos es definir el que, mas no el como. Caso contraio en TareaServiceImpl, ya que en esta definimos el como se hace la logica de negocio como tal.

//El service es la unica capa que conoce tanto al DTO como a la Entity y el Repository. Es responsable de la conversion entre ellos (DTO -> Entity, Entity -> DTO).

package com.example.ManejoTareas.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.example.ManejoTareas.DTO.TareaRequestDTO;
import com.example.ManejoTareas.DTO.TareaResponseDTO;
import com.example.ManejoTareas.entities.TareaEntity;
import com.example.ManejoTareas.respository.TareaRepository;

@Service //Marcamos esta clase como un Service de Spring.
public class TareaServiceImpl implements TareaService {
    
    //Inyeccion de dependencias.
    private final TareaRepository tareaRepository;

    //Constructor para inyeccion (Spring lo hace automaticamente).
    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    //Implementacion de los metodos:

    @Override
    public TareaResponseDTO crearTarea(TareaRequestDTO requestDTO){
        //1. DTO a entity: Transformamos el DTO de entrada a nuestra entity.
        TareaEntity nuevaTarea = new TareaEntity();
        nuevaTarea.setTitulo(requestDTO.getTitulo());
        nuevaTarea.setDescripcion(requestDTO.getDescripcion());
        //El campo completada se deja en false por defecto segun la Entity.

        //2. Persistencia: Usamos el Repository para guardar la Entity en la base de datos.
        TareaEntity tareaGuardada = tareaRepository.save(nuevaTarea);

        //3. Entity a DTO: Transformamos la entity guardada (que ya tiene el ID) a DTO de respuesta.
        return mapToResponseDTO(tareaGuardada);
    }

    @Override
    public List<TareaResponseDTO> obtenerTodas() {
        //1. Persistencia: Obtenemos todas las entidades.
        List<TareaEntity> tareas = tareaRepository.findAll();

        //2. Mapeo masivo: Usamos streams de Java para transformar cada Entity a su DTO de respuesta.
        return tareas.stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public TareaResponseDTO marcarComoCompletada(Long id) {
        //Logica de negocio:
        //1. Buscamos la entity. Si no existe, lanzamos la excepcion (manejo de errores es clave).
        TareaEntity tarea = tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));

        //2. Logica de negocio pura: cambiamos el estado.
        tarea. setCompletada(true);

        //3. Persistencia: Guardamos la entity modificada.
        TareaEntity tareaActualizada = tareaRepository.save(tarea);

        //4. Entity a DTO: Retornamos el DTO actualizado.
        return mapToResponseDTO(tareaActualizada);
    }

    //Metodo auxiliar de Mapeo (Entity -> Response DTO)
    private TareaResponseDTO mapToResponseDTO(TareaEntity tarea) {
        TareaResponseDTO dto = new TareaResponseDTO();
        dto.setId(tarea.getId());
        dto.setTitulo(tarea.getTitulo());
        dto.setDescripcion(tarea.getDescripcion());
        dto.setCompletada(tarea.isCompletada());
        return dto;

    }


}
