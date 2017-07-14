/*CREATE TABLE IF NOT EXISTS `USER` (
  `user_idx` INT(11) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(50) NOT NULL,
  `user_key` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000000;
*/

CREATE TABLE IF NOT EXISTS `user` (
  `user_idx` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `user_principal` varchar(255) NOT NULL,
  `social_type` varchar(255) NOT NULL,
  `user_key` bigint(11) DEFAULT NULL,
  `user_profile_url` varchar(255) DEFAULT NULL,
  `user_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000000 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `comment` (
  `comment_idx` bigint(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `parent_idx` bigint(11) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  `created_at` datetime NOT NULL,
  `modified_at` datetime DEFAULT NULL,
  `user_idx` bigint(11) NOT NULL,
  PRIMARY KEY (`comment_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=1000000000 DEFAULT CHARSET=utf8;
