<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="../js/system/statistics/peweeklist.js"></script>


<style type="text/css">
 #datatableweek{  
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

										<div class="radio-custom radio-info pull-left">
											<input type="radio" value="1" checked="checked"
												name="StatisticsFormMap.departweek" id="infor"> <label
												for="infor">本周</label>
										</div>

										<div class="radio-custom radio-success pull-left">
											<input type="radio" value="2"
												name="StatisticsFormMap.departweek" id="success"> <label
												for="success">上周</label>
										</div>
										<div class="radio-custom radio-danger  pull-left">
											<input type="radio" value="3"
												name="StatisticsFormMap.departweek" id="danger"> <label
												for="danger">上上周</label>
										</div>
										<button id="btn-peweek" type="button"
											class="btn btn-info  buttona">
											搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
												aria-hidden="true"></span>
										</button>

									</div>
								</div>
							</div>
	  <!-- 数据table代码 -->
                
							<table id="datatableweek"
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
				
	