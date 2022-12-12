<?php

require "controllers/actividades.controller.php";

session_start();

function parsePrecio($actividad) {
  if(!isset($actividad->precio)) {
    return "Actividad Gratuita";
  } else {
    return $actividad->precio;
  }
}

if(isset($_POST["crearActividad"]) || $_SERVER['REQUEST_METHOD'] === 'POST')
  insertActividad();

if(isset($_POST["alterarActividad"]) || $_SERVER['REQUEST_METHOD'] === 'PUT')
  alterActividad();

if(!isset($_SESSION["usuario"]))
  header("Location: views/login.php"); exit();

?>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Actividades Culturales</title>
  <link rel="stylesheet" href="public/style.css">
  <script src="public/scripts.js"></script>
</head>
<body>
  <div id="nav-bar">
    <h1 id="titulo-actividades">ACTIVIDADES</h5>
    <?php echo $_COOKIE['nombre'] ?>
    <a href="logout.php">Cerrar Sesión</a>
  </div>
  <section id="actividades">
    <?php
      $actividades = getActividades();
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
    <?php include'public/formulario.html' ?>
    </section>
  </div>
</body>
</html>
