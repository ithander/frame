package org.ithang.tools.model;

public class FilterRule {

	private String field;
	private String key;
	private String op;
	
	public FilterRule(){}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	
}
