<?php

// Creamos una clase de acceso a la BBDD (DAO) para todas las funcionalidades
// de la base de datos.

// Variables de entorno creadas por Docker para pasar al DAO.
$host = $_ENV['MYSQL_HOST'];
$bbdd = $_ENV['MYSQL_DATABASE'];
$user = $_ENV['MYSQL_USER'];
$pass = $_ENV['MYSQL_DATABASE'];

class Dao {

    public $db;

    function __construct() {
    }

    function query($select, $from, $where = '') {
        if ($where) {
            $string = sprintf(
                "SELECT %s FROM %s WHERE %s",
                $select,
                $from,
                $where
            );
        } else {
            $string = sprintf(
                "SELECT %s FROM %s",
                $select,
                $from);
        }
        $query = $this->db;
    }

    function insert_usuario($usuario) {}

    function kill() {
        $this->db = null;
    }
}

?>
