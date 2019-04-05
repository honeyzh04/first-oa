<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<script type="text/javascript" src="${ctx}/js/system/project/addshops.js">
</script>
	<style>
		.wrap{
			width: 1000px;
			font-size: 14px;
		}
		.inpw100{
			height: 38px;
			line-height: 38px;
			background: #fff;
			border-radius: 2px;
			margin-right: 3px;
			padding-left: 3px;
		}
		.labw130{
			float: left;
			display: block;
			padding: 9px 15px;
			width: 130px;
			margin-left: 10px;
			font-weight: 400;
			line-height: 20px;
			text-align: right;
		}
		.inpdiv190{
			float: left;
			width: 230px;
			margin-right: 50px;
		}
		.row{
			width: 100%;
			margin-bottom: 15px;
			margin-top: 20px;
			clear: both;
		}
		.selw100{
			width: 176px;
		}

		option{
			height: 38px;
			line-height: 38px;
		}
		.rowbutton{
			padding-left: 130px;
		}
		.rowbutton button{
			width: 100px;
			height: 38px;
			line-height: 38px;
			margin: 0px 10px;
			border-radius:5px;
			border: 0px;
		}
		.sum{
			text-align: right;
			margin-right: 300px;
		}


		.cover .delbtn {
			color: red;
			font-size: 20px;
			z-index: 999;

		}
		.imageDiv:hover .cover {
			display: block;
		}

	</style>

<body>
<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
<form class="" id="form" action="${ctx}/projectShops/addShops.shtml" method="get">
	<div class="wrap" id="wrap">
		<div class="row">
			<label for="" class="labw130">项目名称</label>
			<div class="inpdiv190">
				<select class="selectpicker projectName " data-style="btn-danger" data-width="170px" id="projectNamea"
						name="projectShopsFormMap.proId" data-live-search="true" title="选择项目"></select>
			</div>

			<label for="" class="labw130">商铺编号</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入商铺编号" name="projectShopsFormMap.shopNumber"></div>
		</div>

		<div class="row">

			<label for="" class="labw130">预测建筑</label>
			<div class="inpdiv190"><input type="text" class="inpw100" name="projectShopsFormMap.forecastBuilding" placeholder="请输入预测建筑">m²</div>
			<label for="" class="labw130">商铺面积</label>
			<div class="inpdiv190"><input type="text" class="inpw100" name="projectShopsFormMap.acreate" placeholder="请输入商铺面积">m²</div>
		</div>
		<div class="row">
			<label for="" class="labw130">预测公摊</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入预测公摊" name="projectShopsFormMap.forecastPublicApportionment">m²</div>
			<label for="" class="labw130">预测套内</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入预测套内" name="projectShopsFormMap.forecastSet">m²</div>

		</div>
		<div class="row">
			<label for="" class="labw130">商铺总价</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入商铺总价" name="projectShopsFormMap.totalPrice">万</div>
			<label for="" class="labw130">商铺单价</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入商铺单价" name="projectShopsFormMap.price">万</div>

		</div>
		<div class="row">
			<label for="" class="labw130">层高</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入层高" name="projectShopsFormMap.height">m</div>
			<label for="" class="labw130">开间</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入开间" name="projectShopsFormMap.opening">m</div>
		</div>

		<div class="row">
			<label for="" class="labw130">出售</label>
			<div class="inpdiv190"><select class="selw100 inpw100" name="projectShopsFormMap.sell">
				<option value="">请选择</option>
				<option value="1">待售</option>
				<option value="2">在售</option>
				<option value="3">认购</option>
				<option value="4">售罄</option>
			</select></div>
			<label for="" class="labw130">经营状态</label>
			<div class="inpdiv190"><select class="selw100 inpw100" name="projectShopsFormMap.store_status">
				<option value="">请选择</option>
				<option value="1">营业中</option>
				<option value="2">空铺</option>
			</select></div>
		</div>


		<div class="row">
			<label for="" class="labw130">是否有烟道</label>
			<div class="inpdiv190"><select class="selw100 inpw100" name="projectShopsFormMap.flue">
				<option value="">请选择</option>
				<option value="1">是</option>
				<option value="2">否</option>
			</select></div>
			<label for="" class="labw130">项目特点</label>
			<div class="inpdiv190"><select class="selw100 inpw100" name="projectShopsFormMap.trait" >
				<option value="">请选择</option>
				<option value="临街">临街</option>
				<option value="转角">转角</option>
				<option value="小区门口">小区门口</option>
				<option value="内街">内街</option>
				<option value="电梯铺">电梯铺</option>

			</select></div>
		</div>
		<div class="row">
			<label for="" class="labw130">租金</label>
			<div class="inpdiv190"><input type="text" class="inpw100" name="projectShopsFormMap.Rent" placeholder="请输入租金">元/月m²</div>
			<label for="" class="labw130">租约时间</label>
			<div class="inpdiv190"><input type="text" class="inpw100" name="projectShopsFormMap.leaseTime"  placeholder="请输入租约时间">年</div>
		</div>

		<div class="row">
			<label for="" class="labw130">口岸</label>
			<textarea id="port1" name="projectShopsFormMap.port" cols="80" rows="5" placeholder="请输入内容"
					  maxlength="500"></textarea>
			<div class="sum">已输入<span id="num">0</span>/500</div>
		</div>
		<div class="row">
			<label for="" class="labw130">描述</label>
			<textarea name="projectShopsFormMap.intro" id="" cols="80" rows="5" placeholder="请输入描述内容"></textarea>
		</div>
		<div class="row">
			<label for="" class="labw130">项目推荐</label>
			<textarea name="projectShopsFormMap.RecommendReason" id="" cols="80" rows="5" placeholder="请输入项目推荐"></textarea>
		</div>
		<div class="row rowbutton">
			<button  type="button" id="btn-test" class="btn-info submitbtn">立即提交</button> <button onclick="reset()">重置</button></div>

	</div>
</form>

</body>

<script>
    $("#btn-test").click(function(){
 /*       var port1 = $("#port1").val();
        var port=port1.replace(/\n|\r\n/g,"<br>");
        $("#port").val(port);
        console.log("das"+ $("#port").val())*/
        $(this).attr("disabled","true"); //设置变灰按钮
        $("#form").submit();//提交表单
        setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示

    })
    layui.use('laydate', function() {
        var laydate = layui.laydate;

        //自定义格式
        laydate.render({
            elem: '#leaseTime'
            , type: 'datetime'
        });
    });
    $(document).ready(function () {
        getprojectName()
    });
    function wordStatic(input) {
        // 获取要显示已经输入字数文本框对象
        var content = document.getElementById('num');
        if (content && input) {
            // 获取输入框输入内容长度并更新到界面
            var value = input.value;
            // 将换行符不计算为单词数
            value = value.replace(/\n|\r/gi, "");
            // 更新计数
            content.innerText = value.length;
        }
    }
    //查看项目
    function getprojectName() {
        $.ajax({
            "url": "../projectShops/getProject.shtml",
            "data": "",
            "type": "GET",
            "dataType": "json",
            "success": function (obj) {
                $("#projectNamea").html("<option value=''> - - - -选择项目- - - - </option>");
                for (var i = 0; i < obj.length; i++) {
                    var str = "<option value=" + obj[i].id + ">" + obj[i].projectName + "</option>";
                    $("#projectNamea").append(str);

                }
                $('.projectName').selectpicker('refresh');
                $('.projectName').selectpicker('render');

            },
            error: function () {
                layer.alert("获取项目出错！请与管理员联系");
            }
        });
    }
    function reset(){
        $("#wrap input").val("");
    }



</script>

</html>