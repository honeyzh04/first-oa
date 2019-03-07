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
                        <input type="text" class="form-control" id="projectName" name="ProjectFormMap.projectName" placeholder="请输入项目名">
                    </label>     
                
			<button id="search" type="button" class="btn btn-info">搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
			<ul class="projectName">
				<li>类型：</li>
				<li><input type="radio" name="ProjectFormMap.type" id="" value=""  checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
				<li><input type="radio" name="ProjectFormMap.type" id="" value="1" /><span>&nbsp;&nbsp;商铺</span></li>
				<li><input type="radio" name="ProjectFormMap.type" id="" value="2" /><span>&nbsp;&nbsp;公寓</span></li>
				<li><input type="radio" name="ProjectFormMap.type" id="" value="3" /><span>&nbsp;&nbsp;写字楼</span></li>
			</ul>
			<ul class="projectName">
				<li>区域：</li>
				<li><input type="radio" name="ProjectFormMap.region" id="" value=""  checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
				<li><input type="radio" name="ProjectFormMap.region" id="" value="14" /><span>&nbsp;&nbsp;东区</span></li>
				<li><input type="radio" name="ProjectFormMap.region" id="" value="15" /><span>&nbsp;&nbsp;西区</span></li>
				<li><input type="radio" name="ProjectFormMap.region" id="" value="12" /><span>&nbsp;&nbsp;南区</span></li>
				<li><input type="radio" name="ProjectFormMap.region" id="" value="13" /><span>&nbsp;&nbsp;北区</span></li>
			</ul>
			<ul class="projectName">
				<li>总价 ：</li>
				<li><input type="radio" name="ProjectFormMap.prices" id="" value=""  checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
				<li><input type="radio" name="ProjectFormMap.prices" id="" value="0-20" /><span>&nbsp;&nbsp;20万以下</span></li>
				<li><input type="radio" name="ProjectFormMap.prices" id="" value="20-50" /><span>&nbsp;&nbsp;20-50万</span></li>
				<li><input type="radio" name="ProjectFormMap.prices" id="" value="50-100" /><span>&nbsp;&nbsp;50-100万</span></li>
				<li><input type="radio" name="ProjectFormMap.prices" id="" value="100-150" /><span>&nbsp;&nbsp;100-150万</span></li>
				<li><input type="radio" name="ProjectFormMap.prices" id="" value="150-200" /><span>&nbsp;&nbsp;150-200万</span></li>
				<li><input type="radio" name="ProjectFormMap.prices" id="" value="200-300" /><span>&nbsp;&nbsp;200-300万</span></li>
				<li><input type="radio" name="ProjectFormMap.prices" id="" value="300-500" /><span>&nbsp;&nbsp;300-500万</span></li>
				<li><input type="radio" name="ProjectFormMap.prices" id="" value="500-800" /><span>&nbsp;&nbsp;500-800万</span></li>
				<li><input type="radio" name="ProjectFormMap.prices" id="" value="800-10000" /><span>&nbsp;&nbsp;800万以上</span></li>
			</ul>
			<ul class="projectName">
				<li>面积 ：</li>
				<li><input type="radio" name="ProjectFormMap.area" id="" value=""   checked="checked" /><span>&nbsp;&nbsp;不限</span></li>
				<li><input type="radio" name="ProjectFormMap.area" id="" value="0-20" /><span>&nbsp;&nbsp;20㎡以下</span></li>
				<li><input type="radio" name="ProjectFormMap.area" id="" value="20-50" /><span>&nbsp;&nbsp;20-50㎡</span></li>
				<li><input type="radio" name="ProjectFormMap.area" id="" value="50-100" /><span>&nbsp;&nbsp;50-100㎡</span></li>
				<li><input type="radio" name="ProjectFormMap.area" id="" value="100-150" /><span>&nbsp;&nbsp;100-150㎡</span></li>
				<li><input type="radio" name="ProjectFormMap.area" id="" value="150-200" /><span>&nbsp;&nbsp;150-200㎡</span></li>
				<li><input type="radio" name="ProjectFormMap.area" id="" value="200-300" /><span>&nbsp;&nbsp;200-300㎡</span></li>
				<li><input type="radio" name="ProjectFormMap.area" id="" value="300-500" /><span>&nbsp;&nbsp;300-500㎡</span></li>
				<li><input type="radio" name="ProjectFormMap.area" id="" value="500-1000" /><span>&nbsp;&nbsp;500-1000㎡</span></li>
				<li><input type="radio" name="ProjectFormMap.area" id="" value="1000-10000" /><span>&nbsp;&nbsp;1000㎡以上</span></li>
			</ul>
		
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
							<th >状况</th>
							<th >菲斯特联系人</th>
							<th >项目联系人</th>
							<th >电话</th>	
							<th >项目描述</th>
							<!-- <th >操作</th> -->
							
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

	<script type="text/javascript" src="js/system/project/tablelist.js"></script>  
		</body>
