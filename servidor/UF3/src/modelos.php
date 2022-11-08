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

function parsePrecio($actividad) {
  // Esta función nos devulve la cadena si es $gratis es true o el precio si no
  // lo es.
  if(isset($actividad->gratis)) {
    return "Actividad Gratuita";
  } else {
    return $actividad->precio;
  }
}

?>
