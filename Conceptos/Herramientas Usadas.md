# ⚙️ Herramientas Usadas y sus Conceptos

-----

## 🧩 Kit de Desarrollo Java (JDK)
Es un software que provee herramientas de desarrollo para la creacion de programas con java.
**Nota: Para desarrollar aplicaciones en Spring Boot, es necesario tener instalado el JDK a partir de su version 17 o en adelante.**

-----

## 🧩 Entorno de Desarrollo Integrado (IDE)
Es una aplicacion que proporciona servicios integrales para facilitar al desarrollador o programador el desarrollo de software.

-----

## 🧩 Postman 
Es una herramienta de desarrollo de API que permite a los desarrolladores crear, probar, documentar y compartir APIs de manera eficiente.

Es especialmente util en el proceso de desarrollo de software cuando se trabaja con APIs RESTful o cualquier otro tipo de API basada en HTTP.

-----

# 📟 Como Creamos Nuestros Primeros Proyectos
Para la realizacion o creacion de nuestros proyectos utilizaremos una herramienta que se llama **Spring Initializr**.
Es una herramiena en linea que permite a los desarrolladores crear rapidamente proyectos de aplicaciones Spring Boot personalizados. Al utilizar esta herramienta, los desarrolladores pueden especificar las dependencias, la version de Spring Boot, el lenguaje de programacion (Java, Kotlin, Groovy), el sistema de construccion (Maven o Grandle), y otras configuraciones especificas del proyecto.

Una vez que se especifican estas opciones, Spring initializr genera un esqueleto de proyecto listo para usar que puede ser importado en un entorno de desarrollo integrado (IDE) como intelliJ IDEA, Visual Studio Code y demas.

-----

# 🧾 Jar VS War 
Al momento de nosotros crear nuestro proyocto, podemos especificar alguna de estas dos opciones, la eleccion de estas depende en como quieres tu que empaquete y despliegue tu aplicacion. Por otra parte, tambien depende del tipo de aplicacion que estas desarrollando y como planeas implementarla. 

## Archivo JAR (Java Archive) 
Es un formato de archivo que contiene codigo Java y otros recursos necesarios para ejecutar una aplicacion de forma independiente. En el caso de Spring Boot, un JAR contiene un servidor web incorporado (como tomcat, jetty o undertow) junto con tu aplicacion. 
- **Cuando es bueno utilizarlo?** : Estos son adecuados para aplicaciones autonomas que no requieren un servidor de aplicaciones externo. Son ideales para aplicaciones Spring boot que necesitan ser autocontenidas y pueden ejercutarse con java -jar sin necesidad de un servidor web externo.
## Archivo WAR (Web Application Archive)
Es un formato de archivo utilizado comunmente para empaquetar aplicaciones web Java que se despliegan en servidores de aplicaciones, como Tomcat, Jetty o WildFly. Contiene tu aplicacion junto con los recursos necesarios para ejecutarse en un servidor web externo.
- **Cuando es bueno utilizarlo?** : Esto es util cuando estas desarrollando una aplicacion web tradicional y no necesitas incorporar un servicio web en el archivo JAR. Puedes crear un archivo WAR y desplegarlo en un servidor web compatible.
## En Resumen
Si estas desarrollando una aplicacion Spring Boot independiente que se ejecuta con su propio servidor web embebido, debes elegir JAR.

Si estas desarrollando una aplicacion web Java tradicional que se ejecutara en un servidor de aplicaciones externo, debes elegir WAR.
