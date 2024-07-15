-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: personalpage
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `colorschemes`
--

DROP TABLE IF EXISTS `colorschemes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `colorschemes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `color1` varchar(10) DEFAULT NULL,
  `color2` varchar(10) DEFAULT NULL,
  `color3` varchar(10) DEFAULT NULL,
  `color4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colorschemes`
--

LOCK TABLES `colorschemes` WRITE;
/*!40000 ALTER TABLE `colorschemes` DISABLE KEYS */;
INSERT INTO `colorschemes` VALUES (1,'#e3fdfd','#cbf1f5','#a6e3e9','#71c9ce'),(2,'#f9f7f7','#dbe2ef','#3f72af','#112d4e'),(3,'#d4a5a5','#ffecda','#f9ffea','#a6d0e4'),(4,'#f5eee6','#f3d7ca','#e6a4b4','#c86b85'),(5,'#99e1e5','#f3e8cb','#f2c6b4','#fbafaf'),(6,'#f9f2f2','#f0e1e1','#ecd1d1','#785a5a'),(7,'#FFFBE9','#E3CAA5','##CEAB93','#AD8B73'),(8,'#fbe6e6','#daafd1','#a989c6','#756ab6'),(9,'#e2f5f7','#c5d9e5','#4e689f','#43577d'),(10,'#B5C0D0','#CCD3CA','#F5E8DD','#EED3D9');
/*!40000 ALTER TABLE `colorschemes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `font`
--

DROP TABLE IF EXISTS `font`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `font` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `font`
--

LOCK TABLES `font` WRITE;
/*!40000 ALTER TABLE `font` DISABLE KEYS */;
INSERT INTO `font` VALUES (1,'serif'),(2,'Times New Roman'),(3,'Comic Sans MS'),(4,'Courier New');
/*!40000 ALTER TABLE `font` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `biography` text,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `linkedin` varchar(255) DEFAULT NULL,
  `github` varchar(255) DEFAULT NULL,
  `color_scheme_id` int DEFAULT NULL,
  `font` int DEFAULT NULL,
  `font_size` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_color_scheme` (`color_scheme_id`),
  CONSTRAINT `fk_color_scheme` FOREIGN KEY (`color_scheme_id`) REFERENCES `colorschemes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (4,'22','dgsrr','etbetab','34524','efbetb','ebett','ebetbetb',1,1,17),(5,'22','svsvrr','etbetab','34524','efbetb','ebett','ebetbetb',1,1,17),(6,'452','svfsf','etbetab','34524','efbetb','ebett','ebetbetb',2,1,17),(7,'5875','hyxfm','etbetab','34524','efbetb','ebett','ebetbetb',1,1,17),(8,'5875','dbege','etbetab','34524','efbetb','ebett','ebetbetb',1,1,16),(9,'5875','beteb','etbetab','34524','efbetb','ebett','ebetbetb',1,1,1),(10,'5875','bdst','etbetab','34524','efbetb','ebett','ebetbetb',1,1,1),(11,'5875','fyjfyj','etbetab','34524','efbetb','ebett','ebetbetb',1,1,16),(12,'5875','dvad','etbetab','34524','efbetb','ebett','ebetbetb',1,1,1),(13,'5875','kyvyk','etbetab','34524','efbetb','ebett','ebetbetb',1,2,17),(14,'5875','bgeb','etbetab','34524','efbetb','ebett','ebetbetb',1,1,132),(15,'5875','fmyjd','etbetab','34524','efbetb','ebett','ebetbetb',1,1,12),(16,'5875','xsaca','etbetab','34524','efbetb','ebett','ebetbetb',1,2,12),(17,'5875','rbrbb','etbetab','34524','efbetb','ebett','ebetbetb',1,1,2),(18,'5875','dvva','etbetab','34524','efbetb','ebett','ebetbetb',1,1,12),(19,'5875','sbfs','etbetab','34524','efbetb','ebett','ebetbetb',1,1,12),(20,'5875','rbryn','etbetab','34524','efbetb','ebett','ebetbetb',1,1,2),(21,'3333333','rbryn','etbetab','34524','efbetb','ebett','ebetbetb',1,1,2),(22,'5875','evtb','etbetab','34524','efbetb','ebett','ebetbetb',1,1,12),(23,'5875','evtb','etbetab','34524','efbetb','ebett','ebetbetb',1,1,12),(24,'66666','svsfvs','etbetab','34524','efbetb','ebett','ebetbetb',1,1,12),(25,'77777','dfsfvsfb','etbetab','34524','efbetb','ebett','ebetbetb',1,1,12),(26,'77777','advadv','etbetab','34524','efbetb','ebett','ebetbetb',1,1,12),(27,'77777','advadva','etbetab','34524','efbetb','ebett','ebetbetb',1,1,12),(28,'888','ebebebt','etbetab','34524','efbetb','ebett','ebetbetb',1,1,2),(29,'888','ebebebt','etbetab','34524','efbetb','ebett','ebetbetb',1,1,2),(30,'888','fbfb','etbetab','34524','efbetb','ebett','ebetbetb',1,2,12),(31,'888','fbfb','etbetab','34524','efbetb','ebett','ebetbetb',1,2,12),(32,'888','eth4th4','etbetab','34524','efbetb','ebett','ebetbetb',1,1,12),(33,'888','dvadv','etbetab','34524','efbetb','ebett','ebetbetb',1,1,1),(34,'888','fyjdfyj','etbetab','34524','efbetb','ebett','ebetbetb',1,1,12),(35,'jingqi','Hi, i am jingqi. ','jingqi_fan@163.com','+17741553618','Northeastern University (China)','jingqi-fan.linkedin','jingqi-fan.github',3,2,17),(36,'trheth','ehtetheth','ethetheth','ethetheth','ethetheth','ethethet','ethetheth',1,1,1),(37,'trheth','swrgwrg','ethetheth','ethetheth','ethetheth','ethethet','ethetheth',1,1,12),(38,'trheth','hnteyn','ethetheth','ethetheth','ethetheth','ethethet','ethetheth',1,1,12),(39,'trheth','dgbeg','ethetheth','ethetheth','ethetheth','ethethet','ethetheth',2,1,15),(40,'trheth','fvebe','ethetheth','ethetheth','ethetheth','ethethet','ethetheth',4,3,12),(41,'trheth','sfbsfb','ethetheth','ethetheth','ethetheth','ethethet','ethetheth',5,3,12),(42,'trheth','ujtukkl','ethetheth','ethetheth','ethetheth','ethethet','ethetheth',10,4,12),(43,'trheth','rwryhry','ethetheth','ethetheth','ethetheth','ethethet','ethetheth',9,2,12),(44,'trheth','vebebt','ethetheth','ethetheth','ethetheth','ethethet','ethetheth',4,3,12),(45,'trheth','hmrymry','ethetheth','ethetheth','ethetheth','ethethet','ethetheth',1,3,12),(46,'trheth','ethetheth','ethetheth','ethetheth','ethetheth','ethethet','ethetheth',8,2,18),(47,'mjx','hh','123','110','6','mjx','111',5,3,20),(48,'Jingqi Fan','Hi, I am Jingqi, an undergraduate student at Northeastern University. I major in software engineering. I really love coding. Every time I write code, it is like that I am building my dream. I also do well in swimming.','jingqi_fan@163.com','+17741553618','Hunnan, Shenyang','https://www.linkedin.com/in/jingqi-fan/','https://github.com/jingqi-fan',8,3,18),(49,'Jingqi Fan','Hi, I am Jingqi, an undergraduate student at Northeastern University. I major in software engineering. I really love coding. Every time I write code, it is like that I am building my dream. I also do well in swimming.','jingqi_fan@163.com','+17741553618','Hunnan, Shenyang','https://www.linkedin.com/in/jingqi-fan/','https://github.com/jingqi-fan',4,3,18);
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectcollaborators`
--

DROP TABLE IF EXISTS `projectcollaborators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projectcollaborators` (
  `projectId` int DEFAULT NULL,
  `collaborator` varchar(255) DEFAULT NULL,
  KEY `projectId` (`projectId`),
  CONSTRAINT `projectcollaborators_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectcollaborators`
--

LOCK TABLES `projectcollaborators` WRITE;
/*!40000 ALTER TABLE `projectcollaborators` DISABLE KEYS */;
INSERT INTO `projectcollaborators` VALUES (16,'b'),(17,'b'),(18,'b'),(19,'b'),(20,'b'),(21,'b'),(22,'b'),(23,'5555'),(24,'b'),(25,'b'),(26,'tmmymu'),(27,'tmmymu'),(28,'b'),(29,'b'),(29,'b'),(29,'b'),(29,'b'),(30,'1'),(31,'2'),(32,'1'),(33,'2'),(34,'1'),(35,'2'),(36,'1'),(37,'2'),(38,'1'),(39,'2'),(40,'jingqi'),(40,'jq'),(41,'nitin'),(41,'jq'),(42,'ethet'),(43,'etheh'),(44,'1'),(45,'2'),(46,'1'),(47,'2'),(48,'1'),(49,'2'),(50,'1'),(51,'2'),(52,'1'),(53,'2'),(54,'1'),(55,'2'),(56,'1'),(57,'2'),(58,'1'),(59,'2'),(60,'1'),(60,'f'),(60,'q'),(61,'2'),(61,'t'),(61,'2'),(62,'1'),(62,'f'),(62,'q'),(63,'2'),(63,'t'),(63,'2'),(64,'ethet'),(65,'etheh'),(66,'Zilong Wang'),(66,'Shuai Li'),(67,'Haochen Zhou'),(67,'Huajia Li'),(67,'Miao Wang'),(68,'Zilong Wang'),(69,'Haochen Zhou');
/*!40000 ALTER TABLE `projectcollaborators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectkeywords`
--

DROP TABLE IF EXISTS `projectkeywords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projectkeywords` (
  `projectId` int DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  KEY `projectId` (`projectId`),
  CONSTRAINT `projectkeywords_ibfk_1` FOREIGN KEY (`projectId`) REFERENCES `projects` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectkeywords`
--

LOCK TABLES `projectkeywords` WRITE;
/*!40000 ALTER TABLE `projectkeywords` DISABLE KEYS */;
INSERT INTO `projectkeywords` VALUES (16,'b'),(17,'b'),(18,'b'),(19,'b'),(20,'b'),(21,'b'),(22,'b'),(23,'4444'),(24,'b'),(25,'b'),(26,'tnt'),(27,'tnt'),(28,'b'),(29,'b'),(29,'a'),(29,'c'),(30,'1'),(31,'2'),(32,'1'),(33,'2'),(34,'1'),(35,'2'),(36,'1'),(37,'2'),(38,'1'),(39,'2'),(40,'personal page'),(40,'web app'),(41,'database'),(41,'sql'),(42,'ethethe'),(43,'ethet'),(44,'1'),(45,'2'),(46,'1'),(47,'2'),(48,'1'),(49,'2'),(50,'1'),(51,'2'),(52,'1'),(53,'2'),(54,'1'),(55,'2'),(56,'1'),(57,'2'),(58,'1'),(59,'2'),(60,'1'),(60,'2'),(60,'3'),(61,'2'),(61,'3'),(61,'f'),(62,'1'),(62,'2'),(62,'3'),(63,'2'),(63,'3'),(63,'f'),(64,'ethethe'),(65,'ethet'),(66,'reinforcement learning'),(66,'bandits'),(66,'decision-making problem'),(67,'fitness'),(67,'business plan'),(68,'reinforcement learning'),(69,'business plan');
/*!40000 ALTER TABLE `projectkeywords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `summary` text,
  `type` varchar(100) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `profile_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_profile` (`profile_id`),
  CONSTRAINT `fk_profile` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (5,NULL,NULL,NULL,NULL,4),(6,NULL,NULL,NULL,NULL,5),(7,NULL,NULL,NULL,NULL,6),(8,NULL,NULL,NULL,NULL,7),(9,NULL,NULL,NULL,NULL,8),(10,NULL,NULL,NULL,NULL,9),(11,NULL,NULL,NULL,NULL,10),(12,NULL,NULL,NULL,NULL,11),(14,NULL,NULL,NULL,NULL,12),(15,NULL,NULL,NULL,NULL,13),(16,'b','dbgee','b','b',14),(17,'b','mfym','b','b',15),(18,'b','dbdf','b','b',16),(19,'b','rnrhr','b','b',17),(20,'b','sdvsdv','b','b',18),(21,'b','sfbsfs','b','b',19),(22,'b','brngb','b','b',20),(23,'b','brngb','b','b',21),(24,'b','fvebebt','b','b',22),(25,'b','fvebebt','b','b',23),(26,'66666','htevsfvfb','mnyjmy','tnrtmr',24),(27,'7a','bdebee','mnyjmy','tnrtmr',25),(28,'b','advav','b','b',26),(29,'b','advadvad','b','b',27),(30,'1','1','1','1',28),(31,'2','2','2','2',29),(32,'1','sfsfbs','1','1',30),(33,'2','sbfsb','2','2',31),(34,'1','rhrnr','1','1',32),(35,'2','rnrynr','2','2',32),(36,'1','dvdvs','1','1',33),(37,'2','svsvsd','2','2',33),(38,'1','dhdh','1','1',34),(39,'2','dddyj','2','2',34),(40,'Web Design','This is a great work!','web application','none',35),(41,'Database Project','This is a interesting project.','coding','none',35),(42,'hethet','eeteth','etethet','etheth',36),(43,'etheth','etheth','etheth','etheth',36),(44,'1','gwrgw','1','1',37),(45,'2','rgwrg','2','2',37),(46,'1','rynwryn','1','1',38),(47,'2','nrynryw','2','2',38),(48,'1','bee','1','1',39),(49,'2','ebt','2','2',39),(50,'1','efbeb','1','1',40),(51,'2','ebetbet','2','2',40),(52,'1','svsfbsf','1','1',41),(53,'2','sfbsfbs','2','2',41),(54,'1','brgwrb','1','1',42),(55,'2','rgrwnn','2','2',42),(56,'1','rbw','1','1',43),(57,'2','rwrn','2','2',43),(58,'1','vwrbeb','1','1',44),(59,'2','ebeeb','2','2',44),(60,'1','dnndg','1','1',45),(61,'2','gnfhmfm','2','2',45),(62,'1','dbge','1','1',46),(63,'2','ebgeete','2','2',46),(64,'hethet','nsdd','etethet','etheth',47),(65,'etheth','nsdd','etheth','etheth',47),(66,'Multi-armed Bandits with Delayed Feedback','With the increasing severity of hypertension worldwide, traditional blood pressure monitoring and management methods have gradually shown their limitations. In view of the shortcomings of the existing technology, we propose a new type of intelligent integration platform. The platform integrates the latest artificial intelligence, machine learning, image recognition and big data technology, which can realize the real-time collection, accurate analysis and effective management of blood pressure data. This slide not only discusses the technical implementation and market application of the platform, but also evaluates the potential risks and development prospects, which provides new ideas and solutions for the future health management field.','Research','none',48),(67,'Fitness Everyone: National Fitness Companion','With the improvement of public health awareness, fitness has become an important part of modern life. In response to this demand, FitnessE application came into being, aiming to provide a multifunctional platform to support users to carry out fitness activities at any time and any place. The application uses advanced artificial intelligence technology to provide users with personalized fitness plans, including video tutorials, real-time feedback, health data tracking and other functions. In addition, the app also has built-in social features, users can invite friends to participate in the challenge, increase the interaction and fun of fitness. In this way, FitnessE not only helps users to get fit scientifically, but also creates a positive and healthy community environment.','Industrial work','none',48),(68,'Multi-armed Bandits with Delayed Feedback','With the increasing severity of hypertension worldwide, traditional blood pressure monitoring and management methods have gradually shown their limitations. In view of the shortcomings of the existing technology, we propose a new type of intelligent integration platform. The platform integrates the latest artificial intelligence, machine learning, image recognition and big data technology, which can realize the real-time collection, accurate analysis and effective management of blood pressure data. This slide not only discusses the technical implementation and market application of the platform, but also evaluates the potential risks and development prospects, which provides new ideas and solutions for the future health management field.','Research','none',49),(69,'Fitness Everyone: National Fitness Companion','With the improvement of public health awareness, fitness has become an important part of modern life. In response to this demand, FitnessE application came into being, aiming to provide a multifunctional platform to support users to carry out fitness activities at any time and any place. The application uses advanced artificial intelligence technology to provide users with personalized fitness plans, including video tutorials, real-time feedback, health data tracking and other functions. In addition, the app also has built-in social features, users can invite friends to participate in the challenge, increase the interaction and fun of fitness. In this way, FitnessE not only helps users to get fit scientifically, but also creates a positive and healthy community environment.','Industrial work','none',49);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'a','a','a'),(2,'jingqi','jingqi','jingqi_fan@163.com'),(3,'qwe','qwe','qwe');
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

-- Dump completed on 2024-07-12 22:36:28
