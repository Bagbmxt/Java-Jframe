-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: cad
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `projotapedido`
--

DROP TABLE IF EXISTS `projotapedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projotapedido` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numero_pedido` int DEFAULT NULL,
  `valor_total` double DEFAULT NULL,
  `numero_itens` double DEFAULT NULL,
  `pago` tinyint(1) DEFAULT NULL,
  `vendedor` varchar(50) DEFAULT NULL,
  `comprador` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projotapedido`
--

LOCK TABLES `projotapedido` WRITE;
/*!40000 ALTER TABLE `projotapedido` DISABLE KEYS */;
INSERT INTO `projotapedido` VALUES (1,1,2500,3,1,'carlos','adao'),(2,0,0,0,1,NULL,NULL),(3,1,2500,3,1,'carlos','adao'),(4,1,2500,3,1,'carlos','adao'),(5,0,0,0,0,NULL,NULL),(6,1,2500,3,1,'carlos','adao'),(7,0,0,0,1,NULL,NULL),(8,1,2500,3,1,'carlos','adao'),(9,1,2500,3,1,'carlos','adao'),(10,1,2500,3,1,'carlos','adao'),(11,1,2500,3,1,'carlos','adao'),(12,1,2500,3,1,'carlos','adao'),(13,1,2500,3,1,'carlos','adao'),(14,0,0,0,1,NULL,NULL),(15,1,2500,3,1,'carlos','adao'),(16,0,0,0,1,NULL,NULL),(17,0,0,0,1,NULL,NULL),(18,0,0,0,1,NULL,NULL),(19,0,0,0,1,NULL,NULL),(20,0,0,0,0,NULL,NULL),(21,0,0,0,0,NULL,NULL);
/*!40000 ALTER TABLE `projotapedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-16 23:33:06
