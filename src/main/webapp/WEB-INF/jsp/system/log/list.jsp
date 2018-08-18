<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/log/list.js"></script>
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
	<div class="m-b-md" style="margin-bottom: 15px">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				
			
			   <label class="control-label">操作用户账号：  
                        <input type="text" class="form-control" id="userName" name="customerFormMap.customerName" placeholder="请输入操作用户账号">
                    </label>     
                
			<button id="search" type="button" class="btn btn-info">搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
			
		
			</div>
		</form>
	</div>
	  <!-- 数据table代码 -->
                  <table id="datatable" class="table table-striped table-bordered"  style=" text-align:center;vertical-align: middle!important" >
                     <thead >
                       	<tr >
                       		
                         	<th >id</th>
                         	<th >操作用户</th>
							<th>模块</th>
							<th >方法</th>
							<th >响应时间</th>
							<th >操作IP</th>
							<th >执行时间</th>
							<th >执行描述</th>
							
                       	</tr>
                     </thead>
                   </table> 