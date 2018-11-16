<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/common/common.jspf" %>

    <style>
        .containt {
            width: 1000px;
            border: 1px solid #a7a5a5;
            margin-left: 15px !important;
            margin-bottom: 15px;
        }

        .dis_inlinblock {
            display: inline-block;
        }

        .pad0 {
            padding: 0px;
        }

        .wid100 {
            width: 100%;
        }

        .wid23 {
            width: 23%;
        }

        .wid30 {
            width: 30%;
        }

        .wid50 {
            width: 45%;
        }

        .hei30 {
            height: 30px;
            line-height: 30px;
        }

        .hei70 {
            height: 70px;
            line-height: 70px;
        }

        .m_title {
            width: 100%;
            height: 40px;
            line-height: 40px;
            background-color: #e6e1e1;
        }

        .bor_bottom {
            border-bottom: 1px solid #e6e1e1;
        }

        .bor_right {
            border-right: 1px solid #e6e1e1;
        }

        .subbtn {
            width: 10%;
            height: 30px !important;
            margin-left: 45%;
        }

        .font12 {
            font-size: 12px;
        }
        .padl10{
            padding-left: 10px;
        }
    </style>
</head>

<body>
<div class="containt " style="border:0px">
    <div class="msg">
        <h2 class="text-center">个人日报确认单</h2>
        <div class="name padl10">姓名：${personal.userName}</div>
        <div class="dep padl10">部门：${personal.departmentName}</div>
        <div class="time padl10">时间：${dayreality.days}</div>
    </div>
</div>
<div class="monthdata container containt">
    <div class="row">
        <div class="m_title text-center ">当天工作情况</div>
        <div class="m_head hei30 bor_bottom">
            <div class="col-md-1 text-center dis_inlinblock bor_right"></div>
            <div class="col-md-5 text-center dis_inlinblock bor_right">新增</div>
            <div class="col-md-4 text-center dis_inlinblock bor_right">到访</div>
            <div class="col-md-2 text-center dis_inlinblock bor_right">成交</div>
        </div>
        <div class="m_head_z hei30 bor_bottom">
            <div class="col-md-1 text-center dis_inlinblock"></div>
            <div class="col-md-5 text-center dis_inlinblock  bor_right">
                <div class="wid23 text-center dis_inlinblock pad0 ">电话新增</div>
                <div class="wid23 text-center dis_inlinblock pad0 ">网络新增</div>
                <div class="wid23 text-center dis_inlinblock pad0 ">其他新增</div>
                <div class="wid23 text-center dis_inlinblock pad0 ">新增总数</div>
            </div>

            <div class="col-md-4 text-center dis_inlinblock  bor_right">
                <div class="wid50 text-center dis_inlinblock pad0">带访数</div>
                <div class="wid50 text-center dis_inlinblock pad0">带访项目</div>
            </div>
            <div class="col-md-2 text-center dis_inlinblock  bor_right">
                <div class="wid100 text-center dis_inlinblock pad0">成交佣金(元)</div>
            </div>
        </div>
        <div class="m_body">
            <div class="m_head_z hei70 bor_bottom">
                <div class="col-md-1 text-center dis_inlinblock bor_right">预计</div>
                <div class="col-md-5 text-center dis_inlinblock bor_right d_exp_add">
                    ${dayplan.add}
                </div>

                <div class="col-md-4 text-center dis_inlinblock  bor_right">
                    <div class="wid50 text-center dis_inlinblock pad0 bor_right d_exp_visit">  ${dayplan.visit}</div>
                    <div class="wid50 text-center dis_inlinblock pad0 font12 d_exp_pro" style="line-height:14px;">\</div>
                </div>
                <div class="col-md-2 text-center dis_inlinblock  bor_right">
                    <div class="wid30 text-center dis_inlinblock pad0 d_exp_money">\</div>
                </div>
            </div>
            <div class="m_head_z hei70 bor_bottom">
                <div class="col-md-1 text-center dis_inlinblock bor_right"> 实际</div>
                <div class="col-md-5 text-center dis_inlinblock  bor_right">
                    <div class="wid23 text-center dis_inlinblock pad0  bor_right d_real_tel">${dayreality.adddh}</div>
                    <div class="wid23 text-center dis_inlinblock pad0  bor_right d_real_net">${dayreality.addwl}</div>
                    <div class="wid23 text-center dis_inlinblock pad0  bor_right d_real_other">${dayreality.addqt}</div>
                    <div class="wid23 text-center dis_inlinblock pad0 d_real_sum">${dayreality.addw}</div>
                </div>
                <div class="col-md-4 text-center dis_inlinblock  bor_right">
                    <div class="wid50 text-center dis_inlinblock pad0 bor_right d_real_visit">${dayreality.visit}</div>
                    <div class="wid50 text-center dis_inlinblock pad0 font12 d_real_pro" style="line-height:14px;">${dayreality.visitproject}</div>
                </div>
                <div class="col-md-2 text-center dis_inlinblock  bor_right">
                    <div class="wid30 text-center dis_inlinblock pad0 d_real_money">${dayreality.commission}</div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="monthdata container containt">
    <div class="row">
        <div class="m_title text-center ">本周工作情况</div>
        <div class="m_head hei30 bor_bottom">
            <div class="col-md-1 text-center dis_inlinblock bor_right"></div>
            <div class="col-md-5 text-center dis_inlinblock bor_right">新增</div>
            <div class="col-md-3 text-center dis_inlinblock bor_right">到访</div>
            <div class="col-md-3 text-center dis_inlinblock bor_right">成交</div>
        </div>
        <div class="m_head_z hei30 bor_bottom">
            <div class="col-md-1 text-center dis_inlinblock"></div>
            <div class="col-md-5 text-center dis_inlinblock  bor_right">
                <div class="wid23 text-center dis_inlinblock pad0 ">电话新增</div>
                <div class="wid23 text-center dis_inlinblock pad0 ">网络新增</div>
                <div class="wid23 text-center dis_inlinblock pad0 ">其他新增</div>
                <div class="wid23 text-center dis_inlinblock pad0 ">新增总数</div>
            </div>

            <div class="col-md-3 text-center dis_inlinblock  bor_right">
                <div class="wid100 text-center dis_inlinblock pad0">带访数</div>
            </div>
            <div class="col-md-3 text-center dis_inlinblock  bor_right">
                <div class="wid100 text-center dis_inlinblock pad0">成交佣金(元)</div>
            </div>
        </div>
        <div class="m_body">
            <div class="m_head_z hei70 bor_bottom">
                <div class="col-md-1 text-center dis_inlinblock bor_right">预计</div>
                <div class="col-md-5 text-center dis_inlinblock bor_right w_exp_add">
                    23
                </div>

                <div class="col-md-3 text-center dis_inlinblock  bor_right">
                    <div class="wid100 text-center dis_inlinblock pad0  w_exp_visit">32</div>
                </div>
                <div class="col-md-3 text-center dis_inlinblock  bor_right">
                    <div class="wid100 text-center dis_inlinblock pad0 w_exp_money">15</div>
                </div>
            </div>
            <div class="m_head_z hei70 bor_bottom">
                <div class="col-md-1 text-center dis_inlinblock bor_right">实际</div>
                <div class="col-md-5 text-center dis_inlinblock  bor_right">
                    <div class="wid23 text-center dis_inlinblock pad0  bor_right w_real_tel">1</div>
                    <div class="wid23 text-center dis_inlinblock pad0  bor_right w_real_net">1</div>
                    <div class="wid23 text-center dis_inlinblock pad0  bor_right w_real_other">1</div>
                    <div class="wid23 text-center dis_inlinblock pad0 w_real_sum">3</div>
                </div>
                <div class="col-md-3 text-center dis_inlinblock  bor_right">
                    <div class="wid100 text-center dis_inlinblock pad0 w_real_visit">1</div>
                </div>
                <div class="col-md-3 text-center dis_inlinblock  bor_right">
                    <div class="wid100 text-center dis_inlinblock pad0 w_real_money">1</div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="monthdata container containt">
    <div class="row">
        <div class="m_title text-center ">本月工作情况</div>
        <div class="m_head hei30 bor_bottom">
            <div class="col-md-1 text-center dis_inlinblock bor_right"></div>
            <div class="col-md-5 text-center dis_inlinblock bor_right">新增</div>
            <div class="col-md-3 text-center dis_inlinblock bor_right">到访</div>
            <div class="col-md-3 text-center dis_inlinblock bor_right">成交</div>
        </div>
        <div class="m_head_z hei30 bor_bottom">
            <div class="col-md-1 text-center dis_inlinblock"></div>
            <div class="col-md-5 text-center dis_inlinblock  bor_right">
                <div class="wid23 text-center dis_inlinblock pad0 ">电话新增</div>
                <div class="wid23 text-center dis_inlinblock pad0 ">网络新增</div>
                <div class="wid23 text-center dis_inlinblock pad0 ">其他新增</div>
                <div class="wid23 text-center dis_inlinblock pad0 ">新增总数</div>
            </div>

            <div class="col-md-3 text-center dis_inlinblock  bor_right">
                <div class="wid100 text-center dis_inlinblock pad0">带访数</div>
            </div>
            <div class="col-md-3 text-center dis_inlinblock  bor_right">
                <div class="wid100 text-center dis_inlinblock pad0">成交佣金(元)</div>
            </div>
        </div>
        <div class="m_body">
            <div class="m_head_z hei70 bor_bottom">
                <div class="col-md-1 text-center dis_inlinblock bor_right">预计</div>
                <div class="col-md-5 text-center dis_inlinblock bor_right m_exp_add">
                    23
                </div>

                <div class="col-md-3 text-center dis_inlinblock  bor_right">
                    <div class="wid100 text-center dis_inlinblock pad0  m_exp_visit">32</div>
                </div>
                <div class="col-md-3 text-center dis_inlinblock  bor_right">
                    <div class="wid100 text-center dis_inlinblock pad0 m_exp_money">15</div>
                </div>
            </div>
            <div class="m_head_z hei70 bor_bottom">
                <div class="col-md-1 text-center dis_inlinblock bor_right">实际</div>
                <div class="col-md-5 text-center dis_inlinblock  bor_right">
                    <div class="wid23 text-center dis_inlinblock pad0  bor_right m_real_tel">1</div>
                    <div class="wid23 text-center dis_inlinblock pad0  bor_right m_real_net">1</div>
                    <div class="wid23 text-center dis_inlinblock pad0  bor_right m_real_other">1</div>
                    <div class="wid23 text-center dis_inlinblock pad0 m_real_sum">3</div>
                </div>
                <div class="col-md-3 text-center dis_inlinblock  bor_right">
                    <div class="wid100 text-center dis_inlinblock pad0 m_real_visit">1</div>
                </div>
                <div class="col-md-3 text-center dis_inlinblock  bor_right">
                    <div class="wid100 text-center dis_inlinblock pad0 m_real_money">1</div>
                </div>
            </div>
        </div>
    </div>
</div>
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
            //当天预计目标
            var d_exp_add = $.trim($(".d_exp_add").text());
            var d_exp_visit = $.trim($(".d_exp_visit").text());
            var d_exp_pro = $.trim($(".d_exp_pro").text());
            //当天实际
            var d_real_tel = $.trim($(".d_real_tel").text());
            var d_real_net = $.trim($(".d_real_net").text());
            var d_real_other = $.trim($(".d_real_other").text());
            var d_real_sum = $.trim($(".d_real_sum").text());
            var d_real_visit = $.trim($(".d_real_visit").text());
            var d_real_pro = $.trim($(".d_real_pro").text());
            var d_real_deal = $.trim($(".d_real_deal").text());
            var d_real_dealpro = $.trim($(".d_real_dealpro").text());
            var d_real_money = $.trim($(".d_real_money").text());
            //本周预计目标
            var w_exp_add = $.trim($(".w_exp_add").text());
            var w_exp_visit = $.trim($(".w_exp_visit").text());
            var w_exp_money = $.trim($(".w_exp_money").text());
            //本周实际
            var w_real_sum = $.trim($(".w_real_sum").text());
            var w_real_visit = $.trim($(".w_real_visit").text());
            var w_real_money = $.trim($(".w_real_money").text());
            //本月预计目标
            var m_exp_add = $.trim($(".m_exp_add").text());
            var m_exp_visit = $.trim($(".m_exp_visit").text());
            var m_exp_money = $.trim($(".m_exp_money").text());
            //本月实际
            var m_real_sum = $.trim($(".m_real_sum").text());
            var m_real_visit = $.trim($(".m_real_visit").text());
            var m_real_money = $.trim($(".m_real_money").text());
            // console.log(d_exp_add)

            if(d_exp_add =="" ||d_exp_visit=="" || w_exp_add =="" ||w_exp_visit==""|| m_exp_add =="" ||m_exp_visit==""){
                layer.alert('请返回主页制定目标计划！', 3);
            }else{
                var info = name+"line_space"+dep+ "line_space"+day+ "工作情况：line_space电话新增：" + d_real_tel + "组,line_space网络新增：" + d_real_net + "组,line_space其他新增：" + d_real_other +
                    "组,line_space新增总数：" + d_real_sum + "组,line_space今日带看数：" + d_real_visit + "组,line_space今天带看项目：" + d_real_pro + ",line_space明日预计新增：" +
                    d_exp_add + "组,line_space 明日预计到访：" + d_exp_visit +"组line_space line_space本周预计新增目标："+w_exp_add+"组,line_space已完成："+w_real_sum+"组;line_space预计到访目标："+w_exp_visit+
                    "组,line_space已完成："+w_real_visit+"组;line_space佣金周目标："+w_exp_money+"元,line_space已完成："+w_real_money+"元;line_space line_space本月新增目标："+m_exp_add+"组,line_space已完成："+m_real_sum
                    +"组;line_space预计到访目标："+m_exp_visit +"组,line_space已完成："+m_real_visit +"组; line_space佣金目标："+m_exp_money+"元, line_space已完成："+m_real_money+"元"
                $.ajax({
                    url: "http://fbd.fangqianli.com/FBD_FFX/Ffx_manage",
                    type: 'get',
                    dataType: 'json',
                    data: {
                        method: "wechat_info",
                        department: "测试",
                        info: info
                    },
                    success: function (res, error) {
                        // console.log(res)
                        if(res.state){
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
