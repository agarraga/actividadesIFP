-- crear nuevo rol
CREATE ROLE BOSSAlonsoGarr;
GRANT ALL ON *.* TO BOSSAlonsoGarr;

-- crear usuario
CREATE USER IF NOT EXISTS THEBOSSAlonsoGarr@localhost 
IDENTIFIED BY 'asdfghjk'
DEFAULT ROLE BOSSAlonsoGarr;

-- verificar creacion y derechos
SHOW GRANTS FOR THEBOSSAlonsoGarr@localhost;
SELECT host, user FROM mysql.user;

-- accede como usuario
system mysql -u THEBOSSAlonsoGarr -p;

-- crear bbdd
DROP DATABASE IF EXISTS instituto;
CREATE DATABASE instituto;
use instituto;

-- crear tablas
CREATE TABLE alumnos (
    clave_alumno CHAR(6) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido1 VARCHAR(255) NOT NULL,
    edad INT NOT NULL,
    curso_actual CHAR(6)
);

CREATE TABLE aulas (
    numero_aula INT PRIMARY KEY,
    capacidad INT NOT NULL
);

CREATE TABLE modulos (
    clave_modulo CHAR(6) PRIMARY KEY,
    curso CHAR(6) NOT NULL,
    descripcion MEDIUMTEXT
);

-- descibir tablas
DESCRIBE aulas;
DESCRIBE alumnos;
DESCRIBE modulos;

-- cambiar nombre modulos
ALTER TABLE modulos RENAME asignaturas;

-- añadir columna
ALTER TABLE alumnos ADD COLUMN apellido2 VARCHAR(80) NOT NULL AFTER apellido1;
DESCRIBE alumnos;

-- cambiar nombre tabla
ALTER TABLE asignaturas ADD COLUMN nombre_profesor VARCHAR(80) AFTER curso;
DESCRIBE asignaturas;

-- insertar registros
INSERT INTO alumnos (clave_alumno, nombre, apellido1, apellido2, edad, curso_actual)
VALUES
('000001', 'Paco', 'Gomez', 'Gonzalez', 32, 'DAW'),
('000002', 'Pepe', 'Garcia', 'Jimenez', 22, 'DAW'),
('000003', 'Nacho', 'Hidalgo', 'Timano', 43, 'DAW'),
('000004', 'Curro', 'Mendez', 'Munoz', 24, 'DAW'),
('000005', 'Guille', 'Mecano', 'Sarbolla', 21, 'DAW')
;

INSERT INTO aulas (numero_aula, capacidad)
VALUES
(01, 40),
(02, 55),
(03, 45),
(04, 78),
(05, 68)
;

INSERT INTO asignaturas (clave_modulo, curso, nombre_profesor, descripcion)
VALUES
('MP0122', 'DAW', 'Pilar Lopez', 'Sistemas Informaticos'),
('MP0222', 'DAW', 'Xavier Castejon',  'Bases de Datos'),
('MP0322', 'DAW', 'Javier Martin',  'Lenguaje de Marcas'),
('MP0422', 'DAW', 'Gonzalo Rodriguez',  'Programacion I'),
('MP0522', 'DAW', 'Gonzalo Rodriguez',  'Programacion II')
;

SELECT table_name, table_rows FROM information_schema.tables WHERE table_schema = 'instituto';

-- realizar consulta
SELECT nombre, edad FROM alumnos WHERE curso = 'DAW';

-- crear usario local todos los permisos
CREATE USER IF NOT EXISTS userlocalAlonsoGarr@localhost IDENTIFIED BY '1234';
GRANT ALL ON instituto.* TO userexternoAlonsoGarr@localhost;

-- comprobrar

-- crear usuario local restringido
CREATE USER IF NOT EXISTS localAlonsoGarr@localhost IDENTIFIED BY '1234';
GRANT SELECT ON instituto.* TO localAlonsoGarr@localhost;
GRANT UPDATE (clave_alumno, nombre, apellido1, apellido2) 
    ON instituto.alumnos TO localAlonsoGarr@localhost;
GRANT UPDATE (clave_modulo, curso, nombre_profesor, descripcion)
    ON instituto.asignaturas TO localAlonsoGarr@localhost;
-- comprobar

-- crear usuario externo
CREATE USER IF NOT EXISTS userexternoAlonsoGarr@'192.168.1.%' IDENTIFIED BY '1234';

-- comprobar
