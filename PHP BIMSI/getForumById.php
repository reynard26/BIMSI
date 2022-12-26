<?php
header('Content-type:application/json;charset=utf-8');
include 'db_connect.php';

$response=[];
if(isset($_POST['id'])){
     $id=$_POST['id'];

   $q = $conn->query("SELECT * FROM forum WHERE id =  $id");
$response = [];
if($q->num_rows> 0){
    $response['data'] = [];
    while($r = $q->fetch_array(MYSQLI_ASSOC)){
        $response['data'][] = $r;
    }
    $response['success'] = 1;
    $response['message'] = "Data mahasiswa berhasil dibaca";
    } else {
        $response['success'] = 0;
        $response['message'] = "Data gagal Dibaca/ Tidak ada data";
    }
}
echo json_encode($response);