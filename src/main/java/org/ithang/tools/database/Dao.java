package org.ithang.tools.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.log4j.Logger;
import org.ithang.tools.model.DBConfig;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Dao {

	@Autowired
	private static DataSource dataSource;//根数据源,根数据源拥有项目配置数据
	
	private static DBOperator dbOperator;
	
	private final static Map<String, DBOperator> ds=new HashMap<String, DBOperator>(5);
	private static Logger logger=Logger.getLogger(Dao.class);
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public DBOperator getDBOperator() {
		if(null!=dataSource&&(null==dbOperator||!dbOperator.equals(dataSource))){
			dbOperator=new DBOperator("default",dataSource);
		}
		return dbOperator;
	}
	
	/**
	 * 根据属性文件加载数据源
	 * @param key
	 * @param db_config
	 */
	public void loadDsByProperties(String key,Properties db_config) {
		try{
		    DataSource keyDs=BasicDataSourceFactory.createDataSource(db_config);
		    ds.put(key, new DBOperator(key, keyDs));
		}catch(Exception e){
			logger.error("加载数据源"+key+"出错"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据JNDI加载数据源
	 * @param key
	 * @param lookup
	 */
	public void loadDsByJNDI(String key,String lookup){
		try{
		     InitialContext ic = new InitialContext();
		     DataSource keyDs = (DataSource) ic.lookup(lookup);
		     ds.put(key, new DBOperator(key, keyDs));
		}catch(Exception e){
			logger.error("加载数据源"+key+"出错"+e.getMessage());
			e.printStackTrace();
		}

	}
	
	/**
	 * 加载数据源
	 * @param key
	 * @param dbConfig
	 */
	public void load(String key,DBConfig dbConfig){
		
	}
	
	/**
	 * 加载数据源
	 * @param key
	 * @param uname
	 * @param upass
	 * @param url
	 */
	public void load(String key,String uname,String upass,String url){
		
	}

	public static Map<String, DBOperator> getDs() {
		return ds;
	}

	
}
