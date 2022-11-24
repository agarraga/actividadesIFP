<?php

function verifyNewActividad()
{
  // Creamos una tabla asociativa de sesión si no existe.
  if(!isset($_SESSION["actividades"]))
  {
    $_SESSION["actividades"] = array();
  }

  // Creamos una actividad si el usuario hace una peticion POST, y la añadimos
  // a la sesión.
  if(isset($_POST["crearActividad"]) || $_SERVER['REQUEST_METHOD'] === 'POST')
  {
    $actividad = new Actividad($_POST["titulo"],
                               $_POST["fecha"],
                               $_POST["ciudad"],
                               $_POST["tipo"],
                               $_POST["precio"]);

    createActividad($actividad);
  }
}

function createActividad($actividad)
{
    array_push($_SESSION["actividades"], serialize($actividad));
}

?>
