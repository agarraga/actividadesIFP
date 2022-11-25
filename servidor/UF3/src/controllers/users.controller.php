<?php

require 'db.php';

function getUser($id, $pass)
{
  global $conn;
  $query = "SELECT id, correo, nombre 
            FROM usuario
            WHERE id = ? AND pass = ?";
  $stmt = $conn->prepare($query);
  $stmt->bind_param('ss', $id, $pass);
  $stmt->execute();
  $resp = $stmt->get_result();
  if($resp)
  {
    $user = mysqli_fetch_assoc($resp);
    /* echo $user; */
    return $user;
  }
}

function verifyLogin($id, $pass)
{
  $user = getUser($id, $pass);
  if ($user)
  {
    $id = $_POST["id"];
    $_SESSION["usuario"] = $id;
    setcookie('id', $id);
    /* setcookie('nombre', $user[""]); */
    header("Location: index.php");
    exit();
  }
}

?>
