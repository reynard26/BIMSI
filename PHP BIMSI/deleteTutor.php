<?php
  header ('content-type:application/json;charset-utf-8');
   include "db_connect.php";


   if (isset($_POST['kode_kelas'])) {
    $kode_kelas=$_POST['kode_kelas'];

     $q=mysqli_query($conn, "DELETE FROM tutor WHERE kode_kelas= '$kode_kelas'");
     $response=array();

       if($q){
       	    $response["success"]=1;
            $response["message"]="Data berhasil didelete";
            echo json_encode($response);
       }else{
       	 	$response["success"]=0;
            $response["message"]="Data gagal didelete";
            echo json_encode($response);
       }
   }else{ 
   		      $response["success"]=-1;
            $response["message"]="Data kosong";
            echo json_encode($response);
   	}
?>