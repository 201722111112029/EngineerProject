SET NAMES utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL comment '用户名',
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `register_date` timestamp DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) DEFAULT 1,
  `role` varchar(50) DEFAULT NULL comment '角色',
  `avatar_url` varchar(200) DEFAULT '' comment '头像',
  PRIMARY KEY (`id`)
);
ALTER TABLE `user` ADD UNIQUE (`username`);
ALTER TABLE `user` ADD UNIQUE (`email`);
ALTER TABLE `user` ADD UNIQUE (`phone`);


-- DROP TABLE IF EXISTS `music`;
-- CREATE TABLE `music`  (
--    `id` bigint(20) NOT NULL AUTO_INCREMENT,
--    `name` varchar(255) NOT NULL,
--    `source_url` varchar(255),
--    `destination_url` varchar(255),
--    `size` bigint(20) NOT NULL,
--    `upload_time` varchar(255) NOT NULL,
--    PRIMARY KEY (`id`)
--  );
--
-- DROP TABLE IF EXISTS `video`;
-- CREATE TABLE `video`  (
--    `id` bigint(20) NOT NULL AUTO_INCREMENT,
--    `name` varchar(255) NOT NULL,
--    `source_url` varchar(255),
--    `destination_url` varchar(255),
--    `size` bigint(20) NOT NULL,
--    `upload_time` varchar(255) NOT NULL,
--    PRIMARY KEY (`id`)
-- );
--
-- DROP TABLE IF EXISTS `document`;
-- CREATE TABLE `document`  (
--    `id` bigint(20) NOT NULL AUTO_INCREMENT,
--    `name` varchar(255) NOT NULL,
--    `source_url` varchar(255),
--    `destination_url` varchar(255),
--    `size` bigint(20) NOT NULL,
--    `upload_time` varchar(255) NOT NULL,
--    PRIMARY KEY (`id`)
-- );
--
-- DROP TABLE IF EXISTS `other_file`;
-- CREATE TABLE `other_file`  (
--    `id` bigint(20) NOT NULL AUTO_INCREMENT,
--    `name` varchar(255) NOT NULL,
--    `source_url` varchar(255),
--    `destination_url` varchar(255),
--    `size` bigint(20) NOT NULL,
--    `upload_time` varchar(255) NOT NULL,
-- PRIMARY KEY (`id`)
-- );
--
-- DROP TABLE IF EXISTS `picture`;
-- CREATE TABLE `picture`  (
--    `id` bigint(20) NOT NULL AUTO_INCREMENT,
--    `name` varchar(255) NOT NULL,
--    `source_url` varchar(255),
--    `destination_url` varchar(255),
--    `size` bigint(20) NOT NULL,
--    `upload_time` varchar(255) NOT NULL,
-- PRIMARY KEY (`id`)
-- );

