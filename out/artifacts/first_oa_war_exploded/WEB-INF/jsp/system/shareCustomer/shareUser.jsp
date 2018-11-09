<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>


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
		  
			
		<%-- 	<input type="hidden" class="form-control checkacc"
			value="${customer.id}" name="extendFormMap.id" id="id"> --%>
			<section class="panel panel-default">
			 <div class="modal-body" >
				   <p class="fz">共享成员：</p>
        <div class="text-center">
        	 <div class="modal-body">
					<label for="inputEmail3" class="control-label">经纪人姓名：</label>
					<input type="text" class="from-con" name="extendFormMap.customerName" id="customerName" value="${customer}" readonly="readonly"  />
				</div>
			
        </div>
		
			</div>
			
				
				</section>
				
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


