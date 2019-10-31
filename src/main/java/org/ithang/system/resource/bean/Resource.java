package org.ithang.system.resource.bean;

/**
 * 
 * @author zyt
 *
 */
public class Resource{

        private String id;//
        private String type;//
        private String title;//


        public void setId(String id){
            this.id=id;
        }
        
        public String getId(){
            return this.id;
        }
        public void setType(String type){
            this.type=type;
        }
        
        public String getType(){
            return this.type;
        }
        public void setTitle(String title){
            this.title=title;
        }
        
        public String getTitle(){
            return this.title;
        }

}