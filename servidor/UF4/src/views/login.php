<?php

require '../controllers/users.controller.php';

session_start();

if(isset($_POST["login"]))
  verifyLogin();

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
      <input class="campo-login" type="text" name="id" placeholder="Nombre usuario" required></br>
      <input class="campo-login" type="password" name="pass" placeholder="Contraseña" required></br>
      <input id="acceder" type="submit" name="login" value="Acceder">
    </form>
  </div>
  <div>
    <form action="register.php" method="POST">
      <label for="boton-registrar">Usuario nuevo:</label>
      <input type="submit" value="Registrarse"/>
    </form>
  </div>
</body>
</html>
