-- Crear objetos
CREATE TYPE VEHICULOS AS OBECT (
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
    MEMBER PROCEDURE getMatricula (SELF IN OUT NOCOPY VEHICULOS),
    MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY VEHICULOS),
)NOT FINAL;

CREATE TYPE COCHE AS OBECT (
    color CHAR(7),
    descapotable BOOLEAN
);

CREATE TYPE AVION AS OBECT (
    nMotores NUMBER,
    maxAltitud NUMBER
);

CREATE TYPE AVION AS OBECT (
    bano BOOLEAN,
    nTV NUMBER
);

CREATE TYPE BODY VEHICULOS AS
    MAP MEMBER FUNCTION getPotenciaCV RETURN NUMBER AS
    BEGIN
        RETURN potenciaCV;
    END;
    MEMBER FUNCTION getNPlazas RETURN NUMBER AS
    BEGIN
        RETURN nPlazas;
    END;
    MEMBER PROCEDURE getMatricula (SELF IN OUT NOCOPY VEHICULOS) AS
    BEGIN
        DBMS_OUTPUT.PUT_LINE(TO_CHAR(matricula) || ' ' || matricula || ' ' || propietario || ' ' || marca || modelo);
    END;
    MEMBER PROCEDURE getModelo (SELF IN OUT NOCOPY VEHICULOS) AS
    BEGIN
        DBMS_OUTPUT.PUT_LINE(TO_CHAR(matricula) || ' ' || modelo || ' ' || marca || ' ' || matricula);
    END;
