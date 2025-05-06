# 🎟️ MDAS - Sistema de Gestión de Eventos y Entradas

Este proyecto simula una aplicación de consola desarrollada en Java para la **gestión de eventos deportivos**, entradas, valoraciones y pagos. Toda la persistencia se maneja mediante **MySQL**, y se sigue una arquitectura basada en **MVC + DAO + DTO**.

---

## 📌 Características principales

- Registro e inicio de sesión de usuarios
- Visualización y gestión de eventos deportivos
- Compra de entradas
- Valoración de eventos
- Solicitud y gestión de reembolsos
- Menú interactivo por consola

---

## 🗂️ Estructura del proyecto

```bash
src/main
├── app/                   # Clase principal con el menú principal
├── java/
│   ├── controller/        # Lógica de negocio
│   ├── data/
│   │   ├── dao/           # Acceso a datos (MySQL)
│   │   └── dto/           # Objetos de transferencia de datos
│   ├── model/             # Clases de dominio
│   └── utils/             # Utilidades y excepciones
└── resources/             # Archivos de configuración y scripts SQL

---

## ⚙️ Configuración y ejecución

### 1. Requisitos previos

- Java 17 o superior
- MySQL Server
- IDE recomendado: IntelliJ IDEA o VSCode
- JDBC driver para MySQL

### 2. Configuración de la base de datos

1. Crear la base de datos en MySQL:
   ```sql
   CREATE DATABASE mdas_db;

2. Configurar archivo config.properties
    ```properties
    db.url=jdbc:mysql://localhost:3306/mdas_db
    db.user=tu_usuario
    db.password=tu_contraseña
    ```

3. Compilacion y ejecucion
    ```bash
    javac -d bin src/main/java/**/*.java
    java -cp bin app.Main
    ```
