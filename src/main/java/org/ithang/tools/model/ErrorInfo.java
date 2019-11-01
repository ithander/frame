package org.ithang.tools.model;

/**
 * 报错信息
 * @author zyt
 *
 */
public enum ErrorInfo {

	
	UnknowError(1,"失败或未知错误"),
	InternalError(2,"内部异常"),
	UserExistError(3,"用户己存在"),
	VCodeNotExistError(4,"验证码错误或己失效");
	
	private int code;
	private String desc;
	
	private ErrorInfo(int _code,String _desc){
		setCode(_code);
		setDesc(_desc);
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
	
	
	
	
}
