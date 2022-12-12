<?php

function getUser()
{
  $endpoint = 'http://' . $_SERVER['HTTP_HOST'] . '/api/routes.php';

  $curl = curl_init();
  curl_setopt($curl, CURLOPT_URL, $endpoint);
  curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
  $out = curl_exec($curl);
  curl_close($curl);

  return json_decode($out, true);
}

// TODO: Implement safe user pass.
function getUserPass() { }

function verifyLogin()
{
  $pass = GetUserPass();
  $q_pass = $_POST['pass'];
  if ($q_pass == $pass)
  {
    $user = getUser();
    $id = $user['id'];
    $_SESSION["usuario"] = $id;
    setcookie('nombre', $user['nombre']);
    header("Location: index.php");
    exit();
  }
}

function insertUsuario()
{
  $usuario = array(
    'id'      => $_POST['titulo'],
    'pass'    => $_POST['pass'],
    'correo'  => $_POST['correo'],
    'nombre'  => $_POST['nombre']
  );

  $endpoint = 'http://' . $_SERVER['HTTP_HOST'] . '/api/routes.php';

  $json = json_encode($usuario);

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
