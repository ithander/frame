package org.ithang.system;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("systemIndex")
@Alias("systemIndex")
@RequestMapping("sys")
public class SystemIndexAction {

	@RequestMapping
	public String index(){
		return "system/index";
	}
	
	@RequestMapping("home")
	public String home(){
		return "system/home";
	}
	
}