<?php

class Actividad {

  public $titulo;
  public $fecha;
  public $ciudad;
  public $tipo;
  public $gratis;
  public $precio;

  function __construct($titulo, $fecha, $ciudad, $tipo, $gratis, $precio) {
    $this->titulo = $titulo;
    $this->fecha = $fecha;
    $this->ciudad = $ciudad;
    $this->tipo = $tipo;
    $this->gratis = $gratis;
    $this->precio = $precio;
  }
}

?>
