<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                <div class="form-group pad">
                    <label >选择月份：</label>
                    <input type="text" class="form-control test-item"
                           id="monthDate" name="customerFormMap.ecreateDate"
                         >


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


                            <th>选择</th>
                            <th>时间</th>
                            <th>百度搜索推广价格</th>
                            <th>百度搜索推广点击</th>
                            <th>百度信息流价格</th>
                            <th>百度信息流点击</th>
                            <th>搜狗价格</th>
                            <th>搜狗点击</th>
                            <th>神马价格</th>
                            <th>神马点击</th>
                            <th>新增客户</th>
                            <th>新增成本</th>
                            <th>客户来源</th>
                            <th>新增转化率</th>
                            <th>带访客户</th>
                            <th>成交客户</th>
                            <th>成交转化率</th>
                            <th>成交佣金</th>
                            <th>成交项目</th>
                            <th>成交价格</th>


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
    var vv = layui.use('element', function() {
        element: layui.element;
    });

    layui.use('laydate', function () {
        var laydate = layui.laydate;


        laydate.render({
            elem : '#monthDate',
            trigger : 'click',
            type : 'month',
            theme : '#FF0000',
            max : 0,
            value : new Date(),
            isInitValue : true

        });
    });


</script>
<script type="text/javascript" src="js/system/statistics/extension.js"></script>
</body>
		
		
