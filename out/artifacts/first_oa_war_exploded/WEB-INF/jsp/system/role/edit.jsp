<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/role/edit.js"></script>
</script>
<style type="text/css">
.col-sm-3 {
	width: 15%;
	float: left;
}

.col-sm-9 {
	width: 85%;
	float: left;
}
label[class^="btn btn-default"]{
	margin-top: -4px;
}
	 .mt10{
            	margin-top: 50px;
            	margin-right: 20px;
            }
</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/role/editEntity.shtml">
		<input type="hidden" class="form-control checkacc"
			value="${role.id}" name="roleFormMap.id" id="id">
		<section class="panel panel-default">
		<div class="panel-body">
			<div class="form-group">
				<label class="col-sm-3 control-label">职位名</label>
				<div class="col-sm-9">
					<input type="text" class="form-control checkacc"
						placeholder="请输入角色名" value="${role.name}" name="roleFormMap.roleName" id="roleName" >
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
				<div class="form-group">
				<label class="col-sm-3 control-label">职位编号</label>
				<div class="col-sm-9">
					<input type="text" class="form-control roleCode" placeholder="请输入职位编号"
						value="${role.roleCode}" name="roleFormMap.roleCode"  id="roleCode">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">roleKey</label>
				<div class="col-sm-9">
					<input type="text" class="form-control roleKey"
						placeholder="请输入唯一值roleKey" value="${role.roleKey}" name="roleFormMap.roleKey" id="roleKey">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">描述</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="请输入账号描述"
						name="roleFormMap.description" value="${role.description}" id="description">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-3 control-label">角色状态</label>
				<div class="col-sm-9">
						
							<select name="roleFormMap.state" class="form-control" >
								<option value="0">可用</option>
								<option value="1">不可用</option>
							</select>
				
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
		</div>
	</div>	
				<button type="submit" class="btn btn-success pull-right mt10">确定</button>
		</section>
	</form>
</body>
</html>