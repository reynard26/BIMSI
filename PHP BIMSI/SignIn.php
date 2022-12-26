<?php
header('Content-type:application/json;charset=utf-8');
require_once 'db_connect.php';

if (isset($_POST['email']) && isset($_POST['password'])) {
  $email = $_POST['email'];
  $password = $_POST['password'];

  $sql = "SELECT * FROM user WHERE email = '$email'";
 
  $response = mysqli_query($conn, $sql);
 
  $result = array();
  $result['SignIn'] = array();

  if(mysqli_num_rows($response) === 1) {
 $row = mysqli_fetch_assoc($response);
  
  
if (password_verify($password, $row['password'])){
  $index['email'] = $row['email'];
  
   array_push($result['SignIn'], $index);

  $result['success'] = "1";
  $result['message'] = "success";

 echo json_encode($result);

 mysqli_close($conn);
}else {
  $result['success'] = "0";
  $result['message'] = "error";
  echo json_encode($result);

  mysqli_close($conn);
}
}else {
  $result['success'] = "0";
  $result['message'] = "error";
  echo json_encode($result);

  mysqli_close($conn);
}
}
?>