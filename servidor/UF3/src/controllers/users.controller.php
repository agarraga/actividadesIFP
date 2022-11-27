<?php

require 'db.php';

function getUser($user_id)
{
  global $conn;
  $query = "SELECT id, correo, nombre
            FROM usuario
            WHERE id = ?";
  $stmt = $conn->prepare($query);
  $stmt->bind_param('s', $id);
  $stmt->execute();
  $rslt = $stmt->get_result();
  if($rslt)
  {
    $user = mysqli_fetch_assoc($rslt);
    $conn->close();
    return $user;
  }
  $conn->close();
  return false;
}

function getUserPass($user_id)
{
  global $conn;
  $query = "SELECT pass
            FROM usuario
            WHERE id = ?";
  $stmt = $conn->prepare($query);
  $stmt->bind_param('s', $user_id);
  $stmt->execute();
  $rslt = $stmt->get_result();
  if($rslt)
  {
    $user = mysqli_fetch_assoc($rslt);
    $conn->close();
    return $user['pass'];
  }
  $conn->close();
  return false;
}

function verifyLogin($id, $pass)
{
  $q_pass = getUserPass($id);
  if ($q_pass == $pass)
  {
    $user = getUser($id);
    $id = $user['id'];
    $_SESSION["usuario"] = $id;
    setcookie('id', $id);
    setcookie('nombre', $user['nombre']);
    header("Location: index.php");
    exit();
  }
}

function insertUsuario($user)
{
  global $conn;
  if (getUser($user->id))
    $conn->close();
    return false;
  $id = $user->id;
  $pass = $user->pass;
  $correo = $user->correo;
  $nombre = $user->nombre;
  $query = "INSERT INTO usuario (id, pass, correo, nombre)
            VALUES (?, ?, ?, ?)";
  $stmt = $conn->prepare($query);
  $stmt->bind_param('ssss', $id, $pass, $correo, $nombre);
  $stmt->execute();
  $conn->close();
  return true;
}
