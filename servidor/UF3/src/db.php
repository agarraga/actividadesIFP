<?php

// Variables de entorno creadas por Docker para pasar al  .
$host = $_ENV['MYSQL_HOST'];
$bbdd = $_ENV['MYSQL_DATABASE'];
$user = $_ENV['MYSQL_USER'];
$pass = $_ENV['MYSQL_DATABASE'];


try
{

  $conn = @mysqli_connect($host, $user, $pass, $bbdd);
  /* echo "conexion succesful!"; */
}
catch (Exception $ex)
{
  echo $ex->getMessage();
}

?>
