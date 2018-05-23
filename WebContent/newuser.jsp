<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/booksystem/loginservlet?action=addconfirm" method="post">
	<table border="1">
		<tr>
		<td>パスワード</td><td><input type="text" name="password"></td>
		</tr>
		<tr>
		<td>氏名</td><td><input type="text" name="name"></td>
		</tr>
		<tr>
		<td>住所</td><td><input type="text" name="address"></td>
		</tr>
		<tr>
		<td>電話番号</td><td><input type="text" name="number"></td>
		</tr>
		<tr>
		<td>性別</td><td><input type="radio" name="sex" value="sexman">男
		<input type="radio" name="sex" value="sexwoman">${user.selectedsex}</td>
		</tr>
	</table>
<input type="submit" value="確認画面へ">
</form>
</body>
</html>