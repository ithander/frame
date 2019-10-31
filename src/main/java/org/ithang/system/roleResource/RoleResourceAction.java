package org.ithang.system.roleResource;

import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ActionValues;
import org.ithang.tools.model.Page;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ithang.system.roleResource.bean.RoleResource;
import org.ithang.system.roleResource.service.RoleResourceService;

/**
 * 
 * @author zyt 控制器
 *
 */
@Controller
@RequestMapping("/app/roleResource")
public class RoleResourceAction extends Action<RoleResource>{

    @Autowired
    private RoleResourceService roleResourceService; 


    @ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ActionResult add(RoleResource roleResource){
		roleResourceService.add(roleResource);
		return success();
	}


    @ResponseBody
	@RequestMapping(value="get",method=RequestMethod.GET)
	public ActionResult get(String resourceId){
		RoleResource r=roleResourceService.get(resourceId);
		return success(r);
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ActionResult delete(String resourceId){
		roleResourceService.delete(resourceId);
		return success();
	}
	
	@ResponseBody
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ActionResult list(String... ids){
		return success(roleResourceService.list(ids));
	}
	
	@ResponseBody
	@RequestMapping(value="page",method=RequestMethod.POST)
	public ActionResult page(RoleResource roleResource,Page<RoleResource> page){
		return success(roleResourceService.page(roleResource,page));
	}
	
	@ResponseBody
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ActionResult query(HttpServletRequest request){
		ActionValues values=new ActionValues(request);
		return success(roleResourceService.query(values));
	}
     

}