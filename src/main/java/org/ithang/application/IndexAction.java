package org.ithang.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value={"main","/app/main"},method=RequestMethod.GET)
	public String main(){
		return "app/main";
	}
	
	@RequestMapping(value={"/login","/app/login"},method=RequestMethod.GET)
	public String login(){
		return "app/login";
	}
	
	@RequestMapping(value={"/login","/app/login"},method=RequestMethod.POST)
	public void login(String username,String password){
		
	}
	
}
