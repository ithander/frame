<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>&nbsp;</title>
    </head>
    <body>

        <form id="fm" method="post" action="/${path}/${beanName}/add">
            <#list fields as fd>
                <div style="margin-bottom:20px">
                <#if fd.javaType=="String">
                    <input class="easyui-textbox" name="${fd.column_name}" style="width:100%" value="<#noparse>${(</#noparse>${fd.column_name}<#noparse>)!}</#noparse>" data-options="label:'${fd.column_name}:',required:true">
                </#if>
                
                <#if fd.javaType=="Integer">
                    <input class="easyui-numberbox" name="${fd.column_name}" style="width:100%" value="<#noparse>${(</#noparse>${fd.column_name}<#noparse>)!}</#noparse>" data-options="label:'${fd.column_name}:',required:true">
                </#if>
                
                <#if fd.javaType=="Long">
                    <input class="easyui-numberbox" name="${fd.column_name}" style="width:100%" value="<#noparse>${(</#noparse>${fd.column_name}<#noparse>)!}</#noparse>" data-options="label:'${fd.column_name}:',required:true">
                </#if>
                </div>
            </#list>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">保存</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">重置</a>
        </div>
       
       <script type="text/javascript">
            function submitForm(){
                $('#fm').form('submit',{
                	success:function(){
                		$('#form').dialog('close');
                	}
                });
            }
            function clearForm(){
                $('#fm').form('clear');
            }
       </script>
    </body>
     
</html>