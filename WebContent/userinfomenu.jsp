<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員画面</title>
</head>
<body>
図書システム<hr>
<a href="/booksystem/mainmenuservlet?action=usermenu">メインメニュー</a>
<a href="/booksystem/mainmenuservlet?action=usersearch">検索</a>
<a href="/booksystem/mainmenuservlet?action=userreturn">返却</a>
<a href="/booksystem/mainmenuservlet?action=userinformation"><font color="#ff6666">■会員情報</font></a>
<a href="/booksystem/mainmenuservlet?action=userout">ログアウト</a>

<h3>会員画面</h3>
<a href="/booksystem/ChangemenuServlet?action=changeinfo">■会員情報の変更</a>
<br>
<br>
<a href="/booksystem/ChangePwServlet?action=inputpw">■会員のパスワード変更</a>
<br>
<a href="/booksystem/ChangePwServlet?action=inputpw">■会員の退会</a>
</body>
</html>