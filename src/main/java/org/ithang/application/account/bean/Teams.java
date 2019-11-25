package org.ithang.application.account.bean;

/**
 * 个人和团队的投资统计
 * @author Administrator
 *
 */
public class Teams {

	private Integer customer_id;//用户ID
	private Integer account_id;//用户账户ID
	private Integer from_user;//用户上级，即推荐人
	private Integer grade;//用户等级，数字的值 表示用户的上级有多少级
	private String uname;//用户昵称
	private Double invest_amount;//用户个人的投资金额
	private Integer team_num;//用户团队数里，即用户邀请人的数量
	private Double team_invest_amount;//用户下一级团队的投资总额，不包括下下级团队
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	public Integer getFrom_user() {
		return from_user;
	}
	public void setFrom_user(Integer from_user) {
		this.from_user = from_user;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Double getInvest_amount() {
		return invest_amount;
	}
	public void setInvest_amount(Double invest_amount) {
		this.invest_amount = invest_amount;
	}
	public Integer getTeam_num() {
		return team_num;
	}
	public void setTeam_num(Integer team_num) {
		this.team_num = team_num;
	}
	public Double getTeam_invest_amount() {
		return team_invest_amount;
	}
	public void setTeam_invest_amount(Double team_invest_amount) {
		this.team_invest_amount = team_invest_amount;
	}
	
}
