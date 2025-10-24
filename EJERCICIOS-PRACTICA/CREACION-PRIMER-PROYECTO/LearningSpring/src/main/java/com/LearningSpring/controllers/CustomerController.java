package com.LearningSpring.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.LearningSpring.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController //Indicando que esta clase sera un controllador del tipo rest.
public class CustomerController {
    
    //Creacion de listas en forma de base de datos para el manejo de inforamcion, ya que actualmente no estamos manejando una base de datos.
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
        new Customer(123, "Juanjo","Jacob", "12345"),
        new Customer(456,"Mateo","Mateus", "1234567"),
        new Customer(789, "Alberto", "Albarito", "1234"),
        new Customer(987, "Carlos", "Carly", "324")
    ));

    //Metodo para ejecutar la lista previamente creada.
    @GetMapping("/clientes") //El sufijo que queremos que pertenezca a la URL mediante la cual vamos a buscar la informacion.
    public List<Customer> getCustomers(){
        return customers;
    }

    //Metodo para poder filtrar a los clientes mediante su usuario o username.
    @GetMapping("/clientes/{username}") //El sufijo que queremos que pertenezca a la URL mediante la cual vamos a buscar la informacion.
    public Customer getCliente(@PathVariable String username) { 
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        } 
        return null;
    }

    //En este caso lo que estamos haciendo es utilizando la decoracion de postmapping con la misma ruta que tienen los metodos de arriba. Esto con el fin de poder ingresar datos de nuevos clientes a la lista de clientes que esta arriba. Todo esto haciendo uso de POSTMAN(APLICACION EXTERNA) y haciendo uso de @RequestBody que esta decoracion nos ayuda a convertir archivos .json a nuestra lista de clientes.
    @PostMapping("/clientes")
    public Customer postCliente(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    //En este caso vamos a crear el metodo que nos va a permitir poder realizar modificaciones de los recursos que ya tenemos en el sistemas, en este caso son los 4 clientes que tenemos en la lista. 
    public Customer putCliente(Customer customer) {
        for(Customer c : customers){
            if () {

            }
        }
    }
}
