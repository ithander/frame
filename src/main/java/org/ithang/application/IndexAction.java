package org.ithang.application;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.ithang.system.user.bean.User;
import org.ithang.system.user.service.UserService;
import org.ithang.tools.lang.MD5Util;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ErrorInfo;
import org.ithang.tools.redis.JedisUtils;
import org.ithang.tools.redis.Keys;
import org.ithang.tools.sender.SmsSender;
import org.ithang.tools.validate.VCode;
import org.ithang.tools.validate.ValidateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 业务首页面
 * @author zyt
 *
 */
@Controller("applicationIndex")
public class IndexAction extends Action<Object>{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/","/app"},method=RequestMethod.GET)
	public String index(){
		return "app/index";
	}
	
	@RequestMapping(value="home",method=RequestMethod.GET)
	public String home(){
		Subject subject = SecurityUtils.getSubject();
    	if(subject.isRemembered()||subject.isAuthenticated()){
        	return "app/home";
        }
        return "app/login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "app/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam String username,@RequestParam String password,@RequestParam(defaultValue="0",required=false) String remeber){
		//添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        if(subject.isRemembered()||subject.isAuthenticated()){
        	return "app/home";
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        if("1".equals(remeber)){
        	usernamePasswordToken.setRememberMe(true);	
        }
        
        //进行验证，这里可以捕获异常，然后返回对应信息
        try{
            subject.login(usernamePasswordToken);
            return "app/home";
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return "app/login";
	}
	
	@RequestMapping(value="logout",method={RequestMethod.POST,RequestMethod.GET})
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
        if(null!=subject){
        	subject.logout();
        }
        return "app/index";
	}
	
	/**
	 * 注册
	 * @param user
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="register",method=RequestMethod.POST)
	public ActionResult register(User user,HttpServletRequest request){
		try{
		    userService.add(user);
		}catch(Exception e){
			return error(ErrorInfo.UserExistError);
		}
		return success();
	}
	
	/**
	 * 传一个唯一性的字符串，如mobile或email
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="freshvcode",method=RequestMethod.GET)
	public ActionResult freshVCode(@RequestParam("mobile")String mobile){
		VCode v = ValidateCodeUtil.getRandomCode();     //直接调用静态方法，返回验证码对象
		if(null!=v){
			String key=Keys.format(Keys.LoginVCode, mobile);
			JedisUtils.set(key, MD5Util.getEncryptedData(v.getValue().toLowerCase()),60);//将验证码值保存redis中
			return success(v.getBase64Str());
		}
        return error(ErrorInfo.UnknowError);
	}
	
	
	/**
	 * 验证 验证码
	 * 传一个唯一性的字符串，如mobile或email
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="vcode",method=RequestMethod.GET)
	public ActionResult vcode(@RequestParam("mobile")String mobile,@RequestParam("vcode")String vcode){
		String preVCode=JedisUtils.get(Keys.format(Keys.LoginVCode, mobile));
		if(null!=preVCode&&preVCode.trim().length()>0){
			vcode=MD5Util.getEncryptedData(vcode.toLowerCase());
			if(vcode.equals(preVCode)){
				success();
			}
		}
        return error(ErrorInfo.UnknowError);
	}
	
	/**
	 * 发送短信验证码
	 * @param mobile 手机号
	 * @param vcode 登陆验证码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="sendsms",method=RequestMethod.GET)
	public ActionResult sendSMS(@RequestParam("mobile")String mobile,@RequestParam("vcode")String vcode){
		String preVCode=JedisUtils.get(Keys.format(Keys.LoginVCode, mobile));
		if(null!=preVCode&&preVCode.trim().length()>0){
			vcode=MD5Util.getEncryptedData(vcode.toLowerCase());
			if(vcode.equals(preVCode)){
				String code=ValidateCodeUtil.getRandomCode().getValue();
				SmsSender.sendMsg(mobile, SmsSender.getSmsTemplate(0, code));
				JedisUtils.set(Keys.format(Keys.SmsCode,mobile), code,60*2);//将验证码值保存redis中
			}
		}else{
			return error(ErrorInfo.VCodeNotExistError);
		}
        return error(ErrorInfo.VCodeNotExistError);
	}
	
	/**
	 * 验证 短信验证码
	 * @param mobile 手机号
	 * @param vcode 登陆验证码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="validatesms",method=RequestMethod.GET)
	public ActionResult validateSMS(@RequestParam("mobile")String mobile,@RequestParam("vcode")String vcode){
		String preVCode=JedisUtils.get(Keys.format(Keys.SmsCode, mobile));
		if(null!=preVCode&&preVCode.trim().length()>0){
			if(vcode.equals(preVCode)){
				return success();
			}
		}else{
			return error(ErrorInfo.VCodeNotExistError);
		}
        return error(ErrorInfo.VCodeNotExistError);
	}
	
	
	
}
