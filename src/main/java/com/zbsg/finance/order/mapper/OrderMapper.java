package com.zbsg.finance.order.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbsg.finance.order.bean.Order;

public interface OrderMapper{

	Order get(@Param("orderId")String orderId);
	
	List<Order> list(Map<String,Object> values);
	
}
