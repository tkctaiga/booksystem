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
<form action="/booksystem/ChangemenuServlet" method="post">
<h3>変更完了!</h3>
<h2>変更完了しました。</h2>
<a href="/booksystem/mainmenuservlet?action=usermenu">メインメニューへ</a>
</form>
</body>
</html>