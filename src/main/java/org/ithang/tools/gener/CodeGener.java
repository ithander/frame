package org.ithang.tools.gener;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 代码生成器
 * @author ithang
 *
 */
public class CodeGener {

	/**
	 * 根据表结构生成 对应的Bean,Mapper,Service
	 * @param jdbcTemplate
	 * @param tableNames 如果为null或长度为0,则全库表都生成一遍
	 */
	public void gener(JdbcTemplate jdbcTemplate,String[] tableNames){
		
	}
	
}
