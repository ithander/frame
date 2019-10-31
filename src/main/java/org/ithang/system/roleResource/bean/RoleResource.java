package org.ithang.system.roleResource.bean;

/**
 * 
 * @author zyt
 *
 */
public class RoleResource{

        private String role_id;//
        private String resource_id;//


        public void setRole_id(String role_id){
            this.role_id=role_id;
        }
        
        public String getRole_id(){
            return this.role_id;
        }
        public void setResource_id(String resource_id){
            this.resource_id=resource_id;
        }
        
        public String getResource_id(){
            return this.resource_id;
        }

}