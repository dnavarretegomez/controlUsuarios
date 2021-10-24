# ControlUsuarios
Uso exclusivo para la prueba de banco BCI


### Herramientas necesarias para ejecutar el proyecto
1. Eclipse IDE (con plugins de Spring) o SpringTools Suite
2. Maven
3. Java 1.8+
4. Postman

### tecnologias ocupadas
1. Springboot Framework
2. Java 8
3. Base de datos H2
4. Persistencia con JPA - Hibernate
5. Maven repository


### Para probar seguir el paso a paso

1. descargue el proyecto a un repositorio local
2. seleccione la opción import->maven->Existing Maven Proyects
3. Selecciona la ruta en donde descargaste el proyecto de tu repositorio local
4. Dirígete a Boot Dashboard en donde aparecerá el componente usuario
5.  inicia el componente Usuario
5.1. (opcional) el programa por defecto inicia a través de http://localhost:8080 si se requiere cambiar puerto agregar al archivo application.properties el comando server.port=(puerto a asignar) por ejemplo server.port=8090
6. Abrir Postman e importar la colección BCI.postman_collection.json. Este archivo contiene el servicio principal (Registro) solicitado en el documento y otros servicios anexos en referencia a el manejo de sesión.
7. probar.

# Problemática

Desarrolle una aplicación que exponga una API RESTful de creación de usuarios.
Todos los endpoints deben aceptar y retornar solamente JSON, inclusive al para los mensajes de
error.
Todos los mensajes deben seguir el formato:
`{"mensaje": "mensaje de error"}`
### Servicio Registro
Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña",
más un listado de objetos "teléfono", respetando el siguiente formato:


    {
    	"name": "Juan Rodriguez",
    	"email": "juan@rodriguez.org",
    	"password": "hunter2",
    	"phones": [
    		{
    			"number": "1234567",
    			"citycode": "1",
    			"contrycode": "57"
    		}
    	]
    }

# Solución
Para este problema se pide generar un servicio de registro y además persistir el token con el usuario. Para realizar las pruebas tome dos escenarios simples:
1. Parte desde el registro el cual obtiene un token generado por UUID con la sesión activa, este busca obtener una lista con todos los usuarios de la base de datos a través de su token recién creado, una vez obtiene los usuarios cierra la sesión.
2. el usuario ya existe en el sistema y busca la lista de usuarios con su usuario ya creado. (este genera un nuevo token)

## Diagramas
A continuación se muestra las interacciones del sistema a través de diagramas de secuencias.

Desde el registro
[![Interacción desde el Registro](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Solucion%20registro.png?raw=true "Interacción desde el Registro")](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Solucion%20registro.png?raw=true "Interacción desde el Registro")

Desde el Login
[![Interacción de Login](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Solucion%20desde%20login.png?raw=true "Interacción de Login")](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Solucion%20desde%20login.png?raw=true "Interacción de Login")


Diagrama de Base de datos utilizada
[![Diagrama de base de datos](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/diagrama%20base%20de%20datos.png?raw=true "Diagrama de base de datos")](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/diagrama%20base%20de%20datos.png?raw=true "Diagrama de base de datos")


# Pruebas desde postman
Dentro de este mismo repositorio se almaceno la collecion ocupada para los ejemplos.

### Caso 1 registro

[![Servicio registro](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Prueba%20servicio%20registro.png?raw=true "Servicio registro")](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Prueba%20servicio%20registro.png?raw=true "Servicio registro")

### Caso 2 Validate Token
Correcto
[![ValidateToken correcto](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Prueba%20validateToken.png?raw=true "ValidateToken correcto")](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Prueba%20validateToken.png?raw=true "ValidateToken correcto")

Usuario deslogueado / token invalido
[![Usuario deslogueado/ token invalido](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Prueba%20Validate%20Token%20con%20usuario%20deslogueado.png?raw=true "Usuario deslogueado/ token invalido")](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Prueba%20Validate%20Token%20con%20usuario%20deslogueado.png?raw=true "Usuario deslogueado/ token invalido")

### Obtener usuarios

Correcto
[![Obtener usuario](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Prueba%20obtener%20usuarios.png?raw=true "Obtener usuario")](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Prueba%20obtener%20usuarios.png?raw=true "Obtener usuario")

Token incorrecto
[![token incorrecto obtener usuarios](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/prueba%20obtener%20usuarios%20con%20token%20invalido.png?raw=true "token incorrecto obtener usuarios")](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/prueba%20obtener%20usuarios%20con%20token%20invalido.png?raw=true "token incorrecto obtener usuarios")

### logout

[![Logout](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Prueba%20logout.png?raw=true "Logout")](https://github.com/dnavarretegomez/controlUsuarios/blob/main/Postman%20collection%20e%20imagenes/Prueba%20logout.png?raw=true "Logout")
