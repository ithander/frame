package org.ithang.system.userRole;

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
import org.ithang.system.userRole.bean.UserRole;
import org.ithang.system.userRole.service.UserRoleService;

/**
 * 
 * @author zyt 控制器
 *
 */
@Controller
@RequestMapping("/app/userRole")
public class UserRoleAction extends Action<UserRole>{

    @Autowired
    private UserRoleService userRoleService; 


    @ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ActionResult add(UserRole userRole){
		userRoleService.add(userRole);
		return success();
	}


    @ResponseBody
	@RequestMapping(value="get",method=RequestMethod.GET)
	public ActionResult get(Integer id){
		UserRole r=userRoleService.get(id);
		return success(r);
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ActionResult delete(Integer id){
		userRoleService.delete(id);
		return success();
	}
	
	@ResponseBody
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ActionResult list(Integer... ids){
		return success(userRoleService.list(ids));
	}
	
	@ResponseBody
	@RequestMapping(value="page",method=RequestMethod.POST)
	public ActionResult page(UserRole userRole,Page<UserRole> page){
		return success(userRoleService.page(userRole,page));
	}
	
	@ResponseBody
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ActionResult query(HttpServletRequest request){
		ActionValues values=new ActionValues(request);
		return success(userRoleService.query(values));
	}
     

}