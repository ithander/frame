CREATE TABLE `sys_info` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`author` VARCHAR(50) NOT NULL DEFAULT '' COMMENT '软件维护者',
	`version` VARCHAR(15) NOT NULL DEFAULT '0' COMMENT '软件版本',
	`mobile` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '联系方式',
	`create_time` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '创建或升级时间',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
