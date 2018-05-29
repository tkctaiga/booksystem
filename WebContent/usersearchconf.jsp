<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員検索結果</title>
</head>
<body>
	<jsp:include page="/managermenu.jsp"/>
	<table border="1">
		<tr><td>番号</td><td>名前</td><td>電話番号</td><td>住所</td><td>貸し出し情報</td></tr>
		<c:forEach items="${users}" var="user">
		<tr><td>${user.id}</td><td>${user.name}</td><td>${user.number1}<td><strong>${user.address}</strong></td><td>${users2}</td></tr>
		</c:forEach>
	</table>
</body>
</html>