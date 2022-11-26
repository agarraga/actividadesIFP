<?php

require "controllers/users.controller.php";
require "controllers/actividades.controller.php";
require "modelos.php"; /* Necesario para acceder al la función parsePrecio() */

session_start();

if(!isset($_SESSION["usuario"]) || !isset($_COOKIE["id"]))
{
  header("Location: login.php");
  exit();
}

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
    <h1 style="float:left;">ACTIVIDADES</h5>
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
      <form action="index.php" role="form" method="post">
        <h3>Crear Actividad</h3>
        <input class="actividad-form-input" type="text" id="input-titulo" name="titulo" placeholder="Nombre de actividad" required><br>
        <input class="actividad-form-input" type="date" id="input-fecha" name="fecha"  required><br>
        <input class="actividad-form-input" type="text" id="input-ciudad" name="ciudad" placeholder="Localicación" required><br>
        <select class="actividad-form-input" id="select-tipo" name="tipo" required>
          <option value="" selected disabled>Selecciona el tipo</option>
          <option value="viaje">Viajes</option>
          <option value="musica">Conciertos</option>
          <option value="cultura">Cultura</option>
          <option value="copas">Copas</option>
          <option value="comida">Restaurantes</option>
          <option value="cine">Cines</option>
        </select><br>
        <input type="checkbox" id="checkbox-gratis" name="gratis" value="1">Actividad Gratuita<br>
        <select class="actividad-form-input" id="select-precio" name="precio" required>
          <option value="" selected disabled>Selecciona el precio</option>
          <option value="Bajo">€</option>
          <option value="Medio">€€</option>
          <option value="Alto">€€€</option>
        </select><br>
        <input id="button-anadir" type="submit" value="Crear Actividad" name="crearActividad">
      </form>
    </section>
  </div>
</body>
</html>
