<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<script type="text/javascript" src="${ctx}/js/system/project/addapartment.js">
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
<form class="" id="form" action="${ctx}/project/editApartment.shtml" method="get">
	<div class="wrap" id="wrap">
		<input type="hidden"  name="projectFormMap.id" value="${apartment.id}" />
		<div class="row">
			<label for="" class="labw130">项目名称</label>
			<div class="inpdiv190"><input type="text" class="inpw100"  readonly="readonly"  name="projectFormMap. projectName" value="${apartment.projectName}"></div>
			<label for="" class="labw130">栋</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入栋"
										  name="projectFormMap.building" value="${apartment.building}"></div>
		</div>

		<div class="row">

			<label for="" class="labw130">层</label>
			<div class="inpdiv190"><input type="text" class="inpw100" name="projectFormMap.floor"
										  placeholder="请输入在哪一层" value="${apartment.floor}">m²</div>
			<label for="" class="labw130">房间编号</label>
			<div class="inpdiv190"><input type="text" class="inpw100" name="projectFormMap.roomNo" placeholder="请输入房间编号" value="${apartment.roomNo}">
			</div>
		</div>
		<div class="row">
			<label for="" class="labw130">性质</label>
			<input type="hidden" id="nature" value="${apartment.nature}"/>
			<div class="inpdiv190">
				<select class="selw100 inpw100" id="natures" name="projectFormMap.nature">
					<option value="">请选择</option>
					<option value="1">商用</option>
					<option value="2">自用</option>
				</select>
			</div>
			<label for="" class="labw130">出售</label>
			<input type="hidden" id="sell" value="${apartment.sell}"/>
			<select class="selw100 inpw100" id="shells"name="projectFormMap.sell">
				<option value="">请选择</option>
				<option value="1">待售</option>
				<option value="2">在售</option>
				<option value="3">认购</option>
				<option value="4">售罄</option>
			</select>

		</div>
		<div class="row">
			<label for="" class="labw130">建面</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入建面 "
										  name="projectFormMap.noodles" value="${apartment.noodles}">m²</div>
			<label for="" class="labw130">惊爆折扣</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入惊爆折扣" name="projectFormMap.shockDiscount" value="${apartment.shockDiscount}">
			</div>

		</div>
		<div class="row">
			<label for="" class="labw130">原总价</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入原总价" name="projectFormMap.originalPrice" value="${apartment.originalPrice}">万
			</div>
			<label for="" class="labw130">原单价</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入原单价" name="projectFormMap.originalUnitPrice" value="${apartment.originalUnitPrice}">万
			</div>
		</div>

		<div class="row">
			<label for="" class="labw130">现总价</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入现总价" name="projectFormMap.currentPrice" value="${apartment.currentPrice}">万
			</div>
			<label for="" class="labw130">现单价</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入现单价" name="projectFormMap.currentUnitPrice" value="${apartment.currentUnitPrice}">万
			</div>
		</div>

		<div class="row">
			<label for="" class="labw130">折扣低价</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入折扣低价" name="projectFormMap.discountLowPrice" value="${apartment.discountLowPrice}">万
			</div>
			<label for="" class="labw130">折扣单价</label>
			<div class="inpdiv190"><input type="text" class="inpw100" placeholder="请输入折扣单价" name="projectFormMap.discountUnitPrice" value="${apartment.discountUnitPrice}">万
			</div>
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
    $(document).ready(function () {


        var sell = $("#sell").val();
        var nature = $("#nature").val();

        //根据值让option选中
        $("#sells option[value='" + sell + "']").attr("selected", "selected");
        $("#natures option[value='" + nature + "']").attr("selected", "selected");




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

    function reset() {
        $("#wrap input").val("");
    }



</script>

</html>