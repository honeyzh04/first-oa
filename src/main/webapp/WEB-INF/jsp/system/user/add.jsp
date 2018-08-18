<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/user/add.js">
	
</script>
<style type="text/css">
.col-sm-3 {
	width: 15%;
	float: left;
	text-align: right;
}

.col-sm-9 {
	width: 85%;
	float: left;
	text-align: left;
}

label[class^="btn btn-default"] {
	margin-top: -4px;
}
.fz{
				 margin: 20px 20px 10px;
				font-size: 18px;
				font-weight: bold;
			}
.mt10 {
	margin-right: 20px;
	
}
</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/user/addEntity.shtml">
		<section class="panel panel-default">
		  <p class="fz">注册用户：</p>
		<div class="panel-body">

			<div class="form-group">
				<label class="col-sm-3 control-label">账号</label>
				<div class="col-sm-9">
					<input type="text" class="form-control checkacc"
						placeholder="请输入账号" name="userFormMap.accountName"
						id="accountName">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">姓名</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入用户名"
						name="userFormMap.userName" id="userName">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">密码</label>
				<div class="col-sm-9" style="color: #53D192;">默认密码为:123456</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">部门</label>
				<div class="col-sm-9">
					<select class="form-control" id="adepartment"
						name="userFormMap.department">
					</select>
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group" id="selRole" data-url="/role/selRole.shtml"></div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">性别</label>
				<div class="col-sm-9">
					<input id="man" type="radio" checked="checked" value="1 "
						name="userFormMap.gender" />男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="woman" type="radio" value="2" name="userFormMap.gender" />女
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">邮箱</label>
				<div class="col-sm-9">
					<input type="text" class="form-control " placeholder="请输入邮箱"
						name="userFormMap.email" id="email">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">电话</label>
				<div class="col-sm-9">
					<input type="text" class="form-control " placeholder="请输入电话"
						name="userFormMap.telephone" id="telephone">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">描述</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入账号描述"
						name="userFormMap.description" id="description">
				</div>
			</div>
		</div>

		</section>

		<button type="submit" class="btn btn-success pull-right  mt10">提交</button>

	</form>

	<script type="text/javascript">
	
	$(function() {
		
		onloadurl();
		getDepartment();
		
	
	});
	
	function getDepartment() {
		$.ajax({
			"url" : "../dict/showDepart.shtml",
			"data" :"" ,
			"type" : "GET",
			"dataType" : "json",
			"success" : function(obj) {
				$("#adepartment").html("<option value=0> 请选择</option>");
				for (i = 0; i < obj.length; i++) {
					var str = "<option value="+obj[i].id+">"+obj[i].name+"</option>";
					$("#adepartment").append(str);
				}
				
			},
			error : function() {
				alert("请与管理员联系");
			}
		});

	}
	
	</script>


</body>
</html>