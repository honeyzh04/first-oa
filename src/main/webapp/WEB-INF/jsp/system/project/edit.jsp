<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<html>
<head>
<script type="text/javascript" src="${ctx}/js/system/project/add.js"> 
</script>
 	<style type="text/css">
			
			.inpuText {
				width: 200px;
				height: 28px;
			}
			
			.box {
				width: 1020px;
				height: auto;
			}
			
			.text1 {
				text-indent: 1em;
			}
			.mt10{
				margin-top: 10px;
			}
			.mt30{
				margin-top: 30px;
			}
			span{
				width: 120px;
				height: auto;
				display: inline-block;
				justify-content: space-between;
			}
			.border-bottom{
				width: 200px;
				height: 30px;
				border-bottom: 1px solid #212121;
			}
		</style>
	</head>
	<body>
	<form id="form" name="form" class="form-horizontal" method="post"
			action="${ctx}/project/addEntity.shtml">
		<div class="container mt30">
			<div class="row mt10">
				<div class="col-md-6">
					<span>项目名：</span>
					<input class="inpuText text1" type="text" id="" value="" name="projectFormMap.projectName" placeholder="请输入项目名" />
				</div>
				<div class="col-md-6">
					<span class="pad77">佣金：</span>
					<input class="inpuText" type="text" id="" name="projectFormMap.commission" value="" />
				</div>
			</div>
			<div class="row mt10">
				<div class="col-md-6">
					<span>项目联系人：</span>
					<input class="inpuText" type="text" id="" name="projectFormMap.projectPerson" value="" />
				</div>
				<div class="col-md-6">
					<span class="pad15">菲斯特联系人：</span>
					<input class="inpuText" type="text" id="" name="projectFormMap.firstPerson" value="" />
				</div>
			</div>
			<div class="row mt10">
				<div class="col-md-6">
					<span>项目联系人电话：</span>
					<input class="inpuText" type="text" id="" name="projectFormMap.projectTelephone" value="" />
				</div>
				<div class="col-md-6">
					<span>项目位置：</span>
					<select id="s_province" name="s_province"></select>

					<select id="s_city" name="s_city"></select>

					<select id="s_county" name="s_county"></select>
					<input type="hidden" id="" value="" />

					<div id="show"></div>
					<span class="mt10">具体位置：</span>
				    <input class="inpuText" type="text" id="" name="projectFormMap.projectPosition" value=""  />
				</div>
			</div>
			<div class="row mt10">
				<div class="col-md-6">
					<span>租约：</span>
					<input type="radio" name="projectFormMap.lease" id="" value="1" />&nbsp;带租约
					<input type="radio" name="projectFormMap.lease" id="" value="2" />&nbsp;不带租约
				</div>
				<div class="col-md-6">
					<span class="pad60">状态：</span>
					<input type="radio" name="projectFormMap.state" id="" value="1" />&nbsp;待售
					<input type="radio" name="projectFormMap.state" id="" value="2" />&nbsp;在售
					<input type="radio" name="projectFormMap.state" id="" value="3" />&nbsp;售罄
				</div>
			</div>
			<div class="row mt10">
				<div class="col-md-6">
					<span>项目区域：</span>
					<input type="radio" name="projectFormMap.region" id="" value="" />&nbsp;东区
					<input type="radio" name="projectFormMap.region" id="" value="" />&nbsp;西区
					<input type="radio" name="projectFormMap.region" id="" value="" />&nbsp;北区
					<input type="radio" name="projectFormMap.region" id="" value="" />&nbsp;南区
				</div>
				<div class="col-md-6">
					<span>项目类型：</span>
					<input type="radio" name="projectFormMap.type" id="" value="" />&nbsp;商铺
					<input type="radio" name="projectFormMap.type" id="" value="" />&nbsp;公寓
					<input type="radio" name="projectFormMap.type" id="" value="" />&nbsp;写字楼
				</div>
			</div>
			<div class="row mt10">
				<div class="col-md-12">
					<span>面积：</span>
					<input class="inpuText" type="text" id="" name="projectFormMap.areas" value="" />---<input class="inpuText" type="text" id="" name="projectFormMap.areae" value="" /> ㎡
				</div>
			</div>
			<div class="row mt10">
				<div class="col-md-12">
					<span>单价：</span>
					<input class="inpuText" type="text" id="" name="projectFormMap.prices" value="" />---<input class="inpuText" type="text" id="" name="projectFormMap.pricee" value="" /> 元
				</div>
			</div>
			<div class="row mt10">
				<div class="col-md-12">
					<span>总价：</span>
					<input class="inpuText" type="text" id="" name="projectFormMap.pricess" value="" />---<input class="inpuText" type="text" id="" name="projectFormMap.pricese" value="" /> 万元
				</div>
			</div>
			<div class="row mt10">
				<div class="col-md-12">
					<p>项目描述：</p>
					<textarea style="resize:none" id="contenta" class="checkacc" name="customerFormMap.content" rows="10" cols="120" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5" placeholder="请输入跟进内容"></textarea>
		
				</div>
			</div>
				
		</div>
			<div class="form-group clearfix">
							<button  type="button" id="btn-test" class="btn btn-info pull-right">保存 &nbsp;&nbsp;<span class="glyphicon glyphicon-save-file" aria-hidden="true"></span></button>
						</div>


		
		</form>
	<script type="text/javascript" src="${ctx}/js/system/project/area.js"> 
	</script>
		<script type="text/javascript">
			_init_area();
			
			$("#btn-test").click(function(){
				 
			    $(this).attr("disabled","true"); //设置变灰按钮
			    $("#form").submit();//提交表单
			    setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示
			     
			})
		
		</script>
		<script type="text/javascript">
			//console.log($("#s_province").text()) ;
			//console.log($("#s_city").text());
			//console.log($("#s_county").val());
			//var a = $("#s_province option:selected").val();
			//console.log(a)

			var Gid = document.getElementById;

			var showArea = function() {

				Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" +

					Gid('s_city').value + " - 县/区" +

					Gid('s_county').value + "</h3>"

			}

			//			Gid('s_county').setAttribute('onchange', 'showArea()');
		</script>

	</body>

</html>