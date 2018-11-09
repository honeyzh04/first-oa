var myTable = null;
var pageii = null;


	// 初始化表格对象

	myTable = $('#datatable')
			.DataTable(
					{

						autoWidth : true, //宽度自适应
						searching : false,//禁用datatables搜索
						processing : true,//载入数据的时候是否显示“载入中”
						serverSide : true,//开启服务器模式。分页，取数据等等的都放到服务端去
						"aLengthMenu" : [ 15, 30], //更改显示记录数选项
						paging : true,//翻页
						info : true, //页脚
						ordering : false,//排序
						ajax : {
							url : "./match/findcumatch.shtml",// 数据请求地址
							type : "POST",

							data : function(params) {
								// 此处为定义查询条件 传给控制器的参数
								// 角色名称
								params.telephone = $("#telephone").val();
								
						
							}
						},
						columns : [
								{
									data : "id",
									sClass : "text-center",
									render : function(data, type, full, meta) {
										return '<input type="checkbox"  class="checkchild"  name="checkchild"  value="'
												+ data + '" />';
									},
									bSortable : false
								},
								/* {"data": null,"width":"10px"}, */
								
								{
									data : "projectName"
								},
								{
									data : "projectPosition",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								},
								{
									data : "type",
									render : function(data, type, row, meta) {
										if (data == 1) {
											return '<span >商铺</span>';
										} else if (data == 2) {
											return '<span >公寓</span>';
										} else if (data == 3) {
											return '<span >写字楼</span>';
										} else {
											return '<span >未知</span>';
										}

									}
								},
								{
									data : "area",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								},
								{
									data : 'price',
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								}, 	{
									data : 'prices',
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								},{
									data : "region",
									bSortable : false,

									className : "text-center",
									render : function(data, type, row, meta) {
										if (data == 12) {
											return '<span >南区</span>';
										} else if (data == 13) {
											return '<span >北区</span>';
										} else if (data == 14) {
											return '<span >东区</span>';
										} else if (data == 15) {
											return '<span >西区</span>';
										} else {
											return '<span>未知</span>';
										}
									}
								},{
									data : "firstPerson",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								},{
									data : "projectPerson",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								}, {
									data : "projectTelephone",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								},{
									data :null
								}
					
						],
						///操作按钮
			        	columnDefs: [
			        		
			                    {  
			                        targets: -1,//操作按鈕位置，从0开始数为第几例  
			                        data: "id",  
			                        
			                        "render": function(data, type, full){  
			                            return  "<div class='btn-group'>"+
			    		        				"<button id='editRow' onclick='discardCustomer(this);' class='btn btn-warning btn-s' type='button'>详情</button>"+
			    		        				"</div>" 
			                        }  
				                },
			        

		 	           ],
						oLanguage : {
							"sProcessing" :"<img src='./img/loading.gif' /> 努力加载数据中.",
							"sLengthMenu" : "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每页显示 _MENU_ 条项目记录",
							"sZeroRecords" : "抱歉， 没有找到",
							"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条项目信息",
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



	$("#btn-test").click("click", function() {// 绑定查询按扭
		myTable.ajax.reload();
	});
	

