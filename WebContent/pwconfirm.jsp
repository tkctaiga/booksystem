<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm Changed Password</title>
</head>
<body>
<font size="3">図書システム<br></font><hr>
<a href="/booksystem/mainmenuservlet?action=usermenu"><font color="#ff6666">■メインメニュー</font></a>
<a href="/booksystem/mainmenuservlet?action=usersearch">検索</a>
<a href="/booksystem/mainmenuservlet?action=userreturn">返却</a>
<a href="/booksystem/mainmenuservlet?action=userinformation">会員情報</a>
<a href="/booksystem/mainmenuservlet?action=userout">ログアウト</a>
<br>
<form action="/booksystem/ChangePwServlet?action=chpwfinish" method="post">

<center><h2>パスワードを変更しますが<br>
よろしいでしょうか?</h2></center>

<center><input type = "submit" value = "変更"></center>
</form>
</body>
</html>