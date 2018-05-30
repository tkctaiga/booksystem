<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パスワード変更</title>
</head>
<body>
<jsp:include page="/managermenu.jsp"/>
<h2>会員のパスワード変更</h2><br>
<form action="/booksystem/SearchRentalServlet?action=passchange"method="post">
<strong>①管理人のパスワードを入力してください</strong><br><br>パスワード:<input type="password" name="pass" maxlength = "12"><br>
<br><strong>②変更したいIDを入力してください</strong><br><br>ユーザーID:<input type="text" name="id" maxlength = "12"><br>
<br><strong>③変更したいパスワードを入力してください</strong><br><br>パスワード:<input type="password" name="cpass" maxlength = "12"><br>
<br>
<input type="submit" value="確認">
</form>
</body>

</html>