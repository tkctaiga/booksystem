<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="/managermenu.jsp"/>

<h2>本の削除</h2><br><br><br><br>


題名検索<input type="text" name="dbsearch" ><br><br>
分類コード<select name="nbassort">

    <option value="0">選択してください</option>
	<option value="1">0 総記</option>
	<option value="2">1 哲学</option>
	<option value="3">2 歴史</option>
	<option value="4">3 社会科学</option>
	<option value="5">4 自然科学</option>
	<option value="6">5 技術</option>
	<option value="7">6 産業</option>
	<option value="8">7 芸術</option>
	<option value="9">8 言語</option>
	<option value="10">9 文学</option>

</select><br><br>

<form action="/booksystem/DeleteBookServlet?action=dbsresult"method="post">

<input type="submit" value="検索">

</form>


</body>
</html>