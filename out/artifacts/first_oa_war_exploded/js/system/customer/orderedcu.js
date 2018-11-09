var myTable=null;
$(function () {
    //初始化部门公共池表格对象
    myTable = $('#datatable').DataTable({


        autoWidth: true,
        searching: false,//禁用datatables搜索
        processing: true,//载入数据的时候是否显示“载入中”
        serverSide: true,//开启服务器模式。分页，取数据等等的都放到服务端去
        "aLengthMenu": [10, 20, 30], //更改显示记录数选项
        paging: true,
        info: true,
        "bStateSave": false,
        ordering: false,
        ajax: {
            url: "../customer/findOrCustomer.shtml",// 数据请求地
            type: "POST",
            data: function (params) {
                //此处为定义查询条件 传给控制器的参数
            }
        },
        columns: [


         /*{ data: "id",
              "sDefaultContent" : "", //此列默认值为""，以防数据中没有此值，DataTables加载数据的时候报错
             "bVisible" : false //此列不显示

            },*/
            { data: "customerName"

            },
           /* {
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
            },*/
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
                        "<button id='editRow' onclick='editAccount(this);' class='btn btn-success btn-s' type='button'>跟进</button>"+
                        "</div>"
                }
            },


        ],
        oLanguage: {
            "sProcessing": "<img src='../img/loading.gif' /> 努力加载数据中.",
            "sLengthMenu": "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;每页显示 _MENU_ 条客户记录",
            "sZeroRecords": "抱歉， 没有找到",
            "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条客户信息",
            "sInfoEmpty": "没有数据",
            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "前一页",
                "sNext": "后一页",
                "sLast": "尾页"
            },
            "sZeroRecords": "没有与此项目匹配的客户",
            "sProcessing": "<img src='../img/loading.gif' />"
        },


    });

});
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

/*
 * 客户跟进
 */
function editAccount(_this) {

    var nRow = $(_this).parents('tr')[0];// 得到这一行
    var aData = $("#datatable").dataTable().fnGetData(nRow);// 得到这一行的json数据
    var cuId = aData.id;

    pageii = layer.open({
        title : "客户跟进",
        resize : false,
        type : 2,
        area : [ "1020px", "80%" ],
        content : '../customer/editUI.shtml?id=' + cuId,

    });

}