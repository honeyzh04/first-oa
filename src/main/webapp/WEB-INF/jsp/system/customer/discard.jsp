<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/system/customer/discard.js"></script>

<style type="text/css">
			.from-con{
            	
            	margin-left: 20%;
            }
            .mt10{
            	margin-top: 10px;
            	margin-right: 10px;
            }
      
</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<form id="form" name="form" class="form-horizontal" method="post"
		action="${ctx}/customer/discardEntity.shtml">
		<input type="hidden" class="form-control checkacc"
			value="${customer.id}" name="customerFormMap.id" id="id">
		<section class="panel panel-default">
		    <div class="modal-body">
        <p><label>丢弃选择：</label></p>
        <div class="from-con" >
        	
        
       	<input id="department" type="radio" checked="checked"  value="2 " name="customerFormMap.resources" />蓝海&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
		<input id="company" type="radio"  value="3" name="customerFormMap.resources"/>公海
        
        </div>
        
      </div>
		<button type="submit" class="btn btn-primary pull-right mt10">丢弃</button>
		</section>
	</form>
</body>
</html>