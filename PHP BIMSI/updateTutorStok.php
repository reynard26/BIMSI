<?php
  header ('content-type:application/json;charset-utf-8');
   include "db_connect.php";


   if (isset($_POST['kode_kelas']) &&
            isset ($_POST['stok']) &&
            isset ($_POST['harga']))
   {
   	   $kode_kelas=$_POST['kode_kelas'];
       $stok=$_POST['stok'];
       $harga=$_POST['harga'];

       $q=mysqli_query($conn, "UPDATE tutor SET stok='$stok', harga='$harga' WHERE kode_kelas= '$kode_kelas'");
       $response=array();
       if($q)
       {
       	 $response["success"]=1;
            $response["message"]="Data berhasil diupdate";
            echo json_encode($response);
       }
       else
       {
       	 	$response["success"]=0;
            $response["message"]="Data gagal diupdate";
            echo json_encode($response);
       }
   }
   else
   	{ 
   		$response["success"]=-1;
            $response["message"]="Data kosong";
            echo json_encode($response);
   	}
   