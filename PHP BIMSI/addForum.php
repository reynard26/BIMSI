<?php
header('Content-type:application/json;charset=utf-8');
include 'db_connect.php';


$response = [];
if( isset($_POST['nama']) && isset($_POST['post'])){
    $nama = $_POST['nama'];
    $post = $_POST['post'];
    $q = $conn->query("INSERT INTO forum(nama, post) VALUES ( '$nama', '$post')");

    if($q){
        $response['success'] = 1;
        $response['message'] = "Data berhasil ditambah";
    } else {
        $response['success'] = 0;
        $response['message'] = "Data gagal ditambah";
    }
}
else {
    $response['success'] = 1;
    $response['message'] = "Data kosong";
}
echo json_encode($response);
