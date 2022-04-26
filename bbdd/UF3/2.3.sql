-- 2.3.1
DELIMITER //
DROP PROCEDURE IF EXISTS add_venta_alonsogarr;
CREATE PROCEDURE add_venta_alonsogarr(
    IN codigo_libro INT, IN codigo_socio INT, in fecha_venta DATE, IN cantidad INT)
BEGIN
    SET @precio_venta := cantidad * (SELECT precio FROM libro WHERE codigo = codigo_libro);
    INSERT INTO venta(cod_libro, cod_socio, fecha, cantidad, precio) 
    VALUES (codigo_libro, codigo_socio, fecha_venta, cantidad, @precio_venta);
END
//
DELIMITER ;

-- 2.3.2
-- no se porque no me está funcionando 
-- TODO fix!
DELIMITER //
DROP TRIGGER IF EXISTS verificar_disp_alonsogarr;
CREATE TRIGGER verificar_disp_alonsogarr BEFORE INSERT ON venta FOR EACH ROW
BEGIN
    IF NEW.cantidad > (SELECT stock FROM libro WHERE codigo = NEW.cod_libro)
    THEN
    SIGNAL SQLSTATE '45000' SET message_text = 'No quda stock para comprar, sentimos las molestias.';
    END IF;
END //
DELIMITER ;

-- 2.3.3
DELIMITER //
DROP TRIGGER IF EXISTS no_modificar_alonsogarr;
CREATE TRIGGER no_modificar_alonsogarr BEFORE UPDATE ON socio FOR EACH ROW
BEGIN
    IF OLD.nombre != NEW.nombre THEN
    signal sqlstate '45000' SET message_text = 'No se puede cambier el nombre de socio.';
    END IF;
END //
DELIMITER ;

-- 2.3.4
DELIMITER //
DROP TRIGGER IF EXISTS no_modificar_libro_alonsogarr;
CREATE TRIGGER no_modificar_libro_alonsogarr BEFORE UPDATE ON libro FOR EACH ROW
BEGIN
    IF OLD.autor != NEW.autor OR OLD.titulo != NEW.titulo
    THEN
    signal sqlstate '45000' SET message_text = 'No se puede cambier el nombre del libro ni el autor.';
    END IF;
END //
DELIMITER ;

-- 2.4.5
DELIMITER //
DROP PROCEDURE IF EXISTS crear_morosos_alonsogarr;
CREATE PROCEDURE crear_morosos_alonsogarr()
BEGIN
    DROP TABLE IF EXISTS morosos;
    CREATE TABLE morosos AS SELECT * FROM socio;
END //
DELIMITER ;

-- 2.4.6
-- ???

-- 2.4.7
DELIMITER //
DROP TRIGGER IF EXISTS update_morosos_alonsogarr;
CREATE TRIGGER update_morosos_alonsogarr AFTER UPDATE ON socio FOR EACH ROW
BEGIN
    UPDATE morosos SET direccion = NEW.direccion, telefono = NEW.telefono
    WHERE codigo = OLD.codigo;
END //
DELIMITER ;
