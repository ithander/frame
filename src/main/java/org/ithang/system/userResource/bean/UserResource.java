package org.ithang.system.userResource.bean;

/**
 * 
 * @author zyt
 *
 */
public class UserResource{

        private Integer id;//
        private Integer user_id;//
        private Integer resource_id;//


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
        public void setResource_id(Integer resource_id){
            this.resource_id=resource_id;
        }
        
        public Integer getResource_id(){
            return this.resource_id;
        }

}