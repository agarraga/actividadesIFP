<?php

require 'db.php';

function getActividades()
{
  $user_id = $_GET['id'];

  $query = "SELECT id, titulo, fecha, ciudad, tipo, precio
            FROM actividad
            WHERE usuario = ?";

  global $conn;
  $stmt = $conn->prepare($query);
  $stmt->bind_param('s', $user_id);
  $stmt->execute();
  $rslt = $stmt->get_result();
  $conn->close();

  if($rslt)
  {
    $actividades = array();
    while($row = mysqli_fetch_assoc($rslt))
      array_push($actividades, $row);
    header('HTTP/1.1 200 OK');
    echo json_encode($actividades);
  }
  else
    header('HTTP/1.1 404 Not Found');
}

function getAllActividades()
{
  $query = "SELECT * FROM actividad";

  global $conn;
  $stmt = $conn->prepare($query);
  $stmt->execute();
  $rslt = $stmt->get_result();
  $conn->close();

  if($rslt)
  {
    $actividades = array();
    while($row = mysqli_fetch_assoc($rslt))
      array_push($actividades, $row);
    header('HTTP/1.1 200 OK');
    echo json_encode($actividades);
  }
  else
    header('HTTP/1.1 418 I\'m a teapot');
}

function insertActividad()
{
  $actividad = json_decode(file_get_contents('php://input'), true);

  $titulo = $actividad['titulo'];
  $fecha = $actividad['fecha'];
  $ciudad = $actividad['ciudad'];
  $tipo = $actividad['tipo'];
  if($actividad['precio']) $precio = $actividad['precio']; else $precio = null;
  $usuario = $actividad['usuario'];

  $query = "INSERT INTO actividad (titulo, fecha, ciudad, tipo, precio)
            VALUES (?, ?, ?, ?, ?, ?)";

  global $conn;
  $stmt = $conn->prepare($query);
  $stmt->bind_param('ssssss', $titulo, $fecha, $ciudad, $tipo, $precio, $usuario);
  $rslt = $stmt->execute();
  $conn->close();

  if ($rslt)
    header('HTTP/1.1 200 OK');
  else
    header('HTTP/1.1 400 Bad request');
}

function alterActividad()
{
  $actividad_id = $_GET['id'];
  $actividad = json_decode(file_get_contents('php://input'), true);

  $titulo = $actividad['titulo'];
  $fecha = $actividad['fecha'];
  $ciudad = $actividad['ciudad'];
  $tipo = $actividad['tipo'];
  if($actividad['precio']) $precio = $actividad['precio']; else $precio = null;
  $usuario = $actividad['usuario'];

  $query = "UPDATE actividad
            SET titulo = ?,
                fecha = ?,
                ciudad = ?,
                tipo = ?,
                precio = ?,
                ususario = ?
            WHERE id = ?";

  global $conn;
  $stmt = $conn->prepare($query);
  $stmt->bind_param('sssssd', $titulo, $fecha, $ciudad, $tipo, $precio, $usuario, $id);
  $rslt = $stmt->execute();
  $conn->close();

  if ($rslt)
    header('HTTP/1.1 200 OK');
  else
    header('HTTP/1.1 400 Bad Request Error');
}


function deleteActividad()
{
  $actividad_id = $_GET['id'];

  $query = "DELETE FROM actividad
            WHERE id = ?";

  global $conn;
  $stmt = $conn->prepare($query);
  $stmt->bind_param('i', $actividad_id);
  $rslt = $stmt->execute();
  $conn->close();

  if ($rslt)
    header('HTTP/1.1 200 OK');
  else
    header('HTTP/1.1 400 Bad Request');
}

function deleteAllActividad($user_id)
{
  $user_id = $_GET['id'];

  $query = "DELETE FROM actividad
            WHERE usuario = ?";

  global $conn;
  $stmt = $conn->prepare($query);
  $stmt->bind_param('s', $user_id);
  $rslt = $stmt->execute();
  $conn->close();

  if ($rslt)
    header('HTTP/1.1 200 OK');
  else
    header('HTTP/1.1 400 Bad Request');
}

?>
