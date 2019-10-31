package org.ithang.system.role.bean;

/**
 * 
 * @author zyt
 *
 */
public class Role{

        private String id;//
        private String title;//


        public void setId(String id){
            this.id=id;
        }
        
        public String getId(){
            return this.id;
        }
        public void setTitle(String title){
            this.title=title;
        }
        
        public String getTitle(){
            return this.title;
        }

}