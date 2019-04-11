<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="js/system/customer/list.js"></script>
<html lang="zh-CN">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title></title>


<style type="text/css">
#datatable {
	width: 100% !important;
}

#datatable {
	width: 100% !important;
}
/*数据表格标题文字居中*/
.table th {
	text-align: center;
	vertical-align: middle !important;
}
.btn-s{
    width: 43px;
    height: 27px;
    padding: 5px 5px;
   margin-right:5px;
}
.ui-timepicker-div .ui-widget-header {
	margin-bottom: 8px;
}

.ui-timepicker-div dl {
	text-align: left;
}

.ui-timepicker-div dl dt {
	float: left;
	clear: left;
	padding: 0 0 0 5px;
}

.ui-timepicker-div dl dd {
	margin: 0 10px 10px 45%;
}

.ui-timepicker-div td {
	font-size: 90%;
}

.ui-tpicker-grid-label {
	background: none;
	border: none;
	margin: 0;
	padding: 0;
}

.ui-timepicker-rtl {
	direction: rtl;
}

.ui-timepicker-rtl dl {
	text-align: right;
	padding: 0 5px 0 0;
}

.ui-timepicker-rtl dl dt {
	float: right;
	clear: right;
}

.ui-timepicker-rtl dl dd {
	margin: 0 45% 10px 10px;
}
/*自己的样式*/
.mt30 {
	margin-top: 30px;
}

.mb60 {
	margin-bottom: 66px;
}

.mt10 {
	margin-top: 10px;
}

.mt15 {
	margin-top: 15px;
}
.ml{
 margin-left:40px;
}

.pad {
	padding: 0 10px;
}

button {
	width: 70px;
	height: 34px;
	/*background: #5CC691;*/
	outline: none;
	border: none;
	color: #fff;
	font-size: 14px;
}

.buttona {
	margin-right: 10px;
}

.form-control {
	height: 31px;
}

.layui-form-label {
	width: 110px;
}

.layui-form-label {
	font-weight: bold;
}

.layui-form input[type=checkbox], .layui-form input[type=radio],
	.layui-form select {
	display: block;
}

.radio-inline, .checkbox-inline {
	margin-bottom: 15px;
}

.layui-form-item {
	margin-bottom: 0;
}

.space {
	width: 100%;
	height: 1px;
	background: #ccc;
	margin-top: 10px;
}

.pda1 {
	position: absolute;
	top: 60px;
	right: 216px;
	z-index: 999;
}

.pda2 {
	position: absolute;
	top: 60px;
	right: 150px;
	z-index: 999;
}

.pda3 {
	position: absolute;
	top: 60px;
	right: 80px;
	z-index: 999;
}
table.dataTable tbody tr:hover {
  background-color: #bdebff;
}

</style>
</head>

<body>
<div id="matching" style="display: none;"></div>
	<!--body wrapper start-->
	<form action="" method="POST" role="form" id="form-test"
		class="form-inline">

		<div class="row">
			<div class="col-lg-12">
				<div class="col-lg-7">
					<div class="form-group pad">
						<label for="exampleInputName2">客户姓名：</label> <input type="text"
							class="form-control" id="customerName"
							name="customerFormMap.customerName" placeholder="请输入客户名">
					</div>

					<div class="form-group pad">
						<label for="exampleInputName2">电话号码：</label> <input type="tel"
							class="form-control" id="telephone"
							name="customerFormMap.telephone" placeholder="请输入客户电话">
					</div>
					<div class="form-group pad">
						<label for="exampleInputName2">跟进的关键词：</label> <input type="text"
							class="form-control" id="followa" name="customerFormMap.follow"
							placeholder="请输入跟进关键词">
					</div>
				</div>
				<div class="col-lg-5">
					<button style="margin-left: 10px;" class="btn btn-danger buttona "
						type="button" id="morea">
						更多 &nbsp;&nbsp;<span id="change"
							class="glyphicon glyphicon-triangle-bottom " aria-hidden="true"></span>
					</button>
					<button id="btn-test" type="button" class="btn btn-info  buttona">
						搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
							aria-hidden="true"></span>
					</button>
					<button id="addAccount" type="button"
						class="btn btn-success buttona">
						新增 &nbsp;&nbsp;<span class="glyphicon glyphicon-plus"
							aria-hidden="true"></span>
					</button>
					<button id="shareAccount" type="button"
						class="btn btn-info  buttona">
						共享 &nbsp;&nbsp;<span class="glyphicon glyphicon-open"
							aria-hidden="true"></span>
					</button>
					<c:forEach items="${res}" var="key" varStatus="s">

					${key.description}
						</c:forEach>

				</div>
			</div>
			<div id="morecontent" style="display: none;">
				<div class="col-lg-12 mt10">
					<div class="layui-form">
						<div class="layui-form-item">
							<div class="form-group pad" style="margin: 0 15px">
								<label for="exampleInputName2">录入时间：</label> <input type="text"
									class=" form-control test-item" id="screateDate"
									name="customerFormMap.screateDate" placeholder="请输入开始时间">----
								<input type="text" class="form-control test-item"
									id="ecreateDate" name="customerFormMap.ecreateDate"
									placeholder="请输入结束时间">


							</div>
							<div class="form-group pad">
								<label for="exampleInputName2">预算总价：</label> <input type="text"
									class="form-control" id="stotalPrice"
									name="customerFormMap.stotalPrice" placeholder="请输入起始价格">万----
								<input type="text" class="form-control" id="etotalPrice"
									name="customerFormMap.etotalPrice" placeholder="请输入最高价格">万
							</div>
							<!-- 	<div class="layui-inline">
									<label class="layui-form-label">跟进时间:</label>
									<div class="layui-input-inline">
										<input type="text" class="layui-input form-control" id="test10" placeholder=" 开始到结束 ">
									</div>
								</div>
								<label class="radio-inline">
						  <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 一周内
						</label>
								<label class="radio-inline">
						  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 两周内
						</label> -->
						</div>
					</div>

				</div>
				<div class="col-lg-12 mt10">

					<label for="exampleInputPassword1" class="pad"
						style="margin-left: 20px;">事业部：</label>
					<select	class="form-control" id="department"	name="customerFormMap.department" onchange="getUsera(this.value)"></select>
					<label for="exampleInputPassword1" class="pad">&nbsp;&nbsp;&nbsp;销售顾问：</label>
					<select class="form-control" id="userId"
						name="customerFormMap.userId"></select> <label
						for="exampleInputPassword1" class="pad">&nbsp;&nbsp;&nbsp;客户状态：</label>
					<select class="form-control m-b-10" id="state"
						name="customerFormMap.state">
						<option value="">请选择</option>
						<option value="1">新增客户</option>
						<option value="2">到访客户</option>
						<option value="4">成交客户</option>
						<option value="5">退单客户</option>
					</select> <label for="exampleInputPassword1" class="pad">&nbsp;&nbsp;&nbsp;购买用途：</label>
					<select class="form-control m-b-10" id="purpose"
						name="customerFormMap.purpose">
						<option value="">请选择</option>
						<option value="1">投资</option>
						<option value="2">自用</option>
					</select> <label for="exampleInputPassword1" class="pad">&nbsp;&nbsp;&nbsp;购买方向：</label>
					<select class="form-control m-b-10" id="apartment"
						name="customerFormMap.apartment">
						<option value="">请选择</option>
						<option value="1">商铺</option>
						<option value="2">公寓</option>
					</select> <label>&nbsp;&nbsp;&nbsp;信息来源：</label> <select
						class="form-control m-b-10" id="cusource"
						name="customerFormMap.cusource">
						<option value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择</option>
						<option value="9">主动T客户</option>
						<option value="0">网络名单</option>
						<option value="0">自身</option>
						<option value="1">网络（安居客端口）</option>
						<option value="2">网络（58同城端口）</option>
						<option value="3">网络（房发现端口）</option>
						<option value="4">网络（安居客供客）</option>
						<option value="5">网络（58同城供客）</option>
						<option value="6">网络（房发现供客）</option>
						<option value="7">自身（打街霸）</option>
						<option value="8">自身（朋友推荐）</option>
					</select>


				</div>
				<div class="col-lg-12 mt10">
					<!-- 		<div class="col-lg-3">
							<label for="exampleInputPassword1" class="pad">排序方式：</label>
						<input type="radio" class="" id="man" name="customerFormMap.date" checked="checked" value="createDate">&nbsp;&nbsp;&nbsp;注册时间 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" class="" id="woman" name="customerFormMap.date" value="trackDate">&nbsp;&nbsp;&nbsp;更进时间
					</div> -->
					<div class="col-lg-12 clearfix">
						<label for="exampleInputPassword1" class="pad pull-left mt10">排序方式：</label>
						<div class="radio-custom radio-info pull-left">
							<input type="radio" value="createDate"
								name="customerFormMap.date" id="infor"> <label
								for="infor">注册时间</label>
						</div>

						<div class="radio-custom radio-success pull-left">
							<input type="radio" value="trackDate" checked="checked"
								name="customerFormMap.date" id="success"> <label
								for="success">跟进时间</label>
						</div>
								<label for="exampleInputPassword1" class="pad pull-left mt10 ml">客户种类：</label>
					<div class=" radio-success pull-left mt10">
							&nbsp;&nbsp;<input type="radio" value="" 
								name="customerFormMap.intention" id="intentiona" checked="checked"> <label
								>&nbsp;&nbsp;所有</label>
						</div>
						<div class=" radio-success pull-left mt10">
							&nbsp;&nbsp;<input type="radio" value="1" 
								name="customerFormMap.intention" id="intentiona"> <label
								>&nbsp;&nbsp;A类客户</label>
						</div>

						<div class="  radio-success pull-left mt10">
							&nbsp;&nbsp;<input type="radio" value="2" 
								name="customerFormMap.intention" id="intentionb"> <label
								>&nbsp;&nbsp;B类客户</label>
						</div>
						<div class=" radio-success pull-left mt10">
							&nbsp;&nbsp;<input type="radio" value="3" 
								name="customerFormMap.intention" id="intentionc"> <label
								>&nbsp;&nbsp;C类客户</label>
						</div>
					</div>

	


				</div>
			</div>

			<div class="col-lg-12 ">
				<div class="space"></div>
			</div>
			<div class="col-lg-12  clearfix">
				<!-- 	<div class="col-lg-9">
						left notification start
						<div class="left-notification">
							<ul class="notification-menu">
								mail info start
								<li class="d-none">
									<a href=" javascript:;" class="btn btn-default dropdown-toggle info-number" style="line-height: 0px;">
										<i class="fa fa-envelope-o"></i>
										<input type="radio"  name="customerFormMap.followb" value="1" id="error"/>
										<label for="error" style="color: #000; font-size: 14px;">漏跟</label>
										<span class="badge bg-danger">6</span>
										
									</a>

								</li>
								mail info end

								task info start
								<li class="d-none">
									<a href="javascript:;" class="btn btn-default dropdown-toggle info-number" style="line-height: 0px;">
										<i class="fa fa-tasks"></i>
										<input type="radio"  name="customerFormMap.followb" value="2" id="warning"/>
										<label for="warning" style="color: #000; font-size: 14px;">今日待跟</label>
										<span class="badge bg-success">9</span>
									</a>

								</li>
								task info end

								notification info start
								<li>
									<a href="javascript:;" class="btn btn-default dropdown-toggle info-number" style="line-height: 0px;">
										<i class="fa fa-bell-o"></i>
										<input type="radio" name="customerFormMap.followb" value="3" id="info-t" />
										<label for="info-t" style="color: #000; font-size: 14px;">今日已跟</label>
										<span class="badge bg-warning">4</span>
									</a>

								</li>
								<li>
									<a href="javascript:;" class="btn btn-default dropdown-toggle info-number" style="line-height: 0px;">
										<i class="fa fa-bell-o"></i>
										<input type="radio" name="radio" />&nbsp;&nbsp;<span style="color: #000; font-size: 14px;">明日待跟</span>
										<span class="badge bg-warning">4</span>
										<input type="radio"  name="customerFormMap.followb" value="4" id="success">
										<label for="success" style="color: #000; font-size: 14px;">明日待跟</label>
										<span class="badge bg-primary ">4</span>
										
									</a>
									</li>
								notification info end
							</ul>
						</div>
						left notification end
					</div> 
				 -->
				<div class="pull-right mt15">
					<div class="form-group" id="checkBoxGroup">

						<!-- 
						 <label class="checkbox-custom inline check-primary pda"> <input
							type="checkbox" value="1" id="personal" checked="checked"
							name='customerFormMap.choice'> <label style="font-weight: bold;">个人</label>
						</label> 
						<label class="checkbox-custom inline check-success pda"> <input
							type="checkbox" value="2" id="customers"
							name='customerFormMap.choice'> <label  style="font-weight: bold;">部门</label>
						</label>
						 <label class="checkbox-custom inline check-info pda"> <input
							type="checkbox" value="3" id="alls"
							name='customerFormMap.choice'> <label 	style="font-weight: bold;">所有</label>
						</label> 
							 -->
					</div>
					<button class="btn btn-info" type="button" id="refresh">
						查看 &nbsp;&nbsp;<span class="glyphicon glyphicon-refresh"
							aria-hidden="true"></span>
					</button>
				</div>
			</div>

		</div>
		<!--最外层-->

	</form>

	<!--body wrapper end-->
	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_content">

					<!-- 数据table代码 -->
					<table id="datatable" class="table table-striped table-bordered table-hover table-condensed"
						style="text-align: center; vertical-align: middle !important">
						<thead>
							<tr>

								<th>选择</th>
								<th>客户姓名</th>
								<th>客户姓名</th>
								<th>联系方式</th>
								<th>性别</th>

								<th>预算总价</th>
								<th>购买用途</th>
								<th>购买方向</th>
								<th>意向指数</th>
								<th>状态</th>
								<th>信息来源</th>
								<th>销售顾问</th>
								<th>事业部</th>
								<!-- <th>最新跟进时间</th> -->
								<th>跟进提醒</th>
								<th>操作</th>
								
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>


	<div class="table-responsive">
		<div id="paging" class="pagclass"></div>
	</div>


	<script type="text/javascript">

	$(function() {
		getDepartment(-1,-1);

	});
    function matchproject(){
        $.ajax({
            "url":"./match/addcumatch.shtml",
            "data":"",
            "type":"post",
            "elevator":"json",
            "success":function(obj) {

                var a=new Array();
                for(i=0;i<obj.length;i++){
                a.push(obj[i].projectName);
                    var str ="<div style='color:#68b5ff'>"+obj[i].projectName +"</div>";
                        $("#matching").append(str);
                }
                var str=a.join("/n");
                layer.open({
                    type: 1,
                    time:10000,
                    title: '新增客户有如下匹配项目',
                    closeBtn: 1, //不显示关闭按钮
                    area: ['340px', '220px'],
                    skin: 'layui-layer-lan',
                    move:false,
                    shade: 0,
                    offset: 'rb', //右下角弹出
                    anim: 2,
                    content: $("#matching"),
                    btn: ['关闭提醒','查看更多'],
                    btn2: function(index, layero){
            	    }
         		   }, function(index, layero){

                });
            }
            });

    }
	//当部门列表发生改变时,调用getUser函数获取城市信息
	function getUsera(userCode){
		$.ajax({
			"url":"./dict/showUser.shtml",
			"data":"departCode="+userCode,
            "type":"GET",
            "dataType":"json",
			"success":function(obj){
				$("#userId").html("<option class='form-control m-b-10' value=0> - - - -选择销售- - - - </option>");
				for(i=0;i<obj.length;i++){
					var str = "<option class='form-control m-b-10' value="+obj[i].id+">"+obj[i].userName+"</option>";
					$("#userId").append(str);
				}
				if(userCode!=-1){

				}
			},
			  error : function() {
	              alert("请与管理员联系");
	          }
		});

	}
	//加载页面完成,就调用dict/showDepart.shtml
	function getDepartment(departCode,userCode){
		$.ajax({
			"url":"./dict/showDepart.shtml",
			"data":"",
            "type":"GET",
            "dataType":"json",
			"success":function(obj){

					$("#department").html("<option class='form-control m-b-10' value=0> - - - -选择部门- - - - </option>");

			for(var i = 0;i<obj.length;i++){
					var str="<option class='form-control m-b-10' value="+obj[i].id+">"+obj[i].name+"</option>";
					console.log("3"+obj[i])
					$("#department").append(str);
				}
				if(departCode!=-1){
					$("#department").val(id);
				}
				
			},
		  error : function() {  
	        alert("请与管理员联系");  
	    }  			
		});
		
		getUsera(userCode);
	}

</script>
	<script>
layui.use('laydate', function() {
	var laydate = layui.laydate;

	//同时绑定多个
	lay('.test-item').each(function() {
		laydate.render({
			elem: this,
			
			trigger: 'click'
			
			 ,max: 1 //今天以前
			
		});
	});
});


 $(".checkbox-custom").click(function(){
     $(".checkbox-custom").find("input[type='checkbox']").prop("checked", false);//每次点击前，将所有checkbox置为 未选中
     var cobj = $(this).find("input[type='checkbox']");//当前点击的checkbox
     cobj.prop("checked", true);//将当前点击的checkbox置为选中状态
     var c=$('input[type=checkbox]:checked').val();
     console.log(c);
}) 

</script>


</body>

</html>

