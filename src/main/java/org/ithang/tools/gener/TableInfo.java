package org.ithang.tools.gener;

import java.util.List;

/**
 * 表信息
 * 对应information_schema.`TABLES`中的数据
 * @author zyt
 *
 */
public class TableInfo {

	private String table_schema;//库名称
	private String table_name;//表名称
	private String table_type;
	private String engine;
	private String version;
	private String row_format;
	private long table_rows;
	private long data_length;
	private String create_time;
	private String update_time;
	private String table_collation;//编码
	private String table_comment;//备注
	
	private List<ColumnInfo> columns;
	
	public String getTable_schema() {
		return table_schema;
	}
	public void setTable_schema(String table_schema) {
		this.table_schema = table_schema;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getTable_type() {
		return table_type;
	}
	public void setTable_type(String table_type) {
		this.table_type = table_type;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getRow_format() {
		return row_format;
	}
	public void setRow_format(String row_format) {
		this.row_format = row_format;
	}
	public long getTable_rows() {
		return table_rows;
	}
	public void setTable_rows(long table_rows) {
		this.table_rows = table_rows;
	}
	public long getData_length() {
		return data_length;
	}
	public void setData_length(long data_length) {
		this.data_length = data_length;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getTable_collation() {
		return table_collation;
	}
	public void setTable_collation(String table_collation) {
		this.table_collation = table_collation;
	}
	public String getTable_comment() {
		return table_comment;
	}
	public void setTable_comment(String table_comment) {
		this.table_comment = table_comment;
	}
	public List<ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(List<ColumnInfo> columns) {
		this.columns = columns;
	}
	
	
}
