<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/customer/extend.js"></script>

	<style type="text/css">
			html,body{margin:0;padding:0;overflow-x:hidden;overflow-y:hidden;}
            .from-con{
            	width: 60%;
            	height: 30px;
            	text-align: center;
            	border: 1px solid #ddd;
            }
            .fz{
				font-size: 18px;
				font-weight: bold;
			}
			.margin{
			   margin:20px;
			}
				  .mt10{
            	margin-top: 10px;
            	margin-right: 10px;
            }
		</style>
	</head>
	<body>
	
		<div class="msg">
		  
			<form id="form" name="form" class="form-preparation" method="post"
			action="${ctx}/customer/extendEntity.shtml">
			<input type="hidden" class="form-control checkacc"
			value="${customer.id}" name="extendFormMap.id" id="id">
			<section class="panel panel-default">
			 <div class="modal-body" >
				   <p class="fz">扩展信息：</p>
        <div class="text-center">
        	 <div class="modal-body">
					<label for="inputEmail3" class="control-label">客户姓名：</label>
					<input type="text" class="from-con" name="extendFormMap.customerName" id="customerName" value="${customer.customerName}" readonly="readonly"  />
				</div>
				<div class="form-group col-xs-12">
					<label for="inputEmail3" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性格：</label>
					<input type="text" class="from-con" name="extendFormMap.charactera" id=" " placeholder="请输入客户交流状态" value="${customer.charactera}" >
				</div>
				<div class="form-group col-xs-12">
					<label for="inputPassword3" class="control-label">备用电话：</label>
					<input type="tel" class="from-con" name="extendFormMap.telephone1" id="" placeholder="请输入客户备用电话" value="${customer.telephone1}" >
				</div>
				<div class="form-group col-xs-12">
					<label for="inputPassword3" class="control-label">出行方式：</label>
					<input type="text" class="from-con" name="extendFormMap.travel" id=" " placeholder="请输入客户出行方式" value="${customer.travel}" >
					</select>
				</div>
				<div class="form-group col-xs-12">
					<label for="inputPassword3" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;职业：</label>
					<input type="text" class="from-con" name="extendFormMap.job" id="" value="${customer.job}" placeholder="请输入客户职业">
				</div>
				<div class="form-group col-xs-12">
					<label for="inputPassword3" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址：</label>
					<input type="text" class="from-con" name="extendFormMap.address" id="" value="${customer.address}"placeholder="请输入地址">
				</div>
				<div class="form-group col-xs-12">
					<label for="inputPassword3" class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：</label>
					<input type="text" class="from-con" name="extendFormMap.description" id="" value="${customer.description}"placeholder="请输入客户扩展备注">
				</div>
        </div>
		
			</div>
			
				<button type="button" id="btn-test" class="btn btn-primary pull-right mt10">确定</button>
				</section>
				</form>
		</div>
	
		<script type="text/javascript">
		
		$("#btn-test").click(function(){
			 
		    $(this).attr("disabled","true"); //设置变灰按钮
		    $("#form").submit();//提交表单
		    setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示
		     
		})
		
		</script>
		

	</body>
</html>


