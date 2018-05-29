<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>	返却ページ</title>
</head>
<body>
図書システム<hr>
<a href="/booksystem/mainmenuservlet?action=usermenu">メインメニュー</a>
<a href="/booksystem/mainmenuservlet?action=usersearch">検索</a>
<a href="/booksystem/mainmenuservlet?action=userreturn">返却</a>
<a href="/booksystem/mainmenuservlet?action=userinformation"><font color="#ff6666">■会員情報</font></a>
<a href="/booksystem/mainmenuservlet?action=userout">ログアウト</a>


<jsp:include page="/menu.jsp"/><br>
<h3>返却ページ</h3>
<c:if test="${empty user.book}">
現在貸出している本がありません。
</c:if>

<c:if test="${not empty user.book}">
<table border="1">
<tr><td>本名</td><td>日時</td><td>返却期限</td></tr>
<c:forEach items="${user.book}" var="book">
<tr>
		<input type="hidden" name="book_name" value="${book.name}">
		<tr><td>${book.categorycode}</td><td><strong>${book.name}</strong></td><td>${book. }</td></tr><input type="checkbox" name="borrow">
<tb align="left">${item.value.book}
</table>
<br>
<input type="submit" value="返却">
<input type="hidden" name="action" value="bookreturn">
</c:forEach>
</c:if>
</body>
</html>