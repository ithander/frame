package org.ithang.application.customer.bean;

public class Team {

	private String uname;//用户昵称
	private Integer num;//用户团队人数
	private Double team_invest_amount;//总金额
	private String create_time;//注册时间
	
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getTeam_invest_amount() {
		return team_invest_amount;
	}
	public void setTeam_invest_amount(Double team_invest_amount) {
		this.team_invest_amount = team_invest_amount;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
}
