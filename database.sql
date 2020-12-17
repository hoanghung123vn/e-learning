CREATE DATABASE  IF NOT EXISTS `learning_toeic_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `learning_toeic_db`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: learning_toeic_db
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` int NOT NULL,
  `guide_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_idx` (`user_id`),
  KEY `fk_grammar_guide_idx` (`guide_id`),
  CONSTRAINT `fk_comment_guide` FOREIGN KEY (`guide_id`) REFERENCES `guides` (`id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_questions`
--

DROP TABLE IF EXISTS `exam_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `no` int NOT NULL,
  `image_path` varchar(45) DEFAULT NULL,
  `audiomp3_path` varchar(45) DEFAULT NULL,
  `audiogg_path` varchar(45) DEFAULT NULL,
  `exam_questionscol` varchar(45) DEFAULT NULL,
  `paragraph` text,
  `question` varchar(255) DEFAULT NULL,
  `option1` varchar(255) DEFAULT NULL,
  `option2` varchar(255) DEFAULT NULL,
  `option3` varchar(255) DEFAULT NULL,
  `option4` varchar(255) DEFAULT NULL,
  `correct` varchar(45) DEFAULT NULL,
  `exam_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_exam_question_idx` (`exam_id`),
  CONSTRAINT `fk_exam_question` FOREIGN KEY (`exam_id`) REFERENCES `examinations` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_questions`
--

LOCK TABLES `exam_questions` WRITE;
/*!40000 ALTER TABLE `exam_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examinations`
--

DROP TABLE IF EXISTS `examinations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examinations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `image_path` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `checked_question` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examinations`
--

LOCK TABLES `examinations` WRITE;
/*!40000 ALTER TABLE `examinations` DISABLE KEYS */;
/*!40000 ALTER TABLE `examinations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercises`
--

DROP TABLE IF EXISTS `exercises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercises` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `image_path` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `checked_question` int NOT NULL,
  `type` enum('READ','LISTEN') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercises`
--

LOCK TABLES `exercises` WRITE;
/*!40000 ALTER TABLE `exercises` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guides`
--

DROP TABLE IF EXISTS `guides`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guides` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image_path` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` text COLLATE utf8_unicode_ci,
  `type` enum('GRAMMAR','VOCABULARY') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guides`
--

LOCK TABLES `guides` WRITE;
/*!40000 ALTER TABLE `guides` DISABLE KEYS */;
/*!40000 ALTER TABLE `guides` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listen_questions`
--

DROP TABLE IF EXISTS `listen_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listen_questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `no` int NOT NULL,
  `image_path` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `question` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `audiomp3_path` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `audiogg_path` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option1` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option2` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option3` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `option4` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `correct` int NOT NULL,
  `listen_exercise_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_listen_exercise_id_idx` (`listen_exercise_id`),
  CONSTRAINT `fk_listen_exercise_id` FOREIGN KEY (`listen_exercise_id`) REFERENCES `exercises` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listen_questions`
--

LOCK TABLES `listen_questions` WRITE;
/*!40000 ALTER TABLE `listen_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `listen_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provinces`
--

DROP TABLE IF EXISTS `provinces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provinces` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provinces`
--

LOCK TABLES `provinces` WRITE;
/*!40000 ALTER TABLE `provinces` DISABLE KEYS */;
/*!40000 ALTER TABLE `provinces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `read_questions`
--

DROP TABLE IF EXISTS `read_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `read_questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `no` int NOT NULL,
  `paragraph` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `question` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `option1` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `option2` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `option3` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `option4` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `correct` int NOT NULL,
  `read_exercise_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_read_exercise_idx` (`read_exercise_id`),
  CONSTRAINT `fk_read_exercise` FOREIGN KEY (`read_exercise_id`) REFERENCES `exercises` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `read_questions`
--

LOCK TABLES `read_questions` WRITE;
/*!40000 ALTER TABLE `read_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `read_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slide_banners`
--

DROP TABLE IF EXISTS `slide_banners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `slide_banners` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `content` text COLLATE utf8_unicode_ci,
  `image_path` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slide_banners`
--

LOCK TABLES `slide_banners` WRITE;
/*!40000 ALTER TABLE `slide_banners` DISABLE KEYS */;
/*!40000 ALTER TABLE `slide_banners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `role` enum('ADMIN','MEMBER') COLLATE utf8_unicode_ci NOT NULL,
  `province_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_province_idx` (`province_id`),
  CONSTRAINT `fk_province` FOREIGN KEY (`province_id`) REFERENCES `provinces` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voca_contents`
--

DROP TABLE IF EXISTS `voca_contents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voca_contents` (
  `id` int NOT NULL AUTO_INCREMENT,
  `num` int NOT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `transcribe` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `image_path` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `audiomp3_path` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `audiogg_path` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mean` text COLLATE utf8_unicode_ci NOT NULL,
  `voca_guide_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_guide_idx` (`voca_guide_id`),
  CONSTRAINT `fk_guide` FOREIGN KEY (`voca_guide_id`) REFERENCES `guides` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voca_contents`
--

LOCK TABLES `voca_contents` WRITE;
/*!40000 ALTER TABLE `voca_contents` DISABLE KEYS */;
/*!40000 ALTER TABLE `voca_contents` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-17 19:50:48
