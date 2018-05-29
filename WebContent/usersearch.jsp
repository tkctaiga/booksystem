<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員検索</title>
</head>
<body>
<jsp:include page="/managermenu.jsp"/>
<form action="/booksystem/SearchRentalServlet?action=userend"method="post">
<strong>会員IDを入力してください</strong><br><br><input type="text" name="userid" maxlength = "12"><br>
<br>
<input type="submit" value="確認">
</form>
</body>
</html>