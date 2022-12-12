<?php

require "controllers/users.controller.php";
require "controllers/actividades.controller.php";
require "models.php"; /* Necesario para acceder al la función parsePrecio() */

session_start();

if(!isset($_SESSION["usuario"]) || !isset($_COOKIE["id"]))
{
  header("Location: login.php");
  exit();
}

verifyNewActividad();

?>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
    <title>Actividades Culturales</title>
    <link rel="stylesheet" href="style.css">
    <script>
      document.addEventListener("DOMContentLoaded", () => {
        document.querySelector('#checkbox-gratis').addEventListener('change', disableSelect, false);
        function disableSelect() {
          var precioChecked = document.querySelector('#checkbox-gratis');
          var precio = document.querySelector('#select-precio');

          if(precioChecked.checked) {
            precio.disabled = true;
          } else {
            precio.disabled = false;
          }
        }
      });
    </script>
</head>
<body>
  <div id="nav-bar">
    <h1 id="titulo-actividades">ACTIVIDADES</h5>
    <?php echo $_COOKIE['nombre'] ?>
    <a href="logout.php">Cerrar Sesión</a>
  </div>
  <section id="actividades">
    <?php
      /**
       * Despues de horas de intentar que esto funcione, una vez conseguido me
       * he dado cuenta de que getActividades() tendría que haber devuelto un 
       * matriz de elementos con el tipo Actividad declarado en `modelos.php`,
       * en vez de un matriz de matrices asociativos.
       */
      $actividades = getActividades($_COOKIE["id"]);
      foreach($actividades as $actividad):
    ?>
      <div class="actividad">
        <img id="image-tipo" src="./imagenes/<?php echo $actividad['tipo'] ?>.jpg" alt="tipo-actividad">
        <dl id="list-actividad">
          <dt>Actividad</dt><dd class="element-actividad"><?php echo $actividad['titulo'] ?></dd>
          <dt>Localidad</dt><dd class="element-actividad"><?php echo $actividad['ciudad'] ?></dd>
          <dt>Fecha</dt><dd class="element-actividad"><?php echo $actividad['fecha'] ?></dd>
          <dt>Tipo</dt><dd class="element-actividad"><?php echo $actividad['tipo'] ?></dd>
          <dt>Precio</dt><dd class="element-actividad"><?php echo parsePrecio($actividad) ?></dd>
        </dl>
      </div>
    <?php endforeach; ?>
  </section>
  <div>
    <section id="actividad-form">
    <?php include'formulario.html' ?>
    </section>
  </div>
</body>
</html>
