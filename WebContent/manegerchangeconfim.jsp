<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>変更確定</title>
</head>
<body>
<jsp:include page="/managermenu.jsp"/>
<h2>会員のパスワード変更確認</h2><br>
ID${id}のパスワードを変更しますか？
<form action="/booksystem/SearchRentalServlet?action=passchangeconf"method="post">
<input type="submit" value="確定">
</form>
</body>
</html>