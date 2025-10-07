package com.LearningSpring.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

//Anotacion para asignar esta clase como controladora.
@RestController

class HelloWorldController {

    //Comando para mapear este metodo para que cuando se haga una solicitud desde el cliente se pueda ejecutar este metodo y retorne la respuesta (Hello World). Dentro del parentesis ponemos la ruta de la cual se va a acceder al metodo.
    //Dato importante: El get mapping puede recibir mas de una ruta para pode hacer peticiones a este endpoint.
    @GetMapping({"/Hello", "/hm", "/hola"})
    public String helloWorld() {
        System.out.println("Solicitud ejecutada");
        return "Hello World";
    }

}