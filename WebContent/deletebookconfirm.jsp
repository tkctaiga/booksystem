<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/managermenu.jsp"/>
<br><br><br><br>
<h2>どの本を削除しますか？</h2>
<table border="1">
<form action="/booksystem/DeleteBookServlet?action=dbconfim2" method="post">
	<tr><td>本名</td><td>本情報</td>本が${bookscount}冊見つかりました</tr>
	<c:forEach items="${books}" var="book">
	<input type="hidden" name="book_stateid" value="${book.bookstateid}">
	<tr><td><strong>${book.name}</strong></td><td>${book.bookstateid}</td><td><input type="submit" value="確定"></td></tr>
	</c:forEach>
	</form>
</table>
</body>
</html>