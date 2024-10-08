<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 정보가 리스트 형태로 넘어왔기 때문에 c 써야함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List Page</title>
</head>
<body>
	<h1>도서 목록 보기</h1>
	<table>
		<tr>
			<td>검색</td>
			<td>
				<form action="/searchBook">
					<input type="text" name="searchText">
					<input type="submit" value="검색">
				</form>
			</td>
		</tr>
		<c:forEach items="${bookList}" var="item">
			<tr>
				<td>도서명</td>
				<td>${item.bookName}</td>
			</tr>
			<tr>
				<td>저자</td>
				<td>${item.author}</td>
			</tr>
			<tr>
				<td>출판사</td>
				<td>${item.publisher}</td>
			</tr>
			<tr>
				<td>ISBN</td>
				<td>${item.isbn}</td>
			</tr>
			<tr>
				<td>출판일자</td>
				<td>${item.publishDate}</td>
			</tr>
			<tr>
				<td>도서 삭제하기</td>
				<td>
					<form action="/deleteBook">
					<input type="hidden" name="id" value="${item.id}">
					<input type="submit" value="삭제">
					</form>
				</td>
			</tr>
			<tr>
				<td>도서 정보 수정하기</td>
				<td>
					<form action="/updateBookPage" method="GET">
					<input type="hidden" name="id" value="${item.id}">
					<input type="submit" value="수정">
					</form>
				</td>
			</tr>
			<tr>
				<td bgcolor="black" height="2px" colspan=2></td>
			</tr>
		</c:forEach>
	</table>
	<form action="/MyPage">
		<input type="submit" value="마이페이지">
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