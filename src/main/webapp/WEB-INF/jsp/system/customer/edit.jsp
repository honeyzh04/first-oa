<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>


<script type="text/javascript" src="${ctx}/js/system/customer/edit.js"></script>
<style type="text/css">
			html,
			body {
				margin: 0;
				padding: 0;
				overflow-x: hidden;
			}
			
			.mt20 {
				margin-top: 20px;
			}
			
			.border {
				height: 100%;
				border-left: 2px solid #ccc;
			}
			
			select {
				width: 170px;
				padding: 3px 0;
				
			}
			
			input {
				padding: 3px 0;
				text-align:center;
			}
			
			.ml {
				margin-left: 5%;
			}
			
			.description {
				width: 50%;
				height: auto;
			}
			
			.followa {
				width: 50%;
				height: auto;
				font-weight: b;
			}
			.fz{
				font-size: 18px;
				font-weight: bold;
			}
			.save-btn{
			  position:relative;
			}
			.saveBtn{
			  position:absolute;
			  top: 690px;
			  left:900px;
			}
			.ml50{
			   margin-left:28px;
			}.ml70{
			   margin-left:12px;
			}
		</style>
	</head>

	
	<body>
		<!--form-horizontal-->
			<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
			<form id="form" name="form" class="form-horizontal" method="post" 
			action="${ctx}/customer/editEntity.shtml">
			<input type="hidden" class="form-control checkacc"
			value="${customer.id}" name="customerFormMap.id" id="customerId">
			<input type="hidden" class="form-control checkacc"
			value="${customer.userId}" name="customerFormMap.userId" id="userId">
			<input type="hidden" class="form-control checkacc"
			value="${customer.department}" name="customerFormMap.department" id="department">
			<input type="hidden" class="form-control checkacc"
			value="1" name="customerFormMap.resources" id="resources">
			<input type="hidden" class="form-control checkacc"
			value="1" name="customerFormMap.trackremind" id="trackremind">
			<div class="row">

				<div class="col-sm-4  left-add mt20">
					<div class="ml">
						<p class="fz">客户基本信息：</p>
						<div class="form-group mt20">
							<label for="">客户姓名：</label>
							<input type="text" class="input" id="customerName" name="customerFormMap.customerName" placeholder="请输入姓名" value="${customer.customerName}">
						</div>

						<div class="form-group">
							<label for="">电话号码：</label>
							<input type="tel" class="input" id="telephone" name="customerFormMap.telephone" placeholder="请输入电话" value="${customer.telephone}">
						</div>
						
						<div class="form-group">
							 <input type="hidden" id ="selectGender" value="${customer.gender}"/>
							<label for="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：</label>
							<input type="radio" class="" id="man" name="customerFormMap.gender"  value="1">&nbsp;&nbsp;&nbsp;男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" class="" id="woman" name="customerFormMap.gender" value="2">&nbsp;&nbsp;&nbsp;女
						</div>
						<div class="form-group">
							<label for="">信息来源：</label>
							  <input type="hidden" id ="selectCusource" value="${customer.cusource}"/>
							<select name="customerFormMap.cusource"  id="cusource">
							<%--   <c:forEach items="${refundReasonList后台传来的键值对集合}" var="each">
          							  <option value="${each.dataKey}">${each.dataValue}</option>
      															  </c:forEach> --%>
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
						<div class="form-group">
							<label for="">&nbsp;&nbsp;&nbsp;市场部：</label>
							<input type="text" id="" value="${customer.departmentName}"  name="customerFormMap.departmentName" readonly="readonly" style="text-align: center;"/>
						</div>
						<div class="form-group">
							<label for="">投资顾问：</label>
							<input type="text" id="" value="${customer.userName}"  name="customerFormMap.userName" readonly="readonly" style="text-align: center;"/>
						</div>
						<div class="form-group">
					        <label>登记时间：</label>
					        <input type="text" id="today" name="date" readonly="readonly">
						</div>
				</div>
				</div>
				<div class="right-add col-sm-7 mt20 border">
					<div class="">
					   <p  class="fz">客户跟进信息：</p>
					   <div class="form-group mt20">
					   	   <label for="" class="ml">预算总价：</label>
					   	   <input type="text" class="input" id="totalPrice" name="customerFormMap.totalPrice" placeholder="请输入预算总价" value="${customer.totalPrice}">万
						
					   </div>
					   <div class="form-group">
							<label for="" class="ml">购买用途：</label>
							 <input type="hidden" id ="selectPurpose" value="${customer.purpose}"/>
							<select name="customerFormMap.purpose" id="purpose">
								<option  value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择</option>
								<option value="1">投资</option>
								<option value="2">自用</option>
							</select>
						</div>
						<div class="form-group">
							<label for="" class="ml">投资意向：</label>
							 <input type="hidden" id ="selectIntention" value="${customer.intention}"/>
							<select name="customerFormMap.intention" id="intention">
								<option  value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择</option>
								<option value="1">A类客户</option>
								<option value="2">B类客户</option>
								<option value="3">C类客户</option>
						
							</select>
						</div>
						<div class="form-group">
							<label for="" class="ml">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;房源：</label>
							 <input type="hidden" id ="selectApartment" value="${customer.apartment}"/>
								<select name="customerFormMap.apartment" id="apartment">
								<option  value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择</option>
								<option value="1">商铺</option>
								<option value="2">公寓</option>
							</select>
						</div>
						<%-- <div class="form-group">
							<label for="" class="ml">需求备注：</label>
							<textarea  style="resize:none"  name="customerFormMap.description"rows="3" cols="60" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"  placeholder="请输入跟进内容">${customer.description}</textarea>
						</div> --%>
						<div class="form-group">
							<label for="" class="ml">跟进历史：</label>
							<textarea readonly  	style="resize:none"   name=""    rows="6" cols="60" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"  placeholder="请输入跟进内容">${customer.content}</textarea>
						</div>
						<div class="form-group">
							<label for="" class="ml">跟进情况：</label>
							<textarea 	id="contenta"  style="resize:none" class="{required:true}"  name="customerFormMap.content" rows="6" cols="60" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"  placeholder="请输入跟进内容"></textarea>
						</div>
						
						<div class="form-group">
							
								
						<div class="content-msg mt20 ml50">
								<label>跟进预约：</label>
								    <input type="text" value="" class=" test-item" id="" placeholder="跟进需求选择" name="customerFormMap.ntrackDate">
								
							</div>
						
						<!-- 	<div class="layui-inline col-sm-12 col-xs-12 mt20">
								<label class="ml">预约时间：</label>
								<div class="layui-input-inline">
									<input type="text" class="layui-input test-item" id="" placeholder="dd/MM/yyyy">
								</div>
							</div> -->
						</div> 
						<div class="form-group">
							 <input type="hidden" id ="selectCommunicate" value="${customer.communicate}"/>
							<label for="" class="ml">跟进方式：</label>
							<input type="radio" class="" id="" name="customerFormMap.communicate" value="1">&nbsp;&nbsp;&nbsp;电话 &nbsp;&nbsp;
							<input type="radio" class="" id="" name="customerFormMap.communicate" value="2">&nbsp;&nbsp;&nbsp;网络 &nbsp;&nbsp;
							<input type="radio" class="" id="" name="customerFormMap.communicate" value="3">&nbsp;&nbsp;&nbsp;其他 &nbsp;&nbsp;
						</div>
						<div class="form-group">
						<input type="hidden" id ="selectState" value="${customer.state}"/>
							<label for="" class="ml">跟进状态：</label>
							<!--<input type="radio" class="" id="" name="" checked="checked" value="1">&nbsp;&nbsp;&nbsp;常规跟进 &nbsp;&nbsp;-->
							<input id="added" type="radio"  value="1" name="customerFormMap.state" />&nbsp;&nbsp;新增&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input id="arrive" type="radio" value="2" name="customerFormMap.state" />&nbsp;&nbsp;到访&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input id="deal" type="radio" value="4" name="customerFormMap.state" />&nbsp;&nbsp;成交&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input id="refund" type="radio" value="5" name="customerFormMap.state" />&nbsp;&nbsp;退单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
						<!--点击到访展现的内容-->
						<div id="arrive-con" class="mb40" style="display: none;">
							  <div class="content-msg mt20 ml50">
							  <label>项目选择：</label>
							  	<input type="text" class="input" id="projectNamea" name="customerFormMap.visitprojectId" placeholder="请输入带访项目">
								<!--  <select  class="from-con" id="projectNamea" name="customerFormMap.projectId" ></select> -->
								    
							    </div>
							<div class="content-msg mt20 ml50">
								<label>到访时间：</label>
								    <input type="text" class=" test-item" id="" placeholder="选择时间" name="customerFormMap.visitdate">
								<label class="ml70">现场顾问：</label>
								<input type="text"  id="" placeholder="现场顾问姓名" name="customerFormMap.visitconsulName">
							</div>
							<div class="form-group" style="margin-top:20px ">
							<label for="" class="ml">到访项目：</label>
							<textarea readonly  	style="resize:none"   name=""    rows="6" cols="60" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"  placeholder="该区域显示该客户所以到访项目">${visproject}</textarea>
						</div>
						</div>
						<!--点击成交展现的内容-->
						<div id="deal-con" style="display: none;">
							<div class="content-msg mt20">
								<label for="" class="ml">付款方式：</label>
								<input id="period" type="radio" value="1" name="customerFormMap.dealmode" />&nbsp;&nbsp;分期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input id="full-section" type="radio" value="2" name="customerFormMap.dealmode" />&nbsp;&nbsp;全款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</div>
							
							  <div class="content-msg mt20 ml50">
							  <label>成交项目：</label>
								 <!-- <select  class="from-con" id="projectNameb" name="customerFormMap.projectId" ></select> -->
								   	<input type="text" class="input" id="projectNameb" name="customerFormMap.dealprojectId" > 
								   	<label class="ml50">现场顾问：</label>
								<input type="text"  id="" placeholder="现场顾问姓名" name="customerFormMap.dealconsulName">
							    </div>
							<div class="content-msg mt20 ml50">
								<label>成交时间：</label>
								    <input type="text" class=" test-item" id="" placeholder="选择时间" name="customerFormMap.dealdate">
								<label class="ml50">成交佣金：</label>
								<input type="text"  id="" placeholder="成交佣金/元" name="customerFormMap.commission">
							</div>
								<div class="content-msg mt20 ml50">
								<label class="">成交面积：</label>
								<input type="text"  id="" value="" placeholder="成交面积/m2"name="customerFormMap.dealarea">
								<label class="ml50">成交金额：</label>
								<input type="text"  id="" value="" placeholder="成交总价/元" name="customerFormMap.dealprice">
								</div>
							</div>
						</div>
						
						
							</div>
					</div>
					<div class="form-group">
						<button  type="button" id="btn-test"  class="btn btn-info saveBtn">保存 &nbsp;&nbsp;<span class="glyphicon glyphicon-save-file" aria-hidden="true"></span></button>
					</div>
				</div>
	
			<!--最外层-->

		</form>

		<script src="../layui-date/layui.js" charset="utf-8"></script>

		<script type="text/javascript">
			function today() {
				var today = new Date();
				var h = today.getFullYear();
				var m = today.getMonth() + 1;
				var d = today.getDate();
				var t = today.getHours();
				var s = today.getMinutes();
				return h + "-" + m + "-" + d + "-" + t + ":" + s;
			}

			document.getElementById("today").value = today();
			$("#btn-test").click(function(){
				 
			    $(this).attr("disabled","true"); //设置变灰按钮
			    $("#form").submit();//提交表单
			    setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示
			     
			});
		</script>

		<script>
	/* 	
	 	if($("#arrive").attr("checked",true)){
			//console.log("000");
		   $('#added').attr("disabled","disabled");
		} */
			layui.use('laydate', function() {
				var laydate = layui.laydate;

				//同时绑定多个
				lay('.test-item').each(function() {
					laydate.render({
						elem: this,
						trigger: 'click'
						,type: 'datetime'
					});
				});

				//自定义格式
				laydate.render({
					elem: '#test11'
					,type: 'datetime'
				});

			});
			
			$(document).ready(function(){ 	
			
				/* 	getprojectNamea();
					getprojectNameb(); */
				
		    var cusource=$("#selectCusource").val();
		    var purpose=$("#selectPurpose").val();
		    var intention=$("#selectIntention").val();
		    var apartment=$("#selectApartment").val();
		    
		    var communicate=$("#selectCommunicate").val();
		    var state=$("#selectState").val();
		    var gender=$("#selectGender").val();
		     //根据值让option选中 
		     $("#cusource option[value='"+cusource+"']").attr("selected","selected"); 
	
			  $("#purpose option[value='"+purpose+"']").attr("selected","selected"); 
			
			
			  $("#intention option[value='"+intention+"']").attr("selected","selected");
			
			
			  $("#apartment option[value='"+apartment+"']").attr("selected","selected"); 
			 
			  $("input[name='customerFormMap.gender'][value='"+gender+"'").attr("checked",true);
			  $("input[name='customerFormMap.communicate'][value='"+communicate+"'").attr("checked",true);
			  $("input[name='customerFormMap.state'][value='"+state+"'").attr("checked",true);
			}); 
			
			
			
		/* 	function getprojectNamea(){
				$.ajax({
					"url":"../project/getProject.shtml",
					"data":"",
					"type":"GET",
					"dataType":"json",
					"success":function(obj){
							$("#projectNamea").html("<option value=0> - - - -选择项目- - - - </option>");
						
						for(var i = 0;i<obj.length;i++){
							var str="<option value="+obj[i].id+">"+obj[i].projectName+"</option>";
							$("#projectNamea").append(str);
						}
						
					},
				  error : function() {  
			        alert("未知错误！请与管理员联系");  
			    }  			
				});
			}
				function getprojectNameb(){
					$.ajax({
						"url":"../project/getProject.shtml",
						"data":"",
						"type":"GET",
						"dataType":"json",
						"success":function(obj){
						
							
							
								$("#projectNameb").html("<option value=0> - - - -选择项目- - - - </option>");
							
							for(var i = 0;i<obj.length;i++){
								var str="<option value="+obj[i].id+">"+obj[i].projectName+"</option>";
								$("#projectNameb").append(str);
							}
							
						},
					  error : function() {  
				        alert("未知错误！请与管理员联系");  
				    }  			
					});
			} */
		</script>
		<script type="text/javascript">


		//点击新增隐藏其他
		$("#added").click(function(){
			$("#arrive-con").hide();
			$("#deal-con").hide();
		});
		//点击排号隐藏其他
		$("#row-num").click(function(){
			$("#arrive-con").hide();
			$("#deal-con").hide();
		});
		//点击退单隐藏其他
		$("#refund").click(function(){
			$("#arrive-con").hide();
			$("#deal-con").hide();
		});
		//点击到访展现其内容
		 var isShow=true;
		$("#arrive").click(function(){
			$("#deal-con").hide();
			
			 if (isShow) {
				 $("#arrive-con").show();
				 isShow=false; 
			 }else{
				 $("#arrive-con").hide();
	                isShow=true;
	            }
			
		
		});
		//点击成交隐藏并展示成交内容
		 var isShowa=true;
		$("#deal").click(function(){
			$("#arrive-con").hide();
			 if (isShowa) {
				 $("#deal-con").show();
				 isShowa=false; 
			 }else{
				 $("#deal-con").hide();
	                isShowa=true;
	            }
			
		});

	     
		//点击定金展现其内容隐藏其他
		$("#deposit").click(function(){
			$("#deposit-con").show();
			$("#period-con").hide();
			$("#full-section-con").hide();
		});
		
		//点击分期展示其内容隐藏其他
		$("#period").click(function(){
			$("#period-con").show();
			$("#deposit-con").hide();
			$("#full-section-con").hide();
		});
		
		//点击全款展示其内容隐藏其他
		$("#full-section").click(function(){
			$("#full-section-con").show();
			$("#period-con").hide();
			$("#deposit-con").hide();
		});

		</script>

	</body>

</html>