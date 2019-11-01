package org.ithang.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageAction {

	/**
	 * 路转到指定页面
	 * @param page
	 * @return
	 */
	@RequestMapping("to")
	public String to(@RequestParam("page")String page){
		return page;
	}
	
	
}
