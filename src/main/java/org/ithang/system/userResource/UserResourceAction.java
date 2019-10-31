package org.ithang.system.userResource;

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
import org.ithang.system.userResource.bean.UserResource;
import org.ithang.system.userResource.service.UserResourceService;

/**
 * 
 * @author zyt 控制器
 *
 */
@Controller
@RequestMapping("/app/userResource")
public class UserResourceAction extends Action<UserResource>{

    @Autowired
    private UserResourceService userResourceService; 


    @ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ActionResult add(UserResource userResource){
		userResourceService.add(userResource);
		return success();
	}


    @ResponseBody
	@RequestMapping(value="get",method=RequestMethod.GET)
	public ActionResult get(Integer id){
		UserResource r=userResourceService.get(id);
		return success(r);
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ActionResult delete(Integer id){
		userResourceService.delete(id);
		return success();
	}
	
	@ResponseBody
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ActionResult list(Integer... ids){
		return success(userResourceService.list(ids));
	}
	
	@ResponseBody
	@RequestMapping(value="page",method=RequestMethod.POST)
	public ActionResult page(UserResource userResource,Page<UserResource> page){
		return success(userResourceService.page(userResource,page));
	}
	
	@ResponseBody
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ActionResult query(HttpServletRequest request){
		ActionValues values=new ActionValues(request);
		return success(userResourceService.query(values));
	}
     

}