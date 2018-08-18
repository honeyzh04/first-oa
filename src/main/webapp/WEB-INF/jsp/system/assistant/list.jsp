<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" src="js/system/assistant/list.js"></script>

<style>
ol {
	padding-left: 20px;
}
#question {
	list-style: disc;
}
</style>



<div class="layui-tab" lay-filter="demo" lay-allowclose="true">
	<ul class="layui-tab-title">
		<li class="layui-this">问题列表</li>
	</ul>
	<ul class="rightmenu" style="display: none; position: absolute;">
		<li data-type="closethis">关闭当前</li>
		<li data-type="closeall">关闭所有</li>
	</ul>
	<div class="layui-tab-content">
		<div class="layui-tab-item layui-show">
			<div class="layui-tab layui-tab-card site-demo-button"
				style="position: relative;">


				<div class="m-b-md">

					<div class="m-b-md">
						<form class="form-inline" role="form" id="searchForm"
							name="searchForm">
							<div class="form-group">


								<label class="control-label">输入问题： <input type="text"
									class="form-control" id="que" name="userFormMap.userName"
									placeholder="请输入感兴趣的问题">
								</label>

								<button id="search" type="button" class="btn btn-info"
									onclick="find()">
									搜索 &nbsp;&nbsp;<span class="glyphicon glyphicon-search"
										aria-hidden="true"></span>
								</button>
								<button id="addAccount" type="button"
									class="btn btn-success buttona">
									提问 &nbsp;&nbsp;<span class="glyphicon glyphicon-plus"
										aria-hidden="true"></span>
								</button>

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
					<div id="hidebg"></div>


				</div>

				<div id="div1">

					<ol id="userId">

					</ol>
					<div class="table-responsive">
						<div id="paging" class="pagclass"></div>
					</div>
				</div>
				<div class="col-lg-3  pull-right" id="pagea"></div>


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
										+ '" scrolling="auto" frameborder="0" src="./interlocution/answerUI.shtml?id='
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

		tabDelete : function(id) {
			vv.element.tabDelete("demo", id);// 删除
		},
		tabDeleteAll : function(ids) {// 删除所有
			$.each(ids, function(i, item) {
				vv.element.tabDelete("demo", item); // ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
			})
		},

	};

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

	function seeanswer(_this) {
		console.log("as");
		var id = $(_this).attr("value");
		console.log(id);

		var dataid = $(this);
		active.tabAdd(id, id, id);
		active.tabChange(id);

	};
</script>
<script type="text/javascript">
	$(function() {

		find();

	});

	function find(_this) {
		$("#userId").html("");
		$("#pagea").html("");
		var que = $("#que").val();
		var page = $(_this).attr("value");
		console.log("que" + que);
		console.log("page" + page);
		$
				.ajax({
					"url" : "./interlocution/findQuestionsa.shtml",
					"data" : {
						que : que,
						page : page
					},

					"type" : "GET",
					"dataType" : "json",
					"success" : function(obj) {
						console.log(obj);
						for (i = 0; i < obj.list.length; i++) {
							console.log(obj.list[i].question);
							var str = '<li id="question"><h4><i class="fa fa-circle-o-notch fa-spin fa-fw"></i><span data-url="b" data-title="选项b"  data-id="45" class="site-demo-active" data-type="tabAdd">'
									+ obj.list[i].question
									+ '</span></h4><a  href="#" onclick="seeanswer(this);" value='
									+ obj.list[i].id
									+ '><i class="fa fa-comment" aria-hidden="true"></i>共'
									+ obj.list[i].sum
									+ ' 条回答</a></li>'

							$("#userId").append(str);

						}
						;
						var pages = "共 " + obj.pages + "页问题";
						$("#pages").append(pages);
						var pagea = '<p id="pages">当前第'
								+ obj.pageNum
								+ '页/共'
								+ obj.pages
								+ '页/共'
								+ obj.total
								+ '条</p> <a href="#"   value='
								+ obj.firstPage
								+ ' onclick="find(this)">首页&nbsp;&nbsp;</a><a href="#"  value='
								+ obj.prePage
								+ ' onclick="find(this)">上一页&nbsp;&nbsp;</a> <a href="#"  value='
								+ obj.nextPage
								+ '  onclick="find(this)">下一页&nbsp;&nbsp;</a><a href="#"  value='
								+ obj.lastPage
								+ '  onclick="find(this)">尾页</a>'
						$("#pagea").append(pagea);
					},
					error : function() {
						alert("请与管理员联系");
					}
				});

	};
</script>