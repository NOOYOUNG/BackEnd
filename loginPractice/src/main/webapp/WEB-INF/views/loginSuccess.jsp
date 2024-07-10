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
아이디: ${currentuserId} <br>
이름: ${currentName} <br>
나이: ${currentAge} <br>
주소: ${currentAddress} <br>
전화번호: ${currentPhone} <br>
	<form action="/logout">
	<input type="submit" value="로그아웃">
	</form>
	<form action="/updatePage">
	<input type="hidden" name="userId" value="${currentuserId}">
	<input type="submit" value="회원정보 변경">
	</form>
	<form action="/deleteMember">
	<input type="hidden" name="userId" value="${currentuserId}">
	<input type="submit" value="회원탈퇴">
	</form>
</body>
</html>