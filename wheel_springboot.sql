/*
Navicat MySQL Data Transfer

Source Server         : localhost_xampp_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : wheel_springboot

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-10-13 14:56:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('hsf123', 'Sheffer', '23');
INSERT INTO `user` VALUES ('hsf456', 'Sheffer', '23');
