package org.ithang.system.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ithang.system.template.bean.Template;
import org.ithang.system.template.service.TemplateService;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ActionValues;
import org.ithang.tools.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 模板
 * @author zyt 控制器
 *
 */
@Controller
@RequestMapping("/sys/template")
public class TemplateAction extends Action<Template>{

    @Autowired
    private TemplateService templateService; 


   	@RequestMapping(value="page",method=RequestMethod.GET)
   	public String page(){
   		return "system/template/list";
   	}
   	
   	@RequestMapping(value="form",method=RequestMethod.GET)
   	public String form(){
   		return "system/template/form";
   	}
    
    @ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ActionResult add(Template template){
		templateService.add(template);
		return success();
	}


    @ResponseBody
	@RequestMapping(value="get",method=RequestMethod.GET)
	public ActionResult get(String id){
		Template r=templateService.get(id);
		return success(r);
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ActionResult delete(String id){
		templateService.delete(id);
		return success();
	}
	
	@ResponseBody
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> list(String... ids){
		List<Template> data=templateService.list(ids);
		Map<String,Object> result=new HashMap<>(7);
		result.put("total", null==data?0:data.size());
		result.put("rows", null==data?new Object[]{}:data);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="page",method=RequestMethod.POST)
	public ActionResult page(Template template,Page<Template> page){
		return success(templateService.page(template,page));
	}
	
	@ResponseBody
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ActionResult query(HttpServletRequest request){
		ActionValues values=new ActionValues(request);
		return success(templateService.query(values));
	}
     

}