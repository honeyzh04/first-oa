<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

 <style type="text/css">
 #datatable{  
    width: 100% !important;  
} 
 /*数据表格标题文字居中*/
.table th {
	text-align: center;
	vertical-align: middle !important;
}
</style>
	
<body>
	<div class="m-b-md">
	
	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				
			
			 	<div class="form-group pad">
						<label for="exampleInputName2">客户姓名：</label> <input type="text"
							class="form-control" id="customerName"
							name="customerFormMap.customerName" placeholder="请输入客户名">
					</div>

					<div class="form-group pad">
						<label for="exampleInputName2">电话号码：</label> <input type="tel"
							class="form-control" id="telephone"
							name="customerFormMap.telephone" placeholder="请输入客户电话">
					</div>
						<div class="form-group pad" style="margin: 0 15px">
								<label for="exampleInputName2">录入时间：</label> <input type="text"
									class=" form-control test-item" id="screateDate"
									name="customerFormMap.screateDate" placeholder="请输入开始时间">----
								<input type="text" class="form-control test-item"
									id="ecreateDate" name="customerFormMap.ecreateDate"
									placeholder="请输入结束时间">


							</div>
			<button id="btn-test" type="button" class="btn btn-info">搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
			
		
			</div>
		</form>
	</div>
	<header class="panel-heading">
 	<div class="doc-buttons">
		<c:forEach items="${res}" var="key">
			${key.description}
		</c:forEach>
		
	</div>
	</header> 
		
			
 <div class="row">
             <div class="col-md-12 col-sm-12 col-xs-12">
               <div class="x_panel">   
                 <div class="x_content">
                 	
	                <!-- 数据table代码 -->
                   <table id="datatable" class="table table-striped table-bordered "  style=" text-align:center;vertical-align: middle!important" >
                     <thead >   
                       	<tr >
                       		
                     		
								<th>客户姓名</th>
								<th>客户姓名</th>
								<th>联系方式</th>
								<th>性别</th>
								<th>预算总价</th>
								<th>购买用途</th>
								<th>购买方向</th>
								<th>意向指数</th>
								<th>状态</th>
								<th>信息来源</th>
								<th>销售顾问</th>
								<th>事业部</th>
								
								<th>跟进提醒</th>
								<th>客户归属</th>
								<th>录入时间</th>
								
							
					
							
                       	</tr>
                     </thead>
                   </table>
                 </div>
               </div>
             </div>
        </div>
	
	</div>
	<div class="table-responsive">
		<div id="paging" class="pagclass"></div>
	</div>
	<script>
layui.use('laydate', function() {
	var laydate = layui.laydate;

	//同时绑定多个
	lay('.test-item').each(function() {
		laydate.render({
			elem: this,
			
			trigger: 'click'
			
			 ,max: 1 //今天以前
			
		});
	});
});



</script>
	<script type="text/javascript" src="js/system/customer/ffxlist.js"></script>  
		</body>
		
		
