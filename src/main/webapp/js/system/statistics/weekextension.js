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
                        bLengthChange: false,
                        "scrollX": true,
						ordering : false,// 排序
						"bStateSave": false,
                        fixedColumns : {//关键是这里了，需要第一列不滚动就设置1
                            leftColumns : 4
                        },

						ajax : {
							url : "./statistics/findByWeekExtension.shtml",// 数据请求地
							type : "POST",
							data : function(params) {
								// 此处为定义查询条件 传给控制器的参数
								// 角色名称
								params.screateDate = $("#screateDate").val();
                                params.ecreateDate = $("#ecreateDate").val();

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
                                data : "platform",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "channel",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "ways",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "consume",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "keyword",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "shows",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "click",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "ip_click",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "pv_click",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "uv_click",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                       /*     {
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
                            },*/
                            {
                                data : "click_rate",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "avetime",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },


                            {
                                data : "bounce_rate",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "aveprice",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

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
                                data : "eftelephone",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "weiliao",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "efweiliao",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "shangqiao",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "efshangqiao",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "message",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "dialogue_cost",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "efdialogue_cost",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "dialogue_time",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "filter_add",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : 'cost1',
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "filter_visit",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "filter_deal",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "adds28",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },{
                                data : "adds16",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "adds18",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "adds20",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },{
                                data : "adds21",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "adds17",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "adds24",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },{
                                data : "visit16",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "visit18",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "visit20",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },{
                                data : "visit21",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "visit17",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "visit24",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "dea16",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "dea18",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "dea20",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },{
                                data : "dea21",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "dea17",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "dea24",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "commission",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
                            {
                                data : "commissionr",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '/';

                                    } else {
                                        return  data;
                                    }
                                }
                            },
								 ],
						// /操作按钮
						columnDefs : [

							

						],
						oLanguage : {
							"sProcessing" :"<img src='./img/loading.gif' /> 努力加载数据中.",
							"sLengthMenu" : "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每页显示 _MENU_ 天竞价信息",
							"sZeroRecords" : "抱歉， 没有找到",
							"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条竞价信息",
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
        area : [ "530px", "520px" ],
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
        area : [ "800px", "80%" ],
        content : './statistics/addwUI.shtml'
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