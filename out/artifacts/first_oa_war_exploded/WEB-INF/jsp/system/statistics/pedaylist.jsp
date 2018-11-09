<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <script type="text/javascript" src="../js/system/statistics/pedaylist.js"></script>


<style type="text/css">
 #datatableday{  
    width: 100% !important;  
} 
 /*数据表格标题文字居中*/
.table th {
	text-align: center;
	vertical-align: middle !important;
}
</style>
						<input type="hidden" class="form-control checkacc"
						value="${deId}" name="StatisticsFormMap.deId" id="deId">
							<div class="row chart-row">
								<div class="col-md-4 sttime form-inline">
									<div class="input-group">
										<label for="dtp_input1" class="control-label">选择时间：</label>
										<div class="input-group date form_date">
											<input type="text" class="form-control checkacc"
												placeholder="请选择时间" name="StatisticsFormMap.choiceday"
												id="choiceday">

										</div>

										<button id="btn-day" type="button"
											class="btn btn-info  buttona">
											搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
												aria-hidden="true"></span>
										</button>
									</div>
								</div>
							</div>
	  <!-- 数据table代码 -->
                
							<table id="datatableday"
								class="table table-striped table-bordered"
								style="text-align: center; vertical-align: middle !important">
								<thead>
									<tr>
										<th>姓名</th>
										<th>新增客户</th>
										<th>电话新增</th>
										<th>网络新增</th>
										<th>其他新增</th>
										<th>公共池新增</th>
										<th>转入新增</th>
										<th>跟进客户</th>
										<th>带访客户</th>
										<th>成交客户</th>
									</tr>
								</thead>
							</table>
							
	<script>					
		/*时间插件*/

	layui.use('laydate', function() {

		var laydate = layui.laydate;

		//同时绑定多个
		lay('#choiceday').each(function() {
			laydate.render({
				elem : this,
				trigger : 'click',
				type : 'date',
				theme : '#FF0000',
				min : -90,
				max : 0
				,value: new Date()
				    ,isInitValue: true

			});
		});

		laydate.render({
			elem : '#choicemonth',
			trigger : 'click',
			type : 'month',
			theme : '#FF0000',
			max : 0
			,value: new Date()
		    ,isInitValue: true
	   

		});
	});		
		</script>	