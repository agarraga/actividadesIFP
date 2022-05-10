-- Crear objetos y cuerpos
CREATE TYPE VEHICULO AS OBECT (
    matricula CHAR(6),
    propietario VARCHAR2(80),
    marca VARCHAR2(80),
    modelo VARCHAR2(80),
    potenciaCV NUMBER,
    nPlazas NUMBER,
    velocidad NUMBER,
    fechaMatriculacion DATE,
    ruedas NUMBER,
    MAP MEMBER FUNCTION getPotenciaCV RETURN NUMBER,
    PRAGMA RESTRICT_REFERENCES(getPotenciaCV, WNDS)
    MEMBER FUNCTION getNPlazas RETURN NUMBER,
    PRAGMA RESTRICT_REFERENCES(getNPlazas, WNDS)
    MEMBER PROCEDURE getMatricula (SELF IN OUT NOCOPY VEHICULO),
    MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY VEHICULO),
)NOT FINAL;

CREATE OR REPLACE 
TYPE BODY VEHICULO AS
    MAP MEMBER FUNCTION getPotenciaCV RETURN NUMBER AS
    BEGIN
        RETURN potenciaCV;
    END getPotenciaCV;

    MEMBER FUNCTION getNPlazas RETURN NUMBER AS
    BEGIN
        RETURN nPlazas;
    END getNPlazas;

    MEMBER PROCEDURE getMatricula (SELF IN OUT NOCOPY VEHICULO) AS
    BEGIN
        DBMS_OUTPUT.PUT_LINE(matricula || ' ' || propietario || ' ' || marca  || ' ' || modelo);
    END getMatricula;

    MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY VEHICULO) AS
    BEGIN
        DBMS_OUTPUT.PUT_LINE(modelo || ' ' || marca || ' ' || matricula);
    END getModelo;
END;

CREATE TYPE COCHE UNDER VEHICULO(
    color CHAR(7),
    descapotable CHAR(4),
    OVERRIDE MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY COCHE),
);


CREATE OR REPLACE 
TYPE BODY COCHE AS
    MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY VEHICULO) AS
    BEGIN
        DBMS_OUTPUT.PUT_LINE(modelo || ' ' || marca || ' ' || matricula || ' ' || color || ' ' || descapotable);
    END getModelo;
END;

CREATE TYPE AVION UNDER VEHICULO(
    nMotores NUMBER,
    maxAltitud NUMBER,
    OVERRIDE MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY AVION)
);

CREATE OR REPLACE 
TYPE BODY AVION AS
    MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY VEHICULO) AS
    BEGIN
        DBMS_OUTPUT.PUT_LINE(modelo || ' ' || marca || ' ' || matricula || ' ' || TO_CHAR(nMotores) || ' ' ||  TO_CHAR(maxAltitud));
    END getModelo;
END;

CREATE TYPE AUTOBUS UNDER VEHICULO(
    bano CHAR(4),
    nTV NUMBER,
    OVERRIDE MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY AUTOBUS)
);

CREATE OR REPLACE 
TYPE BODY AUTOBUS AS
    MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY VEHICULO) AS
    BEGIN
        DBMS_OUTPUT.PUT_LINE(modelo || ' ' || marca || ' ' || matricula || ' ' || bano);
    END getModelo;
END;

CREATE TABLE vehiculo OF VEHICULO;
CREATE TABLE coche OF COCHE;
CREATE TABLE avion OF AVION;
CREATE TABLE autobus OF AUTOBUS;

-- Insertar 4 registros por subclase
INSERT INTO coche VALUES(
    (),
);

INSERT INTO avion VALUES(
    (),
);
INSERT INTO autobus VALUES(
    (),
);

-- Realizar consultas
SELECT * FROM vehiculo;
SELECT * FROM coche;
SELECT * FROM avion;
SELECT * FROM autobus;

SELECT coche.getPotenciaCV() FROM coche;
SELECT autobus.getNPlazas() FROM autobus;
SELECT avion.getMatricula() FROM avion;
SELECT coche.getModelo() FROM coche;
SELECT autobus.getModelo() FROM autobus;
SELECT avion.getModelo() FROM avion;
