//Creacion de la estructura de nuestra base de datos e interactua con ella al igual que Repository.
//Representa una tabla en la base de datos. Son las clases que Spring Data JPA usa para mapear las filas de la base de datos a objetos de Java. 

package com.example.ManejoTareas.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Las entities son clases simples que gracias a anotaciones podemos crear la estructura de nuestra base de datos en Java.
@Data //Genera getters, setters, toString, equals y hashCode automaticamente sin necesidad de escribirlo manualmente.
@NoArgsConstructor //Genera un constructor sin argumentos.
@AllArgsConstructor //Genera un constructor con todos los argumentos.
@Entity(name = "tarea") //Con la anotacion @Entity lo que hacemos es asignar esta clase como una entidad, donde dicha anotacion recibe un atributo que este caso es el nombre que tendra dicha entidad.
@Table(name = "Tareas") //Con la anotacion @Table lo que hacemos es asignar o representar esta entidad como una tabla, donde tambien recibe un atributo de etipo nombre, que es el nombre de dicha tabla.
public class TareaEntity {


    @Id //Con esta anotacion lo que hacemos es definir este primer atributo id, como llave primaria de dicha tabla.
    @GeneratedValue(strategy = GenerationType.AUTO) //Y con esta anotacion lo que hacemos es que cada vez que detecte un registro nuevo se autoincrementara, como se autoincrementara? bueno eso se lo asignamos con un atributo estrategia, donde en este caso le asignamos un GenerationType-AUTO.
    private Long id;



    @Column(name = "TAREA-NOMBRE", length = 50, nullable = false, unique = false) //Con esta anotacion lo que hacemos es asignar el siguiente atributo como una columna dentro de la tabla, donde dicha columna puede tener digamos que varias restricciones, por ejemplo, le podemos cambiar el nombre, la longitud de la cantidad de caracteres, que no puede recibir espacios vacios y que si puede ser unico o no.
    private String titulo;



    @Column(name = "TAREA-DESCRIPCION", length = 150, nullable = false, unique = false)
    private String descripcion;


    
    private boolean completada = false; //Valor por defecto.


}
