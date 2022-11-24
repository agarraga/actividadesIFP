<?php

// Comprobamos que exista una sesion de usuario y redireccionamos a `login.php'
// si no es el caso.
function verifyLogin()
{
  if(!isset($_SESSION["usuario"]))
  {
    header("Location: login.php");
    exit();
  }
}

?>
