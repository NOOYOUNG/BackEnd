<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<script>
	alert("로그인에 실패했습니다! 다시 로그인해주세요.")
</script>
</head>
<body>
	<form name="Log" method="GET" action="/logIn">
	<p>아이디  <input type="text" name="id"><br>
	<p>비밀번호 <input type="text" name="pwd"><br>
	<input type="submit"><br>
	</form>
</body>
</html>