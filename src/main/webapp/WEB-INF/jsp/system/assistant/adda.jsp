<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/assistant/adda.js">
	
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
		action="${ctx}/interlocution/addaInterlocution.shtml">
		<input type="hidden" class="form-control checkacc"
			value="${interlocution.id}" name="interlocutionFormMap.id" id="id">
		<section class="panel panel-default">
		  <p class="fz">完善问题：</p>
		<div class="panel-body">

			<div class="form-group">
				<label class="col-sm-3 control-label">问题</label>
				<div class="col-sm-9">
					<input type="text" class="form-control checkacc"
						placeholder="请输入经典问题" name="interlocutionFormMap.question"
						id="question" readonly="readonly"  value="${interlocution.question}">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
			<label for="" class="col-sm-3 control-label">回答</label>
				<div class="col-sm-9">
							
							<textarea 	id="contenta"  style="resize:none" class="{required:true} form-control checkacc"  name="interlocutionFormMap.answer" rows="6" cols="60" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"  placeholder="请输入经典回答">${interlocution.answer}</textarea>
						</div>
			
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			</div>
			</section>

		<button type="button" class="btn btn-success pull-right  mt10" id="btn-test">保存</button>

	</form>

	<script type="text/javascript">
	
	$(function() {
		$("#btn-test").click(function(){
			 
		    $(this).attr("disabled","true"); //设置变灰按钮
		    $("#form").submit();//提交表单
		    setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示
		     
		});
	
	
	});

	</script>


</body>
</html>