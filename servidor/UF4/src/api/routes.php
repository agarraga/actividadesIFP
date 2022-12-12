<?php

require '../controllers/users.controller.php';
require '../controllers/actividades.controller.php';

$method = $_SERVER['REQUEST_METHOD'];
$url = parse_url($_SERVER['REQUEST_URI']);
if ($url['qurey'])
{
  parse_str($url['$qurey'], $query);
}

switch($method)
{
  case 'GET':
    getAllActividades();
    break;
  case 'POST':
    insertActividad($actividad);
    break;
  case 'DELETE':
    $actividad_id = $query['id'];
    deleteActividad($actividad_id);
    break;
  case 'PUT':
    $actividad_id = $query['id'];
    alterActividad($actividad_id, $actividad);
    break;
  default:
    header('Location: public/404.html', true, 404);
}

?>
