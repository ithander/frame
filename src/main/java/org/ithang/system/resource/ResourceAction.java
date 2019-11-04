package org.ithang.system.resource;

import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ActionValues;
import org.ithang.tools.model.Pager;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ithang.system.resource.bean.Resource;
import org.ithang.system.resource.service.ResourceService;

/**
 * 
 * @author zyt 控制器
 *
 */
@Controller
@RequestMapping("/app/resource")
public class ResourceAction extends Action<Resource>{

    @Autowired
    private ResourceService resourceService; 


    @ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ActionResult add(Resource resource){
		resourceService.add(resource);
		return success();
	}


    @ResponseBody
	@RequestMapping(value="get",method=RequestMethod.GET)
	public ActionResult get(String id){
		Resource r=resourceService.get(id);
		return success(r);
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ActionResult delete(String id){
		resourceService.delete(id);
		return success();
	}
	
	@ResponseBody
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ActionResult list(String... ids){
		return success(resourceService.list(ids));
	}
	
	@ResponseBody
	@RequestMapping(value="page",method=RequestMethod.POST)
	public ActionResult page(Resource resource,Pager<Resource> page){
		return success(resourceService.page(resource,page));
	}
	
	@ResponseBody
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ActionResult query(HttpServletRequest request){
		ActionValues values=new ActionValues(request);
		return success(resourceService.query(values));
	}
     

}