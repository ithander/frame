package org.ithang.system.data.web;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ithang.system.data.bean.SysInfo;
import org.ithang.system.data.service.DataService;
import org.ithang.tools.database.Dao;
import org.ithang.tools.gener.CodeGener;
import org.ithang.tools.gener.TableInfo;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ErrorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 系统数据维护功能
 * 包括:
 * 系统安装初始化与升级
 * 菜单管理
 * 表结构管理
 * @author zyt
 *
 */
@Controller
@RequestMapping("sys/data")
public class DataAction extends Action<Object>{

	@Autowired
	private DataService dataService;
	
	@RequestMapping(value="info",method=RequestMethod.GET)
	public ActionResult info(){
		SysInfo info=dataService.info();
		return page("info",info);
	}
	
	@RequestMapping(value="tables",method=RequestMethod.GET)
	public String tables(){
		return "system/data/tables";
	}
	
	
	@ResponseBody
	@RequestMapping(value="tables",method=RequestMethod.POST)
	public Map<String,Object> tables(String table){
		List<TableInfo> tables=dataService.tables(table);
		Map<String,Object> result=new HashMap<>();
		result.put("total", tables.size());
		result.put("rows", tables);
		return result;
	}
	
	
}
