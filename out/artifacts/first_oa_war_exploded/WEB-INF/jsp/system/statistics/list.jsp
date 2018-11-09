<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="js/system/statistics/list.js"></script>


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

			<div class="layui-tab" lay-filter="demo" lay-allowclose="true">
				<ul class="layui-tab-title">
					<li class="layui-this">日报表</li>
				</ul>
				<ul class="rightmenu" style="display: none; position: absolute;">
					<li data-type="closethis">关闭当前</li>
					<li data-type="closeall">关闭所有</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<div class="layui-tab layui-tab-card site-demo-button"
							style="position: relative;">

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
										<th>部门</th>
										<th>新增客户</th>
										<th>电话新增</th>
										<th>网络新增</th>
										<th>其他新增</th>
										<th>公共池新增</th>
										<th>转入新增</th>
										<th>跟进客户</th>
										<th>带访客户</th>
										<th>成交客户</th>

										<th>详细</th>
									</tr>
								</thead>
							</table>



						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="layui-tab-item">
			<div class="layui-tab" lay-filter="demo1" lay-allowclose="true">
				<ul class="layui-tab-title">
					<li class="layui-this">周报表</li>
				</ul>
				<ul class="rightmenu" style="display: none; position: absolute;">
					<li data-type="closethis">关闭当前</li>
					<li data-type="closeall">关闭所有</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">


						<div class="layui-tab layui-tab-card site-demo-button"
							style="position: relative">

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
										<th>部门</th>
										<th>新增客户</th>
										<th>电话新增</th>
										<th>网络新增</th>
										<th>其他新增</th>
										<th>公共池新增</th>
										<th>转入新增</th>
										<th>跟进客户</th>
										<th>带访客户</th>
										<th>成交客户</th>

										<th>详细</th>
									</tr>
								</thead>
							</table>




						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-tab-item">

			<div class="layui-tab" lay-filter="demo2" lay-allowclose="true">
				<ul class="layui-tab-title">
					<li class="layui-this">月报表</li>
				</ul>
				<ul class="rightmenu" style="display: none; position: absolute;">
					<li data-type="closethis">关闭当前</li>
					<li data-type="closeall">关闭所有</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">

						<div class="layui-tab layui-tab-card site-demo-button"
							style="position: relative;">

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
										<th>部门</th>
										<th>新增客户</th>
										<th>电话新增</th>
										<th>网络新增</th>
										<th>其他新增</th>
										<th>公共池新增</th>
										<th>转入新增</th>
										<th>跟进客户</th>
										<th>带访客户</th>
										<th>成交客户</th>

										<th>详细</th>
									</tr>
								</thead>
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
var vv = layui.use('element', function() {
	element: layui.element;
});

var $ = jQuery = layui.jquery;

// 触发事件
var active = {
	// 在这里给active绑定几项事件，后面可通过active调用这些事件
	tabAdd : function(url, id, name) {
		// 新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
		// 关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
		vv.element
				.tabAdd(
						'demo',
						{
							title : name,
							content : '<iframe data-frameid="'
									+ id
									+ '" scrolling="auto" frameborder="0" src="./statistics/pedaylist.shtml?id='
									+ id
									+ '" style="width:100%;height:99%;"></iframe>',
							id : id
						// 规定好的id
						})
		CustomRightClick(id); // 给tab绑定右击事件
		FrameWH(); // 计算ifram层的大小
	},
	tabChange : function(id) {
		// 切换到指定Tab项
		vv.element.tabChange('demo', id); // 根据传入的id传入到指定的tab项
	},
	tabAdd1 : function(url, id, name) {
		// 新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
		// 关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
		vv.element
				.tabAdd(
						'demo1',
						{
							title : name,
							content : '<iframe data-frameid="'
									+ id
									+ '" scrolling="auto" frameborder="0" src="./statistics/peweeklist.shtml?id='
									+ id
									+ '" style="width:100%;height:99%;"></iframe>',
							id : id
						// 规定好的id
						})
		CustomRightClick(id); // 给tab绑定右击事件
		FrameWH(); // 计算ifram层的大小
	},
	tabChange1 : function(id) {
		// 切换到指定Tab项
		vv.element.tabChange('demo1', id); // 根据传入的id传入到指定的tab项
	},
	tabAdd2 : function(url, id, name) {
		// 新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
		// 关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
		vv.element
				.tabAdd(
						'demo2',
						{
							title : name,
							content : '<iframe data-frameid="'
									+ id
									+ '" scrolling="auto" frameborder="0" src="./statistics/pemonthlist.shtml?id='
									+ id
									+ '" style="width:100%;height:99%;"></iframe>',
							id : id
						// 规定好的id
						})
		CustomRightClick(id); // 给tab绑定右击事件
		FrameWH(); // 计算ifram层的大小
	},
	tabChange2 : function(id) {
		// 切换到指定Tab项
		vv.element.tabChange('demo2', id); // 根据传入的id传入到指定的tab项
	},

	tabDelete : function(id) {
		vv.element.tabDelete("demo", id);// 删除
	},
	tabDeleteAll : function(ids) {// 删除所有
		$.each(ids, function(i, item) {
			vv.element.tabDelete("demo", item); // ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
		})
	},

};

// 当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
$('.site-demo-active').on(
		'click',
		function() {
			var dataid = $(this);

			// 这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
			if ($(".layui-tab-title li[lay-id]").length <= 0) {
				// 如果比零小，则直接打开新的tab项
				active.tabAdd(dataid.attr("data-url"), dataid
						.attr("data-id"), dataid.attr("data-title"));
			} else {
				// 否则判断该tab项是否以及存在

				var isData = false; // 初始化一个标志，为false说明未打开该tab项 为true则说明已有
				$.each($(".layui-tab-title li[lay-id]"), function() {
					// 如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
					if ($(this).attr("lay-id") == dataid.attr("data-id")) {
						isData = true;
					}
				})
				if (isData == false) {
					// 标志为false 新增一个tab项
					active.tabAdd(dataid.attr("data-url"), dataid
							.attr("data-id"), dataid.attr("data-title"));
				}
			}
			// 最后不管是否新增tab，最后都转到要打开的选项页面上
			active.tabChange(dataid.attr("data-id"));
		});

function CustomRightClick(id) {
	// 取消右键 rightmenu属性开始是隐藏的 ，当右击的时候显示，左击的时候隐藏
	$('.layui-tab-title li').on('contextmenu', function() {
		return false;
	})
	$('.layui-tab-title,.layui-tab-title li').click(function() {
		$('.rightmenu').hide();
	});
	// 桌面点击右击
	$('.layui-tab-title li')
			.on(
					'contextmenu',
					function(e) {
						var popupmenu = $(".rightmenu");
						popupmenu.find("li").attr("data-id", id); // 在右键菜单中的标签绑定id属性

						// 判断右侧菜单的位置
						l = ($(document).width() - e.clientX) < popupmenu
								.width() ? (e.clientX - popupmenu.width())
								: e.clientX;
						t = ($(document).height() - e.clientY) < popupmenu
								.height() ? (e.clientY - popupmenu.height())
								: e.clientY;
						popupmenu.css({
							left : l,
							top : t
						}).show(); // 进行绝对定位
						// alert("右键菜单")
						return false;
					});
}

$(".rightmenu li").click(function() {

	// 右键菜单中的选项被点击之后，判断type的类型，决定关闭所有还是关闭当前。
	if ($(this).attr("data-type") == "closethis") {
		// 如果关闭当前，即根据显示右键菜单时所绑定的id，执行tabDelete
		active.tabDelete($(this).attr("data-id"))
	} else if ($(this).attr("data-type") == "closeall") {
		var tabtitle = $(".layui-tab-title li");
		var ids = new Array();
		$.each(tabtitle, function(i) {
			ids[i] = $(this).attr("lay-id");
		})
		// 如果关闭所有 ，即将所有的lay-id放进数组，执行tabDeleteAll
		active.tabDeleteAll(ids);
	}

	$('.rightmenu').hide(); // 最后再隐藏右键菜单
})
function FrameWH() {
	var h = $(window).height() - 41 - 10 - 60 - 10 - 44 - 10;
	$("iframe").css("height", h + "px");
}

$(window).resize(function() {
	FrameWH();
})

// 日报表
function deday(_this) {

	var nRow = $(_this).parents('tr')[0];// 得到这一行
	var aData = $("#datatableday").dataTable().fnGetData(nRow);// 得到这一行的json数据
	var cuId = aData.id;
	var cuname = aData.name;
	var dataid = $(this);
	active.tabAdd(cuId, cuId, cuname);
	active.tabChange(cuId);

}
;
// 周报表
function deweek(_this) {

	var nRow = $(_this).parents('tr')[0];// 得到这一行
	var aData = $("#datatableday").dataTable().fnGetData(nRow);// 得到这一行的json数据
	var cuId = aData.id;
	var cuname = aData.name;
	var dataid = $(this);
	active.tabAdd1(cuId, cuId, cuname);
	active.tabChange1(cuId);
}
;
// 月报表
function demonth(_this) {

	var nRow = $(_this).parents('tr')[0];// 得到这一行
	var aData = $("#datatableday").dataTable().fnGetData(nRow);// 得到这一行的json数据
	var cuId = aData.id;
	var cuname = aData.name;
	var dataid = $(this);
	active.tabAdd2(cuId, cuId, cuname);
	active.tabChange2(cuId);
}
;

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