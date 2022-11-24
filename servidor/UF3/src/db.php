<?php

// Variables de entorno creadas por Docker para pasar a las funciones de mysql.
$host = $_ENV['MYSQL_HOST'];
$bbdd = $_ENV['MYSQL_DATABASE'];
$user = $_ENV['MYSQL_USER'];
$pass = $_ENV['MYSQL_PASSWORD'];

/**
 * Función para detectar errores precisamente:
 * Básicamente me propuse el reto de aprender Docker mientras hacía esta
 * actividad, principalmente para no instalar mysql directamente en mi maquina
 * y tener una relación más real con la bbdd. `mysqli_report` me ayudó mucho
 * más que los if($connexion), o incluso try-catch. De hecho para que funcionase
 * bién tuve que eliminarlos todos.
 * Encontré la solución en una fantastica y exhaustiva respuesta de 
 * StackOverflow que no consigo encontrar otra vez XD
 */
mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
$conn = @mysqli_connect($host, $user, $pass, $bbdd);

function getUsers()
{
  global $conn;
  $query = "SELECT * FROM usuario";
  $resp = mysqli_query($conn, $query);
  $users = array();

  while($row = mysqli_fetch_assoc($resp))
  {
    array_push($users, $row);
  }

  return $users;
}

function getActividades($user)
{
  global $conn;
  $query = "SELECT * FROM actividad WHERE usuario = $user";
  $resp = mysqli_query($conn, $query);
  $users = array();

  while($row = mysqli_fetch_assoc($resp))
  {
    array_push($users, $row);
  }

  return $users;
}

function insertUser($id, $pass, $correo, $nombre)
{
  global $conn;
  $query = "INSERT INTO usuario (id, pass, correo, nombre)
            VALUES ('$id', '$pass', '$correo', '$nombre')";
  $resp = mysqli_query($conn, $query);
}

function insertActividad($titulo, $fecha, $ciudad, $tipo, $precio=null)
{
  global $conn;
  $query = "INSERT INTO actividad (titulo, fecha, ciudad, tipo, precio)
            VALUES ('$titulo', '$fecha', '$ciudad', '$tipo', $precio)";
  $resp = mysqli_query($conn, $query);
}

?>
