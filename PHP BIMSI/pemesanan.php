<?php
  header ('content-type:application/json;charset-utf-8');
   include "db_connect.php";


        if (isset($_POST['nama_mahasiswa']) &&
            isset ($_POST['line']) &&
            isset ($_POST['kode_kelas']) &&
            isset ($_POST['harga']) &&
            isset ($_POST['jangka_waktu']) &&
            isset ($_POST['total' ]) &&
            isset ($_POST[ 'notes']))

       {
       $nama_mahasiswa=$_POST['nama_mahasiswa'];
       $line=$_POST['line'];
       $kode_kelas=$_POST['kode_kelas'];
       $harga=$_POST['harga'];
       $jangka_waktu=$_POST['jangka_waktu'];
       $total=$_POST['total'];
       $notes=$_POST['notes'];

       $q=mysqli_query ($conn, "INSERT INTO pemesanan(nama_mahasiswa, line, kode_kelas, harga, jangka_waktu, total, notes)
                                VALUES ('$nama_mahasiswa','$line', '$kode_kelas','$harga', '$jangka_waktu', '$total', '$notes')");
                                
        $response=array();
       if($q)
       {
            $response["success"]=1;
            $response["message"]="Data berhasil disimpan";
            echo json_encode($response);
       }
       else
          {
              $response["success"]=0;
              $response["message"]="Data gagal disimpan";
              echo json_encode($response);
          }
      }
      else
      {
              $response["success"]=-1;
              $response["message"]="Data kosong";
              echo json_encode($response);

      }
?>