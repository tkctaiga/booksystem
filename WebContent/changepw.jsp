<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
図書システム<hr>
<a href="/booksystem/mainmenuservlet?action=usermenu">メインメニュー</a>
<a href="/booksystem/mainmenuservlet?action=usersearch">検索</a>
<a href="/booksystem/mainmenuservlet?action=userreturn">返却</a>
<a href="/booksystem/mainmenuservlet?action=userinformation"><font color="#ff6666">■会員情報</font></a>
<a href="/booksystem/mainmenuservlet?action=userout">ログアウト</a>

<h3>会員情報メニュー</h3>
現在のパスワード<input type="text" name="password">
<br>
新しいパスワード<input type="text" name="newpassword">
<br>
現在のパスワード<input type="text" name="newpassword2">
<br>
<input type="submit" value="決定">
<input type="hidden" name="action" value="upwbonfirm">
</body>
</html>