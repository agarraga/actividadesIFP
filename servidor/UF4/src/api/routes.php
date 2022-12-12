<?php

require 'controllers/actividades.controller.php';

$method = $_SERVER['REQUEST_METHOD'];

/**
 * No estoy seguro de como llamar a todas las diferentes GETs y POSTs, ya que
 * hay más de un función por método.
 */
switch($method)
{
  case 'GET':
    getAllActividades();
    // getActividad();
    // getUsuario();
    // getUserPass();
    break;
  case 'POST':
    insertActividad();
    // insertUsuario();
    break;
  case 'DELETE':
    deleteActividad();
    break;
  case 'PUT':
    alterActividad();
    break;
  default:
    header('HTTP/1.1 400 Bad Request');
}

?>
