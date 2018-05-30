<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退会ページ</title>
</head>
<body>
<font size="3">新宿図書システム<br></font><hr>
<a href="/booksystem/mainmenuservlet?action=usermenu">メインメニュー</a>
<a href="/booksystem/mainmenuservlet?action=userreturn"><font color="#ff6666">■検索</font></a>
<a href="/booksystem/mainmenuservlet?action=usersearch">返却</a>
<a href="/booksystem/mainmenuservlet?action=userinformation">会員情報</a>
<a href="/booksystem/mainmenuservlet?action=userout">ログアウト</a>
<br><br><br>
<form action="/booksystem/ChangeUserServlet?action=dconfim" method="post">
会員ID<input type="text" name="uid">
<br>
パスワード<input type="password" name="upas">
<br>
<input type="submit" value="確認ページへ">
<input type="hidden" name="action" value="dconfim">
</form>
</body>
</html>