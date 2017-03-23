create database propertyAgentDB;
use propertyAgentDB;
insert  into `address`(`id`,`CITY`,`CO_ORDINATE`,`COUNTRY`,`LOCALITY`,`STATE`,`STREET1`,`STREET2`,`ZIP_CODE`) values (1,'Bangalore','32.22,26.22','India','Kudlugate','karnataka','UMC apartment','Hosure road','560001'),(2,'Bijapur','25.22,36.22','India','Adarshnager','karnataka','Patil aprtment','aSHRAM Road','586101');

/*Data for the table `project` */

insert  into `project`(`id`,`ADDRESS_ID`,`RATING`,`SHORT_DESC`,`STARTING_PRICE`,`STATUS`,`TITLE`) values (1,1,3,NULL,'35 lacs',1,'Vasudev'),(2,1,4,NULL,'45 lacs',2,'Purvankar'),(3,2,5,NULL,'50 lacs',3,'Umashree');

/*Data for the table `projectresources` */

insert  into `projectresources`(`id`,`name`,`PROJECT_ID`,`PROPERTY_ID`,`resourceType`) values (1,'image1.png',1,1,'thumbnail'),(2,'image2.png',1,1,'images');

/*Data for the table `property` */

insert  into `property`(`id`,`count`,`price`,`PROJECT_ID`,`SIZE`,`TYPE`) values (1,4,35,1,'1256 sq.ft ','3 BKH'),(2,2,25,1,'999 sq.ft','2 BHK'),(3,1,20,1,'500 sq.ft','1 BHK');