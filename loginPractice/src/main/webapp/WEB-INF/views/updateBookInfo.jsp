<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book Information</title>
</head>
<body>
	<form name="updateInfo" method="GET" action="/updateBookInfo">
 		<table>
			<tr>
				<td>도서명</td>
				<td><input type="text" name="bookName" value="${currentBookName}"></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><input type="text" name="author" value="${currentAuthor}"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="publisher" value="${currentPublisher}"></td>
			</tr>
			<tr>
				<td>ISBN</td>
				<td><input type="text" name="isbn" value="${currentIsbn}"></td>
			</tr>
			<tr>
				<td>출판일자</td>
				<td><input type="date" name="publishDate"
					value="${currentPublishDate}"></td>
			</tr>
		</table>
		<input type="hidden" name="id" value="${currentId}">
		<input type="submit" value="수정하기">
	</form>
</body>
</html>