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
							url : "./statistics/findByExtension.shtml",// 数据请求地
							type : "POST",
							data : function(params) {
								// 此处为定义查询条件 传给控制器的参数
								// 角色名称
								params.monthDate = $("#monthDate").val();

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
								data : "createDate",
                                width:"60px",
								render : function(data, type, full,
										callback) {

									var date = new Date(data);
									var y = date.getFullYear();
									var m = date.getMonth() + 1;
									var d = date.getDate();

									m = m < 10 ? ("0" + m) : m;
									d = d < 10 ? ("0" + d) : d;
									return y + "-" + m + "-" + d ;
								}
							},
                            {
                                data : "baiduss_price",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "baiduss_click",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },{
                                data : "baiduxxl_price",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "baiduxxl_click",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "sougou_price",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "sougou_click",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "shenma_price",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "shenma_click",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "adds",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "cost",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                "data" : null

                            },
                            {
                                data : "add_conversion",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        var str=Number(data*100).toFixed(2);
                                        str+="%";
                                        return str;

                                    }
                                }
                            },
                            {
                                data : "vis",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "dea",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "dea_conversion",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        var str=Number(data*100).toFixed(2);
                                        str+="%";
                                        return str;
                                    }
                                }
                            },
                            {
                                data : "commission",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "projectName",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "price",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
								 ],
						// /操作按钮
						columnDefs : [
                            {
                                targets :12,// 操作按鈕位置，从0开始数为第几例
                                data : "id",

                                "render" : function(data, type, full) {
                                    return "<div class='btn-group'>"
                                        + "<button onclick='check(this);' class='btn btn-primary btn-sm btn-s' type='button'>查看</button>"

                                        + "</div>"
                                }
                            }

							

						],
						oLanguage : {
							"sProcessing" :"<img src='./img/loading.gif' /> 努力加载数据中.",
							"sLengthMenu" : "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每页显示 _MENU_ 天竞价信息",
							"sZeroRecords" : "抱歉， 没有找到",
							"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 天竞价信息",
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
	 * 查询客户
	 */
	$("#btn-test").click("click", function() {

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


});// 加载完执行Js end

// 分割线。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。表格内置操作按钮
/**
 * 客户扩展
 *
 * @param _this
 * @returns
 */
function check(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var createDate = aData.createDate;


    pageii = layer.open({
        title : "客户来源",
        resize : false,
        type : 2,
        area : [ "530px", "600px" ],
        content : './statistics/sourceUI.shtml?createDate=' +createDate

    });

}
/**
 * 录入
 * @returns
 */
function addAccount() {
    pageii = layer.open({
        title : "录入报表",
        type : 2,
        area : [ "800px", "500px" ],
        content : './statistics/addUI.shtml'
    });
}
/**
 * 编辑
 * @returns
 */
function editAccount() {
    var cbox = $(".checkchild:checked");

    if (cbox.length != 1) {
        layer.msg('请选择一条数据！', {
            icon : 2,
            time : 2000
            //2秒关闭（如果不配置，默认是3秒）
        });
        return;
    }
    var id = cbox.val();

    pageii = layer.open({
        title : "编辑报表",
        type : 2,
        area : [ "620px", "450px" ],
        content : './statistics/editUI.shtml?id=' + id,

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
        layer.msg('您没有选择报表信息！', {
            icon : 2,
            time : 2000
            //2秒关闭（如果不配置，默认是3秒）
        });
        return;
    } else {

        var idstr = id_array.join(',');

        layer.confirm('是否删除？', function(index) {

            $.ajax({
                "url" : './statistics/deleteEntity.shtml?id=' + idstr,

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