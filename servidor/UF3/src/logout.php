<?php
// Destruimos la sesión y redirigimos el usario a login.php.
session_start();
setcookie('id');
session_destroy();

header("Location: login.php");
die();

?>
