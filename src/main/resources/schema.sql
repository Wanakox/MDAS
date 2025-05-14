-- Eliminar tablas respetando dependencias
DROP TABLE IF EXISTS Soporte;
DROP TABLE IF EXISTS Valoracion;
DROP TABLE IF EXISTS Pago;
DROP TABLE IF EXISTS Entrada;
DROP TABLE IF EXISTS Evento;
DROP TABLE IF EXISTS Usuario;

-- Tabla de usuarios
CREATE TABLE Usuario (
  dni VARCHAR(20) PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  correo VARCHAR(100) UNIQUE NOT NULL,
  contrasena VARCHAR(255) NOT NULL,
  cartera FLOAT DEFAULT 0,
  rol ENUM('usuario', 'organizador', 'soporte') NOT NULL
);

-- Tabla de eventos
CREATE TABLE Evento (
  id_evento INT AUTO_INCREMENT PRIMARY KEY,
  id_organizador VARCHAR(20) NOT NULL,
  numeroEntradas INT NOT NULL,
  titulo VARCHAR(255) NOT NULL,
  descripcion TEXT,
  localizacion VARCHAR(255),
  tipo_evento VARCHAR(50),
  fecha_hora DATETIME NOT NULL,
  estado ENUM('activo', 'cancelado', 'finalizado') DEFAULT 'activo',
  FOREIGN KEY (id_organizador) REFERENCES Usuario(dni) ON DELETE CASCADE
);

-- Tabla de entradas
CREATE TABLE Entrada (
  codigo_unico INT AUTO_INCREMENT PRIMARY KEY,
  id_evento INT NOT NULL,
  id_usuario VARCHAR(20) NOT NULL,
  tipo ENUM('general', 'VIP', 'numerada') NOT NULL,
  precio DECIMAL(10,2) NOT NULL,
  asiento INT DEFAULT NULL,
  FOREIGN KEY (id_evento) REFERENCES Evento(id_evento) ON DELETE CASCADE,
  FOREIGN KEY (id_usuario) REFERENCES Usuario(dni) ON DELETE CASCADE
);

-- Tabla de pagos
CREATE TABLE Pago (
  id_compra INT AUTO_INCREMENT PRIMARY KEY,
  id_entrada INT NOT NULL,
  id_comprador VARCHAR(20) NOT NULL,
  fecha_compra TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  estado ENUM('pendiente', 'completada', 'cancelada') DEFAULT 'pendiente',  
  precio FLOAT NOT NULL,
  titular_tarjeta VARCHAR(100) NOT NULL,
  numero_tarjeta VARCHAR(16) NOT NULL,
  fecha_vencimiento DATE NOT NULL,
  cvv VARCHAR(4) NOT NULL,
  FOREIGN KEY (id_entrada) REFERENCES Entrada(codigo_unico) ON DELETE CASCADE,
  FOREIGN KEY (id_comprador) REFERENCES Usuario(dni) ON DELETE CASCADE
);

-- Tabla de valoraciones
CREATE TABLE Valoracion (
  id_valoracion INT AUTO_INCREMENT PRIMARY KEY,
  id_usuario_valorado VARCHAR(20) NOT NULL,
  id_usuario_que_valora VARCHAR(20) NOT NULL,
  puntuacion DECIMAL(2,1) CHECK (puntuacion >= 0 AND puntuacion <= 5),
  fecha_valoracion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_usuario_valorado) REFERENCES Usuario(dni) ON DELETE CASCADE,
  FOREIGN KEY (id_usuario_que_valora) REFERENCES Usuario(dni) ON DELETE CASCADE
);

-- Tabla de soporte
CREATE TABLE Soporte (
  id_soporte INT AUTO_INCREMENT PRIMARY KEY,
  id_usuario VARCHAR(20) NOT NULL,
  tipo ENUM('pago', 'entrada', 'evento', 'otro') NOT NULL,
  descripcion TEXT,
  estado ENUM('pendiente', 'resuelto', 'cerrado') DEFAULT 'pendiente',
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_usuario) REFERENCES Usuario(dni) ON DELETE CASCADE
);

--------------------------- INSERT -----------------------------
-- Usuarios
INSERT INTO Usuario (dni, nombre, apellido, correo, contrasena, cartera, rol) VALUES
('12345678A', 'Juan', 'García', 'juan.garcia@example.com', 'contrasena123', 100.0, 'usuario'),
('98765432B', 'Ana', 'López', 'ana.lopez@example.com', 'contrasena456', 150.0, 'organizador'),
('11223344C', 'Carlos', 'Pérez', 'carlos.perez@example.com', 'contrasena789', 50.0, 'soporte');


-- Eventos (organizados por Marta: C y Luis: F)
INSERT INTO Evento (id_organizador, numeroEntradas, titulo, descripcion, localizacion, tipo_evento, fecha_hora, estado) VALUES
('98765432B', 200, 'Concierto de Rock', 'Concierto en el estadio principal', 'Estadio Nacional', 'concierto', '2025-06-01 20:00:00', 'activo'),
('98765432B', 100, 'Obra de Teatro', 'Una obra impresionante', 'Teatro Gran Vía', 'teatro', '2025-06-10 19:00:00', 'activo');


-- Entradas (vendidas a usuarios por evento)
INSERT INTO Entrada (id_evento, id_usuario, tipo, precio, asiento) VALUES
(1, '12345678A', 'VIP', 100.00, 1),
(1, '11223344C', 'general', 50.00, 2),
(2, '12345678A', 'numerada', 30.00, 10);


-- Pagos (por cada entrada comprada)
INSERT INTO Pago (id_entrada, id_comprador, fecha_compra, estado, precio, titular_tarjeta, numero_tarjeta, fecha_vencimiento, cvv) VALUES
(1, '12345678A', '2025-05-01 14:30:00', 'completada', 100.00, 'Juan García', '1234567812345678', '2026-12-01', '123'),
(2, '11223344C', '2025-05-02 15:00:00', 'pendiente', 50.00, 'Carlos Pérez', '2345678923456789', '2025-11-01', '456');


-- Valoraciones
INSERT INTO Valoracion (id_usuario_valorado, id_usuario_que_valora, puntuacion, fecha_valoracion) VALUES
('12345678A', '98765432B', 4.5, '2025-05-01 16:00:00'),
('11223344C', '98765432B', 3.0, '2025-05-02 17:00:00');


-- Soporte
INSERT INTO Soporte (id_usuario, tipo, descripcion, estado, fecha_creacion) VALUES
('12345678A', 'pago', 'Problema con el pago de la entrada VIP', 'pendiente', '2025-05-01 14:30:00'),
('11223344C', 'entrada', 'Entrada no válida para el asiento numerado', 'resuelto', '2025-05-02 15:00:00');


