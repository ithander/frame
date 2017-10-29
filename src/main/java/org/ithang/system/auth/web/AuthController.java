package org.ithang.system.auth.web;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("system/auth")
public class AuthController {

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "system/login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestParam("uname")String uname,@RequestParam("upass")String upass,HttpSession session){
		return "home";
	}
	
	@RequestMapping("/logout")
	 public String logout(HttpSession session) {
	     Subject subject = SecurityUtils.getSubject();
	     subject.logout();
//	     session.removeAttribute("user");
	     return "login";
	 }
	
	public void home(){
		
	}
}
