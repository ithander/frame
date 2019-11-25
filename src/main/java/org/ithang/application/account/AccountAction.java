package org.ithang.application.account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ithang.application.account.bean.Account;
import org.ithang.application.account.service.AccountService;
import org.ithang.tools.lang.DateUtils;
import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ActionValues;
import org.ithang.tools.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户币种钱包
 * @author zyt 控制器
 *
 */
@Controller
@RequestMapping("/app/account")
public class AccountAction extends Action<Account>{

    @Autowired
    private AccountService accountService; 


    @ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ActionResult add(Account account){
    	if(null!=account.getId()){
    		accountService.update(account);	
    	}else{
    		account.setCreate_time(DateUtils.getSystime());
		    accountService.add(account);
    	}
		return success();
	}
	
	 @RequestMapping("form")
    public String form(@RequestParam(value="id",required=false)Integer id,Model m){
    	if(null!=id){
    		Account bean=accountService.get(id);
    		m.addAttribute(bean);
    	}else{
    		m.addAttribute(new Account());
    	}
    	return "app/account/form";
    }
	
	
	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ActionResult update(Account account){
		accountService.update(account);
		return success();
	}


    @ResponseBody
	@RequestMapping(value="get",method=RequestMethod.GET)
	public ActionResult get(Integer id){
		Account r=accountService.get(id);
		return success(r);
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ActionResult delete(@RequestParam(value="id",required=false)Integer id,@RequestParam(value="ids",required=false)String ids){
		
		if(null!=id&&id>0){
			accountService.delete(id);	
		}
		
		if(null!=ids&&ids.length()>0){
			accountService.batchDelete(ids.split(","));
		}
		
		return success();
	}
	
	@ResponseBody
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ActionResult list(Integer... ids){
		return success(accountService.list(ids));
	}
	
	@ResponseBody
	@RequestMapping(value="page",method=RequestMethod.POST)
	public ActionResult page(Account account,Pager<Account> page){
	    page.setBean(account);
	    List<Account> data=accountService.page(page);
	    page.setData(data);
		return success(page);
	}
	
	@ResponseBody
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ActionResult query(HttpServletRequest request){
		ActionValues values=new ActionValues(request);
		return success(accountService.query(values));
	}
     

}