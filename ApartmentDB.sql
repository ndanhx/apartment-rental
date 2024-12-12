-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.39 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for apartmentdb
CREATE DATABASE IF NOT EXISTS `apartmentdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `apartmentdb`;

-- Dumping structure for table apartmentdb.account
CREATE TABLE IF NOT EXISTS `account` (
  `id_account` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(150) NOT NULL,
  `amount` bigint DEFAULT NULL,
  `role` int NOT NULL,
  `is_active` int NOT NULL,
  `create_at` date DEFAULT NULL,
  `verify` int DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_account`),
  UNIQUE KEY `usernamePK` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table apartmentdb.account: ~17 rows (approximately)
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(1, 'duyanh', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'Duy Anh', '888888888', 'duyanh@example.com', 88728888, 0, 1, '2023-09-02', 1, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(2, 'seller', 'a4279eae47aaa7417da62434795a011ccb0ec870f7f56646d181b5500a892a9a', 'Nguyen Thi Seller', '0888888889', 'seller@gmail.com', 88768888, 1, 1, '2023-09-13', 1, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(3, 'lock', '0c030586945fe504b604ecc2e875c38ede400cd5cd73da9730302162e6b02c6f', 'Account Lock', '0909090980', 'lock@gmail.com', 88888888, 2, 1, '2023-09-02', 0, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(4, 'user1', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'User 1', '0987654321', 'user1@gmail.com', 88888888, 1, 0, '2023-09-02', 0, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(5, 'user2', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'User 2', '0987654321', 'user2@gmail.com', 88888888, 1, 0, '2023-09-02', 0, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(6, 'user3', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'User 3', '0987654321', 'user3@gmail.com', 88888888, 1, 0, '2023-09-02', 0, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(7, 'user4', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'User 4', '0987654321', 'user4@gmail.com', 88888888, 1, 1, '2023-09-02', 1, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(8, 'user5', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'User 5', '0987654321', 'user5@gmail.com', 88888888, 1, 1, '2023-09-02', 1, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(9, 'user6', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'User 6', '0987654321', 'user6@gmail.com', 88888888, 1, 1, '2023-09-02', 0, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(10, 'user7', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'User 7', '0987654321', 'user7@gmail.com', 88888888, 1, 1, '2023-09-13', 0, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(11, 'user8', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'User 8', '0987654321', 'user8@gmail.com', 88888888, 1, 1, '2023-09-13', 1, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(12, 'user9', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'User 9', '0987654321', 'user9@gmail.com', 88888888, 1, 0, '2023-09-13', 0, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(13, 'user10', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'User 10', '0987654321', 'user10@gmail.com', 88888888, 1, 0, '2023-09-13', 0, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(15, 'checkcheck', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'Duy Anh Check', '0999999999', ' account@gmail.com', 88888888, 2, 1, '2023-09-19', 0, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(16, 'censor', 'b7455c3d632694a7bd554e92d654026ea58408211e2140d931fd99ec62b272a6', 'Kiem Duyet Vien', '0999999999', 'censor@gmail.com', 9999999999, 3, 1, '2023-09-20', 1, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(24, 'seller2', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'Nguyen Thi Seller', '999999988', 'anhnd2001026@student.hiu.vn', 40000, 1, 1, '2023-10-22', 1, NULL);
INSERT INTO `account` (`id_account`, `username`, `password`, `name`, `phone`, `email`, `amount`, `role`, `is_active`, `create_at`, `verify`, `image`) VALUES
	(25, 'seller3', '13fe7cb26584062cee0878c80df1c35a815434a330ca980d580b5239beb2cc6f', 'Nguyen Seller', '999999988', 'anhnd2001026@student.hiu.vn', 80000, 1, 1, '2023-10-22', 1, NULL);

-- Dumping structure for table apartmentdb.apartment
CREATE TABLE IF NOT EXISTS `apartment` (
  `id_apartment` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `name_apartment` varchar(50) DEFAULT NULL,
  `room` int NOT NULL,
  `baths` int DEFAULT NULL,
  `area` int NOT NULL,
  `price` int NOT NULL,
  `description` text NOT NULL,
  `listing_status` int NOT NULL,
  `rental_status` int NOT NULL,
  `street_name` varchar(50) DEFAULT NULL,
  `posting_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `id_ward` int NOT NULL,
  `id_type` int DEFAULT NULL,
  `id_account` int NOT NULL,
  `heart_count` int DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_apartment`),
  KEY `FK_Apartment_idAccount` (`id_account`),
  KEY `FK_Apartment_idDistrict` (`id_ward`),
  KEY `FK_Apartment_idType` (`id_type`),
  CONSTRAINT `FK_Apartment_idAccount` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`),
  CONSTRAINT `FK_Apartment_idDistrict` FOREIGN KEY (`id_ward`) REFERENCES `ward` (`id_ward`),
  CONSTRAINT `FK_Apartment_idType` FOREIGN KEY (`id_type`) REFERENCES `apartmenttype` (`id_type`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table apartmentdb.apartment: ~82 rows (approximately)
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(1, 'Apartment A', 'Apartment Anh', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'NAh Bien Phu Street', '2024-12-12', '2034-12-22', 21, 1, 1, 3, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(2, 'Apartment B', 'Apartment B', 3, 2, 120, 1500, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 22, 2, 1, 3, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(5, '9', 'test1', 9, 9, 9, 9, '9', 1, 1, '9', '2024-12-12', '2034-12-22', 11, 3, 1, 5, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(6, 'Apartment D', 'Apartment D', 2, 2, 100, 1000, 'DDDDDDDDDDDDDDDDDDDDDD of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 11, 1, 2, 2, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(7, 'Title Apartment E', 'Apartment E', 2, 2, 100, 1000, 'DDDDDDDDDDDDDDDDDDDDDD of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 15, 3, 2, 8, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(8, 'Apartment F', 'Apartment E', 5, 6, 100, 1000, 'Apartment F of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 21, 1, 2, 1, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(9, 'Apartment G', 'Apartment G', 2, 2, 100, 1000, 'DDDDDDDDDDDDDDDDDDDDDD of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 11, 1, 2, 3, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(10, 'Apartment EEA', 'Apartment EE', 5, 4, 233, 95000000, 'Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEA Apartment EEA Apartment EEAApartment EEA Apartment EEA Apartment EEA', 1, 1, 'dien bien phu', '2024-12-12', '2034-12-22', 21, 1, 2, 23, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(12, 'Apartment 11 + TITLE', 'Apartment 11', 2, 2, 111, 10000000, 'Apartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLEApartment 11 + TITLE', 1, 1, '22 Dien Bien Phu  Street', '2024-12-12', '2034-12-22', 20, 1, 1, 3, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(13, 'Apartment G', 'Apartment G', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) residential buildings, or a separata residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.e dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(14, 'Apartment E', 'Apartment E', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) a residential unit that is part of one (or several) residential buildia residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ngs, or a separate dwelling within a house with its own entrance, bathroom and kitchen.residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(15, 'Apartment D', 'Apartment D', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathrooa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.m and kitchen. of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(16, 'Apartment A', 'Apartment A', 2, 2, 100, 1000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 11, 1, 1, 1, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(17, 'Apartment B', 'Apartment B', 3, 2, 120, 1500, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 22, 2, 1, 1, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(18, 'Apartment C', 'Apartment C', 1, 1, 60, 800, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 15, 3, 1, 2, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(19, 'Apartment G', 'Apartment G', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) residential buildings, or a separata residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.e dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(20, 'Apartment E', 'Apartment E', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) a residential unit that is part of one (or several) residential buildia residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ngs, or a separate dwelling within a house with its own entrance, bathroom and kitchen.residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 11, 1, 2, 1, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(21, 'Apartment D', 'Apartment D', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathrooa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.m and kitchen. of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(22, 'Apartment A', 'Apartment A', 2, 2, 100, 1000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 11, 1, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(23, 'Apartment B', 'Apartment B', 3, 2, 120, 1500, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 1, 1, 'Dien Bien Phu Street', '2024-12-12', '2034-12-22', 22, 2, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(24, 'Apartment C', 'Apartment C', 1, 1, 60, 800, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 0, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 15, 3, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(25, 'Apartment G', 'Apartment G', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) residential buildings, or a separata residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.e dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(26, 'Apartment E', 'Apartment E', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) a residential unit that is part of one (or several) residential buildia residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ngs, or a separate dwelling within a house with its own entrance, bathroom and kitchen.residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(27, 'Apartment D', 'Apartment D', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathrooa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.m and kitchen. of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(28, 'Apartment A', 'Apartment A', 2, 2, 100, 1000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 11, 1, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(29, 'Apartment B', 'Apartment B', 3, 2, 120, 1500, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 0, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 22, 2, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(30, 'Apartment C', 'Apartment C', 1, 1, 60, 800, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 0, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 15, 3, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(31, 'Apartment G', 'Apartment G', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) residential buildings, or a separata residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.e dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(32, 'Apartment E', 'Apartment E', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) a residential unit that is part of one (or several) residential buildia residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ngs, or a separate dwelling within a house with its own entrance, bathroom and kitchen.residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(33, 'Apartment D', 'Apartment D', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathrooa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.m and kitchen. of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(34, 'Apartment A', 'Apartment A', 2, 2, 100, 1000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-13', '2033-09-23', 11, 1, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(35, 'Apartment B', 'Apartment B', 3, 2, 120, 1500, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 0, 'Dien Bien Phu Street', '2023-09-14', '2033-09-24', 22, 2, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(36, 'Apartment C', 'Apartment C', 1, 1, 60, 800, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 0, 'Dien Bien Phu Street', '2023-09-15', '2033-09-25', 15, 3, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(37, 'Apartment G', 'Apartment G', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) residential buildings, or a separata residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.e dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(38, 'Apartment E', 'Apartment E', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) a residential unit that is part of one (or several) residential buildia residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ngs, or a separate dwelling within a house with its own entrance, bathroom and kitchen.residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(39, 'Apartment D', 'Apartment D', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathrooa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.m and kitchen. of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 11, 1, 2, 1, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(40, 'Apartment A', 'Apartment A', 2, 2, 100, 1000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 11, 1, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(41, 'Apartment B', 'Apartment B', 3, 2, 120, 1500, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 22, 2, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(42, 'Apartment C', 'Apartment C', 1, 1, 60, 800, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 15, 3, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(43, 'Apartment G', 'Apartment G', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) residential buildings, or a separata residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.e dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(44, 'Apartment E', 'Apartment E', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) a residential unit that is part of one (or several) residential buildia residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ngs, or a separate dwelling within a house with its own entrance, bathroom and kitchen.residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-13', '2033-09-23', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(45, 'Apartment D', 'Apartment D', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathrooa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.m and kitchen. of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-13', '2033-09-23', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(46, 'Apartment A', 'Apartment A', 2, 2, 100, 1000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-13', '2033-09-23', 11, 1, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(47, 'Apartment B', 'Apartment B', 3, 2, 120, 1500, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 0, 'Dien Bien Phu Street', '2023-09-14', '2033-09-24', 22, 2, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(48, 'Apartment C', 'Apartment C', 1, 1, 60, 800, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 0, 'Dien Bien Phu Street', '2023-09-15', '2033-09-25', 15, 3, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(49, 'Apartment G', 'Apartment G', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) residential buildings, or a separata residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.e dwelling within a house with its own entrance, bathroom and kitchen.', 0, 1, 'Dien Bien Phu Street', '2024-04-02', '2034-04-12', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(50, 'Apartment E', 'Apartment E', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) a residential unit that is part of one (or several) residential buildia residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ngs, or a separate dwelling within a house with its own entrance, bathroom and kitchen.residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-13', '2033-09-23', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(51, 'Apartment D', 'Apartment D', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathrooa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.m and kitchen. of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-13', '2033-09-23', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(52, 'Apartment A', 'Apartment A', 2, 2, 100, 1000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-13', '2033-09-23', 11, 1, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(53, 'Apartment B', 'Apartment B', 3, 2, 120, 1500, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 0, 'Dien Bien Phu Street', '2023-09-14', '2033-09-24', 22, 2, 1, 1, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(54, 'Apartment C', 'Apartment C', 1, 1, 60, 800, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 15, 3, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(55, 'Apartment G', 'Apartment G', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) residential buildings, or a separata residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.e dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 11, 1, 2, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(56, 'Apartment E', 'Apartment E', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. of one (or several) a residential unit that is part of one (or several) residential buildia residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ngs, or a separate dwelling within a house with its own entrance, bathroom and kitchen.residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 11, 1, 2, 1, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(57, 'Apartment D', 'Apartment D', 2, 2, 100, 1000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathrooa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.m and kitchen. of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 11, 1, 2, 1, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(58, 'Apartment A', 'Apartment A', 2, 2, 100, 1000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 11, 1, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(59, 'Apartment B', 'Apartment B', 3, 2, 120, 1500, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 22, 2, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(60, 'Apartment C', 'Apartment C', 1, 1, 60, 800, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 0, 'Dien Bien Phu Street', '2023-09-28', '2033-10-08', 15, 3, 1, 1, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(61, 'Apartment AS', 'Apartment A', 2, 2, 100, 10000000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 2, 1, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 11, 1, 1, 11, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(62, 'Apartment BJD', 'Apartment B', 3, 2, 120, 15000000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 0, 'Dien Bien Phu Street', '2023-09-14', '2033-09-24', 22, 2, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(63, 'Apartment CP', 'Apartment C', 1, 1, 60, 20000000, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 0, 'Dien Bien Phu Street', '2023-09-15', '2033-09-25', 15, 3, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(64, 'Apartment AQQ', 'Apartment A', 2, 2, 100, 52000000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 2, 1, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 11, 1, 1, 9, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(65, 'Apartment BQ', 'Apartment B', 3, 2, 120, 21000000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 2, 1, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 22, 2, 1, 2, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(66, 'Apartment CQ', 'Apartment C', 1, 1, 60, 9000000, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 2, 1, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 15, 3, 1, 35, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(67, 'Apartment AS', 'Apartment A', 2, 2, 100, 10000000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 0, 1, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 11, 1, 1, 4, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(68, 'Apartment BJD', 'Apartment B', 3, 2, 120, 15000000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 1, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 22, 2, 1, 6, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(69, 'Apartment CP', 'Apartment C', 1, 1, 60, 20000000, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 1, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 15, 3, 1, 3, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(70, 'Apartment AQQ', 'Apartment A', 2, 2, 100, 52000000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 2, 1, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 11, 1, 1, 1, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(71, 'Apartment BQ', 'Apartment B', 3, 2, 120, 21000000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 1, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 22, 2, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(72, 'Apartment CQ', 'Apartment C', 1, 1, 60, 9000000, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 1, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 15, 3, 1, 2, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(73, 'Apartment AS', 'Apartment A', 2, 2, 100, 10000000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 0, 1, 'Dien Bien Phu Street', '2024-05-27', '2034-06-06', 11, 1, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(74, 'Apartment BJD', 'Apartment B', 3, 2, 120, 15000000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 1, 'Dien Bien Phu Street', '2023-09-29', '2033-10-09', 22, 2, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(75, 'Apartment CP', 'Apartment C', 1, 1, 60, 20000000, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 0, 'Dien Bien Phu Street', '2023-09-29', '2033-10-09', 15, 3, 1, 2, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(76, 'Apartment AQQ', 'Apartment A', 2, 2, 100, 52000000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 0, 1, 'Dien Bien Phu Street', '2023-09-29', '2033-10-09', 11, 1, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(77, 'Apartment BQ', 'Apartment B', 3, 2, 120, 21000000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 1, 'Dien Bien Phu Street', '2023-09-29', '2033-10-09', 22, 2, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(78, 'Apartment CQ', 'Apartment C', 1, 1, 60, 9000000, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 1, 'Dien Bien Phu Street', '2023-09-29', '2033-10-09', 15, 3, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(79, 'Apartment AS', 'Apartment A', 2, 2, 100, 10000000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 0, 1, 'Dien Bien Phu Street', '2023-09-29', '2033-10-09', 11, 1, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(80, 'Apartment BJD', 'Apartment B', 3, 2, 120, 15000000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 1, 'Dien Bien Phu Street', '2023-10-19', '2033-10-29', 22, 2, 1, 4, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(81, 'Apartment CP', 'Apartment C', 1, 1, 60, 20000000, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 1, 'Dien Bien Phu Street', '2023-09-15', '2033-09-25', 15, 3, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(82, 'Apartment AQQ', 'Apartment A', 2, 2, 100, 52000000, 'a residential unit that is part of onea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. (or several) residential buildings, or a separate dwelling within a house with its owna residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen. entrance, bathroom and kitchen.', 0, 1, 'Dien Bien Phu Street', '2023-09-13', '2033-09-23', 11, 1, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(83, 'Apartment BQ', 'Apartment B', 3, 2, 120, 21000000, 'a residential unit that is part of one (or several) residential buildings, or a separate dwelling within a ha residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.ouse with its own entrance, bathroom and kita residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.chen.', 0, 1, 'Dien Bien Phu Street', '2023-09-14', '2033-09-24', 22, 2, 1, 0, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(84, 'Apartment CQ', 'Apartment C', 1, 1, 60, 9000000, 'a residential unit that is part of one (or several) residential buildings, oa residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.r a separate dwelling within a house with its own entrance, bathroom and kitchea residential unit that is part of one (or several) residential buildings, or a separate dwelling within a house with its own entrance, bathroom and kitchen.n.', 0, 1, 'Dien Bien Phu Street', '2023-09-29', '2033-10-09', 15, 3, 1, 2, NULL);
INSERT INTO `apartment` (`id_apartment`, `title`, `name_apartment`, `room`, `baths`, `area`, `price`, `description`, `listing_status`, `rental_status`, `street_name`, `posting_date`, `end_date`, `id_ward`, `id_type`, `id_account`, `heart_count`, `img`) VALUES
	(86, 'Can Ho Dep Nhat ', 'Can ho dep nhat', 2, 2, 200, 98000000, 'Can Ho Dep Nhat Can Ho Dep Nhat ', 0, 0, '200 dien bien phu', '2023-10-22', '2033-11-01', 11, 1, 25, 4, NULL);

-- Dumping structure for table apartmentdb.apartmenttype
CREATE TABLE IF NOT EXISTS `apartmenttype` (
  `id_type` int NOT NULL AUTO_INCREMENT,
  `name_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table apartmentdb.apartmenttype: ~4 rows (approximately)
INSERT INTO `apartmenttype` (`id_type`, `name_type`) VALUES
	(1, 'House');
INSERT INTO `apartmenttype` (`id_type`, `name_type`) VALUES
	(2, 'Single');
INSERT INTO `apartmenttype` (`id_type`, `name_type`) VALUES
	(3, 'Relationship');
INSERT INTO `apartmenttype` (`id_type`, `name_type`) VALUES
	(4, 'TEST');

-- Dumping structure for table apartmentdb.city
CREATE TABLE IF NOT EXISTS `city` (
  `id_city` int NOT NULL,
  `name_city` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_city`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table apartmentdb.city: ~64 rows (approximately)
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(1, 'An Giang');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(2, 'Bà Rịa - Vũng Tàu');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(3, 'Bạc Liêu');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(4, 'Bắc Kạn');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(5, 'Bắc Giang');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(6, 'Bắc Ninh');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(7, 'Bến Tre');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(8, 'Bình Dương');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(9, 'Bình Định');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(10, 'Bình Phước');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(11, 'Bình Thuận');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(12, 'Cà Mau');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(13, 'Cần Thơ');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(14, 'Cao Bằng');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(15, 'Đà Nẵng');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(16, 'Đắk Lắk');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(17, 'Đắk Nông');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(18, 'Điện Biên');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(19, 'Đồng Nai');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(20, 'Đồng Tháp');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(21, 'Gia Lai');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(22, 'Hà Giang');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(23, 'Hà Nam');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(24, 'Hà Nội');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(25, 'Hà Tĩnh');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(26, 'Hải Dương');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(27, 'Hải Phòng');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(28, 'Hậu Giang');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(29, 'Hòa Bình');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(30, 'Hưng Yên');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(31, 'Khánh Hòa');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(32, 'Kiên Giang');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(33, 'Kon Tum');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(34, 'Lai Châu');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(35, 'Lâm Đồng');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(36, 'Lạng Sơn');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(37, 'Lào Cai');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(38, 'Long An');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(39, 'Nam Định');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(40, 'Nghệ An');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(41, 'Ninh Bình');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(42, 'Ninh Thuận');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(43, 'Phú Thọ');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(44, 'Phú Yên');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(45, 'Quảng Bình');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(46, 'Quảng Nam');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(47, 'Quảng Ngãi');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(48, 'Quảng Ninh');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(49, 'Quảng Trị');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(50, 'Sóc Trăng');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(51, 'Sơn La');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(52, 'Tây Ninh');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(53, 'Thái Bình');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(54, 'Thái Nguyên');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(55, 'Thanh Hóa');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(56, 'Thừa Thiên-Huế');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(57, 'Tiền Giang');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(58, 'Trà Vinh');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(59, 'Tuyên Quang');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(60, 'Vĩnh Long');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(61, 'Vĩnh Phúc');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(62, 'Yên Bái');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(63, 'Phú Quốc');
INSERT INTO `city` (`id_city`, `name_city`) VALUES
	(64, 'Thành Phố Hồ chí Minh');

-- Dumping structure for table apartmentdb.district
CREATE TABLE IF NOT EXISTS `district` (
  `id_district` int NOT NULL,
  `name_district` varchar(50) DEFAULT NULL,
  `id_city` int DEFAULT NULL,
  PRIMARY KEY (`id_district`),
  KEY `FK_ThanhPho_idQsuan` (`id_city`),
  CONSTRAINT `FK_ThanhPho_idQsuan` FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table apartmentdb.district: ~39 rows (approximately)
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(1, 'Quận 1', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(2, 'Quận 2', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(3, 'Quận 3', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(4, 'Quận 4', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(5, 'Quận 5', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(6, 'Quận 6', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(7, 'Quận 7', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(8, 'Quận 8', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(9, 'Quận 9', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(10, 'Quận 10', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(11, 'Quận 11', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(12, 'Quận 12', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(13, 'Quận Bình Thạnh', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(14, 'Quận Phú Nhuận', 64);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(15, 'Quận Hoàn Kiếm', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(16, 'Quận Tây Hồ', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(17, 'Quận Ba Đình', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(18, 'Quận Hai Bà Trưng', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(19, 'Quận Đống Đa', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(20, 'Quận Cầu Giấy', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(21, 'Quận Hoàng Mai', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(22, 'Quận Long Biên', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(23, 'Huyện Sóc Sơn', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(24, 'Huyện Đông Anh', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(25, 'Huyện Gia Lâm', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(26, 'Huyện Thanh Trì', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(27, 'Huyện Ba Vì', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(28, 'Huyện Phúc Thọ', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(29, 'Huyện Đan Phượng', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(30, 'Huyện Hoài Đức', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(31, 'Huyện Quốc Oai', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(32, 'Huyện Thạch Thất', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(33, 'Huyện Chương Mỹ', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(34, 'Huyện Thanh Oai', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(35, 'Huyện Mỹ Đức', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(36, 'Huyện Ứng Hòa', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(37, 'Huyện Thường Tín', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(38, 'Huyện Phú Xuyên', 24);
INSERT INTO `district` (`id_district`, `name_district`, `id_city`) VALUES
	(39, 'Huyện Mê Linh', 24);

-- Dumping structure for table apartmentdb.image
CREATE TABLE IF NOT EXISTS `image` (
  `id_image` int NOT NULL AUTO_INCREMENT,
  `name_image` varchar(50) DEFAULT NULL,
  `link_image` varchar(200) DEFAULT NULL,
  `id_apartment` int NOT NULL,
  PRIMARY KEY (`id_image`),
  KEY `FK_AnhCanHo_CanHo` (`id_apartment`),
  CONSTRAINT `FK_AnhCanHo_CanHo` FOREIGN KEY (`id_apartment`) REFERENCES `apartment` (`id_apartment`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table apartmentdb.image: ~1 rows (approximately)
INSERT INTO `image` (`id_image`, `name_image`, `link_image`, `id_apartment`) VALUES
	(1, 'anh2', 'img2.jpg', 6);

-- Dumping structure for table apartmentdb.paymentreceipt
CREATE TABLE IF NOT EXISTS `paymentreceipt` (
  `id_payment` int NOT NULL AUTO_INCREMENT,
  `payment_date` date DEFAULT NULL,
  `payment_method` varchar(50) DEFAULT NULL,
  `total_amount` bigint DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `id_account` int NOT NULL,
  PRIMARY KEY (`id_payment`),
  KEY `FK_PaymentReceipt_AccountID` (`id_account`),
  CONSTRAINT `FK_PaymentReceipt_AccountID` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table apartmentdb.paymentreceipt: ~70 rows (approximately)
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(1, '2023-09-13', 'Banking', 10000, 'success', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(2, '2023-09-13', 'Banking', 10000, 'failed', 0, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(3, '2023-09-13', 'Banking', 20000, 'success', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(4, '2023-10-01', 'Banking', 56000, 'sucess', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(5, '2023-10-20', 'Banking', 110000, 'sucess', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(6, '2023-10-19', 'Banking', 80000, 'sucess', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(7, '2023-10-20', 'Banking', 20000, 'seller, thanh toan online qua cong VNPAY', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(8, '2023-10-21', 'Banking', -10000, '-10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(9, '2023-10-21', 'Banking', 10000, '+10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(10, '2023-10-21', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(11, '2023-10-21', 'Banking', 10000, 'tai khoan +10,000VND do bai dang bi REJECT', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(12, '2023-10-22', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(13, '2023-10-22', 'Banking', 50000, 'seller2, thanh toan online qua cong VNPAY', 1, 24);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(14, '2023-10-22', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 24);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(15, '2023-10-22', 'Banking', 10000, 'tai khoan +10,000VND do bai dang bi REJECT', 1, 24);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(16, '2023-10-22', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 24);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(17, '2023-10-22', 'Banking', 90000, 'seller3, thanh toan online qua cong VNPAY', 1, 25);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(18, '2023-10-22', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 25);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(19, '2023-10-22', 'Banking', 10000, 'tai khoan +10,000VND do bai dang bi REJECT', 1, 25);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(20, '2023-10-22', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 25);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(21, '2024-03-01', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(22, '2024-03-01', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(23, '2024-04-02', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(24, '2024-04-02', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(25, '2024-04-02', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(26, '2024-04-02', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(27, '2024-04-02', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(28, '2024-04-02', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(29, '2024-04-02', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(30, '2024-04-02', 'Banking', 10000, 'seller, thanh toan online qua cong VNPAY', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(31, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(32, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(33, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(34, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(35, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(36, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(37, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(38, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(39, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(40, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(41, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(42, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(43, '2024-05-27', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(44, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(45, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(46, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(47, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(48, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(49, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(50, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(51, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(52, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(53, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(54, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(55, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(56, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(57, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(58, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(59, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(60, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(61, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(62, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(63, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(64, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(65, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 2);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(66, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(67, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(68, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(69, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);
INSERT INTO `paymentreceipt` (`id_payment`, `payment_date`, `payment_method`, `total_amount`, `description`, `status`, `id_account`) VALUES
	(70, '2024-12-12', 'Banking', -10000, 'tai khoan -10,000VND thanh toan bai dang', 1, 1);

-- Dumping structure for table apartmentdb.ward
CREATE TABLE IF NOT EXISTS `ward` (
  `id_ward` int NOT NULL,
  `name_ward` varchar(50) DEFAULT NULL,
  `id_district` int DEFAULT NULL,
  PRIMARY KEY (`id_ward`),
  KEY `FK_Phuongs_idquan` (`id_district`),
  CONSTRAINT `FK_Phuongs_idquan` FOREIGN KEY (`id_district`) REFERENCES `district` (`id_district`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table apartmentdb.ward: ~22 rows (approximately)
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(1, 'Phường 1', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(2, 'Phường 2', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(3, 'Phường 3', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(4, 'Phường 4', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(5, 'Phường 5', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(6, 'Phường 6', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(7, 'Phường 7', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(8, 'Phường 8', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(9, 'Phường 9', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(10, 'Phường 10', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(11, 'Phường 11', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(12, 'Phường 12', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(13, 'Phường 13', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(14, 'Phường 14', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(15, 'Phường 15', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(16, 'Phường 16', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(17, 'Phường 17', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(18, 'Phường 18', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(19, 'Phường 19', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(20, 'Phường 20', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(21, 'Phường 21', 13);
INSERT INTO `ward` (`id_ward`, `name_ward`, `id_district`) VALUES
	(22, 'Phường 22', 13);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
