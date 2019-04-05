<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

 <style type="text/css">
 #datatable{  
    width: 100% !important;  
} 
 /*数据表格标题文字居中*/
.tablelist th {
	text-align: center;
	vertical-align: middle !important;
}

 .btn-s{
    width: 43px;
    height: 27px;
    padding: 5px 5px;
   margin-right:5px;
}	
	.btn-d{
    width: 65px;
    height: 27px;
    padding: 5px 5px;
   margin-right:5px;
}	
			ul li{
				list-style: none;
			}
			.projectName{
				clear: both;
				padding-top: 15px;
			}
			.projectName li{
				float: left;
				padding-right: 20px;
			}

</style>
	
<body>
	<div class="m-b-md">
	
	<div class="m-b-md">
			<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				
			
			   <label class="control-label">项目名：  
                        <input type="text" class="form-control" id="projectName" name="ProjectHomeFormMap.projectName" placeholder="请输入项目名">
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
                   <table id="datatable" class="tablelist row-border table table-striped table-striped "  style=" text-align:center;vertical-align: middle!important" >
                     <thead >   
                       	<tr >
                       		<!-- <th ><input type="checkbox" id="checkAll"></th> -->
                         	<th >选择</th>
							<th >项目名</th>
							<th >栋</th>
							<th >楼层</th>
							<th >房号</th>
							<th >面积</th>
							<th >价格</th>
							<th >是否出售</th>
							<th >操作</th>
							
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

	<script type="text/javascript" src="js/system/project/homelist.js"></script>
		</body>
