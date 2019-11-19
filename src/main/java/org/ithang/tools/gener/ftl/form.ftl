<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>&nbsp;</title>
    </head>
    <body>
        <#noparse><#if</#noparse> ${beanName!}<#noparse>??></#noparse>
         <form id="fm" method="post" action="/${path}/${beanName}/update">
         <input type="hidden" name="${priKey!}" value="<#noparse>${(</#noparse>${beanName}.${priKey}<#noparse>)!}</#noparse>">
        <#noparse><#else></#noparse>
         <form id="fm" method="post" action="/${path}/${beanName}/add">
        <#noparse></#if></#noparse>
        
            <#list fields as fd>
                <div style="margin-bottom:10px">
                <#if fd.javaType=="String">
                        <input class="easyui-textbox" name="${fd.column_name!}" style="width:100%" value="<#noparse>${(</#noparse>${beanName}.${fd.column_name}<#noparse>)!}</#noparse>" data-options="label:'${fd.column_name}:',required:true">
                 <#else>
                        <input class="easyui-numberbox" name="${fd.column_name!}" style="width:100%" value="<#noparse>${(</#noparse>${beanName}.${fd.column_name}<#noparse>)!}</#noparse>" data-options="label:'${fd.column_name}:',required:true">
                </#if>
                </div>
            </#list>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">保存</a>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <#noparse><#if </#noparse>${beanName}<#noparse>??></#noparse>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="closeForm()" style="width:80px">关闭</a>
            <#noparse><#else> </#noparse>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">重置</a>
            <#noparse></#if></#noparse>
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
            function closeForm(){
            	$('#form').dialog('close');
            }
       </script>
    </body>
     
</html>