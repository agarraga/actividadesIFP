<?php

/**
 * Este archivo es nuestro punto de entrada principal. La primera función
 * deconstruye el uri de la petición del usuario y crea una matriz con
 * parametros si existen. El switch nos lleva al recurso que pida el usuario,
 * ya sea por el navegador o como servicio.
 */
$request_uri = explode('?', $_SERVER['REQUEST_URI'], 2);

switch ($request_uri[0])
{
    case '/':
        require '/views/main.php';
        break;
    case '/api':
        require '/api/routes.php';
        break;
    /* Si la selección no es válida mandamos un 404 */
    default:
        header('HTTP/1.0 404 Not Found');
        require '/views/404.php';
        break;
}

?>
