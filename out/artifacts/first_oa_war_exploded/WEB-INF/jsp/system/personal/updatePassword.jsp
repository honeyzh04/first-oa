<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<script type="text/javascript" src="./js/system/user/updatePassword.js"></script>
    <style>

        .wrap1 {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto
        }
        /*把整个屏幕真正撑开--而且能自己实现居中*/

        .main_content {
            /*background: url(img/main-bg.png) repeat;*/
            background: #f1f1f1;

            box-shadow:0 0 10px #aaa;
            margin-left: 300px;
            margin-right: 0;
            text-align: left;
            float: none;
            border-radius: 8px;
        }

        .form-group {
            position: relative;
        }

        .login_btn {
            display: block;
            background: #3872f6;
            color: #fff;
            font-size: 15px;
            width:375px;
            line-height: 50px;
            border-radius: 3px;
            border: none;
        }

        .login_input {
            width: 100%;
            border: 1px solid #3872f6;
            border-radius: 3px;
            line-height: 40px;
            padding: 2px 5px 2px 30px;
            background: none;
        }


        .font16 {
            font-size: 16px;
            font-weight: bold
        }

        .mg-t20 {
            margin-top: 20px;
        }

        @media (min-width:200px) {
            .pd-xs-20 {
                padding: 20px;
            }
        }

        @media (min-width:768px) {
            .pd-sm-50 {
                padding: 50px;
            }
        }
.textPwd{
    color:#000;
}
        .eye{
            position: absolute;
            left: 370px;
            top:35px;
            color:#000;
        }


    </style>
</head>

<div id="back" style="background:url(./img/007.jpg) no-repeat; width: 100%;height: 800px;">
    <form id="formUpdatePwd" name="form" class="form-horizontal" method="post" action="./user/editPassword.shtml">
    <input type="hidden" class="form-control checkacc" value="${userSession.id}" name="userFormMap.id" id="id">
    <input type="hidden" class="form-control checkacc" value="${userSession.accountName}" name="userFormMap.accountName" id="accountName">
    <input type="hidden" class="form-control checkacc" value="${userSession.password}" name="userFormMap.password" id="password">
    <div class="container wrap1" style="height:450px;">

        <div class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
            <p class="text-center font16">修改密码</p>
            <div class="l_err" style="width: 375px; margin-top: 2px;"></div>
            <div class="form-group mg-t20" style="position: relative;">
                <span class="textPwd">新密码：</span>
                <input type="password" class="login_input" placeholder="请输入新密码" name="userFormMap.newpassword" id="newpassword"/>
               <span  onclick="change()"><i class="fa fa-eye eye" aria-hidden="true"></i></span>
            </div>
            <div class="form-group mg-t20">
                <span class="textPwd">确认密码：</span>
                <input type="password" class="login_input" placeholder="请输入确认密码"  name="userFormMap.confirmpassword" id="confirmpassword"/>
            </div>
            <button class="login_btn" id="login"  type="button"   >确认修改</button>
        </div>
        <!--row end-->
    </div>
    </form>
</div>

 <script type="text/javascript">
        var isShow=true;
        function change(){
            var v=document.getElementById("newpassword");
            if (isShow) {
                v.type="text";
                isShow=false;
            }else{
                v.type="password";
                isShow=true;
            }
        };
        $("#login").click(function(){

            $(this).attr("disabled","true"); //设置变灰按钮
            $("#formUpdatePwd").submit();//提交表单
            setTimeout("$('#login').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示

        });

    </script>

</html>