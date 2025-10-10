# 🧠 Que es la Arquitectura basada en capas?
La arquitectura basada en capas es un enfoque comunmente utilizado para disenar sistemas de software, ademas, se puede aplicar igualmente en el diseno y desarrollo de un microservicio. La idea de implementar la arquitectura basada en capas, es segmentar responsabilidades en distintas capas. 

En esta arquitectura tenemos tres capas basicas principales: 
- **Capa de Presentacion.**
- **Capa de Logica de Negocio.**
- **Capa de Acceso a Datos.**

**Nota: Ademas de estas capas basicas, tambien puede incluir otras capas adicionales, como lo son: la capa de integracion y la capa de seguridad.**



## 🧩 Capa de Presentacion
En un microservicio, la capa de presentacion suele ser minima o incluso inexistente, ya que los microservicios generalmente no tienen una interfaz de usuario directa. Sin embargo, en algunos casos un microservicio podria tener una API de interfaz de usuario para interacturar con otras partes del sistema o con aplicaciones externas. En este caso, esta capa podria consistir en los controladores que exponen esta API.


## 🧩 Capa de Logica de Negocio
En esta capa, es donde se implementa la logica de negocio especifica de la aplicacion. En el contexto de un microservicio, esta capa se compone principalmente de servicios, que son las clases que implementan la logica de negocio especifica del servicio y proporcionan una interfaz para interactuar con ella.

Esto significa que los servicios son responsables de implementar las reglas de negocio, realizar calculos, validar datos y coordinar las operaciones necesarias para cumplir con los requisitos del negocio. 


## 🧩 Capa de Acceso a Datos
Esta capa es responsable de interactuar con la base de datos u otros sistemas de almacenamiento de datos.

En un microservicio, cada servicio podria tener su propia base de datos o compartir una base de datos con otros microservicios, dependiendo de la necesidad y de la arquitectura especifica.


## 🧩 Capa de Integracion
Esta capa se utiliza para integrar el microservicio con otros sistemas externos o con otros microservicios dentro de la misma arquitectura de microservicios. Este puede incluir componentes de comunicacion como clientes HTTP, clientes de servicio web, colar de mensajes, etc.

## 🧩 Capa de Seguridad
Esta capa se encarga de implementar medidas de seguridad, como la autenticacion y la autorizacion, para proteger el microservicio contra accesos no autorizados.

Puede incluir componentes como filtros de seguridad, tokens de acceso, etc.
