<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/common/common.jspf" %>
<body>
<div class="m-b-md">

</div>
    <header class="panel-heading">
        <div class="doc-buttons">

            <table border="1" cellspacing="0">
                <tr><th>姓名</th><th>电话</th></tr>
                <c:forEach items="${customer}" var="key">
                    <tr><td>${key.customerName}</td><td>${key.telephone}</td></tr>
                </c:forEach>
            </table>
        </div>
    </header>



</body>
</html>
