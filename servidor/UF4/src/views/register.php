<?php

require'modelos.php';
require'controllers/users.controller.php';

if(isset($_POST["register"]))
{
  $user = new Usuario($_POST["id"],
                      $_POST["pass"],
                      $_POST["correo"],
                      $_POST["nombre"]);
  if(insertUsuario($user))
  {
    $id = $_POST["id"];
    $_SESSION["usuario"] = $id;
    setcookie('id', $id);
    setcookie('nombre', $user['nombre']);
    header("Location: index.php");
    exit();
  }
}

?>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Regístrate</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <div>
    <form action="index.php" role="form" method="post">
      <div class="reg-form-input-div">
        <label for="nombre" class="reg-label">Nombre completo:</label>
        <input id="nombre" name="nombre" type="text"><br/>
      </div>
      <div class="reg-form-input-div">
        <label for="id" class="reg-label">Nombre de usuario:</label>
        <input id="id" name="id" type="text"><br/>
      </div>
      <div class="reg-form-input-div">
        <label for="pass" class="reg-label">Elige una constraseña:</label>
        <input id="pass" name="pass" type="password"><br/>
      </div>
      <div class="reg-form-input-div">
        <label for="correo" class="reg-label">Correo Electronico:</label>
        <input id="correo" name="correo" type="email"><br/>
      </div>
      <div class="reg-form-input-div">
        <label for="submit" class="reg-label"></label>
        <input type="submit" value="Regístrame" name="register">
      </div>
    </form>
  </div>
</body>
</html>
