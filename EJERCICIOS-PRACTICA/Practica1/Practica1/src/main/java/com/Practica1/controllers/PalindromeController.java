package com.Practica1.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//RestController combina controller con response. Indica que esta clase manejara peticiones HTTP y que sus metodos devolveran directamente datos (textos, json, etc)..
@RestController
public class PalindromeController{

    //GetMapping asocia un metodo a una peticion HTTP GET en la ruta indicada.
    //{word} es un valor dinamico que se captura desde la URL.
    @GetMapping("/validar-palindromo/{word}")
    public String Palindrome(@PathVariable String word){
        //Llamamos al metodo privado para verificar si la palabra lo es.
        if (isPalindrome(word)){
            //Retorna una respuesta en texto simple al cliente indicando que si es un palindromo.
            return " La palabra " + word + " es un palindromo: ";
        } else {
            //Retorna una respuesta en texto simple al cliente indicando que no es un palindromo.
            return " La palabra " + word + " NO es un palindromo: ";
        }
    }


    //Metodo privado de apoyo que determina si una palabra es palindromo (esto no es recomendado hacerlo en la misma carpeta, ya que es bueno devidir responsabilidades, pero esto lo estaremos viendo mas adelante).
    //No esta expuesto como endpoint, solo lo usa el controlador internamente.
    private boolean isPalindrome(String word) {
        //Se obtiene la longitud de la palabra.
        int length = word.length();
        //Se corre la palabra desde varios extremos hasta el centro.
        for (int i = 0; i < length / 2; i++) {
            //Si algun caracter no coincide con el opuesto, no es palindromo.
            if (word.charAt(i) != word.charAt(length - i - 1)){
                return false;
            }
        }
        //Si todas las comparaciones son correctas, es palindromo.
        return true;
    }
}