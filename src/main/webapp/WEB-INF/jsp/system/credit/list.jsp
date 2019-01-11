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
						<label >员工姓名：</label> <input type="text"
							class="form-control" id="userName" placeholder="请输入员姓名">
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
                       		
                     		
								<th>选择</th>
								<th>销售</th>
								<th>积分</th>
								<th>操作</th>

								
							
					
							
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
	<script type="text/javascript" src="js/system/credit/list.js"></script>
		</body>
		
		
