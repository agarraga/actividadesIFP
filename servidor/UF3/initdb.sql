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
    gratis  BOOLEAN         NOT NULL,
    precio  ENUM('Bajo', 'Medio', 'Alto'),
    usuario VARCHAR(50)     NOT NULL,
    FOREIGN KEY (usuario) REFERENCES usuario(id)
);
