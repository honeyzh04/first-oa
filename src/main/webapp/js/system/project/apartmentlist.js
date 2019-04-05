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
							url : "./projectApartment/findApartmentList.shtml",// 数据请求地址
							type : "POST",

							data : function(params) {
								// 此处为定义查询条件 传给控制器的参数
								// 角色名称
								params.projectName = $("#projectName").val();
						
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
                                data : "nature",
                                bSortable : false,
                                className : "text-center",
                                render : function(data, type, row, meta) {
                                    if (data == 1) {
                                        return '<span >商用</span>';
                                    } else if (data == 2) {
                                        return '<span >自用</span>';
                                    } else {
                                        return '<span>未知</span>';
                                    }
                                }
                            },{
                                data : "noodles",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';
                                    } else {
                                        return data;
                                    }

                                }
                            },
                            {
                                data : "currentPrice",
                                render : function(data, type, row, meta) {
                                    if (data == null) {
                                        return '';
                                    } else {
                                        return data;
                                    }

                                }
                            },{
                                data : "currentUnitPrice",
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
                            },
								{
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


	//查询
	$("#search").click("click", function() {// 绑定查询按扭
		myTable.ajax.reload();
	});
	//添加按钮
	$("#addApartment").click("click", function() {
        addApartment();
	});
	//修改按钮
	$("#editApartment").click("click", function() {
		editApartment();

	});
	//删除按钮
	$("#delApartment").click("click", function() {
		delApartment();

	});
    //图片上传
    $("#addApartmentImg").click("click", function() {
        addApartmentImg();

    });



});



/**
 * 添加
 * @returns
 */
function addApartment() {
	pageii = layer.open({
		title : "添加项目",
		type : 2,
		area : [ "1000px", "80%" ],
		content : './projectApartment/addApartmentUI.shtml'
	});
}
/**
 * 编辑
 * @returns
 */
function editApartment() {
	var cbox = $(".checkchild:checked");

	if (cbox.length != 1) {
		layer.msg('请选择唯一一条公寓数据！', {
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
		content : './projectApartment/editApartmentUI.shtml?id=' + id,

	});

}
/**
 * 删除
 * @returns
 */
function delApartment() {

	var id_array = new Array();
	$('input[name="checkchild"]:checked').each(function() {

		id_array.push($(this).val());//向数组中添加元素  

	});
	if (id_array.length < 1) {
		layer.msg('您没有选择！', {
			icon : 2,
			time : 2000
		//2秒关闭（如果不配置，默认是3秒）
		});
		return;
	} else {

		var idstr = id_array.join(',');

		layer.confirm('是否删除？', function(index) {

			$.ajax({
				"url" : './projectApartment/deleteApartment.shtml?ids=' + idstr,

				"type" : "GET",
				"datatype" : "json",
				"success" : function(s) {

					layer.msg('删除成功', {
						icon : 1,
						time : 1000
					//2秒关闭（如果不配置，默认是3秒）
					});
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
        content : './projectApartment/findApartmentUI.shtml?id=' + prId

    });

}


/**
 * 传图
 * @returns
 */
function addApartmentImg() {
    var cbox = $(".checkchild:checked");

    if (cbox.length != 1) {
        layer.msg('请选择唯一一条公寓数据！', {
            icon : 2,
            time : 2000
            // 2秒关闭（如果不配置，默认是3秒）
        });
        return;
    }
    var id = $(".checkchild:checked").val();

    pageii = layer.open({
        title : "公寓销控图片",
        type : 2,
        area : [ "700px", "80%" ],
        content : './project/addApartmentImgUI.shtml?id=' + id,

    });

}