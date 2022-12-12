<?php

function getActividades($user_id)
{
  global $conn;
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
    return json_encode($actividades);
  }
  $conn->close();
  return false;
}

function getAllActividades()
{
  global $conn;
  $query = "SELECT *
            FROM actividad";
  $stmt = $conn->prepare($query);
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
    return json_encode($actividades);
  }
  $conn->close();
  return false;
}

function insertActividad($actividad)
{
  global $conn;
  $actividad = json_decode($actividad);
  $titulo = $actividad['titulo'];
  $fecha = $actividad['fecha'];
  $ciudad = $actividad['ciudad'];
  $tipo = $actividad['tipo'];
  if($actividad['precio']) $precio = $actividad['precio']; else $precio = null;
  $usuario = $actividad['usuario'];
  $query = "INSERT INTO actividad (titulo, fecha, ciudad, tipo, precio)
            VALUES (?, ?, ?, ?, ?, ?)";
  $stmt = $conn->prepare($query);
  $stmt->bind_param('sssss', $titulo, $fecha, $ciudad, $tipo, $precio, $usuario);
  $stmt->execute();
  $conn->close();
  return true;
}

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

    insertActividad(json_encode($actividad));
  }
}


function alterActividad($id, $actividad)
{
  global $conn;

  $titulo = $actividad['titulo'];
  $fecha = $actividad['fecha'];
  $ciudad = $actividad['ciudad'];
  $tipo = $actividad['tipo'];
  if($actividad['precio']) $precio = $actividad['precio']; else $precio = null;
  $usuario = $actividad['usuario'];
  $query = "UPDATE actividad
            SET
            titulo = ?,
            fecha = ?,
            ciudad = ?,
            tipo = ?,
            precio = ?,
            ususario = ?
            WHERE id = ?";
  $stmt = $conn->prepare($query);
  $stmt->bind_param('sssssd', $titulo, $fecha, $ciudad, $tipo, $precio, $usuario, $id);
  $stmt->execute();
  $conn->close();
  return true;
}


function deleteActividad($actividad_id)
{
  global $conn;
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

?>
