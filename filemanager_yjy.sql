/*
Navicat MySQL Data Transfer

Source Server         : db2
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : filemanager_yjy

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-01-07 18:35:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fileinfo
-- ----------------------------
DROP TABLE IF EXISTS `fileinfo`;
CREATE TABLE `fileinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FileName` varchar(50) NOT NULL,
  `FilePath` varchar(100) NOT NULL,
  `Title` varchar(100) DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `CreateUser` int(11) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `UpdateDate` datetime DEFAULT NULL,
  `hitCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for lyinfo
-- ----------------------------
DROP TABLE IF EXISTS `lyinfo`;
CREATE TABLE `lyinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `lyContent` varchar(255) DEFAULT NULL,
  `fileId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `LoginName` varchar(30) NOT NULL,
  `UserName` varchar(30) NOT NULL,
  `UserPwd` varchar(20) DEFAULT NULL,
  `Gender` varchar(1) DEFAULT NULL,
  `Grade` varchar(10) DEFAULT NULL,
  `Cell` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Role` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
