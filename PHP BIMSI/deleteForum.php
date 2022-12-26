<?php
header('Content-type:application/json;charset=utf-8');
include 'db_connect.php';


 $response=[];
if(isset($_POST['id'])){
    $id=$_POST['id'];


    if($conn->query("DELETE FROM forum WHERE id='$id'")){
        $response["success"]=1;
        $response["message"]="Post berhasil di delete";
        
    }else{
        $response["success"]=0;
        $response["message"]="Post gagal di delete";
      
    }
}else{
    $response["success"]=-1;
    $response["message"]="Data kosong";
   
}
 echo json_encode($response);
?>