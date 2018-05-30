/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.41 : Database - payment_database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`payment_database` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `payment_database`;

/*Table structure for table `payment_table` */

DROP TABLE IF EXISTS `payment_table`;

CREATE TABLE `payment_table` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `payment_amount` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `payment_table` */

insert  into `payment_table`(`id`,`payment_amount`,`order_id`,`payment_mode`,`status`) values (1,600,1,'cash','200'),(2,600,2,'cash','200'),(3,600,3,'cash','200'),(4,90000,4,'online','200');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
