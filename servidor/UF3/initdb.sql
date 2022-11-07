CREATE TABLE usuario(
    id      VARCHAR(50)     PRIMARY KEY,
    pass    VARCHAR(100)    NOT NULL,
    correo  VARCHAR(255)    NOT NULL    UNIQUE,
    nombre  VARCHAR(255)    NOT NULL
);

CREATE TABLE actividad(
    id      INT     AUTOINCREMENT   PRIMARY KEY,
    titulo  VARCHAR(200)    NOT NULL    UNIQUE,
    ciudad  VARCHAR(100)    NOT NULL,
    tipo    VARCHAR(50)     NOT NULL,
    fecha   DATE            NOT NULL,
    gratis  BOOLEAN         NOT NULL,
    precio  VARCHAR(50),
    usuario VARCHAR(50)     NOT NULL,
    FOREIGN KEY(usuario) REFERENCES usuario(id)
);
