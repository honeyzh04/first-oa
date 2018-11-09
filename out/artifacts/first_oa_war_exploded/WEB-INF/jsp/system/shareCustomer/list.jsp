<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="js/system/shareCustomer/list.js"></script>
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

 
.space {
	width: 100%;
	height: 1px;
	background: #ccc;
	margin-top: 10px;
}

table.dataTable tbody tr:hover {
  background-color: #bdebff;
}

</style>
</head>

<body>
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
				
					<c:forEach items="${res}" var="key" varStatus="s">

					${key.description}
						</c:forEach>
				</div>
				<div class="col-lg-5">
				
					<button id="btn-test" type="button" class="btn btn-info  buttona">
						搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
							aria-hidden="true"></span>
					</button>
					<button id="outAccount" type="button"
						class="btn btn-success buttona">
						退出 &nbsp;&nbsp;<span class="glyphicon glyphicon-remove"
							aria-hidden="true"></span>
					</button>


				</div>
			</div>
			

			<div class="col-lg-12 ">
				<div class="space"></div>
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


	<script>

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

