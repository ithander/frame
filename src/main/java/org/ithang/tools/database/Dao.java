package org.ithang.tools.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.ithang.tools.model.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Dao {

	@Autowired
	private static DataSource dataSource;//默认数据源
	
	private final static Map<String, DataSource> ds=new HashMap<String, DataSource>(5);
	
	static{
		ds.put("default", dataSource);
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void load(String key,Properties db_config) {
		
	}
	
	public void load(String key,DBConfig dbConfig){
		
	}
	
	public void load(String key,String uname,String upass,String url){
		
	}
	
}
