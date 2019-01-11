<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="js/system/personal/perflist.js"></script>
<script type="text/javascript" src="js/system/personal/peecharts.js"></script>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title></title>
    <style type="text/css">
        #datatable {
            width: 100% !important;
        }

        #datatable {
            width: 100% !important;
        }

        #datatablea {
            width: 100% !important;
        }

        /*数据表格标题文字居中*/
        .table th {
            text-align: center;
            vertical-align: middle !important;
        }

        .ui-timepicker-div {
            margin-bottom: 8px;
        }

        .ui-timepicker-div dl {
            text-align: left;
        }

        .ui-timepicker-div dl dt {
            float: left;
            clear: left;
            padding: 0 0 0 5px;
        }

        .ui-timepicker-div dl dd {
            margin: 0 10px 10px 45%;
        }

        .ui-timepicker-div td {
            font-size: 90%;
        }

        .ui-timepicker-rtl dl {
            text-align: right;
            padding: 0 5px 0 0;
        }

        .ui-timepicker-rtl dl dt {
            float: right;
            clear: right;
        }

        .ui-timepicker-rtl dl dd {
            margin: 0 45% 10px 10px;
        }

        .pad {
            padding: 0 10px;
        }

        button {
            width: 80px;
            height: 34px;
            /*background: #5CC691;*/
            outline: none;
            border: none;
            color: #fff;
            font-size: 14px;
            margin-right: 10px;
        }

        .form-control {
            height: 31px;
        }

        .layui-form input[type=checkbox], .layui-form input[type=radio],
        .layui-form select {
            display: block;
        }


    </style>

</head>

<body>

<div>

    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
        <ul class="layui-tab-title">
            <li class="layui-this">本月数据</li>
            <li>成交业绩</li>

        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <div id="TwoLineChart" style="width:100%; height:500px;"></div>
            </div>


            <div class="layui-tab-item">
                <!--body wrapper start-->


                <div class="m-b-md">
                    <form class="form-inline" role="form"   name="searchForm">
                        <div class="form-group">


                            <div class="form-group pad">
                                <label>客户姓名：</label> <input type="text"
                                                            class="form-control"
                                                            id="dcustomerName"
                                                            name="customerFormMap.customerName"
                                                            placeholder="请输入客户名">
                            </div>

                            <div class="form-group pad">
                                <label>电话号码：</label> <input type="tel"
                                                            class="form-control" id="dtelephone"
                                                            name="customerFormMap.telephone"
                                                            placeholder="请输入客户电话">
                            </div>
                            <div class="form-group pad" style="margin: 0 15px">
                                <label>成交时间：</label> <input type="text"
                                                            class=" form-control test-item"
                                                            id="dscreateDate"
                                                            name="customerFormMap.screateDate"
                                                            placeholder="请输入开始时间">----
                                <input type="text" class="form-control test-item"
                                       id="decreateDate" name="customerFormMap.ecreateDate"
                                       placeholder="请输入结束时间">


                            </div>
                            <button id="btn-testd" type="button" class="btn btn-info">搜索 &nbsp;&nbsp;<span
                                    class="glyphicon glyphicon-search" aria-hidden="true"></span></button>


                        </div>
                    </form>
                </div>
                <!-- 数据table代码 -->
                <table id="datatablea" class="table table-striped table-bordered"
                       style="text-align: center; vertical-align: middle !important">
                    <thead>
                    <tr>
                        <th>成交Id</th>
                        <th>客户姓名</th>
                        <th>联系方式</th>
                        <th>成交项目</th>
                        <th>来源</th>
                        <th>总价</th>
                        <th>面积</th>
                        <th>房号</th>
                        <th>佣金占比</th>
                        <th>佣金</th>
                        <th>成交时间</th>
                        <th>成交详情</th>
                    </tr>
                    </thead>
                </table>

            </div>

        </div>
    </div>

</div>

<script>
    //注意：选项卡 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function () {
         layui.element;
    });
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //同时绑定多个
        lay('.test-item').each(function () {
            laydate.render({
                elem: this,

                trigger: 'click'

                , max: 0 //今天以前
            });
        });
    });
</script>

</body>

</html>

