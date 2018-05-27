<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/booksystem/RegisterServlet?action=addfinish" method="post">
	<table border="1">
		<tr>
		<td>パスワード</td><td>${user.password}</td>
		</tr>
		<tr>
		<td>氏名</td><td>${user.name}</td>
		</tr>
		<tr>
		<tr>
		<td>郵便番号</td><td>${user.postal1}-${user.postal2}</td>
		</tr>
		<tr>
		<td>住所</td><td>${user.address}</td>
		</tr>
		<tr>
		<td>電話番号</td><td>${user.number1}-${user.number2}-${user.number3}</td>
		</tr>
		<tr>
		<td>生年月日</td><td>${user.birthday1}年${user.birthday2}月${user.birthday3}日
		</td>
	    <tr>
		<td>性別</td><td>${selectsex}</td>
		</tr>
	</table>
<input type="submit" value="登録">
</form>
</body>
</html>