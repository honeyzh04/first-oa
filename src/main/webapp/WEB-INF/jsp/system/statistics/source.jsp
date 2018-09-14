<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/common/common.jspf" %>


    <style type="text/css">
        html, body {
            margin: 0;
            padding: 0;
            overflow-x: hidden;
            overflow-y: hidden;
        }

        .from-con {
            width: 60%;
            height: 30px;
            text-align: center;
            border: 1px solid #ddd;
        }

        .fz {
            font-size: 18px;
            font-weight: bold;
        }

    </style>
</head>
<body>

<div class="msg">


    <div class="modal-body">
        <input type="hidden" class="form-control checkacc"
               value="${createDate}" name="sourceFormMap.createDate" id="createDate">
        <p class="fz">具体来源：</p>
        <div class="text-center">
            <div class="modal-body">
                <label class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;百度商桥：</label>
                <input type="text" class="from-con" id="baidusq" value="${customer.customerName}" disabled="disabled"/>
            </div>
            <div class="form-group col-xs-12">
                <label class="control-label">百度推广电话：</label>
                <input type="text" class="from-con" id="baidudh" value="${customer.charactera}" disabled="disabled">
            </div>
            <div class="form-group col-xs-12">
                <label class="control-label">&nbsp;&nbsp;房发现电话：</label>
                <input type="tel" class="from-con" id="ffxdh" value="${customer.telephone1}" disabled="disabled">
            </div>
            <div class="form-group col-xs-12">
                <label class="control-label">&nbsp;&nbsp;房发现微聊：</label>
                <input type="text" class="from-con" id="ffxwl" value="${customer.travel}" disabled="disabled">
                </select>
            </div>

            <div class="form-group col-xs-12">
                <label class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;信息流：</label>
                <input type="text" class="from-con" id="xxl" value="${customer.address}" disabled="disabled">
            </div>
            <div class="form-group col-xs-12">
                <label class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;搜狗神马：</label>
                <input type="text" class="from-con" id="sgsm" value="${customer.description}" disabled="disabled">
            </div>
        </div>

    </div>


</div>
    <script type="">
            var  a=$("#createDate").val();
            console.log("das"+a);
        $.ajax({
            "url" : "../statistics/Source.shtml",
            "data" : {
                createDate : a,

            },
            "type" : "GET",
            "dataType" : "json",
            "success" : function(obj) {
                console.log("fa"+obj);


               // console.log(obj.alls);
               $("#baidusq").val(obj.baidusq);
                $("#baidudh").val(obj.baidudh);
                $("#ffxdh").val(obj.ffxdh);
                $("#ffxwl").val(obj.ffxwl);
                $("#xxl").val(obj.xxl);
                $("#sgsm").val(obj.sgsm);





            },
            error : function() {
                alert("请与管理员联系");
            }
        });



    </script>
</body>
</html>


