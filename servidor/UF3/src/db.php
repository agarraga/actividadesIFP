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
 * Encontré la solución en esta fantástica y exhaustiva respuesta en
 * StackOverflow:
 * https://stackoverflow.com/a/22662582
 */
mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
$conn = mysqli_connect($host, $user, $pass, $bbdd);

function insertActividad($titulo, $fecha, $ciudad, $tipo, $precio=null)
{
  global $conn;
  $query = "INSERT INTO actividad (titulo, fecha, ciudad, tipo, precio)
            VALUES ('$titulo', '$fecha', '$ciudad', '$tipo', $precio)";
  $resp = mysqli_query($conn, $query);
}

?>
