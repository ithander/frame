package org.ithang.system.keyvalue;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ithang.system.keyvalue.bean.Keyvalue;
import org.ithang.system.keyvalue.service.KeyvalueService;
import org.ithang.tools.lang.JsonUtils;
import org.ithang.tools.lang.StrUtils;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ActionValues;
import org.ithang.tools.model.FilterRule;
import org.ithang.tools.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 字典表
 * @author zyt 控制器
 *
 */
@Controller
@RequestMapping("/sys/keyvalue")
public class KeyvalueAction extends Action<Keyvalue>{

    @Autowired
    private KeyvalueService keyvalueService; 


    @ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ActionResult add(Keyvalue keyvalue){
		keyvalueService.add(keyvalue);
		return success();
	}
    
    @RequestMapping("form")
    public String form(@RequestParam(value="key",required=false)String key,Model m){
    	if(null!=key&&key.trim().length()>0){
    		Keyvalue r=keyvalueService.get(key);
    		m.addAttribute(r);
    	}
    	return "system/keyvalue/form";
    }
	
	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ActionResult update(Keyvalue keyvalue){
		keyvalueService.update(keyvalue);
		return success();
	}


    @ResponseBody
	@RequestMapping(value="get",method=RequestMethod.GET)
	public ActionResult get(String key){
		Keyvalue r=keyvalueService.get(key);
		return success(r);
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ActionResult delete(@RequestParam(value="key",required=false)String key,@RequestParam(value="ids",required=false)String ids){
		if(StrUtils.isNotBlank(key)){
			keyvalueService.delete(key);	
		}
		
		if(null!=ids&&ids.length()>0){
			keyvalueService.batchDelete(ids.split(","));
		}
		
		return success();
	}
	
	@ResponseBody
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ActionResult list(String... ids){
		return success(keyvalueService.list(ids));
	}
	
	@ResponseBody
	@RequestMapping(value="page",method=RequestMethod.POST)
	public ActionResult page(Keyvalue keyvalue,Pager<Keyvalue> page){
		List<Keyvalue> rs= keyvalueService.page(keyvalue,page);
		page.setData(rs);
		return success(page);
	}
	
	@ResponseBody
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ActionResult query(HttpServletRequest request){
		ActionValues values=new ActionValues(request);
		List<Keyvalue> rs=keyvalueService.query(values);
		values.put("data", rs);
		return success(values);
	}
     

}