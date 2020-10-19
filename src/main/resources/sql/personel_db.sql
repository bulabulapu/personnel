/*
 Navicat MySQL Data Transfer

 Source Server         : localhost_mysql
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : personel_db

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 19/10/2020 16:13:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adminName` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adminPWord` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('000000', 'Tom', '123456');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `deId` int(11) NOT NULL,
  `deName` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`deId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1000, '销售部');
INSERT INTO `department` VALUES (1001, '无线部');
INSERT INTO `department` VALUES (1002, '行政部');
INSERT INTO `department` VALUES (1003, '企信部');
INSERT INTO `department` VALUES (1004, '人力资源部');
INSERT INTO `department` VALUES (1005, '伙食部');
INSERT INTO `department` VALUES (1006, '后勤部');

-- ----------------------------
-- Table structure for departtransfer
-- ----------------------------
DROP TABLE IF EXISTS `departtransfer`;
CREATE TABLE `departtransfer`  (
  `deTrId` int(11) NOT NULL AUTO_INCREMENT,
  `staffId` int(11) NULL DEFAULT NULL,
  `newDepart` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `oldDepart` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `deType` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `deReson` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `deRemark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `deDate` date NOT NULL,
  PRIMARY KEY (`deTrId`) USING BTREE,
  INDEX `FK_departTransfer`(`staffId`) USING BTREE,
  CONSTRAINT `FK_departTransfer` FOREIGN KEY (`staffId`) REFERENCES `staff` (`staffId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of departtransfer
-- ----------------------------
INSERT INTO `departtransfer` VALUES (4, 2019256109, '行政部', '无线部', '主动调动', '升职', '无', '2020-10-29');

-- ----------------------------
-- Table structure for dimission
-- ----------------------------
DROP TABLE IF EXISTS `dimission`;
CREATE TABLE `dimission`  (
  `dimId` int(11) NOT NULL AUTO_INCREMENT,
  `staffId` int(11) NULL DEFAULT NULL,
  `dimDate` date NOT NULL,
  `dimType` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dimDirection` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dimRemark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`dimId`) USING BTREE,
  INDEX `FK_staffLeave`(`staffId`) USING BTREE,
  CONSTRAINT `FK_staffLeave` FOREIGN KEY (`staffId`) REFERENCES `staff` (`staffId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dimission
-- ----------------------------
INSERT INTO `dimission` VALUES (10, 2016484484, '2020-10-25', '退休', '无', '无');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `poId` int(11) NOT NULL,
  `deId` int(11) NULL DEFAULT NULL,
  `poName` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`poId`) USING BTREE,
  INDEX `FK_departmentPost`(`deId`) USING BTREE,
  CONSTRAINT `FK_departmentPost` FOREIGN KEY (`deId`) REFERENCES `department` (`deId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (10001, 1000, '销售员');
INSERT INTO `post` VALUES (10002, 1000, '销售经理');
INSERT INTO `post` VALUES (10003, 1000, '销售主管');
INSERT INTO `post` VALUES (10010, 1001, '优化工程师');
INSERT INTO `post` VALUES (10011, 1001, '项目工程师');
INSERT INTO `post` VALUES (10020, 1002, '行政总监');
INSERT INTO `post` VALUES (10021, 1002, '部门助理');
INSERT INTO `post` VALUES (10022, 1002, '秘书');
INSERT INTO `post` VALUES (10030, 1003, '大数据开发工程师');
INSERT INTO `post` VALUES (10031, 1003, '部门经理');
INSERT INTO `post` VALUES (10040, 1004, '人力资源总监');
INSERT INTO `post` VALUES (10041, 1004, '招聘主管');

-- ----------------------------
-- Table structure for posttransfer
-- ----------------------------
DROP TABLE IF EXISTS `posttransfer`;
CREATE TABLE `posttransfer`  (
  `poTrId` int(11) NOT NULL AUTO_INCREMENT,
  `staffId` int(11) NULL DEFAULT NULL,
  `newPost` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `oldPost` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `poType` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `poReson` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `poRemark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `poDate` date NOT NULL,
  PRIMARY KEY (`poTrId`) USING BTREE,
  INDEX `FK_postTransfer`(`staffId`) USING BTREE,
  CONSTRAINT `FK_postTransfer` FOREIGN KEY (`staffId`) REFERENCES `staff` (`staffId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of posttransfer
-- ----------------------------
INSERT INTO `posttransfer` VALUES (12, 2019577334, '优化工程师', '项目工程师', '主动调动', '无', '无', '2020-10-24');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `staffId` int(11) NOT NULL,
  `poId` int(11) NULL DEFAULT NULL,
  `staffname` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` tinyint(1) NOT NULL,
  `birthday` date NOT NULL,
  `idCard` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `inDay` date NOT NULL,
  `workDay` date NOT NULL,
  `workType` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `source` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `political` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nation` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nativePlace` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `height` int(11) NULL DEFAULT NULL,
  `bloodType` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `marital` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthPlace` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `huKou` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `education` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `degree` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `major` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `graduationDate` date NULL DEFAULT NULL,
  PRIMARY KEY (`staffId`) USING BTREE,
  INDEX `FK_postStaff`(`poId`) USING BTREE,
  CONSTRAINT `FK_postStaff` FOREIGN KEY (`poId`) REFERENCES `post` (`poId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (2013211767, 10031, '王五', 1, '2020-10-10', '511000199901016462', '2020-10-18', '2020-10-18', '正式员工', '校园招聘', '其他', '汉族', '重庆市', '13562874933', '66666666@qq.com', 177, 'AB型', '已婚', '重庆市', '重庆市', '本科', '学士', '重庆邮电大学', '计算机科学与技术', '2020-10-24');
INSERT INTO `staff` VALUES (2015394202, 10020, '李信', 1, '2020-10-28', '511000199901016464', '2020-10-28', '2020-10-28', '正式员工', '校园招聘', '其他', '汉族', '重庆市', '13562874933', '9999999@qq.com', 169, 'A型', '未婚', '', '', '高中及以下', '无学位', '', '', NULL);
INSERT INTO `staff` VALUES (2016299384, 10003, '韩信', 1, '2020-10-14', '511000199901016222', '2020-10-15', '2020-10-15', '正式员工', '社会招聘', '预备党员', '汉族', '', '', '', 0, 'A型', '未婚', '', '', '高中及以下', '无学位', '', '', NULL);
INSERT INTO `staff` VALUES (2016484484, 10021, '吴某', 1, '2020-10-24', '511000199901016237', '2020-10-22', '2020-10-23', '离职员工', '校园招聘', '党员', '', '', '', '', 0, 'A型', '未婚', '', '', '高中及以下', '无学位', '', '', NULL);
INSERT INTO `staff` VALUES (2017082136, 10022, '李三', 1, '2020-10-02', '511000199901016464', '2020-10-04', '2020-10-04', '临时员工', '社会招聘', '团员', '', '', '', '', 0, 'A型', '未婚', '', '', '高中及以下', '无学位', '', '', NULL);
INSERT INTO `staff` VALUES (2017211212, 10011, '李四', 0, '2020-10-29', '511000199901016222', '2020-10-16', '2020-10-24', '正式员工', '社会招聘', '预备党员', '汉族', '重庆市', '13562874932', '66666666@qq.com', 182, 'A型', '未婚', '重庆市', '重庆市', '本科', '学士', '重庆邮电大学', '计算机科学与技术', '2020-10-09');
INSERT INTO `staff` VALUES (2017211926, 10001, '李瑞', 1, '1995-06-10', '511000199901016464', '2020-10-01', '2020-10-01', '正式员工', '校园招聘', '党员', '汉族', '重庆市', '13562874932', '', 0, 'A型', '未婚', '', '', '高中及以下', '学士', '', '', NULL);
INSERT INTO `staff` VALUES (2017211929, 10001, 'Jerry', 1, '1999-01-01', '511000199901016464', '2020-10-01', '2020-10-01', '正式员工', '校园招聘', '团员', '汉族', '重庆市', '1522222121', '66666666@qq.com', 166, 'O型', '未婚', '重庆市', '重庆市', '本科', '学士', '重庆邮电大学', '计算机科学与技术', '2020-09-29');
INSERT INTO `staff` VALUES (2017211930, 10010, '张山', 0, '2010-06-26', '51100019990213567', '2020-10-07', '2020-10-07', '正式员工', '校园招聘', '党员', '', '', '', '', 0, 'A型', '未婚', '', '', '高中及以下', '无学位', '', '', NULL);
INSERT INTO `staff` VALUES (2017234967, 10020, '李四', 1, '2020-10-18', '511000199901016462', '2020-10-18', '2020-10-18', '临时员工', '社会招聘', '团员', '汉族', '重庆市', '13562874932', '9999999@qq.com', 177, 'A型', '离婚', '重庆市', '重庆市', '研究生', '博士', '重庆邮电大学', '计算机科学与技术', '2020-10-28');
INSERT INTO `staff` VALUES (2018215596, 10030, '张三', 1, '2020-10-01', '511000199901016462', '2020-10-23', '2020-10-23', '临时员工', '其他', '预备党员', '汉族', '重庆市', '13562874933', '9999999@qq.com', 177, 'A型', '未婚', '重庆市', '重庆市', '研究生', '硕士', '重庆邮电大学', '计算机科学与技术', '2020-10-30');
INSERT INTO `staff` VALUES (2019256109, 10020, '赵信', 1, '2020-10-18', '511000199901016462', '2020-10-11', '2020-10-18', '临时员工', '社会招聘', '预备党员', '汉族', '重庆市', '13562874933', '', 0, 'A型', '未婚', '', '', '高中及以下', '无学位', '', '', NULL);
INSERT INTO `staff` VALUES (2019577334, 10010, '张某', 1, '2020-10-23', '511000199901016222', '2020-10-24', '2020-10-24', '正式员工', '校园招聘', '党员', '', '', '', '', 0, 'A型', '未婚', '', '', '高中及以下', '无学位', '', '', NULL);

SET FOREIGN_KEY_CHECKS = 1;
