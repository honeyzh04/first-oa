<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	<div class="m-b-md">
	
		
			
 <div class="row">
             <div class="col-md-12 col-sm-12 col-xs-12">
               <div class="x_panel">   
                 <div class="x_content">
                 		<div class="m-b-md" style="margin-bottom: 15px";>
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				
			
			   <label class="control-label">员工账号：  
                        <input type="text" class="form-control" id="userName" name="customerFormMap.customerName" placeholder="请输入员工账号">
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
                         	
							<th>登录账号</th>
							<th >登录时间</th>
							<th >登陆IP</th>
							
							
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


<script type="text/javascript" src="js/system/userlogin/list.js"></script>   
