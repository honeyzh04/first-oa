<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <style type="text/css">
 #datatable{  
    width: 100% !important;  
} 
.img img{
   margin-left:39%;
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
				
			
			   <label class="control-label">异常名：  
                        <input type="text" class="form-control" id="userName" name="customerFormMap.customerName" placeholder="请输入异常名">
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
                         	<th >异常名</th>
							<th>异常原因</th>
							<th >异常时间</th>
						
							
                       	</tr>
                     </thead>
                   </table> 
                   
        <div class="col-lg-12 img">
        <img src="./img/not_error.jpg"  />
        
        </div>
        
        
        
        
        