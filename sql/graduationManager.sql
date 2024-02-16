/*
 Navicat MySQL Data Transfer

 Source Server         : ali
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 60.205.187.211:3306
 Source Schema         : graduationManager

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 10/03/2022 15:37:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键,管理员id',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,用户id',
  PRIMARY KEY (`admin_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表，\r\n' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '30001');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `class_id` int NOT NULL,
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `subject_id` int NOT NULL,
  PRIMARY KEY (`class_id`) USING BTREE,
  INDEX `class_ibfk_1`(`subject_id`) USING BTREE,
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '2020级计算机科学技术', 1);
INSERT INTO `class` VALUES (2, '2020级电子信息', 2);
INSERT INTO `class` VALUES (3, '2020级人工智能', 3);
INSERT INTO `class` VALUES (4, '2020级数据分析', 4);

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `dept_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,部门id',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门科室名',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '计算机科学教研室');
INSERT INTO `dept` VALUES (2, '大数据教研室');
INSERT INTO `dept` VALUES (3, '数字媒体技术教研室');
INSERT INTO `dept` VALUES (4, '广播电视工程教研室');

-- ----------------------------
-- Table structure for down
-- ----------------------------
DROP TABLE IF EXISTS `down`;
CREATE TABLE `down`  (
  `down_id` int NOT NULL AUTO_INCREMENT COMMENT '公共资源下载',
  `down_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源标题',
  `down_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源下载地址',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `admin_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,管理员id',
  PRIMARY KEY (`down_id`) USING BTREE,
  INDEX `admin_id`(`admin_id`) USING BTREE,
  CONSTRAINT `down_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件下载' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of down
-- ----------------------------
INSERT INTO `down` VALUES (1, '免答辩申请表.docx', '免答辩申请表.docx', '2018-03-24 21:23:15', '1');
INSERT INTO `down` VALUES (2, '中期检查表', '中期检查表.docx', '2018-03-25 17:15:39', '1');
INSERT INTO `down` VALUES (3, '开题报告表', '开题报告.docx', '2018-03-25 17:16:10', '1');
INSERT INTO `down` VALUES (4, '论文要求说明', '', '2018-03-25 17:16:47', '1');
INSERT INTO `down` VALUES (5, '2018届毕业设计（论文）完成情况评价表（新）.doc', '', '2018-03-25 17:17:19', '1');
INSERT INTO `down` VALUES (6, '2018届毕业设计开题报告完成情况统计.xlsx', '', '2018-03-25 17:17:42', '1');
INSERT INTO `down` VALUES (7, 'Javascript参考手册.chm', '', '2018-03-25 17:18:09', '1');
INSERT INTO `down` VALUES (8, 'J2EE_1.6_API.chm', '', '2018-03-25 17:18:30', '1');

-- ----------------------------
-- Table structure for inform
-- ----------------------------
DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform`  (
  `inform_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,通知公告id',
  `inform_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通知公告标题',
  `inform_body` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通知公告主体',
  `is_attachment` int NULL DEFAULT 0 COMMENT '是否有附件(0否1有)',
  `attachment_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件地址',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `admin_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,管理员id',
  PRIMARY KEY (`inform_id`) USING BTREE,
  INDEX `admin_id`(`admin_id`) USING BTREE,
  CONSTRAINT `inform_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`admin_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of inform
-- ----------------------------
INSERT INTO `inform` VALUES (1, '信息技术学院2018届本科毕业设计答辩工作安排说明', '<html><head><meta http-equiv=Content-Type content=\"text/html; charset=gb2312\"><meta name=Generator content=\"Microsoft Word 15 (filtered)\"><style></style></head><body lang=ZH-CN style=\'text-justify-trim:punctuation\'><div class=WordSection1 style=\'layout-grid:15.6pt\'><p class=MsoNormal align=center style=\'text-align:center\'><spanstyle=\'font-size:16.0pt;font-family:宋体\'>信息技术学院</span><span lang=EN-USstyle=\'font-size:16.0pt\'>2018</span><span style=\'font-size:16.0pt;font-family:宋体\'>届本科毕业设计答辩</span></p><p class=MsoNormal align=center style=\'text-align:center\'><spanstyle=\'font-size:16.0pt;font-family:宋体\'>工作安排说明</span></p><p class=MsoNormal align=center style=\'text-align:center\'><span lang=EN-USstyle=\'font-size:16.0pt\'>&nbsp;</span></p><p class=MsoNormal align=left style=\'text-align:left\'><span lang=EN-US>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><spanstyle=\'font-size:12.0pt;font-family:宋体\'>一、本科毕业设计答辩时间</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>校内：<span lang=EN-US>2018</span>年<span lang=EN-US>5</span>月<span lang=EN-US>5</span>日</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>校外：<span lang=EN-US>2018</span>年<span lang=EN-US>5</span>月<span lang=EN-US>10</span>日</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>&nbsp;</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>二、</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>答辩前准备</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>1</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>、<span lang=EN-US>2018</span>年<span lang=EN-US>5</span>月<spanlang=EN-US>3</span>日</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>2018</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>年<span lang=EN-US>5</span>月<span lang=EN-US>3</span>日上午，在行政办<spanlang=EN-US>510</span>房间，给每位指导老师发放档案袋，每个毕业生一个<span lang=EN-US>,</span>请老师们届时领取。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>请指导老师填写档案袋封皮的如下基本信息：</span></p><table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0 width=568 style=\'border-collapse:collapse;border:none\'><tr><td width=568 valign=top style=\'width:426.1pt;border:solid windowtext 1.0pt;  padding:0cm 5.4pt 0cm 5.4pt\'><p class=MsoNormal align=left style=\'text-align:left;text-indent:32.0pt;  line-height:150%\'><span style=\'font-size:16.0pt;line-height:150%;font-family:  黑体\'>信息技术学院<span lang=EN-US>2018</span>届本科毕业设计材料清单</span></p><p class=MsoNormal align=left style=\'text-align:left;line-height:150%\'><span  style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>指导教师<span  lang=EN-US>________</span>职称<span lang=EN-US>__________</span></span></p><p class=MsoNormal align=left style=\'text-align:left;line-height:150%\'><span  style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>学生姓名<span  lang=EN-US>________&nbsp;</span>学号<span lang=EN-US>_____&nbsp;&nbsp;</span>专业<span  lang=EN-US>_____&nbsp;&nbsp;&nbsp;</span>班级<span lang=EN-US>_______</span></span></p></td></tr></table><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>并收齐每个学生档案袋的如下内容：</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（1）</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>开题报告；</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（2）</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>中期检查表；</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（3）</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>毕业论文教师指导记录；</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（4）</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>系统验收报告；</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（5）</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>答辩申请书；</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（6）</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>论文；</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（7）</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>论文复制比检测报告（导师签字，总文字复制比</span><span lang=EN-USstyle=\'font-size:12.0pt;line-height:150%;font-family:\"Arial\",sans-serif\'>≤</span><spanlang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>25%</span><spanstyle=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>）；</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（8）</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>答辩评定表（正确填写基本信息：姓名、专业、学号，<span lang=EN-US>...</span>等，指导教师职称）；</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>2</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>、<span lang=EN-US>2018</span>年<span lang=EN-US>5</span>月<spanlang=EN-US>4</span>日</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（<span lang=EN-US>1</span>）请指导老师于<span lang=EN-US>2018</span>年<spanlang=EN-US>5</span>月<span lang=EN-US>4</span>日上午<span lang=EN-US>12:00</span>之前，将上述收齐内容，以及<b>《毕业设计》（封面）（包括已经签字的作者声明）（<spanlang=EN-US>2</span>份）</b>放入的档案袋，交到行政办<span lang=EN-US>510</span>房间。并将每个学生的论文电子稿<spanlang=EN-US>+</span>系统（包括执行程序和源程序）打包发给邮箱：<span lang=EN-US>1207297849@qq.com</span>。如有答辩时答辩组提出修改的论文，指导教师把纸质稿按照第四条要求交于办公室，替换资料袋相应材料，同时发送电子稿。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（<span lang=EN-US>2</span>）请各答辩组组长，于<span lang=EN-US>2018</span>年<spanlang=EN-US>5</span>月<span lang=EN-US>4</span>日下午<span lang=EN-US>16:00-18:00</span>之间，到行政办<spanlang=EN-US>510</span>房间领取答辩档案袋，以及《毕业论文<span lang=EN-US>(</span>设计）评价标准》和《毕业论文（设计）评分标准》；</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（<span lang=EN-US>3</span>）请各答辩组组长，提前准备《本科学生毕业论文成绩汇总表》。</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>三、</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>答辩</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>请各答辩小组按教务处文件精神认真答辩，维持答辩的严肃性，认真填写答辩记录及答辩成绩，并填写《本科学生毕业论文成绩汇总表》（纸质和电子稿）交于办公室。</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>四、</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>答辩后要求</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（<span lang=EN-US>1</span>）答辩之后，请各答辩组将学生的档案袋，以及成绩汇总表（纸质和电子稿）交到行政办<spanlang=EN-US>510</span>房间。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（<span lang=EN-US>2</span>）对于个别特别需要修改的论文，请指导老师按照答辩修改意见，于<span lang=EN-US>5</span>月<spanlang=EN-US>7</span>、<span lang=EN-US>8</span>日以及<span lang=EN-US>9</span>日上午<spanlang=EN-US>12:00</span>之前，到行政办<span lang=EN-US>510</span>房间更换论文。并于<spanlang=EN-US>2018</span>年<span lang=EN-US>5</span>月<span lang=EN-US>9</span>日<spanlang=EN-US>12:00</span>之前，将最终稿的每个学生的论文电子稿<span lang=EN-US>+</span>系统（包括执行程序和源程序）打包发给邮箱：<spanlang=EN-US>1207297849@qq.com</span>。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>&nbsp;</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>&nbsp;</span></p><p class=MsoNormal align=left style=\'margin-left:21.0pt;text-align:left;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>&nbsp;</span></p><p class=MsoNormal align=left style=\'text-align:left\'><span lang=EN-USstyle=\'font-size:12.0pt;font-family:宋体\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><spanstyle=\'font-size:12.0pt;font-family:宋体\'>信息技术学院</span></p><p class=MsoNormal><span lang=EN-US style=\'font-size:12.0pt;font-family:宋体\'>&nbsp;</span></p><p class=MsoNormal align=left style=\'text-align:left\'><span lang=EN-USstyle=\'font-size:12.0pt;font-family:宋体\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2018</span><spanstyle=\'font-size:12.0pt;font-family:宋体\'>年<span lang=EN-US>4</span>月<spanlang=EN-US>26</span>日</span></p></div></body></html>', 0, NULL, '2018-04-26 21:25:13', '1');
INSERT INTO `inform` VALUES (2, '关于对2018届本科毕业设计(论文)进行系统验收的通知', '<p><span class=\"STYLE1\" data-filtered=\"filtered\"></span></p><p class=\"MsoNormal\">	各学院：<span></span></p><p class=\"MsoNormal\">	<span>&nbsp; &nbsp; &nbsp;为了加强毕业设计（论文）工作的管理，提高毕业设计（论文）质量，根据《洛阳师范学院毕业设计（论文）工作规定》的要求，</span><a name=\"undefined\"></a><a name=\"undefined\"></a><span>学院须进行</span><span>2018</span><span>届本科毕业设计（论文）的系统验收和自查工作。教务处将联合教学质量监控与评估中心对系统验收情况进行检查（具体安排另行通知）。现将本次检查相关事宜通知如下：</span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	一、检查内容<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	1．教师下达任务书、学生的系统验收报告等毕业设计（论文）前期工作；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	2．学生课题落实情况，如课题大小、难度是否合适，与专业是否吻合，课题类型及软、硬件比例是否合适等；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	3．指导教师指导的情况，指导教师意见填写是否详细、具体，进度安排是否合理等；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	4．毕业设计（论文）工作的管理情况，包括前期动员、教学条件提供、教学管理工作中发现问题的解决情况；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	5．在校外进行毕业设计（论文）学生的比例是否合理、手续是否齐全、管理是否完善等；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	6. 优秀毕业设计（论文）培育情况。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	二、检查安排及要求<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	本次检查分学院自查和学校抽查两个阶段进行。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	第一阶段：学院自查<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	学院毕业设计（论文）领导小组负责组织对本学院毕业设计（论文）系统验收工作进行全面自查，学院自查时要将工作检查落到实处，切勿流于形式，走过场，真正起到检查与督促的作用，保证质量。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	自查时间为<span>3</span>月<span>9</span>日前。</p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	第二阶段：学校抽查<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	1．专家通过毕业设计（论文）系统抽查部分学生（<span>30%</span>左右）任务书、系统验收报告；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	2．专家听取学院关于学生毕业设计（论文）管理情况的汇报，请学院分管领导针对检查内容准备<span>10</span>分钟左右的汇报材料。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	<br data-filtered=\"filtered\"></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	请各学院积极配合，确保本次毕业设计（论文）系统验收检查工作顺利进行。<span></span></p><p>	<br data-filtered=\"filtered\"></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;2018年<span>4</span>月<span>06</span>日</p><br data-filtered=\"filtered\"><p></p></td>', 0, NULL, '2018-04-06 15:45:28', '1');
INSERT INTO `inform` VALUES (3, '关于对2018届本科毕业设计(论文)进行中期检查的通知', '<p><span class=\"STYLE1\" data-filtered=\"filtered\"></span></p><p class=\"MsoNormal\">	各学院：<span></span></p><p class=\"MsoNormal\">	<span>&nbsp; &nbsp; &nbsp;为了加强毕业设计（论文）工作的管理，提高毕业设计（论文）质量，根据《洛阳师范学院毕业设计（论文）工作规定》的要求，</span><a name=\"undefined\"></a><a name=\"undefined\"></a><span>学院须进行</span><span>2018</span><span>届本科毕业设计（论文）的中期检查工作。教务处将联合教学质量监控与评估中心对开题情况进行检查（具体安排另行通知）。现将本次检查相关事宜通知如下：</span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	一、检查内容<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	1．学生的中期检查等毕业设计（论文）前期工作；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	2．学生课题落实情况，如课题大小、难度是否合适，与专业是否吻合，课题类型及软、硬件比例是否合适等；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	3．指导教师指导的情况，指导教师意见填写是否详细、具体，进度安排是否合理等；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	4．毕业设计（论文）工作的管理情况，包括前期动员、教学条件提供、教学管理工作中发现问题的解决情况；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	5．在校外进行毕业设计（论文）学生的比例是否合理、手续是否齐全、管理是否完善等；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	6. 优秀毕业设计（论文）培育情况。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	二、检查安排及要求<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	本次检查分学院自查和学校抽查两个阶段进行。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	第一阶段：学院自查<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	学院毕业设计（论文）领导小组负责组织对本学院毕业设计（论文）中期检查进行全面自查，学院自查时要将工作检查落到实处，切勿流于形式，走过场，真正起到检查与督促的作用，保证质量。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	自查时间为<span>3</span>月<span>9</span>日前。</p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	第二阶段：学校抽查<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	1．专家通过毕业设计（论文）系统抽查部分学生中期检查；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	2．专家听取学院关于学生毕业设计（论文）管理情况的汇报，请学院分管领导针对检查内容准备<span>10</span>分钟左右的汇报材料。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	<br data-filtered=\"filtered\"></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	请各学院积极配合，确保本次毕业设计（论文）中期检查检查工作顺利进行。<span></span></p><p>	<br data-filtered=\"filtered\"></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;2018年<span>3</span>月<span>25</span>日</p><br data-filtered=\"filtered\"><p></p></td>', 0, NULL, '2018-03-25 15:46:00', '1');
INSERT INTO `inform` VALUES (4, '关于对2018届本科毕业设计(论文)进行开题报告检查的通知', '<p><span class=\"STYLE1\" data-filtered=\"filtered\"></span></p><p class=\"MsoNormal\">	各学院：<span></span></p><p class=\"MsoNormal\">	<span>&nbsp; &nbsp; &nbsp;为了加强毕业设计（论文）工作的管理，提高毕业设计（论文）质量，根据《洛阳师范学院毕业设计（论文）工作规定》的要求，</span><a name=\"undefined\"></a><a name=\"undefined\"></a><span>学院须进行</span><span>2018</span><span>届本科毕业设计（论文）的开题报告检查工作。教务处将联合教学质量监控与评估中心对开题情况进行检查（具体安排另行通知）。现将本次检查相关事宜通知如下：</span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	一、检查内容<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	1．学生的开题报告等毕业设计（论文）前期工作；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	2．学生课题落实情况，如课题大小、难度是否合适，与专业是否吻合，课题类型及软、硬件比例是否合适等；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	3．指导教师指导的情况，指导教师意见填写是否详细、具体，进度安排是否合理等；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	4．毕业设计（论文）工作的管理情况，包括前期动员、教学条件提供、教学管理工作中发现问题的解决情况；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	5．在校外进行毕业设计（论文）学生的比例是否合理、手续是否齐全、管理是否完善等；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	6. 优秀毕业设计（论文）培育情况。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	二、检查安排及要求<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	本次检查分学院自查和学校抽查两个阶段进行。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	第一阶段：学院自查<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	学院毕业设计（论文）领导小组负责组织对本学院毕业设计（论文）开题报告进行全面自查，学院自查时要将工作检查落到实处，切勿流于形式，走过场，真正起到检查与督促的作用，保证质量。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	自查时间为<span>3</span>月<span>9</span>日前。</p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	第二阶段：学校抽查<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	1．专家通过毕业设计（论文）系统抽查部分学生开题报告；<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	2．专家听取学院关于学生毕业设计（论文）管理情况的汇报，请学院分管领导针对检查内容准备<span>10</span>分钟左右的汇报材料。<span></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	<br data-filtered=\"filtered\"></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	请各学院积极配合，确保本次毕业设计（论文）开题报告检查工作顺利进行。<span></span></p><p>	<br data-filtered=\"filtered\"></p><p class=\"MsoNormal\" style=\"text-indent:32.0pt;\">	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;2018年<span>2</span>月<span>23</span>日</p><br data-filtered=\"filtered\"><p></p></td>', 0, NULL, '2018-02-23 15:46:25', '1');
INSERT INTO `inform` VALUES (5, '信息技术学院2018届本科毕业设计工作安排', '<html><head><meta http-equiv=Content-Type content=\"text/html; charset=gb2312\"><meta name=Generator content=\"Microsoft Word 15 (filtered)\"><style></style></head><body lang=ZH-CN style=\'text-justify-trim:punctuation\'><div class=WordSection1 style=\'layout-grid:15.6pt\'><p class=MsoNormal align=center style=\'text-align:center\'><spanstyle=\'font-size:16.0pt;font-family:宋体\'>信息技术学院</span><span lang=EN-USstyle=\'font-size:16.0pt\'>2018</span><span style=\'font-size:16.0pt;font-family:宋体\'>届本科毕业设计工作安排</span></p><p class=MsoNormal align=left style=\'text-align:left\'><span lang=EN-US>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><spanstyle=\'font-size:12.0pt;font-family:宋体\'>一、本科毕业设计工作领导小组</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>张瑞玲（组长） 李元臣（副组长）</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>组员：蒋胜利 马友忠 王燕玲 王听忠 刘栋 匡春临 郭洪涛 周莉 张琰琰</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>二、时间安排</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（一）学习文件精神</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>2018</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>年<span lang=EN-US>1</span>月<span lang=EN-US>19</span>日前，领会教务处《关于做好<spanlang=EN-US>2018</span>届本科毕业论文（设计）工作的通知》（校教<span lang=EN-US>[2017]134</span>号）文件精神。</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（二）</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>开题检查</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>2018</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>年<span lang=EN-US>1</span>月<span lang=EN-US>26</span>日前，指导老师指导学生按新格式填写开题报告和指导记录（指导记录必须手写，指导时间段为<spanlang=EN-US>2017</span>年<span lang=EN-US>9</span>月下旬——<span lang=EN-US>2018</span>年<spanlang=EN-US>4</span>月，具体时间根据实际情况填写），完成后在指导老师处保存。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（三）中期检查</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>2018</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>年<span lang=EN-US>3</span>月<span lang=EN-US>15</span>日——<spanlang=EN-US>3</span>月<span lang=EN-US>20</span>日为中期检查阶段，指导老师要对学生的毕业设计工作进行中期检查，并如实填写中期检查表；为系统验收和论文的完成做好准备。完成后在指导老师处保存。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（四）系统验收</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>系统验收时间为<span lang=EN-US>2018</span>年<span lang=EN-US>3</span>月<spanlang=EN-US>26</span>日——<span lang=EN-US>3</span>月<span lang=EN-US>30</span>日，由验收组老师自主验收（验收老师分组另行通知），系统验收后填写《信息技术学院<spanlang=EN-US>2018</span>届毕业设计验收情况表》交予学生，各验收组教师严格把握验收时间，过期不再验收。验收不合格者不允许答辩，答辩当日学生将验收情况表交于答辩组老师，若无此表，不准参加答辩。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（五）论文检查</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>2018</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>年<span lang=EN-US>4</span>月<span lang=EN-US>9</span>日前学生要完成论文，交于指导老师检查、修改、定稿，准备盲审。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（六）盲审</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>2018</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>年<span lang=EN-US>4</span>月<span lang=EN-US>13</span>日——<spanlang=EN-US>17</span>日学生论文盲审（盲审老师及学生论文另行通知，<span lang=EN-US>4</span>月<spanlang=EN-US>9</span>日之前学生论文必须完成定稿）。需要修改者由指导老师指导按盲审专家意见修改，修改后论文仍不格者，不允许参加答辩。</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（七）</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>论文复制比检测</span></p><p class=MsoNormal align=left style=\'text-align:left;line-height:150%\'><spanlang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>&nbsp;&nbsp;&nbsp;</span><spanstyle=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>论文复制比检测时间暂定为<spanlang=EN-US>4</span>月<span lang=EN-US>23</span>日——<span lang=EN-US>26</span>日（具体时间以教务处开放时间为准）。经指导老师同意后学生才能进行论文复制比检测，论文的总文字复制比</span><spanlang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:\"Arial\",sans-serif\'>≤</span><spanlang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>25%</span><spanstyle=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>视为合格，可参加答辩，指导老师在检测报告（简洁版）上签字确认。首次检测总文字复制比<spanlang=EN-US>&lt;70%</span>的进行修改后可进行第二次检测，二次检测结果仍不达标的要进行延期答辩（指导教师要告知学生只有两次检测机会）；首次检测论文的总文字复制比</span><spanlang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:\"Arial\",sans-serif\'>≥70%</span><spanstyle=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>的直接取消答辩资格，不允许答辩，本学年毕业设计视为不合格</span><spanstyle=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>学生要在<span lang=EN-US>2018</span>年<span lang=EN-US>4</span>月<spanlang=EN-US>26</span>日之前完成所有<span lang=EN-US>2018</span>届本科毕业生毕业设计所要上交的材料，指导老师要对学生严格要求。</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（八）</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>答辩申请</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>2018</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>年<span lang=EN-US>4</span>月<span lang=EN-US>30</span>日前学生完成答辩申请，指导老师指导学生完成“答辩申请书”、“毕业论文（设计）作者声明”。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>（九）答辩</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>答辩拟定于<span lang=EN-US>2018</span>年<span lang=EN-US>5</span>月<spanlang=EN-US>5</span>日<span lang=EN-US>-6</span>日。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>答辩相关事项：</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>1、</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>学生答辩时要交给答辩组老师检查审核的材料：开题报告、中期检查、教师指导记录、系统验收报告、答辩申请书、论文复制比检测报告（导师签字）、答辩评定表（正确填写基本信息）。</span></p><p class=MsoNormal align=left style=\'text-align:left;text-indent:24.0pt;line-height:150%\'><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>答辩组老师对学生所有材料进行审核，所有的材料每项内容都要按要求填写且签字区都有签字才允许学生参加答辩；任何一项材料不合格者，均不允许学生参加答辩。</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>2、</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>答辩结束后，由答辩组老师上交本答辩组学生的开题报告、中期检查、教师指导记录、系统验收报告、答辩申请书、论文复制比检测报告、答辩评定表。</span></p><p class=MsoNormal align=left style=\'margin-left:0cm;text-align:left;text-indent:24.0pt;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>3、</span><span style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>答辩结束后，学生按答辩组老师的意见和要求修改论文，修改后的论文打印装订稿（“毕业设计作者声明”放到摘要前面）和所有电子版材料交于指导老师审核并与答辩现场的论文稿进行比对，经指导老师审核合格后由指导老师交到办公室。（上交时间另行通知）</span></p><p class=MsoNormal align=left style=\'margin-left:21.0pt;text-align:left;line-height:150%\'><span lang=EN-US style=\'font-size:12.0pt;line-height:150%;font-family:宋体\'>&nbsp;</span></p><p class=MsoNormal align=left style=\'text-align:left\'><span lang=EN-USstyle=\'font-size:12.0pt;font-family:宋体\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><spanstyle=\'font-size:12.0pt;font-family:宋体\'>信息技术学院</span></p><p class=MsoNormal><span lang=EN-US style=\'font-size:12.0pt;font-family:宋体\'>&nbsp;</span></p><p class=MsoNormal align=left style=\'text-align:left\'><span lang=EN-USstyle=\'font-size:12.0pt;font-family:宋体\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2018</span><spanstyle=\'font-size:12.0pt;font-family:宋体\'>年<span lang=EN-US>1</span>月<spanlang=EN-US>18</span>日</span></p></div></body></html>', 0, NULL, '2018-01-18 15:47:27', '1');
INSERT INTO `inform` VALUES (6, '关于开展2018届毕业设计(论文)工作的通知', '<p style=\"text-indent:32.0pt;\">	毕业设计（论文）是实现本科培养目标的重要实践性教学环节。为了进一步加强和规范毕业设计（论文）的管理工作，确保毕业设计（论文）质量，各学院应在认真总结2017届毕业设计（论文）工作的基础上，严格按《洛阳师范学院本科毕业设计（论文）工作规定》和各类型学生的培养方案，认真开展2018届毕业设计（论文）工作，并注意做好以下几点：<span></span></p><p align=\"left\" style=\"text-indent:31.35pt;\">	一、按毕业设计（论文）的工作进程，各学院须在本学期<span>12</span>月<span>31</span>日前做好毕业设计（论文）的拟题、审题、指导教师的落实与任务书的下达等工作。审题中要处理好题量大小、难易程度、课题类型的选择、课题与本专业方向的结合等问题，提高课题中硬软结合（含硬件）类所占的比例，工科专业工程设计类所占比例至少达到<span>70%</span>以上，避免近三年选题重复现象。国防生和部分专业申请提前做毕业设计（论文）的学生，毕业设计（论文）工作进程将另行安排。<span></span></p><p style=\"text-indent:32.25pt;\">	二、为了培养学生的团队协作能力，各学院应鼓励有科研项目的指导教师积极申报团队毕业设计（论文）课题，尤其是跨专业、跨学科的团队课题的申报。认真填写团队毕业设计（论文）申请表和总计划任务书，并于<span>2017</span>年<span>12</span>月<span>31</span>日前报教务处实践教学科，教务处将组织专家对团队课题进行审核。</p><p style=\"text-indent:32.25pt;\">	三、毕业设计（论文）答辩前，各学院须做好学生答辩资格的审查工作。依据任务书中所规定的内容，检查学生课题的完成情况，做好对毕业设计（论文）的评阅及软、硬件等成果的验收，填写《洛阳师范学院毕业设计（论文）系统验收表》。<span></span></p><p style=\"text-indent:32.25pt;\">	四、各学院应加强对校外毕业设计（论文）的管理工作。要尽早落实好课题以及指导教师。毕业设计（论文）过程中，加强与企业的联系与沟通，了解和掌握学生毕业设计（论文）课题的进度情况，加强过程管理，督促学生严格执行《洛阳师范学院本科毕业设计（论文）工作规定》。<span></span></p><p style=\"text-indent:32.25pt;\">	五、毕业设计（论文）结束后，各学院应在当学期内完成本学院的毕业设计（论文）工作小结（按照毕业设计（论文）工作小结提纲撰写）。<span></span></p><p style=\"text-indent:32.25pt;\">	请各学院认真按照毕业设计（论文）工作进程<span>,</span>做好2018届本科生毕业设计（论文）组织与管理工作。教务处将组织专家到各学院跟踪抽查。<span></span></p>', 0, NULL, '2017-12-31 15:48:37', '1');
INSERT INTO `inform` VALUES (7, '关于开展2018届毕业设计(论文)工作的通知', '<p style=\"text-indent:32.0pt;\">	毕业设计（论文）是实现本科培养目标的重要实践性教学环节。为了进一步加强和规范毕业设计（论文）的管理工作，确保毕业设计（论文）质量，各学院应在认真总结2017届毕业设计（论文）工作的基础上，严格按《洛阳师范学院本科毕业设计（论文）工作规定》和各类型学生的培养方案，认真开展2018届毕业设计（论文）工作，并注意做好以下几点：<span></span></p><p align=\"left\" style=\"text-indent:31.35pt;\">	一、按毕业设计（论文）的工作进程，各学院须在本学期<span>12</span>月<span>31</span>日前做好毕业设计（论文）的拟题、审题、指导教师的落实与任务书的下达等工作。审题中要处理好题量大小、难易程度、课题类型的选择、课题与本专业方向的结合等问题，提高课题中硬软结合（含硬件）类所占的比例，工科专业工程设计类所占比例至少达到<span>70%</span>以上，避免近三年选题重复现象。国防生和部分专业申请提前做毕业设计（论文）的学生，毕业设计（论文）工作进程将另行安排。<span></span></p><p style=\"text-indent:32.25pt;\">	二、为了培养学生的团队协作能力，各学院应鼓励有科研项目的指导教师积极申报团队毕业设计（论文）课题，尤其是跨专业、跨学科的团队课题的申报。认真填写团队毕业设计（论文）申请表和总计划任务书，并于<span>2017</span>年<span>12</span>月<span>31</span>日前报教务处实践教学科，教务处将组织专家对团队课题进行审核。</p><p style=\"text-indent:32.25pt;\">	三、毕业设计（论文）答辩前，各学院须做好学生答辩资格的审查工作。依据任务书中所规定的内容，检查学生课题的完成情况，做好对毕业设计（论文）的评阅及软、硬件等成果的验收，填写《洛阳师范学院毕业设计（论文）系统验收表》。<span></span></p><p style=\"text-indent:32.25pt;\">	四、各学院应加强对校外毕业设计（论文）的管理工作。要尽早落实好课题以及指导教师。毕业设计（论文）过程中，加强与企业的联系与沟通，了解和掌握学生毕业设计（论文）课题的进度情况，加强过程管理，督促学生严格执行《洛阳师范学院本科毕业设计（论文）工作规定》。<span></span></p><p style=\"text-indent:32.25pt;\">	五、毕业设计（论文）结束后，各学院应在当学期内完成本学院的毕业设计（论文）工作小结（按照毕业设计（论文）工作小结提纲撰写）。<span></span></p><p style=\"text-indent:32.25pt;\">	请各学院认真按照毕业设计（论文）工作进程<span>,</span>做好2018届本科生毕业设计（论文）组织与管理工作。教务处将组织专家到各学院跟踪抽查。<span></span></p>', 0, NULL, '2017-12-31 15:48:58', '1');
INSERT INTO `inform` VALUES (8, '关于发布《2018届本科生毕业设计（论文）工作规定》的通知', '<p><span class=\"STYLE1\"></span></p><p class=\"MsoNormal\" style=\"margin-left:-7.05pt;text-indent:8.0pt;\">	各学院：</p><p style=\"text-indent:32.0pt;\">	为了进一步加强毕业设计（论文）工作的管理，更加规范有序地开展<span>2018</span>届本科毕业设计（论文）工作，教务处综合各方面意见，对《<span>2017</span>届本科生毕业设计（论文）工作规定》进行了修订，修订后更名为《<span>2018</span>届本科生毕业设计（论文）工作规定》。本规定已由教学例会讨论通过，现予发布，请遵照执行，原《<span>2017</span>届本科生毕业设计（论文）工作规定（教发〔<span>2016</span>〕<span>42</span>号）》同时废止。<span></span></p><p class=\"MsoNormal\" style=\"margin-left:-8.0pt;text-indent:216.0pt;\">	2017年<span>12</span>月<span>1</span>日</p>', 0, NULL, '2017-12-01 15:50:16', '1');

-- ----------------------------
-- Table structure for inform_message
-- ----------------------------
DROP TABLE IF EXISTS `inform_message`;
CREATE TABLE `inform_message`  (
  `message_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,消息id',
  `message_body` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `message_type` int NOT NULL COMMENT '消息类型(0留言1通知)',
  `teacher_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,导师id',
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,学生id',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `response_date` datetime NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`message_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of inform_message
-- ----------------------------

-- ----------------------------
-- Table structure for ktbg
-- ----------------------------
DROP TABLE IF EXISTS `ktbg`;
CREATE TABLE `ktbg`  (
  `ktbg_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,id',
  `column1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '综述',
  `column2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '思路及方法',
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,学生id',
  `ktbg_status` int NULL DEFAULT NULL COMMENT '教师评审意见（0未通过，1通过）',
  PRIMARY KEY (`ktbg_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  CONSTRAINT `ktbg_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ktbg
-- ----------------------------

-- ----------------------------
-- Table structure for lunwen
-- ----------------------------
DROP TABLE IF EXISTS `lunwen`;
CREATE TABLE `lunwen`  (
  `lunwen_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,id',
  `lunwen_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '论文名',
  `lunwen_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '论文上传路径',
  `lunwen_date` datetime NULL DEFAULT NULL COMMENT '论文上传时间',
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,学生id',
  `lunwen_status` int NULL DEFAULT NULL COMMENT '论文被审核之后的状态(0退回修改1评审打分)',
  PRIMARY KEY (`lunwen_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  CONSTRAINT `lunwen_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of lunwen
-- ----------------------------

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,消息id',
  `message_body` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '消息内容',
  `message_type` int(2) UNSIGNED ZEROFILL NULL DEFAULT 00 COMMENT '消息类型(0留言1通知)',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,发送者的用户ID\r\n',
  `to_user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,接收者的用户ID',
  `create_date` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `state` int(2) UNSIGNED ZEROFILL NULL DEFAULT 00 COMMENT '是否已读，0未读   1已读',
  PRIMARY KEY (`message_id`) USING BTREE,
  INDEX `wj_1`(`user_id`) USING BTREE,
  INDEX `wj_2`(`to_user_id`) USING BTREE,
  CONSTRAINT `wj_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wj_2` FOREIGN KEY (`to_user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 'hello', NULL, '10001', '20001', '2022-03-02 20:46:04', 01);
INSERT INTO `message` VALUES (2, 'hello', NULL, '10001', '20001', '2022-03-02 20:47:07', 01);
INSERT INTO `message` VALUES (3, 'hello', NULL, '10001', '20001', '2022-03-02 20:47:07', 01);
INSERT INTO `message` VALUES (4, 'hello', NULL, '10001', '20001', '2022-03-02 20:47:07', 01);
INSERT INTO `message` VALUES (5, 'hello1', 00, '10001', '20002', '2022-03-02 21:11:04', 01);
INSERT INTO `message` VALUES (6, 'hello1', 00, '10001', '20002', '2022-03-02 21:11:04', 01);
INSERT INTO `message` VALUES (7, 'hello1', 00, '10001', '20002', '2022-03-02 21:11:04', 01);
INSERT INTO `message` VALUES (8, 'hello3', 00, '10001', '20003', '2022-03-06 16:07:20', 01);
INSERT INTO `message` VALUES (9, '\nhello3', 00, '10001', '20003', '2022-03-06 16:07:22', 01);
INSERT INTO `message` VALUES (10, '\n', 00, '10001', '20003', '2022-03-06 16:07:22', 01);
INSERT INTO `message` VALUES (11, 'hello3', 00, '10001', '20003', '2022-03-06 16:13:33', 01);
INSERT INTO `message` VALUES (12, '\nhello3', 00, '10001', '20003', '2022-03-06 16:13:35', 01);
INSERT INTO `message` VALUES (13, 'dsfdsfds\n\n\n', 00, '10001', '20001', '2022-03-06 17:11:49', 01);
INSERT INTO `message` VALUES (14, '\ndfdsf', 00, '10001', '10002', '2022-03-06 17:12:06', 01);
INSERT INTO `message` VALUES (15, '\ndsfdsf', 00, '10001', '10003', '2022-03-06 17:12:21', 01);
INSERT INTO `message` VALUES (16, '\ndfdsf', 00, '10001', '10003', '2022-03-06 17:12:26', 01);
INSERT INTO `message` VALUES (17, '\ndsfdsf', 00, '10001', '10004', '2022-03-06 17:12:32', 01);
INSERT INTO `message` VALUES (18, '11', 00, '10002', '10001', '2022-03-06 17:34:36', 01);
INSERT INTO `message` VALUES (19, '\n1', 00, '10002', '10001', '2022-03-06 17:34:37', 01);
INSERT INTO `message` VALUES (20, '\n1', 00, '10002', '10001', '2022-03-06 17:34:37', 01);
INSERT INTO `message` VALUES (21, '\n1', 00, '10002', '10001', '2022-03-06 17:34:37', 01);
INSERT INTO `message` VALUES (22, '34234324', 00, '10002', '10001', '2022-03-06 17:50:02', 01);
INSERT INTO `message` VALUES (23, '\nsdfasf', 00, '10002', '10001', '2022-03-06 17:50:03', 01);
INSERT INTO `message` VALUES (24, '神鼎飞丹砂、\\s\\', 00, '10001', '10002', '2022-03-06 17:52:53', 01);
INSERT INTO `message` VALUES (25, '\nsdfsd', 00, '10001', '10002', '2022-03-06 17:52:54', 01);
INSERT INTO `message` VALUES (26, '11', 00, '10001', '10002', '2022-03-08 21:30:35', 01);
INSERT INTO `message` VALUES (27, '\n11111', 00, '10001', '10002', '2022-03-08 21:30:59', 01);
INSERT INTO `message` VALUES (28, '1111', 00, '10002', '10001', '2022-03-08 21:31:29', 01);
INSERT INTO `message` VALUES (29, '111', 00, '10001', '20001', '2022-03-09 20:03:16', 01);
INSERT INTO `message` VALUES (30, '\n11', 00, '10001', '20001', '2022-03-09 20:03:17', 01);
INSERT INTO `message` VALUES (31, '\n111', 00, '10001', '10002', '2022-03-09 20:03:32', 01);
INSERT INTO `message` VALUES (32, '\n11', 00, '10001', '10002', '2022-03-09 20:03:33', 01);
INSERT INTO `message` VALUES (33, '\nhello', 00, '10001', '10002', '2022-03-09 20:04:07', 01);
INSERT INTO `message` VALUES (34, '111', 00, '10001', '10002', '2022-03-09 20:45:49', 00);
INSERT INTO `message` VALUES (35, '\nhello', 00, '10001', '10002', '2022-03-09 20:45:55', 00);
INSERT INTO `message` VALUES (36, 'hello222', 00, '10002', '10001', '2022-03-09 20:46:05', 00);
INSERT INTO `message` VALUES (37, '\nhello123456', 00, '10001', '10002', '2022-03-09 20:46:15', 00);
INSERT INTO `message` VALUES (38, '111', 00, '10001', '20002', '2022-03-09 21:01:43', 00);

-- ----------------------------
-- Table structure for paperlib
-- ----------------------------
DROP TABLE IF EXISTS `paperlib`;
CREATE TABLE `paperlib`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '课题名称',
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '摘要',
  `file` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '附件链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paperlib
-- ----------------------------
INSERT INTO `paperlib` VALUES (1, '论文名称', '论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-', NULL);
INSERT INTO `paperlib` VALUES (2, '论文名称', '论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-', NULL);
INSERT INTO `paperlib` VALUES (3, '论文名称', '论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-', NULL);
INSERT INTO `paperlib` VALUES (4, '论文名称', '论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-', NULL);
INSERT INTO `paperlib` VALUES (5, '论文名称', '论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-论文摘要-', NULL);

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `project_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,课题id',
  `project_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课题名',
  `project_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课题表述',
  `project_from_id` int NULL DEFAULT NULL COMMENT '外键,课题来源',
  `teacher_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,导师id',
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,学生id',
  `project_state` int NULL DEFAULT NULL COMMENT '该选题的状态，默认状态为0,该课题可选；为1时，待审核，不可选；选题状态2，已被选择，不可选。',
  PRIMARY KEY (`project_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  INDEX `project_from_id`(`project_from_id`) USING BTREE,
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `project_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `project_ibfk_3` FOREIGN KEY (`project_from_id`) REFERENCES `project_from` (`project_from_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for project_from
-- ----------------------------
DROP TABLE IF EXISTS `project_from`;
CREATE TABLE `project_from`  (
  `project_from_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,id',
  `project_from_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课题来源(教师建议 学生拟定 企业和社会征集 科研单位提供)',
  PRIMARY KEY (`project_from_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of project_from
-- ----------------------------

-- ----------------------------
-- Table structure for qzxj
-- ----------------------------
DROP TABLE IF EXISTS `qzxj`;
CREATE TABLE `qzxj`  (
  `qzxj_id` int NOT NULL,
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`qzxj_id`) USING BTREE,
  INDEX `qzxj_ikbj_1`(`student_id`) USING BTREE,
  CONSTRAINT `qzxj_ikbj_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qzxj
-- ----------------------------

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`  (
  `roles_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,角色id',
  `roles_name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名（导师，学生，管理员，超级管理员）',
  PRIMARY KEY (`roles_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES (1, 'teacher');
INSERT INTO `roles` VALUES (2, 'student');
INSERT INTO `roles` VALUES (3, 'admin');

-- ----------------------------
-- Table structure for sessionList
-- ----------------------------
DROP TABLE IF EXISTS `sessionList`;
CREATE TABLE `sessionList`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送者的id',
  `to_user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接受者的ID',
  `list_name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `un_read_count` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '未读消息个数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `wk_1`(`user_id`) USING BTREE,
  INDEX `wk_2`(`to_user_id`) USING BTREE,
  CONSTRAINT `wk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `wk_2` FOREIGN KEY (`to_user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sessionList
-- ----------------------------
INSERT INTO `sessionList` VALUES (1, '10001', '20001', '学生1', 0000000000);
INSERT INTO `sessionList` VALUES (5, '10001', '20002', '学生2', 0000000000);
INSERT INTO `sessionList` VALUES (10, '10001', '20003', '学生3', 0000000000);
INSERT INTO `sessionList` VALUES (11, '10001', '10002', '教师2', 0000000000);
INSERT INTO `sessionList` VALUES (12, '10001', '10003', '教师3', 0000000000);
INSERT INTO `sessionList` VALUES (13, '10001', '10004', '教师4', 0000000000);
INSERT INTO `sessionList` VALUES (14, '10002', '10001', '教师1', 0000000000);
INSERT INTO `sessionList` VALUES (15, '10002', '20002', '学生2', 0000000000);
INSERT INTO `sessionList` VALUES (16, '10002', '20002', '学生2', 0000000000);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键,学生id',
  `project_num` int NULL DEFAULT 0 COMMENT '课题数,只能选择一个课题',
  `project_id` int NULL DEFAULT NULL COMMENT '外键,课题',
  `teacher_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,导师id',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,用户id',
  `class_id` int NULL DEFAULT NULL COMMENT '外键,班级id',
  `student_score` int NULL DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`student_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  INDEX `project_id`(`project_id`) USING BTREE,
  INDEX `class_id`(`class_id`) USING BTREE,
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_ibfk_3` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_ibfk_4` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_ibfk_5` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('210001', 0, NULL, NULL, '20001', 1, NULL);

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `subject_id` int NOT NULL AUTO_INCREMENT COMMENT '主键,id',
  `subject_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业名',
  PRIMARY KEY (`subject_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '专业名表\r\n' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, '计算机科学技术');
INSERT INTO `subject` VALUES (2, '电子信息');
INSERT INTO `subject` VALUES (3, '人工智能');
INSERT INTO `subject` VALUES (4, '数据分析');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键,导师id',
  `teacher_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '导师描述',
  `teacher_project_num` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '导师出题数,限制在8个',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外键,用户id',
  `dept_id` int NULL DEFAULT NULL COMMENT '外键,部门id',
  `zhicheng` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
  PRIMARY KEY (`teacher_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE,
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`dept_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('11001', '计算机科学方向', NULL, '10001', 1, '副教授');
INSERT INTO `teacher` VALUES ('11002', '大数据方向', NULL, '10002', 2, '副教授');
INSERT INTO `teacher` VALUES ('11003', 'Java方向', '', '10003', 1, '副教授');
INSERT INTO `teacher` VALUES ('11004', 'Java方向', NULL, '10004', 1, '副教授');
INSERT INTO `teacher` VALUES ('11005', '自然语言处理方向(NLP)', NULL, '10005', 3, '教授');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `user_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录账号',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_tel` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `user_sex` int NULL DEFAULT NULL COMMENT '用户性别',
  `user_roles` int NULL DEFAULT 3 COMMENT '用户角色',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `user_ibfk_1`(`user_roles`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`user_roles`) REFERENCES `roles` (`roles_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10001', '教师1', '教师1', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10002', '教师2', '教师2', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10003', '教师3', '教师3', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10004', '教师4', '教师4', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('10005', '教师5', '教师5', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 1);
INSERT INTO `user` VALUES ('20001', '学生1', '学生1', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 2);
INSERT INTO `user` VALUES ('20002', '学生2', '学生2', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 2);
INSERT INTO `user` VALUES ('20003', '学生3', '学生3', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 2);
INSERT INTO `user` VALUES ('20004', '学生4', '学生4', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 2);
INSERT INTO `user` VALUES ('20005', '学生5', '学生5', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 2);
INSERT INTO `user` VALUES ('30001', '管理员', '管理员', 'e10adc3949ba59abbe56e057f20f883e', '11111111111', NULL, 3);

SET FOREIGN_KEY_CHECKS = 1;
