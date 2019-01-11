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
							url : "./credit/findCredit.shtml",// 数据请求地
							type : "POST",
							data : function(params) {
								// 此处为定义查询条件 传给控制器的参数
								// 角色名称
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
                                data : "userName",
                            },

								{
									data : "balance",
								},
                            {
                                "data" : null

                            }



								 ],
						// /操作按钮
						columnDefs : [

                            {
                                targets: -1,//操作按鈕位置，从0开始数为第几例
                                data: "id",

                                "render": function(data, type, full){
                                    return  "<div class='btn-group'>"+
                                        "<button id='editRow' onclick='discardAll(this);' class='btn btn-success btn-s' type='button'><i class='fa fa-edit'></i>&nbsp;&nbsp;积分记录</button>"+
                                        "</div>"
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

});// 加载完执行Js end


$.fn.dataTable.ext.errMode = 'none'; //不显示任何错误信息

//以下为发生错误时的事件处理，如不处理，可不管。
$('#example')
    .on( 'error.dt', function ( e, settings, techNote, message ) {
//这里可以接管错误处理，也可以不做任何处理
        console.log( 'An error has been reported by DataTables: ', message );
    } )
    .DataTable();