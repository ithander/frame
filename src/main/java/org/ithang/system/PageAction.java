package org.ithang.system;

import org.ithang.tools.model.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageAction {

	@Autowired
	private Config config;
	
	/**
	 * 路转到指定页面
	 * @param page
	 * @return
	 */
	@RequestMapping("to")
	public String to(@RequestParam("page")String page,Model model){
		model.addAttribute("theme", config.getTheme());
		return page;
	}
	
	
}
