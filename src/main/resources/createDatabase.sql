-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: justgetit
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `categorieen`
--

DROP TABLE IF EXISTS `categorieen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorieen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(45) NOT NULL,
  `parentId` int(11) DEFAULT NULL,
  `isSubcategorie` tinyint(4) NOT NULL,
  `winstmargeIsPercentage` tinyint(4) NOT NULL DEFAULT '1',
  `winstmarge` decimal(12,2) NOT NULL DEFAULT '10.00',
  PRIMARY KEY (`id`),
  KEY `CategorieSubCategorie` (`parentId`),
  CONSTRAINT `CategorieSubCategorie` FOREIGN KEY (`parentId`) REFERENCES `categorieen` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorieen`
--

LOCK TABLES `categorieen` WRITE;
/*!40000 ALTER TABLE `categorieen` DISABLE KEYS */;
INSERT INTO `categorieen` VALUES (4,'boeken',NULL,0,1,10.00),(5,'CD\'s',NULL,0,1,10.00),(6,'elektronische toestellen',NULL,0,1,10.00),(7,'kleding',NULL,0,1,10.00),(79,'testParent2',NULL,1,1,10.00);
/*!40000 ALTER TABLE `categorieen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producten`
--

DROP TABLE IF EXISTS `producten`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(45) NOT NULL,
  `aankoopprijs` decimal(12,2) NOT NULL,
  `verkoopprijs` decimal(12,2) NOT NULL,
  `categorie` int(11) DEFAULT NULL,
  `voorraad` int(11) DEFAULT NULL,
  `minimaleBestelhoeveelheid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `naam_UNIQUE` (`naam`),
  KEY `productCategorie_idx` (`categorie`),
  CONSTRAINT `productCategorie` FOREIGN KEY (`categorie`) REFERENCES `categorieen` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producten`
--

LOCK TABLES `producten` WRITE;
/*!40000 ALTER TABLE `producten` DISABLE KEYS */;
/*!40000 ALTER TABLE `producten` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `naam` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `wachtwoord` varchar(45) NOT NULL,
  `isManager` tinyint(4) NOT NULL DEFAULT '0',
  `isBediende` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'manager','manager','manager',0,1),(2,'bediende','bediende','bediende',0,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-11 11:11:44
