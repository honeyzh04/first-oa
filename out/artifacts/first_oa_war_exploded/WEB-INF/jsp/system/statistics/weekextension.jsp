<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/fixedcolumns/3.2.2/css/dataTables.fixedColumns.css" />--%>
<style type="text/css">
    #datatable {
        width: 100% !important;
    }

    /*数据表格标题文字居中*/
    .table th {
        text-align: center;
        vertical-align: middle !important;
    }
</style>

<body>

<div class="m-b-md">

    <div class="m-b-md">
        <form class="form-inline" role="form" id="searchForm"
              name="searchForm">
            <div class="form-group">
                <div class="form-group pad" style="margin: 0 15px">
                    <label>录入时间：</label> <input type="text"
                                                                        class=" form-control test-item" id="screateDate"
                                                                        name="customerFormMap.screateDate"
                                                                        placeholder="请输入开始时间">----
                    <input type="text" class="form-control test-item"
                           id="ecreateDate" name="customerFormMap.ecreateDate"
                           placeholder="请输入结束时间">


                </div>
                <button id="btn-test" type="button" class="btn btn-info">搜索 &nbsp;&nbsp;<span
                        class="glyphicon glyphicon-search" aria-hidden="true"></span></button>


            </div>
        </form>
    </div>
    <header class="panel-heading">
        <div class="doc-buttons">
            <c:forEach items="${res}" var="key">
                ${key.description}
            </c:forEach>

        </div>
    </header>


    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_content">

                    <!-- 数据table代码 -->
                    <table id="datatable" class="table table-striped table-bordered "
                           style=" text-align:center;vertical-align: middle!important">
                        <thead>
                        <tr>
                            <th rowspan="2">选择</th>
                            <th colspan="3">推广平台</th>
                            <th colspan="3"></th>
                            <th colspan="5">点击</th>
                            <th colspan="3">访问参数</th>
                            <th colspan="10">接访量</th>
                            <th colspan="4">客户(去重)</th>
                            <th colspan="7">新增</th>
                            <th colspan="6">带访</th>
                            <th colspan="6">成交</th>
                            <th colspan="2">佣金</th>
                        </tr>
                        <tr>


                            <th>平台</th>
                            <th>渠道</th>
                            <th>方式</th>
                            <th>消费</th>
                            <th>关键词量</th>
                            <th>展现量</th>
                            <th>总点击量</th>
                            <th>ip点击量</th>
                            <th>pv点击量</th>
                            <th>uv点击量</th>
                            <th>点击率</th>
                            <th>平均访问时长</th>
                            <th>跳出率</th>
                            <th>平均点击价格</th>
                            <th>接访电话</th>
                            <th>有效电话</th>
                            <th>微聊对话</th>
                            <th>有效微聊</th>
                            <th>商桥对话</th>
                            <th>有效商桥对话</th>
                            <th>短信（邮箱）</th>
                            <th>对话成本</th>
                            <th>有效对话成本</th>
                            <th>平均对话时长</th>
                            <th>新增客户</th>
                            <th>新增成本</th>
                            <th>带访客户</th>
                            <th>成交客户</th>
                            <th>客户部</th>
                            <th>东一</th>
                            <th>西一</th>
                            <th>南一</th>
                            <th>南二</th>
                            <th>南三</th>
                            <th>北一</th>
                            <th>东一</th>
                            <th>西一</th>
                            <th>南一</th>
                            <th>南二</th>
                            <th>南三</th>
                            <th>北一</th>
                            <th>东一</th>
                            <th>西一</th>
                            <th>南一</th>
                            <th>南二</th>
                            <th>南三</th>
                            <th>北一</th>
                            <th>成交佣金</th>
                            <th>退单</th>

                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
<div class="table-responsive">
    <div id="paging" class="pagclass"></div>
</div>

<script>
    var vv = layui.use('element', function () {
        element: layui.element;
    });

    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //同时绑定多个
        lay('.test-item').each(function () {
            laydate.render({
                elem: this,

                trigger: 'click'

                , max: 1 //今天以前

            });
        });
    });


</script>
<%--<script src="https://cdn.datatables.net/fixedcolumns/3.2.2/js/dataTables.fixedColumns.min.js"></script>--%>
<script type="text/javascript" src="js/system/statistics/weekextension.js"></script>
</body>
		
		
