<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input Password</title>
</head>
<body>

<jsp:include page="/managermenu.jsp"/>
<br><br>

<h2>会員照会</h2>

パスワード<input type="password" name="managerpass" ><br><br>

<form action="/booksystem/DeleteBookServlet?action=inqmenu"method="post">

<input type="submit" value="検索">

</form>





</body>
</html>