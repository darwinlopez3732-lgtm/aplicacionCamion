CREATE database conexion_BD;
USE conexion_BD;


CREATE TABLE Ciudad (
    idCiudad INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);



CREATE TABLE Camionero (
    idCamionero INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    direccion VARCHAR(200),
    salario DECIMAL(10,2) NOT NULL,
    poblacion VARCHAR(100),
    dpi VARCHAR(20) NOT NULL UNIQUE,
    telefono VARCHAR(20)
);


CREATE TABLE Camion (
    idCamion INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    potencia DECIMAL(10,2),
    noPlaca VARCHAR(20) NOT NULL UNIQUE
);



CREATE TABLE ConductorCamion (
    idConductorCamion INT AUTO_INCREMENT PRIMARY KEY,
    idCamionero INT NOT NULL,
    idCamion INT NOT NULL,
    fecha DATE NOT NULL,

    CONSTRAINT fk_conductor_camionero
        FOREIGN KEY (idCamionero)
        REFERENCES Camionero(idCamionero),

    CONSTRAINT fk_conductor_camion
        FOREIGN KEY (idCamion)
        REFERENCES Camion(idCamion)
);


CREATE TABLE Paquete (
    idPaquete INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    destinatario VARCHAR(150) NOT NULL,
    peso DECIMAL(10,2) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    idCamionero INT NOT NULL,
    idCiudad INT NOT NULL,

    CONSTRAINT fk_paquete_camionero
        FOREIGN KEY (idCamionero)
        REFERENCES Camionero(idCamionero),

    CONSTRAINT fk_paquete_ciudad
        FOREIGN KEY (idCiudad)
        REFERENCES Ciudad(idCiudad)
);



SHOW TABLES;
