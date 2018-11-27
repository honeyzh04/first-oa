<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/common/common.jspf" %>
    <script type="text/javascript" src="${ctx}/js/system/teamaward/addaward.js"></script>

    <style type="text/css">
        .from-con {

            margin-left: 20%;
        }

        .mt10 {
            margin-top: 10px;
            margin-right: 10px;
        }

    </style>
</head>
<body>
<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
<form id="form" name="form" class="form-horizontal" method="post"
      action="${ctx}/temaaward/addAward.shtml">
    <input type="hidden" class="form-control checkacc"
           value="${customer.id}" name="teamAwardFormMap.id" id="id">
    <section class="panel panel-default">
        <div class="modal-body">
            <p><label>客户来源：</label></p>
            <div class="from-con">
                <input id="personal" type="radio" checked="checked" value="1 " name="teamAwardFormMap.resources"/>个人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="public" type="radio" value="2" name="teamAwardFormMap.resources"/>公海&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="all" type="radio" value="" name="teamAwardFormMap.resources"/>随机
            </div>
            <p><label>客户数量：</label></p>
            <div class="from-con">
                <input  style="width: 73%;"type="text"   class="form-control  " name="teamAwardFormMap.customers" id="visitproject" value="5" />


            </div>
        </div>

        <button type="submit" class="btn btn-primary pull-right mt10">奖励</button>
    </section>
</form>
</body>
</html>