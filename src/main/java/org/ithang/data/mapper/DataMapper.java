package org.ithang.data.mapper;

import org.ithang.data.bean.SysInfo;

public interface DataMapper {

	/**
	 * 判断是否己安装
	 * @return
	 */
	public int isInstall();
	
	/**
	 * 判断数据库是否存在
	 * @return
	 */
	public int isDatabaseExist();
	
	/**
	 * 最新系统信息
	 * @return
	 */
	public SysInfo lastInfo();
	
	
}
