<?php

function verifyNewActividad()
{
  if(!isset($_SESSION["actividades"]))
    $_SESSION["actividades"] = array();

  if(isset($_POST["crearActividad"]) || $_SERVER['REQUEST_METHOD'] === 'POST')
  {
    $actividad = new Actividad($_POST["titulo"],
                               $_POST["fecha"],
                               $_POST["ciudad"],
                               $_POST["tipo"],
                               $_POST["precio"],
                               $_COOKIE["id"]);

    insertActividad($actividad);
  }
}

function insertActividad($actividad)
{
  global $conn;
  $titulo = $actividad->titulo;
  $fecha = $actividad->fecha;
  $ciudad = $actividad->ciudad;
  $tipo = $actividad->tipo;
  if($actividad->precio) $precio = $actividad->precio; else $precio = null;
  $usuario = $actividad->usuario;
  $query = "INSERT INTO actividad (titulo, fecha, ciudad, tipo, precio)
            VALUES (?, ?, ?, ?, ?, ?)";
  $stmt = $conn->prepare($query);
  $stmt->bind_param('sssss', $titulo, $fecha, $ciudad, $tipo, $precio, $usuario);
  $stmt->execute();
  $conn->close();
  return true;
}

function getActividades()
{
  global $conn;

  $user_id = $_GET['id'];

  $query = "SELECT id, titulo, fecha, ciudad, tipo, precio
            FROM actividad
            WHERE usuario = ?";
  $stmt = $conn->prepare($query);
  $stmt->bind_param('s', $user_id);
  $stmt->execute();
  $rslt = $stmt->get_result();
  if($rslt)
  {
    $actividades = array();
    while($row = mysqli_fetch_assoc($rslt))
    {
      array_push($actividades, $row);
    }
    $conn->close();
    return $actividades;
  }
  $conn->close();
  return false;
}

// TODO: implement
function deleteActividad()
{
  global $conn;

  $actividad_id = $_GET['id'];

  $query = "DELETE FROM actividad
            WHERE id = ?";

  $stmt = $conn->prepare($query);
  $stmt->bind_param('i', $actividad_id);
  $stmt->execute();
  $conn->close();
  return true;
}

// TODO: implement
function deleteAllActividad($user_id)
{
  global $conn;
  $query = "DELETE FROM actividad
            WHERE usuario = ?";
  $stmt = $conn->prepare($query);
  $stmt->bind_param('s', $user_id);
  $stmt->execute();
  $conn->close();
  return true;
}

// TODO: implement
function alterActividad($id, $field, $value)
{
  global $conn;
  $query = "UPDATE actividad
            SET ? = ?
            WHERE id = ?";
  $stmt = $conn->prepare($query);
  $stmt->bind_param('sss', $field, $value, $id);
  $stmt->execute();
  $conn->close();
  return true;
}

?>
