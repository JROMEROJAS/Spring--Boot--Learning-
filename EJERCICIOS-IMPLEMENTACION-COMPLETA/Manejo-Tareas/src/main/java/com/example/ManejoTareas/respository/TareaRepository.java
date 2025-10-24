//Interactua directamente con la base de datos. Realiza operaciones CRUD (crear, leer, actualizar y eleminar).
//El repository es una interfaz que extiende de una interfaz de Spring Data JPA (como JpaRepository). Su funcion es proporcionar metodos para acceder y manipular los datos en la base de datos.

package com.example.ManejoTareas.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ManejoTareas.entities.TareaEntity;

//Extender de JpaRepository nos da todos los metodos CRUD basicos.
//En este caso es lo mismo que decir JpaRepository<T, ID>, donde T es la entidad con la que trabajara tarea y ID el tipo de dato de llave primaria.
//Al extende de JpaRepository tenemos varios metodos como: save(tarea), findById(id), findAll(), deleteById(id).
public interface TareaRepository  extends JpaRepository<TareaEntity, Long>{

    //Spring data es magico aqui
    //Al nombre el metodo asi, Spring sabe que debe generar una consulta que busque tareas donde "completada" sea igual al valor pasado. Esto se le llama "Derived Query Method" (metodo de consulta derivada).

    java.util.List<TareaEntity> findByCompletada (boolean completada);

    
}