package com.LearningSpring.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class GrettingController {
    
    //Lo que estamos haciendo aqui es haciendo uso del comando PathVariable: Donde este se usa cuando queremos pasarle un parametro nuestro metodo para que cuando imprima la informacion de la solicitud tambien la imprima con el parametro que le estamos pasando.

    @GetMapping("/saludo/{name}/{edad}")
    public String gretting(@PathVariable String name, @PathVariable int edad){
        return "Hola " + name + " se que tienes una edad de: "+ edad + " esta es mi primera creacion de un ENDPOINT que recibe la solicitud get para retornarte un saludo personalizado, espero y estes orgulloso. :) ";
    }
} 
