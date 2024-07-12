<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var loginok='<%=(String)session.getAttribute("loginok")%>';
	if(loginok!=null && loginok!=""){
		location.replace('/loginok');
	}
	else{
		location.replace('/logout');
	}
</script>
</head>
<body>
	<form name="Log" method="POST" action="/logIn">
	<p>아이디  <input type="text" name="id"><br>
	<p>비밀번호 <input type="password" name="pwd"><br>
	<input type="submit" value="로그인"><br>
	</form>
	<input type="button" value="회원가입" onclick="javascript:location.replace('join.html')">
	<input type="button" value="비밀번호 찾기" onclick="javascript:location.replace('/findPage')">
</body>
</html>
</body>
</html>