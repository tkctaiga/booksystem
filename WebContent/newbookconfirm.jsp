<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録確認</title>
</head>
<body>

<jsp:include page="/managermenu.jsp"/>

<h3>こちらで登録しますが、よろしいでしょうか？</h3>












①ISBN番号 ${nnbook. nisbn } <br><br>
②分類コード ${nnbook. nbassort }<br> <br>
③出版社コード ${nnbook. npublishernum } <br><br>
④タイトル ${nnbook. ntitle }<br><br>
⑤著者 ${nnbook. nauthor }<br><br>
⑥出版社 ${nnbook. npublisher }<br><br>
⑦出版年月日 ${nnbook. npubyear }<br><br>
⑧入荷年月日 ${nnbook. arrivalyear }<br><br>


<form action="/booksystem/NewBookServlet?action=result"method="post">
<input type="submit" value="登録">
</form>

</body>
</html>