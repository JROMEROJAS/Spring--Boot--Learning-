# 🧠 Decoracion de Clases 
Cuando trabajamos con Spring, constantemente escuchamos el termino "decorar una clase". Este termino generalmente se refiere a la aplicacion de anotaciones de Spring en una clase para configurar su comportamiento y 
funcionalidad dentro de Spring Framework.

Al decorar una clase con anotaciones Spring, estas indicando a spring como debe manejar y configurar esa clase dentro de su contenedor de inversion de control (loC),
lo que permite la administracion de componentes, la inyeccion de dependencias, la configuracion de propiedades, entre otras funcionalidades.

# 📘 Anotaciones 
En Spring Boot, una anotacion se utiliza para confgurar y definir el comportamiento de los componentes de una aplicacion.

Estas anotaciones se utilizan en conjunto con Spring Framework para simplificar el desarrollo de aplicaciones empresariale es con Java.
Entre las anotaciones podemos encontrar varias, pero nos podemos especificar en tres de ellas que son: 
- @SpringBootApplication
- @RestController
- @GetMapping

## 🧩 SpringBootApplication
Esta es la anotacion principal que se utiliza para marcar la clase principal de una aplicacion Spring Boot.

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Marca la clase principal de la aplicación
public class LearningSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningSpringApplication.class, args);
    }
}
```

## 🧩 RestController
Se utiliza para marcar una clase Java como un controlador REST, en una aplicacion Spring Boot.

Esta anotacion combina las funcionalidades de @Controller y @ResponseBody, lo que significa que es capaz de manejar solicitudes HTTP y devolder datos directamente en formato JSON o XML.

En esencia, @RestController se utiliza para crear controladores en aplicaciones Spring Boot que generan respuestas HTTP para APIs RESTful.

Cuando una clase esta anotada con @RestController, cada metodo de esa clase se mapea automaticamente a una ruta URL y responde a las solicitudes HTTP entrantes
en funcion de las anotaciones: @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, etc.

```java
import org.springframework.web.bind.annotation.RestController;

@RestController  // Indica que esta clase es un controlador REST
public class HelloController {

    public String saludo() {
        return "¡Hola desde Spring Boot!";
    }
}
```

## 🧩 GetMapping 
La anotacion @GetMapping se utiliza para mapear las solicitudes HTTP GET a metodos de controlador especificos en una aplicacion Spring Boot.

Esta anotacion se utiliza comunmente en combinacion con la anotacion @RestController o @Controller para crear controladores RESTful en una aplicacion Spring.

Cuando se utiliza @GetMapping, Spring Boot asigna la URL especificada en la anotacion a un metodo en el controlador y maneja automaticamente las solicitudes HTTP GET
que llegan a esas URL, invocando el metodo correspondiente y devolviendo el resultado como respuesta. En resumen, @GetMapping es una anotacion que se utiliza para asignar solicitudes
HTTP GET a metodos de controlador especificos en una aplicacion Spring Boot, lo que permite crear facilmente APIs RESTful y manejar las solicitudes GET de manera eficiente y estructurada.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

```

## 🧩 PostMapping
La anotacion @PostMapping se utiliza para mapear las solicitudes HTTP POST a metodos de controlador especificos en una aplicacion Spring Boot.

Esta anotacion es una forma conveniente de especificar que un metodo en nuestro controlador debe ser invocado cuando llega una solicitud POST a una URL especifica.

Ahora bien,**que es una solicitud POST?**, es uno de los metodos HTTP utilizados para enviar datos a un servidor y crear un nuevo recurso. Cuando se realiza una solicitud del tipo POST, se esta solicitando al servidor que acepte los datos incluidos en el cuerpo de la solicitud y los procese de acuerdo con la logica de la aplicacion.  

```java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    // Define la ruta POST /usuario
    @PostMapping("/usuario")
    public String crearUsuario(@RequestBody String nombre) {
        return "Usuario creado con éxito: " + nombre;
    }
}

```

## 🧩 @RequestBody 
La anotacion @RequestBody se utiliza para anotar argumentos del metodo del controlador de solicitudes.

Esta anotacion indica que un parametro de metodo debe estar vinculado al valor del cuerpo de la solicitud HTTP. Es decir, la anotacion @RequestBody se encarga de indicar que un objeto se construira a partir de la informacion enviada en el body del Request para la peticion de este servicio.


```java
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Clase modelo para representar un usuario
class Usuario {
    private String nombre;
    private String correo;

    // Getters y setters (necesarios para mapear el JSON)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

@RestController
public class UsuarioController {

    // Define la ruta POST /registrar
    @PostMapping("/registrar")
    public String registrarUsuario(@RequestBody Usuario usuario) {
        return "Usuario registrado: " + usuario.getNombre() + " (" + usuario.getCorreo() + ")";
    }
}

```

## 🧩 @PutMapping
La anotacion @PutMapping se utiliza para mapear las solicitudes HTTP del tipo PUT a metodos especificos en controladores de Spring.

Cuando un cliente envia una solicitud HTTP del tipo PUT a una URL especifica en la aplicacion Spring Boot, esta indicando que desea actualizar o reemplazar por completo un recurso en el servidor con los datos proporcionados en el cuerpo de la solicitud. 

Con lo cual, la anotacion @PutMapping dirige la solicitud al metodo correspondiente en el controlador y de esta manera efectuar los cambios correspondientes.

```java
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 📘 Controlador para gestionar usuarios
@RestController
public class UsuarioController {

    // 🛠️ Actualiza la información de un usuario existente
    @PutMapping("/usuarios/{id}")
    public String actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario)  // @PathVariable Obtiene el ID del usuario desde la URL @RequestBody Usuario usuario y @RequestBody Recibe los datos del usuario desde el cuerpo de la petición.
     {
        // Aquí normalmente se actualizaría el usuario en la base de datos
        return "✅ Usuario con ID " + id + " actualizado correctamente: " + usuario.getNombre();
     }
}

// Clase modelo simple para representar un usuario
class Usuario {
    private String nombre;
    private String email;

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```
