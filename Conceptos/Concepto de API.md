# 🧠 Que es una API?
Una API, es un conjunto de definiciones de protocolos que facilitan la comunicacion y la interaccion entre diferentes componentes de softwares.

Las cuales actuan como puentes que permiten que aplicaciones y sistemas se comuniquen de manera eficiente y coherente.

Ahora bien, ¿Que siginifica API?, significa **Interfaz de programacion de aplicaciones**. En el contexto de la API, la palabra aplicacion se refiere a cualquier software con un funcion distinta. La interfaz puede considerarse como un contrato de servicio entre dos aplicaciones. Este contrato se define como se comunican entre si mediante solicitudes y respuestas.

## Arquitecturas de una API
La arquitectura de una API se refiere a las reglas que rigen como se comparten los datos con los clientes. Las API tienen distintos tipos de arquitectura, las cuales suelen explicarse en terminos de cliente servidor. Donde la aplicacion que envia la solicitud se llama cliente, y la que envia la respuesta se llama servidor. 

Una de las arquitecturas mas comunes dentro de una API son:
- **SOAP**
- **RPC**
- **WebSocket**
- **REST (EN ESTE CURSO NOS CENTRAREMOS EN ESTA)**


## Que es la arquitectura REST?
REST o transferencia de estado representacional, es la arquitectura mas comun para APIs debido a su escalabilidad y facilidad de implementacion. **NOTA:** REST tambien puede denominarse RESTful.

La arquitectura REST esta basada en estandares web que utilizan metodos HTTP (GET, POST, PUT, PATCH, DELETE) para realizar operaciones CRUD (crear, leer, actualizar y eliminar) en recursos que son identificados como URLs.

REST utiliza el concepto de recursos y manipulacion de estos recursos a traves de interfaces uniformes. Donde los cursos son entidades de informacion que son identificadas mediante URLs.

Estos recursos pueden ser cualquier cosa que puede ser denominada y a la que se pueda acceder a traves de la red, como datos, archivos, servicios, etc. Cada recurso en una arquitectura REST tiene una representacion asociada, que puede ser en diferentes formatos como JSON, XML, HTML, entre otros. Esta representacion es la que se envia o se recibe cuando se accede al recurso a traves de la API REST.

**En resumen, podemos decir que los recursos en una arquitectura REST son entidades de informacion identificadas por URLs y pueden ser accedidos y manipulados a traves de los metodos HTTP para realizar operaciones CRUD.**


## ❗ Restricciones de una API REST
Las API REST siguen restricciones claves que indican las reglas y condiciones que deben seguirse para cumplir con el estilo arquitectonico REST.
- **Separacion CLIENTE-SERVIDOR:** Esto permite que los cambios en cualqueira de los extremos no repercutan en el opuesto, favoreciendo la escalabilidad y la flexibilidad.
- **Interfaz Uniforme:** Todas las peticiones y respuestas pertenecen a un identificador uniforme de recursos (URI), lo que significa que todas tienen el mismo formato y se transmiten a traves de protocolos HTTP.  
- **Sin Estado:** Las aplicaciones de servidor no pueden almacenar datos de las peticiones de los clientes y cada peticion es independiente de la siguiente.
- **Sistema en Capas:** Dado que el servidor y el cliente estan desacoplados, las solicitudes y respuestas se envian a traves de multiples aplicaciones, lo que requiere que contengan un formato coherente. Ademas, la API REST esta diseñada para que el ni el cliente ni el servidor puedan identificar si se esta comunicando con una aplicacion final o con un intermediario.
- **Almacenamiento en Cache:** El objetivo es ayudar a reducir las restricciones de la falta de estado, mejorar el rendimiento del lado del cliente, aumentar los resultados del lado del servidor y, en general, reducir el tiempo medio de respuesta.  

------

# Conclusion
Una API es un conjunto de reglas y definiciones que permite que diferentes aplicaciones se comuniquen entre si.

Mientras que una API REST es un estilo arquitectonico para diseñar redes y servidores web que utiliza el protocolo HTTP para acceder y manipular los recursos. 
