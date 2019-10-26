package org.ithang.system.data.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.ithang.system.data.bean.SysInfo;
import org.ithang.system.data.bean.SysTable;
import org.ithang.system.data.mapper.DataMapper;
import org.ithang.tools.database.BaseDao;
import org.ithang.tools.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService extends BaseDao{

	@Autowired
	private DataMapper dataMapper;
	
	Logger logger = Logger.getLogger(DataService.class);
	
	/**
	 * 得到最新的系统信息
	 * @return
	 */
	public SysInfo info(){
		return dataMapper.info();
	}
	
	public List<SysTable> tables(Page<SysTable> page){
		return dataMapper.tables(page);
	}
	
}
