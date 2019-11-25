package org.ithang.application.customer;

import org.ithang.tools.lang.MD5Util;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ActionValues;
import org.ithang.tools.model.ErrorInfo;
import org.ithang.tools.model.Pager;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.ithang.application.customer.bean.Customer;
import org.ithang.application.customer.service.CustomerService;

/**
 * 用户表信息
 * @author zyt 控制器
 *
 */
@Controller
@RequestMapping("/app/customer")
public class CustomerAction extends Action<Customer>{

    @Autowired
    private CustomerService customerService; 


    @ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ActionResult add(Customer customer){
		customerService.add(customer);
		return success();
	}
	
	 @RequestMapping("form")
    public String form(@RequestParam(value="id",required=false)Integer id,Model m){
    	if(null!=id){
    		Customer bean=customerService.get(id);
    		m.addAttribute(bean);
    	}else{
    		m.addAttribute(new Customer());
    	}
    	return "app/customer/form";
    }
	
	
	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ActionResult update(Customer customer){
		customerService.update(customer);
		return success();
	}
	
	/**
	 * 设置密码
	 * @param prepwd
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="setupass",method=RequestMethod.POST)
	public ActionResult setupass(@RequestParam("prepwd")String prepwd,@RequestParam("pwd")String pwd){
		Subject subject = SecurityUtils.getSubject();
    	if(subject.isAuthenticated()){
    		Customer user=(Customer)subject.getPrincipal();
    		if(user.getUpass().equals(MD5Util.md5(prepwd))){
    			Customer newpass=new Customer();
    			newpass.setId(user.getId());
    			newpass.setUpass(MD5Util.md5(pwd));
    			customerService.update(newpass);
    		}else{
    			return error(ErrorInfo.PasswordError);
    		}
    	}else{
    		return error(ErrorInfo.NoLoginError);
    	}
		return success();
	}


    @ResponseBody
	@RequestMapping(value="get",method=RequestMethod.GET)
	public ActionResult get(Integer id){
		Customer r=customerService.get(id);
		return success(r);
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ActionResult delete(@RequestParam(value="id",required=false)Integer id,@RequestParam(value="ids",required=false)String ids){
		
		if(null!=id&&id>0){
			customerService.delete(id);	
		}
		
		if(null!=ids&&ids.length()>0){
			customerService.batchDelete(ids.split(","));
		}
		
		return success();
	}
	
	@ResponseBody
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ActionResult list(Integer... ids){
		return success(customerService.list(ids));
	}
	
	@ResponseBody
	@RequestMapping(value="page",method=RequestMethod.POST)
	public ActionResult page(Customer customer,Pager<Customer> page){
	    page.setBean(customer);
	    List<Customer> data=customerService.page(page);
	    page.setData(data);
		return success(page);
	}
	
	@ResponseBody
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ActionResult query(HttpServletRequest request){
		ActionValues values=new ActionValues(request);
		return success(customerService.query(values));
	}
     

}