<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理人会員メニュー</title>
</head>
<body>

<jsp:include page="/managermenu.jsp"/>


<br><a href="/booksystem/SearchRentalServlet?action=usersearch">■会員照会</a><br><br>
<a href="/booksystem/SearchRentalServlet?action=pass">■会員パスワード変更</a>


</body>
</html>