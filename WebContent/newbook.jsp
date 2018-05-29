<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>本の登録</title>
</head>
<body>

<jsp:include page="/managermenu.jsp"/>

<h2>本登録ページ</h2><br><br>

<form action="/booksystem/NewBookServlet?action=confirm" method="post">


①ISBN番号<input type="text" name="nisbn" maxlength="10"><br><br>
②分類コード<select name="nbassort">

    <option value="10">選択してください</option>
	<option value="0">0 総記</option>
	<option value="1">1 哲学</option>
	<option value="2">2 歴史</option>
	<option value="3">3 社会科学</option>
	<option value="4">4 自然科学</option>
	<option value="5">5 技術</option>
	<option value="6">6 産業</option>
	<option value="7">7 芸術</option>
	<option value="8">8 言語</option>
	<option value="9">9 文学</option>

</select><br><br>

③出版社コード<input type="text" name="npublishernum" ><br><br>

④タイトル<input type="text" name="ntitle" ><br><br>

⑤著者<input type="text" name="nauthor"><br><br>

⑥出版社<input type="text" name="npublisher"><br><br>

⑦出版年月日<input type="text" name="npubyear" maxlength="10"><br>
<br>

⑧入荷年月日<input type="text" name="arrivalyear" maxlength="10"><br>
<br>


<input type="submit" value="登録">

</form>

</body>
</html>