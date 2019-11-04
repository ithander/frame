-- --------------------------------------------------------
-- 主机:                           192.168.0.186
-- 服务器版本:                        5.7.27-log - MySQL Community Server (GPL)
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table test.keyvalue
CREATE TABLE IF NOT EXISTS `keyvalue` (
  `key` varchar(50) NOT NULL COMMENT '英文标识',
  `value` varchar(250) DEFAULT NULL COMMENT '值',
  `title` varchar(250) DEFAULT NULL COMMENT '中文名称',
  PRIMARY KEY (`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- Dumping data for table test.keyvalue: ~2 rows (大约)
/*!40000 ALTER TABLE `keyvalue` DISABLE KEYS */;
INSERT INTO `keyvalue` (`key`, `value`, `title`) VALUES
	('abc', 'have a good time', '测试啊'),
	('test', '1', '测试');
/*!40000 ALTER TABLE `keyvalue` ENABLE KEYS */;

-- Dumping structure for table test.resource
CREATE TABLE IF NOT EXISTS `resource` (
  `id` varchar(50) NOT NULL,
  `type` tinyint(4) NOT NULL DEFAULT '0',
  `title` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test.resource: ~0 rows (大约)
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;

-- Dumping structure for table test.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` varchar(50) NOT NULL,
  `title` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test.role: ~0 rows (大约)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table test.role_resource
CREATE TABLE IF NOT EXISTS `role_resource` (
  `role_id` varchar(50) NOT NULL,
  `resource_id` varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`,`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test.role_resource: ~0 rows (大约)
/*!40000 ALTER TABLE `role_resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_resource` ENABLE KEYS */;

-- Dumping structure for table test.template
CREATE TABLE IF NOT EXISTS `template` (
  `id` varchar(50) NOT NULL,
  `title` varchar(150) DEFAULT NULL COMMENT '标题',
  `content` longtext COMMENT '内容',
  `create_time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(50) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板';

-- Dumping data for table test.template: ~3 rows (大约)
/*!40000 ALTER TABLE `template` DISABLE KEYS */;
INSERT INTO `template` (`id`, `title`, `content`, `create_time`, `update_time`) VALUES
	('1', '', NULL, NULL, NULL),
	('eee1', 'aaaa', '', NULL, NULL),
	('sdf', 'were', NULL, NULL, NULL),
	('sdf0', 'aaaa', '', NULL, NULL);
/*!40000 ALTER TABLE `template` ENABLE KEYS */;

-- Dumping structure for table test.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `uname` varchar(50) DEFAULT NULL COMMENT '用户名',
  `upass` varchar(50) DEFAULT NULL COMMENT '密码',
  `type` tinyint(4) DEFAULT '0' COMMENT '用户类型，0app,1sys',
  `title` varchar(50) DEFAULT NULL COMMENT '昵称',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(50) DEFAULT NULL COMMENT '手机',
  `pay_pwd` varchar(50) DEFAULT NULL COMMENT '支付密码',
  `from_user` int(11) DEFAULT NULL COMMENT '推荐人',
  `mycode` varchar(50) DEFAULT NULL COMMENT '邀请码',
  `create_time` varchar(50) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8 COMMENT='用户表信息';

-- Dumping data for table test.user: ~120 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `uname`, `upass`, `type`, `title`, `email`, `mobile`, `pay_pwd`, `from_user`, `mycode`, `create_time`) VALUES
	(1, 'admin', '123456', 0, '张三', NULL, '13774486318', NULL, NULL, NULL, '2019-10-16 09:29:12');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table test.user_resource
CREATE TABLE IF NOT EXISTS `user_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0',
  `resource_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table test.user_resource: ~1 rows (大约)
/*!40000 ALTER TABLE `user_resource` DISABLE KEYS */;
INSERT INTO `user_resource` (`id`, `user_id`, `resource_id`) VALUES
	(1, 1, 'power');
/*!40000 ALTER TABLE `user_resource` ENABLE KEYS */;

-- Dumping structure for table test.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table test.user_role: ~1 rows (大约)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES
	(1, 1, 'admin');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
