package org.ithang.system.keyvalue.bean;

/**
 * 字典表
 * @author zyt
 *
 */
public class Keyvalue{

        private String key;//英文标识
        private String value;//值
        private String title;//中文名称


        public void setKey(String key){
            this.key=key;
        }
        
        public String getKey(){
            return this.key;
        }
        public void setValue(String value){
            this.value=value;
        }
        
        public String getValue(){
            return this.value;
        }
        public void setTitle(String title){
            this.title=title;
        }
        
        public String getTitle(){
            return this.title;
        }

}