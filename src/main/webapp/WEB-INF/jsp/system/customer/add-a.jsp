<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/customer/add-a.js"> 
	
</script>

		<meta charset="UTF-8">
		<title></title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	
	
		<!--layuidate-->
		<!-- 		<link rel="stylesheet" href="js/layui-date/css/layui.css" media="all"> -->
		<style type="text/css">
			html,body{margin:0;padding:0;overflow-x:hidden;}
			.mt20 {
				margin-top: 20px;
			}
			
			.border{
				height: 100%;
				border-left: 2px solid #ccc;
			}
			
			select {
				width: 170px;
				padding: 3px 0;
			}
			
			input {
				padding: 3px 0 ;
				text-align:center;
			}
			.ml{
				margin-left: 5%;
			}
			.description{
				width: 50%;
			}
			.followa{
				width: 50%;
				height: 80px;
			}
			.fz{
			   font-size:18px;
			   font-weight:bold;
			}
			.zero{
						height:80px;
			}
			
		</style>
	</head>

	<body>
		<!--form-horizontal-->
			<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
			<form id="form" name="form" class="form-horizontal" method="post"
			action="./customer/addEntity.shtml">
			<input type="hidden" class="form-control checkacc"
			value="${user.id}" name="customerFormMap.userId" id="userId">
			<input type="hidden" class="form-control checkacc"
			value="${user.accountName}" name="customerFormMap.accountName" id="accountName">
			<input type="hidden" class="form-control checkacc"
			value="${user.department}" name="customerFormMap.department" id="department">
			<input type="hidden" class="form-control checkacc"
			value="1" name="customerFormMap.resources" id="resources">
			<input type="hidden" class="form-control checkacc"
			value="0" name="customerFormMap.trackremind" id="trackremind">
			<div class="row">

				<div class="col-sm-4  left-add mt20">
					<div class="ml">
						<p class="fz">客户基本信息：</p>
						<div class="form-group mt20">
							<label for="">客户姓名：</label>
							<input type="text" class="input" id="customerName" name="customerFormMap.customerName" placeholder="请输入姓名" value="">
						</div>

						<div class="form-group">
							<label for="">电话号码：</label>
							<input type="tel" class="input" id="telephone" name="customerFormMap.telephone" placeholder="请输入电话" value="">
						</div>
						
						<div class="form-group">
							<label for="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：</label>
							<input type="radio" class="" id="man" name="customerFormMap.gender" checked="checked" value="1">&nbsp;&nbsp;&nbsp;男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" class="" id="woman" name="customerFormMap.gender" value="2">&nbsp;&nbsp;&nbsp;女
						</div>
						<div class="form-group">
							<label for="">信息来源：</label>
							<select name="customerFormMap.cusource" id="cusource"  onchange="getCusource(this)">
								<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择</option>
								<option value="9">主动T客户</option>
								<option value="1">网络（安居客端口）</option>
								<option value="2">网络（58同城端口）</option>
								<option value="3">网络（房发现端口）</option>
								<option value="4">网络（安居客供客）</option>
								<option value="5">网络（58同城供客）</option>
								<option value="6">网络（房发现供客）</option>
								<option value="7">自身（打街霸）</option>
								<option value="8">自身（朋友推荐）</option>
								<option value="0">其他</option>
							</select>
						</div>
						<div class="form-group" style="display: none;" id="ffxccusources" >
							<label for="">具体来源：</label>
							<select name="customerFormMap.ffxcusource" id="ffxccusource" >
								<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择</option>
								<option value="1">百度商桥</option>
								<option value="2">百度推广电话</option>
								<option value="3">房发现电话</option>
								<option value="4">房发现微聊</option>
								<option value="5">信息流</option>
								<option value="6">搜狗神马</option>
								<option value="7">离线宝</option>
								<option value="8">公众号</option>
								<option value="9">其他途径</option>

							</select>
						</div>
						<div class="form-group">
							<label for="">&nbsp;&nbsp;&nbsp;市场部：</label>
							<input type="text" id="" value="${user.departmentName}"  name="customerFormMap.departmentName" readonly="readonly" style="text-align: center;"/>
						</div>
						<div class="form-group">
							<label for="">投资顾问：</label>
							<input type="text" id="" value="${user.userName}"  name="customerFormMap.userName" readonly="readonly" style="text-align: center;"/>
						</div>
						<div class="form-group">
					        <label>登记时间：</label>
					        <input type="text"  value="${user.creatDate}" readonly="readonly">
						</div>
				</div>
				</div>
				<div class="right-add col-sm-7 mt20 border">
					<div class="">
					   <p  class="fz">客户跟进信息：</p>
					   <div class="form-group mt20">
					   	   <label for="" class="ml">预算总价：</label>
					   	   <input type="text" class="input" id="totalPrice" name="customerFormMap.totalPrice" placeholder="请输入预算总价" value="">万
						
					   </div>
					   <div class="form-group">
							<label for="" class="ml">购买用途：</label>
							<select name="customerFormMap.purpose">
								<option  value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择</option>
								<option value="1">投资</option>
								<option value="2">自用</option>
							</select>
						</div>
						<div class="form-group">
							<label for="" class="ml">投资意向：</label>
							<select name="customerFormMap.intention">
								<option  value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择</option>
								<option value="1">A类客户</option>
								<option value="2">B类客户</option>
								<option value="3">C类客户</option>
							</select>
						</div>
						<div class="form-group">
							<label for="" class="ml">购买方向：</label>
							<select name="customerFormMap.apartment">
								<option  value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择</option>
								<option value="1">商铺</option>
								<option value="2">公寓</option>
							</select>
						</div>
					<!-- 	<div class="form-group">
							<label for="" class="ml">需求备注：</label>
							<textarea  style="resize:none"  name="customerFormMap.description" rows="3" cols="80" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"  placeholder="请输入跟进内容"></textarea>
						</div> -->
						<div class="form-group">
							<label for="" class="ml">跟进情况：</label>
							<textarea 	style="resize:none"  id="contenta" name="customerFormMap.content" rows="6" cols="80" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"  placeholder="请输入跟进内容"></textarea>
						</div>
					<!-- 	<div class="form-group">
							<div class="layui-inline col-sm-12 col-xs-12">
						      <label class="ml">下次跟进：</label>
						      <div class="layui-input-inline">
						        <input type="text" class="layui-input test-item" id="" placeholder="dd/MM/yyyy" name="customerFormMap.accountName">
						      </div>
						    </div>
					
						</div> -->
						<div class="form-group">
							<label for="" class="ml">跟进方式：</label>
							<input type="radio" class="" id="" name="customerFormMap.communicate" checked="checked" value="1">&nbsp;&nbsp;&nbsp;电话 &nbsp;&nbsp;
							<input type="radio" class="" id="" name="customerFormMap.communicate"  value="2">&nbsp;&nbsp;&nbsp;网络 &nbsp;&nbsp;
							<input type="radio" class="" id="" name="customerFormMap.communicate"  value="3">&nbsp;&nbsp;&nbsp;其他 &nbsp;&nbsp;
						</div>
						<div class="form-group">
							<label for="" class="ml">跟进状态：</label>
							<input type="radio" class="" id="" name="customerFormMap.state" checked="checked" value="1">&nbsp;&nbsp;&nbsp;常规跟进 &nbsp;&nbsp;
						</div>
						<div class="zero"></div>
						<div class="form-group clearfix">
							<button  type="button" id="btn-test"  class="btn btn-info pull-right" >保存 &nbsp;&nbsp;<span class="glyphicon glyphicon-save-file" aria-hidden="true"></span></button>
						</div> 
						
				   </div>
				</div>
				
			</div>
			<!--最外层-->		
		</form>


		<!-- <script src="../layui-date/layui.js" charset="utf-8"></script> -->
		
		<script type="text/javascript">
		$("#btn-test").click(function(){
			 
		    $(this).attr("disabled","true"); //设置变灰按钮
		    $("#form").submit();//提交表单
		    setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示
		     
		});
		$(function() {

			function today(){
			    var today=new Date();
			    var h=today.getFullYear();
			    var m=today.getMonth()+1;
			    var d=today.getDate();
			    var t=today.getHours();
			    var s=today.getMinutes();
			    return h+"-"+m+"-"+d+"-"+t+":"+s;
			}
			 
			document.getElementById("today").value = today();
			
		
		});
        function getCusource(obj){
            var a = $(obj).find('option:selected').val();
            console.log("asd"+ a);
            if(a==3||a==6){
                $("#ffxccusources").show();
                console.log("as5");
            }else {
                $("#ffxccusources").hide();
            }
        }
		</script>

	<!-- 	
		<script>
			layui.use('laydate', function() {
				var laydate = layui.laydate;
				
				//同时绑定多个
			  lay('.test-item').each(function(){
			    laydate.render({
			      elem: this
			      ,trigger: 'click'
			    });
			  });
				
				//自定义格式
			  laydate.render({
			    elem: '#test11'
			    ,format: 'yyyy年MM月dd日'
			  });

			});
		</script> -->
	</body>

</html>