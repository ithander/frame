package org.ithang.system.userRole.bean;

/**
 * 
 * @author zyt
 *
 */
public class UserRole{

        private Integer id;//
        private Integer user_id;//
        private String role_id;//


        public void setId(Integer id){
            this.id=id;
        }
        
        public Integer getId(){
            return this.id;
        }
        public void setUser_id(Integer user_id){
            this.user_id=user_id;
        }
        
        public Integer getUser_id(){
            return this.user_id;
        }
        public void setRole_id(String role_id){
            this.role_id=role_id;
        }
        
        public String getRole_id(){
            return this.role_id;
        }

}