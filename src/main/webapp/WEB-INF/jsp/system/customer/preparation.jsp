<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/customer/preparation.js"></script>

	<style type="text/css">
			.from-con{
            	width: 30%;
            	height: 30px;
            	text-align: center;
            	border: 1px solid #ddd;
            	margin-right: 2%;
            	margin-top: 2%;
            }
            .fz{
				font-size: 18px;
				font-weight: bold;
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
			action="${ctx}/customer/preparationEntity.shtml">
			<input type="hidden" class="form-control checkacc"
			value="${customer.id}" name="customerFormMap.id" id="id">
			<section class="panel panel-default">
			 <div class="modal-body" style="margin-bottom:200px">
				   <p class="fz">报备信息：</p>
        <div class="text-center">
        	<label>客户姓名：</label>
        	<input type="text" class="from-con" name="customerFormMap.customerName" id="customerName" value="${customer.customerName}" readonly="readonly"  />
        	<label>客户电话：</label>
        	<input type="text" class="from-con" name="customerFormMap.telephone" id="telephone" value="${customer.telephone}" readonly="readonly" />
        	<label>报备人员：</label>
        	<input type="text" class="from-con" name="customerFormMap.userName" id="userName" value="${customer.userName}"  readonly="readonly"/>
        	<label>报备时间：</label>
        	<input type="text" class="from-con "  name="customerFormMap.createDate" id="today" placeholder="" value="" readonly="readonly" >
        	<label>报备项目：</label>
        	
        	 <select  class="from-con" id="projectName" name="customerFormMap.projectId" ></select>
        	
        	</select>
        	<label>预约时间：</label>
        	<input type="text" class="from-con test-item" id="today"  name="customerFormMap.bespeakDate"  value=""  >
        </div>
		
			</div>
			
				<button type="submit" class="btn btn-primary pull-right mt10">确定</button>
				</section>
				</form>
		</div>
	
		
		
		
	

<script>
//页面加载完成执行
$(function(){
	getprojectName();
	
});
function getprojectName(){
	$.ajax({
		"url":"../project/getProject.shtml",
		"data":"",
		"type":"GET",
		"dataType":"json",
		"success":function(obj){
				$("#projectName").html("<option value=0> - - - -选择项目- - - - </option>");
			
			for(var i = 0;i<obj.length;i++){
				var str="<option value="+obj[i].id+">"+obj[i].projectName+"</option>";
				$("#projectName").append(str);
			}
			
		},
	  error : function() {  
        alert("未知错误！请与管理员联系");  
    }  			
	});
	
}

			layui.use('laydate', function() {
				var laydate = layui.laydate;

				//同时绑定多个
				lay('.test-item').each(function() {
					laydate.render({
						elem: this,
						
						trigger: 'click'
							 ,min: 0 //7天前
							  ,max: 7 //7天后
					});
				});

			

			});

function today() {
    var date = new Date();
    var seperator1 = "-";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

$("#today").val(today()) ;
		</script>

	</body>
</html>
