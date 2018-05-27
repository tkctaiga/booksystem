<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本の削除</title>
</head>
<body>

<jsp:include page="/managermenu.jsp"/>
<br><br>検索件数は${bookscount}件HITしました！
	<table border="1">
		<tr><td>ISBN</td><td>ジャンル</td><td>本名</td><td>出版社</td><td>著作名</td></tr>
		<c:forEach items="${books}" var="book">
		<form action="/booksystem/DeleteBookServlet?action=dbconfirm" method="post">
		<input type="hidden" name="book_name" value="${book.name}">
		<tr><td>${book.isbn}</td><td>${book.categorycode}</td><td><strong>${book.name}</strong></td><td>${book.publishercode}</td><td>${book.author}</td><td><input type="submit" value="詳細"></td></tr>
		</form>
		</c:forEach>
	</table>
</form>
</body>
</html>