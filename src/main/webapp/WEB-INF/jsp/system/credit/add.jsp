<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf" %>
<script type="text/javascript" src="${ctx}/js/system/credit/add.js">
</script>
<style type="text/css">
 #aa{
	 margin: 15px;
 }
</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/credit/addCredit.shtml">
		<div id="aa">
		<label class="pad" >部门：</label>
		<select	class="form-control" id="department"	name="creditFormMap.department" onchange="getUsera(this.value)"></select>
		<label  class="pad">职工：</label>
		<select class="form-control" id="userId"    name="creditFormMap.userId"></select>
		<label  class="pad">分数：</label>
			<select class="form-control" class="form-control" name="creditFormMap.credit">
				<option value="9">500分</option>
				<option value="10">1000分</option>
				<option value="11">1500分</option>
				<option value="12">2000分</option>
			</select>

		<button type="button"  id="btn-test"class="btn btn-success pull-right ">确定</button>
		</div>
	</form>
</body>
<script !src="">
    $("#btn-test").click(function(){

        $(this).attr("disabled","true"); //设置变灰按钮
        $("#form").submit();//提交表单
        setTimeout("$('#btn-test').removeAttr('disabled')",3000); //设置三秒后提交按钮 显示

    })

    $(function() {
        getDepartment(-1,-1);

    });
    //当部门列表发生改变时,调用getUser函数获取城市信息
    function getUsera(userCode){
        $.ajax({
            "url":"../dict/showUser.shtml",
            "data":"departCode="+userCode,
            "type":"GET",
            "dataType":"json",
            "success":function(obj){
                $("#userId").html("<option class='form-control m-b-10' value=''> - - - -选择销售- - - - </option>");
                for(i=0;i<obj.length;i++){
                    var str = "<option class='form-control m-b-10' value="+obj[i].id+">"+obj[i].userName+"</option>";
                    $("#userId").append(str);
                }
                if(userCode!=-1){

                }
            },
            error : function() {
                alert("请与管理员联系");
            }
        });

    }
    //加载页面完成,就调用dict/showDepart.shtml
    function getDepartment(departCode,userCode){
        $.ajax({
            "url":"../dict/showDepart.shtml",
            "data":"",
            "type":"GET",
            "dataType":"json",
            "success":function(obj){

                $("#department").html("<option class='form-control m-b-10' value=''> - - - -选择部门- - - - </option>");

                for(var i = 0;i<obj.length;i++){
                    var str="<option class='form-control m-b-10' value="+obj[i].id+">"+obj[i].name+"</option>";
                    console.log("3"+obj[i])
                    $("#department").append(str);
                }
                if(departCode!=-1){
                    $("#department").val(id);
                }

            },
            error : function() {
                alert("请与管理员联系");
            }
        });

        getUsera(userCode);
    }

</script>

</html>