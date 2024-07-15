<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
    <h1>회원탈퇴</h1>
    <script>
        const answer = confirm("정말 탈퇴하시겠습니까?");
        
        if (answer) {
            document.write("<p>탈퇴가 완료되었습니다.</p>");
            document.write('<input type="button" value="홈으로 가기" onclick="javascript:location.replace('/')">');
        } else {
            location.replace('/');
        }
    </script>
</body>
</html>