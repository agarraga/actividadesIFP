<?php

function getAllActividades()
{
  $endpoint = 'http://' . $_SERVER['HTTP_HOST'] . '/api/routes.php';

  $curl = curl_init();
  curl_setopt($curl, CURLOPT_URL, $endpoint);
  curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
  $out = curl_exec($curl);
  curl_close($curl);

  return json_decode($out, true);
}

function getActividades()
{
  $endpoint = 'http://' . $_SERVER['HTTP_HOST'] . '/api/routes.php';

  $curl = curl_init();
  curl_setopt($curl, CURLOPT_URL, $endpoint);
  curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
  $out = curl_exec($curl);
  curl_close($curl);

  return json_decode($out, true);
}

function insertActividad()
{
  $actividad = array(
    'titulo'  => $_POST['titulo'],
    'fecha'   => $_POST['fecha'],
    'ciudad'  => $_POST['ciudad'],
    'tipo'    => $_POST['tipo'],
    'precio'  => $_POST['precio'],
    'usuario' => $_COOKIE['id']);

$endpoint = 'http://' . $_SERVER['HTTP_HOST'] . '/api/routes.php';

$json = json_encode($actividad);

$curl = curl_init();
  curl_setopt($curl, CURLOPT_URL, $endpoint);
  curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
  curl_setopt($curl, CURLOPT_POST, 1);
  curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
  curl_setopt($curl, CURLOPT_POSTFIELDS, $json);
  $out = curl_exec($curl);
  curl_close($curl);

  return $out;
}

function alterActividad()
{
  $actividad = array(
    'titulo'  => $_POST['titulo'],
    'fecha'   => $_POST['fecha'],
    'ciudad'  => $_POST['ciudad'],
    'tipo'    => $_POST['tipo'],
    'precio'  => $_POST['precio'],
    'usuario' => $_COOKIE['id']);

  $endpoint = 'http://' . $_SERVER['HTTP_HOST'] . '/api/routes.php';

  $json = json_encode($actividad);

  $curl = curl_init();
  curl_setopt($curl, CURLOPT_URL, $endpoint);
  curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
  curl_setopt($curl, CURLOPT_PUT, 1);
  curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
  curl_setopt($curl, CURLOPT_POSTFIELDS, $json);
  $out = curl_exec($curl);
  curl_close($curl);

  return $out;
}

function deleteActividad()
{
  $endpoint = 'http://' . $_SERVER['HTTP_HOST'] . '/api/routes.php';

  $curl = curl_init();
  curl_setopt($curl, CURLOPT_URL, $endpoint);
  curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
  curl_setopt($curl, CURLOPT_CUSTOMREQUEST, 'DELETE');
  $out = curl_exec($curl);
  curl_close($curl);

  return $out;
}

// TODO: define
function deleteAllActividad() { }


?>
