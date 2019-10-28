package org.ithang.system.data.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.ithang.system.data.bean.SysInfo;
import org.ithang.system.data.mapper.DataMapper;
import org.ithang.tools.database.BaseDao;
import org.ithang.tools.gener.DBInfoUtils;
import org.ithang.tools.gener.TableInfo;
import org.ithang.tools.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService extends BaseDao{

	@Autowired
	private DataMapper dataMapper;
	
	private static List<TableInfo> tables=null;
	
	private Logger logger = Logger.getLogger(DataService.class);
	
	/**
	 * 得到最新的系统信息
	 * @return
	 */
	public SysInfo info(){
		return dataMapper.info();
	}
	
	public List<TableInfo> tables(String table){
		if(null==tables){
			if(null==table){
				tables=DBInfoUtils.tables(getDBOperator().getJdbcTemplate());	
			}else{
				tables=DBInfoUtils.tables(getDBOperator().getJdbcTemplate(),table);
			}
		}
		return tables;
	}
	
}
