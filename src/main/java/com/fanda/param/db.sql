-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fandafood
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `first_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `last_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone_number` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('admin','123','Nguyễn','Quản Trị','0788791726','tinhntpc02175@fpt.edu.vn',_binary '',_binary '',NULL),('user1','123','Nguyễn','Nhất Niệm','0986633495',NULL,_binary '',_binary '\0',NULL),('user2','123','Nguyễn','Nhị Khúc',NULL,NULL,_binary '',_binary '',NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `id` int NOT NULL,
  `role_id` int DEFAULT NULL,
  `userid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKs1gjv619ehephhyauffufq669` (`userid`,`role_id`),
  KEY `FK_user_author_idx` (`userid`),
  KEY `FK_author_role_idx` (`role_id`),
  CONSTRAINT `FK_author_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_user_author` FOREIGN KEY (`userid`) REFERENCES `account` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,1,'admin'),(2,2,'user1'),(3,2,'user2');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `food_id` int DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `qty` int DEFAULT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `FK_food_idx` (`food_id`),
  KEY `FK_acc_idx` (`username`),
  CONSTRAINT `FK_acc` FOREIGN KEY (`username`) REFERENCES `account` (`username`),
  CONSTRAINT `FK_food` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_address`
--

DROP TABLE IF EXISTS `delivery_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_address` (
  `address_id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FKuseraddress_idx` (`username`),
  CONSTRAINT `FKuseraddress` FOREIGN KEY (`username`) REFERENCES `account` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_address`
--

LOCK TABLES `delivery_address` WRITE;
/*!40000 ALTER TABLE `delivery_address` DISABLE KEYS */;
INSERT INTO `delivery_address` VALUES (1,'Nhà','288 nvl',_binary '','user1',0),(2,'Nhà','300 nvl',_binary '','user2',0);
/*!40000 ALTER TABLE `delivery_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite`
--

DROP TABLE IF EXISTS `favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favorite` (
  `favorite_id` int NOT NULL,
  `restaurant_id` int DEFAULT NULL,
  PRIMARY KEY (`favorite_id`),
  KEY `restaurant_id` (`restaurant_id`),
  CONSTRAINT `favorite_ibfk_1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite`
--

LOCK TABLES `favorite` WRITE;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `food_id` int NOT NULL,
  `menu_cate_id` int DEFAULT NULL,
  `food_cate_id` int DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`food_id`),
  KEY `menu_cate_id` (`menu_cate_id`),
  KEY `food_cate_id` (`food_cate_id`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`menu_cate_id`) REFERENCES `menu_cate` (`menu_id`),
  CONSTRAINT `food_ibfk_2` FOREIGN KEY (`food_cate_id`) REFERENCES `food_category` (`food_cate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,1,1,'Cơm trộn Hàn Quốc',12000,'popular4.png','Cơm trộn',_binary ''),(2,3,4,'Bánh mì chảo',36000,'popular5.png','Siêu ngon',_binary ''),(3,1,1,'Soup bí ngô',36000,'trending6.png','Món ăn châu âu',_binary ''),(4,1,1,'Hambuger',50000,'popular2.png','Bánh Mì Hambuger',_binary ''),(5,1,1,'Salad Rau củ',120000,'popular6.png','Món ăn có lợi cho sức khỏe',_binary ''),(6,1,1,'Thịt viên sốt kiểu Pháp',300000,'popular7.png','Sốt cay , Phô mai , Tiêu xanh',_binary ''),(7,3,1,'Set Đồ ăn dã ngoại',400000,'popular8.png','Các loại hạt và trái cây tốt cho sức khỏe',_binary ''),(8,1,1,'Set Đồ ăn châu âu',600000,'popular3.png','Được kết hợp bởi nhiều nền văn hóa',_binary '');
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_category`
--

DROP TABLE IF EXISTS `food_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_category` (
  `food_cate_id` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`food_cate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_category`
--

LOCK TABLES `food_category` WRITE;
/*!40000 ALTER TABLE `food_category` DISABLE KEYS */;
INSERT INTO `food_category` VALUES (1,'Cafe'),(2,'Bò'),(3,'Salad'),(4,'Đá xay'),(5,'Sữa chua'),(6,'Sữa tươi'),(7,'Hamburger'),(8,'Bánh mì'),(9,'Bữa sáng'),(10,'Pizza'),(11,'Bánh'),(12,'Kẹo'),(13,'Ăn no'),(14,'Thức anh nhanh');
/*!40000 ALTER TABLE `food_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_cate`
--

DROP TABLE IF EXISTS `menu_cate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu_cate` (
  `menu_id` int NOT NULL,
  `restaurant_id` int DEFAULT NULL,
  `cate_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`menu_id`),
  KEY `restaurant_id` (`restaurant_id`),
  CONSTRAINT `menu_cate_ibfk_1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_cate`
--

LOCK TABLES `menu_cate` WRITE;
/*!40000 ALTER TABLE `menu_cate` DISABLE KEYS */;
INSERT INTO `menu_cate` VALUES (1,1,'Đồ nóng'),(2,1,'Đồ lạnh'),(3,2,'Khai vị'),(4,2,'Tráng miệng');
/*!40000 ALTER TABLE `menu_cate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` int NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `voucher_id` int DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  `total` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `username` (`username`),
  KEY `voucher_id` (`voucher_id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`username`) REFERENCES `account` (`username`),
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`voucher_id`) REFERENCES `voucher` (`restaurant_id`),
  CONSTRAINT `order_ibfk_3` FOREIGN KEY (`address_id`) REFERENCES `delivery_address` (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `order_detail_id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `food_id` int DEFAULT NULL,
  `qty` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `oder_detail_id` int NOT NULL,
  PRIMARY KEY (`order_detail_id`),
  KEY `order_id` (`order_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`),
  CONSTRAINT `order_detail_ibfk_2` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `picture` (
  `picture_id` int NOT NULL,
  `food_id` int DEFAULT NULL,
  `picture` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`picture_id`),
  KEY `food_id` (`food_id`),
  CONSTRAINT `picture_ibfk_1` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `premium_bundle`
--

DROP TABLE IF EXISTS `premium_bundle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `premium_bundle` (
  `premium_id` int NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `restaurant_tag` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `premium_icon` bit(1) DEFAULT NULL,
  PRIMARY KEY (`premium_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `premium_bundle`
--

LOCK TABLES `premium_bundle` WRITE;
/*!40000 ALTER TABLE `premium_bundle` DISABLE KEYS */;
INSERT INTO `premium_bundle` VALUES (1,'Phổ thông',0,NULL,NULL,_binary '\0'),(2,'Cao cấp',200000,'2022-11-25 00:00:00','Cao cấp',_binary '');
/*!40000 ALTER TABLE `premium_bundle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prioritized`
--

DROP TABLE IF EXISTS `prioritized`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prioritized` (
  `id` int NOT NULL,
  `premium_id` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `premium_id` (`premium_id`),
  CONSTRAINT `prioritized_ibfk_1` FOREIGN KEY (`premium_id`) REFERENCES `premium_bundle` (`premium_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prioritized`
--

LOCK TABLES `prioritized` WRITE;
/*!40000 ALTER TABLE `prioritized` DISABLE KEYS */;
INSERT INTO `prioritized` VALUES (1,1,'2022-11-25',NULL,_binary '');
/*!40000 ALTER TABLE `prioritized` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant` (
  `restaurant_id` int NOT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `prioritized_id` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `main_image` varchar(500) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `total_rate` float DEFAULT NULL,
  `open_time` time DEFAULT NULL,
  `close_time` time DEFAULT NULL,
  PRIMARY KEY (`restaurant_id`),
  KEY `FK_user_idx` (`user_id`),
  KEY `FK_pri_idx` (`prioritized_id`),
  CONSTRAINT `FK_pri` FOREIGN KEY (`prioritized_id`) REFERENCES `prioritized` (`id`),
  CONSTRAINT `FK_user` FOREIGN KEY (`user_id`) REFERENCES `account` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (1,NULL,1,'Tui\'s restaurant','tui.png','0102 NVC',2,'08:00:00','24:00:00'),(2,NULL,1,'Bạn\'s food','ban.png','QL HEHE CT',4.5,'00:00:00','24:00:00');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_location`
--

DROP TABLE IF EXISTS `restaurant_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant_location` (
  `id` int DEFAULT NULL,
  `restaurant_id` int DEFAULT NULL,
  `location` varchar(300) DEFAULT NULL,
  KEY `Key` (`id`,`restaurant_id`,`location`),
  KEY `FKkgl6ss2nr2yb87wedxpury51c` (`restaurant_id`),
  CONSTRAINT `FKkgl6ss2nr2yb87wedxpury51c` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`restaurant_id`),
  CONSTRAINT `restaurant_location_ibfk_1` FOREIGN KEY (`id`) REFERENCES `restaurant` (`restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_location`
--

LOCK TABLES `restaurant_location` WRITE;
/*!40000 ALTER TABLE `restaurant_location` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurant_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `review_id` int NOT NULL AUTO_INCREMENT,
  `food_id` int DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `vote` bit(1) DEFAULT NULL,
  `restaurant_id` int DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FK_food_idx` (`food_id`),
  KEY `FK_user_idx` (`user_id`),
  KEY `FK70ry7cuti298yxet366rynxch` (`restaurant_id`),
  CONSTRAINT `FK70ry7cuti298yxet366rynxch` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`restaurant_id`),
  CONSTRAINT `food_review` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`),
  CONSTRAINT `food_user` FOREIGN KEY (`user_id`) REFERENCES `account` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voucher`
--

DROP TABLE IF EXISTS `voucher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voucher` (
  `voucher` int NOT NULL,
  `restaurant_id` int DEFAULT NULL,
  `discount` int DEFAULT NULL,
  `minimum_order` int DEFAULT NULL,
  `delivery_discount` double DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`voucher`),
  KEY `restaurant_id_idx` (`restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voucher`
--

LOCK TABLES `voucher` WRITE;
/*!40000 ALTER TABLE `voucher` DISABLE KEYS */;
/*!40000 ALTER TABLE `voucher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voucher_applyto`
--

DROP TABLE IF EXISTS `voucher_applyto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voucher_applyto` (
  `id` int NOT NULL,
  `voucher_id` int DEFAULT NULL,
  `restaurant_id` int DEFAULT NULL,
  `food_id` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `restaurant_idx` (`restaurant_id`),
  KEY `food_idx` (`food_id`),
  KEY `voucher_idx` (`voucher_id`),
  KEY `FKbnnlqvut1qja0f570cjgj3faj` (`username`),
  CONSTRAINT `FKbnnlqvut1qja0f570cjgj3faj` FOREIGN KEY (`username`) REFERENCES `account` (`username`),
  CONSTRAINT `food` FOREIGN KEY (`food_id`) REFERENCES `food` (`food_id`),
  CONSTRAINT `restaurant` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`restaurant_id`),
  CONSTRAINT `voucher` FOREIGN KEY (`voucher_id`) REFERENCES `voucher` (`voucher`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voucher_applyto`
--

LOCK TABLES `voucher_applyto` WRITE;
/*!40000 ALTER TABLE `voucher_applyto` DISABLE KEYS */;
/*!40000 ALTER TABLE `voucher_applyto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-30  2:08:45
