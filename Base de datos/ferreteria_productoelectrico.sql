-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: ferreteria
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `productoelectrico`
--

DROP TABLE IF EXISTS `productoelectrico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoelectrico` (
  `serial` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `material` varchar(45) DEFAULT NULL,
  `bodegaid` int DEFAULT NULL,
  `demanda` int DEFAULT NULL,
  `costoproduccion` float DEFAULT NULL,
  `costodeventa` float DEFAULT NULL,
  `costoalmacenamiento` float DEFAULT NULL,
  `capacidaddecarga` float DEFAULT NULL,
  `calibre` float DEFAULT NULL,
  `imagen` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`serial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productoelectrico`
--

LOCK TABLES `productoelectrico` WRITE;
/*!40000 ALTER TABLE `productoelectrico` DISABLE KEYS */;
INSERT INTO `productoelectrico` VALUES (221,'Bombilla','Blanco','Philiphs','Vidrio',5,2000,5000,12000,800,45,27,'img221.JPG'),(222,'Interruptor','Plateado','Riduco','Porcelana',1,1000,400,3500,600,24,32,'img222.JPG'),(223,'Regulador','Negro','Induma','Metal',3,500,30000,95000,20000,120,65,'img223.JPG'),(224,'Transformador','Plateado','Siemens','Hierro',2,10,300000,1200000,120000,1200,260,'img224.JPG'),(225,'Termostato','Blanco','Mabe','Policarbono',4,200,40000,160000,9000,48,18,'img225.JPG');
/*!40000 ALTER TABLE `productoelectrico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-08 18:03:03
