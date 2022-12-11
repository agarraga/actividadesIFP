<?php
// Destruimos la sesión y redirigimos el usario a login.php.
session_start();
session_destroy();

header("Location: login.php");
die();

?>
