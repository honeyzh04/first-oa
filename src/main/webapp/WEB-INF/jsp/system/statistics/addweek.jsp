<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/common/common.jspf" %>
    <script type="text/javascript" src="${ctx}/js/system/statistics/addweek.js">
    </script>

    <style type="text/css">

        button{
            width: 250px;
            height: 35px;
            background:rgb(0, 159, 149);
            color: #fff;
            border: 0px;
            margin: 75px 275.5px;
        }

        .col-lg-6 {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
<form id="form" name="form" class="form-horizontal" method="post"
      action="${ctx}/statistics/addWeekReports.shtml">
<div class="container">
    <div class="page-header">
     <h1>房发现运营数据链 </h1>


    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">录取时间选择</h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">开始时间</span>
                        <input type="text"  class="form-control test-item" id="screateDate" name="statisticsFormMap.screateDate" placeholder="请输入开始时间">


                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">

                        <span class="input-group-addon" id="sizing-addon1">结束时间</span>
                        <input type="text"  class="form-control test-item" id="ecreateDate" name="statisticsFormMap.ecreateDate" placeholder="请输入结束时间">

                    </div>
                </div>


            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">推广平台选择</h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">推广平台</span>
                        <select class="form-control" id="sltWebSite" name="statisticsFormMap.platform">
                            <option value="">选择推广平台</option>
                            <option value="电脑端:fangfaxian.com">电脑端:fangfaxian.com</option>
                            <option value="电脑端:fangfaxian.cn">电脑端:fangfaxian.cn</option>
                            <option value="移动端:m.fangfaxian.com">移动端:m.fangfaxian.com</option>
                            <option value="移动端:m.fangfaxian.cn">移动端:m.fangfaxian.cn</option>
                            <option value="wangjinpu.com">wangjinpu.com</option>
                            <option value="m.wangjinpu.com">m.wangjinpu.com</option>
                            <option value="信息流营销页">信息流营销页</option>
                            <option value="微信小程序">微信小程序</option>
                            <option value="专题页面">专题页面</option>
                            <option value="南充站">南充站</option>
                        </select>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">推广渠道</span>
                        <select class="form-control" id="sltChannels" name="statisticsFormMap.channel">
                            <option  value="">选择推广渠道</option>
                            <option  value="百度">百度</option>
                            <option  value="搜狗">搜狗</option>
                            <option   value="神马">神马</option>
                            <option   value="360">360推广</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">推广方式</span>
                        <select class="form-control" id="sltType" name="statisticsFormMap.ways">
                            <option value="">选择推广方式</option>
                            <option value="搜索推广">搜索推广</option>
                            <option value="信息流">信息流</option>
                            <option value="自然流量">自然流量</option>
                        </select>
                    </div>
                </div>
            </div>


        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">访问数据录入</h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">消费</span>
                        <input type="text" class="form-control" placeholder="输入消费金额" name="statisticsFormMap.consume">
                        <span class="input-group-addon">元</span>

                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">关键词量</span>
                        <input type="text" class="form-control" placeholder="输入关键词数量" name="statisticsFormMap.keyword">
                        <span class="input-group-addon">个</span>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">展现量</span>
                        <input type="text" class="form-control" placeholder="输入展现数量" name="statisticsFormMap.shows">
                        <span class="input-group-addon">次</span>
                    </div>
                </div>



            </div>

            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">总点击</span>
                        <input type="text" class="form-control" placeholder="输入点击量" name="statisticsFormMap.click">
                        <span class="input-group-addon">次</span>

                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">IP</span>
                        <input type="text" class="form-control" placeholder="输入IP数量" name="statisticsFormMap.ip_click">
                        <span class="input-group-addon">个</span>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">PV</span>
                        <input type="text" class="form-control" placeholder="输入PV数量" name="statisticsFormMap.pv_click">
                        <span class="input-group-addon">次</span>
                    </div>
                </div>

                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">UV</span>
                        <input type="text" class="form-control" placeholder="输入UV数量" name="statisticsFormMap.uv_click">
                        <span class="input-group-addon">次</span>
                    </div>
                </div>

            </div>

            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">平均访问时长</span>
                        <input type="text" class="form-control" placeholder="输入平均访问时长" name="statisticsFormMap.avetime">
                        <span class="input-group-addon">次</span>

                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">

                        <span class="input-group-addon" id="sizing-addon1">平均点击价格</span>
                        <input type="text" class="form-control" placeholder="输入平均点击价格" name="statisticsFormMap.aveprice">
                        <span class="input-group-addon">次/元</span>
                    </div>
                </div>


            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">点击率</span>
                        <input type="text" class="form-control" placeholder="输入点击率(小数)" name="statisticsFormMap.click_rate">

                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">跳出率</span>
                        <input type="text" class="form-control" placeholder="输入跳出率(小数)" name="statisticsFormMap.bounce_rate">


                    </div>
                </div>
            </div>

        </div>


    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">对话数据录入</h3>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">电话接访</span>
                        <input type="text" class="form-control" placeholder="输入电话接访数量" name="statisticsFormMap.telephone">
                        <span class="input-group-addon">个</span>

                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">有效电话接访</span>
                        <input type="text" class="form-control" placeholder="输入有效电话接访数量" name="statisticsFormMap.eftelephone">
                        <span class="input-group-addon">个</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">网站微聊</span>
                        <input type="text" class="form-control" placeholder="输入网站微聊数量" name="statisticsFormMap.weiliao">
                        <span class="input-group-addon">个</span>

                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">有效网站微聊</span>
                        <input type="text" class="form-control" placeholder="输入有效网站微聊数量" name="statisticsFormMap.efweiliao">
                        <span class="input-group-addon">个</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">商桥对话</span>
                        <input type="text" class="form-control" placeholder="输入商桥对话数量" name="statisticsFormMap.shangqiao">
                        <span class="input-group-addon">个</span>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">有效商桥对话</span>
                        <input type="text" class="form-control" placeholder="输入有效商桥对话接访数量" name="statisticsFormMap.efshangqiao">
                        <span class="input-group-addon">个</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">短信&邮件</span>
                        <input type="text" class="form-control" placeholder="输入短信&邮件数量" name="statisticsFormMap.message">
                        <span class="input-group-addon">个</span>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">平均对话时长</span>
                        <input type="text" class="form-control" placeholder="输入平均对话时长" name="statisticsFormMap.dialogue_time">
                        <span class="input-group-addon">分</span>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">对话成本</span>
                        <input type="text" class="form-control" placeholder="输入对话成本" name="statisticsFormMap.dialogue_cost">
                        <span class="input-group-addon">元</span>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="input-group">
                        <span class="input-group-addon" id="sizing-addon1">有效对话成本</span>
                        <input type="text" class="form-control" placeholder="输入有效对话成本" name="statisticsFormMap.efdialogue_cost">
                        <span class="input-group-addon">元</span>
                    </div>
                </div>
            </div>

        </div>
        </div>

    </div>

</div>
</form>
<div class="form-group clearfix">
    <button  type="button" id="btn-test" class="btn btn-info pull-right">保存</button>
</div>
<SCRIPT type="text/javascript" >

    $("#btn-test").click(function(){

        $(this).attr("disabled","true"); //设置变灰按钮
        $("#form").submit();//提交表单
        setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示

    })

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

</SCRIPT>
</body>
</html>


