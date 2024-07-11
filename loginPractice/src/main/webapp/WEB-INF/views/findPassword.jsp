<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FIND PASSWORD</title>
</head>
<body>
<form name="find" method="post" action="/findPassword">
	이름을 입력하세요: <input type="text" name="name" value="${currentName}"><br>
	전화번호를 입력하세요: <input type="text" name="phone" value="${currentPhone}"><br>
	<input type="hidden" name="id" value="${currentId}"><br>
	<input type="submit" value="비밀번호 변경">
</form>
</body>
</html>