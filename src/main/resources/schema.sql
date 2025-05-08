
-- Eliminar tablas en orden de dependencia para reiniciar
DROP TABLE IF EXISTS Soporte, Valoracion, Pago, Compra, Entrada, Evento, Usuario;

-- Tabla de usuarios
CREATE TABLE Usuario (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  apellido VARCHAR(100) NOT NULL,
  correo VARCHAR(100) UNIQUE NOT NULL,
  contrasena VARCHAR(255) NOT NULL,
  dni VARCHAR(20) UNIQUE NOT NULL,
  rol ENUM('comprador', 'vendedor', 'organizador', 'soporte') NOT NULL
);

-- Tabla de eventos
CREATE TABLE Evento (
  id_evento INT AUTO_INCREMENT PRIMARY KEY,
  id_organizador INT NOT NULL,
  titulo VARCHAR(255) NOT NULL,
  descripcion TEXT,
  localizacion VARCHAR(255),
  tipo_evento VARCHAR(50),
  fecha_hora DATETIME NOT NULL,
  estado VARCHAR(20) DEFAULT 'activo',
  FOREIGN KEY (id_organizador) REFERENCES Usuario(id_usuario)
);

-- Tabla de entradas
CREATE TABLE Entrada (
  id_entrada INT AUTO_INCREMENT PRIMARY KEY,
  id_evento INT NOT NULL,
  tipo ENUM('general', 'VIP', 'numerada') NOT NULL,
  precio DECIMAL(10,2) NOT NULL,
  numerada BOOLEAN DEFAULT FALSE,
  codigo_unico VARCHAR(100) UNIQUE NOT NULL,
  en_venta BOOLEAN DEFAULT TRUE,
  FOREIGN KEY (id_evento) REFERENCES Evento(id_evento) ON DELETE CASCADE
);

-- Tabla de compras
CREATE TABLE Compra (
  id_compra INT AUTO_INCREMENT PRIMARY KEY,
  id_entrada INT NOT NULL,
  id_comprador INT NOT NULL,
  fecha_compra TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_entrada) REFERENCES Entrada(id_entrada),
  FOREIGN KEY (id_comprador) REFERENCES Usuario(id_usuario)
);

-- Tabla de pagos
CREATE TABLE Pago (
  id_pago INT AUTO_INCREMENT PRIMARY KEY,
  id_compra INT NOT NULL,
  metodo VARCHAR(50),
  estado VARCHAR(20) DEFAULT 'realizado',
  monto DECIMAL(10,2),
  fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_compra) REFERENCES Compra(id_compra)
);

-- Tabla de valoraciones
CREATE TABLE Valoracion (
  id_valoracion INT AUTO_INCREMENT PRIMARY KEY,
  id_usuario_valorado INT NOT NULL,
  id_usuario_que_valora INT NOT NULL,
  puntuacion DECIMAL(2,1),
  comentario TEXT,
  fecha_valoracion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_usuario_valorado) REFERENCES Usuario(id_usuario),
  FOREIGN KEY (id_usuario_que_valora) REFERENCES Usuario(id_usuario)
);

-- Tabla de soporte
CREATE TABLE Soporte (
  id_soporte INT AUTO_INCREMENT PRIMARY KEY,
  id_usuario INT NOT NULL,
  tipo VARCHAR(100),
  descripcion TEXT,
  estado VARCHAR(20) DEFAULT 'pendiente',
  fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
);

-- Datos de prueba: Usuarios
INSERT INTO Usuario (nombre, apellido, correo, contrasena, dni, rol) VALUES
('Laura', 'Gómez', 'laura@correo.com', 'pwd123', '12345678A', 'comprador'),
('Carlos', 'Ruiz', 'carlos@correo.com', 'pwd123', '87654321B', 'vendedor'),
('Marta', 'López', 'marta@correo.com', 'pwd123', '11223344C', 'organizador'),
('Soporte', 'Equipo', 'soporte@evento.com', 'pwd123', '99999999S', 'soporte'),
('Pedro', 'Sánchez', 'pedro@correo.com', 'pwd123', '23456789D', 'comprador'),
('Ana', 'Martínez', 'ana@correo.com', 'pwd123', '34567890E', 'vendedor'),
('Luis', 'Hernández', 'luis@correo.com', 'pwd123', '45678901F', 'organizador'),
('Sara', 'Vega', 'sara@correo.com', 'pwd123', '56789012G', 'comprador');

-- Datos de prueba: Eventos
INSERT INTO Evento (id_organizador, titulo, descripcion, localizacion, tipo_evento, fecha_hora) VALUES
(3, 'Concierto Rock', 'Concierto al aire libre', 'Auditorio Central', 'concierto', '2025-06-10 20:00:00'),
(3, 'Teatro Clásico', 'Obra del siglo XVIII', 'Teatro Nacional', 'obra de teatro', '2025-07-05 19:00:00'),
(7, 'Festival de Jazz', 'Evento con músicos internacionales', 'Plaza Mayor', 'festival', '2025-08-20 18:00:00'),
(3, 'Monólogo de Humor', 'Show de comedia con artistas locales', 'Sala Risueña', 'monólogo', '2025-09-15 21:00:00');

-- Datos de prueba: Entradas
INSERT INTO Entrada (id_evento, tipo, precio, numerada, codigo_unico) VALUES
(1, 'VIP', 75.00, TRUE, 'VIP-RCK-001'),
(1, 'general', 30.00, FALSE, 'GEN-RCK-001'),
(2, 'numerada', 50.00, TRUE, 'NUM-THR-001'),
(3, 'general', 40.00, FALSE, 'GEN-JAZZ-001'),
(3, 'VIP', 90.00, TRUE, 'VIP-JAZZ-002'),
(4, 'numerada', 25.00, TRUE, 'NUM-HUMOR-001'),
(4, 'general', 15.00, FALSE, 'GEN-HUMOR-002');

-- Datos de prueba: Compras
INSERT INTO Compra (id_entrada, id_comprador) VALUES
(2, 1),  -- Laura compra entrada general
(6, 5),  -- Pedro compra numerada humor
(4, 8);  -- Sara compra general festival

-- Datos de prueba: Pagos
INSERT INTO Pago (id_compra, metodo, monto) VALUES
(1, 'tarjeta_credito', 30.00),
(2, 'paypal', 25.00),
(3, 'tarjeta_credito', 40.00);

-- Datos de prueba: Valoraciones
INSERT INTO Valoracion (id_usuario_valorado, id_usuario_que_valora, puntuacion, comentario) VALUES
(2, 1, 4.5, 'Muy buena experiencia, todo correcto.'),  -- Laura valora a Carlos
(6, 5, 5.0, 'Rápido y fiable'),                         -- Pedro valora a Ana
(3, 8, 4.0, 'El evento estuvo bien organizado');        -- Sara valora a Marta

-- Datos de prueba: Soporte
INSERT INTO Soporte (id_usuario, tipo, descripcion) VALUES
(1, 'pago', 'No he recibido confirmación del pago.'),
(5, 'entrada', 'El código de entrada no se puede descargar.'),
(8, 'pago', 'Me han cobrado dos veces por la misma entrada.');
