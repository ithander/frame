package org.ithang.tools.gener;

public class GenFieldInfo {
	
	private String addtype;
	private String addname;
	private String express;
	private String addnamed;
	
	public GenFieldInfo(){}
	
	public GenFieldInfo(String addType,String addName,String express,String addNamed){
		setAddname(addName);
		setAddnamed(addNamed);
		setAddtype(addType);
		setExpress(express);
	}
	
	public String getAddtype() {
		return addtype;
	}
	public void setAddtype(String addtype) {
		this.addtype = addtype;
	}
	public String getAddname() {
		return addname;
	}
	public void setAddname(String addname) {
		this.addname = addname;
	}
	public String getExpress() {
		return express;
	}
	public void setExpress(String express) {
		this.express = express;
	}
	public String getAddnamed() {
		return addnamed;
	}
	public void setAddnamed(String addnamed) {
		this.addnamed = addnamed;
	}

}
