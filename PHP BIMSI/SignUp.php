<?php
require "DataBase.php";
$db = new DataBase();

if (isset($_POST['NamaFull']) && isset($_POST['nickname']) && isset($_POST['email']) && isset($_POST['password']) && isset($_POST['phone']) && isset($_POST['yoc'])) {
    if ($db->dbConnect()) {
        if ($db->signUp("user", $_POST['NamaFull'], $_POST['nickname'],$_POST['email'], $_POST['password'], $_POST['phone'], $_POST['yoc'])){
            echo "Sign Up Successfull";
        } else echo "Email Invalid, Sign Up Failed";
    } else echo "Error: Database connection";
} else echo "All fields must be filled";
?>

