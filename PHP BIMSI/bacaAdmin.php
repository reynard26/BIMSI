<?php
  header ('content-type:application/json;charset-utf-8');
   include "db_connect.php";

   $stmt = $conn->prepare("SELECT kode_kelas, kode_namasubject, kode_tutor, namaTutor , jadwal, stok, harga, gambar, note FROM tutor");

   $stmt ->execute();
   $stmt -> bind_result($kode_kelas, $kode_namasubject, $kode_tutor, $namaTutor , $jadwal, $stok, $harga, $gambar, $note);

   $tutor = array();

   while($stmt ->fetch()) {

   		$temp = array();

   		$temp['kode_kelas'] = $kode_kelas;
   		$temp['kode_namasubject'] = $kode_namasubject;
   		$temp['kode_tutor'] = $kode_tutor;
   		$temp['namaTutor'] = $namaTutor;
   		$temp['jadwal'] =$jadwal;
   		$temp['stok'] = $stok;
   		$temp['harga'] = $harga;
   		$temp['gambar'] = $gambar;
   		$temp['note'] = $note;
 
   		array_push($tutor,$temp);
   }
   echo json_encode($tutor);
 ?>