<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="/js/layui-date/layui.js"></script>
<link rel="stylesheet" type="text/css" href="/js/layui-date/css/layui.css">
<script type="text/javascript" src="js/system/statistics/list.js"></script>
		<div class="layui-tab layui-tab-brief"  lay-filter="docDemoTabBrief">
			<ul class="layui-tab-title">
				<li class="layui-this">日报表</li>
				<li  >周报表</li>
				<li>月报表</li>
			</ul>
			<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
<div class="layui-tab layui-tab-card site-demo-button" style="position: relative;">
  	<div class="datd_inp">
						<input type="text" class="form-control checkacc"
							placeholder="请选择时间" name="StatisticsFormMap.choiceday"
							id="choiceday">
					</div>
					<button id="btn-test" type="button" class="btn btn-info  buttona">
						搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
							aria-hidden="true"></span>
					</button>
					
					<table id="datatableday" class="table table-striped table-bordered"
						style="text-align: center; vertical-align: middle !important">
						<thead>
							<tr>
								<th>部门</th>
								<th>外部新增</th>
								<th>电话新增</th>
								<th>网络新增</th>
								<th>其他新增</th>
								<th>公共池新增</th>
								<th>转入新增</th>
								<th>跟进客户</th>
								<th>带访客户</th>
								<th>成交客户</th>
								
								<th>成交客户</th>
							</tr>
						</thead>
					</table>
					<table border="1">
  <tr>
    <th>Month</th>
    <th>Savings</th>
  </tr>
  <tr>
    <td><a href="#" data-url="b" data-title="选项b"  data-id="45" class="site-demo-active" data-type="tabAdd">选项b</a></td>
    <td><a href="#" data-url="b" data-title="选项b"  data-id="64" class="site-demo-active" data-type="tabAdd">选项b</a></td>
  </tr>
</table>
       <table lay-filter="demo">
  <thead>
    <tr>
      <th lay-data="{field:'username', width:100}">昵称</th>
      <th lay-data="{field:'experience', width:80, sort:true}">积分</th>
      <th lay-data="{field:'sign'}">签名</th>
    </tr> 
  </thead>
  <tbody>
    <tr>
      <td><a href="#" data-url="b" data-title="选项b"  data-id="22" class="site-demo-active" data-type="tabAdd">选项b</a></td>
      <td>66</td>
      <td>人生就像是一场修行a</td>
    </tr>
    <tr>
      <td><a href="#" data-url="b" data-title="选项b"  data-id="22" class="site-demo-active" data-type="tabAdd">选项b</a></td>
      <td>88</td>
      <td>人生就像是一场修行b</td>
    </tr>
    <tr>
      <td>贤心3</td>
      <td>33</td>
      <td>人生就像是一场修行c</td>
    </tr>
  </tbody>
</table>
 <table id="demo" lay-filter="test"></table>
       <div class="layui-nav-item layui-nav-itemed">
       
                    <a href="javascript:;">默认展开</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a data-url="a" data-id="11" data-title="选项a" href="#" class="site-demo-active" data-type="tabAdd">选项a</a>
                            	<div class="site-demo-active">aad</div>
                        </dd>
                        <dd>
                           <!--  <a href="#" data-url="b" data-title="选项b"  data-id="22" class="site-demo-active" data-type="tabAdd">选项b</a> -->
                        </dd>
                        <dd>
                            <a href="">跳转</a>
                        </dd>
                        
                    </dl>
                    
                </div>
            <div class="layui-tab" lay-filter="demo" lay-allowclose="true" style="margin-left: 200px;">
                <ul class="layui-tab-title">
                </ul>
                <ul class="rightmenu" style="display: none;position: absolute;">
                    <li data-type="closethis">关闭当前</li>
                    <li data-type="closeall">关闭所有</li>
                </ul>
                <div class="layui-tab-content">
                
                </div>
            </div>
 </div>
        </div>
       
        <div class="layui-tab-item">2
<table id="demo" lay-filter="test"></table>

        </div>
          <div class="layui-tab-item">3</div>
        </div>
        </div>
        <script>
layui.use('table', function(){
  var table = layui.table;
  
  //第一个实例
  table.render({
    elem: '#demo'
    ,height: 315
    ,url: './statistics/findBydepartMonth.shtml' //数据接口
    ,page: true //开启分页
    ,cols: [[ //表头
    	{field: 'bbb', title: 'ID', width:80, sort: true, fixed: 'left'}
      ,{field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
      ,{field: 'name', title: '用户名', width:80}
      ,{field: 'addw', title: '性别', width:80, sort: true}
      ,{field: 'adddh', title: '城市', width:80} 
      ,{field: 'addwl', title: '签名', width: 177}
      ,{field: 'addqt', title: '积分', width: 80, sort: true}
      ,{field: 'addg', title: '评分', width: 80, sort: true}
      ,{field: 'addz', title: '职业', width: 80}
      ,{field: 'vit', title: '财富', width: 135, sort: true}
      ,{field: 'dea', title: '财富', width: 135, sort: true}
      ,{field: 'follow', title: '财富', width: 135, sort: true,align:'center', toolbar: '#barDemo'}
    ]]
  });
  
});
</script>

<script type="text/html" id="barDemo">
	 <button id='editRow'  class='site-demo-active' type='button'>ds</button>
	<a href="#" data-url="b" data-title=""  data-id="223" class="site-demo-active" data-type="tabAdd">选项b</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  
  <!-- 这里同样支持 laytpl 语法，如： -->
  {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
  {{#  } }}
</script>

<script>

layui.use('element', function(){
	  var element = layui.element;
	  
	

	     
var $ = jQuery = layui.jquery;

var layer = layui.layer;

    //触发事件
    var active = {
        //在这里给active绑定几项事件，后面可通过active调用这些事件
        tabAdd: function(url,id,name) {
            //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
            //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
            element.tabAdd('demo', {
                title: name,
                content: '<iframe data-frameid="'+id+'" scrolling="auto" frameborder="0" src="'+url+'.html" style="width:100%;height:99%;"></iframe>',
                id: id //规定好的id
            })
             CustomRightClick(id); //给tab绑定右击事件
             FrameWH();  //计算ifram层的大小
        },
        tabChange: function(id) {
            //切换到指定Tab项
            element.tabChange('demo', id); //根据传入的id传入到指定的tab项
        }, 
        tabDelete: function (id) {
        element.tabDelete("demo", id);//删除
        }
        , tabDeleteAll: function (ids) {//删除所有
            $.each(ids, function (i,item) {
                element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
            })
        },
        aaa: function() {
        	alert("ces");
        }
    };


    //当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
    $('.site-demo-active').on('click', function() {
    	alert("das");
        var dataid = $(this);

        //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
        if ($(".layui-tab-title li[lay-id]").length <= 0) {
            //如果比零小，则直接打开新的tab项
            active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
        } else {
            //否则判断该tab项是否以及存在

            var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
            $.each($(".layui-tab-title li[lay-id]"), function () {
                //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                if ($(this).attr("lay-id") == dataid.attr("data-id")) {
                    isData = true;
                }
            })
            if (isData == false) {
                //标志为false 新增一个tab项
                active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
            }
        }
        //最后不管是否新增tab，最后都转到要打开的选项页面上
        active.tabChange(dataid.attr("data-id"));
    });

    function CustomRightClick(id) {
        //取消右键  rightmenu属性开始是隐藏的 ，当右击的时候显示，左击的时候隐藏
        $('.layui-tab-title li').on('contextmenu', function () { return false; })
        $('.layui-tab-title,.layui-tab-title li').click(function () {
            $('.rightmenu').hide();
        });
        //桌面点击右击 
        $('.layui-tab-title li').on('contextmenu', function (e) {
            var popupmenu = $(".rightmenu");
            popupmenu.find("li").attr("data-id",id); //在右键菜单中的标签绑定id属性

            //判断右侧菜单的位置 
            l = ($(document).width() - e.clientX) < popupmenu.width() ? (e.clientX - popupmenu.width()) : e.clientX;
            t = ($(document).height() - e.clientY) < popupmenu.height() ? (e.clientY - popupmenu.height()) : e.clientY;
            popupmenu.css({ left: l, top: t }).show(); //进行绝对定位
            //alert("右键菜单")
            return false;
        });
    }

    $(".rightmenu li").click(function () {

        //右键菜单中的选项被点击之后，判断type的类型，决定关闭所有还是关闭当前。
        if ($(this).attr("data-type") == "closethis") {
            //如果关闭当前，即根据显示右键菜单时所绑定的id，执行tabDelete
            active.tabDelete($(this).attr("data-id"))
        } else if ($(this).attr("data-type") == "closeall") {
            var tabtitle = $(".layui-tab-title li");
            var ids = new Array();
            $.each(tabtitle, function (i) {
                ids[i] = $(this).attr("lay-id");
            })
            //如果关闭所有 ，即将所有的lay-id放进数组，执行tabDeleteAll
            active.tabDeleteAll(ids);
        }

        $('.rightmenu').hide(); //最后再隐藏右键菜单
    })
    function FrameWH() {
        var h = $(window).height() -41- 10 - 60 -10-44 -10;
        $("iframe").css("height",h+"px");
    }

    $(window).resize(function () {
        FrameWH();
    })
    



function  discardCustomer(_this){  	 
	  alert("dsa");
		active.aaa();
		 active.tabAdd();
	 active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"),dataid.attr("data-title"));
 

}

});
		</script>
		
   
