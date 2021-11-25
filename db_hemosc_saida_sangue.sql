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
-- Table structure for table `saida_sangue`
--

DROP TABLE IF EXISTS `saida_sangue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saida_sangue` (
  `id_saida_sangue` int NOT NULL AUTO_INCREMENT,
  `id_entidade` int NOT NULL,
  `id_tipo_sanguineo` int NOT NULL,
  `data` datetime DEFAULT NULL,
  `quantidade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_saida_sangue`),
  KEY `fk_saida_sangue_tipos_sanguineos1_idx` (`id_tipo_sanguineo`),
  KEY `fk_saida_sangue_entidades1_idx` (`id_entidade`),
  CONSTRAINT `fk_saida_sangue_entidades1` FOREIGN KEY (`id_entidade`) REFERENCES `entidades` (`id_entidade`),
  CONSTRAINT `fk_saida_sangue_tipos_sanguineos1` FOREIGN KEY (`id_tipo_sanguineo`) REFERENCES `tipos_sanguineos` (`id_tipo_sanguineo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saida_sangue`
--

LOCK TABLES `saida_sangue` WRITE;
/*!40000 ALTER TABLE `saida_sangue` DISABLE KEYS */;
INSERT INTO `saida_sangue` VALUES (1,1,1,'2000-10-12 00:00:00','100'),(2,2,2,'2013-12-03 00:00:00','200'),(3,3,3,'2019-06-29 00:00:00','50'),(4,4,4,'2021-04-25 00:00:00','30');
/*!40000 ALTER TABLE `saida_sangue` ENABLE KEYS */;
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
