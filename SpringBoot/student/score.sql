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

 Date: 12/11/2025 20:53:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `subjects` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time_start` datetime NULL DEFAULT NULL,
  `time_end` datetime NULL DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, 'Excepteur veniam in incididunt', '2026-06-10 09:20:22', '2025-06-30 17:37:18', '91', 'Lorem qui fugiat', 'sit velit aliquip');
INSERT INTO `score` VALUES (2, 'quis esse', '2025-01-10 15:36:33', '2026-10-21 15:29:02', '69', 'ut laboris mollit magna', 'occaecat amet qui esse');
INSERT INTO `score` VALUES (3, 'magna', '2026-02-18 00:05:26', '2025-01-31 15:31:09', '83', 'aute ullamco', 'ut pariatur fugiat magna');
INSERT INTO `score` VALUES (4, 'ea non consequat nostrud', '2025-03-30 07:19:41', '2025-10-13 10:55:16', '20', 'do in nisi', 'est magna ea');
INSERT INTO `score` VALUES (5, 'ea non consequat nostrud', '2025-03-30 07:19:41', '2025-10-13 10:55:16', '20', 'do in nisi', 'est magna ea');
INSERT INTO `score` VALUES (6, 'math', '2025-03-15 09:00:00', '2025-03-15 11:00:00', 'S001', '92', 'Li Ming');
INSERT INTO `score` VALUES (7, 'math', '2025-03-15 09:00:00', '2025-03-15 11:00:00', 'S002', '88', 'Li Ming');
INSERT INTO `score` VALUES (8, 'math', '2025-03-15 09:00:00', '2025-03-15 11:00:00', 'S003', '85', 'Li Ming');
INSERT INTO `score` VALUES (9, 'math', '2025-03-15 09:00:00', '2025-03-15 11:00:00', 'S004', '81', 'Li Ming');
INSERT INTO `score` VALUES (10, 'math', '2025-03-15 09:00:00', '2025-03-15 11:00:00', 'S005', '78', 'Li Ming');
INSERT INTO `score` VALUES (11, 'math', '2025-03-15 09:00:00', '2025-03-15 11:00:00', 'S006', '75', 'Li Ming');
INSERT INTO `score` VALUES (12, 'math', '2025-03-15 09:00:00', '2025-03-15 11:00:00', 'S007', '73', 'Li Ming');
INSERT INTO `score` VALUES (13, 'math', '2025-03-15 09:00:00', '2025-03-15 11:00:00', 'S008', '70', 'Li Ming');
INSERT INTO `score` VALUES (14, 'math', '2025-06-18 09:00:00', '2025-06-18 11:00:00', 'S001', '95', 'Li Ming');
INSERT INTO `score` VALUES (15, 'math', '2025-06-18 09:00:00', '2025-06-18 11:00:00', 'S002', '90', 'Li Ming');
INSERT INTO `score` VALUES (16, 'math', '2025-06-18 09:00:00', '2025-06-18 11:00:00', 'S003', '87', 'Li Ming');
INSERT INTO `score` VALUES (17, 'math', '2025-06-18 09:00:00', '2025-06-18 11:00:00', 'S004', '85', 'Li Ming');
INSERT INTO `score` VALUES (18, 'math', '2025-06-18 09:00:00', '2025-06-18 11:00:00', 'S005', '80', 'Li Ming');
INSERT INTO `score` VALUES (19, 'math', '2025-06-18 09:00:00', '2025-06-18 11:00:00', 'S006', '78', 'Li Ming');
INSERT INTO `score` VALUES (20, 'math', '2025-06-18 09:00:00', '2025-06-18 11:00:00', 'S007', '74', 'Li Ming');
INSERT INTO `score` VALUES (21, 'math', '2025-06-18 09:00:00', '2025-06-18 11:00:00', 'S008', '72', 'Li Ming');
INSERT INTO `score` VALUES (22, 'math', '2025-06-18 09:00:00', '2025-06-18 11:00:00', 'S009', '68', 'Li Ming');
INSERT INTO `score` VALUES (23, 'english', '2025-03-17 14:00:00', '2025-03-17 16:00:00', 'S001', '86', 'Wang Fang');
INSERT INTO `score` VALUES (24, 'english', '2025-03-17 14:00:00', '2025-03-17 16:00:00', 'S002', '90', 'Wang Fang');
INSERT INTO `score` VALUES (25, 'english', '2025-03-17 14:00:00', '2025-03-17 16:00:00', 'S003', '84', 'Wang Fang');
INSERT INTO `score` VALUES (26, 'english', '2025-03-17 14:00:00', '2025-03-17 16:00:00', 'S004', '80', 'Wang Fang');
INSERT INTO `score` VALUES (27, 'english', '2025-03-17 14:00:00', '2025-03-17 16:00:00', 'S005', '76', 'Wang Fang');
INSERT INTO `score` VALUES (28, 'english', '2025-03-17 14:00:00', '2025-03-17 16:00:00', 'S006', '74', 'Wang Fang');
INSERT INTO `score` VALUES (29, 'english', '2025-03-17 14:00:00', '2025-03-17 16:00:00', 'S007', '71', 'Wang Fang');
INSERT INTO `score` VALUES (30, 'english', '2025-03-17 14:00:00', '2025-03-17 16:00:00', 'S008', '69', 'Wang Fang');
INSERT INTO `score` VALUES (31, 'english', '2025-06-20 14:00:00', '2025-06-20 16:00:00', 'S001', '88', 'Wang Fang');
INSERT INTO `score` VALUES (32, 'english', '2025-06-20 14:00:00', '2025-06-20 16:00:00', 'S002', '92', 'Wang Fang');
INSERT INTO `score` VALUES (33, 'english', '2025-06-20 14:00:00', '2025-06-20 16:00:00', 'S003', '85', 'Wang Fang');
INSERT INTO `score` VALUES (34, 'english', '2025-06-20 14:00:00', '2025-06-20 16:00:00', 'S004', '82', 'Wang Fang');
INSERT INTO `score` VALUES (35, 'english', '2025-06-20 14:00:00', '2025-06-20 16:00:00', 'S005', '79', 'Wang Fang');
INSERT INTO `score` VALUES (36, 'english', '2025-06-20 14:00:00', '2025-06-20 16:00:00', 'S006', '77', 'Wang Fang');
INSERT INTO `score` VALUES (37, 'english', '2025-06-20 14:00:00', '2025-06-20 16:00:00', 'S007', '73', 'Wang Fang');
INSERT INTO `score` VALUES (38, 'english', '2025-06-20 14:00:00', '2025-06-20 16:00:00', 'S008', '70', 'Wang Fang');
INSERT INTO `score` VALUES (39, 'physics', '2025-04-10 09:00:00', '2025-04-10 11:00:00', 'S001', '89', 'Zhao Qiang');
INSERT INTO `score` VALUES (40, 'physics', '2025-04-10 09:00:00', '2025-04-10 11:00:00', 'S002', '85', 'Zhao Qiang');
INSERT INTO `score` VALUES (41, 'physics', '2025-04-10 09:00:00', '2025-04-10 11:00:00', 'S003', '83', 'Zhao Qiang');
INSERT INTO `score` VALUES (42, 'physics', '2025-04-10 09:00:00', '2025-04-10 11:00:00', 'S004', '79', 'Zhao Qiang');
INSERT INTO `score` VALUES (43, 'physics', '2025-04-10 09:00:00', '2025-04-10 11:00:00', 'S005', '75', 'Zhao Qiang');
INSERT INTO `score` VALUES (44, 'physics', '2025-04-10 09:00:00', '2025-04-10 11:00:00', 'S006', '72', 'Zhao Qiang');
INSERT INTO `score` VALUES (45, 'physics', '2025-04-10 09:00:00', '2025-04-10 11:00:00', 'S007', '68', 'Zhao Qiang');
INSERT INTO `score` VALUES (46, 'physics', '2025-04-10 09:00:00', '2025-04-10 11:00:00', 'S008', '65', 'Zhao Qiang');
INSERT INTO `score` VALUES (47, 'physics', '2025-07-12 09:00:00', '2025-07-12 11:00:00', 'S001', '91', 'Zhao Qiang');
INSERT INTO `score` VALUES (48, 'physics', '2025-07-12 09:00:00', '2025-07-12 11:00:00', 'S002', '87', 'Zhao Qiang');
INSERT INTO `score` VALUES (49, 'physics', '2025-07-12 09:00:00', '2025-07-12 11:00:00', 'S003', '86', 'Zhao Qiang');
INSERT INTO `score` VALUES (50, 'physics', '2025-07-12 09:00:00', '2025-07-12 11:00:00', 'S004', '82', 'Zhao Qiang');
INSERT INTO `score` VALUES (51, 'physics', '2025-07-12 09:00:00', '2025-07-12 11:00:00', 'S005', '78', 'Zhao Qiang');
INSERT INTO `score` VALUES (52, 'physics', '2025-07-12 09:00:00', '2025-07-12 11:00:00', 'S006', '74', 'Zhao Qiang');
INSERT INTO `score` VALUES (53, 'physics', '2025-07-12 09:00:00', '2025-07-12 11:00:00', 'S007', '70', 'Zhao Qiang');
INSERT INTO `score` VALUES (54, 'physics', '2025-07-12 09:00:00', '2025-07-12 11:00:00', 'S008', '67', 'Zhao Qiang');
INSERT INTO `score` VALUES (55, 'physics', '2025-07-12 09:00:00', '2025-07-12 11:00:00', 'S009', '63', 'Zhao Qiang');

SET FOREIGN_KEY_CHECKS = 1;
