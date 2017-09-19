<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>后台管理</title>
        <#include "common/header.ftl">
    </head>
    <body>
        <div class="layui-carousel" id="test1">
            <div carousel-item>
                <div>条目1</div>
                <div>条目2</div>
                <div>条目3</div>
                <div>条目4</div>
                <div>条目5</div>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        layui.use(['layer','carousel'], function(){
            var layer = layui.layer;
            layer.msg('hello');
            
            
            var carousel = layui.carousel;
			  //建造实例
			  carousel.render({
			    elem: '#test1'
			    ,width: '100%' //设置容器宽度
			    ,arrow: 'always' //始终显示箭头
			    //,anim: 'updown' //切换动画方式
			  });
            
        });
    </script>
</html>