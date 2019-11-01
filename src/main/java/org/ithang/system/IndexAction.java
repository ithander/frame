package org.ithang.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.type.Alias;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("sysIndex")
@Alias("sysIndex")
public class IndexAction {

	@RequestMapping(value={"sys"},method=RequestMethod.GET)
	public String index(HttpServletRequest request){
		return "system/index";
	}
	
	
	@RequestMapping(value = "/sLogin",method = RequestMethod.GET)
    public String sLogin(){
    	Subject subject = SecurityUtils.getSubject();
    	if(subject.isRemembered()||subject.isAuthenticated()){
        	return "system/main";
        }
        return "system/login";
    }
	
	
	@RequestMapping(value="sLogin",method=RequestMethod.POST)
	public String sLogin(@RequestParam("uname")String uname,@RequestParam("upass")String upass,HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue="0",required=false) String remeber){
		//添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        if(subject.isRemembered()||subject.isAuthenticated()){
        	return "system/main";
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(uname,upass);
        if("1".equals(remeber)){
        	usernamePasswordToken.setRememberMe(true);	
        }
        
        //进行验证，这里可以捕获异常，然后返回对应信息
        try{
            subject.login(usernamePasswordToken);
            return "system/main";
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return "system/login";
	}
	
	@RequestMapping(value="sloginout",method=RequestMethod.GET)
	public String loginout(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
        if(null!=subject){
        	subject.logout();
        }
		return "system/login";
	}
	
	@RequestMapping("main")
	public String main(HttpServletRequest request){
    	Subject subject = SecurityUtils.getSubject();
    	if(subject.isRemembered()||subject.isAuthenticated()){
        	return "system/main";
        }
        return "system/login";
	}
	
}
