<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript"
	src="${ctx}/js/system/customer/share.js"></script>

<style type="text/css">
.from-con {
	width: 30%;
	height: 30px;
	text-align: center;
	border: 1px solid #ddd;
	margin-right: 2%;
}


.mt10 {
	margin-top: 10px;
	margin-right: 10px;
}
</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/customer/shareEntity.shtml">
		<input type="hidden" class="form-control checkacc"
			value="${customer.id}" name="customerFormMap.customerId" id="customerId">
			 <input type="hidden" class="form-control checkacc" value="${customer.userId}"
			name="customerFormMap.userId" id="userId">
		 <input type="hidden" class="form-control checkacc" value=""
			name="customerFormMap.userIds" id="userIds">
		<div class="modal-body">
			<p>
				<label>客户共享选择：</label>
			</p>
			<div class="text-center">
			
				<select class="form-control selectpicker" data-style="btn-info" 
					title="请选择需要共享的经纪人" data-live-search="true"
					data-live-search-placeholder="搜索" id="receiverDepartment"
					 name="customerFormMap.user" multiple>
					<optgroup id="departmente" label="东区一部">
					</optgroup>
					<optgroup id="departmentw" label="西区一部">
					</optgroup>
					<optgroup id="departments1" label="南区一部">
					</optgroup>
					<optgroup id="departments2" label="南区二部">
					</optgroup>
					<optgroup id="departments3" label="南区三部">
					</optgroup>
					<optgroup id="departmentn" label="北区一部">
					</optgroup>
					<optgroup id="departmentk" label="客服部">
					</optgroup>
				</select> 
			</div>
		</div>

		<button  type="button" id="btn-test" class="btn btn-primary pull-right mt10">确定</button>
		
	</form>
	<script type="text/javascript">
		//页面加载完成执行
		$(function() {
			getDepartment();
			

	
			
			$("#btn-test").click(function(){
				var o = document.getElementById("receiverDepartment");//获取多选内容
				var str = []; 
	        	for(var i=0;i<o.length;i++){     
	                if(o.options[i].selected){  
	                    str.push(o.options[i].value);  
	                }  
	    	    }
	        	 $("#userIds").val(str);
	        	
				 
			    $(this).attr("disabled","true"); //设置变灰按钮
			    $("#form").submit();//提交表单
			    setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示
			     
			});
		});
		//加载页面完成,就调用dict/showDepart.shtml
		function getDepartment() {
			$.ajax({
				"url" : "../dict/allUser.shtml",
				"data" : "",
				"type" : "GET",
				"dataType" : "json",
				"success" : function(obj) {
					
					for (var i = 0; i < obj.length; i++) {

						if (obj[i].v == 16) {

							var str = "<option  value="+obj[i].id+">"
									+ obj[i].userName + "</option>";
							$("#departmente").append(str);
						} else if (obj[i].v == 18) {
							var str = "<option  value="+obj[i].id+">"
									+ obj[i].userName + "</option>";
							$("#departmentw").append(str);
						} else if (obj[i].v == 20) {
							var str = "<option  value="+obj[i].id+">"
									+ obj[i].userName + "</option>";
							$("#departments1").append(str);
						} else if (obj[i].v == 21) {
							var str = "<option  value="+obj[i].id+">"
									+ obj[i].userName + "</option>";
							$("#departments2").append(str);
						} else if (obj[i].v == 26) {
							var str = "<option  value="+obj[i].id+">"
									+ obj[i].userName + "</option>";
							$("#departments3").append(str);
						} else if (obj[i].v == 24) {
							var str = "<option  value="+obj[i].id+">"
									+ obj[i].userName + "</option>";
							$("#departmentn").append(str);
						}else if (obj[i].v == 28) {
							var str = "<option  value="+obj[i].id+">"
							+ obj[i].userName + "</option>";
							$("#departmentk").append(str);
				}

					}

					$("#receiverDepartment").selectpicker("refresh");
					$("#receiverDepartment").selectpicker("render");
				},
				error : function() {
					alert("请与管理员联系");
				}
			});

		}
	</script>
</body>
</html>