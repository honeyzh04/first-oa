var myTable = null;
var pageii = null;
$(function() {

	// 初始化表格对象

	myTable = $('#datatable')
			.DataTable(
					{

						autoWidth : true, //宽度自适应
						searching : false,//禁用datatables搜索
						processing : true,//载入数据的时候是否显示“载入中”
						serverSide : true,//开启服务器模式。分页，取数据等等的都放到服务端去
						"aLengthMenu" : [ 10, 20, 30 ], //更改显示记录数选项
						paging : true,//翻页
						info : true, //页脚
						ordering : false,//排序
						ajax : {
							url : "./user/findByPage.shtml",// 数据请求地址
							type : "POST",

							data : function(params) {
								// 此处为定义查询条件 传给控制器的参数
								// 角色名称
								params.userName = $("#userName").val();

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
									data : "accountName"
								},
								{
									data : "userName",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								},
								{
									data : "roleName",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								},
								{
									data : "departmentName",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								},
								{
									data : 'gender',
									bSortable : false,

									className : "text-center",
									render : function(data, type, row, meta) {
										if (data == 1) {
											return '<span title="男" class="icon-symbol-male font-blue"></span>';
										} else if (data == 2) {
											return '<span title="女" class="icon-symbol-female font-red"></span>';
										} else {
											return '<span title="未知" class="icon-question font-green"></span>';
										}
									}
								}, {
									data : "email",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								},{
									data : "telephone",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								},{
									data : "locked",
									render : function(data, type, row, meta) {
										if (data == 1) {
											return '<span >可用</span>';
										}  else if(data == 0){
											return '<span >不可用</span>';
										} 

									}
								}, {
									data : "description",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';
										} else {
											return data;
										}

									}
								}
						/*
						 * {"data": null, render : function(data, type, row,
						 * meta) { return '<span class="label label-sm
						 * label-success" onclick="findOpe(this);"
						 * style="cursor: pointer;">查看操作日志</span>'; } }
						 */
						],
						// /操作按钮
						/*
						 * columnDefs: [ { targets: 0, defaultContent: "<input
						 * type='checkbox' name='checkList'>" },
						 */
						// 复选框单元格
						/*
						 * { targets: 0, className: "td-checkbox", orderable :
						 * false, bSortable : false, data : "id", width :
						 * '30px', render : function(data, type, row, meta) {
						 * return '<input type="checkbox" class="checkchild"
						 * name="checkList" value="' + data + '" />';
						 * 
						 *  } } ,
						 */
						/*
						 * columnDefs: [{ targets: 3,// <span
						 * style="font-family:Arial, Helvetica, sans-serif;">操作例</span>的位置，从0开始数为第几例，
						 * data: "id", width: 140, "render": function(data,
						 * type, full){ return "<a id='upd' class='btn btn-info
						 * btn-xs'><i class='fa fa-pencil'></i>修改权限</a>" + "<button
						 * class='btn btn-danger btn-xs'
						 * onclick='deleteRoleRes("+data+")'><i class='fa
						 * fa-remove'></i> 删除</button>" } }], { targets: -1,//
						 * <span style="font-family:Arial, Helvetica,
						 * sans-serif;">操作例</span>的位置，从0开始数为第几例， data: "id",
						 * 
						 * "render": function(data, type, full){ return "<div
						 * class='btn-group'>"+ "<button id='editRow' onclick='
						 * editAccount(this);' class='btn btn-primary btn-sm'
						 * type='button'><i class='fa fa-edit'></i></button>"+ "<button
						 * id='del' onclick='del(this);' class='btn btn-primary
						 * btn-sm' type='button'><i class='fa fa-trash-o'></i></button>"+ "</div>" } }
						 *  ],
						 */
						oLanguage : {
							"sProcessing" :"<img src='./img/loading.gif' /> 努力加载数据中.",
							"sLengthMenu" : "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每页显示 _MENU_ 条员工记录",
							"sZeroRecords" : "抱歉， 没有找到",
							"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条员工信息",
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
	// select row
	/*
	 * $('#datatable tbody').on('click', 'tr', function () { alert("点击");
	 * $(this).toggleClass('selected'); });
	 */
	// del data
	/*
	 * $('#datatable').on('click', '#del', function () { alert("点击1"); var data =
	 * myTable.row($(this).parents('tr')).data(); alert(data); var nId =
	 * data.id; var status = 0; if (confirm("数据将永久删除，你确定要删除吗？")) { $.ajax({ url:
	 * "./user/deleteEntity.shtml?id" + nId, type: "POST" }).done(function (doc) {
	 * if (doc === 1) { table.ajax.reload(); } }); }
	 * 
	 * });
	 */
	

	/*
	 * $('#delAccount').click(function () { var data =
	 * myTable.rows('.selected').data(); $.each(data, function (index, value) {
	 * 
	 * }); });
	 */

	// checkbox全选
/*	$("#checkAll").on(
			"click",
			function() {
				if ($(this).prop("checked") === true) {
					var id = $("input[name='checkList']").prop("checked",
							$(this).prop("checked"));
					alert(id);

					$(this).hasClass('selected')
				} else {
					$("input[name='checkList']").prop("checked", false);
					$("#dataTable tbody tr").removeClass('selected');
				}
			});*/

	//查询
	$("#search").click("click", function() {// 绑定查询按扭
		myTable.ajax.reload();
	});
	//添加按钮
	$("#addAccount").click("click", function() {
		addAccount();
	});
	//修改按钮
	$("#editAccount").click("click", function() {
		editAccount();

	});
	//删除按钮
	$("#delAccount").click("click", function() {
		delAccount();

	});
	//重置密码
	$("#resetAccount").click("click", function() {
		resetAccount();

	});

});

// 分割线。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
/*function editAccount(_this) {
	var nRow = $(_this).parents('tr')[0];// 得到这一行
	var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
	var userId = aData.id;
	pageii = layer.open({
		title : "编辑",
		type : 2,
		area : [ "600px", "80%" ],
		content : './user/editUI.shtml?id=' + userId,

	});
	// post请求
	
	  $.ajax({ type: 'POST', url: './user/editUI.shtml',//发送请求 data:
	  {id:userId}, dataType : "html", success: function(result) { var htmlCont =
	  result;//返回的结果页面 layer.open({ type: 1,//弹出框类型 title : "编辑", shadeClose:
	 false, //点击遮罩关闭层 area : [ "600px", "80%" ], shift:1, content:
	  htmlCont,//将结果页面放入layer弹出层中 success: function(layero, index){
	   } }); } });
	
}
*/
/*function del(_this) {
	var nRow = $(_this).parents('tr')[0];// 得到这一行
	alert(nRow);
	var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
	alert(aData);
	var userId = aData.id;
	alert(userId);
	layer.confirm('是否删除？', function(index) {
		var url = './user/deleteEntity.shtml';
		var s = CommnUtil.ajax(url, {
			ids : cbox.join(",")
		}, "json");
		if (s == "success") {
			layer.msg('删除成功');
			grid.loadData();
		} else {
			layer.msg('删除失败');
		}
	});
}*/
/*
 * function getSelectLine() { alert("12"); var nTrs
 * =$("#datatable").dataTable().fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr
 * alert(nTrs); for ( var i = 0; i < nTrs.length; i++) {
 * if($(nTrs[i]).hasClass('selected')){//相当于$(tr) var selectLine =
 * myTable.fnGetData(nTrs[i]); alert(selectLine[4]);//获取一行第4列数据 } } }
 */

// 得到userId
/*
 * function editAccount() { var cbox =myTable.row($(this).closest('tr')).data();
 * console.log("cbox"); if (cbox.length > 1 || cbox == "") {
 * layer.msg("只能选中一个"); return; } pageii = layer.open({ title : "编辑", type : 2,
 * area : [ "600px", "80%" ], content :'./user/editUI.shtml?id=' + cbox }); var
 * nTrs = myTable.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象 for(var i =
 * 0; i < nTrs.length; i++){ console.log('[获取数据]' +
 * table.fnGetData(nTrs[i]));//fnGetData获取一行的数据 }
 *  }
 */




/**
 * 添加
 * @returns
 */
function addAccount() {
	pageii = layer.open({
		title : "新增",
		type : 2,
		area : [ "600px", "80%" ],
		content : './user/addUI.shtml'
	});
}
/**
 * 编辑
 * @returns
 */
function editAccount() {
	var cbox = $(".checkchild:checked");

	if (cbox.length != 1) {
		layer.msg('请选择唯一一条数据！', {
			icon : 2,
			time : 2000
		// 2秒关闭（如果不配置，默认是3秒）
		});
		return;
	}
	var id = $(".checkchild:checked").val();

	pageii = layer.open({
		title : "编辑",
		type : 2,
		area : [ "600px", "80%" ],
		content : './user/editUI.shtml?id=' + id,

	});

}
/**
 * 删除
 * @returns
 */
function delAccount() {

	var id_array = new Array();
	$('input[name="checkchild"]:checked').each(function() {

		id_array.push($(this).val());//向数组中添加元素  

	});
	if (id_array.length < 1) {
		layer.msg('您没有选择职位信息！', {
			icon : 2,
			time : 2000
		//2秒关闭（如果不配置，默认是3秒）
		});
		return;
	} else {

		var idstr = id_array.join(',');

		layer.confirm('是否删除？', function(index) {

			$.ajax({
				"url" : './user/deleteEntity.shtml?id=' + idstr,

				"type" : "GET",
				"datatype" : "json",
				"success" : function(s) {

					layer.msg('删除成功', {
						icon : 1,
						time : 1000
					//2秒关闭（如果不配置，默认是3秒）
					});
					//myTable.ajax.reload();
					myTable.draw(false);
				},
				error : function(er) {
					layer.msg('删除失败');
				}

			});
			layer.close(index);
		});

	}

}

/**
 * 重置密码
 * @returns
 */
function resetAccount() {
 
	var cbox = $(".checkchild:checked");

	if (cbox.length != 1) {
		layer.msg('请选择唯一一条数据！', {
			icon : 2,
			time : 2000
		// 2秒关闭（如果不配置，默认是3秒）
		});
		return;
	} 
	var id = $(".checkchild:checked").val();
	

		layer.confirm('是否重置密码？', function(index) {

			$.ajax({
				
				"url" : './user/resetPassword.shtml?id=' + id,

				"type" : "GET",
				"datatype" : "json",
				"success" : function(s) {

					layer.msg('重置成功', {
						icon : 1,
						time : 1000
					//2秒关闭（如果不配置，默认是3秒）
					});
					//myTable.ajax.reload();
					myTable.draw(false);
				},
				error : function(er) {
					layer.msg('重置失败');
				}

			});
			layer.close(index);
		});

	
}
