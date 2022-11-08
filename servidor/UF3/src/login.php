<?php

session_start();

if(isset($_POST["login"])) 
{
  if($_POST["user"] == "ifp" && $_POST["pass"] == "2022")
  {
    $_SESSION["usuario"] = $_POST["user"];
    header("Location: index.php");
    exit();
  }
  else
  // en caso de que no exista el usuario lanzamos una alerta javascript.
  // JavaScript empotrado en PHP empotrado en HTML ;)
  {
    echo '<script>
      alert("La combinación de usuario y constraseña no exiten, intentelo de nuevo.")
      </script>
    ';
  }
}

?>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Autentificación</title>
</head>
<body>
  <div>
  <!-- Formulario de autentificación. -->
    <form role="form" method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
      <input class="campo-login" type="text" name="user" placeholder="Nombre usuario" required>
      <input class="campo-login" type="password" name="pass" placeholder="Contraseña" required>
      <input id="acceder" type="submit" name="login" value="Acceder">
    </form>
  </div>
</body>
</html>
