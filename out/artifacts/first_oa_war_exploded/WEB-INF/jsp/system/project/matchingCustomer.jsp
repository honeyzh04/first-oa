<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/project/matchingcu.js"></script>

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
			value="${project}" name="projectFormMap.projectId" id="projectId">

			 <div class="modal-body" >
				   <p class="fz">匹配客户列表：</p>

				 <!-- 数据table代码 -->
				 <table id="datatable" class="table table-striped table-bordered table-hover table-condensed"
						style="text-align: center; vertical-align: middle !important">
					 <thead>
					 <tr>

						 <th>客户姓名</th>
						 <th>联系方式</th>
						 <th>性别</th>
						 <th>预算总价(万)</th>
						 <th>投资用途</th>
						 <th>购买方向</th>
						 <th>信息来源</th>
						 <th>最新跟进时间</th>
						 <th>跟进</th>

					 </tr>
					 </thead>
				 </table>
			</div>
			

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
<
<script !src="">
	var a=$("#projectId").val();
	console.log(a);

</script>
</html>


