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
		<tr><td>ユーザー番号</td><td>名前</td><td></td></tr>
		<c:forEach items="${rens}" var="ren">
		<form action="/booksystem/SearchRentalServlet?action=detail" method="post">
		<input type="hidden" name="renid" value="${ren.id}">
		<tr><td>${ren.id}</td><td>${ren.name}</td><td><input type="submit" value="詳細"></td></tr>
		</form>
		</c:forEach>
	</table>
</body>
</html>