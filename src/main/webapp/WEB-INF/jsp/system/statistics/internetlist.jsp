<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="js/system/statistics/internextlist.js"></script>


<style>
#datatableday {
	width: 100% !important;
}

#datatableweek {
	width: 100% !important;
}

#datatablemonth {
	width: 100% !important;
}
/*数据表格标题文字居中*/
.table th {
	text-align: center;
	vertical-align: middle !important;
}

.sttime {
	margin: 10px
}
</style>
<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
	<ul class="layui-tab-title">
		<li class="layui-this">日报表</li>
		<li>周报表</li>
		<li>月报表</li>
	</ul>
	<div class="layui-tab-content">
		<div class="layui-tab-item layui-show">

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
							<table id="datatableday"
								class="table table-striped table-bordered"
								style="text-align: center; vertical-align: middle !important">
								<thead>
									<tr>
										<th>合计</th>
										<th>网络新增</th>
										<th>新增（安居客端口）</th>
										<th>新增（58同城端口）</th>
										<th>新增（房发现端口）</th>
										<th>新增（安居客供客）</th>
										<th>新增（58同城供客）</th>
										<th>新增（房发现供客）</th>
										<th>网络带访</th>
										<th>带访（安居客端口）</th>
										<th>带访（58同城端口）</th>
										<th>带访（房发现端口）</th>
										<th>带访（安居客供客）</th>
										<th>带访（58同城供客）</th>
										<th>带访（房发现供客）</th>
										<th>网络成交</th>
										<th>成交（安居客端口）</th>
										<th>成交（58同城端口）</th>
										<th>成交（房发现端口）</th>
										<th>成交（安居客供客）</th>
										<th>成交（58同城供客）</th>
										<th>成交（房发现供客）</th>
									</tr>
								</thead>
							</table>
		</div>

		<div class="layui-tab-item">
	
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
										<button id="btn-week" type="button"
											class="btn btn-info  buttona">
											搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
												aria-hidden="true"></span>
										</button>

									</div>
								</div>
							</div>

							<table id="datatableweek"
								class="table table-striped table-bordered"
								style="text-align: center; vertical-align: middle !important">
								<thead>
									<tr>
										<th>合计</th>
										<th>网络新增</th>
										<th>新增（安居客端口）</th>
										<th>新增（58同城端口）</th>
										<th>新增（房发现端口）</th>
										<th>新增（安居客供客）</th>
										<th>新增（58同城供客）</th>
										<th>新增（房发现供客）</th>
										<th>网络带访</th>
										<th>带访（安居客端口）</th>
										<th>带访（58同城端口）</th>
										<th>带访（房发现端口）</th>
										<th>带访（安居客供客）</th>
										<th>带访（58同城供客）</th>
										<th>带访（房发现供客）</th>
										<th>网络成交</th>
										<th>成交（安居客端口）</th>
										<th>成交（58同城端口）</th>
										<th>成交（房发现端口）</th>
										<th>成交（安居客供客）</th>
										<th>成交（58同城供客）</th>
										<th>成交（房发现供客）</th>
									</tr>
								</thead>
							</table>
		</div>
		<div class="layui-tab-item">

				<div class="row chart-row">
								<div class="col-md-4 sttime form-inline">
									<div class="input-group">
										<label for="dtp_input1" class="control-label">选择时间：</label>
										<div class="input-group date form_date">
											<input type="text" class="form-control checkacc"
												placeholder="请选择时间" name="StatisticsFormMap.choicemonth"
												id="choicemonth">

										</div>

										<button id="btn-month" type="button"
											class="btn btn-info  buttona">
											搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
												aria-hidden="true"></span>
										</button>
									</div>
								</div>
							</div>



							<table id="datatablemonth"
								class="table table-striped table-bordered"
								style="text-align: center; vertical-align: middle !important">
								<thead>
									<tr>
										<th>合计</th>
										<th>网络新增</th>
										<th>新增（安居客端口）</th>
										<th>新增（58同城端口）</th>
										<th>新增（房发现端口）</th>
										<th>新增（安居客供客）</th>
										<th>新增（58同城供客）</th>
										<th>新增（房发现供客）</th>
										<th>网络带访</th>
										<th>带访（安居客端口）</th>
										<th>带访（58同城端口）</th>
										<th>带访（房发现端口）</th>
										<th>带访（安居客供客）</th>
										<th>带访（58同城供客）</th>
										<th>带访（房发现供客）</th>
										<th>网络成交</th>
										<th>成交（安居客端口）</th>
										<th>成交（58同城端口）</th>
										<th>成交（房发现端口）</th>
										<th>成交（安居客供客）</th>
										<th>成交（58同城供客）</th>
										<th>成交（房发现供客）</th>
									</tr>
								</thead>
							</table>
	</div>
</div>
<script>
var vv = layui.use('element', function() {
	element: layui.element;
});

var $ = jQuery = layui.jquery;
/* 时间插件 */

layui.use('laydate', function() {

	var laydate = layui.laydate;

	// 同时绑定多个
	lay('#choiceday').each(function() {
		laydate.render({
			elem : this,
			trigger : 'click',
			type : 'date',
			theme : '#FF0000',
			min : -90,
			max : 0,
			value : new Date(),
			isInitValue : true

		});
	});

	laydate.render({
		elem : '#choicemonth',
		trigger : 'click',
		type : 'month',
		theme : '#FF0000',
		max : 0,
		value : new Date(),
		isInitValue : true

	});
});

</script>