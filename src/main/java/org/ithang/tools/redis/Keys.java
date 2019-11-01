package org.ithang.tools.redis;

public final class Keys {

	/**
	 * 用户session信息
	 */
	public final static String UserSession="current_user_session_info";
	
	//登陆验证码key头，登陆前要验证
	public final static String LoginVCode="login_vcode_%s";
	
	//发短信验证码key头,发送短信之前要验证
	public final static String SmsVCode="sms_vcode_%s";
	
	//短信验证码key头，存放手机验证码
	public final static String SmsCode="sms_code_%s";
	
	
	
	public static String format(String temp,Object ...values){
		return String.format(temp, values);
	}
}
