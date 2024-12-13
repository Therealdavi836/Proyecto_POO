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
-- Table structure for table `productoherraje`
--

DROP TABLE IF EXISTS `productoherraje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productoherraje` (
  `serial` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `material` varchar(45) DEFAULT NULL,
  `demanda` int DEFAULT NULL,
  `costoproduccion` float DEFAULT NULL,
  `costoalmacenamiento` float DEFAULT NULL,
  `costodeventa` float DEFAULT NULL,
  `bodegaid` int DEFAULT NULL,
  `tipoelemento` varchar(45) DEFAULT NULL,
  `imagen` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`serial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productoherraje`
--

LOCK TABLES `productoherraje` WRITE;
/*!40000 ALTER TABLE `productoherraje` DISABLE KEYS */;
INSERT INTO `productoherraje` VALUES (121,'Cilindros','Plateado','Platino','Metal',300,4000,900,24000,2,'f','img121.JPG'),(122,'Arandelas','Cobrizo','Bellota','Hierro',100,2000,800,9000,5,'f','img122.JPG'),(123,'Tornillos','Latón','Guij','Acero ',200,200,100,2000,4,'f','img123.JPG'),(124,'Bisagras','Negro','Induma','Cobre',10000,3000,900,12000,1,'f','img124.JPG'),(125,'Cerrojos','Dorado','Riduco','Titanio ',199,3000,2000,20000,3,'f','img125.JPG ');
/*!40000 ALTER TABLE `productoherraje` ENABLE KEYS */;
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
