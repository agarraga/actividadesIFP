DROP DATABASE IF EXISTS actividades_db;
CREATE DATABASE actividades_db;
use actividades_db;

CREATE TABLE usuario(
    id      VARCHAR(50)     PRIMARY KEY,
    pass    VARCHAR(100)    NOT NULL,
    correo  VARCHAR(255)    NOT NULL    UNIQUE,
    nombre  VARCHAR(255)    NOT NULL
);

CREATE TABLE actividad(
    id      INT     AUTO_INCREMENT  PRIMARY KEY,
    titulo  VARCHAR(200)    NOT NULL    UNIQUE,
    ciudad  VARCHAR(100)    NOT NULL,
    tipo    ENUM(
        'viaje', 
        'musica', 
        'cultura', 
        'copas', 
        'comida', 
        'cine'
    )   NOT NULL,
    fecha   DATE            NOT NULL,
    precio  ENUM('Bajo', 'Medio', 'Alto'),
    usuario VARCHAR(50)     NOT NULL,
    FOREIGN KEY (usuario) REFERENCES usuario(id)
);

INSERT INTO usuario
VALUES
    ('00ab', '2022', 'fernando@mail.com', 'Fernando Fernandez'),
    ('0e3f', '2022', 'hernanda@mail.com', 'Hernanda Hernandez'),
    ('a338', '2022', 'gonzale@mail.com', 'Gonzale Gonzalez')
;

INSERT INTO actividad(titulo, ciudad, tipo, fecha, precio, usuario)
VALUES
    ('Calzada Nocturida', 'Sendralejos', 'viaje', '2022-11-30', null, '00ab'),
    ('Los Artículos', 'Indera de la Comesda', 'musica', '2022-12-22', 'Medio', '0e3f'),
    ('Bar Las Copas', 'Genuindilia', 'copas', '2023-01-11', 'Bajo', 'a338')
;
