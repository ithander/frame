package ${basePkg}.${BeanName};

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
import ${basePkg}.${BeanName}.bean.${BeanName};
import ${basePkg}.${BeanName}.service.${BeanName}Service;

/**
 * ${tabComment}
 * @author zyt 控制器
 *
 */
@Controller
@RequestMapping("/app/${beanName}")
public class ${BeanName}Action extends Action<${BeanName}>{

    @Autowired
    private ${basePkg}.${BeanName}.service.${BeanName}Service ${beanName}Service; 


    @ResponseBody
	@RequestMapping(value="add",method=RequestMethod.POST)
	public ActionResult add(${BeanName} ${beanName}){
		${beanName}Service.add(${beanName});
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
	public ActionResult delete(${priKeyType!"String"} ${priKey!"id"}){
		${beanName}Service.delete(${priKey!"id"});
		return success();
	}
	
	@ResponseBody
	@RequestMapping(value="list",method={RequestMethod.GET,RequestMethod.POST})
	public ActionResult list(${priKeyType!"String"}... ids){
		return success(${beanName}Service.list(ids));
	}
	
	@ResponseBody
	@RequestMapping(value="page",method=RequestMethod.POST)
	public ActionResult page(${BeanName} ${beanName},Page<${BeanName}> page){
		return success(${beanName}Service.page(${beanName},page));
	}
	
	@ResponseBody
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ActionResult query(HttpServletRequest request){
		ActionValues values=new ActionValues(request);
		return success(${beanName}Service.query(values));
	}
     

}