<?php
$conn = mysqli_connect("localhost","id17942833_user","BimbelJayaJaya2!","id17942833_bimbel");

function konneksiDb(){
try{
      $dsn = "mysql:host=localhost;dbname=id17942833_bimbel";
      $pdo = new PDO($dsn, 'id17942833_user', 'BimbelJayaJaya2!');
      return $pdo;
    }catch(PDOException $e){
         return $e;
    }
}

?>