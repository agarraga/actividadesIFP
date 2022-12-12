<?php

require 'db.php';

function getUser()
{
  $user_id = $_GET['id'];

  $query = "SELECT id, correo, nombre
            FROM usuario
            WHERE id = ?";

  global $conn;
  $stmt = $conn->prepare($query);
  $stmt->bind_param('s', $user_id);
  $stmt->execute();
  $rslt = $stmt->get_result();
  $conn->close();

  if($rslt)
  {
    $user = mysqli_fetch_assoc($rslt);
    header('HTTP/1.1 200 OK');
    echo json_encode($user);
  }
  else
    header('HTTP/1.1 404 Not Found');
}

// TODO: Implementar get con autentificación
function getUserPass() { }

function insertUsuario()
{
  /* // uy uy se empieza a complicar la cosa
  $user_id = $_GET['id'];
  if (getUser())
    $conn->close();
    return false;
   */

  $usuario = json_decode(file_get_contents('php://input'), true);

  $id     = $usuario['id'];
  $pass   = $usuario['pass'];
  $correo = $usuario['correo'];
  $nombre = $usuario['nombre'];

  $query = "INSERT INTO usuario (id, pass, correo, nombre)
            VALUES (?, ?, ?, ?)";

  global $conn;
  $stmt = $conn->prepare($query);
  $stmt->bind_param('ssss', $id, $pass, $correo, $nombre);
  $rslt = $stmt->execute();
  $conn->close();

  if ($rslt)
    header('HTTP/1.1 200 OK');
  else
    header('HTTP/1.1 400 Bad request');
}
