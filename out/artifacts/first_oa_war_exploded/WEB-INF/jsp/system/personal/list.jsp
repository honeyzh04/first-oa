<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
	<script type="text/javascript" src="js/system/role/list.js"></script> 
 	
	<body>

		<div class="layui-fluid layadmin-homepage-fluid">
			<div class="layui-row layui-col-space8">
				<div class="layui-col-md2">
					<div class="layadmin-homepage-panel layadmin-homepage-shadow">
						<div class="layui-card text-center">
							<div class="layui-card-body">
							<p style="font-size: 18px; font-weight: bold;">基本信息</p>
								<div class="layadmin-homepage-pad-ver">
									<img class="layadmin-homepage-pad-img" src="./img/tou.png" width="96" height="96">
								</div>
								<h4 class="layadmin-homepage-font">${personal.userName}</h4>
							</div>
						</div>
						<p class="layadmin-homepage-about">
							关于我
						</p>
						<ul class="layadmin-homepage-list-group">
							<li class="list-group-item"><i class="fa fa-user"></i>&nbsp;账户名：${personal.accountName}</li>
							<li class="list-group-item"><i class="fa fa-user-md"></i>&nbsp;用户名：${personal.userName}</li>
							<li class="list-group-item"><i class="fa fa-tag" aria-hidden="true"></i>&nbsp;部门：${personal.departmentName}</li>
							<li class="list-group-item"><i class="fa fa-envelope"></i>&nbsp;邮箱：${personal.email}</li>
							<li class="list-group-item"><i class="fa fa-phone-square "></i>&nbsp;电话：${personal.telephone}</li>
						</ul>
						<div class="layadmin-homepage-pad-hor">
							<mdall>描述：：${personal.description}</mdall>
						</div>
					</div>
				</div>
				<div class="layui-col-md10">
					<div class="layui-fluid layadmin-homepage-content">
	
						<div class="layui-row layui-col-space20 layadmin-homepage-list-imgtxt">
							<div class="layui-col-md9">
								<div class="grid-demo">
									<div class="layadmin-homepage-shadow">
									
										<div class="media-body">
								
											<p style="font-size: 18px; font-weight: bold; padding-top:10px;">个人报表</p>
											<div class="media-list">
												<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
												<div id="main" style="width: 900px;height:400px;"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="layui-col-md3">
								<div class="grid-demo">
									<div class="layui-card homepage-bottom">
										<div class="layui-card-header">
											<p style="font-size: 18px; font-weight: bold;">其他信息</p>
										</div>
										<div class="layui-card-body">
					
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<script type="text/javascript">
		$(function () {
	       
	 
	        showLine();
	    });

	    function showLine() {
	    
	        $.ajax({
	            type: "GET",
	            url: "./statistics/findBypersonweek.shtml",
	            dataType: 'json',
	        });
	    }
			// 基于准备好的dom，初始化echarts实例
			var myChart = echarts.init(document.getElementById('main'));

			// 指定图表的配置项和数据
	
			var option = {
				tooltip: {
					trigger: 'axis',
					axisPointer: { // 坐标轴指示器，坐标轴触发有效
						type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				legend: {
					data: ['新增', '到访', '排号', '成交', '退单']
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				xAxis: {
					type: 'value'
				},
				yAxis: {
					type: 'category',
					data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
				},
				series: [{
						name: '新增',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [320, 302, 301, 334, 390, 330, 320]
					},
					{
						name: '到访',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [120, 132, 101, 134, 90, 230, 210]
					},
					{
						name: '排号',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [220, 182, 191, 234, 290, 330, 310]
					},
					{
						name: '成交',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [150, 212, 201, 154, 190, 330, 410]
					},
					{
						name: '退单',
						type: 'bar',
						stack: '总量',
						label: {
							normal: {
								show: true,
								position: 'insideRight'
							}
						},
						data: [820, 832, 901, 934, 1290, 1330, 1320]
					}
				]
			};

			// 使用刚指定的配置项和数据显示图表。
			myChart.setOption(option);
			
			// 异步加载数据
			/*$.get('data.json').done(function (data) {
			    // 填入数据
			    myChart.setOption({
			        xAxis: {
			            data: data.categories
			        },
			        series: [{
			            // 根据名字对应到相应的系列
			            name: '新增',
			            data: data.data
			        }]
			    });*/
		</script>
	</body>

</html>