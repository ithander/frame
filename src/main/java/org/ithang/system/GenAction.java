package org.ithang.system;

import java.sql.SQLException;

import org.ithang.tools.database.Dao;
import org.ithang.tools.gener.CodeGener;
import org.ithang.tools.gener.GenField;
import org.ithang.tools.lang.JsonUtils;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ErrorInfo;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("gen")
public class GenAction extends Action<Object> {

	@ResponseBody
	@RequestMapping(value="testdb",method=RequestMethod.POST)
	public ActionResult testMySQL(String url,String uname,String upass){
		try {
			SimpleDriverDataSource sdd=new SimpleDriverDataSource(new com.mysql.jdbc.Driver(), url, uname, upass);
			if(!sdd.getConnection().isValid(6000)){
				return error(ErrorInfo.UnknowError);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return error(ErrorInfo.InternalError);
		}
		
		return success();
	}
	
	/**
	 * 生成代码
	 * @param tables
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="gencode",method=RequestMethod.POST)
	public ActionResult generCode(String url,String uname,String upass,String dir,String pkg,String tabname,String gsql,GenField gen){
		try{
			SimpleDriverDataSource sdd=new SimpleDriverDataSource(new com.mysql.jdbc.Driver(), url, uname, upass);
		    CodeGener cdGener=new CodeGener(sdd);
		    System.out.println(sdd);
		    System.out.println("genField="+JsonUtils.toJsonStr(gen));
		    //cdGener.gener(tables);
		}catch(Exception e){
			e.printStackTrace();
		    return error(ErrorInfo.InternalError);
		}
		return success();
	}
	
}
