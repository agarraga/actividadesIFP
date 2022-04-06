/* 
 * No se porqué decidí utilizar Postgresql en vez de MySql y me está dando 
 * bastantes problemas. No le gusta nada cuando intento cambiar el `collate' ya
 * que dice que es_ES no es compatible con Latin1. Ademas hay un problema de 
 * compatibilidad de versiones por lo cual no me deja utilizar IF NOT EXISTS.
 */
DROP DATABASE IF EXISTS agencia_de_viajes;
CREATE DATABASE agencia_de_viajes 
/* WITH */
    /* ENCODING = 'latin1' */ 
    /* LC_COLLATE = 'es_ES.UTF-8' */
    /* LC_CTYPE = 'es_ES.UTF-8' */
    ;
\c agencia_de_viajes;

/*
 * He decidido utilizar CHAR en vez de INT para CodLoc y CodHo ya que me parece
 * más fácil de validar. Además se podría decir que el código postal no es
 * realmente un numero, ya que no me imagino una situación en la que tendriamos
 * que "hacer mates" a este valor. Ni tampoco al codigo del hotel. Se podría
 * decir lo mismo de Hotel.CatHo pero me parece más fácil validar con un entero.
 */
CREATE TABLE Localidad (
    CodLoc  CHAR(5) PRIMARY KEY NOT NULL,
    NomLoc  VARCHAR(64)         NOT NULL,
    DesLoc  TEXT,
    CONSTRAINT codLoc_is_valid CHECK (CodLoc ~ '^[\d]{5}$')
);

CREATE TABLE Viaje (
    CodVi   CHAR(5) PRIMARY KEY NOT NULL,
    NomVi   VARCHAR(64) UNIQUE  NOT NULL,
    DurVi   SMALLINT            NOT NULL,
    CONSTRAINT codvi_is_valid CHECK (CodVi ~* '^[A-Z][\d]{4}$')
);

CREATE TABLE Hotel (
    CodHo   CHAR(3) PRIMARY KEY NOT NULL,
    NomHo   VARCHAR(64) UNIQUE  NOT NULL,
    CatHo   SMALLINT DEFAULT(3) NOT NULL,
    DesHo   TEXT,
    CodHR   CHAR(3),
    CONSTRAINT codHo_is_valid CHECK (CodHo ~ '^[\d]{3}$'),
    CONSTRAINT catHo_is_valid CHECK (CatHo >= 1 AND CatHo <= 5),
    CONSTRAINT fk_CodHr FOREIGN KEY (CodHR) REFERENCES Hotel (CodHo)
    ON DELETE SET NULL ON UPDATE CASCADE
);

/*
 * Al crear la PRIMARY KEY conjunta, NumJo crea su índice automáticamente. 
 * También he intentado (sin exito) que el valor de NumJo no sea mayor que el
 * valor correspondiente de Viaje.DurVi.
 */
CREATE TABLE Jornada (
    CodVi   CHAR(5)             NOT NULL,
    NumJo   SMALLINT            NOT NULL,
    CodLP   CHAR(5)             NOT NULL,
    CodLL   CHAR(5)             NOT NULL,
    CodHo   CHAR(3),
    KmtJo   SMALLINT,
    PRIMARY KEY (CodVi, NumJo),
    CONSTRAINT fk_CodVi FOREIGN KEY (CodVi) REFERENCES Viaje (CodVi)
    ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_CodLP FOREIGN KEY (CodLP) REFERENCES Localidad (CodLoc)
    ON UPDATE CASCADE,
    CONSTRAINT fk_CodLL FOREIGN KEY (CodLL) REFERENCES Localidad (CodLoc)
    ON UPDATE CASCADE,
    CONSTRAINT fk_CodHo FOREIGN KEY (CodHo) REFERENCES Hotel (CodHo)
    ON DELETE SET NULL ON UPDATE CASCADE
);
