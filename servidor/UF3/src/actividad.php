<?php

class Actividad {

  public $id;
  public $titulo;
  public $fecha;
  public $ciudad;
  public $tipo;
  public $gratis;
  public $precio;
  public $usuario;

  function __construct($id, $titulo, $fecha, $ciudad, $tipo, $gratis, $precio, $usuario) {
    $this->id = $id;
    $this->titulo = $titulo;
    $this->fecha = $fecha;
    $this->ciudad = $ciudad;
    $this->tipo = $tipo;
    $this->gratis = $gratis;
    $this->precio = $precio;
    $this->precio = $precio;
    $this->usuario = $usuario;
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


class Usuario {
    public $id;
    public $pass;
    public $correo;
    public $nombre;

    function __construct($id, $pass, $correo, $nombre) {
        $this->id = $id;
        $this->pass = $pass;
        $this->correo = $correo;
        $this->nombre = $nombre;
    }
}

?>
