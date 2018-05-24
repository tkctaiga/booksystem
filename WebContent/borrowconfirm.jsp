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
	<tr><td>ISBN</td><td>ジャンル</td><td>本名</td><td>出版社</td><td>著作名</td><td>在庫</td></tr>
	<c:forEach items="${books}" var="book">
	<tr><td>${book.isbn}</td><td>${book.categorycode}</td><td><strong>${book.name}</strong></td><td>${book.publishercode}</td><td>${book.author}</td><td>${book.author}</td></tr>
	</c:forEach>
</table>
<br>
こちらでよろしいでしょうか？
<form action="/booksystem/bookdispservlet?action=searchborroworder" method="post">
<br><input type="submit" value="確定">
</form>
</body>
</html>
