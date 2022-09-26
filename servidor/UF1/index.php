<?php

require "actividad.php";

if(isset($_POST["crearActividad"]) || $_SERVER['REQUEST_METHOD'] === 'POST')
{
  $actividad = new Actividad($_POST["titulo"],
                             $_POST["fecha"],
                             $_POST["ciudad"],
                             $_POST["tipo"],
                             $_POST["gratis"],
                             $_POST["precio"]);
}

function parsePrecio($actividad) {
  if(isset($actividad->gratis)) {
    return "Actividad Gratuita";
  } else {
    return "Coste: " . $actividad->precio;
  }
}

?>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
    <title>Actividades Culturales</title>
    <link rel="stylesheet" href="style.css">
    <script>
      /* Según he leido, php no pude 'hacer cosas' después de haber cargado la
      * página. Para añadir la funcionalidad he tenido que utilizar js.
      * Al parecer podría haber utilizado métodos AJAX de php, pero tendria que
      * aprender más de esto. 
      */
      document.addEventListener("DOMContentLoaded", function() {
        document.getElementById('checkbox-gratis').addEventListener('change', disableSelect, false);
        function disableSelect() {
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
  <?php if(isset($_POST["crearActividad"])): ?>
    <div>
      <section id="actividad">
        <ul id="lista-actividad">
        <li class="element-actividad"><?php echo $actividad->titulo ?></li>
          <li class="element-actividad"><?php echo $actividad->ciudad ?></li>
          <li class="element-actividad"><?php echo $actividad->fecha ?></li>
          <li class="element-actividad"><?php echo parseprecio($actividad) ?></li>
        </ul>
      </section>
    </div>
  <?php endif; ?>
  <div>
    <section id="actividad-form">
      <form action="index.php" role="form" method="post">
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
