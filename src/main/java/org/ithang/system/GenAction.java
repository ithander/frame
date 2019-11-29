package org.ithang.system;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.ithang.tools.database.Dao;
import org.ithang.tools.gener.CodeGener;
import org.ithang.tools.gener.ColumnExpress;
import org.ithang.tools.gener.DBInfoUtils;
import org.ithang.tools.gener.GenField;
import org.ithang.tools.gener.TableInfo;
import org.ithang.tools.lang.JsonUtils;
import org.ithang.tools.lang.StrUtils;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ErrorInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("gen")
public class GenAction extends Action<Object> {

	
	private static JdbcTemplate jdbcTemplate;
	
	/**
	 * 获取表名
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="gettabs",method=RequestMethod.GET)
	public ActionResult getTabs(){
		jdbcTemplate=Dao.getDBOperator().getJdbcTemplate();
		List<String> tabNames=jdbcTemplate.queryForList("show tables", String.class);
		return success(tabNames);
	}
	
	@ResponseBody
	@RequestMapping(value="testdb",method=RequestMethod.POST)
	public ActionResult testMySQL(String url,String uname,String upass){
		try {
			SimpleDriverDataSource sdd=new SimpleDriverDataSource(new com.mysql.jdbc.Driver(), url, uname, upass);
			Connection conn=sdd.getConnection();
			if(conn.isValid(6000)){
				JdbcTemplate jt=new JdbcTemplate(sdd);
				jdbcTemplate=jt;
				List<String> tabNames=jt.queryForList("show tables", String.class);
				return success(tabNames);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return error(ErrorInfo.InternalError);
		}
		return error(ErrorInfo.UnknowError);
		
	}
	
	@ResponseBody
	@RequestMapping("cinfo")
	public ActionResult columnInfo(@RequestParam("tabName")String tabName){
		
		if(null!=jdbcTemplate&&StrUtils.isNotBlank(tabName)){
			List<TableInfo> tab=DBInfoUtils.tables(jdbcTemplate, tabName);
			if(null!=tab&&!tab.isEmpty()){
				return success(tab.get(0));
			}
		}
		
		if(null==jdbcTemplate){
			return error(ErrorInfo.DataSourceError);
		}
		
		if("".equals(tabName.trim())){
			return error(ErrorInfo.ParamError);
		}
		
		return error(ErrorInfo.UnknowError);
	}
	
	/**
	 * 生成代码
	 * @param tables
	 * @return
	 */
	@RequestMapping(value="gencode",method=RequestMethod.POST)
	public String generCode(String ui,String dir,String pkg,String tabname,String gsql,ColumnExpress ce,GenField gen){
		try{
		    CodeGener cdGener=new CodeGener(jdbcTemplate);
		    cdGener.setGenField(gen);
		    cdGener.setColumnExpress(ce);
		    cdGener.setSaveDir(dir);
		    cdGener.setBasePkg(pkg);
		    cdGener.setGsql(gsql);
		    cdGener.gener(tabname);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/to?page=gcode";
	}
	
}
