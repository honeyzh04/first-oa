

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/user/edit.js"></script>

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
		action="${ctx}/user/editEntity.shtml">
		<section class="panel panel-default">
		<input type="hidden" class="form-control checkacc"
			value="${user.id}" name="userFormMap.id" id="id">
		  <p class="fz">编辑用户：</p>
		<div class="panel-body">

			<div class="form-group">
				<label class="col-sm-3 control-label">账号</label>
				<div class="col-sm-9">
					<input type="text" class="form-control checkacc"
						placeholder="请输入账号" value="${user.accountName}" name="userFormMap.accountName"
						id="accountName" readonly="readonly">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<div class="col-sm-3">
					<label class="control-label">姓名</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入用户名"
						value="${user.userName}" name="userFormMap.userName" id="userName">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
			 <input type="hidden" id ="selectDepartment"  name="userFormMap.departmento" value="${user.department}"/>
				<label class="col-sm-3 control-label">部门</label>
				<div class="col-sm-9">
					<select class="form-control" id="adepartment"
						name="userFormMap.department">
					</select>
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div id="selGroup"
				data-url="/role/selRole.shtml?roleFormMap.userId=${user.id}"></div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<input type="hidden" id ="selectGender" value="${user.gender}"/>
				<label class="col-sm-3 control-label">性别</label>
				<div class="col-sm-9">
					 
					<input id="man" type="radio"  value="1" name="userFormMap.gender" />男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id="woman" type="radio" value="2" name="userFormMap.gender" />女
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">邮箱</label>
				<div class="col-sm-9">
					<input type="text" class="form-control " placeholder="请输入邮箱"
						value="${user.email}" name="userFormMap.email" id="email">
				</div>
			</div>

			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">电话</label>
				<div class="col-sm-9">
					<input type="text" class="form-control " placeholder="请输入电话"
					value="${user.telephone}"	name="userFormMap.telephone" id="telephone">
				</div>
			</div>
			

			<div class="line line-dashed line-lg pull-in"></div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label">状态</label>
				<div class="col-sm-9">
						 <input type="hidden" id ="selectLocked" value="${user.locked}"/>
							<select name="userFormMap.locked" id="locked"  class="form-control" >
							
								<option value="1" >可用</option>
								<option value="0" >不可用</option>
							</select>
				
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
		</div>
	
			<div class="form-group">
				<label class="col-sm-3 control-label">描述</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入账号描述"
						value="${user.description}" name="userFormMap.description" id="description">
				</div>
			</div>
		</div>

		</section>

		<button type="submit" class="btn btn-success pull-right  mt10">提交</button>

	</form>

	<script type="text/javascript">
	onloadurl();
	$(function() {
		
		
		getDepartment();
	    var locked=$("#selectLocked").val();
	    var gender=$("#selectGender").val();
	    var department=$("#selectDepartment").val();

	 
	     //根据值让option选中 
	     $("#locked option[value='"+locked+"']").attr("selected","selected"); 
	     $("#adepartment option[value='"+department+"']").attr("selected","selected"); 
	     $("input[name='userFormMap.gender'][value='"+gender+"'").attr("checked",true);
	});
	
	function getDepartment() {
		$.ajax({
			"url" : "../dict/showDepart.shtml",
			"data" :"" ,
			"type" : "GET",
			"dataType" : "json",
            async:false,
			"success" : function(obj) {
				$("#adepartment").html("<option value=0> 请选择</option>");
				for (i = 0; i < obj.length; i++) {
					var str = "<option value="+obj[i].id+">"+obj[i].name+"</option>";
					$("#adepartment").append(str);
				}
				
			},
			error : function() {
				layer.alert("请与管理员联系");
			}
		});

	}
	
	</script>


</body>
</html>		