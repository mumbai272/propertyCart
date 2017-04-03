/*
SQLyog Community v9.63 
MySQL - 5.5.29 : Database - property
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Data for the table `hibernate_sequence` */
create database property;
use property;
insert  into `hibernate_sequence`(`next_val`) values (1),(1),(1),(1),(1),(1),(1),(1),(1);

/*Data for the table `ps_address` */

insert  into `ps_address`(`id`,`Street`,`area`,`city`,`country`,`latitude`,`longitude`,`state`,`zipcode`) values (1,'Kalepadal','Shiv Nagar, Hadapsar','Pune','India',18.480217,73.943337,'Maharashtra',411028),(2,'Pisoli','Pisoli','Pune','India',18.4524988,73.8954707,'Maharashtra',411028);

/*Data for the table `ps_enquiry` */

/*Data for the table `ps_image` */

insert  into `ps_image`(`id`,`imageName`,`is_active`,`is_blocked`,`status`,`type`,`project_id`,`property_id`) values (1,'3216_Ar_Parvej_Satyam_Mahadik_Hadapsar_Evening_View_01.jpg','','','Active','image',1,1),(2,'Satyam Niranjani.jpg','','','Active','thumbnail',1,1),(3,'3216_Ar_Parvej_Satyam_Mahadik_Hadapsar_View_03.jpg','','','Active','image',1,1),(4,'3216_Ar_Parvej_Satyam_Mahadik_Hadapsar_View_07.jpg','','','Active','image',1,1),(5,'Flat_1BHK_01.jpg','','','Active','image',1,1),(6,'Flat_2BHK_01.jpg','','','Active','image',1,1);

/*Data for the table `ps_project` */

insert  into `ps_project`(`id`,`address_id`,`STARTING_PRICE`,`STATUS`,`title`,`user_id`) values (1,1,'25 lacs',1,'Satyam Niranjani',1),(2,2,'25 lacs',3,'Sankla Exclusive Vistas',1);

/*Data for the table `ps_promotion` */

/*Data for the table `ps_property` */

insert  into `ps_property`(`is_new`,`id`,`address_id`,`bedrooms`,`price`,`project_id`,`user_id`,`size`) values (1,1,1,1,2943470,1,1,605),(1,2,1,1,3003680,1,1,620),(1,3,1,1,3023750,1,1,625),(1,4,1,1,3164240,1,1,660),(1,5,1,1,3204380,1,1,670),(1,6,1,1,3465290,1,1,735),(1,7,1,2,3886760,1,1,840),(1,8,1,2,3906830,1,1,845);

/*Data for the table `ps_testimonial` */

/*Data for the table `ps_user` */

/*Data for the table `ps_user_map` */

/*Data for the table `ps_user_profile` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
