package com.zbsg.finance.order.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zbsg.finance.order.bean.Order;
import com.zbsg.finance.order.mapper.OrderMapper;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	public Order get(String orderId){
	    return orderMapper.get(orderId);	
	}
	
	public List<Order> list(int pageNow,int pageSize,Map<String,Object> values){
		return orderMapper.list(values);
	}
}
