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
<br><br>返却確認メニュー<br><h3>現在の貸し出し状況</h3>
<table border="1">
<tr><td>本名</td><td>貸し出し日時</td><td>返却日</td><td>レンタルID</td></tr>
<c:forEach items="${renusers}" var="renuser">
<tr><td>${renuser.name}</td><td>${renuser.bookday}</td><td>${renuser.bookdayr}</td><td>${renuser.rentalnumber}</td></tr>
</c:forEach>
</table>
こちらでよろしいでしょうか？
<form action="/booksystem/ShowReturnBookServlet?action=returnend" method="post">
<input type="hidden" name="rental_id" value="${renuser.rentalnumber}">
<input type="submit" value="返却">
</form>
</body>
</html>