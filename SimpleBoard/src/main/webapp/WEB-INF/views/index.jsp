<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<HTML>
<body>
	<table>
		<tr>
			<td>작성번호</td>
			<td>ID</td>
			<td>작성자</td>
			<td>내용</td>
		</tr>
		<c:forEach items="${boardList}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.userId}</td>
				<td>${item.name}</td>
				<td>${item.content}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan=3>
				<form method="POST" action="/addBoard">
					<table>
						<tr>
							<td>작성자 <input type="text" name="name"></td>
							<br>
						</tr>
						<tr>
							<td>내용 <input type="text" name="content"></td>
							<br>
						</tr>
						<tr>
							<td>ID <input type="text" name="userId"></td>
							<td>비밀번호 <input type="password" name="password"></td>
						</tr>
					</table>
					<input type="submit" value="입력">
				</form>
			</td>
		</tr>
	</table>
</body>
</HTML>