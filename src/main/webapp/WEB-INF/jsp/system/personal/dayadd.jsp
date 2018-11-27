<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/common/common.jspf" %>
    <script type="text/javascript" src="${ctx}/js/system/personal/dayadd.js"></script>

    <style type="text/css">
        .from-con {
            width: 30%;
            height: 30px;
            text-align: center;
            margin-right: 2%;
            margin-top: 2%;
            display:inline;
        }

        .fz {
            font-size: 18px;
            font-weight: bold;
        }

        .mt10 {
            margin-top: 10px;
            margin-right: 10px;
        }
        #zs{
            margin-top: 50px;
        }
    </style>
</head>
<body>

<div class="msg">

    <form id="form" name="form" class="form-preparation" method="post"
          action="${ctx}/personal/dayadd.shtml">
        <section class="panel panel-default">
            <input type="hidden" class="form-control checkacc" id="type"
                   value="dayadd" name="personalFormMap.type">
            <div class="modal-body" style="margin-bottom:180px">
                <p class="fz">日目标：</p>
                <div class="l_err" style="width: 100%; margin-top: 2px;"></div>
                <div class="text-center">
                    <label>销售精英：</label>
                    <input type="text" class="from-con form-control checkacc" name="personalFormMap.userName" id="userName"
                           value="${userName}" readonly="readonly"/>
                    <label>计划时间：</label>
                    <input type="text" class="from-con test-item form-control" name="personalFormMap.createDate" value=""
                           id="createDate">
                    <label>计划新增：</label>
                    <input type="text"class="form-control checkacc from-con" name="personalFormMap.add" id="add" value="" placeholder="录入新增目标"/>
                    <label>计划到访：</label>
                    <input type="text"  class="form-control checkacc from-con " name="personalFormMap.visit" id="visit" value="" placeholder="录入到访数量"/>
                    <label style="">计划到访项目：</label>
                    <input  style="width: 73%;"type="text"   class="form-control checkacc from-con " name="personalFormMap.visitproject" id="visitproject" value="" placeholder="录入到访项目，用逗号隔开"/>
                </div>

                <div id="zs"> 友情提示：目标制定确认后不可更改，请谨慎合理制定！</div>
            </div>

            <button type="button" id="btn-test" class="btn btn-primary pull-right mt10">确定</button>
        </section>
    </form>
</div>


<script>
    //页面加载完成执行
    $("#btn-test").click(function(){

        $(this).attr("disabled","true"); //设置变灰按钮
        $("#form").submit();//提交表单
        setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示

    })

    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //同时绑定多个
        lay('.test-item').each(function () {
            laydate.render({
                elem: this,

                trigger: 'click'
                , min: 0 //7天前
                , max: 7 //7天后
            });
        });


    });
</script>

</body>
</html>
