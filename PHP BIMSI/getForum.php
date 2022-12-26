<?php
header('Content-type:application/json;charset=utf-8');
include 'db_connect.php';

$q = $conn->query("SELECT * FROM forum");
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
    $response['message'] = 'Tidak ada data';
}
echo json_encode($response);