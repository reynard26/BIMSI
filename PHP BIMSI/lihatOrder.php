<?php
   header('content-type:application/json;charset=utf-8');
   include "db_connect.php";

   $stmt = $conn->prepare("SELECT tanggal_pemesanan, nama_mahasiswa, line, kode_kelas, harga, jangka_waktu, total, notes FROM pemesanan");
   
   $stmt ->execute();
   $stmt ->bind_result($tanggal_pemesanan, $nama_mahasiswa, $line, $kode_kelas, $harga, $jangka_waktu, $total, $notes);

   $pemesanan = array();

    while($stmt ->fetch()) {
      $temp = array();
    
          $temp['tanggal_pemesanan']=$tanggal_pemesanan;
          $temp['nama_mahasiswa']=$nama_mahasiswa;
          $temp['line']=$line;
          $temp['kode_kelas']=$kode_kelas;
          $temp['harga']=$harga;
          $temp['jangka_waktu']=$jangka_waktu;
          $temp['total']=$total;
          $temp['notes']=$notes;
          array_push($pemesanan,$temp);

	  }
   echo json_encode($pemesanan);
 ?>