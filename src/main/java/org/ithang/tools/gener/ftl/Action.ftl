package ${basePkg}.${beanName};

import org.ithang.tools.model.Action;
import org.ithang.tools.model.ActionResult;
import org.ithang.tools.model.ActionValues;
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
import ${basePkg}.${beanName}.bean.${BeanName};
import ${basePkg}.${beanName}.service.${BeanName}Service;

/**
 * ${tabComment}
 * @author zyt 控制器
 *
 */
@Controller
@RequestMapping("/${path}/${beanName}")
public class ${BeanName}Action extends Action<${BeanName}>{

    @Autowired
    private ${BeanName}Service ${beanName}Service; 


    @ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ActionResult add(${BeanName} ${beanName}){
		${beanName}Service.add(${beanName});
		return success();
	}
	
	 @RequestMapping("form")
    public String form(@RequestParam(value="${priKey!"id"}",required=false)${priKeyType!"String"} ${priKey!"id"},Model m){
    	if(null!=${priKey!"id"}){
    		${BeanName} bean=${beanName}Service.get(${priKey!"id"});
    		m.addAttribute(bean);
    	}else{
    		m.addAttribute(new ${BeanName}());
    	}
    	return "${pathDir}/${beanName}/form";
    }
	
	
	@ResponseBody
	@RequestMapping(value="update",method=RequestMethod.POST)
	public ActionResult update(${BeanName} ${beanName}){
		${beanName}Service.update(${beanName});
		return success();
	}


    @ResponseBody
	@RequestMapping(value="get",method=RequestMethod.GET)
	public ActionResult get(${priKeyType!"String"} ${priKey!"id"}){
		${BeanName} r=${beanName}Service.get(${priKey!"id"});
		return success(r);
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public ActionResult delete(@RequestParam(value="${priKey!"id"}",required=false)${priKeyType!"String"} ${priKey!"id"},@RequestParam(value="ids",required=false)String ids){
		
		<#if priKeyType=='String'>
		if(null!=${priKey!"id"}&&${priKey!"id"}.trim().length()>0){
			${beanName}Service.delete(${priKey!"id"});	
		}
		<#else>
		if(null!=${priKey!"id"}&&${priKey!"id"}>0){
			${beanName}Service.delete(${priKey!"id"});	
		}
		</#if>
		
		if(null!=ids&&ids.length()>0){
			${beanName}Service.batchDelete(ids.split(","));
		}
		
		return success();
	}
	
	@ResponseBody
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ActionResult list(${priKeyType!"String"}... ids){
		return success(${beanName}Service.list(ids));
	}
	
	@ResponseBody
	@RequestMapping(value="page",method=RequestMethod.POST)
	public ActionResult page(${BeanName} ${beanName},Pager<${BeanName}> page){
	    page.setBean(${beanName});
	    List<${BeanName}> data=${beanName}Service.page(page);
	    page.setData(data);
		return success(page);
	}
	
	@ResponseBody
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ActionResult query(HttpServletRequest request){
		ActionValues values=new ActionValues(request);
		return success(${beanName}Service.query(values));
	}
     

}