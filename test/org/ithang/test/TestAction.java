package org.ithang.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestAction {

	@RequestMapping("to")
	public String to(@RequestParam("page")String page){
		return page;
	}
	
}
