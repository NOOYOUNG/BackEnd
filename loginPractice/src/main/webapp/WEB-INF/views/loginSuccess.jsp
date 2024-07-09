<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
</head>
<body>
로그인 성공!<br>
--개인정보조회--<br>
아이디: ${currentId} <br>
이름: ${currentName} <br>
나이: ${currentAge} <br>
주소: ${currentAddress} <br>
전화번호: ${currentPhone} <br>
<form action="/logout">
<input type="submit" value="로그아웃"></form>
</body>
</html>