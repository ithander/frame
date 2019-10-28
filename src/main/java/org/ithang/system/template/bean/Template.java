package org.ithang.system.template.bean;

/**
 * 模板
 * @author zyt
 *
 */
public class Template{

        private String id;//
        private String title;//标题
        private String content;//内容
        private String create_time;//创建时间
        private String update_time;//修改时间


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
        public void setContent(String content){
            this.content=content;
        }
        
        public String getContent(){
            return this.content;
        }
        public void setCreate_time(String create_time){
            this.create_time=create_time;
        }
        
        public String getCreate_time(){
            return this.create_time;
        }
        public void setUpdate_time(String update_time){
            this.update_time=update_time;
        }
        
        public String getUpdate_time(){
            return this.update_time;
        }

}