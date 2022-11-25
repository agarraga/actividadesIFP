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

function getActividades($id)
{

  global $conn;
  $query = "SELECT *
            FROM usuario
            WHERE id = ?";
  $stmt = $conn->prepare($query);
  $stmt->bind_param('s', $id);
  $stmt->execute();
  $resp = $stmt->get_result();
  if($resp)
  {
    /* $actividad = array(); */
    /* while($row = mysqli_fetch_assoc($resp)) */
    /* { */
      /* array_push($actividad, $row); */
    /* } */
    return $resp;
  }
}

?>
