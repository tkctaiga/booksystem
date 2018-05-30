<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員情報</title>
</head>
<body>
新宿図書システム<hr>
<a href="/booksystem/mainmenuservlet?action=usermenu">メインメニュー</a>
<a href="/booksystem/mainmenuservlet?action=usersearch">検索</a>
<a href="/booksystem/mainmenuservlet?action=userreturn">返却</a>
<a href="/booksystem/mainmenuservlet?action=userinformation"><font color="#ff6666">■会員情報</font></a>
<a href="/booksystem/mainmenuservlet?action=userout">ログアウト</a>
<form action="/booksystem/ChangemenuServlet" method="post">
<h3>会員変更ページ</h3>
<br>
①氏名<input type="text" name="chname">
<br>
②住所<input type="text" name="chaddress">
<br>
③電話番号<input type="text" name="chnumber1">-<input type="text" name="chnumber2">-<input type="text" name="chnumber3">
<br>
<input type="hidden" name="menu" value="userinfo">
<input type="hidden" name="action" value="password">
<input type="submit" value="登録">
</form>
</body>
</html>

