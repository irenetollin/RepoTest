CREATE DATABASE processes;
USE  processes;
DROP TABLE IF EXISTS `execution_processes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `execution_processes` (
  `ID` int NOT NULL,
  `Process_ID` int DEFAULT NULL,
  `Execution_Date` datetime DEFAULT NULL,
  `Execution_Status` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `execution_processes`
--

LOCK TABLES `execution_processes` WRITE;
/*!40000 ALTER TABLE `execution_processes` DISABLE KEYS */;
INSERT INTO `execution_processes` VALUES (1,1,'2020-06-07 17:00:00','Completed'),(2,1,'2020-05-31 17:00:00','Completed with Error'),(3,2,'2020-05-07 17:30:00','Completed'),(4,1,'2020-05-24 17:00:00','Completed'),(5,1,'2020-06-06 17:00:00','Completed'),(6,1,'2020-06-05 17:00:00','Completed with Error'),(7,1,'2020-06-04 17:00:00','Not Started'),(8,1,'2020-06-03 17:00:00','Completed'),(9,1,'2020-06-02 17:00:00','Completed'),(10,1,'2020-06-01 17:00:00','Completed'),(11,1,'2020-05-30 17:00:00','Completed with Error'),(12,1,'2020-05-29 17:00:00','Completed'),(13,1,'2020-05-28 17:00:00','Completed'),(14,1,'2020-05-25 17:00:00','Completed'),(15,1,'2020-05-26 17:00:00','Completed'),(16,1,'2020-05-27 17:00:00','Completed With Error'),(17,2,'2020-06-07 17:30:00','Completed'),(18,3,'2020-01-01 08:00:00','Completed'),(19,3,'2020-02-01 08:00:00','Completed'),(20,3,'2020-03-01 08:00:00','Completed'),(21,3,'2020-04-01 08:00:00','Completed With Error'),(22,3,'2020-05-01 08:00:00','Completed'),(23,3,'2020-06-01 08:00:00','Completed'),(24,4,'2020-01-01 08:00:00','Completed'),(25,4,'2020-04-01 00:00:00','Completed With Error');
/*!40000 ALTER TABLE `execution_processes` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `processes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `processes` (
  `ProcessName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Description` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Periodicity` int DEFAULT NULL,
  `Time_to_process` time DEFAULT NULL,
  `ID` int NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processes`
--

LOCK TABLES `processes` WRITE;
/*!40000 ALTER TABLE `processes` DISABLE KEYS */;
INSERT INTO `processes` VALUES ('Send Transfer','Closing time for sending credit transfers',1,'17:00:00',1),('Financing Payment','Automatic Financing Payment',3,'17:30:00',2),('Send Monthly Report','Automatic Send of Monthly Report',3,'08:00:00',3),('Send Quarterly report','Automatic Send of Quartetly Report',4,'08:00:00',4),('Send Annual Report','Automatic Send of Annual Report',5,'08:00:00',5);
/*!40000 ALTER TABLE `processes` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `periodicity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodicity` (
  `idPeriodicity` int NOT NULL,
  `Periodicity` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idPeriodicity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodicity`
--

LOCK TABLES `periodicity` WRITE;
/*!40000 ALTER TABLE `periodicity` DISABLE KEYS */;
INSERT INTO `periodicity` VALUES (1,'Every Day'),(2,'Every Week'),(3,'Every Month'),(4,'Every Quarter'),(5,'Annual');

UNLOCK TABLES;