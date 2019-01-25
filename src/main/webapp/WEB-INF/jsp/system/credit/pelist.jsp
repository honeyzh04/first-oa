<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


</head>
<style>
    .head{
        width: 100%;
        height: 120px;
        /* border-bottom:2px solid rgb(179, 176, 176);  */
    }
    .head div{
        display: inline-block;

    }
    .head_img{
        width: 100px;
        height: 100px;
        border-radius:50%;
        overflow: hidden;
        margin:10px;

    }
    .head_img img{
        width: 100px;
        height: 100px;
    }
    .heigh120{
        height: 120px;
        line-height: 120px;
    }
    .verticaltop{
        vertical-align: top;
    }
    .aligncenter{
        text-align: center;
    }
    .pad10{
        padding: 10px;
    }
    .box{
        width: 120px;
        text-align: center;
        border: 1px solid #ccc;
        border-radius:10px;
        display: inline-block;
        margin-left: 10px;
    }
    .font12{
        font-size: 12px;
    }
    .font14{
        font-size: 14px;
    }
    .line18{
        line-height: 18px;
    }
    .line40{
        line-height: 40px;
    }
    .pad75px{
        padding-top: 65px;
    }
    .marl50{
        margin-left: 50px;
    }
    .magt85{
        margin-top: 85px;
    }
    .padt53{
        padding-top: 44px;
    }
    .btn-warning{
        height: 23px;
        line-height: 13px;
    }
    .disnone{
        display:none !important;
    }
</style>

<body>
<div class="wrap">
    <div class="head">
        <div class="head_img">  <img class="layadmin-homepage-pad-img" src="./img/tou.png" width="96" height="96"></div>
        <div class="name heigh120 line18 verticaltop pad75px">
            <p> 姓名：${creditFormMap.userName}</p>
        </div>
        <div class="myint heigh120 verticaltop marl50 padt53"> <span>我的积分：${creditFormMap.balance}</span> </div>
        <button type="button " class="btn btn-info verticaltop magt85 marl50">使用规则</button>
        <!-- <div class="rule verticaltop">
            <p >使用规则</p>
        </div> -->
    </div>
    <div class="content">
        <ul id="myTab" class="nav nav-tabs">
            <li class="active">
                <a href="#home" data-toggle="tab">
                    积分兑换
                </a>
            </li>
            <li><a href="#Exchange" data-toggle="tab">
                兑换记录
            </a></li>
            <li><a href="#receive" data-toggle="tab">
                获取积分记录
            </a></li>

        </ul>
        <div id="myTabContent" class="tab-content pad10">
            <div class="tab-pane fade in active" id="home">
                <div>
                    <div class="box pad10">
                        <img src="image/3.png" alt="">
                        <p>房源置顶</p>
                        <div> <span class="font12">1000分</span> <button type="button" class="btn btn-warning" onclick="funExchange('7')">兑换</button></div>
                    </div>
                    <div class="box pad10">
                        <img src="image/3.png" alt="">
                        <p>精选房源</p>
                        <div> <span class="font12">1000分</span> <button type="button" class="btn btn-warning" onclick="funExchange('7')">兑换</button></div>
                    </div>
                </div>

            </div>
            <div class="tab-pane fade" id="Exchange">

                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>商品</th>
                        <th>时间</th>
                        <th>消耗积分</th>
                    </tr>
                    </thead>
                    <tbody id="r_tbody">
                    </tbody>
                </table>
                <div class="rpagebtn aligncenter"></div>
            </div>
            <div class="tab-pane fade" id="receive">

                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>操作</th>
                        <th>时间</th>
                        <th>积分</th>
                    </tr>
                    </thead>
                    <tbody id="e_tbody">


                    </tbody>
                </table>
                <div class="epagebtn aligncenter">
            </div>

        </div>

    </div>
</div>

</body>
<%--<script src="js/jquery-1.10.2.js"></script>--%>
<script>
    function getelist(obj) {
        var page="";
        if( $(obj).attr('data-page')!==undefined){
            page = $(obj).attr('data-page');
        }
        else(
            page=""
        )
        $.ajax({
            type: "get",
            url: "./credit/findCreditRecord.shtml",
            dataType: "json",
            async: true,
            data: {
                page: page,
                type:0
            },
            success: function (data) {
              console.log(data);
                var btnhtml = '';
                btnhtml = '<span class="btn btn-default first" data-page="'+data.firstPage+'"onclick="getelist(this)">首页</span>' +
                    '<span class="btn btn-default  pre" data-page="'+data.prePage+'" onclick="getelist(this)">上一页</span>' +
                  '<span class="btn btn-default next next" data-page="'+data.nextPage+'"onclick="getelist(this)">下一页</span>' +
                   '<span class="btn btn-default last" data-page="'+data.lastPage+'" onclick="getelist(this)">尾页</span>'
                var e_html = "";

                $(".epagebtn").html(btnhtml)
                for (var i = 0; i < data.list.length; i++) {
                    if (data.list[i].type == 0) {
                        var e_time = getMyDate(data.list[i].createDate);
                        e_html += '<tr class="warning"><td>'+data.list[i].operation+'</td><td>'+e_time+'</td><td>'+data.list[i].score+'</td></tr>'

                    }
                }
                $("#e_tbody").html(e_html);
            },
            error: function (e) {
                console.log(e);
            }
        });
    }
    getelist()
    getrlist()
    function getrlist(obj) {
        var page="";
        if( $(obj).attr('data-page')!==undefined){
            page = $(obj).attr('data-page');
        }
        else(
            page=""
        )
        $.ajax({
            type: "get",
            url: "./credit/findCreditRecord.shtml",
            dataType: "json",
            async: true,
            data: {
                page: page,
                type:1
            },
            success: function (data) {

                var btnhtml = '';
                btnhtml = '<span class="btn btn-default first" data-page="'+data.firstPage+'"onclick="getrlist(this)">首页</span>' +
                    '<span class="btn btn-default  pre" data-page="'+data.prePage+'" onclick="getrlist(this)">上一页</span>' +
                    '<span class="btn btn-default next next" data-page="'+data.nextPage+'"onclick="getrlist(this)">下一页</span>' +
                    '<span class="btn btn-default last" data-page="'+data.lastPage+'" onclick="getrlist(this)">尾页</span>'
                var r_html = "";
                $(".rpagebtn").html(btnhtml)
                for (var i = 0; i < data.list.length; i++) {
                    if (data.list[i].type == 1) {
                        var r_time = getMyDate(data.list[i].createDate);
                        r_html += '<tr class="danger"><td>'+data.list[i].operation+'</td><td>'+r_time+'</td><td>'+data.list[i].score+'</td></tr>'
                    }
                }

                $("#r_tbody").html(r_html);
            },
            error: function (e) {
                console.log(e);
            }
        });
    }
    function getMyDate(str, bool) {
        if (str > 9999999999) { // 这里判断：时间戳为几位数
            var c_Date = new Date(parseInt(str));
        } else {
            var c_Date = new Date(parseInt(str) * 1000);
        }
        var c_Year = c_Date.getFullYear(),
            c_Month = c_Date.getMonth() + 1,
            c_Day = c_Date.getDate(),
            c_Hour = c_Date.getHours(),
            c_Min = c_Date.getMinutes(),
            c_Sen = c_Date.getSeconds();
        if (bool) { // 判断是否需要显示秒
            var c_Time = c_Year + '-' + getzf(c_Month) + '-' + getzf(c_Day) + ' ' + getzf(c_Hour) + ':' + getzf(c_Min) + ':' + getzf(c_Sen);//最后拼接时间
        } else {
            var c_Time = c_Year + '-' + getzf(c_Month) + '-' + getzf(c_Day) + ' ' + getzf(c_Hour) + ':' + getzf(c_Min);//最后拼接时间
        }
        return c_Time;
    };
    function getzf(c_num) {
        if (parseInt(c_num) < 10) {
            c_num = '0' + c_num;
        }
        return c_num;
    }
    function funExchange(opid){
        $.ajax({
            type: "get",
            url: "./credit/useCredit.shtml",
            dataType: "json",
            async: true,
            data: {
                opId:opid
            },
            success: function (data) {
                if (data=="success"){
                    layer.alert("兑换成功")
                } else {
                    layer.alert("兑换失败")
                }

            },
            error: function (e) {
                console.log(e);
            }
        });
    }
</script>

</html>