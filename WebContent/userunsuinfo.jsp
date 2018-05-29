<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>退会確認ページへ</title>
</head>
<body>
図書システム<hr>
<a href="/booksystem/mainmenuservlet?action=usermenu">メインメニュー</a>
<a href="/booksystem/mainmenuservlet?action=usersearch">検索</a>
<a href="/booksystem/mainmenuservlet?action=userreturn">返却</a>
<a href="/booksystem/mainmenuservlet?action=userinformation"><font color="#ff6666">■会員情報</font></a>
<a href="/booksystem/mainmenuservlet?action=userout">ログアウト</a>
<br><br><br>
会員ID${userId}<br>
名前${userName}<br>
<h3>退会してもよろしいですか？</h3>
<input type="submit" value="退会">
<input type="hidden" name="action" value="userdeletefinish">
</body>
</html>