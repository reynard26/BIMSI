<?php
header('Content-type:application/json;charset=utf-8');
include 'db_connect.php';

$response = [];
if(isset($_POST['id']) && isset($_POST['nama']) && isset($_POST['post'])){
    $id = $_POST['id'];
    $nama = $_POST['nama'];
    $post = $_POST['post'];

    $q = $conn->query("UPDATE forum SET nama='$nama', post='$post' WHERE id=' $id'");
    if($q){
        $response['success'] = 1;
        $response['message'] = "Data berhasil di update";
    } else {
        $response['success'] = 0;
        $response['message'] = "Data gagal diupdate";
    }

} else {
    $response['success'] = -1;
    $response['message'] = "Data kosong";
}
echo json_encode($response);