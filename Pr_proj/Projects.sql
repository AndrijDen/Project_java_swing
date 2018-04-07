CREATE DATABASE  IF NOT EXISTS `projects` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `projects`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: projects
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `balance`
--

DROP TABLE IF EXISTS `balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `balance` (
  `idBalance` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Spending` decimal(15,2) NOT NULL,
  `Profit` decimal(15,2) NOT NULL,
  `Remainder` decimal(20,2) NOT NULL,
  PRIMARY KEY (`idBalance`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balance`
--

LOCK TABLES `balance` WRITE;
/*!40000 ALTER TABLE `balance` DISABLE KEYS */;
/*!40000 ALTER TABLE `balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `idDepartment` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `PhoneNum` varchar(45) NOT NULL,
  PRIMARY KEY (`idDepartment`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Business Solutions Development department','093232323234'),(2,'Banking Solutions Development department','0931104009'),(3,'Quality Assurance department','0974454697'),(4,'Design department','0965456102'),(5,'Management department','0938543207');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flow`
--

DROP TABLE IF EXISTS `flow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flow` (
  `idFlow` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Sum` decimal(20,2) NOT NULL,
  `Year` int(11) NOT NULL,
  `Month` int(11) NOT NULL,
  `idStaff` int(11) DEFAULT NULL,
  `idManager` int(11) DEFAULT NULL,
  `idWork` int(11) DEFAULT NULL,
  `idStage` int(11) DEFAULT NULL,
  `idBalance` int(11) DEFAULT NULL,
  `FlowType` int(11) NOT NULL,
  PRIMARY KEY (`idFlow`),
  KEY `Flow_idStaff_idx` (`idStaff`),
  KEY `Flow_idManager_idx` (`idManager`),
  KEY `Flow_idWork_idx` (`idWork`),
  KEY `Flow_idStage_idx` (`idStage`),
  KEY `Flow_idBalance_idx` (`idBalance`),
  CONSTRAINT `Flow_idBalance` FOREIGN KEY (`idBalance`) REFERENCES `balance` (`idBalance`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `Flow_idManager` FOREIGN KEY (`idManager`) REFERENCES `manager` (`idManager`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `Flow_idStaff` FOREIGN KEY (`idStaff`) REFERENCES `staff` (`idStaff`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `Flow_idStage` FOREIGN KEY (`idStage`) REFERENCES `stage` (`idStage`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `Flow_idWork` FOREIGN KEY (`idWork`) REFERENCES `work` (`idWork`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flow`
--

LOCK TABLES `flow` WRITE;
/*!40000 ALTER TABLE `flow` DISABLE KEYS */;
INSERT INTO `flow` VALUES (1,'2017-12-25',25000.00,2017,12,NULL,NULL,NULL,1,NULL,4),(2,'2017-12-28',25000.00,2017,12,NULL,NULL,NULL,1,NULL,4),(3,'2018-01-11',20000.00,2018,1,NULL,NULL,NULL,2,NULL,4),(4,'2018-02-24',20000.00,2018,2,NULL,NULL,NULL,3,NULL,4),(5,'2018-02-25',8000.00,2018,2,NULL,NULL,NULL,4,NULL,4),(6,'2018-02-26',3000.00,2018,2,NULL,NULL,NULL,4,NULL,4),(7,'2017-09-25',10000.00,2017,9,NULL,NULL,NULL,6,NULL,4),(8,'2017-09-29',20000.00,2017,9,NULL,NULL,NULL,7,NULL,4),(9,'2017-10-02',5000.00,2017,10,NULL,NULL,NULL,7,NULL,4),(10,'2017-10-11',10000.00,2017,10,NULL,NULL,NULL,8,NULL,4),(11,'2017-10-25',10000.00,2017,10,NULL,NULL,NULL,8,NULL,4),(12,'2017-10-05',20000.00,2017,10,NULL,NULL,NULL,9,NULL,4),(13,'2017-03-23',5000.00,2017,3,NULL,NULL,NULL,12,NULL,4),(14,'2017-04-25',2000.00,2017,4,NULL,NULL,NULL,13,NULL,4),(15,'2017-04-26',3000.00,2017,4,NULL,NULL,NULL,13,NULL,4),(16,'2017-03-12',500000.00,2017,3,7,NULL,NULL,NULL,NULL,2),(17,'2017-04-15',500000.00,2017,4,NULL,1,NULL,NULL,NULL,1),(18,'2016-05-25',250000.00,2016,5,6,NULL,NULL,NULL,NULL,2),(19,'2018-01-23',950700.00,2018,1,1,NULL,NULL,NULL,NULL,3),(20,'2018-04-06',630000.00,2018,4,1,NULL,NULL,NULL,NULL,2),(21,'2018-04-06',200400.00,2018,4,NULL,2,NULL,NULL,NULL,1),(22,'2018-05-24',700500.00,2018,5,2,NULL,NULL,NULL,NULL,3),(23,'2018-05-24',902400.00,2018,5,3,NULL,NULL,NULL,NULL,3),(24,'2018-05-24',908000.00,2018,5,4,NULL,NULL,NULL,NULL,3),(25,'2018-05-24',890000.00,2018,5,5,NULL,NULL,NULL,NULL,3),(26,'2018-05-24',330000.00,2018,5,2,NULL,NULL,NULL,NULL,2),(27,'2018-05-24',410000.00,2018,5,3,NULL,NULL,NULL,NULL,2),(28,'2018-05-24',570000.00,2018,5,4,NULL,NULL,NULL,NULL,2),(29,'2018-05-24',390000.00,2018,5,5,NULL,NULL,NULL,NULL,2),(30,'2018-05-24',700500.00,2018,5,NULL,3,NULL,NULL,NULL,1),(31,'2018-05-24',309000.00,2018,5,NULL,4,NULL,NULL,NULL,1),(32,'2018-05-24',800500.00,2018,5,NULL,5,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `flow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `idManager` int(11) NOT NULL AUTO_INCREMENT,
  `Beginning` date NOT NULL,
  `Ending` date DEFAULT NULL,
  `Pay` decimal(10,2) NOT NULL,
  `idStaff` int(11) DEFAULT NULL,
  `idProject` int(11) DEFAULT NULL,
  PRIMARY KEY (`idManager`),
  KEY `Manager_idStaff_idx` (`idStaff`),
  KEY `Manager_idProject_idx` (`idProject`),
  CONSTRAINT `Manager_idProject` FOREIGN KEY (`idProject`) REFERENCES `project` (`idProject`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `Manager_idStaff` FOREIGN KEY (`idStaff`) REFERENCES `staff` (`idStaff`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'2017-12-25','2018-03-21',1000.00,1,1),(2,'2018-02-25','2018-03-25',1000.00,2,2),(3,'2017-09-11','2017-11-01',1000.00,3,3),(4,'2017-10-05','2017-11-05',1000.00,4,4),(5,'2017-03-23','2017-05-11',1000.00,1,5);
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `idPosition` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(45) NOT NULL,
  `Beginning` varchar(45) NOT NULL,
  `Ending` varchar(45) DEFAULT NULL,
  `Pay` decimal(10,2) NOT NULL,
  `idDepartment` int(11) DEFAULT NULL,
  `idStaff` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPosition`),
  KEY `idDepartment_idx` (`idDepartment`),
  KEY `idStaff_idx` (`idStaff`),
  CONSTRAINT `Position_idDepartment` FOREIGN KEY (`idDepartment`) REFERENCES `department` (`idDepartment`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `Position_idStaff` FOREIGN KEY (`idStaff`) REFERENCES `staff` (`idStaff`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Project manager','2016-05-03','2017-09-18',5000.00,5,1),(2,'Architect','2016-05-03','2017-09-18',4000.00,5,2),(3,'Project manager','2016-05-03','2017-09-18',4000.00,5,3),(4,'Architect','2016-05-03','2017-09-18',4000.00,5,4),(5,'QA engineer','2016-05-03','2017-09-18',2000.00,3,5),(6,'UI/UX designer','2016-05-03','2017-09-18',1500.00,4,6),(7,'Senior developer','2016-05-03','2017-09-18',3000.00,1,7),(8,'Senior developer','2016-05-03','2017-09-18',3000.00,1,8),(9,'Senior developer','2016-05-03','2017-09-18',3000.00,2,9),(10,'Middle developer','2016-05-03','2017-09-18',2000.00,2,10),(11,'Junior developer','2016-05-03','2017-09-18',1000.00,2,11),(12,'test','2017-01-01','2018-01-01',10000.00,1,2);
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `idProject` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Client` varchar(45) NOT NULL,
  `Beginning` date NOT NULL,
  `EndingPlanned` date NOT NULL,
  `EndingFact` date DEFAULT NULL,
  `Cost` decimal(15,2) NOT NULL,
  `Spending` decimal(15,2) NOT NULL,
  `Rate` varchar(45) DEFAULT NULL,
  `idDepartment` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProject`),
  KEY `Project_idDepartment_idx` (`idDepartment`),
  CONSTRAINT `Project_idDepartment` FOREIGN KEY (`idDepartment`) REFERENCES `department` (`idDepartment`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'Rozetka mobile app','Rozetka','2017-12-25','2018-03-21','2018-03-21',90000.00,90000.00,'done',1),(2,'Scheduler','BBC Ukraine','2018-02-25','2018-05-25',NULL,25000.00,11000.00,'in progress',1),(3,'Oshchad official web site','Oshchad bank','2017-09-11','2017-11-01','2017-11-01',55000.00,55000.00,'done',2),(4,'Privat24 mobile app','Privat bank','2017-10-05','2018-01-24',NULL,70000.00,20000.00,'failed',2),(5,'Nova poshta rebranding','Nova poshta','2017-03-23','2017-05-11','2017-05-11',10000.00,5000.00,'done',4);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `idStaff` int(11) NOT NULL AUTO_INCREMENT,
  `Surname` varchar(45) NOT NULL,
  `Sex` varchar(10) NOT NULL,
  `BirthDate` date NOT NULL,
  PRIMARY KEY (`idStaff`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Brunets','male','1997-08-03'),(2,'Denysenko','male','1997-03-03'),(3,'Andreeva','female','1997-11-21'),(4,'Zacheshygryva','female','1997-11-11'),(5,'Ivanenko','male','1994-08-03'),(6,'Kostenko','male','1992-06-15'),(7,'Petrenko','female','1996-10-03'),(8,'Bolonna','famale','1997-06-13'),(9,'Biletska','female','1993-02-09'),(10,'Shevchenko','male','1986-01-01'),(11,'Jobs','male','1995-05-05');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stage`
--

DROP TABLE IF EXISTS `stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stage` (
  `idStage` int(11) NOT NULL AUTO_INCREMENT,
  `Number` int(11) NOT NULL,
  `Beginning` date NOT NULL,
  `EndingPlanned` date NOT NULL,
  `EndingFact` date DEFAULT NULL,
  `Cost` decimal(10,2) NOT NULL,
  `Spending` decimal(10,2) NOT NULL,
  `idProject` int(11) DEFAULT NULL,
  PRIMARY KEY (`idStage`),
  KEY `Stage_idProject_idx` (`idProject`),
  CONSTRAINT `Stage_idProject` FOREIGN KEY (`idProject`) REFERENCES `project` (`idProject`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stage`
--

LOCK TABLES `stage` WRITE;
/*!40000 ALTER TABLE `stage` DISABLE KEYS */;
INSERT INTO `stage` VALUES (1,1,'2017-12-25','2018-01-11','2018-01-11',50000.00,50000.00,1),(2,2,'2018-01-11','2018-02-24','2018-02-24',20000.00,20000.00,1),(3,3,'2018-02-24','2018-03-21','2018-03-21',20000.00,20000.00,1),(4,1,'2018-02-25','2018-03-25','2018-03-25',15000.00,11000.00,2),(5,2,'2018-03-25','2018-05-25',NULL,10000.00,0.00,2),(6,1,'2017-09-11','2017-09-29','2017-09-29',10000.00,10000.00,3),(7,2,'2017-09-29','2017-10-11','2017-10-11',25000.00,25000.00,3),(8,3,'2017-10-11','2017-11-01','2017-11-01',20000.00,20000.00,3),(9,1,'2017-10-05','2017-11-05','2017-11-05',20000.00,20000.00,4),(10,2,'2017-11-05','2017-12-05',NULL,40000.00,0.00,4),(11,3,'2017-12-05','2018-01-24',NULL,10000.00,0.00,4),(12,1,'2017-03-23','2017-04-23','2017-04-23',5000.00,5000.00,5),(13,2,'2017-04-23','2017-05-11','2017-05-11',5000.00,5000.00,5);
/*!40000 ALTER TABLE `stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work` (
  `idWork` int(11) NOT NULL AUTO_INCREMENT,
  `Beginning` date NOT NULL,
  `Ending` date DEFAULT NULL,
  `Description` varchar(400) NOT NULL,
  `idStage` int(11) DEFAULT NULL,
  `idStaff` int(11) DEFAULT NULL,
  PRIMARY KEY (`idWork`),
  KEY `Work_idStaff_idx` (`idStaff`),
  KEY `Work_idStage_idx` (`idStage`),
  CONSTRAINT `Work_idStaff` FOREIGN KEY (`idStaff`) REFERENCES `staff` (`idStaff`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `Work_idStage` FOREIGN KEY (`idStage`) REFERENCES `stage` (`idStage`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
INSERT INTO `work` VALUES (1,'2017-12-25','2018-01-11','creating working plan',1,1),(2,'2018-01-11','2018-02-24','share responsibilities between developers',2,1),(3,'2018-02-24','2018-03-21','project documentation',3,1),(4,'2017-03-23','2017-04-23','creating working plan',12,1),(5,'2017-04-23','2017-05-11','project documentation',13,1),(6,'2018-02-25','2018-03-25','creating working plan',4,2),(7,'2017-09-11','2017-09-29','creating working plan',6,3),(8,'2017-09-29','2017-10-11','refactoring the code',7,3),(9,'2017-10-11','2017-11-01','project documentation',8,3),(10,'2017-10-05','2017-11-05','creating working plan',9,4),(11,'2018-02-24','2018-03-21','testing the project',3,5),(12,'2017-10-11','2017-11-01','tesing API',8,5),(13,'2017-03-23','2017-04-23','making wareframes',12,6),(14,'2017-04-23','2017-05-11','making mockups',13,6),(15,'2017-12-25','2018-01-11','making initial architecture',1,7),(16,'2018-01-11','2018-02-24','backend development',2,7),(17,'2018-02-24','2018-03-21','code debugging',3,7),(18,'2017-12-25','2018-01-11','making initial architecture',1,8),(19,'2018-01-11','2018-02-24','frontend development',2,8),(20,'2018-02-24','2018-03-21','binding frontend with API',3,8),(21,'2018-02-25','2018-03-25','making initial architecture',4,7),(22,'2018-02-25','2018-03-25','making initial stubs',4,8),(23,'2017-09-11','2017-09-29','making initial architecture',6,9),(24,'2017-09-29','2017-10-11','API development',7,9),(25,'2017-10-11','2017-11-01','debugging',8,9),(26,'2017-10-05','2017-11-05','making stubs',9,9),(27,'2017-09-11','2017-09-29','making stubs',6,10),(28,'2017-09-29','2017-10-11','frontend development',7,10),(29,'2017-10-11','2017-11-01','binding with API',8,10),(30,'2017-10-05','2017-11-05','making initial architecture',9,10),(31,'2017-09-29','2017-10-11','API development',7,11),(32,'2017-10-11','2017-11-01','debugging',8,11);
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-05 21:56:02
