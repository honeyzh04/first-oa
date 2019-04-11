<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<script type="text/javascript" src="${ctx}/js/system/statistics/add.js">
</script>

        <style>
            input{text-align:center;}
        .wrap {
            width:800px;
            text-align: center;
            /* overflow: hidden; */
            padding-top: 30px;
        }
            .wrap  .timediv{
                width: 40%;
                padding: 10px 10px;
                font-size: 14px;
                color: #333;
                margin-left: 10%
            }
        .wrap .floatl{
            width: 40%;
            display: inline-block;
            padding: 10px 10px;
            font-size: 14px;
            color: #333;
        }
        .wrap div input{
            outline: 1px  #999;
            width: 170px;
            height: 25px;
            margin-left: 5px
        }
        .wrap label{
            width: 80px ;
            text-align: right;
        }
        .wrap button{
            width: 250px;
            height: 35px;
            background:rgb(0, 159, 149);
            color: #fff;
            border: 0px;
			margin: 75px 275.5px;
        }
        .cjprice{
            display: block !important;
            margin-left: 98px;
        }
        </style>
        <head>
        <body>
        <div class="l_err" style="width: 100%; margin-top: 2px;"></div>
        <form id="form" name="form" class="form-horizontal" method="post"
        action="${ctx}/statistics/addEntity.shtml">
            <div class="wrap">
            <div class="timediv">
            <label for="time">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间:</label>
        <input type="text" name="statisticsFormMap.createDate" id="createDate" >
            </div>
            <div class="floatl">
            <label for="time">&nbsp;&nbsp;百度搜索推广价格:</label>
        <input type="text" class="baiduprice"   name="statisticsFormMap.baiduss_price"id="baidussprice">
            </div>
            <div class="floatl">
            <label for="time">&nbsp;&nbsp;百度搜索推广点击:</label>
        <input type="text" class="baiduclick"   name="statisticsFormMap.baiduss_click" id="baidussclick">
            </div>
                <div class="floatl">
                    <label for="time">&nbsp;&nbsp;百度信息流价格:</label>
                    <input type="text" class="baiduprice"   name="statisticsFormMap.baiduxxl_price"id="baiduxxlprice">
                </div>
                <div class="floatl">
                    <label for="time">&nbsp;&nbsp;百度信息流点击:</label>
                    <input type="text" class="baiduclick"   name="statisticsFormMap.baiduxxl_click" id="baiduxxlclick">
                </div>
            <div class="floatl">
            <label for="time">&nbsp;&nbsp;搜狗价格:</label>
        <input type="text" class="baiduprice"   name="statisticsFormMap.sougou_price" id="sougouprice">
            </div>
            <div class="floatl">
            <label for="time">&nbsp;&nbsp;搜狗点击:</label>
        <input type="text" class="baiduprice"  name="statisticsFormMap.sougou_click"  id="sougouclick">
            </div>
            <div class="floatl">
                <label for="time">&nbsp;&nbsp;神马价格:</label>
        <input type="text" class="baiduprice"  name="statisticsFormMap.shenma_price" id="shenmaprice">
            </div>
            <div class="floatl">
            <label for="time">&nbsp;&nbsp;神马点击:</label>
        <input type="text" class="baiduprice"  name="statisticsFormMap.shenma_click" id="shenmaclick">
            </div>
                <div class="floatl">
                    <label >&nbsp;&nbsp;360价格:</label>
                    <input type="text" class="baiduprice"  name="statisticsFormMap.sanliuning_price" id="sanliuningprice">
                </div>
                <div class="floatl">
                    <label >&nbsp;&nbsp;360点击:</label>
                    <input type="text" class="baiduprice"  name="statisticsFormMap.sanliuning_click" id="sanliuningclick">
                </div>
                <div class="floatl">
                    <label >新媒体价格:</label>
                    <input type="text" class="baiduprice"  name="statisticsFormMap.newmedia_price" id="newmediaprice">
                </div>
                <div class="floatl">
                    <label >新媒体点击:</label>
                    <input type="text" class="baiduprice"  name="statisticsFormMap.newmedia_click" id="newmediaclick">
                </div>
            <div class="form-group clearfix">
            <button  type="button" id="btn-test" class="btn btn-info pull-right">保存</button>
            </div>
            </div>
            </form>

		<script type="text/javascript">

            layui.use('laydate', function() {

                var laydate = layui.laydate;
            laydate.render({
                elem : "#createDate",
                trigger : 'click',
                type : 'date',
                theme : '#FF0000',
                min : -7,
                max : 0
                ,isInitValue: true
                ,done: function(value, date, endDate){
                    console.log(value);
                    find();
                }


            });

            });
          /*  function find() {

                var createDate = $("#createDate").val();

                console.log("que" + createDate);

                $.ajax({
                    "url" : "../statistics/addOther.shtml",
                    "data" : {
                        createDate : createDate,

                    },
                    "type" : "GET",
                    "dataType" : "json",
                    "success" : function(obj) {
                        console.log("fa"+obj);


                        console.log(obj.alls);
                        $("#addAll").val(obj.alls);
                        $("#viscu").val(obj.vis);
                        $("#deacu").val(obj.dea);
                        $("#commission").val(obj.commission);
                        $("#deaprice").val(obj.price);
                        $("#deaproject").val(obj.projectName);




                    },
                    error : function() {
                        alert("请与管理员联系");
                    }
                });

            }; */
			
			    $("#btn-test").click(function(){
				 
			    $(this).attr("disabled","true"); //设置变灰按钮
			    $("#form").submit();//提交表单
			    setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示
			     
			});
	

		</script>


	</body>

</html>