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
        private String title;//昵称
        private String email;//邮箱
        private String mobile;//手机
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
        public void setCreate_time(String create_time){
            this.create_time=create_time;
        }
        
        public String getCreate_time(){
            return this.create_time;
        }

}