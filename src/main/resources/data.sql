-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: uptake
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe54x81nmccsk5569hsjg1a6ka` (`country_id`),
  CONSTRAINT `FKe54x81nmccsk5569hsjg1a6ka` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Fairfield','Iowa','52556',1),(2,'Fairfield','Iowa','52554',1),(3,'Fairfield','Iowa','52557',1),(4,'Fairfield','Iowa','52553',1),(5,'Fairfield','Iowa','52553',1),(25,'Ulaanbaatar','Tuv province','16100',2),(26,'Ulaanbaatar','Tuv province','16100',2),(27,'Ulaanbaatar','Tuv province','16100',1),(28,'Ulaanbaatar','Tuv province','16100',1),(29,'Ulaanbaatar','Tuv province','16100',1),(31,'Ulaanbaatar','Tuv province','16100',2),(32,'Ulaanbaatar','Tuv province','16100',2),(33,'Ulaanbaatar','Tuv province','16100',2),(34,'Fairfield','IOWA','52557',2),(35,NULL,NULL,NULL,1),(36,NULL,NULL,NULL,1),(37,'Fairfield','IOWA','52557',1),(38,NULL,NULL,NULL,1),(39,NULL,NULL,NULL,1),(40,NULL,NULL,NULL,1),(41,NULL,NULL,NULL,1),(42,NULL,NULL,NULL,1),(43,'','','',1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ads`
--

DROP TABLE IF EXISTS `ads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ads` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `advertisement_url` varchar(255) DEFAULT NULL,
  `created` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `target_age_max` int(11) NOT NULL,
  `target_age_min` int(11) NOT NULL,
  `target_gender` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `photo_id` bigint(20) DEFAULT NULL,
  `target_country_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi2ajkc2o0lpxddqwl24tecucx` (`photo_id`),
  KEY `FK6g9i35d0a5cmd70v1ctfg59ce` (`target_country_id`),
  KEY `FKnh2ec7osfjpf2rpuv552gnu1` (`user_id`),
  CONSTRAINT `FK6g9i35d0a5cmd70v1ctfg59ce` FOREIGN KEY (`target_country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `FKi2ajkc2o0lpxddqwl24tecucx` FOREIGN KEY (`photo_id`) REFERENCES `photo` (`id`),
  CONSTRAINT `FKnh2ec7osfjpf2rpuv552gnu1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ads`
--

LOCK TABLES `ads` WRITE;
/*!40000 ALTER TABLE `ads` DISABLE KEYS */;
INSERT INTO `ads` VALUES (1,'https://www.discovermongolia.mn/',NULL,'Do you crave a one-off kind adventure? Do you want to escape the tourist trail and truly get off the beaten track? ',1,35,15,1,'X-max sale',57,1,1),(2,'https://www.discovermongolia.mn/',NULL,'Authentic and Unforgettable',1,70,50,0,'Discover Mongolia',58,1,1),(3,'https://www.discovermongolia.mn/',NULL,'Description',1,100,1,2,'test projected',81,2,1);
/*!40000 ALTER TABLE `ads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs1slvnkuemjsq2kj4h3vhx7i1` (`post_id`),
  KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKs1slvnkuemjsq2kj4h3vhx7i1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'2019-12-12','Cooment 1',1,3),(2,'2019-12-12','Cooment 1',1,3),(3,'2019-12-12','Cooment 1',1,3),(4,'2019-12-12','Love this place.',1,3),(5,'2019-12-12','Wanna go there',1,4),(6,'2019-12-12','It\'s epic',1,4),(7,'2019-12-12','So cool',1,2),(8,'2019-12-12','Isn\'t it the wonderful place',1,3);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'USA'),(2,'Mongolia');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follower`
--

DROP TABLE IF EXISTS `follower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follower` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `followed_user_id` bigint(20) DEFAULT NULL,
  `following_user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK327xwf2s2pc1tuqw3y9ve2gej` (`followed_user_id`),
  KEY `FK62bta77uvhi6ys0akwblaog14` (`following_user_id`),
  CONSTRAINT `FK327xwf2s2pc1tuqw3y9ve2gej` FOREIGN KEY (`followed_user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK62bta77uvhi6ys0akwblaog14` FOREIGN KEY (`following_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follower`
--

LOCK TABLES `follower` WRITE;
/*!40000 ALTER TABLE `follower` DISABLE KEYS */;
INSERT INTO `follower` VALUES (1,2,4),(2,4,4),(3,5,2),(4,1,4),(29,2,3),(30,5,3),(31,8,3),(32,8,1),(33,5,10),(34,2,9),(35,9,10),(36,9,6),(37,11,10),(45,3,12),(50,4,17),(51,16,17),(52,15,17),(56,15,16),(57,13,17);
/*!40000 ALTER TABLE `follower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (33);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `likes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` date DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKowd6f4s7x9f3w50pvlo6x3b41` (`post_id`),
  KEY `FKi2wo4dyk4rok7v4kak8sgkwx0` (`user_id`),
  CONSTRAINT `FKi2wo4dyk4rok7v4kak8sgkwx0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKowd6f4s7x9f3w50pvlo6x3b41` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (1,NULL,1,3),(13,NULL,2,3),(14,NULL,3,3),(15,NULL,4,3),(16,NULL,6,3),(17,NULL,12,3),(18,NULL,13,3),(19,NULL,10,3),(20,NULL,11,3),(21,NULL,18,3),(22,NULL,23,3),(23,NULL,31,3),(24,NULL,32,3);
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification_user`
--

DROP TABLE IF EXISTS `notification_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification_user` (
  `id` bigint(20) NOT NULL,
  `destination_user_email` varchar(255) DEFAULT NULL,
  `has_seen` bit(1) DEFAULT NULL,
  `message_code` varchar(255) DEFAULT NULL,
  `post_id` varchar(255) DEFAULT NULL,
  `profile_photo_path` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification_user`
--

LOCK TABLES `notification_user` WRITE;
/*!40000 ALTER TABLE `notification_user` DISABLE KEYS */;
INSERT INTO `notification_user` VALUES (1,'tuugii.soft@gmail.com',_binary '','Post added','11','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','uptake'),(2,'busdavaabayar@gmail.com',_binary '\0','Post added','11','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','uptake'),(3,'tuugii.soft@gmail.com',_binary '','Post added','12','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','uptake'),(4,'busdavaabayar@gmail.com',_binary '\0','Post added','12','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','uptake'),(5,'tuugii.soft@gmail.com',_binary '','Post added','13','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','uptake'),(6,'busdavaabayar@gmail.com',_binary '\0','Post added','13','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','uptake'),(8,'userb@abc.com',_binary '','Post added','18','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','userb'),(9,'userb@abc.com',_binary '','Post added','19','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','usera'),(10,'userb@abc.com',_binary '','Post added','20','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','usera'),(11,'userb@abc.com',_binary '','Post added','21','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','usera'),(12,'usera@abc.com',_binary '\0',' has added post','22','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','userb'),(13,'davaa@gmail.com',_binary '',' has added post','23','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','manduul'),(14,'davaa@gmail.com',_binary '',' has added post','24','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','manduul'),(15,'tuugii.soft@gmail.com',_binary '\0',' has added post','26','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','pusher'),(16,'tuugii.soft@gmail.com',_binary '\0',' has added post','27','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','pusher'),(17,'tuugii.soft@gmail.com',_binary '\0',' has added post','28','https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg','pusher'),(18,'davaa@gmail.com',_binary '',' has added post','30','/files/onon.jpg','onon'),(19,'davaa@gmail.com',_binary '',' has added post','31','/files/onon.jpg','onon'),(20,'onon@gmail.com',_binary '',' has added post','32','/files/davuush.jpg','davaa'),(21,'onon@gmail.com',_binary '',' has added post','33','/files/davuush.jpg','davaa'),(22,'onon@gmail.com',_binary '',' has added post','34','/files/davuush.jpg','davaa'),(23,'davaa@gmail.com',_binary '',' has added post','35','/files/onon.jpg','onon'),(24,'davaa@gmail.com',_binary '',' has added post','36','/files/onon.jpg','onon'),(25,'davaa@gmail.com',_binary '',' has added post','37','/files/mandy.jpg','manduul'),(26,'onon@gmail.com',_binary '',' has added post','37','/files/mandy.jpg','manduul'),(27,'davaa@gmail.com',_binary '',' has added post','39','/files/mandy.jpg','manduul'),(28,'onon@gmail.com',_binary '\0',' has added post','39','/files/mandy.jpg','manduul'),(29,'davaa@gmail.com',_binary '',' has added post','40','/files/mandy.jpg','manduul'),(30,'onon@gmail.com',_binary '\0',' has added post','40','/files/mandy.jpg','manduul'),(31,'davaa@gmail.com',_binary '',' has added post','41','/files/mandy.jpg','manduul'),(32,'onon@gmail.com',_binary '\0',' has added post','41','/files/mandy.jpg','manduul');
/*!40000 ALTER TABLE `notification_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
INSERT INTO `photo` VALUES (1,'profile1.jpg'),(2,'profile2.jpg'),(3,'profile3.jpg'),(4,'profile4.jpg'),(5,'profile5.jpg'),(6,'post1.jpg'),(7,'post2.jpg'),(8,'post3.jpg'),(9,'post4.jpg'),(10,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(11,'/files/20934173_1617305541674382_3941745081911979547_o.jpg'),(12,'/files/withmyfamily.jpg'),(13,'files/video-1576649195.mp4'),(14,'/files/withmyfamily.jpg'),(15,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(16,'/files/23905773_10156144061890832_5027496113300848825_n.jpg'),(17,'/files/23905773_10156144061890832_5027496113300848825_n.jpg'),(18,'/files/withmyfamily.jpg'),(19,'/files/withmyfamily.jpg'),(20,'/files/23905773_10156144061890832_5027496113300848825_n.jpg'),(21,'/files/26239519_1776473499092077_4406121826459448485_n.jpg'),(22,'/files/withmyfamily.jpg'),(23,'/files/withmyfamily.jpg'),(24,'/files/withmyfamily.jpg'),(25,'/files/withmyfamily.jpg'),(26,'/files/withmyfamily.jpg'),(27,'/files/withmyfamily.jpg'),(28,'/files/withmyfamily.jpg'),(29,'/files/withmyfamily.jpg'),(30,'/files/withmyfamily.jpg'),(31,'/files/withmyfamily.jpg'),(32,'/files/withmyfamily.jpg'),(33,'/files/76939616_426825451534676_4170866281861349376_n.png'),(34,'/files/26239519_1776473499092077_4406121826459448485_n.jpg'),(35,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(36,'/files/withmyfamily.jpg'),(37,'/files/withmyfamily.jpg'),(38,'/files/withmyfamily.jpg'),(40,'/files/withmyfamily.jpg'),(41,'/files/23905773_10156144061890832_5027496113300848825_n.jpg'),(42,'/files/51620292_1115352621969570_5223358961322819584_n.jpg'),(43,'/files/video-1576649195.mp4'),(44,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(45,'/files/ph12r65ps82qbwe.jpg'),(46,'/files/dc82e32a21661bae70c91ffa98831f78.jpg'),(47,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(48,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(49,'/files/dc82e32a21661bae70c91ffa98831f78.jpg'),(50,'/files/76939616_426825451534676_4170866281861349376_n.png'),(51,'/files/26239519_1776473499092077_4406121826459448485_n.jpg'),(52,'/files/23905773_10156144061890832_5027496113300848825_n.jpg'),(53,'/files/dad.jpg'),(54,'/files/77206850_1206219442909121_7443689145903349760_o.jpg'),(55,'/files/video-1576649195.mp4'),(56,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(57,'/img/postDefault.png'),(58,'/files/Mongolian-ger-tourist-camp-DiscoverMongolia-3.jpg'),(59,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(60,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(61,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(62,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(63,'/files/pexels-photo-371589.jpeg'),(64,'/files/pexels-photo-1886694.jpeg'),(65,'/files/davuush.jpg'),(66,'/img/postDefault.png'),(67,'/files/mandy.jpg'),(68,'/files/onon.jpg'),(69,'/files/aka.jpg'),(70,'/files/3.jpg'),(71,'/files/dude1.jpg'),(72,'/files/girl1.jpg'),(73,'/files/gilr3.jpg'),(74,'/files/gilr6.jpg'),(75,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(76,'https://assets.rebelcircus.com/blog/wp-content/uploads/2016/05/facebook-avatar.jpg'),(77,'/files/gilr3.jpg'),(78,'/files/girl2.jpg'),(79,'/files/dude9.jpg'),(80,'/files/3.jpg'),(81,'/files/dude9.jpg'),(82,'/files/dude1.jpg'),(83,'/files/video-1576649195.mp4'),(84,'/files/StoryHubMongolia.jpg');
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `is_unhealthy` bit(1) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `photo_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3eivwj72mrwf0ufkehkx3ocwd` (`photo_id`),
  KEY `FK72mt33dhhs48hf9gcqrq4fxte` (`user_id`),
  CONSTRAINT `FK3eivwj72mrwf0ufkehkx3ocwd` FOREIGN KEY (`photo_id`) REFERENCES `photo` (`id`),
  CONSTRAINT `FK72mt33dhhs48hf9gcqrq4fxte` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'2019-12-12 10:00:00.000000','Daniel is a British bloke who works with Skyscanner and LonelyPlanet on the regular. ',_binary '\0',1,'British',6,2),(2,'2019-12-12 10:00:00.000000','His photography has also been published in Beautiful Destination, Travel & Leisure, National Geographic, Travel Channel and Matador Network.',_binary '\0',2,'Photography',7,2),(3,'2019-12-12 10:00:00.000000','YOU MUST catch her on Snapchat or Youtube. She\'s either hitchhiking though SE Asia or sharing her travel shenanigans.',_binary '\0',1,'Limitless',8,2),(4,'2019-12-12 10:00:00.000000','Never afraid to voice her an opinion, she is a talented writer who creates great content. ',_binary '\0',1,'Picky blinders',9,2),(5,NULL,'Description',_binary '\0',1,'New Book Form',11,2),(6,NULL,'Family day',_binary '\0',1,'Family',12,8),(7,NULL,'Learning',_binary '\0',1,'My video',13,8),(8,NULL,'You are my sunshine.',_binary '\0',1,'I love you',36,2),(9,NULL,'sdfsdf',_binary '\0',1,'test projected',37,1),(10,NULL,'You are my sunshine.',_binary '\0',1,'New Book Form',40,9),(11,NULL,'You are my sunshine.',_binary '\0',1,'New Book Form',41,9),(12,NULL,'Yeah we are',_binary '\0',1,'We are familty',42,9),(13,NULL,'Playing piano',_binary '\0',1,'Mandy',43,9),(14,NULL,'Description',_binary '\0',1,'New post',45,10),(15,NULL,'You are my sunshine.',_binary '\0',1,'Use case design',46,11),(16,NULL,'Description',_binary '\0',1,'New Book Form',49,12),(17,NULL,'Must notify',_binary '\0',1,'New post',50,13),(18,NULL,'Brings success',_binary '\0',1,'Team effort',51,12),(19,NULL,'LOL',_binary '\0',1,'New post',52,13),(20,NULL,'Golden time',_binary '\0',1,'Guys',53,13),(21,NULL,'It\'s time to party',_binary '\0',1,'New year is coming',54,13),(22,NULL,'Video post',_binary '\0',1,'It\'s video',55,12),(23,NULL,'You are my sunshine.',_binary '\0',1,'Use case design',63,15),(24,NULL,'Dance like no body is watching',_binary '\0',1,'Dancing girl',64,15),(25,NULL,'Dance like no body is watching',_binary '\0',1,'Davaa',65,11),(26,NULL,'Dance like no body is watching',_binary '\0',1,'Davaa',66,11),(27,NULL,'We did our best.',_binary '\0',1,'This is a nice day',67,11),(28,NULL,'125',_binary '\0',1,'Onon',68,11),(29,NULL,'123',_binary '\0',1,'Aka',69,11),(30,NULL,'Akjol\'s post',_binary '\0',1,'Aka',70,16),(31,NULL,'Onoko\'s post',_binary '\0',1,'Onoko',71,16),(32,NULL,'My family',_binary '\0',1,'Davaa',19,17),(33,NULL,'My daddy',_binary '\0',1,'Davaa',20,17),(34,NULL,'stupid somebody',_binary '',1,'Now post',74,17),(35,NULL,'testtest',_binary '\0',1,'test',77,16),(36,NULL,'test2',_binary '\0',1,'test2',78,16),(37,NULL,'testtesttest',_binary '\0',1,'testest',79,15),(38,NULL,'test',_binary '\0',1,'test',80,15),(39,NULL,'stupid',_binary '\0',1,'Unhealthy',82,15),(40,NULL,'ved',_binary '\0',1,'ved',83,15),(41,NULL,'Description',_binary '\0',1,'New post',84,15);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_for_newsfeed`
--

DROP TABLE IF EXISTS `post_for_newsfeed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_for_newsfeed` (
  `id` bigint(20) NOT NULL,
  `created` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `post_path` varchar(255) DEFAULT NULL,
  `profile_path` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_for_newsfeed`
--

LOCK TABLES `post_for_newsfeed` WRITE;
/*!40000 ALTER TABLE `post_for_newsfeed` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_for_newsfeed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bio` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `photo_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3hiakcdj1r5twsj9mc8273qth` (`photo_id`),
  KEY `FKawh070wpue34wqvytjqr4hj5e` (`user_id`),
  CONSTRAINT `FK3hiakcdj1r5twsj9mc8273qth` FOREIGN KEY (`photo_id`) REFERENCES `photo` (`id`),
  CONSTRAINT `FKawh070wpue34wqvytjqr4hj5e` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (1,'Admin user profiele','2000-10-10','--Admin--',1,1,1),(2,'Live without excuse.Travel without regret.','2000-10-10','Dolly Anna',1,35,2),(3,'Bio','2000-10-10','Jessica Alba',1,35,3),(4,'Admin user profiele','2000-10-10','Ross',1,35,4),(5,'Bio','2000-10-10','Monica',1,35,5),(6,'',NULL,'',NULL,NULL,NULL),(7,'sdfsdf',NULL,'DAVAABAYAR BATTOGTOKH',NULL,NULL,NULL),(8,'Java developer',NULL,'DAVAABAYAR BATTOGTOKH',NULL,NULL,NULL),(9,'Java developer',NULL,'DAVAABAYAR BATTOGTOKH',NULL,NULL,NULL),(10,'Java developer',NULL,'Davaabayar Battogtokh',NULL,NULL,NULL),(11,'Java developer',NULL,'Victor Luiz Garcia',NULL,NULL,NULL),(12,'Java developer',NULL,'Usain Bolt',0,NULL,NULL),(13,'Java developer',NULL,'Usain Bolt',0,NULL,NULL),(15,'New bio','2019-06-29','Tuguldur',1,34,NULL),(16,NULL,NULL,NULL,NULL,15,9),(19,'Bio Davaabayar','2019-09-30','Davaabayar Battogtokh',1,22,NULL),(20,'','2019-09-30','Davaabayar Battogtokh',1,23,NULL),(21,'','2019-09-30','Davaabayar Battogtokh',1,24,NULL),(22,'','2019-09-30','DAVAABAYAR BATTOGTOKH',1,25,NULL),(23,'','2019-09-30','Davaabayar Battogtokh',1,26,NULL),(25,'','2019-09-30','Pinky',1,27,NULL),(26,'','2019-09-30','Pinky',1,28,NULL),(27,'','2019-09-30','Pinky Davaa',1,29,NULL),(28,'','2019-09-30','Pinky Davaa',1,30,NULL),(29,NULL,NULL,NULL,NULL,35,10),(30,NULL,NULL,NULL,NULL,44,11),(31,'',NULL,'Maharishi university of management',NULL,56,NULL),(32,NULL,NULL,NULL,NULL,48,13),(33,NULL,NULL,NULL,NULL,69,14),(34,NULL,NULL,NULL,NULL,67,15),(35,NULL,NULL,NULL,NULL,68,16),(36,NULL,NULL,NULL,NULL,65,17),(37,'',NULL,'',NULL,76,NULL);
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `public_name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`),
  KEY `FKddefmvbrws3hvl5t0hnnsv8ox` (`address_id`),
  CONSTRAINT `FKddefmvbrws3hvl5t0hnnsv8ox` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2019-12-12','admin@yahoo.com','$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui',NULL,_binary '','admin',1),(2,'2019-12-13','user1@yahoo.com','$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui',NULL,_binary '','user1',2),(3,'2019-12-12','user2@yahoo.com','$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui',NULL,_binary '\0','user2',3),(4,'2019-12-13','user3@yahoo.com','$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui',NULL,_binary '','user3',4),(5,'2019-12-13','user4@yahoo.com','$2y$12$/ENaGrt1xm6HWvXSXtEYtunMB1.1hZa8kTLYjnjGdziYfsbJcUNui',NULL,_binary '','user4',5),(6,NULL,'busdavaabayar@gmail.com','$2a$10$u0pKIf8FW9cXKk4MyU8kdOzckCj/kM.VVZIxi6MNHTIC7ou2bMGBu',NULL,_binary '','Davaa1',NULL),(7,NULL,'new@gmail.com','$2a$10$3/OHByLtHqMpfRxJrt61yO38FTgDYpPL85pUv.KTeBODhSqarPJsW',NULL,_binary '','username',NULL),(8,NULL,'pinky@yahoo.com','$2a$10$HF0wg6cN4y83eOq4/Qxr8uaCyC9WoqjmWuFPlDJzpE6t0E27YUPK2',NULL,_binary '\0','pinky',34),(9,NULL,'uptake@yahoo.com','$2a$10$AsxY2kM0CjX6EjKOOViTCuZF6UKq6OvPd8e3HHvqlixCOUW9jxl1.',NULL,_binary '','uptake',1),(10,NULL,'tuugii.soft@gmail.com','$2a$10$e8xCI1EH.NpCiwzJ3vTS5uU51Bv1Qt/8/67ojRWRQcTL2v8hlBsnO',NULL,_binary '','Tuugii',35),(11,NULL,'push@yahoo.com','$2a$10$1hPQSmBcdbM3Ji4bDgWZoOZqHO2HdnYpNbEJYOSPMXAbLz.oTDXpO',NULL,_binary '','pusher',36),(12,NULL,'userb@abc.com','$2a$10$7yLz3jHx.ZweKUZTYzrN5.VEjyL5qE38xD8TU8cWISPy29cujLE26',NULL,_binary '\0','userb',37),(13,NULL,'usera@abc.com','$2a$10$QIPNVhQw5eOkJv9Q5J/cG.FiBTCKn00R0/GL77GTwk9J8JRMvhOGi',NULL,_binary '','usera',38),(14,NULL,'akjol@gmail.com','$2a$10$oQarXWBQmnED1CM9Mvue5.06dARski.KoRBqpqIztjMZJ8PIn0PIq',NULL,_binary '','akjol',39),(15,NULL,'manduul@gmail.com','$2a$10$JyjUe52M3xKXqlGSS/PztOsL.CP.n1grBCBzyhG9wKHi3THw7BgUy',NULL,_binary '','manduul',40),(16,NULL,'onon@gmail.com','$2a$10$Dr8HkBn/wPdbfz74CBzNf.wberXwEWhqFN3alnHA4Uox95byc1Qgi',NULL,_binary '','onon',41),(17,NULL,'davaa@gmail.com','$2a$10$YXU7rZ8wtIMDMQIct.kcB.l9hfIj6AFY0mIeYnaG86kfmyMR9zXze',NULL,_binary '','davaa',42),(18,NULL,'test@gmail.com','$2a$10$OUx6wTDu0g/Vwn3h2MLHaOVTaC2kzs18N0SwuExo46WRcHpuOFZc2',NULL,_binary '\0','test',43);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_for_search`
--

DROP TABLE IF EXISTS `user_for_search`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_for_search` (
  `username` varchar(255) NOT NULL,
  `bio` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_for_search`
--

LOCK TABLES `user_for_search` WRITE;
/*!40000 ALTER TABLE `user_for_search` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_for_search` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(9,2),(10,2),(11,2),(13,2),(14,2),(15,2),(16,2),(17,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-19 20:33:25
