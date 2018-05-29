<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input your Info</title>
</head>
<body>
<form action="/booksystem/RegisterServlet?action=addconfirm" method="post">

		パスワード:<input type="text" name="password" maxlength = "12">(最大12文字)
		<br>
		<br>
		氏名:<input type="text" name="name" maxlength = "15">
		<br>
		<br>
		郵便番号: <input type="text" name="postal1" maxlength = "3">-
		<input type="text" name="postal2" maxlength = "4">
		<br>
		<br>
		住所:<input type="text" name="address">
		<br>
		<br>
		電話番号:<input type="text" name="number1" maxlength = "3">-
		<input type="text" name="number2" maxlength = "4">-
		<input type="text" name="number3" maxlength = "4">
		<br>
		<br>
		生年月日:西暦<input type = "text" name = "birthday1" maxlength = "4">年
		<input type = "text" name = "birthday2" maxlength = "2">月
		<input type = "text" name = "birthday3" maxlength = "2">日
		<br>
		<br>
		性別:<input type="radio" name="sex" value="0">男
		<input type="radio" name="sex" value="1">女
		<br>
		<br>

<input type="submit" value="登録">
</form>
</body>
</html>