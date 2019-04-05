var myTablea=null;
var myTableb=null;
var myTablec=null;
var myTabled=null;
var  pagea=null;
var  pageb=null;
var  pagec=null;
var  paged=null;
$(function() {
	// 初始化表格对象

	myTablea = $('#datatableShops').DataTable({

						autoWidth : true, //宽度自适应
						searching : false,//禁用datatables搜索
						processing : true,//载入数据的时候是否显示“载入中”
						serverSide : true,//开启服务器模式。分页，取数据等等的都放到服务端去
						"aLengthMenu" : [ 15, 30], //更改显示记录数选项
						paging : true,//翻页
						info : true, //页脚
						ordering : false,//排序
						ajax : {
							url : "./projectShops/findByProjectShops.shtml",// 数据请求地址
							type : "POST",

							data : function(params) {
								// 此处为定义查询条件 传给控制器的参数
								// 角色名称
								params.projectName = $("#projectShopsName").val();
								params.region = $("input[name='ProjectShopsFormMap.region']:checked").val();
								params.prices = $("input[name='ProjectShopsFormMap.prices']:checked").val();
								params.area = $("input[name='ProjectShopsFormMap.area']:checked").val();
						
							}
						},
						columns : [
								{
									data : "id",
									sClass : "text-center",
									render : function(data, type, full, meta) {
										return '<input type="checkbox"  class="checkchilda"  name="checkchilda"  value="'
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
                                data : "state",
                                bSortable : false,

                                className : "text-center",
                                render : function(data, type, row, meta) {
                                    if (data == 0) {
                                        return '<span style="color: #c43023;font-weight:bold" >热销</span>';
                                    } else if (data == 1) {
                                        return '<span style="color: #3e8f3e;font-weight:bold" >待售</span>';
                                    } else if (data == 2) {
                                        return '<span style="color: #3e8f3e;font-weight:bold" >在售</span>';
                                    } else if (data == 3) {
                                        return '<span style="color: #68b5ff;font-weight:bold" >认购</span>';
                                    }  else {
                                        return '<span  style="color: red;font-weight:bold">停售</span>';
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
                                            "<button id='editRow' onclick='projectShopsDetails(this);' class='btn btn-warning btn-s' type='button'>详情</button>"+
                                            "<button id='editRow' onclick='matchShopsCustomer(this);' class='btn btn-danger btn-d' type='button'>匹配客户</button>"+
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
    myTableb = $('#datatableApartment').DataTable({

        autoWidth : true, //宽度自适应
        searching : false,//禁用datatables搜索
        processing : true,//载入数据的时候是否显示“载入中”
        serverSide : true,//开启服务器模式。分页，取数据等等的都放到服务端去
        "aLengthMenu" : [ 15, 30], //更改显示记录数选项
        paging : true,//翻页
        info : true, //页脚
        ordering : false,//排序
        ajax : {
            url : "./projectApartment/findByProjectApartment.shtml",// 数据请求地址
            type : "POST",

            data : function(params) {
                // 此处为定义查询条件 传给控制器的参数
                // 角色名称
                params.projectName = $("#projectApartmentName").val();
                params.region = $("input[name='ProjectApartmentFormMap.region']:checked").val();
                params.prices = $("input[name='ProjectApartmentFormMap.prices']:checked").val();
                params.area = $("input[name='ProjectApartmentFormMap.area']:checked").val();

            }
        },
        columns : [
            {
                data : "id",
                sClass : "text-center",
                render : function(data, type, full, meta) {
                    return '<input type="checkbox"  class="checkchildb"  name="checkchildb"  value="'
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
                data : "state",
                bSortable : false,

                className : "text-center",
                render : function(data, type, row, meta) {
                    if (data == 0) {
                        return '<span style="color: #c43023;font-weight:bold" >热销</span>';
                    } else if (data == 1) {
                        return '<span style="color: #3e8f3e;font-weight:bold" >待售</span>';
                    } else if (data == 2) {
                        return '<span style="color: #3e8f3e;font-weight:bold" >在售</span>';
                    } else if (data == 3) {
                        return '<span style="color: #68b5ff;font-weight:bold" >认购</span>';
                    }  else {
                        return '<span  style="color: red;font-weight:bold">停售</span>';
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
                        "<button id='editRow' onclick='projectApartmentDetails(this);' class='btn btn-warning btn-s' type='button'>详情</button>"+
                        "<button id='editRow' onclick='matchApartmentCustomer(this);' class='btn btn-danger btn-d' type='button'>匹配客户</button>"+
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
    myTablec = $('#datatableOffice').DataTable({

        autoWidth : true, //宽度自适应
        searching : false,//禁用datatables搜索
        processing : true,//载入数据的时候是否显示“载入中”
        serverSide : true,//开启服务器模式。分页，取数据等等的都放到服务端去
        "aLengthMenu" : [ 15, 30], //更改显示记录数选项
        paging : true,//翻页
        info : true, //页脚
        ordering : false,//排序
        ajax : {
            url : "./projectOffice/findByProjectOffice.shtml",// 数据请求地址
            type : "POST",

            data : function(params) {
                // 此处为定义查询条件 传给控制器的参数
                // 角色名称
                params.projectName = $("#projectOfficeName").val();
                params.region = $("input[name='ProjectOfficeFormMap.region']:checked").val();
                params.prices = $("input[name='ProjectOfficeFormMap.prices']:checked").val();
                params.area = $("input[name='ProjectOfficeFormMap.area']:checked").val();

            }
        },
        columns : [
            {
                data : "id",
                sClass : "text-center",
                render : function(data, type, full, meta) {
                    return '<input type="checkbox"  class="checkchildc"  name="checkchildc"  value="'
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
                data : "state",
                bSortable : false,

                className : "text-center",
                render : function(data, type, row, meta) {
                    if (data == 0) {
                        return '<span style="color: #c43023;font-weight:bold" >热销</span>';
                    } else if (data == 1) {
                        return '<span style="color: #3e8f3e;font-weight:bold" >待售</span>';
                    } else if (data == 2) {
                        return '<span style="color: #3e8f3e;font-weight:bold" >在售</span>';
                    } else if (data == 3) {
                        return '<span style="color: #68b5ff;font-weight:bold" >认购</span>';
                    }  else {
                        return '<span  style="color: red;font-weight:bold">停售</span>';
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
                        "<button id='editRow' onclick='projectOfficeDetails(this);' class='btn btn-warning btn-s' type='button'>详情</button>"+
                        "<button id='editRow' onclick='matchOfficeCustomer(this);' class='btn btn-danger btn-d' type='button'>匹配客户</button>"+
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
    myTabled = $('#datatableHome').DataTable({

        autoWidth : true, //宽度自适应
        searching : false,//禁用datatables搜索
        processing : true,//载入数据的时候是否显示“载入中”
        serverSide : true,//开启服务器模式。分页，取数据等等的都放到服务端去
        "aLengthMenu" : [ 15, 30], //更改显示记录数选项
        paging : true,//翻页
        info : true, //页脚
        ordering : false,//排序
        ajax : {
            url : "./projectHome/findByProjectHome.shtml",// 数据请求地址
            type : "POST",

            data : function(params) {
                // 此处为定义查询条件 传给控制器的参数
                // 角色名称
                params.projectName = $("#projectHomeName").val();
                params.region = $("input[name='ProjectHomeFormMap.region']:checked").val();
                params.prices = $("input[name='ProjectHomeFormMap.prices']:checked").val();
                params.area = $("input[name='ProjectHomeFormMap.area']:checked").val();

            }
        },
        columns : [
            {
                data : "id",
                sClass : "text-center",
                render : function(data, type, full, meta) {
                    return '<input type="checkbox"  class="checkchildd"  name="checkchildd"  value="'
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
                    if (data == 4) {
                        return '<span >住宅</span>';
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
                data : "state",
                bSortable : false,

                className : "text-center",
                render : function(data, type, row, meta) {
                    if (data == 0) {
                        return '<span style="color: #c43023;font-weight:bold" >热销</span>';
                    } else if (data == 1) {
                        return '<span style="color: #3e8f3e;font-weight:bold" >待售</span>';
                    } else if (data == 2) {
                        return '<span style="color: #3e8f3e;font-weight:bold" >在售</span>';
                    } else if (data == 3) {
                        return '<span style="color: #68b5ff;font-weight:bold" >认购</span>';
                    }  else {
                        return '<span  style="color: red;font-weight:bold">停售</span>';
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
                        "<button id='editRow' onclick='projectHomeDetails(this);' class='btn btn-warning btn-s' type='button'>详情</button>"+
                        "<button id='editRow' onclick='matchHomeCustomer(this);' class='btn btn-danger btn-d' type='button'>匹配客户</button>"+
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

    $("#searchShops").click("click", function() {// 绑定查询按扭
		myTablea.ajax.reload();
	});
    $("#searchApartment").click("click", function() {// 绑定查询按扭
        myTableb.ajax.reload();
    });
    $("#searchOffice").click("click", function() {// 绑定查询按扭
        myTablec.ajax.reload();
    });
    $("#searchHome").click("click", function() {// 绑定查询按扭
        myTabled.ajax.reload();
    });
	//添加按钮
	$("#addProjectShops").click("click", function() {
		addProjectShops();
	});
    $("#addProjectApartment").click("click", function() {
        addProjectApartment();
    });
    $("#addProjectOffice").click("click", function() {
        addProjectOffice();
    });
    $("#addProjectHome").click("click", function() {
        addProjectHome();
    });
	//修改按钮
	$("#editProjectShops").click("click", function() {
		editProjectShops();

	});
    $("#editProjectApartment").click("click", function() {
        editProjectApartment();

    });
    $("#editProjectOffice").click("click", function() {
        editProjectOffice();

    });
    $("#editProjectHome").click("click", function() {
        editProjectHome();

    });
	//删除按钮
	$("#delProjectShops").click("click", function() {
		delProjectShops();

	});
    $("#delProjectApartment").click("click", function() {
        delProjectApartment();

    });
    $("#delProjectOffice").click("click", function() {
        delProjectOffice();

    });
    $("#delProjectHome").click("click", function() {
        delProjectHome();

    });
    //图片上传
    $("#addProjectShopsImg").click("click", function() {
        addProjectShopsImg();

    });
    $("#addProjectApartmentImg").click("click", function() {
        addProjectApartmentImg();

    });
    $("#addProjectOfficeImg").click("click", function() {
        addProjectOfficeImg();

    });
    $("#addProjectHomeImg").click("click", function() {
        addProjectHomeImg();

    });



});



/**
 * 添加
 * @returns
 */
function addProjectShops() {
	pagea = layer.open({
		title : "添加商铺项目",
		type : 2,
		area : [ "1000px", "80%" ],
		content : './projectShops/addProjectShopsUI.shtml'
	});
}
function addProjectApartment() {
    pageb = layer.open({
        title : "添加公寓项目",
        type : 2,
        area : [ "1000px", "80%" ],
        content : './projectApartment/addProjectApartmentUI.shtml'
    });
}
function addProjectOffice() {
    pagec = layer.open({
        title : "添加写字楼项目",
        type : 2,
        area : [ "1000px", "80%" ],
        content : './projectOffice/addProjectOfficeUI.shtml'
    });
}
function addProjectHome() {
    paged = layer.open({
        title : "添加住宅项目",
        type : 2,
        area : [ "1000px", "80%" ],
        content : './projectHome/addProjectHomeUI.shtml'
    });
}
/**
 * 编辑
 * @returns
 */
function editProjectShops() {
	var cbox = $(".checkchilda:checked");

	if (cbox.length != 1) {
		layer.msg('请选择唯一一条商铺项目数据！', {
			icon : 2,
			time : 2000
		// 2秒关闭（如果不配置，默认是3秒）
		});
		return;
	}
	var id = $(".checkchilda:checked").val();

	pagea = layer.open({
		title : "编辑商铺项目",
		type : 2,
        area : [ "1000px", "80%" ],
		content : './projectShops/editProjectShopsUI.shtml?id=' + id,

	});

}
function  editProjectApartment() {
    var cbox = $(".checkchildb:checked");

    if (cbox.length != 1) {
        layer.msg('请选择唯一一条公寓项目数据！', {
            icon : 2,
            time : 2000
            // 2秒关闭（如果不配置，默认是3秒）
        });
        return;
    }
    var id = $(".checkchildb:checked").val();

    pageb = layer.open({
        title : "编辑公寓项目",
        type : 2,
        area : [ "1000px", "80%" ],
        content : './projectApartment/editProjectApartmentUI.shtml?id=' + id,

    });

}
function editProjectOffice() {
    var cbox = $(".checkchildc:checked");

    if (cbox.length != 1) {
        layer.msg('请选择唯一一条写字楼项目数据！', {
            icon : 2,
            time : 2000
            // 2秒关闭（如果不配置，默认是3秒）
        });
        return;
    }
    var id = $(".checkchildc:checked").val();

    pagec= layer.open({
        title : "编辑写字楼项目",
        type : 2,
        area : [ "1000px", "80%" ],
        content : './projectOffice/editProjectOfficeUI.shtml?id=' + id,

    });

}
function editProjectHome() {
    var cbox = $(".checkchildd:checked");

    if (cbox.length != 1) {
        layer.msg('请选择唯一一条住宅项目数据！', {
            icon : 2,
            time : 2000
        });
        return;
    }
    var id = $(".checkchildd:checked").val();

    paged = layer.open({
        title : "编辑住宅项目",
        type : 2,
        area : [ "1000px", "80%" ],
        content : './projectHome/editProjectHomeUI.shtml?id=' + id,

    });

}
/**
 * 删除
 * @returns
 */
function delProjectShops() {
	var id_array = new Array();
	$('input[name="checkchilda"]:checked').each(function() {

		id_array.push($(this).val());//向数组中添加元素  

	});
	if (id_array.length < 1) {
		layer.msg('您没有选择商铺项目！', {
			icon : 2,
			time : 2000
		//2秒关闭（如果不配置，默认是3秒）
		});
		return;
	} else {

		var idstr = id_array.join(',');

		layer.confirm('是否删除？', function(index) {

			$.ajax({
				"url" : './projectShops/deleteProjectShops.shtml?ids=' + idstr,

				"type" : "GET",
				"datatype" : "json",
				"success" : function(s) {
					layer.msg('删除成功', {
						icon : 1,
						time : 1000
					//2秒关闭（如果不配置，默认是3秒）
					});
					//myTablea.ajax.reload();
					myTablea.draw(false);
				},
				error : function(er) {
					layer.msg('删除失败');
				}

			});
			layer.close(index);
		});

	}

}
function delProjectApartment() {
    var id_array = new Array();
    $('input[name="checkchildb"]:checked').each(function() {

        id_array.push($(this).val());//向数组中添加元素

    });
    if (id_array.length < 1) {
        layer.msg('您没有选择公寓项目！', {
            icon : 2,
            time : 2000
        });
        return;
    } else {

        var idstr = id_array.join(',');

        layer.confirm('是否删除？', function(index) {

            $.ajax({
                "url" : './projectApartment/deleteProjectApartment.shtml?ids=' + idstr,

                "type" : "GET",
                "datatype" : "json",
                "success" : function(s) {
                    layer.msg('删除成功', {
                        icon : 1,
                        time : 1000
                        //2秒关闭（如果不配置，默认是3秒）
                    });
                    //myTablea.ajax.reload();
                    myTableb.draw(false);
                },
                error : function(er) {
                    layer.msg('删除失败');
                }

            });
            layer.close(index);
        });

    }

}
function delProjectOffice() {
    var id_array = new Array();
    $('input[name="checkchildc"]:checked').each(function() {

        id_array.push($(this).val());//向数组中添加元素

    });
    if (id_array.length < 1) {
        layer.msg('您没有选择写字楼项目！', {
            icon : 2,
            time : 2000
        });
        return;
    } else {

        var idstr = id_array.join(',');

        layer.confirm('是否删除？', function(index) {

            $.ajax({
                "url" : './projectOffice/deleteProjectOffice.shtml?ids=' + idstr,

                "type" : "GET",
                "datatype" : "json",
                "success" : function(s) {
                    layer.msg('删除成功', {
                        icon : 1,
                        time : 1000
                        //2秒关闭（如果不配置，默认是3秒）
                    });
                    //myTablea.ajax.reload();
                    myTablec.draw(false);
                },
                error : function(er) {
                    layer.msg('删除失败');
                }

            });
            layer.close(index);
        });

    }

}
function delProjectHome() {
    var id_array = new Array();
    $('input[name="checkchildd"]:checked').each(function() {

        id_array.push($(this).val());//向数组中添加元素

    });
    if (id_array.length < 1) {
        layer.msg('您没有选择住宅项目！', {
            icon : 2,
            time : 2000
            //2秒关闭（如果不配置，默认是3秒）
        });
        return;
    } else {

        var idstr = id_array.join(',');

        layer.confirm('是否删除？', function(index) {

            $.ajax({
                "url" : './projectHome/deleteProjectHome.shtml?ids=' + idstr,

                "type" : "GET",
                "datatype" : "json",
                "success" : function(s) {
                    layer.msg('删除成功', {
                        icon : 1,
                        time : 1000
                        //2秒关闭（如果不配置，默认是3秒）
                    });
                    //myTablea.ajax.reload();
                    myTabled.draw(false);
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
 * 传图
 * @returns
 */
function addProjectShopsImg() {
    var cbox = $(".checkchilda:checked");

    if (cbox.length != 1) {
        layer.msg('请选择唯一一条商铺项目数据！', {
            icon : 2,
            time : 2000
            // 2秒关闭（如果不配置，默认是3秒）
        });
        return;
    }
    var id = $(".checkchilda:checked").val();

    pageii = layer.open({
        title : "商铺项目图片",
        type : 2,
        area : [ "700px", "80%" ],
        content : './projectShops/addImgUI.shtml?id=' + id,

    });

}
function addProjectApartmentImg() {
    var cbox = $(".checkchildb:checked");

    if (cbox.length != 1) {
        layer.msg('请选择唯一一条公寓项目数据！', {
            icon : 2,
            time : 2000
            // 2秒关闭（如果不配置，默认是3秒）
        });
        return;
    }
    var id = $(".checkchildb:checked").val();

    pageii = layer.open({
        title : "公寓项目图片",
        type : 2,
        area : [ "700px", "80%" ],
        content : './projectApartment/addImgUI.shtml?id=' + id,

    });

}
function addProjectOfficeImg() {
    var cbox = $(".checkchildc:checked");

    if (cbox.length != 1) {
        layer.msg('请选择唯一一条写字楼项目数据！', {
            icon : 2,
            time : 2000
            // 2秒关闭（如果不配置，默认是3秒）
        });
        return;
    }
    var id = $(".checkchildc:checked").val();

    pageii = layer.open({
        title : "写字楼项目图片",
        type : 2,
        area : [ "700px", "80%" ],
        content : './projectOffice/addImgUI.shtml?id=' + id,

    });

}
function addProjectHomeImg() {
    var cbox = $(".checkchildd:checked");

    if (cbox.length != 1) {
        layer.msg('请选择唯一一条住宅项目数据！', {
            icon : 2,
            time : 2000
            // 2秒关闭（如果不配置，默认是3秒）
        });
        return;
    }
    var id = $(".checkchildd:checked").val();

    pageii = layer.open({
        title : "住宅项目图片",
        type : 2,
        area : [ "700px", "80%" ],
        content : './projectHome/addImgUI.shtml?id=' + id,

    });

}
/**
 *
 * 项目详情
 * @param _this
 */
function projectShopsDetails(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var prId = aData.id;
    pageii = layer.open({
        title : "楼盘详情",
        resize : false,
        type : 2,
        area : [ "1000px", "80%" ],
        content : './projectShops/projectDetails.shtml?id=' + prId
    });
}
function projectApartmentDetails(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var prId = aData.id;
    pageii = layer.open({
        title : "楼盘详情",
        resize : false,
        type : 2,
        area : [ "1000px", "80%" ],
        content : './projectApartment/projectDetails.shtml?id=' + prId
    });
}function projectOfficeDetails(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var prId = aData.id;
    pageii = layer.open({
        title : "楼盘详情",
        resize : false,
        type : 2,
        area : [ "1000px", "80%" ],
        content : './projectOffice/projectDetails.shtml?id=' + prId
    });
}function projectHomeDetails(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var prId = aData.id;
    pageii = layer.open({
        title : "楼盘详情",
        resize : false,
        type : 2,
        area : [ "1000px", "80%" ],
        content : './projectHome/projectDetails.shtml?id=' + prId
    });
}
/**
 *
 * 匹配客户
 * @param _this
 */
function matchShopsCustomer(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var Id = aData.id;
    pageii = layer.open({
        title : "匹配客户",
        resize : false,
        type : 2,
        area : ["60%","70%"],
        content : './match/matchingCustomer.shtml?id=' + Id+"&type=1"
    });

}

function matchApartmentCustomer(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var Id = aData.id;
    pageii = layer.open({
        title : "匹配客户",
        resize : false,
        type : 2,
        area : ["60%","70%"],
        content : './match/matchingCustomer.shtml?id=' + Id+"&type=2"
    });

}
function matchOfficeCustomer(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var Id = aData.id;
    pageii = layer.open({
        title : "匹配客户",
        resize : false,
        type : 2,
        area : ["60%","70%"],
        content : './match/matchingCustomer.shtml?id=' + Id+"&type=3"
    });

}
function matchHomeCustomer(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var Id = aData.id;
    pageii = layer.open({
        title : "匹配客户",
        resize : false,
        type : 2,
        area : ["60%","70%"],
        content : './match/matchingCustomer.shtml?id=' + Id+"&type=4"
    });

}
