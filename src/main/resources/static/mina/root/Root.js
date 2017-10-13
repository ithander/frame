Ext.define('mina.root.Root',{
	alias:'Root',
	constructor:function(){
		body=Ext.getBody();
	},
    body:null,
    getBody:function(){
    	if(null==body){
    		body=Ext.getBody();
    	}
    	return body;
    }
})