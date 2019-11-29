package ${basePkg}.${beanName}.bean;

/**
 * ${tabComment}
 * @author zyt
 *
 */
public class ${BeanName}{

    <#list fields as fd>
        private ${fd.javaType!"String"} ${fd.column_name};//${fd.column_comment!""}
    </#list>
    
    <#if genField??>
        <#list genField as fd>
            private ${fd.addtype!"String"} ${fd.addname};
        </#list>
    </#if>
    


    <#list fields as fd>
        public void set${fd.column_name?cap_first}(${fd.javaType!"String"} ${fd.column_name}){
            this.${fd.column_name}=${fd.column_name};
        }
        
        public ${fd.javaType!"String"} get${fd.column_name?cap_first}(){
            return this.${fd.column_name};
        }
    </#list>
    
    <#if genField??>
        <#list genField as fd>
            public void set${fd.addname?cap_first}(${fd.addtype!"String"} ${fd.addname}){
	            this.${fd.addname}=${fd.addname};
	        }
	        
	        public ${fd.addtype!"String"} get${fd.addname?cap_first}(){
	            return this.${fd.addname};
	        }
        </#list>
    </#if>

}