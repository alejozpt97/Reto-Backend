Requisitos
Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes programas:

* MySQL: Versión 8.0.21 o la version que sea compatible con tu ordenador
* Postman: Para realizar pruebas de API.
* MySQL Workbench: Versión 8.0.12  o la version que sea compatible con tu ordenador para administrar la base de datos.
* Java: Versión 17.0.12 
* Visual Studio Code: Versión 1.9.3.1 o la version que sea compatible con tu ordenador
Descargar una extension en vs code de Spring Initializr Java Support, esto es necesario para la utilizacion del codigo java
y tambien descargar la extension de Test Runner for Java para correr el programa en codigo java


Pasos para la utilizacion de este programa

Configuración de la Base de Datos
Crear la Base de Datos: Abre MySQL Workbench y ejecuta el siguiente comando para crear la base de datos:

- Estos codigos los veras en la carpeta BaseDatos.sql

tener en cuenta que los nombres que crees en la base de datos deben ser iguales a los que estan en este codigo


Conectar la Aplicación a la Base de Datos: Asegúrate de que tu archivo de configuración de Spring (por ejemplo, application.properties) esté correctamente configurado:

properties

spring.application.name=Company

spring.datasource.url=jdbc:mysql://localhost/Company?serverTimezone=UTC
spring.datasource.username=root  (Revisar si este username es igual al que tiene tu al crear tu base de datos sino es igual cambia el nombre por que tienes)
spring.datasource.password= Esta contraseña es la que tienes que tienes para tu base de datos

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update

Reviar que al correr codigo no te muestre error
para poder usar Postman se debe correr primero el codigo en vs code

API REST
La aplicación utiliza una API REST para manejar operaciones sobre la tabla de empleados. A continuación se describen los endpoints disponibles.

1. Crear un Empleado
Método: POST

Endpoint: /employees

Ejemplo de Petición:

json

{
    "name": "Juan",
    "last_name": "Pérez",
    "email": "juan.perez@example.com",
    "employmentdate": "2024-09-28"
}

2. Obtener todos los Empleados
Método: GET

Endpoint: /employees

3. Obtener un Empleado por ID
Método: GET

Endpoint: /employees/{id_employee}

4. Actualizar un Empleado
Método: PUT

Endpoint: /employees/{id_employee}

Ejemplo de Petición:

json

{
    "name": "Juan",
    "last_name": "Gómez",
    "email": "juan.gomez@example.com",
    "employmentdate": "2024-09-29"
}

5. Eliminar un Empleado
Método: DELETE

Endpoint: /employees/{id_employee}



Uso de Postman

Para realizar peticiones a la API, puedes utilizar Postman:

Abre Postman.
Selecciona el método HTTP correspondiente (GET, POST, PUT, DELETE).
Ingresa la URL del endpoint.
Para POST y PUT, selecciona Body, elige raw, y selecciona JSON en el menú desplegable.
Haz clic en Send para enviar la petición.

Ejemplo de Uso

Crear un Empleado
Selecciona POST en Postman.
Ingresa la URL: http://localhost:8080/employees.
En el cuerpo de la petición, incluye los detalles del nuevo empleado en formato JSON.
Haz clic en Send.
Actualizar un Empleado
Selecciona PUT en Postman.
Ingresa la URL: http://localhost:8080/employees/1 (donde 1 es el ID del empleado a actualizar).
Incluye los nuevos detalles en formato JSON.
Haz clic en Send.
Eliminar un Empleado
Selecciona DELETE en Postman.
Ingresa la URL: http://localhost:8080/employees/1.
Haz clic en Send.
