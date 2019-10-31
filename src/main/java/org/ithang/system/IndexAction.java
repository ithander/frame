package org.ithang.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.type.Alias;
import org.ithang.system.auth.bean.User;
import org.ithang.tools.filter.session.SessionsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("sysIndex")
@Alias("sysIndex")
public class IndexAction {

	@RequestMapping(value={"","sindex"},method=RequestMethod.GET)
	public String index(HttpServletRequest request){
		return "system/index";
	}
	
	@RequestMapping(value="sLogin",method=RequestMethod.GET)
	public String sLogin(){
		return "system/login";
	}
	
	@RequestMapping(value="sLogin",method=RequestMethod.POST)
	public String sLogin(@RequestParam("uname")String uname,@RequestParam("upass")String upass,HttpServletRequest request,HttpServletResponse response){
		User user=new User();
		user.setUname(uname);
		user.setUpass(upass);
		SessionsManager.updateSession(user, request);
		
		return "redirect:/sys/main";
	}
	
	@RequestMapping(value="loginout",method=RequestMethod.GET)
	public String loginout(HttpServletRequest request){
		if(SessionsManager.isLogin(request)){
			SessionsManager.clearSession(request);
		}
		return "system/login";
	}
	
	@RequestMapping("main")
	public String main(HttpServletRequest request){
		if(SessionsManager.isLogin(request)){
			return "system/main";
		}
		return "system/login";
	}
	
}
