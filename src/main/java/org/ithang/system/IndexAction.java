package org.ithang.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("system")
public class IndexAction {

	@RequestMapping
	public String index(){
		return "system/index";
	}
	
	@RequestMapping("home")
	public String home(){
		return "system/home";
	}
	
}
