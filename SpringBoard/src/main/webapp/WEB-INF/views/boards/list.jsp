<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>게시판</title>
		<c:if test="${param.result == 1}">
			<script>
				alert("작성 완료!");
				location.href = "./list";
			</script>
		</c:if>
	</head>
	<body>
		<h1>게시판</h1>

		<button onclick="location.href='./write'">게시글 쓰기</button>
		<hr />
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>댓글</th>
			</tr>
			<c:forEach items="${boards}" var="board">
				<tr>
					<td>${board.board_id}</td>
					<td><a href="./detail?board_id=${board.board_id}">${board.board_title}</a></td>
					<td>${board.board_writer}</td>
					<td>${board.view_count}</td>
					<td>${replySizes.get(board.board_id)}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
