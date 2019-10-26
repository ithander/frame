package org.ithang.tools.gener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DBInfoUtils {


	/**
	 * 查所指定表的列信息
	 * @param jdbcTemplate
	 * @param tableNames
	 * @return
	 */
	public static List<ColumnInfo> columns(JdbcTemplate jdbcTemplate,String...tableNames){
		
		StringBuilder sber=new StringBuilder();
		for(String tableName:tableNames){
			if(sber.length()>0){
				sber.append(" or ");
			}
			sber.append(" `table_name`=").append("'").append(tableName).append("'");
		}
		sber.insert(0, "SELECT * from information_schema.columns where");
		return jdbcTemplate.query(sber.toString(), new RowMapper<ColumnInfo>(){

			@Override
			public ColumnInfo mapRow(ResultSet rs, int index) throws SQLException {
				ColumnInfo ci=new ColumnInfo();
				ci.setTable_name(rs.getString("table_name"));
				ci.setColumn_name(rs.getString("column_name"));
				ci.setColumn_default(rs.getString("column_default"));
				ci.setCharacter_maximum_length(rs.getInt("character_maximum_length"));
				ci.setColumn_comment(rs.getString("column_comment"));
				ci.setData_type(rs.getString("data_type"));
				ci.setColumn_key(rs.getString("column_key"));
				ci.setIs_nullable(rs.getString("is_nullable"));
				ci.setOrdinal_position(rs.getInt("ordinal_position"));
				return ci;
			}
			
		});
	}
	
	
	public static List<TableInfo> tables(JdbcTemplate jdbcTemplate,String...tableNames){
		
		List<ColumnInfo> cos=columns(jdbcTemplate,tableNames);
		
		StringBuilder sber=new StringBuilder();
		for(String tableName:tableNames){
			if(sber.length()>0){
				sber.append(" or ");
			}
			sber.append(" `table_name`=").append("'").append(tableName).append("'");
		}
		sber.insert(0, "SELECT * from information_schema.`TABLES` where ");
		return jdbcTemplate.query(sber.toString(), new RowMapper<TableInfo>(){

			@Override
			public TableInfo mapRow(ResultSet rs, int index) throws SQLException {
				TableInfo ti=new TableInfo();
			    ti.setTable_schema(rs.getString("table_schema"));
			    ti.setTable_name(rs.getString("table_name"));
			    ti.setTable_type(rs.getString("table_type"));
			    ti.setEngine(rs.getString("engine"));
			    ti.setVersion(rs.getString("version"));
			    ti.setRow_format(rs.getString("row_format"));
			    ti.setData_length(rs.getLong("data_length"));
			    ti.setCreate_time(rs.getString("create_time"));
			    ti.setUpdate_time(rs.getString("update_time"));
			    ti.setTable_collation(rs.getString("table_collation"));
			    ti.setTable_comment(rs.getString("table_comment"));
			    ti.setColumns(getColumnInfos(ti.getTable_name(),cos));
				return ti;
			}
			
		});
	}
	
	
	/**
	 * 提取出指定表的数据字段信息
	 * @param tableName
	 * @param columnInfos
	 * @return
	 */
	 private static List<ColumnInfo> getColumnInfos(String tableName,List<ColumnInfo> columnInfos){
		    List<ColumnInfo> cos=null;
			if(null!=columnInfos&&!columnInfos.isEmpty()){
				cos=new ArrayList<>();
				for(ColumnInfo ci:columnInfos){
					if(tableName.equalsIgnoreCase(ci.getTable_name())){
						cos.add(ci);
					}
				}
			}
			return cos;
	 }
	
}
