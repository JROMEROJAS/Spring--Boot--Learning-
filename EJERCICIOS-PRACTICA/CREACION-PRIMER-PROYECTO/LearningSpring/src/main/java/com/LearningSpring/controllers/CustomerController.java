package com.LearningSpring.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.LearningSpring.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;


@RestController //Indicando que esta clase sera un controllador del tipo rest.
public class CustomerController {
    
    //Creacion de listas en forma de base de datos para el manejo de inforamcion, ya que actualmente no estamos manejando una base de datos.
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
        new Customer(123, "Juanjo","Jacob", "12345"),
        new Customer(456,"Mateo","Mateus", "1234567"),
        new Customer(789, "Alberto", "Albarito", "1234"),
        new Customer(000, "Carlos", "Carly", "324")
    ));

    //Metodo para ejecutar la lista previamente creada.
    @GetMapping("clientes") //El sufijo que queremos que pertenezca a la URL mediante la cual vamos a buscar la informacion.
    public List<Customer> getCustomers(){
        return customers;
    }
}
