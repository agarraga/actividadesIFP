-- 2.2.1
DELIMITER //
DROP PROCEDURE IF EXISTS insertar_departamentos_alonsogarr;
CREATE PROCEDURE insertar_departamentos_alonsogarr(IN nombre VARCHAR(80), IN planta INT)
BEGIN
    INSERT INTO Departamento (nombre, planta)
    VALUES (nombre, planta);
END //
DELIMITER ;

-- 2.2.2
DELIMITER //
DROP PROCEDURE IF EXISTS empleados_sueldo_alonsogarr;
CREATE PROCEDURE empleados_sueldo_alonsogarr()
BEGIN
    SELECT nombre, apellido, sueldo FROM Empleado;
END //
DELIMITER ;

-- 2.2.3
DELIMITER //
DROP PROCEDURE IF EXISTS empleados_hijos_alonsogarr;
CREATE PROCEDURE empleados_hijos_alonsogarr()
BEGIN
    SELECT nombre, apellido, CantidadHijos FROM Empleado WHERE CantidadHijos > 0;
END //
DELIMITER ;

-- 2.2.4
DELIMITER //
DROP PROCEDURE IF EXISTS empleados_mayor_sueldo_alonsogarr;
CREATE PROCEDURE empleados_mayor_sueldo_alonsogarr(IN cantidad INT)
BEGIN
    SELECT nombre, apellido, sueldo FROM Empleado WHERE sueldo <= cantidad;
END //
DELIMITER ;

--2.2.5
CREATE TABLE Indefinido (
    Documento VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(30),
    apellidos VARCHAR(20)
);

CREATE TABLE Temporal (
    Documento VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(30),
    apellidos VARCHAR(20)
);

--2.2.6
DELIMITER //
DROP PROCEDURE IF EXISTS clasificar_empleados_alonsogarr;
CREATE PROCEDURE clasificar_empleados_alonsogarr()
BEGIN
    INSERT INTO Indefinido SELECT Documento, nombre, apellidos FROM Empleado WHERE sueldo > 1000;
    INSERT INTO Temporal SELECT Documento, nombre, apellidos FROM Empleado WHERE sueldo <= 1000;
END //
DELIMITER ;

--2.2.7
DELIMITER //
DROP PROCEDURE IF EXISTS drop_empty_departamento;
CREATE PROCEDURE drop_empty_departamento(IN nombre_departamento VARCHAR(20))
BEGIN
    IF EXISTS (
        SELECT nombre FROM Departamento WHERE nombre = nombre_departamento
        AND num_dpt NOT IN (SELECT num_dpt FROM Empleado))
        THEN
        DELETE FROM Departamento WHERE nombre = nombre_departamento;
    ELSEIF NOT EXISTS (
        SELECT nombre FROM Departamento WHERE nombre = nombre_departamento)
        THEN
        SELECT concat('El Departamento no existe o está mal escrito.');
    -- No entiendo porque no me salta el ELSE, aunque el procedimiento funciona
    -- no enseña el mensaje correcto.
    ELSE
        SELECT concat('El Departamento tiene empleados y no se puede borrar.');
    END IF;
END //
DELIMITER ;
