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


    <#list fields as fd>
        public void set${fd.column_name?cap_first}(${fd.javaType!"String"} ${fd.column_name}){
            this.${fd.column_name}=${fd.column_name};
        }
        
        public ${fd.javaType!"String"} get${fd.column_name?cap_first}(){
            return this.${fd.column_name};
        }
    </#list>

}