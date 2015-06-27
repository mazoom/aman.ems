/*
SQLyog - Free MySQL GUI v5.19
Host - 5.5.19 : Database - amaneng_ems_db
*********************************************************************
Server version : 5.5.19
*/


SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `amaneng_ems_db`;

USE `amaneng_ems_db`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `ems_user_account` */

DROP TABLE IF EXISTS `ems_user_account`;

CREATE TABLE `ems_user_account` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `is_verified` int(2) DEFAULT '1',
  `account_type` varchar(25) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `is_active` int(1) DEFAULT '1',
  `created_by` varchar(255) DEFAULT NULL,
  `created_dt` date DEFAULT NULL,
  `last_upd_by` varchar(255) DEFAULT NULL,
  `last_upd_dt` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `ems_user_account` */

insert into `ems_user_account` (`id`,`user_id`,`first_name`,`last_name`,`password`,`gender`,`is_verified`,`account_type`,`email`,`is_active`,`created_by`,`created_dt`,`last_upd_by`,`last_upd_dt`) values (1,'root','b1','b2','40bd001563085fc35165329ea1ff5c5ecbdbbeef','Male',1,'EMPLOYEE','b1@gt.com',1,'','2012-11-18','','2012-11-18');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
