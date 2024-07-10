<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Personal Information</title>
</head>
<body>
<form name="update" method="GET" action="/updateMember">
	--개인정보--<br>
	아이디: ${currentuserId}<br>
	이름: <input type="text" name="modName" value="${currentName}"><br>
	나이: <input type="text" name="modAge" value="${currentAge}"><br>
	주소: <input type="text" name="modAddress" value="${currentAddress}"><br>
	전화번호: <input type="text" name="modPhone" value="${currentPhone}"><br>
	<input type="hidden" name="userId" value="${currentuserId}"><br>
	<input type="submit" value="회원정보 변경">
</form>
</body>
</html>