<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/common.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>answer</title>
<style>
ol {
	padding-left: 20px;
}
li{
	margin-top: 20px;
}
.i-question-btn {
	float: right;
	width: 120px;
	height: 33px;
	line-height: 33px;
	text-align: center;
	color: #fff;
	background: #d40711;
	font-size: 14px;
	border-radius: 4px;

}
#answer {
	list-style: disc;
	border-bottom:1px solid #ccc;
	letter-spacing: 0.2em
}
	#answer1{
		margin-bottom: 40px;
	}
	#answeruser{
		color: #008CBA;
		font-weight:bold
	}
</style>
</head>
<body>
  <h3>${interlocution.question}</h3>
	<DIV id="answer1">
  <a href="#" onclick="interlocutionaddLayer(this);" value="${interlocution.id}" class="i-question-btn">我来回答</a>
  </DIV>
            <div>
            <c:forEach var="item" items="${answers}" varStatus="status">
            	<ol >
				<li id="answer">${item.answer}
				 <div id="answeruser">回答人：${item.createBy}   回答时间：${item.createDate}
				 <a  href="#" onclick="interlocutioneditLayer(this);" value="${item.id}">${item.edit}</a>&nbsp;&nbsp;&nbsp;&nbsp;
				 <a  href="#" onclick="interlocutiondeleLayer(this);" value="${item.id}">${item.dele}</a>
				</div></li>
					</ol>
 
</c:forEach>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/system/assistant/answer.js"></script>
</html>


