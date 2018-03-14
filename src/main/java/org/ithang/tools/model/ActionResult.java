package org.ithang.tools.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

public class ActionResult extends ModelAndView {

	private int code;//响应码
	private String desc;//描述
	private Object result;//结果数据
	
	private String page;//响应页面
	
	public ActionResult(){
		setCode(0);
		setDesc("操作成功!");
	}
	
	public ActionResult(Object result){
		setCode(0);
		setDesc("操作成功!");
		setResult(result);
	}
	
	public ActionResult(ErrorInfo error){
		setCode(error.getCode());
		setDesc(error.getDesc());
		setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ActionResult(ErrorInfo error,Object results){
		setCode(error.getCode());
		setDesc(error.getDesc());
		setResult(results);
		setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
		addObject(result);
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
		setViewName(page);
	}
	
	public void add(String key,Object value){
		addObject(key, value);
	}
	
}
