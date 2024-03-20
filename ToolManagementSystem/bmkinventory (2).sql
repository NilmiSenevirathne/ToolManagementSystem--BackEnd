-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 20, 2024 at 08:49 AM
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
-- Database: `bmkinventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `allocated_tools`
--

DROP TABLE IF EXISTS `allocated_tools`;
CREATE TABLE IF NOT EXISTS `allocated_tools` (
  `id` bigint NOT NULL,
  `allocated_quantity` int NOT NULL,
  `project_id` bigint DEFAULT NULL,
  `saved_quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `allocated_tools_mapping`
--

DROP TABLE IF EXISTS `allocated_tools_mapping`;
CREATE TABLE IF NOT EXISTS `allocated_tools_mapping` (
  `tool_id` bigint NOT NULL,
  `allocated_tool_id` bigint NOT NULL,
  PRIMARY KEY (`tool_id`,`allocated_tool_id`),
  KEY `FK2ojl3nrg5jnxuf4bwj3gkik5f` (`allocated_tool_id`)
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
  `allocated_tool_id` bigint NOT NULL,
  `tool_id` bigint NOT NULL,
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
  `location_id` bigint DEFAULT NULL,
  `supervisor_id` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  KEY `FKf26udtksq9wiwsjv6bp7dq053` (`location_id`),
  KEY `FKhswfwa3ga88vxv1pmboss6jhm` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
CREATE TABLE IF NOT EXISTS `reports` (
  `report_id` varchar(255) NOT NULL,
  `report_typeid` varchar(255) DEFAULT NULL,
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
  `tool_id` bigint NOT NULL,
  `pic` varbinary(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `qr_id` varchar(255) DEFAULT NULL,
  `saved_quantity` int DEFAULT NULL,
  `tool_name` varchar(255) DEFAULT NULL,
  `allocated_quantity` int DEFAULT NULL,
  PRIMARY KEY (`tool_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tools`
--

INSERT INTO `tools` (`tool_id`, `pic`, `description`, `qr_id`, `saved_quantity`, `tool_name`, `allocated_quantity`) VALUES
(25346, NULL, 'High power and speed for grinding.Sealed toggle switch provides protection from dust and fillings extending switch life.Tool free adjustable guard allows easy positioning for left or right-handed use.Accessible brushes for easy brush replacement & less do', NULL, 7, 'Angle Grinder Machine - 4 inch', 5);

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
  `project_id` bigint DEFAULT NULL,
  `supervisor_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bq5ow00jtilbvmsd2l5uyxqmw` (`tool_id`),
  KEY `FK6dcvusmn5l8q6vk23nxbwq1i0` (`location_id`),
  KEY `FK7xmm1txm7qp04pmxs2ype75ww` (`project_id`)
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
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `contact` int NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `nic` int NOT NULL,
  `password` varchar(255) NOT NULL,
  `pic` varbinary(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `user_typeid` bigint DEFAULT NULL,
  `project_id` bigint DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `FKs56btya000gpydk446xrw2jx3` (`user_typeid`),
  KEY `FKj4xjs6i0exxcgearpuykol477` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
CREATE TABLE IF NOT EXISTS `user_type` (
  `user_typeid` bigint NOT NULL AUTO_INCREMENT,
  `user_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `allocated_tools_mapping`
--
ALTER TABLE `allocated_tools_mapping`
  ADD CONSTRAINT `FK2ojl3nrg5jnxuf4bwj3gkik5f` FOREIGN KEY (`allocated_tool_id`) REFERENCES `allocated_tools` (`id`),
  ADD CONSTRAINT `FKqd2w5n5uq3fp1g370rqoflspr` FOREIGN KEY (`tool_id`) REFERENCES `tools` (`tool_id`);

--
-- Constraints for table `allocated_tools_set`
--
ALTER TABLE `allocated_tools_set`
  ADD CONSTRAINT `FK6bumbjufy0pgi44lsx0ecxpt3` FOREIGN KEY (`allocated_tool_id`) REFERENCES `allocated_tools` (`id`),
  ADD CONSTRAINT `FKt03p7ney98wjvmp9y4ub33t2v` FOREIGN KEY (`tool_id`) REFERENCES `tools` (`tool_id`);

--
-- Constraints for table `projects`
--
ALTER TABLE `projects`
  ADD CONSTRAINT `FKf26udtksq9wiwsjv6bp7dq053` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`),
  ADD CONSTRAINT `FKhswfwa3ga88vxv1pmboss6jhm` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `tool_box`
--
ALTER TABLE `tool_box`
  ADD CONSTRAINT `FK6dcvusmn5l8q6vk23nxbwq1i0` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`),
  ADD CONSTRAINT `FK7xmm1txm7qp04pmxs2ype75ww` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKj4xjs6i0exxcgearpuykol477` FOREIGN KEY (`project_id`) REFERENCES `projects` (`project_id`),
  ADD CONSTRAINT `FKs56btya000gpydk446xrw2jx3` FOREIGN KEY (`user_typeid`) REFERENCES `user_type` (`user_typeid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
