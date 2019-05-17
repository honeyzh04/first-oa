<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/common/common.jspf" %>

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
            text-align: center;
        }

        .ml {
            margin-left: 5%;
        }

        .m80 {
            width: 80px;
        }

        .m120 {
            width: 120px;
        }

        .fz {
            font-size: 18px;
            font-weight: bold;
        }

        .save-btn {
            position: relative;
        }

        .saveBtn {
            position: absolute;
            top: 690px;
            left: 900px;
        }

        .ml50 {
            margin-left: 28px;
        }

        .ml70 {
            margin-left: 12px;
        }
    </style>
</head>


<body>
<!--form-horizontal-->
<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
<form id="form" name="form" class="form-horizontal" method="post"
      action="${ctx}/customer/editEntity.shtml">
    <input type="hidden" name="token" value="${token}"/>
    <input type="hidden" class="form-control checkacc"
           value="${customer.id}" name="customerFormMap.id" id="customerId">
    <input type="hidden" class="form-control checkacc"
           value="${customer.userId}" name="customerFormMap.userID" id="userId">
    <input type="hidden" class="form-control checkacc"
           value="${customer.department}" name="customerFormMap.deId" id="department">
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
                    <input type="text" class="input" id="customerName" name="customerFormMap.customerName"
                           placeholder="请输入姓名" value="${customer.customerName}">
                </div>

                <div class="form-group">
                    <label for="">电话号码：</label>
                    <input type="tel" class="input" id="telephone" name="customerFormMap.telephone" placeholder="请输入电话"
                           value="${customer.telephone}" readonly="readonly">
                </div>

                <div class="form-group">
                    <input type="hidden" id="selectGender" value="${customer.gender}"/>
                    <label for="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：</label>
                    <input type="radio" class="" id="man" name="customerFormMap.gender" value="1" <c:if test="${customer.gender==1}">checked="checked"</c:if>>&nbsp;&nbsp;&nbsp;男
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" class="" id="woman" name="customerFormMap.gender" value="2"<c:if test="${customer.gender==2}">checked="checked"</c:if>>&nbsp;&nbsp;&nbsp;女
                </div>
                <div class="form-group">
                    <label for="">信息来源：</label>
                    <input type="hidden" id="selectCusource" value="${customer.cusource}"/>
                    <select name="customerFormMap.cusource" id="cusource">
                        <%--   <c:forEach items="${refundReasonList后台传来的键值对集合}" var="each">
                                    <option value="${each.dataKey}">${each.dataValue}</option>
                                                                </c:forEach> --%>
                        <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择
                        </option>
                        <option value="9">主动T客户</option>
                        <option value="1">网络（安居客端口）</option>
                        <option value="2">网络（58同城端口）</option>
                        <option value="3">网络（房发现端口）</option>
                        <option value="4">网络（安居客供客）</option>
                        <option value="5">网络（58同城供客）</option>
                        <option value="6">网络（房发现供客）</option>
                        <option value="7">自身（打街霸）</option>
                        <option value="8">自身（朋友推荐）</option>
                          <option value="22">欢姐资源</option>
                        <option value="0">其他</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="">&nbsp;&nbsp;&nbsp;市场部：</label>
                    <input type="text" id="" value="${customer.departmentName}" name="customerFormMap.departmentName"
                           readonly="readonly" style="text-align: center;"/>
                </div>
                <div class="form-group">
                    <label for="">投资顾问：</label>
                    <input type="text" value="${customer.userName}" name="customerFormMap.userNamea"
                           readonly="readonly" style="text-align: center;"/>
                </div>
                <div class="form-group">
                    <label>登记时间：</label>
                    <input type="text" id="today" name="date" readonly="readonly">
                </div>
            </div>
        </div>
        <div class="right-add col-sm-7 mt20 border">
            <div class="">
                <p class="fz">客户跟进信息：</p>
                <div class="form-group mt20">
                    <label for="" class="ml">预算总价：</label>
                    <input type="text" class="input" id="totalPrice" name="customerFormMap.totalPrice"
                           placeholder="请输入预算总价" value="${customer.totalPrice}">万

                </div>
                <div class="form-group">
                    <label for="" class="ml">购买用途：</label>
                    <input type="hidden" id="selectPurpose" value="${customer.purpose}"/>
                    <select name="customerFormMap.purpose" id="purpose">
                        <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择
                        </option>
                        <option value="1">投资</option>
                        <option value="2">自用</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="" class="ml">投资意向：</label>
                    <input type="hidden" id="selectIntention" value="${customer.intention}"/>
                    <select name="customerFormMap.intention" id="intention">
                        <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择
                        </option>
                        <option value="1">A类客户</option>
                        <option value="2">B类客户</option>
                        <option value="3">C类客户</option>

                    </select>
                </div>
                <div class="form-group">
                    <label for="" class="ml">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;房源：</label>
                    <input type="hidden" id="selectApartment" value="${customer.apartment}"/>
                    <select name="customerFormMap.apartment" id="apartment">
                        <option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择
                        </option>
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
                    <textarea readonly style="resize:none" name="" rows="6" cols="60"
                              onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"
                              placeholder="请输入跟进内容">${customer.content}</textarea>
                </div>
                <div class="form-group">
                    <label for="" class="ml">跟进情况：</label>
                    <textarea id="contenta" style="resize:none" class="{required:true}" name="customerFormMap.content"
                              rows="6" cols="60"
                              onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"
                              placeholder="请输入跟进内容"></textarea>
                </div>

                <div class="form-group">


                    <div class="content-msg mt20 ml50">
                        <label>跟进预约：</label>
                        <input type="text" value="" class=" test-item" id="ordered" placeholder="选择下次预约时间"
                               name="customerFormMap.ntrackDate">

                    </div>

                    <!-- 	<div class="layui-inline col-sm-12 col-xs-12 mt20">
                            <label class="ml">预约时间：</label>
                            <div class="layui-input-inline">
                                <input type="text" class="layui-input test-item" id="" placeholder="dd/MM/yyyy">
                            </div>
                        </div> -->
                </div>
                <div class="form-group">
                    <input type="hidden" id="selectCommunicate" value="${customer.communicate}"/>
                    <label for="" class="ml">跟进方式：</label>
                    <input type="radio" class="" name="customerFormMap.communicate" value="1" <c:if test="${customer.communicate==1}">checked="checked"</c:if>>&nbsp;&nbsp;&nbsp;电话
                    &nbsp;&nbsp;
                    <input type="radio" class="" name="customerFormMap.communicate" value="2" <c:if test="${customer.communicate==2}">checked="checked"</c:if>>&nbsp;&nbsp;&nbsp;网络
                    &nbsp;&nbsp;
                    <input type="radio" class="" name="customerFormMap.communicate" value="3" <c:if test="${customer.communicate==3}">checked="checked"</c:if>>&nbsp;&nbsp;&nbsp;其他
                    &nbsp;&nbsp;
                </div>
                <div class="form-group">
                    <input type="hidden" id="selectState" value="${customer.state}"/>
                    <label for="" class="ml">跟进状态：</label>
                    <!--<input type="radio" class="" id="" name="" checked="checked" value="1">&nbsp;&nbsp;&nbsp;常规跟进 &nbsp;&nbsp;-->
                    <input id="added" type="radio" value="1" name="customerFormMap.state" <c:if test="${customer.state==1}">checked="checked"</c:if>/>&nbsp;&nbsp;新增&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input id="arrive" type="radio" value="2" name="customerFormMap.state" <c:if test="${customer.state==2}">checked="checked"</c:if>/>&nbsp;&nbsp;到访&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input id="deal" type="radio" value="4" name="customerFormMap.state" <c:if test="${customer.state==4}">checked="checked"</c:if>/>&nbsp;&nbsp;成交&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input id="refund" type="radio" value="5" name="customerFormMap.state" <c:if test="${customer.state==5}">checked="checked"</c:if>/>&nbsp;&nbsp;退单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <!--点击到访展现的内容-->
                <div id="arrive-con" class="mb40" style="display: none;">
                    <div class="content-msg mt20 ml50">
                        <label>项目选择：</label>
                        <select class="selectpicker projectName" data-style="btn-danger" data-width="170px" id="projectNamea"
                                name="customerFormMap.visitprojectId" data-live-search="true" title="选择到访项目"></select>
                        <!--  <select  class="from-con" id="projectNamea" name="customerFormMap.projectId" ></select> -->

                    </div>
                    <div class="content-msg mt20 ml50">
                        <label>到访时间：</label>
                        <input type="text" class=" test-item" id="visitdate" placeholder="选择时间"
                               name="customerFormMap.visitdate">
                        <label class="ml70">现场顾问：</label>
                        <input type="text" id="visitconsulName" placeholder="现场顾问姓名"
                               name="customerFormMap.visitconsulName">
                    </div>
                    <div class="form-group" style="margin-top:20px ">
                        <label for="" class="ml">到访项目：</label>
                        <textarea readonly style="resize:none" name="" rows="6" cols="60"
                                  onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5"
                                  placeholder="该区域显示该客户所以到访项目">${visproject}</textarea>
                    </div>
                </div>
                <!--点击成交展现的内容-->
                <div id="deal-con" style="display: none;">
                    <div class="content-msg mt20">
                        <label for="" class="ml">付款方式：</label>
                        <input id="period" type="radio" value="1" name="customerFormMap.dealmode"/>&nbsp;&nbsp;分期&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input id="full-section" type="radio" value="2" name="customerFormMap.dealmode"/>&nbsp;&nbsp;全款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </div>

                    <div class="content-msg mt20 ml50">
                        <label>成交项目：</label>
                        <select class="selectpicker projectName" data-style="btn-danger" data-width="170px" id="projectNameb" data-size="5"
                                name="customerFormMap.dealprojectId" data-live-search="true" title="选择成交项目"></select>

                        <%-- <input type="text" class="input" id="projectName" name="customerFormMap.dealprojectId">--%>

                    </div>
                    <div class="content-msg mt20 ml50">
                        <label>成交时间：</label>
                        <input type="text" class=" test-item" id="dealdate" placeholder="选择时间"
                               name="customerFormMap.dealdate">
                        <label class="ml50">成交房号：</label>
                        <input type="text" id="roomNumber" placeholder="成交房号" name="customerFormMap.roomNumber">

                    </div>
                    <div class="content-msg mt20 ml50">
                        <label class="">成交面积：</label>
                        <input type="text" id="dealarea" value="" placeholder="成交面积/m2" name="customerFormMap.dealarea">
                        <label class="ml50">成交金额：</label>
                        <input type="text" id="dealprice" value="" placeholder="成交总价/元"
                               name="customerFormMap.dealprice">
                    </div>
                    <div class="content-msg mt20 ml50">
                        <label class="">成交佣金：</label>
                        <input type="text" id="commission" placeholder="成交佣金/元" onchange="commissionRatioa()"
                               name="customerFormMap.commission">
                        <label class="ml50">现金奖励：</label>
                        <input type="text" id="money" placeholder="现金奖励/元" onchange="commissionRatioa()" value="0"
                               name="customerFormMap.money">
                    </div>
                    <div class="content-msg mt20">
                        <label for="" class="ml">佣金分配：</label>
                        <button type="button" class="btn btn-warning " id="allocation">分配佣金&nbsp;&nbsp;<span
                                class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
                    </div>


                    <div id="deal-info" style="display: none;">
                        <div class="content-msg mt20 ml50">
                            <label>客服：</label>
                            <select class="selectpicker dealUser " data-style="btn-danger" data-width="170px"
                                    id="dealUsera"  data-live-search="true"></select>
                            <input type="hidden" name="customerFormMap.dealUserKF" id="dealUserKF">
                            <label>比例：</label>
                            <select style="width:80px;" name="customerFormMap.dealRatioKF" id="dealRatioKF">
                                <option value="0">0%</option>
                                <option value="0.15">15%</option>
                            </select>
                            <label>佣金：</label>
                            <input class="m120" type="text" id="dealCommissionKF" readonly="readonly"
                                   readonly="readonly"
                                   name="customerFormMap.dealCommissionKF">
                        </div>
                        <div class="content-msg mt20 ml50">
                            <label>首录：</label>
                            <c:choose>
                                <c:when test="${createUser.id == null }">
                                    <input class="m80" type="text" style="width: 170px" id="dealUserb"
                                           value="${customer.userName}" readonly="readonly"
                                           name="customerFormMap.dealUserSL">
                                    <input type="hidden" name="customerFormMap.dealUserIdSL"  value="${customer.userId}" >
                                    <input type="hidden" name="customerFormMap.dealdeIdSL"  value="${customer.department}" >
                                </c:when>
                                <c:otherwise>
                                    <input class="m80" type="text" style="width: 170px" id="dealUserb"
                                           value="${createUser.userName}" readonly="readonly"
                                           name="customerFormMap.dealUserSL">
                                    <input type="hidden" name="customerFormMap.dealUserIdSL"  value="${createUser.id}" >
                                    <input type="hidden" name="customerFormMap.dealdeIdSL"  value="${createUser.department}" >
                                </c:otherwise>
                            </c:choose>
                            <label>比例：</label>
                            <input class="m80" type="text" id="dealRatioa" value="5%" readonly="readonly">
                            <label>佣金：</label>
                            <input class="m120" type="text" id="dealCommissionSL" readonly="readonly"
                                   name="customerFormMap.dealCommissionSL">
                        </div>
                        <div class="content-msg mt20 ml50">
                            <label>归属：</label>
                            <select class="selectpicker dealUser " data-style="btn-info" data-width="170px"
                                    id="dealUserc" multiple data-live-search="true"  title="请选择经纪人"></select>
                            <input type="hidden" name="customerFormMap.dealUserGS" id="dealUserGS">
                            <label>比例：</label>
                            <input class="m80" type="text" id="dealRatiob" value="15%" readonly="readonly">
                            <label>佣金：</label>
                            <input class="m120" type="text" id="dealCommissionGS" readonly="readonly"
                                   name="customerFormMap.dealCommissionGS">
                        </div>
                        <div class="content-msg mt20 ml50">

                            <label>邀约：</label>
                            <select class="selectpicker dealUser " data-style="btn-info" data-width="170px"
                                    id="dealUserd" multiple data-live-search="true" title="请选择经纪人"></select>
                            <input type="hidden" name="customerFormMap.dealUserYY" id="dealUserYY">
                            <label>比例：</label>
                            <input class="m80" type="text" id="dealRatioc" value="25%" readonly="readonly">
                            <label>佣金：</label>
                            <input class="m120" type="text" id="dealCommissionYY" readonly="readonly" name="customerFormMap.dealCommissionYY">
                        </div>
                        <div class="content-msg mt20 ml50">
                            <label>战狼：</label>
                            <select class="selectpicker dealUser" data-style="btn-info" data-width="170px"
                                    id="dealUsere" multiple data-live-search="true"   title="请选择经纪人"></select>
                            <input type="hidden" name="customerFormMap.dealUserZL" id="dealUserZL">
                            <label>比例：</label>
                            <input class="m80" type="text" id="dealRatioZL" value="30%" readonly="readonly">
                            <label>佣金：</label>
                            <input class="m120" type="text" id="dealCommissionZL" readonly="readonly" name="customerFormMap.dealCommissionZL">
                        </div>
                        <div class="content-msg mt20 ml50">
                            <label>参与：</label>
                            <select class="selectpicker dealUser " data-style="btn-info" data-width="170px"
                                    id="dealUserf" multiple data-live-search="true" title="请选择经纪人"></select>
                            <input type="hidden" name="customerFormMap.dealUserCY" id="dealUserCY">
                            <label>比例：</label>
                            <input class="m80" type="text" id="dealRatioCY" value="25%" readonly="readonly">
                            <label>佣金：</label>
                            <input class="m120" type="text" id="dealCommissionCY" readonly="readonly" name="customerFormMap.dealCommissionCY"/>
                        </div>

                    </div>
                </div>
            </div>


        </div>
    </div>
    <div class="form-group">
        <button type="button" id="btn-test" class="btn btn-info saveBtn">保存 &nbsp;&nbsp;<span
                class="glyphicon glyphicon-save-file" aria-hidden="true"></span></button>
    </div>
    </div>

    <!--最外层-->

</form>
<script type="text/javascript" src="${ctx}/js/system/customer/edit.js"></script>
<script type="text/javascript">
    //获取当前时间
    function today() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        return currentdate;
    }

    $("#today").val(today());

    // 时间选择器
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //同时绑定多个
        lay('.test-item').each(function () {
            laydate.render({
                elem: this,
                trigger: 'click'
                , type: 'datetime'
            });
        });

        laydate.render({
            elem: '#ordered'
            , type: 'datetime'
            , min: 0 //7天前
            , max: 7 //7天后
        });
    });
    //提交表单
    $("#btn-test").click(function () {
        var o = document.getElementById("dealUsera");//获取多选内容
        var str = [];
        for(var i=0;i<o.length;i++){
            if(o.options[i].selected){
                str.push(o.options[i].value);
            }
        }
        $("#dealUserKF").val(str);
        var o = document.getElementById("dealUserc");//获取多选内容
        var str = [];
        for(var i=0;i<o.length;i++){
            if(o.options[i].selected){
                str.push(o.options[i].value);
            }
        }
        $("#dealUserGS").val(str);
        var o = document.getElementById("dealUserd");//获取多选内容
        var str = [];
        for(var i=0;i<o.length;i++){
            if(o.options[i].selected){
                str.push(o.options[i].value);
            }
        }
        $("#dealUserYY").val(str);
        var o = document.getElementById("dealUsere");//获取多选内容
        var str = [];
        for(var i=0;i<o.length;i++){
            if(o.options[i].selected){
                str.push(o.options[i].value);
            }
        }
        $("#dealUserZL").val(str);
        var o = document.getElementById("dealUserf");//获取多选内容
        var str = [];
        for(var i=0;i<o.length;i++){
            if(o.options[i].selected){
                str.push(o.options[i].value);
            }
        }
        $("#dealUserCY").val(str);
        console.log( $("#dealUserCY").val())
        $(this).attr("disabled", "true"); //设置变灰按钮
        $("#form").submit();//提交表单
        setTimeout("$('#btn-test').removeAttr('disabled')", 3000); //设置三秒后提交按钮 显示

    });


    $(document).ready(function () {
        $('.selectpicker').selectpicker({});
        var cusource = $("#selectCusource").val();
        var purpose = $("#selectPurpose").val();
        var intention = $("#selectIntention").val();
        var apartment = $("#selectApartment").val();

        var communicate = $("#selectCommunicate").val();
        var state = $("#selectState").val();
        var gender = $("#selectGender").val();

        //根据值让option选中
        $("#cusource option[value='" + cusource + "']").attr("selected", "selected");

        $("#purpose option[value='" + purpose + "']").attr("selected", "selected");


        $("#intention option[value='" + intention + "']").attr("selected", "selected");


        $("#apartment option[value='" + apartment + "']").attr("selected", "selected");
      //  $("input[name='customerFormMap.gender'][value='" + gender + "'").prop("checked", "checked");
      //  $("input[name='customerFormMap.gender'][value='" + gender + "'").attr("checked", true);
       // $("input[name='customerFormMap.communicate'][value='" + communicate + "'").attr("checked", true);
      //  $("input[name='customerFormMap.state'][value='" + state + "'").attr("checked", true);



    });

</script>

<script type="text/javascript">

    //查看项目
    function getprojectName() {
        $.ajax({
            "url": "../project/getProject.shtml",
            "data": "",
            "type": "GET",
            "dataType": "json",
            "success": function (obj) {
                $("#projectNameb").html("<option value=0> - - - -选择项目- - - - </option>");
                for (var i = 0; i < obj.length; i++) {
                    var str = "<option value=" + obj[i].projectName + ">" + obj[i].projectName + "</option>";
                    $("#projectNamea").append(str);
                    $("#projectNameb").append(str);

                }
                $('.projectName').selectpicker('refresh');
                $('.projectName').selectpicker('render');

            },
            error: function () {
                layer.alert("获取项目出错！请与管理员联系");
            }
        });
    }
    function getDepartment() {
        $.ajax({
            "url": "../dict/allUser.shtml",
            "data": "",
            "type": "GET",
            "dataType": "json",
            "success": function (obj) {
                $("#dealUsera").html("<option value=0>如有客服参与请选择</option>");
                for (var i = 0; i < obj.length; i++) {

                    var str = "<option  value=" + obj[i].id + ":" + obj[i].v + ">"
                        + obj[i].userName + "</option>";
                    $("#dealUsera").append(str);
                    $("#dealUserc").append(str);
                    $("#dealUserd").append(str);
                    $("#dealUsere").append(str);
                    $("#dealUserf").append(str);
                    $('.dealUser').selectpicker('refresh');
                    $('.dealUser').selectpicker('render');

                }
            },
            error: function () {
                layer.alert("获取销售人员出错，请与管理员联系");
            }
        });
    }

    //点击新增隐藏其他
    $("#added").click(function () {
        $("#arrive-con").hide();
        $("#deal-con").hide();
    });
    //点击排号隐藏其他
    $("#row-num").click(function () {
        $("#arrive-con").hide();
        $("#deal-con").hide();
    });
    //点击退单隐藏其他
    $("#refund").click(function () {
        $("#arrive-con").hide();
        $("#deal-con").hide();
    });
    //点击到访展现其内容
    var isShow = true;
    $("#arrive").click(function () {
        $("#deal-con").hide();

        if (isShow) {
            $("#arrive-con").show();
            getprojectName();
            isShow = false;
        } else {
            $("#arrive-con").hide();
            isShow = true;
        }


    });
    //点击成交隐藏并展示成交内容
    var isShowa = true;
    $("#deal").click(function () {
        $("#arrive-con").hide();
        if (isShowa) {
            $("#deal-con").show();
            getprojectName();
            getDepartment();
            isShowa = false;
        } else {
            $("#deal-con").hide();
            isShowa = true;
        }

    });
    //点击佣金分配 展示
    var isShowb = true;
    $("#allocation").click(function () {

        // $("#deal-info").hide();
        if (isShowb) {
            $("#deal-info").show();

            isShowb = false;
        } else {
            $("#deal-info").hide();
            isShowb = true;
        }

    });


    //点击定金展现其内容隐藏其他
    $("#deposit").click(function () {
        $("#deposit-con").show();
        $("#period-con").hide();
        $("#full-section-con").hide();
    });

    //点击分期展示其内容隐藏其他
    $("#period").click(function () {
        $("#period-con").show();
        $("#deposit-con").hide();
        $("#full-section-con").hide();
    });

    //点击全款展示其内容隐藏其他
    $("#full-section").click(function () {
        $("#full-section-con").show();
        $("#period-con").hide();
        $("#deposit-con").hide();
    });
    /*
    获取总分配佣金
     */
    function   sumCommission() {
        var commission = $("#commission").val();
        var money = $("#money").val();
        var co = parseInt(commission);
        var mo = parseInt(money);
        var sum1=co+mo;
        return sum1;
    }
    function commissionRatioa() {
        dealRatioKF();
        dealRatioSL();
        dealRatioGS();
        dealRatioYY();
        dealRatioZL();
        dealRatioCY();

    }

    $("#dealRatioKF").change(function () {
        dealRatioKF();
        dealRatioSL();
        dealRatioGS();
        dealRatioYY();
        dealRatioZL();
        dealRatioCY();
    });

    function dealRatioKF() {
        var sum1=sumCommission();
        var dealRatioKF = $("#dealRatioKF").val();
        var a=sum1*dealRatioKF;
        var b = a.toFixed(2);
        $("#dealCommissionKF").val(b)
    }

    function dealRatioSL() {
        var sum1=sumCommission();
        var kf= $("#dealCommissionKF").val();
        var a=(sum1-kf)*0.05;
        console.log(a)
        var b = a.toFixed(2);
        $("#dealCommissionSL").val(b)
    }

    function dealRatioGS() {
        var sum1=sumCommission();
        var kf= $("#dealCommissionKF").val();
        var a=(sum1-kf)*0.15;
        var b = a.toFixed(2);
        $("#dealCommissionGS").val(b)
    }

    function dealRatioYY() {
        var sum1=sumCommission();
        var kf= $("#dealCommissionKF").val();
        var a=(sum1-kf)*0.25;
        var b = a.toFixed(2);
        $("#dealCommissionYY").val(b)
    }

    function dealRatioZL() {
        var sum1=sumCommission();
        var kf= $("#dealCommissionKF").val();
        var a=(sum1-kf)*0.3;
        var b = a.toFixed(2);
        $("#dealCommissionZL").val(b)
    }

    function dealRatioCY() {
        var sum1=sumCommission();
        var kf= $("#dealCommissionKF").val();
        var a=(sum1-kf)*0.25;
        var b = a.toFixed(2);
        $("#dealCommissionCY").val(b)
    }
</script>

</body>

</html>