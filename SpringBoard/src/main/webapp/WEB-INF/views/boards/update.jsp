<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>${board.board_id}번 게시글 수정</title>
		<c:if test="${result == 0}">
			<script>
				alert("오류가 발생했습니다");
			</script>
		</c:if>
	</head>
	<body>
		<button onclick="location.href='./detail?board_id=${board.board_id}'">돌아가기</button>
		<hr />
		<h4>no. ${board.board_id}</h4>

		<form action="./update" method="post">
			<input name="board_id" type="hidden" value="${board.board_id}" />
			Title : <input name="board_title" type="text" value="${board.board_title}" /> <br />
			<br />
			<textarea name="board_content" cols="50" rows="20" style="resize: none">${board.board_content}</textarea>
			<br />
			<input type="submit" value="수정완료" />
		</form>
	</body>
</html>
