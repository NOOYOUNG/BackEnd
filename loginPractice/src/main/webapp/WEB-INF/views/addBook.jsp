<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book Page</title>
</head>
<body>
<h2>도서 정보 등록</h2>
<form name="insertbook" method="GET" action="/insertbook">
	도서 제목: <input type="text" name="bookname"><br>
	ISBN: <input type="text" name="isbn"><br>
	저자: <input type="text" name="author"><br>
	출판사: <input type="text" name="publisher"><br>
	출판일자: <input type="date" name="publishdate"><br>
	<input type="submit" value="등록하기">
</form>
	<script>
		var loginok = '<%=(String)session.getAttribute("loginok")%>';
		if(loginok == "" || loginok == "null") {
			alert("로그인이 되어 있지 않습니다.");
			location.replace("/");
		}
	</script>
</body>
</html>