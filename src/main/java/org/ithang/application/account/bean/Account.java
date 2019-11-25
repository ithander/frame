package org.ithang.application.account.bean;

/**
 * 用户币种钱包
 * @author zyt
 *
 */
public class Account{

        private Integer id;//
        private Integer customer_id;//
        private Integer currency_id;//币种ID
        private Integer from_user;
        private String mobile;
        private String title;
        private String uname;
        private String currency_title;
        private Double amount;//可用金额
        private Double frozen_amount;//冻结金额
        private Double invest_amount;//投资总金额
        private Double static_bonus;//静态收益
        private Double team_bonus;//加速收益
        private Double addteam_bonus;//动态收益
        private Double total_bonus;//总收益
        private Double team_invest_amount;//团队投资
        private String create_time;//创建时间


        public void setId(Integer id){
            this.id=id;
        }
        
        public Integer getId(){
            return this.id;
        }
        
        public Integer getCustomer_id() {
			return customer_id;
		}

		public void setCustomer_id(Integer customer_id) {
			this.customer_id = customer_id;
		}

		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		public void setCurrency_id(Integer currency_id){
            this.currency_id=currency_id;
        }
        
        public Integer getCurrency_id(){
            return this.currency_id;
        }
        public void setAmount(Double amount){
            this.amount=amount;
        }
        
        public Double getAmount(){
            return this.amount;
        }
        public void setFrozen_amount(Double frozen_amount){
            this.frozen_amount=frozen_amount;
        }
        
        public Double getFrozen_amount(){
            return this.frozen_amount;
        }
        public void setInvest_amount(Double invest_amount){
            this.invest_amount=invest_amount;
        }
        
        public Double getInvest_amount(){
            return this.invest_amount;
        }
        
		public Integer getFrom_user() {
			return from_user;
		}

		public void setFrom_user(Integer from_user) {
			this.from_user = from_user;
		}

		public void setCreate_time(String create_time){
            this.create_time=create_time;
        }
        
        public String getCreate_time(){
            return this.create_time;
        }

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getCurrency_title() {
			return currency_title;
		}

		public void setCurrency_title(String currency_title) {
			this.currency_title = currency_title;
		}

		public Double getTeam_bonus() {
			return team_bonus;
		}

		public void setTeam_bonus(Double team_bonus) {
			this.team_bonus = team_bonus;
		}

		public Double getStatic_bonus() {
			return static_bonus;
		}

		public void setStatic_bonus(Double static_bonus) {
			this.static_bonus = static_bonus;
		}

	    
		public Double getTeam_invest_amount() {
			return team_invest_amount;
		}

		public void setTeam_invest_amount(Double team_invest_amount) {
			this.team_invest_amount = team_invest_amount;
		}

		public Double getAddteam_bonus() {
			return addteam_bonus;
		}

		public void setAddteam_bonus(Double addteam_bonus) {
			this.addteam_bonus = addteam_bonus;
		}

		public Double getTotal_bonus() {
			return total_bonus;
		}

		public void setTotal_bonus(Double total_bonus) {
			this.total_bonus = total_bonus;
		}

		

}