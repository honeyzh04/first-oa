<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
 <script type="text/javascript" src="${ctx}/js/system/customer/transfer.js"></script> 

<style type="text/css">
		.from-con{
            	width: 30%;
            	height: 30px;
            	text-align: center;
            	border: 1px solid #ddd;
            	margin-right: 2%;
            }
            .mt10{
            	margin-top: 10px;
            	margin-right: 10px;
            }
</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/customer/transferEntity.shtml">
		<input type="hidden" class="form-control checkacc"
			value="${customer.id}" name="customerFormMap.id" id="id">
			<input type="hidden" class="form-control checkacc"
			value="" name="customerFormMap.userName" id="userName">
		<section class="panel panel-default">
		    <div class="modal-body">
        <p><label>转出选择：</label></p>
        <div class="text-center">
        	<label>事业部：</label>
        	 <select  class="from-con" id="receiverDepartment" name="customerFormMap.department" onchange="getUser(this.value)">
      		 
      		  </select>
        	<label>销售顾问：</label>
        	<select	 class="from-con" id="receiverUser" name="customerFormMap.userId" >
        
        	</select>
        </div>
    </div>
		<button type="submit" class="btn btn-primary pull-right mt10">确定</button>
		</section>
	</form>
	<script type="text/javascript">

	//页面加载完成执行
		$(function(){
			getDepartment(-1,-1);
			
		});
	//加载页面完成,就调用dict/showDepart.shtml
	function getDepartment(departCode,userCode){
		$.ajax({
			"url":"../dict/showcuDepart.shtml",
			"data":"",
			"type":"GET",
			"dataType":"json",
			"success":function(obj){
					
				$("#receiverDepartment").html("<option class='form-control m-b-10' value=0> - - - -选择部门- - - - </option>");
				
				for(var i = 0;i<obj.length;i++){
					var str="<option class='form-control m-b-10' value="+obj[i].id+">"+obj[i].name+"</option>";
					$("#receiverDepartment").append(str);
				}
				if(departCode!=-1){
					$("#receiverDepartment").val(id);
				}
				
			},
		  error : function() {  
	        alert("请与管理员联系");  
	    }  			
		});
		
		getUser(userCode);
	}
//当部门列表发生改变时,调用getUser函数获取销售信息
function getUser(userCode){
	$.ajax({
		"url":"../dict/showUser.shtml",
		"data":"departCode="+userCode,
		"type":"GET",
		"dataType":"json",
		"success":function(obj){
			
			$("#receiverUser").html("<option class='form-control m-b-10' value=0> - - - -选择销售- - - - </option>");
			for(i=0;i<obj.length;i++){
				var str = "<option class='form-control m-b-10' value="+obj[i].id+">"+obj[i].userName+"</option>";
				$("#receiverUser").append(str);
			}
			if(userCode!=-1){
				
			}
		},
		  error : function() {  
              alert("请与管理员联系");  
          }  
	});

}

	//把userName重新赋值
	  $("#receiverUser").change(function(){
		  var username=$("#receiverUser").find("option:selected").text();
			var len = $("#userName").attr("value",username);
			
		    });
</script>
</body>
</html>