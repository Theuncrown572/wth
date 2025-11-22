/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80042
 Source Host           : localhost:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 80042
 File Encoding         : 65001

 Date: 12/11/2025 20:53:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `subjects` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sid` int NULL DEFAULT NULL,
  `zone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `IDNum` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '理国珍', 'quis aliqua', 'dolore', '女', 32, 'ullamco minim amet', '刑旁8943号', '003 4682 4116', 11);
INSERT INTO `student` VALUES (2, '俟燕', 'et', 'id', '男', 81, 'proident dolor reprehenderit est qui', '印桥7884号', '063 2818 7583', 3);
INSERT INTO `student` VALUES (3, '叔军', 'in nisi', 'mollit laborum minim veniam', '男', 91, 'minim sunt aliqua reprehenderit', '祭巷28号', '33991262443', 29);
INSERT INTO `student` VALUES (4, '禚梓馨', 'consequat ad', 'sed', '女', 97, 'Ut', '乜侬61724号', '51727098339', 62);
INSERT INTO `student` VALUES (5, '愚勇', 'ex adipisicing laboris cillum consequat', 'tempor', '女', 42, 'in officia', '单街26261号', '68799487066', 50);
INSERT INTO `student` VALUES (6, '霍馨羽', 'incididunt magna esse', 'occaecat sed incididunt Lorem culpa', '女', 72, 'sint tempor in minim', '和旁65958号', '19669936870', 24);
INSERT INTO `student` VALUES (7, '陶艳', NULL, 'nulla adipisicing', '女', 75, 'pariatur dolor qui ipsum dolor', '屠路31号', '18260920734', 18);
INSERT INTO `student` VALUES (8, '千瑜', 'aliquip exercitation ut amet', 'consectetur culpa eu dolore', '女', 49, 'Duis', '熊巷51603号', '12370981668', 40);
INSERT INTO `student` VALUES (9, '蹉国香', 'commodo consequat nisi aliquip', 'aliqua et nulla', '女', 2, 'labore pariatur culpa est aute', '冒侬95号', '03487055853', 15);

SET FOREIGN_KEY_CHECKS = 1;
