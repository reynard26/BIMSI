-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 07, 2021 at 04:59 PM
-- Server version: 10.5.12-MariaDB
-- PHP Version: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id17942833_bimbel`
--

-- --------------------------------------------------------

--
-- Table structure for table `forum`
--

CREATE TABLE `forum` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `post` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `forum`
--

INSERT INTO `forum` (`id`, `nama`, `post`) VALUES
(1, 'Reynardthan Handoko', 'Hallo Saya Rey'),
(9, 'Bill', 'Halo saya bill'),
(13, 'Rey', 'hallo'),
(17, 'Meilani', 'Halloa saya mei'),
(18, 'mei', 'mei'),
(19, 'Meilani', 'Halo saya meilani, kelas a'),
(21, 'Metta', 'Semangat!'),
(34, 'Reynardthan Handoko', 'Hello Kak, saya mau tanya apakah ini sudah benar ?');

-- --------------------------------------------------------

--
-- Table structure for table `namasubject`
--

CREATE TABLE `namasubject` (
  `id_namasubject` int(11) NOT NULL,
  `kode_namasubject` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `subject` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `picture` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `namasubject`
--

INSERT INTO `namasubject` (`id_namasubject`, `kode_namasubject`, `subject`, `picture`) VALUES
(1, 'MK001', 'Data Analyis', 'https://bimbelhimsi.000webhostapp.com/BIMBEL/assets/dataanalysis.jpg'),
(2, 'MK002', 'Accounting', 'https://bimbelhimsi.000webhostapp.com/BIMBEL/assets/accounting.jpg'),
(3, 'MK003', 'Database System', 'https://bimbelhimsi.000webhostapp.com/BIMBEL/assets/database.jpg'),
(4, 'MK004', 'Algorithm', 'https://bimbelhimsi.000webhostapp.com/BIMBEL/assets/algo.jpg'),
(5, 'MK005', 'Mobile App', 'https://bimbelhimsi.000webhostapp.com/BIMBEL/assets/mobile.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id_mahasiswa` int(11) NOT NULL,
  `tanggal_pemesanan` timestamp NOT NULL DEFAULT current_timestamp(),
  `nama_mahasiswa` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `line` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `kode_kelas` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `harga` int(11) NOT NULL,
  `jangka_waktu` int(11) NOT NULL,
  `total` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `notes` varchar(1000) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `pemesanan`
--

INSERT INTO `pemesanan` (`id_mahasiswa`, `tanggal_pemesanan`, `nama_mahasiswa`, `line`, `kode_kelas`, `harga`, `jangka_waktu`, `total`, `notes`) VALUES
(55, '2021-11-24 08:30:00', 'Michael Abhinaya', 'michael', 'MK001BK Data Analysis', 10000, 4, '40000', 'Saya sudah transfer lewat BCA'),
(56, '2021-11-24 08:30:30', 'Maria Darlene', 'darlene', 'MK002MY Accounting', 10000, 4, '40000', 'saya sudah transfer lewat gopay'),
(58, '2021-11-25 15:29:59', 'KEn', 'ken', 'MK001BK Data Analysis', 10000, 4, '40000', 'say bayar lwt bca'),
(59, '2021-11-26 13:43:51', 'HAYUKK', 'HAY', 'MK001BK Data Analysis', 10000, 4, '40000', 'SAYA TRANSFER LEWAT HATI'),
(60, '2021-11-26 14:15:34', 'Michael', 'mic', 'MK001BK Data Analysis', 10000, 4, '40000', 'Transfer LEWAT BCA'),
(61, '2021-11-27 15:31:01', 'bang jason', 'jason', 'MK001BK Data Analysis', 10000, 4, '40000', 'udah did bayar'),
(63, '2021-11-29 06:21:31', 'Budi', 'budi', 'MK001BK Data Analysis', 10000, 4, '40000', 'Di dibayar melalui ovo atasnama budi'),
(68, '2021-12-02 15:09:13', 'res', 're', 'MK001BK Data Analysis', 10000, 4, '40000', 'r'),
(69, '2021-12-02 15:20:50', 'rey', 'rey', 'MK001BK Data Analysis', 10000, 4, '40000', 'ff'),
(70, '2021-12-02 15:22:28', 'meianeh', 'mei', 'MK002MY Accounting', 10000, 4, '40000', 'meianeh'),
(71, '2021-12-02 15:54:39', 're', 'aras', 'MK001BK Data Analysis', 10000, 4, '40000', 'rey'),
(72, '2021-12-02 15:59:45', 'BABAI', 'rey', 'MK001BK Data Analysis', 10000, 4, '40000', 'rey'),
(73, '2021-12-02 16:48:44', 'asdf', 'asdfasdf', 'MK001BK Data Analysis', 10000, 4, '40000', 'adfadf'),
(74, '2021-12-05 15:02:57', 'mikel', 'mikel123', 'MK003M Database', 10000, 4, '40000', 'kredit'),
(75, '2021-12-05 18:09:23', 'Budi', 'budizz', 'MK001BK Data Analysis', 10000, 4, '40000', 'Sudah di transfer melalui transfer bank bca'),
(76, '2021-12-05 19:16:57', 'Aji', 'ajizz', 'MK001BK Data Analysis', 10000, 4, '40000', 'Pembayaran sudah dibayar melalui E-wallet'),
(77, '2021-12-06 10:24:42', 'Adi', 'adiz', 'MK001BK Data Analysis', 10000, 4, '40000', 'Pembayaran melalui transfer bank bca');

--
-- Triggers `pemesanan`
--
DELIMITER $$
CREATE TRIGGER `pemesanan_stok` AFTER INSERT ON `pemesanan` FOR EACH ROW BEGIN
   UPDATE tutor SET stok = stok - NEW.jangka_waktu
   WHERE kode_kelas = NEW.kode_kelas;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tutor`
--

CREATE TABLE `tutor` (
  `idTutor` int(11) NOT NULL,
  `kode_kelas` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `kode_namasubject` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `kode_tutor` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `namaTutor` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `jadwal` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `stok` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `harga` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `gambar` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note` varchar(1000) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tutor`
--

INSERT INTO `tutor` (`idTutor`, `kode_kelas`, `kode_namasubject`, `kode_tutor`, `namaTutor`, `jadwal`, `stok`, `harga`, `gambar`, `note`) VALUES
(1, 'MK001BK Data Analysis', 'MK001', 'BK', 'Bill Kiki', 'Senin, 18.00 WIB', '41', '10000', 'https://bimbelhimsi.000webhostapp.com/BIMBEL/assets/billkikii.jpg', 'Bill Kiki adalah mahasiswa yang lulus dengan IPK Maksimal yaitu 4.0, yang handal dalam menganalisa data'),
(2, 'MK002MY Accounting', 'MK002', 'MY', 'Meilani Yaputri', 'Selasa, 18.00 WIB', '33', '10000', 'https://bimbelhimsi.000webhostapp.com/BIMBEL/assets/meilaniiii.jpg', 'Meilani adalah juara umum akuntansi sekota Tangerang'),
(3, 'MK003M Database', 'MK003', 'M', 'Mettadewi', 'Rabu, 18.00 WIB', '37', '10000', 'https://bimbelhimsi.000webhostapp.com/BIMBEL/assets/metadewiii.jpg', 'Metta adalah mahasiswa Sistem Informasi angkatan 2020 yang lulus dengan nilai A untuk mata kuliah Database Systems dan sekarang sedang bekerja sebagai pemegang database Google.'),
(4, 'MK004AR Algoritma', 'MK004', 'AR', 'Amelia Rahmanita', 'Kamis, 18.00 WIB', '41', '10000', 'https://bimbelhimsi.000webhostapp.com/BIMBEL/assets/ameliaa.jpg', 'Amel merupakan angkatan 2020 yang mendapatkan nilai A untuk mata kuliah algoritma dan struktur data'),
(10, 'MK005RH Mobile App', 'MK005', 'RH', 'Reynardthan Handoko', 'Jumat, 18.00 WIB', '41', '10000', 'https://bimbelhimsi.000webhostapp.com/BIMBEL/assets/reynardthann.jpg', 'Rey merupakan mahasiswa angkatan 2020 yang mengambil matakuliah Mobile Application Development yang diajarkan oleh Pak Agus, dan lulus dengan nilai A.');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `NamaFull` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nickname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `yoc` varchar(4) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `NamaFull`, `nickname`, `email`, `password`, `phone`, `yoc`) VALUES
(59, 'BillKiki', 'Bill', 'billkiki@gmail.com', '$2y$10$3Dvv0Cl9qXqAHhh3GKtRi.sg12BUhefOoUz9LmhvxE6AmfcF270sa', '201289301', '2020'),
(62, 'tutor', 'tutor', 'tutor@gmail.com', '$2y$10$PKl0hkCnSdoroYhM939HteC9DHQT7GCyRtmvSs7eIB8hwwGDuuOyS', '0000000', '2020'),
(63, 'Reynardthan Handoko', 'reynardthan', 'reynardthanhandoko@gmail.com', '$2y$10$xeaxJ06.e5/spK7dYHGmx.HKiGTAqcDUt.5mY3YEpI3qz4ItaKxJK', '08901823018', '2020'),
(64, 'Reynardthan', 'Nardthan', 'reynardthan@gmail.com', '$2y$10$NLG8ZVOLvoop7DwS9gt9FO4JvLLt7ximmHWuhIkv0HMZCGZebQaVu', '08120381831', '2020'),
(66, 'Rey', 'nard', '', '$2y$10$2ZcZWbv./zr7YZ2AIMzW2OaWhkDTIUEvld8RnWCdovTXURop1flne', '081283786164', '2020'),
(67, 'Rey', 'nard', 'reynard@gmail.com', '$2y$10$FPNqCr.RQD8KbG8cR2Ae7.6kMAcUJpwHOij6U4nrjtU5zMgfG2Yby', '081283786164', '2020'),
(68, 'Rey', 'nard', 'amelia@gmail.com', '$2y$10$P4LHbCm70duJNTBBtsanyOJUcyZDodYIPYF5CvxjbzlioBedBkoum', '081283786164', '2020'),
(70, 'adminbimsi', 'admin', 'adminbimsi@gmail.com', '$2y$10$8sRN3SiCIkDxH1qOEtKb.uRllAXvtpwVKBx57vDdDHI/151Akyp8O', '0000000', '2017'),
(71, 'Amelia Rahmanita', 'amelia', 'ameliarahmanita@gmail.com', '$2y$10$21nXwsISVG/YtX/veo1lreCHJBokcn.CQWv4JrQo8Me6GTrDIACfK', '0812837816322', '2020'),
(73, 'Meilani Yaputri', 'Meilani', 'meilaniyaputri@gmail.com', '$2y$10$9BL6cKAbl9d5TjL09vxYKe2lY1C1lgyKf6DENQyfAStU0qhS7QkrC', '081237861231', '2020'),
(75, 'Mettadewi', 'Metta', 'mettadewi@gmail.com', '$2y$10$nsdjXSrMN.IsoMeo2OEICugp2oCd6BKsQiY83VLsyVobaszqPjLTG', '081231231234', '2020'),
(76, 'Robertus Charlie', 'Ipin', 'robertuscharlie@gmail.com', '$2y$10$Z0v8kou0JRMj.TVckJv0ruNQswOk.9aTeyc/IlyGPZs3jOubgtkVq', '081908634925', '2019'),
(77, 'richard', 'rich', 'richard@gmail.com', '$2y$10$L3UwPcmJwXB6nVMKVw6dA.snC2aVMa9cRiD7Ezj1eS10yxM7jcfqO', '078523319849', '2020');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `forum`
--
ALTER TABLE `forum`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `namasubject`
--
ALTER TABLE `namasubject`
  ADD PRIMARY KEY (`id_namasubject`),
  ADD UNIQUE KEY `kode_namasubject` (`kode_namasubject`);

--
-- Indexes for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`id_mahasiswa`),
  ADD KEY `fk_kelas` (`kode_kelas`);

--
-- Indexes for table `tutor`
--
ALTER TABLE `tutor`
  ADD PRIMARY KEY (`idTutor`),
  ADD UNIQUE KEY `kode_tutor` (`kode_tutor`),
  ADD UNIQUE KEY `kode_kelas` (`kode_kelas`),
  ADD KEY `fk_namasubject` (`kode_namasubject`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `password` (`password`),
  ADD KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `forum`
--
ALTER TABLE `forum`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `pemesanan`
--
ALTER TABLE `pemesanan`
  MODIFY `id_mahasiswa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

--
-- AUTO_INCREMENT for table `tutor`
--
ALTER TABLE `tutor`
  MODIFY `idTutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD CONSTRAINT `fk_kelas` FOREIGN KEY (`kode_kelas`) REFERENCES `tutor` (`kode_kelas`);

--
-- Constraints for table `tutor`
--
ALTER TABLE `tutor`
  ADD CONSTRAINT `fk_kodesubject` FOREIGN KEY (`kode_namasubject`) REFERENCES `namasubject` (`kode_namasubject`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
