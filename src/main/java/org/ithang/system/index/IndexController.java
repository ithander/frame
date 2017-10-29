package org.ithang.system.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("system/index")
public class IndexController {

	@RequestMapping
	public String index(){
		return "index";
	}
	
	@RequestMapping("home")
	public String home(){
		return "home";
	}
	
}
