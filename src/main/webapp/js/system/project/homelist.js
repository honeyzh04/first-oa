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
						"aLengthMenu" : [ 15, 30], //更改显示记录数选项
						paging : true,//翻页
						info : true, //页脚
						ordering : false,//排序
						ajax : {
							url : "./project/findHomeList.shtml",// 数据请求地址
							type : "POST",

							data : function(params) {
								// 此处为定义查询条件 传给控制器的参数
								// 角色名称
								params.projectName = $("#projectName").val();
								params.type = $("input[name='ProjectFormMap.type']:checked").val();
								params.region = $("input[name='ProjectFormMap.region']:checked").val();
								params.prices = $("input[name='ProjectFormMap.prices']:checked").val();
								params.area = $("input[name='ProjectFormMap.area']:checked").val();
						
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

                            {
                                data : "projectName"
                            },
                            {
                                data : "building",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';
                                    } else {
                                        return data;
                                    }

                                }
                            },	{
                                data : "floor",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';
                                    } else {
                                        return data;
                                    }

                                }
                            },{
                                data : "roomNo",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';
                                    } else {
                                        return data;
                                    }

                                }
                            },{
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
                                data : "price",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';
                                    } else {
                                        return data;
                                    }

                                }
                            },{
                                data : "sell",
                                bSortable : false,
                                className : "text-center",
                                render : function(data, type, row, meta) {
                                    if (data == 1) {
                                        return '<span >出售</span>';
                                    } else if (data == 2) {
                                        return '<span >在售</span>';
                                    } else if (data == 3) {
                                        return '<span >认购</span>';
                                    } else if (data == 4) {
                                        return '<span >已售</span>';
                                    } else {
                                        return '<span>未知</span>';
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
			    		        				"<button id='editRow' onclick='detailsCustomer(this);' class='btn btn-warning btn-s' type='button'>详情</button>"+
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
	$("#addHome").click("click", function() {
        addHome();
	});
	//修改按钮
	$("#editHome").click("click", function() {
		editHome();

	});
	//删除按钮
	$("#delHome").click("click", function() {
		delHome();

	});

    //图片上传
    $("#addHomeImg").click("click", function() {
        addHomeImg();

    });



});



/**
 * 添加
 * @returns
 */
function addHome() {
	pageii = layer.open({
		title : "添加项目",
		type : 2,
		area : [ "1000px", "80%" ],
		content : './project/addHomeUI.shtml'
	});
}
/**
 * 编辑
 * @returns
 */
function editHome() {
	var cbox = $(".checkchild:checked");

	if (cbox.length != 1) {
		layer.msg('请选择唯一一条住宅数据！', {
			icon : 2,
			time : 2000
		// 2秒关闭（如果不配置，默认是3秒）
		});
		return;
	}
	var id = $(".checkchild:checked").val();

	pageii = layer.open({
		title : "编辑项目",
		type : 2,
        area : [ "1000px", "80%" ],
		content : './project/editHomeUI.shtml?id=' + id,

	});

}
/**
 * 删除
 * @returns
 */
function delHome() {

	var id_array = new Array();
	$('input[name="checkchild"]:checked').each(function() {

		id_array.push($(this).val());//向数组中添加元素  

	});
	if (id_array.length < 1) {
		layer.msg('您没有选择数据！', {
			icon : 2,
			time : 2000
		//2秒关闭（如果不配置，默认是3秒）
		});
		return;
	} else {

		var idstr = id_array.join(',');

		layer.confirm('是否删除？', function(index) {

			$.ajax({
				"url" : './project/deleteHome.shtml?ids=' + idstr,

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
 *
 * 项目详情
 * @param _this
 */
function detailsCustomer(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var prId = aData.id;
    var state = aData.state;


    pageii = layer.open({
        title : "楼盘详情",
        resize : false,
        type : 2,
        area : [ "1000px", "80%" ],
        content : './project/findHomeUI.shtml?id=' + prId

    });

}

/**
 *
 * 匹配客户
 * @param _this
 */
function matchingCustomer(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var Id = aData.id;


    pageii = layer.open({
        title : "匹配客户",
        resize : false,
        type : 2,
        area : ["60%","70%"],
        content : './match/matchingCustomer.shtml?id=' + Id

    });

}
/**
 * 传图
 * @returns
 */
function addHomeImg() {
    var cbox = $(".checkchild:checked");

    if (cbox.length != 1) {
        layer.msg('请选择唯一一条住宅销控数据！', {
            icon : 2,
            time : 2000
            // 2秒关闭（如果不配置，默认是3秒）
        });
        return;
    }
    var id = $(".checkchild:checked").val();

    pageii = layer.open({
        title : "住宅销控图片",
        type : 2,
        area : [ "700px", "80%" ],
        content : './project/addHomeImgUI.shtml?id=' + id,

    });

}