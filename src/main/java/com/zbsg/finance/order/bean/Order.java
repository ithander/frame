package com.zbsg.finance.order.bean;

/**
 * 订单
 * @author zyt
 *
 */
public class Order {

	private String order_id;//订单ID
	private String owner;//下单人
	private String create_time;//下单时间
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
}
