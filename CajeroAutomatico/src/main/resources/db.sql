CREATE DATABASE BancoDB;
USE BancoDB;

-- ========================
-- TABLA USUARIO
-- ========================
CREATE TABLE Usuario (
    usuario_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    telefono VARCHAR(15),
    pin_usuario INT 
);

-- ========================
-- TABLA CUENTA
-- ========================
CREATE TABLE Cuenta (
    cuenta_id INT PRIMARY KEY AUTO_INCREMENT,
    numero_cuenta BIGINT,
    saldo DECIMAL(15,2)
);

-- ========================
-- RELACIÓN MUCHOS A MUCHOS USUARIO-CUENTA
-- ========================
CREATE TABLE Usuario_Cuenta (
    usuario_id INT,
    cuenta_id INT,
    PRIMARY KEY (usuario_id, cuenta_id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id),
    FOREIGN KEY (cuenta_id) REFERENCES Cuenta(cuenta_id)
);

-- ========================
-- TABLA TARJETA
-- ========================
CREATE TABLE Tarjeta (
    tarjeta_id INT PRIMARY KEY AUTO_INCREMENT,
    numero_tarjeta BIGINT NOT NULL UNIQUE,
    fecha_expiracion DATE NOT NULL,
    cuenta_id INT ,
    usuario_id INT ,
    FOREIGN KEY (cuenta_id) REFERENCES Cuenta(cuenta_id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(usuario_id)
);

-- ========================
-- TABLA PRESTAMO
-- ========================
CREATE TABLE Prestamo (
    prestamo_id INT PRIMARY KEY AUTO_INCREMENT,
    monto DECIMAL(15,2) ,
    tasa_interes DECIMAL(5,2) ,
    fecha_inicio DATE,
    fecha_fin DATE ,
    tipo_de_pago VARCHAR(50) ,
    cuenta_id INT ,
    FOREIGN KEY (cuenta_id) REFERENCES Cuenta(cuenta_id)
);

-- ========================
-- TABLA TIPO DE TRANSACCION
-- ========================
CREATE TABLE Tipo_Transaccion (
    tipo_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_tipo VARCHAR(50)  
);

-- ========================
-- TABLA ESTADO DE TRANSACCION
-- ========================
CREATE TABLE Estado_Transaccion (
    estado_id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_estado VARCHAR(50)
);

-- ========================
-- TABLA TRANSACCION
-- ========================
CREATE TABLE Transaccion (
    transaccion_id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE ,
    fecha_programada DATETIME , 
    monto DECIMAL(15,2) ,
    cuenta_id INT ,
    tipo_id INT ,
    estado_id INT ,
    tarjeta_id INT ,
    FOREIGN KEY (cuenta_id) REFERENCES Cuenta(cuenta_id),
    FOREIGN KEY (tipo_id) REFERENCES Tipo_Transaccion(tipo_id),
    FOREIGN KEY (estado_id) REFERENCES Estado_Transaccion(estado_id),
    FOREIGN KEY (tarjeta_id) REFERENCES Tarjeta(tarjeta_id)
);

-- ========================
-- EJEMPLO DE BATCH PARA PROCESAR TRANSFERENCIAS PENDIENTES
-- ========================
/*
UPDATE Transaccion
SET estado_id = (SELECT estado_id FROM Estado_Transaccion WHERE nombre_estado = 'EFECTUADO')
WHERE tipo_id = (SELECT tipo_id FROM Tipo_Transaccion WHERE nombre_tipo = 'TRANSFERENCIA')
  AND estado_id = (SELECT estado_id FROM Estado_Transaccion WHERE nombre_estado = 'PENDIENTE')
  AND fecha_programada <= NOW();
*/
