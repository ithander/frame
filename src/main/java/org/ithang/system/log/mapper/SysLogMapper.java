package org.ithang.system.log.mapper;

import org.ithang.system.log.bean.SysLog;
import org.ithang.tools.model.Page;

public interface SysLogMapper {

	/**
	 * 得到指定日志
	 * @param sysLog_id
	 * @return
	 */
	public SysLog get(long sysLog_id);
	
	/**
	 * 分页查询日志
	 * @param page
	 * @return
	 */
	public Page<SysLog> list(Page<SysLog> page);
	
}
