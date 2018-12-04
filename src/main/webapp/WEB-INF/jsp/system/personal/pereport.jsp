<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/common/common.jspf" %>
    <style>
        .table {
            border: 1px solid #dbdbdd;
            text-align: center;
            width: 1000px !important;
            margin-left: 10px;
        }

        .table th {
            min-width: 100px;
            text-align: center;
        }

        caption {
            background: #e6e1e1 !important;
            text-align: center !important;
        }
        .containt{
            margin-left: 10px;
        }
        .subbtn {
            width: 10%;
            height: 30px !important;
            margin-left: 45%;
        }
    </style>

</head>

<body>
<input type="hidden" class="agentid" id="agentid"
       value="${personal.agentid}">
<input type="hidden" class="corpsecret" id="corpsecret"
       value="${personal.corpsecret}">
<div class="containt " style="border:0px">
    <div class="msg">
        <h2 class="text-center">个人日报确认单</h2>
        <div class="name padl10">姓名：${personal.userName}</div>
        <div class=" padl10" >部门：<span class="dep">${personal.departmentName}</span></div>
        <div class="time padl10">时间：${dayreality.days}</div>
    </div>
</div>
<table class="table" border="1">
    <caption>当天工作情况</caption>
    <thead>
    <tr>
        <th></th>
        <th colspan="4">新增</th>
        <th colspan="2">到访</th>
        <th colspan="3">成交</th>
    </tr>
    </thead>
    <tbody>

    <tr>
        <th></th>
        <th>电话新增</th>
        <th>网络新增</th>
        <th>其他新增</th>
        <th>新增总数</th>
        <th>到访数</th>
        <th>到访项目</th>
        <th>成交价格</th>
        <th>成交佣金</th>
        <th>成交项目</th>

    </tr>
    <tr>
        <th>明日计划</th>
        <th colspan="4" class="d_exp_add"> ${dayplan.add}</th>
        <th class="d_exp_visit"> ${dayplan.visit}</th>
        <th class="d_exp_visitpro"> ${dayplan.visitproject}</th>
        <th colspan="3" class="d_exp_money">/</th>
    </tr>
    <tr>
        <th>今日实际</th>
        <th class="d_real_tel">${dayreality.adddh}</th>
        <th class="d_real_net">${dayreality.addwl}组(安居客：${dayreality.addwla},58：${dayreality.addwl5},房发现：${dayreality.addwlf})</th>
        <th class="d_real_other">${dayreality.addqt}</th>
        <th class="d_real_sum">${dayreality.addw}</th>
        <th class="d_real_visit">${dayreality.visit}</th>
        <th class="d_real_pro">${dayreality.visitproject}</th>
        <th class="d_real_price">${dayreality.price}</th>
        <th class="d_real_money">${dayreality.commission}</th>
        <th class="d_real_moneypro">${dayreality.dealproject}</th>
    </tr>

    </tbody>
</table>

<table class="table" border="1">
    <caption>本周工作情况</caption>
    <thead>
    <tr>
        <th></th>
        <th colspan="4">新增</th>
        <th colspan="2">到访</th>
        <th colspan="2">成交</th>
    </tr>
    </thead>
    <tbody>

    <tr>
        <th></th>
        <th>电话新增</th>
        <th>网络新增</th>
        <th>其他新增</th>
        <th>新增总数</th>
        <th colspan="2">到访数</th>
        <th>成交价格</th>
        <th>成交佣金</th>

    </tr>
    <tr>
        <th>预计</th>
        <th colspan="4" class="w_exp_add"> ${weekplan.add}</th>
        <th colspan="2" class="w_exp_visit">${weekplan.visit}</th>
        <th class="w_exp_price">/</th>
        <th class="w_exp_money"> ${weekplan.commission}</th>
    </tr>
    <tr>
        <th>实际</th>
        <th class="w_real_tel"> ${weekreality.adddh}</th>
        <th class="w_real_net">${weekreality.addwl}组(安居客：${weekreality.addwla},58：${weekreality.addwl5},房发现：${weekreality.addwlf})</th>
        <th class="w_real_other">${weekreality.addqt}</th>
        <th class="w_real_sum">${weekreality.addw}</th>
        <th class="w_real_visit" colspan="2">${weekreality.visit}</th>
        <th class="w_real_price">${weekreality.price}</th>
        <th class="w_real_money">${weekreality.commission}</th>
    </tr>

    </tbody>
</table>

<table class="table" border="1">
    <caption>本月工作情况</caption>
    <thead>
    <tr>
        <th></th>
        <th colspan="4">新增</th>
        <th colspan="2">到访</th>
        <th colspan="2">成交</th>
    </tr>
    </thead>
    <tbody>

    <tr>
        <th></th>
        <th>电话新增</th>
        <th>网络新增</th>
        <th>其他新增</th>
        <th>新增总数</th>
        <th colspan="2">到访数</th>
        <th>成交价格</th>
        <th>成交佣金</th>

    </tr>
    <tr>
        <th>预计</th>
        <th class="m_exp_add" colspan="4"> ${monthplan.add}</th>
        <th class="m_exp_visit" colspan="2">${monthplan.visit}</th>
        <th class="m_exp_price">/</th>
        <th class="m_exp_money">${monthplan.commission}</th>
    </tr>
    <tr>
        <th>实际</th>
        <th class="m_real_tel">${monthreality.adddh}</th>
        <th class="m_real_net">${monthreality.addwl}组(安居客：${monthreality.addwla},58：${monthreality.addwl5},房发现：${monthreality.addwlf})</th>
        <th class="m_real_other">${monthreality.addqt}</th>
        <th class="m_real_sum">${monthreality.addw}</th>
        <th class="m_real_visit" colspan="2">${monthreality.visit}</th>
        <th class="m_real_price">${monthreality.price}</th>
        <th class="m_real_money">${monthreality.commission}</th>
    </tr>

    </tbody>
</table>

<div class="containt" style="border:0px">
    <div>注：一经提交，不能修改并发送到部门微信群</div>
    <button class="btn btn-primary subbtn">提交</button>
</div>

</body>
<script>
    $(".subbtn").click(
        function () {
            var myDate = new Date();
            // myDate.getMonth(); //获取当前月份(0-11,0代表1月)
            // myDate.getDate(); //获取当前日(1-31)
            var day = myDate.getMonth() + 1 + "月" + myDate.getDate().toString() + "日";
            console.log(day)
            //个人信息
            var name = $.trim($(".name").text());
            var dep = $.trim($(".dep").text());
            var  weixin=dep.slice(0,2);
            //当天预计目标
            var d_exp_add = $.trim($(".d_exp_add").text());
            var d_exp_visit = $.trim($(".d_exp_visit").text());
            var  d_exp_visitpro = $.trim($(".d_exp_visitpro").text());

            //当天实际
            var d_real_tel = $.trim($(".d_real_tel").text());
            var d_real_net = $.trim($(".d_real_net").text());

            var d_real_other = $.trim($(".d_real_other").text());
            var d_real_sum = $.trim($(".d_real_sum").text());
            var d_real_visit = $.trim($(".d_real_visit").text());
            var d_real_pro = $.trim($(".d_real_pro").text());
            var d_real_deal = $.trim($(".d_real_deal").text());
            var d_real_dealpro = $.trim($(".d_real_dealpro").text());
            var d_real_price = $.trim($(".d_real_price").text());
            var d_real_money = $.trim($(".d_real_money").text());
            var d_real_moneypro = $.trim($(".d_real_moneypro").text());
            //本周预计目标
            var w_exp_add = $.trim($(".w_exp_add").text());
            var w_exp_visit = $.trim($(".w_exp_visit").text());
            var w_exp_money = $.trim($(".w_exp_money").text());

            //本周实际
            var w_real_sum = $.trim($(".w_real_sum").text());
            var w_real_visit = $.trim($(".w_real_visit").text());
            var w_real_price = $.trim($(".w_real_price").text());
            var w_real_money = $.trim($(".w_real_money").text());
            var  w_real_net = $.trim($(".w_real_net").text());
            //本月预计目标
            var m_exp_add = $.trim($(".m_exp_add").text());
            var m_exp_visit = $.trim($(".m_exp_visit").text());

            var m_exp_money = $.trim($(".m_exp_money").text());
            //本月实际
            var m_real_sum = $.trim($(".m_real_sum").text());
            var m_real_visit = $.trim($(".m_real_visit").text());
            var m_real_price = $.trim($(".m_real_price").text());
            var m_real_money = $.trim($(".m_real_money").text());
            var  m_real_net = $.trim($(".m_real_net").text());
            // console.log(d_exp_add)
            var agentid=$.trim($("#agentid").val());
            var corpsecret=$.trim($("#corpsecret").val());

            if (d_exp_add == "" || d_exp_visit == "" || w_exp_add == "" || w_exp_visit == "" || m_exp_add == "" || m_exp_visit == "") {
                layer.alert('请返回主页制定目标计划！', 3);
            } else {
                var info = "个人日报表\n\n"+name + "\n部门：" + dep + "\n" + day + "工作情况：\n新增总数：" + d_real_sum + "组,\n电话新增：" + d_real_tel + "组,\n网络新增：" + d_real_net + ",\n其他新增：" + d_real_other +
                    "组,\n今日带看数：" + d_real_visit + "组,\n今天带看项目：" + d_real_pro + ",\n今日成交价格：" + d_real_price + "万元,\n今日成交佣金：" + d_real_money + "万元,\n今天成交项目：" + d_real_moneypro + ",\n明日预计新增：" +
                    d_exp_add + "组,\n明日预计到访：" + d_exp_visit + "组,\n明日预计到访项目："+  d_exp_visitpro + "\n \n本周预计新增目标：" + w_exp_add + "组,\n已完成：" + w_real_sum + "组,\n网络新增：" + w_real_net + "组;\n预计到访目标：" + w_exp_visit +
                    "组,\n已完成：" + w_real_visit + "组;\n佣金周目标：" + w_exp_money + "万元,\n已完成：" + w_real_money + "万元,\n成交价格：" + w_real_price +"万元;\n \n本月新增目标：" + m_exp_add + "组,\n已完成：" + m_real_sum
                    +  "组,\n网络新增：" + m_real_net +"组;\n预计到访目标：" + m_exp_visit + "组,\n已完成：" + m_real_visit + "组; \n佣金目标：" + m_exp_money + "万元, \n已完成：" + m_real_money + "万元\n成交价格：" + m_real_price + "万元"
                $.ajax({
                    url: "../personal/sendWeChat.shtml",
                    type: 'get',
                    dataType: 'json',
                    data: {
                       corpsecret:corpsecret,
                        agentid: agentid,
                        info: info
                    },
                    success: function (res, error) {
                        // console.log(res)
                        if(res=="success"){
                            layer.confirm('提交成功!是否关闭窗口?', {
                                icon : 6,
                                title : '提示'
                            }, function(index) {

                                parent.layer.close(parent.pageii);
                                return false;
                            });

                        } else {
                            layer.alert('提交失败！', 3);
                        }
                    }
                })

            }

        }
    )
</script>


</body>
</html>
