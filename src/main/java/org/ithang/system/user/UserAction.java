package org.ithang.system.user;

import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ActionValues;
import org.ithang.tools.model.Pager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ithang.system.keyvalue.bean.Keyvalue;
import org.ithang.system.user.bean.User;
import org.ithang.system.user.service.UserService;

/**
 * 用户表信息
 * @author zyt 控制器
 *
 */
@Controller
@RequestMapping("/sys/user")
public class UserAction extends Action<User>{

    @Autowired
    private UserService userService; 


    @ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ActionResult add(User user){
		userService.add(user);
		return success();
	}


    @ResponseBody
	@RequestMapping(value="get",method=RequestMethod.GET)
	public ActionResult get(Integer id){
		User r=userService.get(id);
		return success(r);
	}
    
    @RequestMapping("form")
    public String form(@RequestParam(value="id",required=false)Integer id,Model m){
    	if(null!=id){
    		User bean=userService.get(id);
    		m.addAttribute(bean);
    	}
    	return "system/user/form";
    }
    
	
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ActionResult delete(Integer id,@RequestParam(value="ids",required=false)String ids){
		if(null!=id){
			userService.delete(id);	
		}
		if(null!=ids&&ids.length()>0){
			userService.batchDelete(ids.split(","));
		}
		
		return success();
	}
	
	@ResponseBody
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ActionResult list(Integer... ids){
		return success(userService.list(ids));
	}
	
	@ResponseBody
	@RequestMapping(value="page",method=RequestMethod.POST)
	public ActionResult page(User user,Pager<User> page){
		List<User> rs= userService.page(user,page);
		page.setData(rs);
		return success(page);
	}
	
	@ResponseBody
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ActionResult query(HttpServletRequest request){
		ActionValues values=new ActionValues(request);
		return success(userService.query(values));
	}
	
	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ActionResult update(User user,HttpServletRequest request){
		userService.update(user);
		return success();
	}
	

}