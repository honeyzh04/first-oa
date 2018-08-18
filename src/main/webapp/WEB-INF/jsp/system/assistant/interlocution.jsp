<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="/common/common.jspf"%>
	<script type="text/javascript" src="${ctx}/js/system/assistant/interlocution.js"></script>
	<style type="text/css">
		.col-sm-3 {
			width: 20%;
			float: left;
		}
		.col-sm-9 {
			width: 80%;
			float: left;
		}
	</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<form id="formUpdatePwd" name="form" class="form-horizontal" method="post" action="${ctx}/user/editPassword.shtml">
		<input type="hidden" class="form-control checkacc" value="${userSession.id}" name="userFormMap.id" id="id">

		
			<div class="panel-body col-lg-12">
	
					
					<div class="col-sm-9 ">
						<input type="text" class="form-control" placeholder="搜索你感兴趣的问题"  id="que" >
					</div>
					<div class=" col-sm-3 ">
					<button id="btn-test" type="button" onclick="find()" class="btn btn-info  buttona">
						搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
							aria-hidden="true"></span>
					</button>
					</div>
				</div>
				<div class="line line-dashed line-lg pull-in"></div>
		
		<div>
		
		<ol  id="userId" >
		
		
		</ol>
		</div>
		
	</form>
	<script type="text/javascript">

	function find(){
		$("#userId").html("");
		var que=$("#que").val();
		
		$.ajax({
			"url":"../interlocution/findQuestions.shtml",
			"data":"que="+que,
			"type":"GET",
			"dataType":"json",
			"success":function(obj){
				
				for(i=0;i<obj.length;i++){
					var str = "<li style='margin-Bottom:10px;border-Bottom:1px solid #dbdbdb; width:95%;margin-left:2.5%;'><div style='color:rgb(51,144,255); line-height:24px ;font-weight:500'>"+"Q:&nbsp;"+ obj[i].question+"</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</br>A:"+obj[i].answer+"</li>";
					$("#userId").append(str);
				};
				
			},
			  error : function() {  
	              alert("请与管理员联系");  
	          }  
		});
		
	}
	
	
	</script>
</body>
</html>