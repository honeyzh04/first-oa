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
						"aLengthMenu" : [ 15, 30 ], // 更改显示记录数选项
						paging : true,// 翻页
						info : true, // 页脚
						ordering : false,// 排序
						"bStateSave": false,
						ajax : {
							url : "./customer/findByffxCustomer.shtml",// 数据请求地
							type : "POST",
							data : function(params) {
								// 此处为定义查询条件 传给控制器的参数
								// 角色名称
								params.customerName = $("#customerName").val();
								params.telephone = $("#telephone").val();
								params.screateDate = $("#screateDate").val();
								params.ecreateDate = $("#ecreateDate").val();
							}
						},
						columns : [
			

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
                                data : "ffxsource",
                                render : function(data, type, row, meta) {
                                    if (data == 10) {
                                        return '<span >百度商桥</span>';
                                    } else if (data == 11) {
                                        return '<span >百度推广电话</span>';
                                    } else if (data == 12) {
                                        return '<span >房发现电话</span>';
                                    } else if (data == 13) {
                                        return '<span >房发现微聊</span>';
                                    } else if (data == 14) {
                                        return '<span >信息流</span>';
                                    } else if (data == 15) {
                                        return '<span >搜狗神马</span>';
                                    }else if (data == 16) {
                                        return '<span >离线宝</span>';
                                    } else if (data == 17) {
                                        return '<span >公众号</span>';
                                    } else if (data ==21) {
                                        return '<span >其他途径</span>';
                                    } else if (data == 18) {
                                        return '<span >页面留言</span>';
                                    } else if (data == 19) {
                                        return '<span >360推广</span>';
                                    }else if (data == 20) {
                                        return '<span >今日头条</span>';
                                    }else {
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
									"data" : "resources",
									render : function(data, type, row, meta) {
										if (data == 1) {
											return '<span >个人</span>';
										} else if (data == 2) {
											return '<span >蓝海</span>';
										} else {
											return '<span >公海</span>';
										}
									}
								},
									{
								data : "createDate",
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
							},
								 ],
						// /操作按钮
						columnDefs : [
								{
									"targets" : 0,
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
			time : 10000
			
		});

	} else {
		tmp = layer.close(tmp);
		tmp = "";
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