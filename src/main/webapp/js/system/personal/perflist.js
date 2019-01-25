var myTablea=null;	
var myTable=null;
$(function () {

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
              url : "./personal/peDealPerformance.shtml",// 数据请求地
              type : "POST",
              data : function(params) {
                  // 此处为定义查询条件 传给控制器的参数
                  // 角色名称
                  params.customerName = $("#dcustomerName").val();
                  params.telephone = $("#dtelephone").val();
                  params.screateDate = $("#dscreateDate").val();
                  params.ecreateDate = $("#decreateDate").val();
              },
              error:function(){
                  layer.alert('服务器走丢了，刷新一下试试看');
              }
          },
          columns : [
              {
                  data : "id",
                  visible : false,
              },
              {
                  data : "customerName"
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
                          return '<span >其他</span>';
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
              {
                  data : "area",
                  render : function(data, type, row, meta) {
                      if (data == null) {
                          return '';

                      } else {
                          return  data;
                      }
                  }
              },
              {
                  data : "roomNumber",
                  render : function(data, type, row, meta) {
                      if (data == null) {
                          return '';

                      } else {
                          return  data;
                      }
                  }
              },
              {
                  data : "ratio",
                  render : function(data, type, row, meta) {
                      if (data == null) {
                          return '';

                      } else {
                          return  data;
                      }
                  }
              },{
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
              }, {
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
                          "<button id='editRow' onclick='dealInfo(this);' class='btn btn-warning btn-s' type='button'>详情</button>"+
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

function dealInfo(_this) {
    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatablea").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var deId = aData.id;

    pageii = layer.open({
        title : "成交详情",
        resize : false,
        type : 2,
        area : [ "1000px", "80%" ],
        content : './customer/dealAllotUI.shtml?id=' + deId,

    });

}