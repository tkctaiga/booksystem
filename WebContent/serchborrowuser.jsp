<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<form action="/booksystem/bookdispservlet?action=searchresult" method="post"><br>
	<table border="1">
		<tr>
		<td>検索:</td><td>
		<input type="text" name="searchnum">
		<input type="submit" value="検索"></td>
		</tr>
		<tr>
		<td>ジャンル:</td><td>
		<select name="category">
		<option value="10">指定なし</option>
		<option value="0">0:総記</option>
		<option value="1">1:哲学</option>
		<option value="2">2:歴史</option>
		<option value="3">3:社会科学</option>
		<option value="4">4:自然科学</option>
		<option value="5">5:技術</option>
		<option value="6">6:産業</option>
		<option value="7">7:芸術</option>
		<option value="8">8:言語</option>
		<option value="9">9:文学</option>
</select></td>
	</table>
<br><br>
</form>
</body>
</html>