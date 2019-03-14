<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/customer/orderedcu.js"></script>

	<style type="text/css">
			html,body{margin:0;padding:0;overflow-x:hidden;overflow-y:hidden;}
            .fz{
				font-size: 18px;
				font-weight: bold;
			}

		</style>
	</head>
	<body>
	
		<div class="msg">

			 <div class="modal-body" >
				   <p class="fz">预约客户列表：</p>

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


	</body>

</html>


