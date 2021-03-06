<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="js/system/personal/list.js"></script>
<style>
    .wid100 {
        width: 100%;
    }

    .wid100 div {
        display: inline-block;
        height: 30px;
        line-height: 30px;
        text-align: center;
    }

    h4 {
        display: inline-block;
        margin-top: 25px;
    }

    .inp_btn {
        height: 21px;
        line-height: 21px;
        padding: 0px 12px !important;
        margin-top: 1px;
    }

    .wid32 {
        width: 32%;
    }
    .wid64 {
        width:64%;
    }

    .wid32 span {
        color: red;
    }

    .bor_all {
        border: 1px solid #b4b8a7;
    }

    .height60{
        height: 60px !important;
    }
    line60{
        line-height: 60px !important;
    }
    .bor_right {
        border-right: 1px solid #b4b8a7;
    }
    .posre{
        position: relative;
    }
    .posab{
        position: absolute;
    }
</style>
<body>

<div class="layui-fluid layadmin-homepage-fluid">
    <div class="layui-row layui-col-space8">
        <div class="layui-col-md2">
            <div class="layadmin-homepage-panel layadmin-homepage-shadow">
                <div class="layui-card text-center">
                    <div class="layui-card-body">
                        <p style="font-size: 18px; font-weight: bold;">基本信息</p>
                        <div class="layadmin-homepage-pad-ver">
                            <img class="layadmin-homepage-pad-img" src="./img/tou.png" width="96" height="96">
                        </div>
                        <h4 class="layadmin-homepage-font">${personal.userName}</h4>
                    </div>
                </div>
                <p class="layadmin-homepage-about">
                    关于我
                </p>
                <ul class="layadmin-homepage-list-group">
                    <li class="list-group-item"><i class="fa fa-user"></i>&nbsp;账户名：${personal.accountName}</li>
                    <li class="list-group-item"><i class="fa fa-user-md"></i>&nbsp;用户名：${personal.userName}</li>
                    <li class="list-group-item"><i class="fa fa-tag"
                                                   aria-hidden="true"></i>&nbsp;部门：${personal.departmentName}</li>
                    <li class="list-group-item"><i class="fa fa-envelope"></i>&nbsp;邮箱：${personal.email}</li>
                    <li class="list-group-item"><i class="fa fa-phone-square "></i>&nbsp;电话：${personal.telephone}</li>
                </ul>
                <div class="layadmin-homepage-pad-hor">
                    <mdall>描述：：${personal.description}</mdall>
                </div>
            </div>
        </div>
        <div class="layui-col-md7">
            <div class="layui-fluid layadmin-homepage-content">

                <div class="layui-row layui-col-space20 layadmin-homepage-list-imgtxt">
                    <div class="layui-col-md9">
                        <div class="grid-demo">
                            <div class="layadmin-homepage-shadow">

                                <div class="media-body">

                                    <p style="font-size: 18px; font-weight: bold; padding-top:10px;">本周数据</p>
                                    <div class="media-list">
                                        <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                                        <div id="main" style="width: 100%;height:400px;"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="layui-col-md3">
            <p style="font-size: 18px; font-weight: bold;">报表提交</p>
            <header class="panel-heading">
                <div class="doc-buttons">
                  <%-- <button type="button" id="peReport" class="btn btn-primary marR10">个人日报表审核</button>--%>
                    <c:forEach items="${reres}" var="key">
                        ${key.description}
                    </c:forEach>

                </div>
            </header>
            <h4>日目标</h4>
            <button type="button" class="btn btn-default navbar-btn inp_btn" id="dayadd">录入</button>
           ${deres.deadd2.description}
            <div class="wid100 bor_all">
            <div class="wid32 bor_right">
                今日目标</div>
            <div class="wid32 bor_right">新增：
             <span id="dayplan_add">
                   </span></div>
            <div class="wid32">带访：<span id="dayplan_visit"></span></div>
        </div>
            <div class="wid100 bor_all height60 posre" >
                <div class="wid32 bor_right height60 posab" style="line-height: 60px" >目标项目</div>
                <div class="wid64 height60 posab" style="left: 32%">
               <span id="dayplan_visitproject">
                   </span>
                </div>
            </div>
            <div class="wid100 bor_all">
                <div class="wid32 bor_right">明日目标</div>

                <div class="wid32 bor_right">新增：<span id="nextplan_add"></span></div>
                <div class="wid32">带访：<span id="nextplan_visit"></span></div>
            </div>
            <div class="wid100 bor_all height60 posre" >
                <div class="wid32 bor_right height60 posab" style="line-height: 60px" >目标项目</div>
                <div class="wid64 height60 posab" style="left: 32%">
                       <span id="nextplan_visitproject">
                   </span>
                </div>
            </div>

            <h4>周目标</h4>
            <button type="button" class="btn btn-danger navbar-btn inp_btn" id="weekadd">录入</button>
            ${deres.deadd3.description}
            <div class="wid100 bor_all">
                <div class="wid32 bor_right">新增：<span  id="weekplan_add"></span></div>
                <div class="wid32 bor_right">带访：<span id="weekplan_visit"></span></div>
                <div class="wid32">佣金：<span id="weekplan_commission"></span></div>
            </div>

            <h4>月目标</h4>
            <button type="button" class="btn btn-warning navbar-btn inp_btn" id="monthadd">录入</button>
            ${deres.deadd4.description}
            <div class="wid100 bor_all">
                <div class="wid32 bor_right">新增：<span  id="monthplan_add"> </span></div>
                <div class="wid32 bor_right">带访：<span  id="monthplan_visit"></span></div>
                <div class="wid32">佣金：<span  id="monthplan_commission"></span></div>
            </div>

        </div>
    </div>
</div>


<script type="text/javascript">
    $(function () {

        showPlan();
        showLine();
        findPeweeks();
    });
//个人报表1
    function showLine() {

        $.ajax({
            type: "GET",
            url: "./statistics/findBypersonweek.shtml",
            dataType: 'json',
        });
    }
    //个人计划
    function showPlan() {

        $.ajax({
            type: "GET",
            url: "./personal/showPlan.shtml",
            dataType: 'json',
            success : function(obj) {
                console.log(obj);
                if (obj.dayplan!=null){
                    $("#dayplan_add").html(obj.dayplan.add+"组");
                    $("#dayplan_visit").html(obj.dayplan.visit+"组");
                    $("#dayplan_visitproject").html(obj.dayplan.visitproject);
                }
                if (obj.nextplan!=null) {
                    $("#nextplan_add").html(obj.nextplan.add+"组");
                    $("#nextplan_visit").html(obj.nextplan.visit+"组");
                    $("#nextplan_visitproject").html(obj.nextplan.visitproject);
                }
                if (obj.weekplan!=null){
                    $("#weekplan_add").html(obj.weekplan.add+"组");
                    $("#weekplan_visit").html(obj.weekplan.visit+"组");
                    $("#weekplan_commission").html(obj.weekplan.commission+"万元");
                }
                if (obj.monthplan!=null){
                    $("#monthplan_add").html(obj.monthplan.add+"组");
                    $("#monthplan_visit").html(obj.monthplan.visit+"组");
                    $("#monthplan_commission").html(obj.monthplan.commission+"万元");
                }
            },
            error : function() {
                layer.alert("请与管理员联系");
            }
            });
    }
    function  findPeweeks(){

        var myChart = echarts.init(document.getElementById('main'));
        //图表显示提示信息
        myChart.showLoading();
        //定义图表options
        option = {
            tooltip : {
                trigger : 'axis',
                axisPointer : { // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend : {
                data: ['新增', '跟进','带访']
            },
            grid : {
                left : '3%',
                right : '4%',
                bottom : '3%',
                containLabel : true
            },
            xAxis : {
                type : 'value'
            },
            yAxis : {
                type : 'category',
                data: ['周二','周三','周四','周五','周六','周日','周一']
            },
            series :  []
        };
        //通过Ajax获取数据
        $.ajax({
            type : "post",
            async : false, //同步执行
            url :" ./personal/findPeweeks.shtml",
            dataType : "json", //返回数据形式为json
            success : function(serisdata) {
                if (serisdata) {
                    //将返回的category和series对象赋值给options对象内的category和series
                    //因为xAxis是一个数组 这里需要是xAxis[i]的形式
                    var datas = [];
                    var data1 = [];
                    var data2 = [];
                    var data3 = [];
                    for ( var i = 0; i < serisdata.length; i++) {

                            data1.push( serisdata[i].adds);
                        data2.push( serisdata[i].follow);
                        data3.push( serisdata[i].visit);

                    }
                    datas.push(
                        {
                        name: '新增',
                        type: 'bar',
                        stack: '总量',
                        label: {
                            normal: {
                                show: true,
                                position: 'insideRight'
                            }
                        },
                        data: data1,
                    }, {
                            name: '跟进',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: data2,
                        }, {
                            name: '带访',
                            type: 'bar',
                            stack: '总量',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideRight'
                                }
                            },
                            data: data3,
                        });
                    option.series = datas;
                    myChart.hideLoading();
                    myChart.setOption(option);
                }
            },
            error : function(errorMsg) {
                alert("图表请求数据失败啦!");
            }
        });

    }
</script>
</body>

</html>