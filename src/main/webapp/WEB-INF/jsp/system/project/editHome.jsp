<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<script type="text/javascript" src="${ctx}/js/system/project/addhome.js">
	</script>
	<style>
		.wrap {
			width: 1000px;
			font-size: 14px;
		}
		.inpw100 {
			height: 38px;
			line-height: 38px;
			background: #fff;
			border-radius: 2px;
			margin-right: 3px;
			padding-left: 3px;
		}
		.labw130 {
			float: left;
			display: block;
			padding: 9px 15px;
			width: 130px;
			margin-left: 10px;
			font-weight: 400;
			line-height: 20px;
			text-align: right;
		}
		.inpdiv190 {
			float: left;
			width: 230px;
			margin-right: 50px;
		}
		.row {
			width: 100%;
			margin-bottom: 15px;
			margin-top: 20px;
			clear: both;
		}
		.selw100 {
			width: 176px;
		}

		option {
			height: 38px;
			line-height: 38px;
		}
		.rowbutton button {
			width: 100px;
			height: 38px;
			line-height: 38px;
			margin: 0px 10px;
			border-radius: 5px;
			border: 0px;
		}

	</style>

<body>
<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
<form class="" id="form" action="${ctx}/projectHome/editHome.shtml" method="get">
	<div class="wrap" id="wrap">
		<div class="row">
			<input type="hidden"  name="projectHomeFormMap.id" value="${home.id}" />
			<label for="" class="labw130">项目名称</label>
			<div class="inpdiv190">
				<div class="inpdiv190"><input type="text" class="inpw100"  readonly="readonly"  name="projectHomeFormMap. projectName" value="${home.projectName}"></div>
			</div>
			<label for="building" class="labw130">栋</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入栋号" id="building"  name="projectHomeFormMap.building" value="${home.building}"></div>
		</div>

		<div class="row">

			<label for="" class="labw130">层</label>
			<div class="inpdiv190"><input type="text" class="inpw100" name="projectHomeFormMap.floor"
										  placeholder="请输入层号" value="${home.floor}">m²</div>
			<label for="" class="labw130">房间编号</label>
			<div class="inpdiv190"><input type="text" class="inpw100" name="projectHomeFormMap.roomNo" placeholder="请输入房间编号" value="${home.roomNo}">
			</div>
		</div>
		<div class="row">
			<label for="" class="labw130">建面</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入房间面积"
										  name="projectHomeFormMap.area" value="${home.area}">m²</div>
			<label for="" class="labw130">出售</label>
			<input type="hidden" id="sell" value="${apartment.sell}"/>
			<select class="selw100 inpw100" id="sells" name="projectHomeFormMap.sell">
				<option value="">请选择</option>
				<option value="1">待售</option>
				<option value="2">在售</option>
				<option value="3">认购</option>
				<option value="4">售罄</option>
			</select>

		</div>
		<div class="row">
			<label for="" class="labw130">价格</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入价格"
										  name="projectHomeFormMap.price" value="${home.price}">万</div>
		</div>
		<div class="row rowbutton">
			<button  type="button" id="btn-test" class="btn-info submitbtn">立即提交</button></div>
	</div>
</form>

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
    $(document).ready(function () {
        var sell = $("#sell").val();
        //根据值让option选中
        $("#sells option[value='" + sell + "']").attr("selected", "selected");
    });




</script>
</html>
