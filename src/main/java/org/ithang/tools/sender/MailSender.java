package org.ithang.tools.sender;

import config.AppConfig;
import config.MailConfig;
import lib.MAILSend;

public class MailSender {

	
	public static String sendEmail(String sendTo,String code){
		AppConfig config = new MailConfig();
		config.setAppId("15008");
		config.setAppKey("0c368e337b8813f12330b1d60cb8e24f");
		config.setSignType("md5");
		MAILSend submail = new MAILSend(config);
//		submail.addTo("leo@submail.cn","leo");
		submail.addTo(sendTo,"交易所用户");
		//submail.addCc("mailer@submail.cn", "");
		//submail.addBcc("leo@drinkfans.com", "");
		submail.setSender("javadev@yinhusoft.com","银狐信息");
		submail.setReply("3218138121@qq.com");
		submail.setSubject("邮箱验证码");
		submail.setText("邮箱验证码");
		//submail.addAttachment("D:\\Program Files\\eclipse-php-luna-SR1-win32\\eclipse\\epl-v10.html");
		String content="您的验证码为："+code+"<br/><br/>该邮件为系统自动发出，请勿回复，谢谢!!!</br><a href='http://www.yinhusoft.com/' style='text-decoration : none'>银狐信息</a>";
		submail.setHtml(content);
		submail.addVar("name", "yinhu");
		//submail.addVar("age", "32");
		submail.addLink("developer", "http://www.yinhusoft.com/");
		submail.addLink("store", "http://submail.cn/chs/store");
		submail.addHeaders("X-Accept", "zh-cn");
		submail.addHeaders("X-Mailer", "YinHu App");
		submail.send();
		return "success";
	}
	
	
	
	
}
