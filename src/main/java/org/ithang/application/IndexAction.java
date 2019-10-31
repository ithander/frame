package org.ithang.application;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 业务首页面
 * @author zyt
 *
 */
@Controller("applicationIndex")
public class IndexAction {

	@RequestMapping(value={"/","/app"},method=RequestMethod.GET)
	public String index(){
		return "index";
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
            return "app/main";
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return "app/login";
	}
	
	@RequestMapping(value="login",method={RequestMethod.POST,RequestMethod.GET})
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
        if(null!=subject){
        	subject.logout();
        }
        return "index";
	}
	
}
