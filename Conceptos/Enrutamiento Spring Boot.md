# 🧠 Que es el Enrutamiento en Spring Boot?
El enrutamiento o tambien conocido como asignacion de URL, es el proceso mediante el cual Spring Boot decide que metodo de controlador ejecutar en respuesta a una solicitud HTTP especifica.

En spring boot se utilizan varias anotaciones de mapeo para definir que metodo de controlador manejara una solicitud HTTP especifica, **algunas de las mas comunes son:**
-  **@GetMapping:** Mapea las solicitudes HTTP GET a metodos especificos.
-  **@PostMapping:** Mapea las solicitudes HTTP POST a metodos especificos.
-  **@PutMapping:** Mapea las solicitudes HTTP PUT a metodos especificos.
-  **@DeleteMapping:** Mapea las solicitudes HTTP DELETE a metodos especificos.


-----

# 🚀 Coincidencia de Patrones URL 
Spring boot utiliza un enfoque basado en enfoques para asignar solicitudes a metodos de controlador. Esto significa que puede tener multiples metodos de controlador con la misma ruta de acceso base, pero diferentes patrones adicionales, como parametros de ruta o extensiones para diferenciarlos.

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// La anotación @RestController indica que esta clase manejará solicitudes HTTP.
@RestController
public class UsuarioController {

    // -----------------------------
    // RUTA GET: obtener información
    // -----------------------------
    @GetMapping("/usuarios")
    public String obtenerUsuarios() {
        return "Lista de usuarios registrados";
    }

    // -------------------------------------
    // RUTA GET con parámetro en la URL
    // Ejemplo: /usuarios/5
    // -------------------------------------
    @GetMapping("/usuarios/{id}")
    public String obtenerUsuarioPorId(@PathVariable int id) {
        return "Detalles del usuario con ID: " + id;
    }

    // ------------------------------------------
    // RUTA POST: crear un nuevo usuario
    // Recibe datos mediante el cuerpo (RequestBody)
    // ------------------------------------------
    @PostMapping("/usuarios")
    public String crearUsuario(@RequestBody String datosUsuario) {
        return "Usuario creado con los siguientes datos: " + datosUsuario;
    }
}
```
