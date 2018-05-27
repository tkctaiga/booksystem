<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<form action="/booksystem/loginservlet?action=login" method="post">
図書システム<hr><br>
	<table border="1">
		<tr>
		<td>ユーザーID:</td><td><input type="text" name="id"></td>
		</tr>
		<tr>
		<td>パスワード:</td><td><input type="text" name="password"></td>
	</table>
<br><input type="submit" value="ログイン"><br>
</form>
<br>新規会員はこちら<a href="/booksystem/RegisterServlet?action=useradd">新規会員登録</a>

</body>
</html>