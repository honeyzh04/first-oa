var myTable = null;
var pageii = null;
$(function() {
	// 初始化表格对象

	myTable = $('#datatable')
			.DataTable(
					{

						autoWidth : true, // 宽度自适应
						searching : false,// 禁用datatables搜索
						processing : true,// 载入数据的时候是否显示“载入中”
						serverSide : true,// 开启服务器模式。分页，取数据等等的都放到服务端去
						"aLengthMenu" : [ 10, 20, 30 ], // 更改显示记录数选项
						paging : true,// 翻页
						info : true, // 页脚
						ordering : false,// 排序
						"bStateSave": false,
						ajax : {
							url : "./customer/findByPage.shtml",// 数据请求地
							type : "POST",
							data : function(params) {
								// 此处为定义查询条件 传给控制器的参数
								// 角色名称
								params.customerName = $("#customerName").val();
								params.telephone = $("#telephone").val();
								params.followa = $("#followa").val();
								params.screateDate = $("#screateDate").val();
								params.ecreateDate = $("#ecreateDate").val();
								params.stotalPrice = $("#stotalPrice").val();
								params.etotalPrice = $("#etotalPrice").val();
								params.department = $("#department").val();
								params.userId = $("#userId").val();
								params.state = $("#state").val();
								params.purpose = $("#purpose").val();
								params.apartment =$("#apartment").val();
								params.cusource = $("#cusource").val();
								params.date = $("input[name='customerFormMap.date']:checked").val();
								params.intention = $("input[name='customerFormMap.intention']:checked").val();
								params.choice = $('input[type=checkbox]:checked').val();

							}
						},
						columns : [
								{
									data : "id",
									sClass : "text-center",
									render : function(data, type, full, meta) {
										return '<input type="checkbox"  class="checkchild" name="checkchild"  value="'
												+ data + '" />';
									},
									bSortable : false
								},

								{
									data : "customerName"
								},
								{
									"data" : "content",
									"visible" : false,
									sClass : "text-center",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '<span >没有跟进</span>';

										} else {
											return  data;
										}
									}
								},
								{
									data : "telephone",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';

										} else {
											return  data;
										}
									}
								},
								{
									data : 'gender',
									render : function(data, type, row, meta) {
										if (data == 1) {
											return '<span>男</span>';
										} else if (data == 2) {
											return '<span>女</span>';
										} else {
											return '<span>未知</span>';
										}
									}
								},

								{
									data : "totalPrice",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';

										} else {
											return  data;
										}
									}
								},
								{
									data : "purpose",
									render : function(data, type, row, meta) {
										if (data == 1) {
											return '<span >投资</span>';
										} else if (data == 2) {
											return '<span >自用</span>';
										} else {
											return '<span >其他</span>';
										}
									}
								},
								{
									data : "apartment",
									render : function(data, type, row, meta) {
										if (data == 1) {
											return '<span >商铺</span>';
										} else if (data == 2) {
											return '<span >公寓</span>';
										} else {
											return '<span >其他</span>';
										}
									}
								},
								{
									data : "intention",
									render : function(data, type, row, meta) {
										if (data == 1) {
											return '<span >A</span>';
										} else if (data == 2) {
											return '<span >B</span>';
										} else if (data == 3) {
											return '<span >C</span>';
										} else {
											return '<span >其他</span>';
										}
									}
								},
								{
									data : "state",
									render : function(data, type, row, meta) {
										if (data == 1) {
											return '<span >新增</span>';
										} else if (data == 2) {
											return '<span  style="font-weight:bold;color:#228B22";>到访</span>';
										} else if (data == 3) {
											return '<span >排号</span>';
										} else if (data == 4) {
											return '<span  style="font-weight:bold;color:red">成交</span>';
										} else if (data == 5) {
											return '<span >退单</span>';
										} else {
											return '<span >其他</span>';
										}
									}
								},
								{
									data : "cusource",
									render : function(data, type, row, meta) {
										if (data == 1) {
											return '<span >网络（安居客端口）</span>';
										} else if (data == 2) {
											return '<span >网络（58同城端口）</span>';
										} else if (data == 3) {
											return '<span >网络（房发现端口）</span>';
										} else if (data == 4) {
											return '<span >网络（安居客供客）</span>';
										} else if (data == 5) {
											return '<span >网络（58同城供客）</span>';
										} else if (data == 6) {
											return '<span >网络（房发现供客）</span>';
										} else if (data == 7) {
											return '<span >自身（打街霸）</span>';
										} else if (data == 8) {
											return '<span >自身（朋友推荐）</span>';
										} else if (data == 9) {
											return '<span >主动T客户</span>';
										} else {
											return '<span >未知</span>';
										}
									}
								},
								{
									data : "userName",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';

										} else {
											return  data;
										}
									}
								},
								{
									data : "departmentName",
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';

										} else {
											return  data;
										}
									}
								},

						/*		{
									data : "trackDate",
									render : function(data, type, full,
											callback) {

										var date = new Date(data);
										var y = date.getFullYear();
										var m = date.getMonth() + 1;
										var d = date.getDate();
										var h = date.getHours();
										var m1 = date.getMinutes();
										var s = date.getSeconds();
										m = m < 10 ? ("0" + m) : m;
										d = d < 10 ? ("0" + d) : d;
										return y + "-" + m + "-" + d + " " + h
												+ ":" + m1;
									}
								},*/
								{
									data : "trackremind",
									render : function(data, type, row, meta) {
										if (data == 0) {
											return '<span style="color:	#43CD80">今日已跟</span>';
										}else if (data == 1) {
											return '<span style="color:#43CD80">昨日跟进</span>';
										} else if (data == 2) {
											return '<span style="color:#9400D3">1日未跟</span>';
										} else if (data == 3) {
											return '<span style="color:#9400D3">2日未跟</span>';
										}else if (data == 4) {
											return '<span style="color:#9400D3" >3日未跟</span>';
										}else if (data == 5) {
											return '<span style="color:#FFB800">4日未跟</span>';
										}else if (data == 6) {
											return '<span style="color:#FFB800">5日未跟</span>';
										}else {
											return '<span style="color:#FF0000">6日未跟</span>';
										}
									}
								}, {
									"data" : null
									
								} ],
						// /操作按钮
						columnDefs : [
								{
									"targets" : 1,
									"data" : "customerName",
									className : "text-center",  
									"render" : function(data, type, full) {
										// return "<div title='"+data+"'
										// >"+data.substring(0,3)+"</div>";//
										// 也可以不用a标签，用<span>
										// return "<div id='usrName'
										// onclick='func(this);'>a</div>";
										return  "<div class='btn-group' onclick='funAccount(this);'>"+ data + "</div>"

									}
								},

								/*
								 * columnDefs: [{ targets: 3,// <span
								 * style="font-family:Arial, Helvetica,
								 * sans-serif;">操作例</span>的位置，从0开始数为第几例， data:
								 * "id", width: 140, "render": function(data,
								 * type, full){ return "<a id='upd' class='btn
								 * btn-info btn-xs'><i class='fa fa-pencil'></i>修改权限</a>" + "<button
								 * class='btn btn-danger btn-xs'
								 * onclick='deleteRoleRes("+data+")'><i
								 * class='fa fa-remove'></i> 删除</button>" }
								 * }],
								 */
							
								{
									targets : -1,// 操作按鈕位置，从0开始数为第几例
									data : "id",
									width:"240px",
									"render" : function(data, type, full) {
										return "<div class='btn-group'>"
												+ "<button onclick='editAccount(this);' class='btn btn-primary btn-sm btn-s' type='button'><i class='fa fa-edit'></i>&nbsp;&nbsp; 跟</button>"
												+"<button onclick=' extendAccount(this);' class='btn btn-primary btn-sm btn-s' type='button'><i class='fa fa-edit'></i>&nbsp;&nbsp;扩</button>"
												+"<button onclick='giveAccount(this);' class='btn btn-primary btn-sm btn-s' type='button'><i class='fa fa-sign-in'></i>&nbsp;&nbsp;转</button>"
												+"<button  onclick=' discardAccount(this);' class='btn btn-primary btn-sm btn-s' type='button'><i class='fa fa-trash-o'></i>&nbsp;&nbsp;弃</button>"
												+ "<button  onclick='preAccount(this);' class='btn btn-primary btn-sm btn-s' type='button'><i class='fa fa-comment-o'></i>&nbsp;&nbsp;报</button>"
												+ "</div>"
									}
								}

						],
						oLanguage : {
							"sProcessing" :"<img src='./img/loading.gif' /> 努力加载数据中.",
							"sLengthMenu" : "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每页显示 _MENU_ 条客户记录",
							"sZeroRecords" : "抱歉， 没有找到",
							"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条客户信息",
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

					/*
					 * "fnServerParams": function (aoData) { aoData.push( {
					 * "name": "customerName", "value": $('#customerName').val() }
					 *  ); },
					 */

					});

	/**
	 * 查询客户
	 */
	$("#btn-test").click("click", function() {

		myTable.ajax.reload();
	});

	/**
	 * 客户添加
	 */
	$("#addAccount").click("click", function() {
		addAccount();
	});
	/**
	 *客户共享
	 */
	$("#shareAccount").click("click", function() {
		shareAccount();
	});
	/**
	 * 客户删除
	 */

	$("#delAccount").click("click", function() {

		var cbox = $(".checkchild:checked");
		var length = cbox.length;
		var id = cbox.val();

		if (length != 1) {
			layer.msg('请选择一条且只有一条客户信息！', {
				icon : 2,
				time : 2000
			// 2秒关闭（如果不配置，默认是3秒）
			});
			return;
		} else {

			layer.confirm('是否删除？', function(index) {

				$.ajax({
					"url" : './customer/deleteEntity.shtml?id=' + id,

					"type" : "GET",
					"datatype" : "json",
					"success" : function(s) {

						layer.msg('删除成功', {
							icon : 1,
							time : 1000
						// 2秒关闭（如果不配置，默认是3秒）
						});
						// myTable.ajax.reload();
						myTable.draw(false);
					},
					error : function(er) {
						layer.msg('删除失败');
					}

				});
				layer.close(index);
			});

		}
	});

	/**
	 * 展开/收缩 查询栏目
	 */

	$("#morea").click(function() {
		if ($("#morecontent").css("display") == "none") {

			$("#morecontent").show();
			// 改变#change的class
			$("#change").removeClass("glyphicon-triangle-bottom");
			$("#change").addClass("glyphicon-triangle-top");

		} else {

			$("#morecontent").hide();
			$("#change").removeClass("glyphicon-triangle-top");
			$("#change").addClass("glyphicon-triangle-bottom");
		}
	})
	/**
	 * 客户批量转让
	 */
	$("#gives").click("click", function() {
		
		givesAccount();
	});
	/**
	 * 刷新
	 */
	$("#refresh").click("click", function() {

		myTable.ajax.reload();
	});
});// 加载完执行Js end

// 分割线。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。表格内置操作按钮
/**
 * 跟进详情弹窗
 */
var tmp = "";
function funAccount(_this) {

	var nRow = $(_this).parents('tr')[0];// 得到这一行

	var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据

	var cuId = aData.content;

	if (tmp == "") {
		tmp = layer.tips(cuId, _this, {
			tips : [ 2, '#3595CC' ],
			area: ['400px', 'auto'],
			time : 20000
			
		});

	} else {
		tmp = layer.close(tmp);
		tmp = "";
	}
}

/*
 * 客户跟进
 */
function editAccount(_this) {
	
	var nRow = $(_this).parents('tr')[0];// 得到这一行
	var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
	var cuId = aData.id;
	pageii = layer.open({
		title : "客户跟进",
		resize : false,
		type : 2,
		area : [ "1020px", "80%" ],
		content : './customer/editUI.shtml?id=' + cuId,

	});

}
/**
 * 客户扩展
 * 
 * @param _this
 * @returns
 */
function extendAccount(_this) {
	var nRow = $(_this).parents('tr')[0];// 得到这一行
	var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
	var cuId = aData.id;
	var customerName = aData.customerName;

	pageii = layer.open({
		title : "客户扩展",
		resize : false,
		type : 2,
		area : [ "530px", "520px" ],
		content : './customer/extendUI.shtml?id=' + cuId + '&customerName='
				+ customerName,

	});

}
/**
 * 转让客户
 * 
 * @param _this
 * @returns
 */
function giveAccount(_this) {
	var nRow = $(_this).parents('tr')[0];// 得到这一行
	var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
	var cuId = aData.id;
    var userId = aData.userId;
	pageii = layer.open({
		// skin: 'layui-layer-rim',
		title : "客户转让",
		type : 2,
		area : [ "560px", "200PX" ],
		content : './customer/transferUI.shtml?id=' + cuId,
	/*
	 * end: function () {
	 * 
	 * myTable.ajax.reload( null,false); }
	 */

	});

}

/**
 * 放入公共池
 * 
 * @param _this
 * @returns
 */
function discardAccount(_this) {
	var nRow = $(_this).parents('tr')[0];//得到这一行    

	var aData = $("#datatable").dataTable().fnGetData(nRow);//得到这一行的json数据   

	var cuId = aData.id;

	pageii = layer.open({

		title : "客户丢弃",
		type : 2,
		area : '600px',
		content : './customer/discardUI.shtml?id=' + cuId,
	/* end: function () {

	     myTable.ajax.reload( null,false);
	 }*/

	});

}
/**
 * 报备客户
 * @param _this
 * @returns
 */
function preAccount(_this) {
	var nRow = $(_this).parents('tr')[0];//得到这一行    
	var aData = $("#datatable").dataTable().fnGetData(nRow);//得到这一行的json数据   
	var cuId = aData.id;
	pageii = layer.open({
		title : "客户报备",
		//resize:false,
		type : 2,
		area : [ "530px", "500px" ],
		content : './customer/preparationUI.shtml?id=' + cuId,

	});

}
/**
 * 新增用户
 * @returns
 */
function addAccount() {
	pageii = layer.open({
		title : "新增",
		type : 2,
		area : [ "1000px", "80%" ],
		content : './customer/addUI.shtml'

	});
};
/**
 * 批量转让
 * @returns
 */
function givesAccount() {

	var id_array = new Array();
	$('input[name="checkchild"]:checked').each(function() {

		id_array.push($(this).val());//向数组中添加元素  

	});
	if (id_array.length < 1) {
		layer.msg('您没有选择客户！', {
			icon : 2,
			time : 2000
		//2秒关闭（如果不配置，默认是3秒）
		});
		return;
	} else {

		var idstr = id_array.join(',');

		pageii = layer.open({
			// skin: 'layui-layer-rim',
			title : "客户转让",
			type : 2,
			area : [ "560px", "200PX" ],
			content : './customer/transferUI.shtml?id=' +  idstr,
		/*
		 * end: function () {
		 * 
		 * myTable.ajax.reload( null,false); }
		 */

		});


	}


};

/**
 * 客户共享
 * @param _this
 * @returns
 */
function shareAccount() {

	var cbox = $(".checkchild:checked");
	var length = cbox.length;
	var id = cbox.val();

	if (length != 1) {
		layer.msg('请选择一条且只有一条客户信息！', {
			icon : 2,
			time : 2000
		// 2秒关闭（如果不配置，默认是3秒）
		});
		return;
	} else {

	pageii = layer.open({
		// skin: 'layui-layer-rim',
		title : "客户共享",
		type : 2,
		area : [ "560px", "60%" ],
		content : './customer/shareUI.shtml?id=' + id,


	});
	}
}

$.fn.dataTable.ext.errMode = 'none'; //不显示任何错误信息

//以下为发生错误时的事件处理，如不处理，可不管。
$('#example')
    .on( 'error.dt', function ( e, settings, techNote, message ) {
//这里可以接管错误处理，也可以不做任何处理
        console.log( 'An error has been reported by DataTables: ', message );
    } )
    .DataTable();
