-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 20, 2024 at 05:38 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `diluminventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `allocated_tools`
--

DROP TABLE IF EXISTS `allocated_tools`;
CREATE TABLE IF NOT EXISTS `allocated_tools` (
  `id` varchar(255) NOT NULL,
  `allocated_quantity` int NOT NULL,
  `saved_quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `allocated_tools_seq`
--

DROP TABLE IF EXISTS `allocated_tools_seq`;
CREATE TABLE IF NOT EXISTS `allocated_tools_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `allocated_tools_seq`
--

INSERT INTO `allocated_tools_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `allocated_tools_set`
--

DROP TABLE IF EXISTS `allocated_tools_set`;
CREATE TABLE IF NOT EXISTS `allocated_tools_set` (
  `allocated_tool_id` varchar(255) NOT NULL,
  `tool_id` varchar(255) NOT NULL,
  PRIMARY KEY (`allocated_tool_id`,`tool_id`),
  KEY `FKt03p7ney98wjvmp9y4ub33t2v` (`tool_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `location_id` bigint NOT NULL AUTO_INCREMENT,
  `location_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
CREATE TABLE IF NOT EXISTS `messages` (
  `message_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
CREATE TABLE IF NOT EXISTS `projects` (
  `project_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
CREATE TABLE IF NOT EXISTS `reports` (
  `report_id` bigint NOT NULL,
  `report_details` varchar(255) DEFAULT NULL,
  `report_name` varchar(255) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reports_seq`
--

DROP TABLE IF EXISTS `reports_seq`;
CREATE TABLE IF NOT EXISTS `reports_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `reports_seq`
--

INSERT INTO `reports_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `report_type`
--

DROP TABLE IF EXISTS `report_type`;
CREATE TABLE IF NOT EXISTS `report_type` (
  `report_typeid` bigint NOT NULL AUTO_INCREMENT,
  `report_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`report_typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tools`
--

DROP TABLE IF EXISTS `tools`;
CREATE TABLE IF NOT EXISTS `tools` (
  `tool_id` varchar(255) NOT NULL,
  `pic` varbinary(255) DEFAULT NULL,
  `allocated_quantity` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `saved_quantity` int DEFAULT NULL,
  `tool_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tool_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tools_seq`
--

DROP TABLE IF EXISTS `tools_seq`;
CREATE TABLE IF NOT EXISTS `tools_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tools_seq`
--

INSERT INTO `tools_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `tool_box`
--

DROP TABLE IF EXISTS `tool_box`;
CREATE TABLE IF NOT EXISTS `tool_box` (
  `id` bigint NOT NULL,
  `qr_id` varchar(500) NOT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `tool_details` varchar(255) DEFAULT NULL,
  `tool_id` varchar(255) DEFAULT NULL,
  `location_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bq5ow00jtilbvmsd2l5uyxqmw` (`tool_id`),
  KEY `FK6dcvusmn5l8q6vk23nxbwq1i0` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tool_box_seq`
--

DROP TABLE IF EXISTS `tool_box_seq`;
CREATE TABLE IF NOT EXISTS `tool_box_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tool_box_seq`
--

INSERT INTO `tool_box_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` varchar(255) NOT NULL,
  `contact` int NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `nic` int NOT NULL,
  `password` varchar(255) NOT NULL,
  `pic` varbinary(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `user_typeid` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `FKs56btya000gpydk446xrw2jx3` (`user_typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `contact`, `firstname`, `lastname`, `nic`, `password`, `pic`, `username`, `user_typeid`) VALUES
('U001', 718456322, 'Isuru', 'Withanage', 189267222, 'isu@123', NULL, 'isuru@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users_seq`
--

DROP TABLE IF EXISTS `users_seq`;
CREATE TABLE IF NOT EXISTS `users_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
CREATE TABLE IF NOT EXISTS `user_type` (
  `user_typeid` bigint NOT NULL AUTO_INCREMENT,
  `user_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_typeid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_type`
--

INSERT INTO `user_type` (`user_typeid`, `user_type`) VALUES
(1, 'Admin');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `allocated_tools_set`
--
ALTER TABLE `allocated_tools_set`
  ADD CONSTRAINT `FK6bumbjufy0pgi44lsx0ecxpt3` FOREIGN KEY (`allocated_tool_id`) REFERENCES `allocated_tools` (`id`),
  ADD CONSTRAINT `FKt03p7ney98wjvmp9y4ub33t2v` FOREIGN KEY (`tool_id`) REFERENCES `tools` (`tool_id`);

--
-- Constraints for table `tool_box`
--
ALTER TABLE `tool_box`
  ADD CONSTRAINT `FK6dcvusmn5l8q6vk23nxbwq1i0` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKs56btya000gpydk446xrw2jx3` FOREIGN KEY (`user_typeid`) REFERENCES `user_type` (`user_typeid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
