<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="js/system/publicCustomer/list.js"></script>
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

#datatablea {
	width: 100% !important;
}
/*数据表格标题文字居中*/
.table th {
	text-align: center;
	vertical-align: middle !important;
}
.btn-s{
    width: 60px;
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

.pad {
	padding: 0 10px;
}

button {
	width: 80px;
	height: 34px;
	/*background: #5CC691;*/
	outline: none;
	border: none;
	color: #fff;
	font-size: 14px;
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

.row {
	margin-bottom: 30px;
}
</style>

</head>

<body>

	<div>
		<div>
			<input type="hidden" class="form-control checkacc" value="${user.id}"
				name="customerFormMap.userId" id="userId">
			<input type="hidden" class="form-control checkacc" value="${user.department}"
				name="customerFormMap.departmentId" id="departmentId">
		</div>
		<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
			<ul class="layui-tab-title">
				<li class="layui-this">蓝海</li>
				<li>公海</li>

			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<!--body wrapper start-->
					<form action="" method="POST" role="form" id="form-test"
						class="form-inline">

						<div class="row">
							<div class="col-lg-12">
								<div class="col-lg-9">
									<div class="form-group pad">
										<label for="exampleInputName2">客户姓名：</label> <input
											type="text" class="form-control" id="ccustomerName"
											name="customerFormMap.ccustomerName" placeholder="请输入客户名">
									</div>

									<div class="form-group pad">
										<label for="exampleInputName2">电话号码：</label> <input type="tel"
											class="form-control" id="ctelephone"
											name="customerFormMap.ctelephone" placeholder="请输入客户电话">
									</div>
									<div class="form-group pad">
										<label for="exampleInputName2">预算总价：</label> <input
											type="text" class="form-control" id="cstotalPrice"
											name="customerFormMap.cstotalPrice" placeholder="请输入起始价格">万----
										<input type="text" class="form-control" id="cetotalPrice"
											name="customerFormMap.cetotalPrice" placeholder="请输入最高价格">万
									</div>

								</div>
								<div class="col-lg-2">
									<button id="btn-customer" type="button" class="btn btn-info">
										搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
											aria-hidden="true"></span>
									</button>

								</div>
							</div>
							<div class="col-lg-12 mt10">
								<div class="col-lg-12 mt10" style="margin:0 10px;">

									<label>销售顾问：</label> <select class="form-control   m-b-10"
										id="cuserName" name="customerFormMap.cuserId"></select>&nbsp; &nbsp; &nbsp; <label>购买用途：</label>
									<select class="form-control m-b-10" id="cpurpose"
										name="customerFormMap.cpurpose">
										<option value="">请选择</option>
										<option value="1">投资</option>
										<option value="2">自用</option>
									</select>&nbsp; &nbsp; &nbsp;  <label>购买方向：</label> <select class="form-control m-b-10"
										id="capartment " name="customerFormMap.capartment ">
										<option value="">请选择</option>
										<option value="1">商铺</option>
										<option value="2">公寓</option>
									</select>



								</div>
							</div>

						</div>
						<!--最外层-->

					</form>
					<!-- 数据table代码 -->
					<table id="datatable" class="table table-striped table-bordered"
						style="text-align: center; vertical-align: middle !important">
						<thead>
							<tr>
								<th>客户姓名</th>
								<th>联系方式</th>
								<th>性别</th>
								<th>预算总价(万)</th>
								<th>投资用途</th>
								<th>购买方向</th>
								<th>信息来源</th>
								<th>销售顾问</th>
								<th>事业部</th>
								<th>最新跟进时间</th>
								<th>拾取</th>

							</tr>
						</thead>
					</table>

				</div>




				<div class="layui-tab-item">
					<!--body wrapper start-->
					<form action="" method="POST" role="form" id="form-test"
						class="form-inline">

						<div class="row">
							<div class="col-lg-12">
								<div class="col-lg-8">
									<div class="form-group pad">
										<label for="exampleInputName2">客户姓名：</label> <input
											type="text" class="form-control" id="acustomerName"
											name="customerFormMap.acustomerName" placeholder="请输入客户名">
									</div>

									<div class="form-group pad">
										<label for="exampleInputName2">电话号码：</label> <input type="tel"
											class="form-control" id="atelephone"
											name="customerFormMap.atelephone" placeholder="请输入客户电话">
									</div>
									<!-- 	<div class="form-group pad">
							<label for="exampleInputName2">跟进的关键词：</label>
							<input type="text" class="form-control" id="followa" name="customerFormMap.follow" placeholder="请输入跟进关键词">
						</div> -->
									<div class="form-group pad">
										<label for="exampleInputName2">预算总价：</label> <input
											type="text" class="form-control" id="astotalPrice"
											name="customerFormMap.astotalPrice" placeholder="请输入起始价格">万----
										<input type="text" class="form-control" id="aetotalPrice"
											name="customerFormMap.aetotalPrice" placeholder="请输入最高价格">万
									</div>
								</div>
								<div class="col-lg-4">
									<button style="margin-left: 10px;" class="btn btn-danger"
										type="button" id="morea">
										更多 &nbsp;&nbsp;<span id="change"
											class="glyphicon glyphicon-triangle-bottom"
											aria-hidden="true"></span>
									</button>
									<button id="btn-All" type="button" class="btn btn-info">
										搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
											aria-hidden="true"></span>
									</button>
									<button id='getcus'  class='btn btn-success' type='button'><i class='fa fa-edit'></i>&nbsp;&nbsp;拾取</button>
										
								<c:forEach items="${res}" var="key">
									${key.description}
										</c:forEach>
				
								</div>
							</div>
							<div id="morecontent" style="display: none;">
								<div class="col-lg-12 mt10">
									<div class="form-group pad" style="margin:0 15px">
										<label for="exampleInputName2">录入时间：</label> <input
											type="text" class=" form-control test-item" id="ascreateDate"
											name="customerFormMap.ascreateDate" placeholder="请输入开始时间">----
										<input type="text" class="form-control test-item"
											id="aecreateDate" name="customerFormMap.aecreateDate"
											placeholder="请输入结束时间">


									</div>


									<!-- 		<div class="layui-inline">
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
							

						<div class="col-lg-12">
							<div class="col-lg-5 mt10">

								<label for="exampleInputPassword1" class="pad">事业部：</label> <select
									class="form-control" id="adepartment"
									name="customerFormMap.adepartment"
									onchange="getUsera(this.value)"></select> 
									<label
									for="exampleInputPassword1" class="pad">销售顾问：</label>
									 <select
									class="form-control" id="auserId"
									name="customerFormMap.auserId"></select>




							</div>
							<div class="col-lg-6">
						
								</select> <label >购买用途：</label> <select
									class="form-control m-b-10" 
										id="apurpose" name="customerFormMap.apurpose">
									<option value="">请选择</option>
									<option value="1">投资</option>
									<option value="2">自用</option>
							
								</select> <label>购买方向：</label> <select
									class="form-control m-b-10" id="aapartment" name="customerFormMap.aapartment ">
									<option value="">请选择</option>
									<option value="1">商铺</option>
									<option value="2">公寓</option>
								</select>
								<label >信息来源：</label> <select
									class="form-control m-b-10" id="acusource" name="customerFormMap.acusource">
										<option value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择</option>
								<option value="9">主动T客户</option>
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
</div>
						</div>

						<!--最外层-->
						</div>
					</form>
					<!-- 数据table代码 -->
					<table id="datatablea" class="table table-striped table-bordered"
						style="text-align: center; vertical-align: middle !important">
						<thead>
							<tr>

								<th>选择</th>
								<th>客户姓名</th>
								<th>联系方式</th>
								<th>性别</th>
								<th>预算总价(万)</th>
								<th>投资用途</th>
								<th>购买方向</th>
								<th>信息来源</th>
							<!-- 	<th>销售顾问</th>
								<th>事业部</th>
								<th>最新跟进时间</th> -->
								<th>拾取</th>


							</tr>
						</thead>
					</table>

				</div>

			</div>
		</div>

	</div>

	<script>
		//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
		layui.use('element', function() {
			var element = layui.element;

			//…
		});
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			//同时绑定多个
			lay('.test-item').each(function() {
				laydate.render({
					elem: this,
					
					trigger: 'click'
					
						  ,max: 0 //今天以前
				});
			});
		});
		$(function() {
			var departmentId = $("#departmentId").val();

			getUser(departmentId);
			
			getDepartment(-1,-1);
		});
		
		function getUser(codeId) {
			$.ajax({
				"url" : "./dict/showUser.shtml",
				"data" : "departCode=" + codeId,
				"type" : "GET",
				"dataType" : "json",
				"success" : function(obj) {
					$("#cuserName").html("<option value=0> 请选择</option>");
					for (i = 0; i < obj.length; i++) {
						var str = "<option value="+obj[i].id+">"
								+ obj[i].userName + "</option>";
						$("#cuserName").append(str);
					}
					if (userCode != -1) {

					}
				},
				error : function() {
					alert("请与管理员联系");
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
					$("#auserId").html("<option class='form-control m-b-10' value=0> - - - -选择销售- - - - </option>");
					for(i=0;i<obj.length;i++){
						var str = "<option class='form-control m-b-10' value="+obj[i].id+">"+obj[i].userName+"</option>";
						$("#auserId").append(str);
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
				"url":"./dict/showcuDepart.shtml",
				"data":"",
				"type":"GET",
				"dataType":"json",
				"success":function(obj){
						$("#adepartment").html("<option class='form-control m-b-10' value=0> - - - -选择部门- - - - </option>");
					
					for(var i = 0;i<obj.length;i++){
						var str="<option class='form-control m-b-10' value="+obj[i].id+">"+obj[i].name+"</option>";
						$("#adepartment").append(str);
					}
					if(departCode!=-1){
						$("#adepartment").val(id);
					}
					
				},
			  error : function() {  
		        alert("请与管理员联系");  
		    }  			
			});
			
			getUsera(userCode);
		}
	
	</script>

</body>

</html>

