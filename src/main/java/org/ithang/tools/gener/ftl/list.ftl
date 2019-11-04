<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
	    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="/easyui/themes/color.css">
        <script type="text/javascript" src="/easyui/jquery.min.js"></script>
        <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
        <link rel="stylesheet" href="/layui/css/layui.css" media="all">
        <script type="text/javascript" src="/layui/layui.all.js"></script>
        <script type="text/javascript" src="/easyui/locale/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript" src="/easyui/plugins/datagrid-filter.js"></script>
    </head>
    <body>
         <table id="dat" class="easyui-datagrid" title="" data-options="fit:true,singleSelect:false,
                                                                   selectOnCheck:true,ctrlSelect:true,
                                                                   fitColumns:true,rownumbers:true,remoteFilter: true,
                                                                   collapsible:true,pagination:true,clientPaging: false,
                                                                   url:'/${path}/${beanName}/page',collapsible:false,idField:'key',
                                                                   method:'post',toolbar:toolbars,pageSize:20">
	        <thead>
	            <tr>
	                <#list fields as fd>
	                     <th data-options="field:'${fd.column_name}',width:200">${fd.column_name}</th>
	                </#list>
	            </tr>
	        </thead>
	        
	    </table>
	    <div id="form" style="width:100%;padding:30px 60px;"></div>
    </body>
    <script type="text/javascript">
		    var toolbars = [{
		        text:'新增',
		        iconCls:'icon-add',
		        handler:function(){
		        	$('#form').dialog({
		        	    title: '新增表单',
		        	    width: 500,
		        	    height: 380,
		        	    closed: false,
		        	    cache: false,
		        	    href: '/to?page=system/${beanName}/form',
		        	    modal: true,
		        	    onClose:function(){
		        	    	$('#dat').datagrid('reload');
		        	    },
		        	    onDestroy:function(){
		        	    	$('#dat').datagrid('reload');
		        	    }
		        	});
		        }
		    },{
		        text:'修改',
		        iconCls:'icon-edit',
		        handler:function(){
		        	var data=$('#dat').datagrid('getSelected');
		        	if(data&&data.key){
		        		$('#form').dialog({
			        	    title: '修改表单',
			        	    width: 500,
			        	    height: 380,
			        	    closed: false,
			        	    cache: false,
			        	    href: '/${path}/${beanName}/form?${priKey!"id"}='+data.${priKey!"id"},
			        	    modal: true,
			        	    onClose:function(){
			        	    	$('#dat').datagrid('reload');
			        	    },
			        	    onDestroy:function(){
			        	    	$('#dat').datagrid('reload');
			        	    }
			        	});
		        	}else{
		        		layer.alert('请选择记录');
		        	}
		        }
		    },'-',{
		        text:'删除',
		        iconCls:'icon-remove',
		        handler:function(){
		        	var data=$('#dat').datagrid('getSelections');
		        	if(data&&data.length>0){
		        		layer.confirm('确定要删除码?',function(index){
		        			var key='';
		        			var ids='';
		        			if(data instanceof Array){
		        				$.each(data,function(index,value){
	                            	if(index>0){
	                            		ids+=',';
	                            	}
	                            	ids+=value.${priKey!"id"};
	                            })
		        			}else{
		        				key=data.${priKey!"id"};
		        			}
		        			
                            
                            
                            $.post('/${path}/${beanName}/delete',{'key':key,'ids':ids},function(r){
                            	if(r.code>0){
                            		layer.alert('删除失败',function(){
                            			layer.close(index);			
                            		});
                            	}else{
                            		layer.close(index);
                            		$('#dat').datagrid('reload');
                            	}
                            },"json")
		        			
		        		});
		        	}
		        }
		    },{
		    	text:'刷新',
		    	iconCls:'icon-reload',
		        handler:function(){
		        	$('#dat').datagrid('reload');
		        }
		    }];
		    
		    
		    $('#dat').datagrid({
		    	loader:function(params,success,error){
		    		var pm={'pageNow':1,'pageSize':20};
		    		if(params&&params.page){
		    			pm.pageNow=params.page;
		    		}
		    		if(params&&params.rows){
		    			pm.pageSize=params.rows;
		    		}
		    		if(params&&params.filterRules){
		    			$.each(JSON.parse(params.filterRules),function(index,item){
		    				pm[item.field]=item.value;
		    			})
		    		}
		    		$.post('/${path}/${beanName}/page',pm,function(r){
		    			success(r.result);
		    		},"json")
		    	},
		    	loadFilter: function(r){
		    		if (r){
		    			return {'rows':r.data,'total':r.total};
		    		}
		    	},
		    	onLoadSuccess:function(){
		    		$('#dat').datagrid('enableFilter');
		    	}
		    });
		    
		    
		    
		  		   
		 		    
    </script>
</html>