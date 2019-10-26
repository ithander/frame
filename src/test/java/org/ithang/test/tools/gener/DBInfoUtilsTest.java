package org.ithang.test.tools.gener;

import java.sql.SQLException;
import java.util.List;

import org.ithang.tools.gener.ColumnInfo;
import org.ithang.tools.gener.DBInfoUtils;
import org.ithang.tools.gener.TableInfo;
import org.ithang.tools.lang.JsonUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DBInfoUtilsTest {

	@Test
	public void testTables() throws SQLException{
		
		SimpleDriverDataSource ds=new SimpleDriverDataSource(new com.mysql.jdbc.Driver(), "jdbc:mysql://192.168.0.187:3306/test?useSSL=false", "root", "123456");
		JdbcTemplate jt=new JdbcTemplate(ds);
		List<TableInfo> tbs=DBInfoUtils.tables(jt, "user_info","kvalues");
		System.out.println(JsonUtils.toJsonStr(tbs));
		
	}
	
	@Test
	public void testColumns()throws SQLException{
		SimpleDriverDataSource ds=new SimpleDriverDataSource(new com.mysql.jdbc.Driver(), "jdbc:mysql://192.168.0.187:3306/test?useSSL=false", "root", "123456");
		JdbcTemplate jt=new JdbcTemplate(ds);
		List<ColumnInfo> tbs=DBInfoUtils.columns(jt, "user_info","kvalues");
		System.out.println(JsonUtils.toJsonStr(tbs));
	}
	
	
   
}
