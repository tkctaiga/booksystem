<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借りる処理</title>
</head>
<body>
<font size="3">図書システム<br></font><hr>
<a href="/booksystem/mainmenuservlet?action=usermenu">メインメニュー</a>
<a href="/booksystem/mainmenuservlet?action=userreturn"><font color="#ff6666">■検索</font></a>
<a href="/booksystem/mainmenuservlet?action=usersearch">返却</a>
<a href="/booksystem/mainmenuservlet?action=userinformation">会員情報</a>
<a href="/booksystem/mainmenuservlet?action=userout">ログアウト</a>
<br><h3>確認画面</h3><br>
<table border="1">
<form action="/booksystem/bookdispservlet?action=searchborroworder" method="post">
	<tr><td>本名</td><td>本情報</td>本が${bookscount}冊見つかりました</tr>
	<c:forEach items="${books}" var="book">
	<input type="hidden" name="book_stateid" value="${book.bookstateid}">
	<tr><td><strong>${book.name}</strong></td><td>${book.bookstateid}</td><td><input type="submit" value="確定"></td></tr>
	</c:forEach>
	</form>
</table>
<br>
</body>
</html>
