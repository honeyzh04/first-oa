
var myTableweek = null;

$(function() {
	
	myTableweek = $('#datatableweek')
	.DataTable(
			{

				autoWidth : true,
				searching : false,// 禁用datatables搜索
				processing : true,// 载入数据的时候是否显示“载入中”
				serverSide : true,// 开启服务器模式。分页，取数据等等的都放到服务端去
				"aLengthMenu" : [ 10, 20, 30 ], // 更改显示记录数选项

				paging : true,
				info : true,
				"bStateSave" : false,
				ordering : false,
				ajax : {
					url : "../statistics/findBypeweek.shtml",// 数据请求地
					type : "POST",
					data : function(params) {
						// 此处为定义查询条件 传给控制器的参数
						// 角色名称

						params.peweek= $("input[name='StatisticsFormMap.departweek']:checked").val();
						params.deId= $("#deId").val();

					}
				},
				columns : [

				{
					data : "userName"

				},

				{
					data : "addw"

				},

				{
					data : "adddh"

				},

				{
					data : "addwl"

				}, {
					data : "addqt"

				},

				{
					data : "addg"

				}, {
					data : "addz"

				},

				{
					data : "follow"

				}, {
					data : "vis"

				}, {
					data : "dea"

				},


				],
				// /操作按钮
				columnDefs : [

					

				],
				oLanguage : {
					"sProcessing" :"<img src='../img/loading.gif' /> 努力加载数据中.",
					"sLengthMenu" : "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每页显示 _MENU_ 条报表记录",
					"sZeroRecords" : "抱歉， 没有找到",
					"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条报表信息",
					"sInfoEmpty" : "没有数据",
					"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
					"oPaginate" : {
						"sFirst" : "首页",
						"sPrevious" : "前一页",
						"sNext" : "后一页",
						"sLast" : "尾页"
					},
					"sZeroRecords" : "没有检索到数据",
					"sProcessing" : "<img src='../img/loading.gif' />"
				},

			});
	
	

	/**
	 * 查询周报表
	 */
	$("#btn-peweek").click("click", function() {

		myTableweek.ajax.reload();
	});
	

});

