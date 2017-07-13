package com.zbsg.finance.order.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbsg.common.model.Action;
import com.zbsg.common.model.ActionValues;
import com.zbsg.common.tools.JsonUtils;
import com.zbsg.finance.order.bean.Order;
import com.zbsg.finance.order.service.OrderService;

@Controller
@RequestMapping("orders")
public class OrderAction extends Action{

	@Autowired
	private OrderService orderService;
	
	private Logger logger=Logger.getLogger(OrderAction.class);
	
	@ResponseBody
	@RequestMapping(value="{orderId}",method=RequestMethod.GET)
	public Order get(@PathVariable("orderId") String orderId){
		return orderService.get(orderId);
	}
	
	@ResponseBody
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Order> list(int pageNow,int pageSize,HttpServletRequest request){
		ActionValues values=getValues(request);
		Map<String,Object> map=new HashMap<String,Object>();
		map.putAll(values);
		List<Order> results=orderService.list(pageNow, pageSize,map);
		logger.info("values="+JsonUtils.toJsonStr(map));
		return results;
	}
	
}
