<?php

// Creamos una clase data access object para todas las funcionalidades de la
// base de datos. Voy a utilizar Sqlite para simplificar la parte de conexion
// de servidor y poder complicarme con todo lo demás.
class Dao {

    public $db;

    function __construct() {
        $this->db = new PDO("sqlite:".__DIR__."/actividades.db");
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
