<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>返却</title>
</head>
<body>
<font size="3">図書システム<br></font><hr>
<a href="/booksystem/mainmenuservlet?action=usermenu">メインメニュー</a>
<a href="/booksystem/mainmenuservlet?action=usersearch">検索</a>
<a href="/booksystem/mainmenuservlet?action=userreturn"><font color="#ff6666">■返却</font></a>
<a href="/booksystem/mainmenuservlet?action=userinformation">会員情報</a>
<a href="/booksystem/mainmenuservlet?action=userout">ログアウト</a>
<br><br>返却ページ
		<table border="1">
		<tr><td>ISBN</td><td>分類コード</td><td>出版社</td><td>本名</td><td>著作名</td></tr>
		<c:forEach items="${books}" var="book">
		<tr><td>${book.isbn}</td><td>${book.categorycode}</td><td>${book.publishercode}</td><td>${book.name}</td><td>${book.author}</td></tr>
		</c:forEach>
	</table>
</body>
</html>