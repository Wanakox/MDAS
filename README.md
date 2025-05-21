# 🎟️ MDAS - Sistema de Gestión de Eventos y Entradas

Este proyecto es una aplicación de consola desarrollada en Java para la **gestión de eventos**, compra de entradas, valoraciones y gestión de pagos y reembolsos. La persistencia de datos se realiza mediante archivos de texto planos y se sigue una arquitectura basada en **MVC + DAO + DTO**.

Enlace al repositorio público creado para la práctica: https://github.com/Wanakox/MDAS

---

## 📌 Características principales

- Registro e inicio de sesión de usuarios✅
- Visualización y gestión de eventos✅
- Compra y gestión de entradas
- Valoración de eventos
- Solicitud y gestión de reembolsos
- Menú interactivo por consola ✅

---

## 🗂️ Estructura del proyecto

```bash
├── documentation.pdf                   # Documento explicativo de la práctica 1
├── Enunciado_Problema.pdf              # Enunciado del problema o caso de estudio
├── out                                 # Carpeta de salida (generada por el compilador)
├── README.md                           # Archivo de documentación del proyecto
├── start.sh                            # Script para compilar o ejecutar el proyecto
├── src
│   └── main
│       ├── app
│       │   └── Main.java               # Clase principal del proyecto (punto de entrada)
│       ├── java
│       │   ├── controller              # Controladores para manejar la lógica de negocio
│       │   │   ├── EntradaController.java
│       │   │   ├── EventoController.java
│       │   │   ├── PagoController.java
│       │   │   ├── ReembolsoController.java
│       │   │   ├── UsuarioController.java
│       │   │   └── ValoracionController.java
│       │   ├── data
│       │   │   ├── dao                 # Clases DAO para acceso a datos
│       │   │   │   ├── EntradaDAO.java
│       │   │   │   ├── EventoDAO.java
│       │   │   │   ├── PagoDAO.java
│       │   │   │   ├── ReembolsoDAO.java
│       │   │   │   ├── UsuarioDAO.java
│       │   │   │   └── ValoracionDAO.java
│       │   │   └── dto                 # Objetos de transferencia de datos (DTOs)
│       │   │       ├── EntradaDTO.java
│       │   │       ├── EventoDTO.java
│       │   │       ├── PagoDTO.java
│       │   │       ├── ReembolsoDTO.java
│       │   │       ├── UsuarioDTO.java
│       │   │       └── ValoracionDTO.java
│       │   ├── model                   # Clases del modelo de dominio
│       │   │   ├── Entrada.java
│       │   │   ├── Evento.java
│       │   │   ├── Pago.java
│       │   │   ├── Reembolso.java
│       │   │   ├── Usuario.java
│       │   │   ├── UsuarioNormal.java
│       │   │   ├── UsuarioOrganizador.java
│       │   │   ├── UsuarioSoporte.java
│       │   │   └── Valoracion.java
│       │   └── patterns                # Patrones de diseño utilizados en el proyecto
│       │       ├── builder
│       │       │   └── DirectorEvento.java
│       │       └── factory
│       │           ├── TipoUsuario.java
│       │           └── UsuarioFactory.java
│       └── resources                   # Archivos de datos utilizados por el sistema
│           ├── entrada.txt
│           ├── evento.txt
│           ├── pago.txt
│           └── usuarios.txt
```

## ⚙️ Uso

Al ejecutar el script `./start.sh` dentro de la carpeta `/MDAS`, el sistema compilará el proyecto y desplegará un menú interactivo en consola, donde podrás:

- Acceder al registro, inicio de sesión o listar todos los usuarios.
- Menú de usuario: ver eventos disponibles, comprar entradas (TODO), comprar entradas de otro usuario (TODO), ver entradas compradas.
- Menú de soporte: listo para futuras implementaciones
- Menú de organizador: crear evento, editar evento, ver eventos, buscar evento por ID, cancelar evento.


### Usuarios disponibles para poder acceder al sistema
En esta parte vas a poder encontrar los diferentes posibles menús de nuestra aplicación

#### Organizador
Correo: 1234alber@hotmail.com
Contraseña:i22alberto
#### Soporte
Correo: 1234angel@hotmail.com
Contraseña: i22angel
#### Usuario
Correo:1234aitor@hotmail.com
Contraseña:i22aitor

---

## 📁 Archivos de datos

La aplicación utiliza archivos planos para la persistencia de datos, ubicados en la carpeta de recursos. Entre ellos se encuentran:

- `entrada.txt` — Registra la información sobre las entradas vendidas.
- `evento.txt` — Contiene los datos de los eventos deportivos disponibles.
- `pago.txt` — Registra los pagos realizados por las entradas.
- `usuarios.txt` — Almacena la información de los usuarios registrados.

Estos archivos son leídos y actualizados por los DAOs para mantener la consistencia del sistema.

---

## 📄 Documentación

Para una descripción más detallada del proyecto, arquitectura y flujo de trabajo, revisa el archivo `documentation.pdf` incluido en la raíz del repositorio.

Además, el documento `Enunciado_Problema.pdf` describe el planteamiento original y los requisitos funcionales del sistema.

### Documentación del código
Para poder ver todos los comentarios de nuestro código podemos acceder al directorio html para poder ejecutar el index.html y ver el doxygen.
---

## 🛠️ Arquitectura y diseño

El sistema está basado en una arquitectura modular con separación clara de responsabilidades siguiendo los patrones:

- **MVC (Modelo-Vista-Controlador):**  
  - *Modelo:* Clases que representan las entidades del dominio (Usuario, Evento, Entrada, Pago, Reembolso, Valoración).  
  - *Controlador:* Gestiona la lógica de negocio y la interacción con el usuario a través de la consola.  
  - *Vista:* Implementada en la consola mediante menús interactivos.

- **DAO (Data Access Object):** Acceso y manipulación de datos desde los archivos de persistencia.

- **DTO (Data Transfer Object):** Objetos utilizados para transferir datos entre capas del sistema sin exponer detalles internos.

- **Patrones de diseño:**  
  - *Builder:* Para la creación flexible de eventos deportivos.  
  - *Factory:* Para la creación de distintos tipos de usuarios según su rol.
  - *Singleton:* Para mantener la coherencia dentro de los ficheros
---


## Componentes implementados
En este apartado podremos ver la especificación de todos los componentes que hemos implementado y su correspondencia en los ficheros de nuestra práctica. Aquí también especificaremos los cambios que hemos realizado
### Componentes de negocio
En esta parte vamos a implementar los componentes de negocio y vamos a explicar cada una de las partes correspondientes.
#### Componente 1: Evento
##### Explicación y correspondencia con el código
En este componente encontramos uno de los componentes core que se encarga de recopilar todas las partes más importantes relacionadas con el evento. Por ello la correspondencia con los archivos es la siguiente: `evento.txt` (contiene toda la información de  los eventos), `evento.java` (parte del modelo del evento con getters, setters y constructores), `eventoController`(recopila las principales funciones de control), `DAO y DTO` (para manejar los datos del fichero)
##### Cambios realizados
- Se ha añadido el campo idEvento para poder identificar a cada una de los eventos que hemos ido creando.
#### Componente 2: Usuario
##### Explicación y correspondencia con el código
En este componente vamos a tener el aspecto relacionado con el usuario que abarcaría con el inicio de sesión, registro, listar usuarios o realizar valoraciones. Este componente tiene mucha relación, con el componente del sistema de sesión. La correspondencia con los archivos es la siguiente: `usuarios.txt` (contiene toda la información de los usuarios), `usuario.java` (modelo del usuario con getters, setters y constructores), `usuarioController` (recopila las principales funciones de controlc, `DAO y DTO` (para manejar los datos del fichero))
##### Cambios realizados
- Añadidas todas las funciones relacionadas con el saldo porque fueron omitidas en la parte de diseño.
- Funciones para realizar diferentes busquedas con distintos parámetros
---

### Componentes del sistema
En este apartado vamos a pasar a hacer una especificación detallada de los diferentes componentes del sistema, explicando a su vez algunos de los cambios realizados.
#### Componente 1: Evento
##### Explicación y correspondencia con el código
Dentro de este componente de sistema encontramos todas las partes relacionadas con el evento, en nuestro proyecto se encuentran las siguientes interfaces con sus correspondencias se encuentran dentro de estos ficheros: `evento.txt` (donde almacenan todos los datos), `evento.java` (modelo para obtener los getters, setters y constructor), `DAO y DTO` (acceden al fichero para poder acceder a todos los datos) , `EventoController.java` (se encuentra toda la lógica de control)
- ICrearEvento
- ICancelarEvento
- IEditarEvento
- IListarEvento
##### Cambios realizados

#### Componente 2: Sesión
##### Explicación y correspondencia con el código
Dentro de este componente podemos encontrar las partes que se relacionan con la sesión, haciendo uso del registro y del inicio de sesión. Por ello utilizan los siguientes ficheros dentro de nuestro código: `usuarios.txt` (donde almacena todos los datos del usuario), `usuarios.java` (modelo para obtener los getters, setters y constructor), `DAO y DTO` para poder acceder a todos los datos de nuestro fichero, `UsuarioController.java` (se encuentra toda la lógica de control para iniciar o registrarse). \\
Interfaces implementadas:
- IInicioSesion
- IRegistro
#### Componente 3: Entrada
##### Explicación y correspondencia con el código
Dentro de este componenete vamos a encontrar algunas de las partes que implementamos no hemos realizado un desarrollo completo porque nos dimos cuenta de que no era necesario, pero vemos oportuno escribir poner las partes que hemos realizado para aumentar nuestro trabajo. Los ficheros que utilizaremos son: `entrada.txt` (donde se almacena todos los datos de nuestras entradas), `entradas.java` (modelo para obtener los getters, setters y los constructores), `DAO y DTO` para acceder a todos los datos de nuestro fichero, `EntradaController.java` (encuentra toda la lógica de control para iniciar o registrarse).
##### Cambios realizados
- Añadir el campo id a la entrada para poder identificarlo
- Añadir el campo idEvento a la entrada para relacionarla con el evento al que pertenece.
- Añadir el booleano dispReembolso para identificar cuando una entrada está disponible para su reembolso. 
---