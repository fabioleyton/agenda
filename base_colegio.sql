CREATE DATABASE IF NOT EXISTS colegio;

USE colegio;

CREATE TABLE estudiantes (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    celular VARCHAR(20) NOT NULL
);
