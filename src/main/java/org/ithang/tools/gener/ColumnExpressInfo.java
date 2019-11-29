package org.ithang.tools.gener;

/**
 * 字段表达式
 * @author zyt
 *
 */
public class ColumnExpressInfo {

	private String column;
	private String express;
	private String var;
	
	public ColumnExpressInfo(){}
	
	public ColumnExpressInfo(String column,String express,String var){
		setColumn(column);
		setExpress(express);
		setVar(var);
	}
	
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getExpress() {
		return express;
	}
	public void setExpress(String express) {
		this.express = express;
	}
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	
}
