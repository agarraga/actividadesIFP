<?php

/**
 * Este archivo es nuestro punto de entrada principal. La primera función nos
 * devuelve la ruta que pida el usuario sin parametros. El switch nos lleva al
 * recurso que pida el usuario, ya sea por el navegador o como servicio.
 */

$path = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);

switch ($path)
{
    case '/':
        require 'views/main.php';
        break;
    case '/api':
        require 'api/routes.php';
        break;
    /* Si la selección no es válida mandamos un 404 */
    default:
        header('Location: public/404.html', false, 404);
        break;
}

?>
