package org.ithang.system.user.bean;

/**
 * 用户表信息
 * @author zyt
 *
 */
public class User{

        private Integer id;//ID
        private String uname;//用户名
        private String upass;//密码
        private int type;//用户类型，0app,1sys
        private String title;//昵称
        private String email;//邮箱
        private String mobile;//手机
        private String pay_pwd;//支付密码
        private Integer from_user;//推荐人
        private String create_time;//创建时间


        public void setId(Integer id){
            this.id=id;
        }
        
        public Integer getId(){
            return this.id;
        }
        public void setUname(String uname){
            this.uname=uname;
        }
        
        public String getUname(){
            return this.uname;
        }
        public void setUpass(String upass){
            this.upass=upass;
        }
        
        public String getUpass(){
            return this.upass;
        }
        
        public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public void setTitle(String title){
            this.title=title;
        }
        
        public String getTitle(){
            return this.title;
        }
        public void setEmail(String email){
            this.email=email;
        }
        
        public String getEmail(){
            return this.email;
        }
        public void setMobile(String mobile){
            this.mobile=mobile;
        }
        
        public String getMobile(){
            return this.mobile;
        }
        public void setPay_pwd(String pay_pwd){
            this.pay_pwd=pay_pwd;
        }
        
        public String getPay_pwd(){
            return this.pay_pwd;
        }
        public void setFrom_user(Integer from_user){
            this.from_user=from_user;
        }
        
        public Integer getFrom_user(){
            return this.from_user;
        }
        public void setCreate_time(String create_time){
            this.create_time=create_time;
        }
        
        public String getCreate_time(){
            return this.create_time;
        }

}