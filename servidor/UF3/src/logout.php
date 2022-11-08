<?php
// Destruimos la sesión y redirigimos el usario a index.php.
session_start();
session_destroy();

header("Location: index.php");
die();

?>
