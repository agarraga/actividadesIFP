-- Crear objetos y cuerpos
CREATE TYPE VEHICULO AS OBJECT (
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
    PRAGMA RESTRICT_REFERENCES(getPotenciaCV, WNDS),
    MEMBER FUNCTION getNPlazas RETURN NUMBER,
    PRAGMA RESTRICT_REFERENCES(getNPlazas, WNDS),
    MEMBER PROCEDURE getMatricula (SELF IN OUT NOCOPY VEHICULO),
    MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY VEHICULO)
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
    OVERRIDING MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY COCHE),
);

CREATE OR REPLACE 
TYPE BODY COCHE AS
    OVERRIDING MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY COCHE) AS
    BEGIN
        DBMS_OUTPUT.PUT_LINE(modelo || ' ' || marca || ' ' || matricula || ' ' || color || ' ' || descapotable);
    END getModelo;
END;

CREATE TYPE AVION UNDER VEHICULO(
    nMotores NUMBER,
    maxAltitud NUMBER,
    OVERRIDING MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY AVION)
);

CREATE OR REPLACE 
TYPE BODY AVION AS
    OVERRIDING MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY AVION) AS
    BEGIN
        DBMS_OUTPUT.PUT_LINE(modelo || ' ' || marca || ' ' || matricula || ' ' || TO_CHAR(nMotores) || ' ' ||  TO_CHAR(maxAltitud));
    END getModelo;
END;

CREATE TYPE AUTOBUS UNDER VEHICULO(
    bano CHAR(4),
    nTV NUMBER,
    OVERRIDING MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY AUTOBUS)
);

CREATE OR REPLACE 
TYPE BODY AUTOBUS AS
    OVERRIDING MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY AUTOBUS) AS
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
    ('123abd', 'fulanita', 'seat', 'ibiza', 400,5 ,130 , '2018-02-01', 4, '#ffeeff', 'fals'),
    ('456jkl', 'fulanito', 'renault', 'berlingo', 600,7 ,100 , '2017-01-06', 4, '#00a08f', 'fals'),
    ('678jgh', 'fulanite', 'ferrari', 'super-rapido', 800,2 ,180 , '2010-04-30', 4, '#e466b0', 'true'),
    ('832akg', 'fulaniti', 'fiat', 'panda', 200,4 ,60 , '1997-02-01', 4, '#8fcef0', 'fals')
);

INSERT INTO avion VALUES(
    ('000023', 'Capitan Hook', 'Boeing', '747', 12000, 320, 900, '1998-02-01', 6, 5, 3500),
    ('000453', 'Capitan Farrel', 'Airbus', '343', 10000, 180, 800, '2002-10-05', 6, 4, 2500),
    ('000892', 'Capitan Picard', 'Starship', 'Enterprise', 2000, 320, 3999999, '2400-03-01', 0, 2, 3999999),
    ('000023', 'Capitan Haddok', 'Ship', 'The Red Unicorn', 200, 32, 40, '1786-04-03', 0, 0, 0)
);
INSERT INTO autobus VALUES(
    ('adg943', 'La pava esta', 'Magic', 'School Bus', 200, 67, 80, '1999-04-03', 10, 'true', 0)
    ('dkfj83', 'Hagrid', 'Magic', 'Hogwarts', 1, 69, 900, '1999-05-03', 11, 'fals', 0)
    ('sdkfj3', 'pepe', 'mercedes', '58buzus', 200, 67, 80, '1999-04-03', 10, 'true', 0)
    ('kdj324', 'La esta', 'Magic', 'gogo Bus', 200, 67, 80, '1999-04-03', 10, 'true', 0)
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
