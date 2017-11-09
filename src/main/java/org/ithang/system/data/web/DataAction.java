package org.ithang.system.data.web;

import org.ithang.system.data.bean.SysInfo;
import org.ithang.system.data.service.DataService;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统安装初始化与升级
 * @author zyt
 *
 */
@Controller
@RequestMapping("system/data")
public class DataAction extends Action{

	@Autowired
	private DataService dataService;
	
	@RequestMapping("install")
	public ActionResult install(){
		SysInfo info=dataService.lastInfo();
		return page("install",info);
	}
	
}