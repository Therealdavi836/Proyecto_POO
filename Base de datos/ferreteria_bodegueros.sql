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
-- Table structure for table `bodegueros`
--

DROP TABLE IF EXISTS `bodegueros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bodegueros` (
  `cedula` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `fechanacimiento` varchar(45) DEFAULT NULL,
  `fechaingreso` varchar(45) DEFAULT NULL,
  `sueldo` int DEFAULT NULL,
  `contraseña` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bodegueros`
--

LOCK TABLES `bodegueros` WRITE;
/*!40000 ALTER TABLE `bodegueros` DISABLE KEYS */;
INSERT INTO `bodegueros` VALUES (2000,'andrea','lopez','cra 23k',3478562,'fua@gmail.com','01/01/2000','10/10/2000',100000,'2000'),(11405856,'Walter','Lopez','Calle45Ñ #99-12',35548962,'waltergamer45@gmail.com','07/04/2000','02/03/2022',100000,'waom2001+'),(105689041,'Erika','Patiño','Calle 32F #41-00',307890265,'erikjlop@gmail.com','25/06/1992','05/07/2023',100000,'erikmihij2006');
/*!40000 ALTER TABLE `bodegueros` ENABLE KEYS */;
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
