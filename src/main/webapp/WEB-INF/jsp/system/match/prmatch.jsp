<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<script type="text/javascript" src="js/system/match/prlist.js"></script>  
 <style type="text/css">
 #datatable{  
    width: 100% !important;  
} 
 /*数据表格标题文字居中*/
.table th {
	text-align: center;
	vertical-align: middle !important;
}
.btn-s{
    width: 43px;
    height: 27px;
    padding: 5px 5px;
   margin-right:5px;
}
</style>
	
<body>
	<div class="m-b-md">
	
	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				
			

					<div class="form-group pad">
						<label for="exampleInputName2">客户电话：</label> <input type="tel"
							class="form-control" id="telephone"
							name="customerFormMap.telephone" placeholder="请输入客户电话">
					</div>
			<button id="btn-test" type="button" class="btn btn-info">开始匹配 &nbsp;&nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
			
		
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
                   <table id="datatable" class="tablelist row-border table table-striped table-striped "  style=" text-align:center;vertical-align: middle!important" >
                     <thead >   
                       	<tr >
                       		<!-- <th ><input type="checkbox" id="checkAll"></th> -->
                         	<th >选择</th>
							<th >项目名</th>
							<th >项目位置</th>
							<th >类型</th>
							<th >面积</th>
							<th >单价</th>
							<th >总价</th>
							<th >区域</th>
							<th >菲斯特联系人</th>
							<th >项目联系人</th>
							<th >电话</th>	
							<th >项目描述</th>
							
							
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

		</body>

