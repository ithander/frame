package org.ithang.tools.gener;

import java.util.ArrayList;
import java.util.List;

/**
 * 字段表达式
 * @author zyt
 *
 */
public class ColumnExpress {

	private String[] column;
	private String[] express;
	private String[] var;
	
	public String[] getColumn() {
		return column;
	}
	public void setColumn(String[] column) {
		this.column = column;
	}
	public String[] getExpress() {
		return express;
	}
	public void setExpress(String[] express) {
		this.express = express;
	}
	public String[] getVar() {
		return var;
	}
	public void setVar(String[] var) {
		this.var = var;
	}
	
	public List<ColumnExpressInfo> toArray(){
		List<ColumnExpressInfo> data=new ArrayList<>();
		if(null!=getColumn()&&getColumn().length>0){
			for(int i=0;i<getColumn().length;i++){
				data.add(new ColumnExpressInfo(column[i],express[i],var[i]));
			}
		}
		return data;
	}
	
}
