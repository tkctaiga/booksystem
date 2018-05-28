<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>貸借検索</title>
</head>
<body>
	<jsp:include page="/managermenu.jsp"/>
	<form action="/booksystem/SearchRentalServlet?action=result" method="post"><br>
	<table border="1">
		<tr>
		<td>検索:</td><td>
		<input type="text" name="userid">
		<input type="submit" value="検索"></td>
		</tr>
		<tr>
	</table>
<br><br>
</form>
</body>
</html>