<?php

/* Docker enviroment variables */
$host = $_ENV['MYSQL_HOST'];
$bbdd = $_ENV['MYSQL_DATABASE'];
$user = $_ENV['MYSQL_USER'];
$pass = $_ENV['MYSQL_PASSWORD'];

/* Database connection */
mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
$conn = mysqli_connect($host, $user, $pass, $bbdd);

?>
