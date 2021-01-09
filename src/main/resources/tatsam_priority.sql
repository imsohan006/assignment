/*Database creation*/
CREATE SCHEMA `tatsam_priority` DEFAULT CHARACTER SET utf8 ;




/*Create areas table*/

DROP TABLE IF EXISTS `areas`;

CREATE TABLE `areas` (
  `id` int(11) NOT NULL,
  `area` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `areas` (`id`, `area`) VALUES (5,'Wealth'),(6,'Career'),(7,'Relationships'),(8,'Connection');






/*Create hibernate_sequence table*/

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `hibernate_sequence` (`next_val`) VALUES (12);






/*Create priority table*/

DROP TABLE IF EXISTS `priority`;

CREATE TABLE `priority` (
  `id` bigint(20) NOT NULL,
  `area` varchar(255) NOT NULL,
  `create_timestamp` datetime(6) DEFAULT NULL,
  `priority` int(11) NOT NULL,
  `satisfaction` int(11) NOT NULL,
  `user` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `priority` (`id`, `area`, `create_timestamp`, `priority`, `satisfaction`, `user`) VALUES (9,'Wealth','2021-01-09 10:52:47.274000',1,5,'user1'),(10,'Career','2021-01-09 10:53:08.784000',3,3,'user1'),(11,'Career','2021-01-09 10:53:31.224000',5,1,'user2');





/*Create user table*/

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `user` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i3e9qhkr9wead1gstwc34yimg` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `user` (`id`, `password`, `role`, `user`) VALUES (1,'admin','ADMIN','admin'),(2,'user1','USER','user1'),(3,'user2','USER','user2'),(4,'user3','USER','user3');
