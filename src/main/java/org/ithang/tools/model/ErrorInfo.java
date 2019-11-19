package org.ithang.tools.model;

/**
 * 报错信息
 * @author zyt
 *
 */
public enum ErrorInfo {

	NoLoginError(-1,"未登录,请登录后操作!"),
	UnknowError(1,"失败或未知错误"),
	InternalError(2,"内部异常"),
	UserExistError(3,"用户己存在"),
	VCodeNotExistError(4,"验证码错误或己失效"),
	MobileExistError(5,"手机号己注册"),
	UserNotExistError(6,"无效用户"),
	LookAtError(7,"操作失败,具体原因请查看记录详细"),
	BalanceNotEnoughError(8,"余额不足"),
	PasswordError(9,"密码错误"),
	InvalidDataError(10,"无效数据"),
	ToMoneyNoPersonError(11,"对方账户无效"),
	NoPayPassError(12,"未设置支付密码"),
	PayPassError(12,"支付密码错误"),
	InvalidMobileError(13,"无效的手机号码"),
	LoginFailError(15,"登录失败，用户名或密码错误！"),
	InvalidTokenError(16,"无效Token！"),
	BtAddrExistError(17,"该提币地址己存在！"),
	InvalidBtAddrError(18,"无效的提币地址！"),
	QueryTradFailError(19,"查询交易失败！"),
	RechargeError(20,"充币地址不正确！"),
	GasError(21,"分发Gas必须大于0！"),
	GasingError(22,"正在分发Gas！"),
	GoveringError(23,"正在归集！"),
	HasRechargeError(24,"充币记录己添加！"),
	ProcessSuccess(0,"成功");
	
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

