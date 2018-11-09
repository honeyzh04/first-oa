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
	
		<div class="m-b-md" style="margin-bottom: 15px">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				
			
			   <label class="control-label">职工姓名：  
                        <input type="text" class="form-control" id="userName" name="customerFormMap.customerName" placeholder="请输入员工姓名">
                    </label>     
                
			<button id="search" type="button" class="btn btn-info">搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
			
		
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
                   <table id="datatable" class="table table-striped table-bordered"  style=" text-align:center;vertical-align: middle!important" >
                     <thead >
                       	<tr >
                       		<th width="10px"><input type="checkbox" id="checkAll" class="checkchild"></th>
                         	<th width="200px">id</th>
							<th width="300px">菜单名称</th>
							<th width="300px">菜单类型</th>
							<th width="300px">状态</th>
							<th width="300px">操作</th>
						
							
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
<script type="text/javascript" src="js/system/resources/list.js"></script>
			</body>
