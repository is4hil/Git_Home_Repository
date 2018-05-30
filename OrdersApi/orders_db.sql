/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.41 : Database - orders_database
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`orders_database` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `orders_database`;

/*Table structure for table `order_table` */

DROP TABLE IF EXISTS `order_table`;

CREATE TABLE `order_table` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) DEFAULT NULL,
  `product_price` varchar(100) DEFAULT NULL,
  `payment_mode` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `order_table` */

insert  into `order_table`(`id`,`product_name`,`product_price`,`payment_mode`,`status`) values (1,'sahil','600','cash','200'),(2,'sahil','600','cash','200'),(3,'sahil','600','cash','200'),(4,'Motuuu','90000','online','200');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
