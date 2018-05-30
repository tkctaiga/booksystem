<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
新宿図書システム<hr>
<a href="/booksystem/mainmenuservlet?action=usermenu">メインメニュー</a>
<a href="/booksystem/mainmenuservlet?action=usersearch">検索</a>
<a href="/booksystem/mainmenuservlet?action=userreturn">返却</a>
<a href="/booksystem/mainmenuservlet?action=userinformation"><font color="#ff6666">■会員情報</font></a>
<a href="/booksystem/mainmenuservlet?action=userout">ログアウト</a>

<h4>こちらで登録しますが、よろしいでしょうか？</h4>
<br>
<form action="/booksystem/ChangemenuServlet" method="post">
<h3>①氏名       ${changeUserInfo.name}</h3>
<h3>②住所       ${changeUserInfo.address}</h3>
<h3>③電話番号   ${changeUserInfo.number1} - ${changeUserInfo.number2} - ${changeUserInfo.number3}</h3>
<input type="submit" value="登録">
<input type="hidden" name="menu" value="userinfo">
<input type="hidden" name="action" value="confirm">
</form>
</body>
</html>