-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_hemosc
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `doacoes`
--

DROP TABLE IF EXISTS `doacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doacoes` (
  `id_doacao` int NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `id_doador` int NOT NULL,
  `id_tipo_sanguineo` int NOT NULL,
  `id_colaborador` int NOT NULL,
  PRIMARY KEY (`id_doacao`),
  KEY `fk_doacoes_doadores1_idx` (`id_doador`),
  KEY `fk_doacoes_tipos_sanguineos1_idx` (`id_tipo_sanguineo`),
  KEY `fk_doacoes_colaboradores1_idx` (`id_colaborador`),
  CONSTRAINT `fk_doacoes_colaboradores1` FOREIGN KEY (`id_colaborador`) REFERENCES `colaboradores` (`id_colaborador`),
  CONSTRAINT `fk_doacoes_doadores1` FOREIGN KEY (`id_doador`) REFERENCES `doadores` (`id_doador`),
  CONSTRAINT `fk_doacoes_tipos_sanguineos1` FOREIGN KEY (`id_tipo_sanguineo`) REFERENCES `tipos_sanguineos` (`id_tipo_sanguineo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doacoes`
--

LOCK TABLES `doacoes` WRITE;
/*!40000 ALTER TABLE `doacoes` DISABLE KEYS */;
INSERT INTO `doacoes` VALUES (1,'2000-10-20',1,1,1),(2,'2001-11-21',2,2,2),(3,'2002-12-22',3,3,3),(4,'2003-09-23',4,4,4),(5,'2004-08-24',2,2,5);
/*!40000 ALTER TABLE `doacoes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-25 13:50:35
