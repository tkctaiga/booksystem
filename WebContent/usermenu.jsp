<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メインメニュー</title>
</head>
<body>
<font size="3">図書システム<br></font><hr>
<a href="/booksystem/mainmenuservlet?action=usermenu"><font color="#ff6666">■メインメニュー</font></a>
<a href="/booksystem/mainmenuservlet?action=usersearch">検索</a>
<a href="/booksystem/mainmenuservlet?action=userreturn">返却</a>
<a href="/booksystem/mainmenuservlet?action=userinformation">会員情報</a>
<a href="/booksystem/mainmenuservlet?action=userout">ログアウト</a>
</body>
<br><br>ようこそ○○さん。<br><h3>現在の貸し出し状況</h3>
<table border="1">
<tr><td>本名</td><td>貸し出し日時</td><td>返却日</td></tr>
<tr><td><strong>プリント</strong></td><td>2018-05-20</td><td>2018-05-23</td></tr>
</table>
</html>