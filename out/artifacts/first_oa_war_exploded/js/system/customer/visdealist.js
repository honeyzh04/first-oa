var myTablea=null;	
var myTable=null;
$(function () {		
		//初始化部门公共池表格对象
	  myTable =$('#datatable').DataTable({


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
              url : "./customer/findByVisitCustomer.shtml",// 数据请求地
              type : "POST",
              data : function(params) {
                  // 此处为定义查询条件 传给控制器的参数
                  // 角色名称
                  params.customerName = $("#vcustomerName").val();
                  params.telephone = $("#vtelephone").val();
                  params.screateDate = $("#vscreateDate").val();
                  params.ecreateDate = $("#vecreateDate").val();
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
                          return '未知';

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
                  data : "resources",
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
                  data : "projectId",
                  render : function(data, type, row, meta) {
                      if (data == null) {
                          return '';

                      } else {
                          return  data;
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
              },
              {
                  data : "visitDate",
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



      });
	//初始化部门公共池表格对象
	  myTablea =$('#datatablea').DataTable({


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
              url : "./customer/findByDealCustomer.shtml",// 数据请求地
              type : "POST",
              data : function(params) {
                  // 此处为定义查询条件 传给控制器的参数
                  // 角色名称
                  params.customerName = $("#dcustomerName").val();
                  params.telephone = $("#dtelephone").val();
                  params.screateDate = $("#dscreateDate").val();
                  params.ecreateDate = $("#decreateDate").val();
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
                          return '未知';

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
                  data : "projectId",
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
              },   {
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
                  data : "dealDate",
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
                      return  "<div class='btn-group' onclick='funAccount1(this);'>"+ data + "</div>"

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
		$("#btn-testv").click("click", function() {
			
			  myTable.ajax.reload();
		});

		/**
		 * 公司资源池查询客户
		 */
		$("#btn-testd").click("click", function() {
			
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
var tmp1 = "";
function funAccount1(_this) {

    var nRow = $(_this).parents('tr')[0];// 得到这一行

    var aData = $("#datatablea").dataTable().fnGetData(nRow);// 得到这一行的json数据

    var cuId = aData.content;

    if (tmp1 == "") {
        tmp1 = layer.tips(cuId, _this, {
            tips : [ 2, '#3595CC' ],
            area: ['400px', 'auto'],
            time : 10000

        });

    } else {
        tmp1 = layer.close(tmp1);
        tmp1 = "";
    }
}