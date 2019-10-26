package org.ithang.tools.gener;

/**
 * 对应information_schema.columns表
 * @author zyt
 *
 */
public class ColumnInfo {

	private String table_name;//表名称
	private String column_name;//列名称
	private int ordinal_position;//列顺序
	private String column_default;//默认值
	private String column_key;//列索引
	private String is_nullable;//是否可以为NULL,[NO|YES]
	private String data_type;//字段类型:int,varchar
	private int character_maximum_length;//最大长度
	private String column_comment;//备注
	
	
	private String javaType;
	
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public int getOrdinal_position() {
		return ordinal_position;
	}
	public void setOrdinal_position(int ordinal_position) {
		this.ordinal_position = ordinal_position;
	}
	public String getColumn_default() {
		return column_default;
	}
	public void setColumn_default(String column_default) {
		this.column_default = column_default;
	}
	public String getColumn_key() {
		return column_key;
	}
	public void setColumn_key(String column_key) {
		this.column_key = column_key;
	}
	public String getIs_nullable() {
		return is_nullable;
	}
	public void setIs_nullable(String is_nullable) {
		this.is_nullable = is_nullable;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
		if(null!=data_type&&data_type.trim().length()>0){
			if(data_type.startsWith("int")){
				setJavaType("Integer");
			}
			if(data_type.startsWith("bigint")){
				setJavaType("Long");
			}
			if(data_type.startsWith("varchar")){
				setJavaType("String");
			}
		}
	}
	public int getCharacter_maximum_length() {
		return character_maximum_length;
	}
	public void setCharacter_maximum_length(int character_maximum_length) {
		this.character_maximum_length = character_maximum_length;
	}
	public String getColumn_comment() {
		return column_comment;
	}
	public void setColumn_comment(String column_comment) {
		this.column_comment = column_comment;
	}
	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	
}
