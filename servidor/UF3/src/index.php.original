<?php

require "modelos.php";
require "dao.php";

session_start();

// Comprobamos que exista una sesion de usuario y redireccionamos a `login.php'
// si no es el caso.
if(!isset($_SESSION["usuario"]))
{
  header("Location: login.php");
  exit();
}

// Creamos una tabla asociativa de sesión si no existe.
if(!isset($_SESSION["actividades"]))
{
  $_SESSION["actividades"] = array();
}

// Creamos una actividad si el usuario hace una peticion POST, y la añadimos
// a la sesión.
if(isset($_POST["crearActividad"]) || $_SERVER['REQUEST_METHOD'] === 'POST')
{
  $actividad = new Actividad($_POST["titulo"],
                             $_POST["fecha"],
                             $_POST["ciudad"],
                             $_POST["tipo"],
                             $_POST["gratis"],
                             $_POST["precio"]);

  array_push($_SESSION["actividades"], serialize($actividad));
}

?>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
    <title>Actividades Culturales</title>
    <link rel="stylesheet" href="style.css">
    <script>
      document.addEventListener("DOMContentLoaded", function() {
        document.getElementById('checkbox-gratis').addEventListener('change', disableSelect, false);
        function disableSelect() {
          // Deshabilitamos el menu desplegable de precios si es una actividad
          // gratuita.
          var precioChecked = document.getElementById('checkbox-gratis');
          var precio = document.getElementById('select-precio');

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
    <?php echo $_SESSION["usuario"] ?>
    <a href="logout.php">Cerrar Sesión</a>
  </div>
  <section id="actividades">
  <!-- Esta sección mantiene todas las actividades a `float: left;' -->
    <?php foreach($_SESSION["actividades"] as $actividad_serializada): 
      $actividad = unserialize($actividad_serializada);
    ?>
      <div class="actividad">
        <img id="image-tipo" src="./imagenes/<?php echo $actividad->tipo ?>.jpg" alt="tipo-actividad">
        <dl id="list-actividad">
          <!-- Utilizamos el elemento dl (description list) para que nos queden
               bien los nobres de las categorias-->
          <dt>Actividad</dt><dd class="element-actividad"><?php echo $actividad->titulo ?></dd>
          <dt>Localidad</dt><dd class="element-actividad"><?php echo $actividad->ciudad ?></dd>
          <dt>Fecha</dt><dd class="element-actividad"><?php echo $actividad->fecha ?></dd>
          <dt>Tipo</dt><dd class="element-actividad"><?php echo $actividad->tipo ?></dd>
          <dt>Precio</dt><dd class="element-actividad"><?php echo parseprecio($actividad) ?></dd>
        </dl>
      </div>
    <?php endforeach; ?>
  </section>
  <div>
  <!-- El formulario de creación de actividad -->
    <section id="actividad-form">
    <!-- Esta sección mantiene el formulario `float: right;' -->
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
