<?php

class Actividad {

  public $titulo;
  public $fecha;
  public $ciudad;
  public $tipo;
  public $precio;

  function __construct($titulo, $fecha, $ciudad, $tipo, $precio = null) {
    $this->titulo = $titulo;
    $this->fecha = $fecha;
    $this->ciudad = $ciudad;
    $this->tipo = $tipo;
    $this->precio = $precio;
  }
}

function parsePrecio($actividad) {
  if(!isset($actividad->precio)) {
    return "Actividad Gratuita";
  } else {
    return $actividad->precio;
  }
}

class Usuario {

  public $id;
  public $pass;
  public $correo;
  public $nombre;

  function __construct(string $id, string $pass, string $correo, string $nombre) {
    $this->id=$id;
    $this->pass=$pass;
    $this->correo=$correo;
    $this->nombre=$nombre;
  }
}

?>
