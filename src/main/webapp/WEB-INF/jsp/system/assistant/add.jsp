<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/assistant/add.js">
	
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
		action="${ctx}/interlocution/addInterlocution.shtml">
		<section class="panel panel-default">
		  <p class="fz">写下你的问题：</p>
		<div class="panel-body">

			<div class="form-group">
				<label class="col-sm-3 control-label">问题</label>
				<div class="col-sm-9">
					<input type="text" class="form-control checkacc"
						placeholder="请输入经典问题" name="interlocutionFormMap.question"
						id="question">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
				<label class="col-sm-3 control-label">标签</label>
				<div class="col-sm-9">
					<input type="text" class="form-control checkacc"
						placeholder="给问题打上关键标签,如(位置;价格)" name="interlocutionFormMap.label"
						id="labe">
				</div>
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			<div class="form-group">
			<label for="" class="col-sm-3 control-label">问题描述(可选)</label>
				<div class="col-sm-9">
							
							<textarea 	id="describe"  style="resize:none" class="{required:true} form-control checkacc"  name="interlocutionFormMap.describe" rows="6" cols="60" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"  placeholder="问题背景,条件等详细信息"></textarea>
						</div>
			
			</div>
			<div class="line line-dashed line-lg pull-in"></div>
			</div>
			</section>

		<button type="button" class="btn btn-success pull-right  mt10" id="btn-test">提交问题</button>

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