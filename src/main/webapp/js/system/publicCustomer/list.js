var myTablea=null;	
var myTable=null;
$(function () {		
		//初始化部门公共池表格对象
	  myTable =$('#datatable').DataTable({
		        	
		  
      	autoWidth: true,
      	  searching: false,//禁用datatables搜索
	        	processing: true,//载入数据的时候是否显示“载入中”
	            serverSide: true,//开启服务器模式。分页，取数据等等的都放到服务端去
	            "aLengthMenu" : [10,20,30], //更改显示记录数选项
	        	paging: true,
	        	info: true,
	        	"bStateSave": false,
	        	 ordering: false,
		        	ajax: {
		                url: "./publicCustomer/findByCustomer.shtml?resources=2",// 数据请求地
			                type: "POST",
			                data: function (params) {  
	                            //此处为定义查询条件 传给控制器的参数  
	                            //角色名称  
			                    
	                            params.customerName = $("#ccustomerName").val();
	                            params.telephone = $("#ctelephone").val();
	                    
	                            params.department = $("#department").val();
	                            params.userName = $("#cuserName").val();
	                     
	                            params.stotalPrice = $("#cstotalPrice").val();
	                            params.etotalPrice = $("#cetotalPrice").val();
	                            params.purpose = $("#cpurpose").val();
	                           
	                            params.apartment = $("#capartment ").val();
	                   
	                        } 
			            },
		   columns: [
						 
						   	
	       	           	 	{ data: "customerName" 
								
							},
							
	       	       		  	{ data: "telephone" ,
								render : function(data, type, row, meta) {
									if (data == null) {
										return '';

									} else {
										/*var tel =data;  
										  
									    var mtel = tel.substr(0, 3) + '****' + tel.substr(7);  
									    $('#tel').text(mtel);  */
										return  data;
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
		       	             },
	       	         		
	       	         		{ data: "totalPrice" ,
									render : function(data, type, row, meta) {
										if (data == null) {
											return '';

										} else {
											return  data;
										}
									}
								},
	       	         		{ data: "purpose",
	       	         		 bSortable : false,  
	       	                 className : "text-center",  
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
	       	         		
	       	          { data: "apartment",
	       	         		 bSortable : false,  
	       	                 className : "text-center",  
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
	       	          { data: "cusource",
	       	         		 bSortable : false,  
	       	                
	       	                 className : "text-center",  
	       	                 render : function(data, type, row, meta) {  
	       	                     if (data == 1) {  
	       	                         return '<span >网络（安居客端口）</span>';  
	       	                     } else if (data == 2) {  
	       	                         return '<span >网络（58同城端口）</span>';  
	       	                     } else if (data == 3) {  
	       	                         return '<span >网络（房发现端口）</span>';  
	       	                     }else if (data == 4) {  
	       	                         return '<span >网络（安居客供客）</span>';  
	       	                     }else if (data == 5) {  
	       	                         return '<span >网络（58同城供客）</span>';  
	       	                     }else if (data == 6) {  
	       	                         return '<span >网络（房发现供客）</span>';  
	       	                     }else if (data == 7) {  
	       	                         return '<span >自身（打街霸）</span>';  
	       	                     }else if (data == 8) {  
	       	                         return '<span >自身（朋友推荐）</span>';  
	       	                     } else if (data == 9) {  
	       	                         return '<span >主动T客户</span>';  
	       	                     }else {  
	       	                         return '<span >未知</span>';  
	       	                     }  
	       	                 }  
	       	             }, 	
	       	     	 		{ data: "userName" ,
								render : function(data, type, row, meta) {
									if (data == null) {
										return '';

									} else {
										return  data;
									}
								}
							}, 	     	 	
	       	     	 		{ data: "departmentName" ,
								render : function(data, type, row, meta) {
									if (data == null) {
										return '';

									} else {
										return  data;
									}
								}
							},
	       	     	 		
	       	     	 		{ data: "trackDate", 
	       	                    "render":function(data,type,full,callback) {
	       	                      
	       	                    		var date=new Date(data);
	       	                    	 var y=date.getFullYear();  
	       	                      var m=date.getMonth()+1;  
	       	                      var d=date.getDate();  
	       	                      var h=date.getHours();  
	       	                      var m1=date.getMinutes();  
	       	                      var s=date.getSeconds();  
	       	                      m = m<10?("0"+m):m;  
	       	                      d = d<10?("0"+d):d;  
	       	                      return y+"-"+m+"-"+d+" "+h+":"+m1+":"+s;  
	       	                    }},
	       	     	 		
	       	     	 		
	       	     	 		{"data": null  },
	       	     	 	
		        	], 
		          	///操作按钮
		        	columnDefs: [
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
		        
		                    {  
		                        targets: -1,//操作按鈕位置，从0开始数为第几例  
		                        data: "id",  
		                        
		                        "render": function(data, type, full){  
		                            return  "<div class='btn-group'>"+
		    		        				"<button id='editRow' onclick='discardCustomer(this);' class='btn btn-success btn-s' type='button'><i class='fa fa-edit'></i>&nbsp;&nbsp;拾取</button>"+
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
	 	        	  

			 });
	//初始化部门公共池表格对象
	  myTablea =$('#datatablea').DataTable({
      	
		  
	      	autoWidth: true,
	      	  searching: false,//禁用datatables搜索
		        	processing: true,//载入数据的时候是否显示“载入中”
		            serverSide: true,//开启服务器模式。分页，取数据等等的都放到服务端去
		            "aLengthMenu" : [10,20,30], //更改显示记录数选项
		        	paging: true,
		        	info: true,
		        	 ordering: false,
			        	ajax: {
			        		 url: "./publicCustomer/findByAll.shtml?resources=3",// 数据请求地
				                type: "POST",
				                data: function (params) {  
		                            //此处为定义查询条件 传给控制器的参数  
		                            //角色名称  
				                    
		                            params.customerName = $("#acustomerName").val();
		                            params.telephone = $("#atelephone").val();
		                    
		                            params.department = $("#adepartment").val();
		                            params.userId = $("#auserId").val();
		                       
		                            params.screateDate = $("#ascreateDate").val();
		                            params.ecreateDate = $("#aecreateDate").val();
		                            params.stotalPrice = $("#astotalPrice").val();
		                            params.etotalPrice = $("#aetotalPrice").val();
		                            params.purpose = $("#apurpose").val();
		                           
		                            params.apartment = $("#aapartment").val();
		                            params.acusource = $("#acusource").val();
		                        } 
				            },
			   columns: [
							    {
							    	 data: "id",
					                 sClass: "text-center",
					                 render: function (data, type, full, meta) {
					                     return '<input type="checkbox"  name="checkchild" class="checkchild"  value="' + data + '" />';
					                 },
					                 bSortable: false
					             },
					          	
			       	           	 	{ data: "customerName",
										render : function(data, type, row, meta) {
											if (data == null) {
												return '';

											} else {
												return  data;
											}
										}
									},
			       	           	 
			       	       		  	{ data: "telephone" ,
										render : function(data, type, row, meta) {
											if (data == null) {
												return '';

											} else {
												/*var tel =data;  
												  
											    var mtel = tel.substr(0, 3) + '****' + tel.substr(7);  
											    $('#tel').text(mtel);  */
												return  data;
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
				       	             },
			       	         		
			       	         		{ data: "totalPrice" ,
											render : function(data, type, row, meta) {
												if (data == null) {
													return '';

												} else {
													return  data;
												}
											}
										},
			       	         		{ data: "purpose",
			       	         		 bSortable : false,  
			       	                 className : "text-center",  
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
			       	         		
			       	          { data: "apartment",
			       	         		 bSortable : false,  
			       	                 className : "text-center",  
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
			       	          { data: "cusource",
			       	         		 bSortable : false,  
			       	                
			       	                 className : "text-center",  
			       	                 render : function(data, type, row, meta) {  
			       	                     if (data == 1) {  
			       	                         return '<span >网络（安居客端口）</span>';  
			       	                     } else if (data == 2) {  
			       	                         return '<span >网络（58同城端口）</span>';  
			       	                     } else if (data == 3) {  
			       	                         return '<span >网络（房发现端口）</span>';  
			       	                     }else if (data == 4) {  
			       	                         return '<span >网络（安居客供客）</span>';  
			       	                     }else if (data == 5) {  
			       	                         return '<span >网络（58同城供客）</span>';  
			       	                     }else if (data == 6) {  
			       	                         return '<span >网络（房发现供客）</span>';  
			       	                     }else if (data == 7) {  
			       	                         return '<span >自身（打街霸）</span>';  
			       	                     }else if (data == 8) {  
			       	                         return '<span >自身（朋友推荐）</span>';  
			       	                     } else if (data == 9) {  
			       	                         return '<span >主动T客户</span>';  
			       	                     }else {  
			       	                         return '<span >未知</span>';  
			       	                     }  
			       	                 }  
			       	             }, 	
			       	     	 		/*{ data: "userName" ,
										render : function(data, type, row, meta) {
											if (data == null) {
												return '';

											} else {
												return  data;
											}
										}
									},  	     	 	
			       	     	 		{ data: "departmentName" ,
										render : function(data, type, row, meta) {
											if (data == null) {
												return '';

											} else {
												return  data;
											}
										}
									},
			       	     	 		
			       	     	 		{ data: "trackDate", 
			       	                    "render":function(data,type,full,callback) {
			       	                      
			       	                    		var date=new Date(data);
			       	                    	 var y=date.getFullYear();  
			       	                      var m=date.getMonth()+1;  
			       	                      var d=date.getDate();  
			       	                      var h=date.getHours();  
			       	                      var m1=date.getMinutes();  
			       	                      var s=date.getSeconds();  
			       	                      m = m<10?("0"+m):m;  
			       	                      d = d<10?("0"+d):d;  
			       	                      return y+"-"+m+"-"+d+" "+h+":"+m1+":"+s;  
			       	                    }},*/
			       	     	 		
			       	     	 		
			       	     	 		{"data": null },
			       	     	 	
				        	], 
			          	///操作按钮
			        	columnDefs: [
			        	
			        		
			                    {  
			                        targets: -1,//操作按鈕位置，从0开始数为第几例  
			                        data: "id",  
			                        
			                        "render": function(data, type, full){  
			                            return  "<div class='btn-group'>"+
			    		        				"<button id='editRow' onclick='discardAll(this);' class='btn btn-success btn-s' type='button'><i class='fa fa-edit'></i>&nbsp;&nbsp;拾取</button>"+
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

				 });

		/**
		 * 部门资源池查询客户
		 */
		$("#btn-customer").click("click", function() {
			
			  myTable.ajax.reload();
		});
	 	/**
	 	 * 展开搜索
	 	 */
		$("#morea").click(function(){
			if($("#morecontent").css("display")=="none"){

			$("#morecontent").show();
			//改变#change的class
			$("#change").removeClass("glyphicon-triangle-bottom");
			$("#change").addClass("glyphicon-triangle-top");
			
			}else{
			
			$("#morecontent").hide();
			$("#change").removeClass("glyphicon-triangle-top");
			$("#change").addClass("glyphicon-triangle-bottom");
			}
		})
		
		/**
		 * 公司资源池查询客户
		 */
		$("#btn-All").click("click", function() {
			
			  myTablea.ajax.reload();
		});

});
//分割线。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。表格内置操作按钮
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


/**
 * 部门资源池拾取
 * @param _this
 * @returns
 */
function  discardCustomer(_this){  	 
    var nRow = $(_this).parents('tr')[0];//得到这一行    
    
    var aData = $("#datatable").dataTable().fnGetData(nRow);//得到这一行的json数据   
  
    var cuId = aData.id;
   
	layer.confirm('是否拾取？', function(index) {
		
	    $.ajax({
        	"url":'./publicCustomer/pickupUI.shtml?id='+cuId,
        	
        	"type":"GET",
        	"datatype":"json",
        	"success":function(s) {
        		
        			layer.msg('拾取成功',{
        				  icon: 1,
        				  time: 1000 //2秒关闭（如果不配置，默认是3秒）
        				});
        			//myTable.ajax.reload();
        			myTable.draw(false);
        		} ,
        		 error:function (er) {layer.msg('拾取失败');
        		}
        	
        });
	    layer.close(index);
	/*	var url = './publicCustomer/pickupUI.shtml?id='+cuId+'&department='+department;
		var s = CommnUtil.ajax(url, {
			ids : cbox.join(",")
		}, "json");
		if (s == "success") {
			layer.msg('拾取成功');
			grid.loadData();
		} else {
			layer.msg('拾取失败');
		}*/
	});

}
/**
 * 公司资源池拾取客戶
 * @param _this
 * @returns
 */
function  discardAll(_this){  	 
    var nRow = $(_this).parents('tr')[0];//得到这一行    
    
    var aData = $("#datatablea").dataTable().fnGetData(nRow);//得到这一行的json数据   
  
    var cuId = aData.id;
  
    
	layer.confirm('是否拾取？', function(index) {
		
	    $.ajax({
        	"url":'./publicCustomer/pickupUI.shtml?id='+cuId,
        	
        	"type":"GET",
        	"datatype":"json",
        	"success":function(s) {
        		
        			layer.msg('拾取成功',{
        				  icon: 1,
        				  time: 1000 //2秒关闭（如果不配置，默认是3秒）
        				});
        			//myTable.ajax.reload();
        			myTablea.draw(false);
        		} ,
        		 error:function (er) {layer.msg('拾取失败');
        		}
        	
        });
	    layer.close(index);

	});

}

/**
 * 客户删除
 */

$("#delAccount").click("click", function() {
	
		var cbox=$(".checkchild:checked");
		var length=cbox.length;
		 var id = cbox.val();
	
		 if (length!=1) {
			 layer.msg('请选择一条且只有一条客户信息！',{
				  icon: 2,
				  time: 2000 //2秒关闭（如果不配置，默认是3秒）
				} );
			return;
		 } else{

				layer.confirm('是否删除？', function(index) {
					
				    $.ajax({
			        	"url":'./customer/deleteEntity.shtml?id='+id,
			        	
			        	"type":"GET",
			        	"datatype":"json",
			        	"success":function(s) {
			        		
			        			layer.msg('删除成功',{
			        				  icon: 1,
			        				  time: 1000 //2秒关闭（如果不配置，默认是3秒）
			        				});
			        			//myTable.ajax.reload();
			        			myTablea.draw(false);
			        		} ,
			        		 error:function (er) {layer.msg('删除失败');
			        		}
			        	
			        });
				    layer.close(index);
		});
		
		 }
});
/**
 * 批量拾取
 */

$("#getcus").click("click", function() {
	
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
		
		layer.confirm('是否拾取？', function(index) {
			
		    $.ajax({
	        	"url":'./publicCustomer/pickupUI.shtml?id='+idstr,
	        	
	        	"type":"GET",
	        	"datatype":"json",
	        	"success":function(s) {
	        		
	        			layer.msg('拾取成功',{
	        				  icon: 1,
	        				  time: 1000 //2秒关闭（如果不配置，默认是3秒）
	        				});
	        			//myTable.ajax.reload();
	        			myTablea.draw(false);
	        		} ,
	        		 error:function (er) {layer.msg('拾取失败');
	        		}
	        	
	        });
		    layer.close(index);

		});


	}
});
			
		