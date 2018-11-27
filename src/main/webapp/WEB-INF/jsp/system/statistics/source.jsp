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

        .text-center{
           margin-top: 40px;
        }

        .fz {
            font-size: 18px;
            font-weight: bold;
        }
        .form-control{text-align:center;}
    </style>
</head>
<body>

<div class="msg">


    <div class="modal-body">
        <input type="hidden" class="form-control checkacc"
               value="${createDate}" name="sourceFormMap.createDate" id="createDate">
        <p class="fz">具体来源：</p>
        <div class="text-center">

            <div class="input-group form-group">
                <span class="input-group-addon">百度商桥：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)"  id="baidusq" disabled="disabled">
                <span class="input-group-addon">位</span>
            </div>
            <div class="input-group form-group">
                <span class="input-group-addon">百度推广电话：</span>
                <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)"  id="baidudh"  disabled="disabled">
                <span class="input-group-addon">位</span>
            </div>
            <div class="input-group form-group">
                <span class="input-group-addon">房发现电话：&nbsp;&nbsp;</span>
                <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)"  id="ffxdh"  disabled="disabled">
                <span class="input-group-addon">位</span>
            </div>
            <div class="input-group form-group">
                <span class="input-group-addon">房发现微聊：&nbsp;&nbsp;</span>
                <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" id="ffxwl"  disabled="disabled">
                <span class="input-group-addon">位</span>
            </div>
            <div class="input-group form-group">
                <span class="input-group-addon">信息流：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" id="xxl"  disabled="disabled">
                <span class="input-group-addon">位</span>
            </div>
            <div class="input-group form-group">
                <span class="input-group-addon">搜狗神马：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" id="sgsm"  disabled="disabled">
                <span class="input-group-addon">位</span>
            </div>
            <div class="input-group form-group">
            <span class="input-group-addon">离线宝：：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" id="lxb"  disabled="disabled">
            <span class="input-group-addon">位</span>
            </div>
                <div class="input-group form-group">
            <span class="input-group-addon">公众号：：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" id="gzh"  disabled="disabled">
            <span class="input-group-addon">位</span>
                </div>
                    <div class="input-group form-group">
            <span class="input-group-addon">其他途径：：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)" id="qttj"  disabled="disabled">
            <span class="input-group-addon">位</span>
        </div>

        </div>

    </div>


</div>
    <script type="">
            var  a=$("#createDate").val();

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
                $("#lxb").val(obj.lxb);
                $("#gzh").val(obj.gzh);
                $("#qttj").val(obj.qttj);





            },
            error : function() {
                alert("请与管理员联系");
            }
        });



    </script>
</body>
</html>


