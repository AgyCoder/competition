/*
 Navicat MySQL Data Transfer

 Source Server         : lab11
 Source Server Type    : MySQL
 Source Server Version : 50149
 Source Host           : localhost:3306
 Source Schema         : competition_sys

 Target Server Type    : MySQL
 Target Server Version : 50149
 File Encoding         : 65001

 Date: 13/06/2019 00:32:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '工科');
INSERT INTO `category` VALUES (2, '理科');
INSERT INTO `category` VALUES (3, '文科');
INSERT INTO `category` VALUES (4, '商科');
INSERT INTO `category` VALUES (5, '综合');
INSERT INTO `category` VALUES (6, '体育');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `itemName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '比赛名称',
  `categoryId` int(10) UNSIGNED NOT NULL COMMENT '类别',
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '比赛描述',
  `signUpStartTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报名开始时间',
  `signUpEndTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报名结束时间',
  `startTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '比赛开始时间',
  `endTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '比赛结束时间',
  `sponsor` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主办方',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fki_c`(`categoryId`) USING BTREE,
  CONSTRAINT `fki_c` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES (1, '计算机博弈大赛', 1, NULL, NULL, '2019-01-01', '2019-02-02', '2019-03-03', '2019-03-03', '电子科大中山学院');
INSERT INTO `item` VALUES (2, 'ACM', 1, NULL, '大学生程序设计大赛', '2018-02-04', '2018-04-02', '2019-01-01', '2019-02-05', '电子科大中山学院');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `studentId` int(10) UNSIGNED NOT NULL COMMENT '学号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `major` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `klass` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` bit(1) NULL DEFAULT NULL COMMENT '0是女，1是男',
  `email` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fkstutou`(`studentId`) USING BTREE,
  CONSTRAINT `fkstutou` FOREIGN KEY (`studentId`) REFERENCES `user` (`userCode`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 5, '学生A', '软件工程', '大二', '0202151025', b'1', '12315');
INSERT INTO `student` VALUES (2, 4, '学生B', '材料科学', '大三', '12321541', b'0', '4534');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `teacherId` int(10) UNSIGNED NOT NULL COMMENT '职工号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `institute` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `office` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '办公室',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` bit(1) NULL DEFAULT NULL COMMENT '性别',
  `email` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fkthertou`(`teacherId`) USING BTREE,
  CONSTRAINT `fkthertou` FOREIGN KEY (`teacherId`) REFERENCES `user` (`userCode`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 1, '洪俐', '计算机学院', '厚德楼8楼', '15362143070', b'1', NULL);
INSERT INTO `teacher` VALUES (2, 2, 'admin', '材料与食品学院', '树德楼', '0000002222', b'1', NULL);
INSERT INTO `teacher` VALUES (3, 3, '黎小明', '计算机学院', '厚德楼802', '001020202', b'1', NULL);

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `groupId` int(60) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '团队编号',
  `studentId` int(10) UNSIGNED NOT NULL COMMENT '队长学号',
  `teacherName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指导老师',
  `teamRole` int(1) UNSIGNED NOT NULL COMMENT '0表示个人报名，1表示团体报名',
  `state` int(1) UNSIGNED NULL DEFAULT NULL COMMENT '审核状态,0为等待审核,1为通过审核,2为审核不通过',
  `itemId` int(10) UNSIGNED NOT NULL COMMENT '报名的项目',
  PRIMARY KEY (`groupId`) USING BTREE,
  INDEX `fkteamtostu`(`studentId`) USING BTREE,
  INDEX `fkteamtoit`(`itemId`) USING BTREE,
  CONSTRAINT `fkteamtostu` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fkteamtoit` FOREIGN KEY (`itemId`) REFERENCES `item` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '报名的的项目' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for teaminfo
-- ----------------------------
DROP TABLE IF EXISTS `teaminfo`;
CREATE TABLE `teaminfo`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `groupId` int(60) UNSIGNED NOT NULL,
  `studentId` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fkt_t1`(`groupId`) USING BTREE,
  INDEX `fktinfotostu`(`studentId`) USING BTREE,
  CONSTRAINT `fktinfotostu` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fkt_t1` FOREIGN KEY (`groupId`) REFERENCES `team` (`groupId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userCode` int(10) UNSIGNED NOT NULL COMMENT '用户码(学号或职工号登录)',
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '0是老师，1是学生',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userCode`(`userCode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 5, '123456', 0);
INSERT INTO `user` VALUES (2, 1, '123456', 0);
INSERT INTO `user` VALUES (3, 2, '123456', 0);
INSERT INTO `user` VALUES (4, 3, '123456', 1);
INSERT INTO `user` VALUES (5, 4, '123456', 1);

SET FOREIGN_KEY_CHECKS = 1;
