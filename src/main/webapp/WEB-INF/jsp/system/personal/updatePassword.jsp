<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<script type="text/javascript" src="./js/system/user/updatePassword.js"></script>
	<style type="text/css">
	
	     .mt10{
            	margin-top: 10px;
            	margin-right: 10px;
            }
               .mt12{
            	
            	margin-bottom: 20px;
            	border: 1px solid;
            } 
	</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<form id="formUpdatePwd" name="form" class="form-horizontal" method="post" action="./user/editPassword.shtml">
		<input type="hidden" class="form-control checkacc" value="${userSession.id}" name="userFormMap.id" id="id">
		<input type="hidden" class="form-control checkacc" value="${userSession.accountName}" name="userFormMap.accountName" id="accountName">
		<input type="hidden" class="form-control checkacc" value="${userSession.password}" name="userFormMap.password" id="password">
		<section class="panel panel-default">
			
				<div class="col-lg-12  m12">
				<div class="col-lg-7">
					<div class="form-group pad">
						<label for="exampleInputName2">新密码：</label> <input  type="password"
							class="form-control"  placeholder="请输入新密码" name="userFormMap.newpassword" id="newpassword">
					</div>

					<div class="form-group pad">
						<label for="exampleInputName2">确认密码：</label> <input  type="password"
							class="form-control" placeholder="请输入确认密码" name="userFormMap.confirmpassword" id="confirmpassword">
					</div>
			
				</div>
		
			</div>
				<button type="button" onclick="change()"class="btn btn-success btn-s-xs pull-right mt10 ">可见</button>
				<button type="submit" class="btn btn-success btn-s-xs pull-right mt10 ">修改</button>

		</section>
	</form>
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


    </script>
</body>
</html>