<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Admin Template">
    <meta name="keywords" content="admin dashboard, admin, flat, flat ui, ui kit, app, web app, responsive">
    <link rel="shortcut icon" href="img/ico/favicon.png">
    <title>fangfaxian.菲斯特地产</title>

    <!-- Base Styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <script>
        var _hmt = _hmt || [];
        (function () {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?c52aab0aa4b78b30851c244acb725bf2";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>


</head>

<body class="login-body">


<div class="login-logo">
    <img src="img/login_logo.png" alt=""/>
</div>

<h2 class="form-heading">菲斯特地产欢迎你</h2>

<div class="container log-row">
    <form id="loginform" name="loginform" class="form-signin"
          action="${pageContext.servletContext.contextPath }/login.shtml"
          method="post">
        <div class="login-wrap">
            <input type="text" class="form-control" placeholder="User ID" name="username" autofocus>
            <input type="password" class="form-control" placeholder="Password" name="password" autocomplete="on">
            <a id="logoin" type="submit" href="javascript:checkUserForm()"
               class="btn btn-lg btn-success btn-block">登录</a>

            <label class="checkbox-custom check-success">

                <a class="pull-right" href="javascript:forget()" data-toggle="modal" href="#forgotPass"> 忘记密码？</a>
            </label>


        </div>


    </form>
</div>
<div style="text-align: center;">
    <img src="img/fangfaxian/erweima1.png">


</div>

<script type="text/javascript">
    if ("${error}" != "") {
        alert("${error}");
    }
    ;

    function checkUserForm() {
        document.loginform.submit();
    }

    function forget() {
        alert("请与管理员联系");
    }

    document.onkeydown = function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 13) {

            document.loginform.submit();
        }
    }

</script>
<!--jquery-1.10.2.min-->
<script src="js/jquery-1.11.1.min.js"></script>
<!--Bootstrap Js-->
<script src="js/bootstrap.min.js"></script>
<script src="js/jrespond..min.js"></script>

</body>
</html>
