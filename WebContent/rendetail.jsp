<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>貸借結果</title>
</head>
<body>
	<jsp:include page="/managermenu.jsp"/>
		<table border="1">
		<tr><td>ユーザーID</td><td>名前</td><td>本名</td><td>貸月日</td><td>返却日</td></tr>
		<c:forEach items="${rens}" var="ren">
		<tr><td>${ren.id}</td><td>${ren.name}</td><td><strong>${ren.userbooks}</strong></td><td>${ren.userbooksday}</td><td>${ren.userbooksrenday}</td></tr>
		</c:forEach>
	</table>
</body>
</html>