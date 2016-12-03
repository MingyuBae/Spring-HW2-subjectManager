-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: subjectmanager
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `course_year` int(11) DEFAULT NULL,
  `course_semester` varchar(10) DEFAULT NULL,
  `course_code` varchar(10) NOT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  `course_type` varchar(10) DEFAULT NULL,
  `course_point` int(11) DEFAULT NULL,
  PRIMARY KEY (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (2012,'1','CAE0001','일반물리I','핵교A',2),(2012,'1','CAE0002','공학의 이해','핵교A',2),(2012,'2','CAE0004','미분적분학','핵교A',2),(2012,'2','CAE0006','과학기술사','핵교A',2),(2012,'1','CAE0007','공학윤리','핵교A',2),(2012,'2','CAE0008','공학과 경제성','핵교A',2),(2013,'1','CBE0008','기초통계학','핵교B',2),(2013,'1','CBH0003','윤리학','핵교B',2),(2015,'2','CBRE004','창의적 기술과 리더십','핵교B',2),(2012,'2','CBS0006','한국사회의 이해','핵교B',2),(2012,'1','COM0002','컴퓨터프로그래밍Ⅰ','전기',3),(2012,'1','COM0004','이산수학 ','전기',3),(2012,'2','COM0005','컴퓨터프로그래밍Ⅱ','전기',3),(2013,'1','COM0009','자료구조','전지',3),(2015,'2','COM0010','컴퓨터구조 ','전선',3),(2015,'2','COM0012','알고리즘','전선',3),(2015,'2','COM0016','객체지향언어 1','전선',3),(2013,'1','COM0038','시스템프로그래밍','전선',3),(2015,'2','COM0040','네트워크와 데이터통신','전선',3),(2013,'1','COM0053','논리회로설계','전선',3),(2013,'1','COM0054','프로그래밍언어론','전선',3),(2012,'2','COM0055','창의적공학설계','전선',3),(2015,'2','COM0069','웹 기초','전선',3),(2016,'1','CSE0012','객체지향언어2','전선',3),(2016,'1','CSE0017','운영체제','전지',3),(2016,'1','CSE0019','데이터베이스','전지',3),(2016,'1','CSE0020','소프트웨어공학','전선',3),(2016,'1','CSE0022','모바일시스템','전선',3),(2016,'1','CSE0023','웹서버프로그래밍','전선',3),(2016,'2','CSE0026','고급시스템프로그래밍','전선',3),(2016,'2','CSE0028','설계패턴','전선',3),(2016,'2','CSE0029','네트워크프로그래밍','전선',3),(2016,'2','CSE0031','안드로이드프로그래밍1','전선',3),(2016,'2','CSE0032','웹프레임워크1','전선',3),(2016,'2','CSE0033','데이터마이닝','전선',3),(2013,'1','GEN0190','Excel 실무활용','일교',2),(2013,'1','GEN0200','컴퓨터와 인터넷개론','일교',2),(2012,'1','REQ0013','사고와 표현I','교필',2),(2012,'2','REQ0014','사고와 표현II','교필',2),(2012,'2','REQ0015','대학과 지성','교필',2),(2012,'1','REQ0112','영어커뮤니케이션 독해/작문A-II','교필',1),(2012,'1','REQ0122','영어커뮤니케이션 청취/회화A-II','교필',1),(2012,'2','REQ0212','영어커뮤니케이션 독해/작문B-II','교필',1),(2012,'2','REQ0222','영어커뮤니케이션 청취/회화B-II','교필',1),(2015,'2','U121012','그린IT의 이해','일교',3),(2012,'1','U122013','스마트기기 100배 즐기기','일교',3),(2016,'1','U122043','소셜미디어와 스마트한 세상','자율',3),(2016,'2','U122060','커피와 바리스타','자율',3);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sugang`
--

DROP TABLE IF EXISTS `sugang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sugang` (
  `sugang_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_code` varchar(20) DEFAULT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  `course_type` varchar(10) DEFAULT NULL,
  `course_point` int(11) DEFAULT NULL,
  PRIMARY KEY (`sugang_id`),
  UNIQUE KEY `course_code_UNIQUE` (`course_code`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='수강신청 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sugang`
--

LOCK TABLES `sugang` WRITE;
/*!40000 ALTER TABLE `sugang` DISABLE KEYS */;
INSERT INTO `sugang` VALUES (10,'CSE0025','캡스톤디자인1','전지',3),(11,'CSE0036','캡스톤디자인2','전지',3),(12,'CSE0042','웹프레임워크2','전선',3),(13,'CSE0041','안드로이드프로그래밍2','전선',3),(16,'U121017','웰니스와 삶의 질','자율',3);
/*!40000 ALTER TABLE `sugang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'subjectmanager'
--

--
-- Dumping routines for database 'subjectmanager'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-03 18:12:42
