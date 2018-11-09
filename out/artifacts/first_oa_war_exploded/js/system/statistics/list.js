
var myTableday = null;
var myTableweek = null;
var myTablemonth = null;
$(function() {
	// 初始化部门公共池表格对象
	myTableday = $('#datatableday')
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
							url : "./statistics/findBydepartday.shtml",// 数据请求地
							type : "POST",
							data : function(params) {
						
								params.choiceday= $("#choiceday").val();
						

							}
						},
						columns : [

						{
							data : "name"

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

						{
							"data" : null
						},

						],
						// /操作按钮
						columnDefs : [

								{
									targets : -1,// 操作按鈕位置，从0开始数为第几例
									data : "id",

									"render" : function(data, type, full) {
										return "<div class='btn-group' >"
												+ "<button onclick='deday(this);' class='btn btn-primary btn-sm ' type='button'><i class='fa fa-edit'></i>&nbsp;&nbsp; 详细</button>"
												+ "</div>"

									}
								},

						],
						oLanguage : {
							"sProcessing" :"<img src='./img/loading.gif' /> 努力加载数据中.",
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
							"sProcessing" : "<img src='./img/loading.gif' />"
						},

					});
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
					url : "./statistics/findBydepartweek.shtml",// 数据请求地
					type : "POST",
					data : function(params) {
						// 此处为定义查询条件 传给控制器的参数
						// 角色名称

						params.departweek= $("input[name='StatisticsFormMap.departweek']:checked").val();

					}
				},
				columns : [

				{
					data : "name"

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

				{
					"data" : null
				},

				],
				// /操作按钮
				columnDefs : [

						{
							targets : -1,// 操作按鈕位置，从0开始数为第几例
							data : "id",

							"render" : function(data, type, full) {
								return "<div class='btn-group'>"
										+ "<button onclick='deweek(this);' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'></i>&nbsp;&nbsp; 详细</button>"
										+ "</div>"

							}
						},

				],
				oLanguage : {
					"sProcessing" :"<img src='./img/loading.gif' /> 努力加载数据中.",
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
					"sProcessing" : "<img src='./img/loading.gif' />"
				},

			});
	myTablemonth = $('#datatablemonth')
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
					url : "./statistics/findBydepartMonth.shtml",// 数据请求地
					type : "POST",
					data : function(params) {
						// 此处为定义查询条件 传给控制器的参数
						// 角色名称

						params.choicemonth = $("#choicemonth").val();
					

					}
				},
				columns : [

				{
					data : "name"

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

				{
					"data" : null
				},

				],
				// /操作按钮
				columnDefs : [

						{
							targets : -1,// 操作按鈕位置，从0开始数为第几例
							data : "id",

							"render" : function(data, type, full) {
								return "<div class='btn-group'>"
										+ "<button onclick='demonth(this);' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'></i>&nbsp;&nbsp; 详细</button>"
										+ "</div>"

							}
						},

				],
				oLanguage : {
					"sProcessing" :"<img src='./img/loading.gif' /> 努力加载数据中.",
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
					"sProcessing" : "<img src='./img/loading.gif' />"
				},

			});
	
	/**
	 * 查询日报表
	 */
	$("#btn-day").click("click", function() {

		myTableday.ajax.reload();
	});
	/**
	 * 查询周报表
	 */
	$("#btn-week").click("click", function() {

		myTableweek.ajax.reload();
	});
	/**
	 * 查询月
	 */
	$("#btn-month").click("click", function() {

		myTablemonth.ajax.reload();
	});


});


