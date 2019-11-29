package org.ithang.tools.gener;

import java.util.ArrayList;
import java.util.List;

public class GenField {

	private String[] addtype;
	private String[] addname;
	private String[] express;
	private String[] addnamed;
	
	public GenField(){}

	public String[] getAddtype() {
		return addtype;
	}

	public void setAddtype(String[] addtype) {
		this.addtype = addtype;
	}

	public String[] getAddname() {
		return addname;
	}

	public void setAddname(String[] addname) {
		this.addname = addname;
	}

	public String[] getExpress() {
		return express;
	}

	public void setExpress(String[] express) {
		this.express = express;
	}

	public String[] getAddnamed() {
		return addnamed;
	}

	public void setAddnamed(String[] addnamed) {
		this.addnamed = addnamed;
	}
	
	public List<GenFieldInfo> toArray(){
		List<GenFieldInfo> data=new ArrayList<>();
		if(null!=getAddname()&&getAddname().length>0){
			for(int i=0;i<getAddname().length;i++){
				data.add(new GenFieldInfo(addtype[i],addname[i],express[i],addnamed[i]));
			}
		}
		return data;
	}
	
}
