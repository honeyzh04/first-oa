		
$(function () {		
			//初始化表格对象
	
	 var myTable =$('#datatable').DataTable({
		        	
		            searching: false,//禁用datatables搜索
		        	processing: true,//载入数据的时候是否显示“载入中”
		            serverSide: true,//开启服务器模式。分页，取数据等等的都放到服务端去
		            pageLength: 10,  //首次加载的数据条数
		        	paging: true,
		        	info: true,
		        	scrollX: true, //列太多，超过显示长度需要滚动条时使用
		        	ajax: {
		                url: "./resources/treelists.shtml",// 数据请求地址
		                type: "POST"
		              
		                
		                	/* data: function (params) {
		                	//此处为定义查询条件 传给控制器的参数
		                	//角色名称
		                    params.roleName = $("#theRoleName").val()
		                } */
		            },
		   columns: [
						    {
						    	 data: "id",
				                 sClass: "text-center",
				                 render: function (data, type, full, meta) {
				                     return '<input type="checkbox"  class="checkchild"  value="' + data + '" />';
				                 },
				                 bSortable: false
				             },
						   	{ data: "id" },
	       	           	 	{ data: "resName" },
	       	       		  	{ data: "type" },
	       	         		{ data: "ishide" },
	       	         		{ data: null },
	       	         		
		        	], 
		        /* 	///操作按钮
		        	columnDefs: [{
		        		targets: 5,// <span style="font-family:Arial, Helvetica, sans-serif;">操作例</span>的位置，从0开始数为第几例，
		                data: "id",
		                width: 140,
		                "render": function(data, type, full){
		                    return  "<button class='btn btn-danger btn-xs' onclick='deleteRoleRes("+data+")'><i class='fa fa-remove'></i> 删除</button>"
			            }
	 	            }], */
	 	   oLanguage: {
	 	        	 "sProcessing": "<img src='/images/datatable_loading.gif'>  努力加载数据中.",
	 	        	  "sLengthMenu": "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每页显示 _MENU_ 条记录",
	 	        	  "sZeroRecords": "抱歉， 没有找到",
	 	        	  "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条员工信息",
	 	        	  "sInfoEmpty": "没有数据",
	 	        	  "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
	 	        	  "oPaginate": {
	 	        	  "sFirst": "首页",
	 	        	  "sPrevious": "前一页",
	 	        	  "sNext": "后一页",
	 	        	  "sLast": "尾页"
	 	        	  },
	 	        	  "sZeroRecords": "没有检索到数据",
	 	        	  "sProcessing": "<img src='./loading.gif' />"
	 	        	  } ,

			 });
	 $("#search").click("click", function() {// 绑定查询按扭
			var searchParams = $("#searchForm").serializeJson();// 初始化传参数
			grid.setOptions({//设置参数，具体参数与表格参数一致
				data : searchParams//查询条件数据，必须是json格式
			});
		});
		$("#addAccount").click("click", function() {
			addAccount();
		});
		$("#editAccount").click("click", function() {
			editAccount();
		});
		$("#delAccount").click("click", function() {
			delAccount();
		});
		$("#permissions").click("click", function() {
			permissions();
		});
	 
	    //checkbox全选
        $("#checkAll").on("click", function () {
            if ($(this).prop("checked") === true) {
                $("input[name='checkList']").prop("checked", $(this).prop("checked"));
                //$("#dataTable tbody tr").addClass('selected');
                $(this).hasClass('selected')
            } else {
                $("input[name='checkList']").prop("checked", false);
                $("#dataTable tbody tr").removeClass('selected');
            }
        });
	});
	function editAccount() {
		var cbox =myTable.getSelectedCheckbox();
		if (cbox.length > 1 || cbox == "") {
			layer.msg("只能选中一个");
			return;
		}
		pageii = layer.open({
			title : "编辑",
			type : 2,
			area : [ "600px", "80%" ],
			content :'./user/editUI.shtml?id=' + cbox
		});
	}
	function addAccount() {
		pageii = layer.open({
			title : "新增",
			type : 2,
			area : [ "600px", "80%" ],
			content :'./user/addUI.shtml'
		});
	}
	function delAccount() {
		var cbox = grid.getSelectedCheckbox();
		if (cbox == "") {
			layer.msg("请选择删除项！！");
			return;
		}
		layer.confirm('是否删除？', function(index) {
			var url = rootPath + '/user/deleteEntity.shtml';
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
	}
	function permissions() {
		var cbox = grid.getSelectedCheckbox();
		if (cbox.length > 1 || cbox == "") {
			layer.msg("请选择一个对象！");
			return;
		}
		var url = rootPath + '/resources/permissions.shtml?userId='+cbox;
		pageii = layer.open({
			title : "分配权限",
			type : 2,
			area : [ "700px", "80%" ],
			content : url
		});
	}
	
			
		
